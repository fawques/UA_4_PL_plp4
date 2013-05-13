grammar plp4;

/* Traduce con ANTLR un fichero de expresiones infijas separadas por punto 
   y coma a notación prefija. Usa una gramática EBNF.
*/ 

@header {
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.lang.String;
	import java.lang.Math;
}

@rulecatch {
	catch (RecognitionException re) {
		reportError(re);
		System.exit(1);
	}catch (Exception e) {
//		e.printStackTrace();
		System.err.println(e);
		System.exit(1);
	}
}

 

    @lexer::members {

      public void emitErrorMessage(String msg) {

        System.err.println(msg);

        System.exit(1);

      }

    }



@parser::members {
	ArrayList<tablaSimbolos> listatS = new ArrayList<tablaSimbolos>();
	tablaSimbolos tS = null;
	tablaSimbolos tSGlobal = null;
	tablaSimbolos tSClase = null;
	tablaSimbolos tSMetodo = null;

	HashMap<String,tablaSimbolos> conjClases = new HashMap<String,tablaSimbolos>();
	
	String claseActual = "";
	boolean estoyEnMain = false;

	int numEtiqueta = 0;
	int numVariable = 1;
	int numCampo = 0;
	int numArg = 1;
	public void emitErrorMessage(String msg) {
		System.err.println(msg);
		System.exit(1);
	}
}

/* Analizador sintáctico: */
s[String archivo] returns [String resultado]
	:	{
			tS = tSGlobal = new tablaSimbolos(); 
			listatS.add(tSGlobal);
			$resultado = ".assembly extern mscorlib {}\n" + ".assembly '" + $archivo + "' {}\n";
		}
		(clase
		{
			$resultado += $clase.trad + "\n";
		}
		)+;

clase returns [String trad]
	:	CLASS ID LLAVEI 
		{
			boolean constrDefecto = false;
			$trad=".class '" + $ID.text + "' extends [mscorlib]System.Object \n{\n";
			numCampo = 0;
			claseActual = $ID.text;
			tS.add(claseActual, new Tipo(TipoLiteral.clase), 0, Visibilidad.publico, TipoSimbolo.clase);
			tS = tSClase = new tablaSimbolos(tSGlobal,claseActual);
			tS.add(claseActual, new Tipo(TipoLiteral.clase),0,Visibilidad.publico, TipoSimbolo.constructor);
			conjClases.put(claseActual,tSClase);
		}
		(miembro 
		{
			$trad+=$miembro.trad + "\n";
			if($miembro.constrDefecto == true)
				constrDefecto = true;
		}
		)+ LLAVED 
		{
			if(!constrDefecto){
				$trad += ".method public specialname rtspecialname instance void .ctor() cil managed\n{\n";
				//TODO: añadir la inicialización de los campos de la clase
				$trad += ".maxstack 1\nldarg 0\ncall instance void [mscorlib]System.Object::.ctor()\nret\n";
				$trad += "}\n";
			}
			$trad +="}";
			tS=tS.pop();
		};

miembro returns [String trad, boolean constrDefecto]
	:	campo {$trad = $campo.trad;$constrDefecto = false;}
	|	metodo {$trad = $metodo.trad;$constrDefecto = $metodo.constrDefecto;};
campo returns [String trad]
	:	visibilidad decl[$visibilidad.vis] {$trad = $decl.trad;}; 

visibilidad returns [Visibilidad vis]
	:	PRIVATE {$vis = Visibilidad.privado;}
	|	PUBLIC {$vis = Visibilidad.publico;};

// ==================================================================================================================================================================================================================================================================================================================================================================================================================================  MAXSTACK  ================================================================================================================================================================================================================================================================================================================================================================================================================================================= //

metodo returns [String trad,boolean constrDefecto]
@init{
		numVariable = 1;
		numArg = 1;
		$constrDefecto = false;
		tS = tSMetodo = new tablaSimbolos(tSClase);
	}
	:	{
			estoyEnMain = true;			
		}
		PUBLIC STATIC VOID MAIN PARI PARD bloque[-1, -1,true]
		{
			$trad = ".method static public void main () cil managed \n{\n.entrypoint\n.maxstack 1000"/*+$bloque.maxstack*/+"\n.locals(int32)\n"+$bloque.trad+"\n ret\n}";
			tS = tS.pop();
			estoyEnMain = false;
		}
	|	PUBLIC 
		{
			boolean constructor = false;
			$trad = ".method public ";
			TipoLiteral tipo = null;
		}
		(tipoSimple
		{
			tipo = $tipoSimple.trad;
		}
		)? ID PARI args PARD
		{
			if($ID.text.equals(claseActual)){
				constructor = true;
			}
			if(!constructor){
				if(tipo == null){
					throw new Error_32($ID.line,$ID.pos);
				}
				$trad += tipo + "  " + $ID.text ;
				tSClase.add($ID.text, new Tipo(tipo,$args.dimension), 0, Visibilidad.publico, TipoSimbolo.metodo);
			}else{
				if(tipo != null){
					throw new Error_31($ID.line,$ID.pos);
				}
				$trad += "specialname rtspecialname instance void .ctor";
				if($args.dimension != 0){
					tSClase.add($ID.text, new Tipo(TipoLiteral.clase),0,Visibilidad.publico, TipoSimbolo.constructor);
				}else{
					$constrDefecto = true;
				}
			}
		}
		bloque[-1,-1,true]
		{
			$trad += "(" + $args.trad + ")" +  " cil managed \n{\n.maxstack 1000"/*+$bloque.maxstack*/+"\n.locals(int32)\n"+$bloque.trad;
			if(tipo == null){
				$trad += "ldarg 0\ncall instance void [mscorlib]System.Object::.ctor()";
			}
			$trad += "\n ret\n}";
			tS = tS.pop();
		};

// ==================================================================================================================================================================================================================================================================================================================================================================================================================================  MAXSTACK  ================================================================================================================================================================================================================================================================================================================================================================================================================================================= //

tipoSimple returns [TipoLiteral trad, int line, int pos]
	:	INT {$trad = TipoLiteral.convertir("int32");$line = $INT.line; $pos = $INT.pos;}
	|	DOUBLE {$trad = TipoLiteral.convertir("float64");$line = $DOUBLE.line; $pos = $DOUBLE.pos;}
	|	BOOL {$trad=TipoLiteral.convertir("bool");$line = $BOOL.line; $pos = $BOOL.pos;};
	
// Cambiamos la gramática de tipo a tipopl para no colisionar con la clase Tipo que ya teníamos
tipopl returns [TipoLiteral trad, int line, int pos, String ident]
	:	ID {$trad = TipoLiteral.clase; $ident = $ID.text; $line = $ID.line; $pos = $ID.pos;}
	|	tipoSimple {$trad = $tipoSimple.trad; $ident = ""; $line = $tipoSimple.line; $pos = $tipoSimple.pos;};


decl[Visibilidad vis] returns [String trad]
	:	tipopl primervarid = varid[$tipopl.trad,vis,$tipopl.ident]
		{
			String tipo = $primervarid.resultado.toString();
			$trad = "";
			if(vis == Visibilidad.none)
			{
				if($primervarid.resultado.getTipo() == TipoLiteral.clase){
					tipo = $tipopl.ident;
				}

				$trad += ".locals(" + tipo + " '" + $primervarid.ident + "'";
			}
			else{
				if($primervarid.resultado.getTipo() == TipoLiteral.clase){
					tipo = $tipopl.ident;
				}
				
				$trad += ".field " + vis + " " + tipo + " '" + $primervarid.ident + "'\n";
			}
			
		}
		(COMA nuevovarid = varid[$tipopl.trad,vis,$tipopl.ident]
		{
			tipo = $nuevovarid.resultado.toString();
			if($primervarid.resultado.getTipo() == TipoLiteral.clase){
				tipo = $tipopl.ident;
			}
			if(vis == Visibilidad.none)
				$trad+=", " + tipo;
			else{
				if($nuevovarid.resultado.getTipo() == TipoLiteral.clase){
					tipo = $tipopl.ident;
				}
				$trad += ".field " + vis + " " + tipo + " '" + $nuevovarid.ident + "'\n";
			}
		}
		)* PYC
		{
			if(vis == Visibilidad.none)
				$trad += ")";
			$trad += "\n";
		};	
	
varid[TipoLiteral tipo,Visibilidad vis,String nombreClase] returns [Tipo resultado, String ident]
	:	ID 
		{
			$resultado = new Tipo($tipo);
			$ident = $ID.text;
		} 
		(CORI 
		{
			$resultado = new Tipo($tipo,$resultado);
		}
		(COMA
		{
			$resultado = new Tipo($tipo,$resultado);
		}
		)* CORD)?
		{
			if(vis == Visibilidad.none){
				try{
					Simbolo nuevo;
					if($tipo == TipoLiteral.clase){
						nuevo = new Simbolo($ID.text,numVariable,$resultado,vis,TipoSimbolo.local,$nombreClase);
					}else{
						nuevo = new Simbolo($ID.text,numVariable,$resultado,vis,TipoSimbolo.local);
					}
					tS.add(nuevo);
					numVariable++;
				}catch(Error_1 ex){
					ex.setFilaColumna($ID.line,$ID.pos);
					throw ex;
				}
			}else{
				try{
					Simbolo nuevo = new Simbolo($ID.text,numCampo,$resultado,vis,TipoSimbolo.campo,tSClase.getNombre());
					tS.add(nuevo);
					numCampo++;
				}catch(Error_1 ex){
					ex.setFilaColumna($ID.line,$ID.pos);
					throw ex;
				}
			}
		};

declins[int etiquetaBreakBucle, int etiquetaContinueBucle] returns [String trad, int maxstack]
	:	{
			$trad = "";
			$maxstack = 0;
		}
		(instr[$etiquetaBreakBucle, $etiquetaContinueBucle,true] 
		{
			$trad += $instr.trad;
			$maxstack = Math.max($maxstack,$instr.maxstack);
		}
		| decl[Visibilidad.none]
		{
			$trad += $decl.trad;
		})*;

bloque[int etiquetaBreakBucle, int etiquetaContinueBucle, boolean creaAmbito] returns [String trad, int maxstack]
	:	{
			if($creaAmbito){
				tS = new tablaSimbolos(tS);
			}
		}
		LLAVEI declins[$etiquetaBreakBucle, $etiquetaContinueBucle] LLAVED
		{
			$trad = $declins.trad;
			$maxstack = $declins.maxstack;
			if($creaAmbito){
				tS = tS.pop();
			}
		};

instr[int etiquetaBreakBucle, int etiquetaContinueBucle, boolean creaAmbito] returns [String trad, int maxstack]
@init{
		int etiqFin = -1;
		int etiqIni = -1;
		int etiqContinue = -1;
	}
	:	bloque[$etiquetaBreakBucle, $etiquetaContinueBucle, $creaAmbito]{$trad = $bloque.trad;$maxstack = $bloque.maxstack;}
	|	IF PARI expr 
		{
			int etiqElse = -1;
			//int etiqFin = -1;
			if($expr.tipo == TipoLiteral.bool){
				etiqFin = numEtiqueta;
				numEtiqueta++;
				etiqElse = numEtiqueta;
				numEtiqueta++;
				$trad = $expr.trad + "ldc.i4 0\n" + "beq et" + etiqElse + "\n";
				// como expr siempre tiene que dejar al menos un elemento en la pila, max(expr.maxstack,1) da expr seguro
				$maxstack = $expr.maxstack;
			}else{
				throw new Error_5($IF.text,$IF.line,$IF.pos);
			}
			
		}
		PARD insif=instr[$etiquetaBreakBucle,$etiquetaContinueBucle,true]
		{
			$trad += $insif.trad + "br et"+etiqFin + "\n";
			$trad += "et" + etiqElse + ": ";
			$maxstack = Math.max($insif.maxstack,$maxstack);
		}
		(ELSE inselse=instr[$etiquetaBreakBucle,$etiquetaContinueBucle,true]
		{
			$trad += $inselse.trad;
			$maxstack = Math.max($inselse.maxstack,$maxstack);
		}
		)?{$trad += "et" + etiqFin + ": ";}
	|	WHILE PARI expr
		{
			if($expr.tipo == TipoLiteral.bool){
				etiqIni = numEtiqueta;
				numEtiqueta++;
				etiqFin = numEtiqueta;
				numEtiqueta++;
			}else{
				throw new Error_5($WHILE.text,$WHILE.line,$WHILE.pos);
			}
		}
		PARD contenido=instr[etiqFin,etiqIni,true]
		{
				$trad = "et" + etiqIni + ": " + $expr.trad + "ldc.i4 0\n" + "beq et" + etiqFin + "\n";
				$trad += $contenido.trad + "br et" + etiqIni + "\n" + "et" + etiqFin + ": ";
				$maxstack = Math.max($expr.maxstack,$contenido.maxstack);
			
		}
	|	FOREACH PARI VAR iterador=ID IN idArray=ID
		{
			Simbolo array = tS.getSimbolo($idArray.text);
			int iteradorInt = -1;
			if(array.esArray()){
				tS = new tablaSimbolos(tS);
				TipoLiteral tFinal = array.getTipoFinal();
				$trad = ".locals(" + tFinal + ", int32)\n";
				Tipo tipoIterador = new Tipo(tFinal,true);
				int posicion = numVariable;

				tS.add($iterador.text,tipoIterador,numVariable,Visibilidad.publico, TipoSimbolo.local);
				numVariable++;
				iteradorInt = numVariable;
				numVariable++;

				etiqIni = numEtiqueta;
				numEtiqueta++;

				etiqFin = numEtiqueta;
				numEtiqueta++;

				etiqContinue = numEtiqueta;
				numEtiqueta++;

				$trad += "ldc.i4 0\n" + "stloc " + iteradorInt + "\n";
				$trad += "et" + etiqIni + ": ";
				$trad += "ldloc " + iteradorInt + "\n" + "ldc.i4 " + (array.getDimension()-1) + "\n" + "bgt et" + etiqFin + "\n";
				$trad += "ldloc " + array.posicion_locals + "\n";
				$trad += "ldloc " + iteradorInt + "\n" + "ldelem.";
				if(tipoIterador.tipo == TipoLiteral.int32 || tipoIterador.tipo == TipoLiteral.bool){
					$trad += "i4\n";	
				}else{
					$trad += "r8\n";
				}
				$trad += "stloc " + posicion + "\n"; // y lo guardamos en el iterador
				$maxstack = 2;

			}else{
				throw new Error_11($idArray.text,$idArray.line,$idArray.pos);
			}
		}
		PARD contenido=instr[etiqFin,etiqContinue,false]
		{
			$trad += $contenido.trad;
			$trad += "et" + etiqContinue + ": ldloc " + iteradorInt + "\n" + "ldc.i4 1\n" + "add\n" + "stloc " + iteradorInt + "\n" + "br et" + etiqIni + "\n";
			$trad += "et" + etiqFin + ": ";
			tS = tS.pop();
			$maxstack = Math.max($contenido.maxstack, $maxstack);
		}
	|	FOR PARI INT ID ASIG inicializacion=expr
		{
			tS = new tablaSimbolos(tS);
			$trad = ".locals(int32)\n";
			Tipo tipoIterador = new Tipo(TipoLiteral.int32, true);
			int posicion =numVariable;
			tS.add($ID.text,tipoIterador,numVariable,Visibilidad.publico, TipoSimbolo.local);
				numVariable++;
			$trad += $inicializacion.trad;
			if($inicializacion.tipo == TipoLiteral.float64)
				$trad += "conv.i4\n";
			$trad += "stloc " + posicion + "\n";
			$maxstack = $inicializacion.maxstack;
			
		}
		TO limite=expr
		{
			$trad += ".locals(int32)\n" + $limite.trad;
			numVariable++;
			if($limite.tipo == TipoLiteral.float64){
				$trad+= "conv.i4\n";
			}else if($limite.tipo == TipoLiteral.bool){
				throw new Error_17($TO.line,$TO.pos);
			}
			$trad += "stloc " + (posicion+1) + "\n";
			etiqIni = numEtiqueta;
			numEtiqueta++;
			etiqFin = numEtiqueta;
			numEtiqueta++;
			etiqContinue = numEtiqueta;
			numEtiqueta++;

			$maxstack = Math.max($limite.maxstack,$maxstack);

		}
		STEP (ADDOP)? ENTERO PARD contenido=instr[etiqFin,etiqContinue,false]
		{
			$trad+= "et" + etiqIni + ": " + "ldloc " + posicion + "\n" + "ldloc " + (posicion+1) + "\n";
			if($ADDOP == null || $ADDOP.text.equals("+")){
				$trad += "bgt et" + etiqFin + "\n";
			}else{
				$trad += "blt et" + etiqFin + "\n";			
			}
			 
			$trad+= $contenido.trad;

			
			
			$trad += "et" + etiqContinue + ": ldloc " + posicion + "\n" + "ldc.i4 " + $ENTERO.text + "\n";
			
			if($ADDOP == null || $ADDOP.text.equals("+")){
				$trad += "add\n";
			}else{
				$trad += "sub\n";
			}
			$trad += "stloc " + posicion + "\n";
			
			
			$trad += "br et" + etiqIni + "\n" + "et" + etiqFin + ": ";
			tS = tS.pop();
			$maxstack = Math.max(2,Math.max($contenido.maxstack,$maxstack));
		}
	|	BREAK PYC
		{
			if($etiquetaBreakBucle != -1){
				$trad = "br et" + $etiquetaBreakBucle + "\n";
			}else{
				throw new Error_16($BREAK.text,$BREAK.line,$BREAK.pos);
			}
			$maxstack = 0;
		}
	|	CONTINUE PYC{
			if($etiquetaContinueBucle != -1){
				$trad = "br et"+$etiquetaContinueBucle + "\n";
			}else{
				throw new Error_16($CONTINUE.text,$CONTINUE.line,$CONTINUE.pos);
			}
			$maxstack = 0;
		}
	|	ref cambio[$ref.simbolo,$ref.tipoFinal]
		{
			$trad = $ref.prefijo + $cambio.trad + "st" + $ref.sufijo;
			/* //$maxstack = Math.max(ref.maxstack,$cambio.maxstack);*/
		}
	|	ID 
		{
			Simbolo simb = tS.getSimbolo($ID.text);
			TipoLiteral tipo_final_simbolo = simb.getTipoFinal();
			Tipo tipoCompleto = simb.getTipo();
			TipoSimbolo tipo_simbolo = simb.getTipoSimbolo();
			$trad = "";
			if(tipo_simbolo == TipoSimbolo.campo && !estoyEnMain){
				$trad = "ldarg 0\n";
			}
			if(!simb.esArray()){
				throw new Error_11($ID.text,$ID.line,$ID.pos);
			}
		}
		ASIG NEW tipoSimple 
		{
			if(tipo_final_simbolo != $tipoSimple.trad){
				String lexema;
				if($tipoSimple.trad == TipoLiteral.int32){
					lexema = "int";
				}else if($tipoSimple.trad == TipoLiteral.float64){
					lexema = "double";
				}else{
					lexema = "bool";
				}
				throw new Error_14(lexema,$tipoSimple.line, $tipoSimple.pos);
			}
			
			
		}
		 CORI dims[tipoCompleto] CORD
		 {
		 	if($dims.tipoFinal.esArray()){
		 		throw new Error_10( $CORD.line,$CORD.pos);
		 	}
		 }
		 PYC
		 {
		 	String auxTipo;
		 	$trad += "ldc.i4 " + $dims.dimension + "\n";
		 	if($tipoSimple.trad == TipoLiteral.int32 || $tipoSimple.trad == TipoLiteral.bool){
		 		auxTipo = "[mscorlib]System.Int32";
		 	}else{
		 		auxTipo = "[mscorlib]System.Double";
		 	}
		 	$trad +="newarr " + auxTipo + "\n";
		 	if(tipo_simbolo == TipoSimbolo.local){
				$trad = "stloc " + simb.posicion_locals + "\n";
			}else if(tipo_simbolo == TipoSimbolo.campo){
				$trad += "stfld " + simb.getTipo() + " '" + tS.getNombre() + "'::'" + simb.getNombre() + "'\n";
			}
		 	$maxstack = 1;
		 }
	|	WRITELINE PARI expr PARD PYC{
			$trad = $expr.trad;
			$trad += "call void [mscorlib]System.Console::WriteLine(" + $expr.tipo + ")\n";
			$maxstack = $expr.maxstack;
		}
	|	RETURN expr PYC
	|	variable=ID ASIG NEW tipoClase=ID params 
		{
			$trad = "";
			Simbolo simb = tS.getSimbolo($variable.text);
			if(simb.getTipoSimbolo() == TipoSimbolo.campo && !estoyEnMain){
				$trad = "ldarg 0\n";
			}/*else if(simb.getTipoSimbolo() == TipoSimbolo.campo && estoyEnMain){
				throw new Error_27($variable.text,$variable.line,$variable.pos);
			}*/
			$trad += $params.trad;
			$trad += "newobj instance void '" + $tipoClase.text + "'::.ctor(";
			if($params.dimension > 0){
				$trad += "float64";
			}
			for(int i = 1; i < $params.dimension;i++){
				$trad += ",float64";
			}
			$trad += ")\n";

			
			if(simb.getTipoSimbolo() == TipoSimbolo.local){
				$trad += "stloc " + simb.posicion_locals + "\n";
			}else if(simb.getTipoSimbolo() == TipoSimbolo.campo){
				$trad += "stfld '" + $tipoClase.text + "' '" + $tipoClase.text + "'::'" + $variable.text + "'\n";
			}
		}
		PYC
	|	subref params PYC;

dims[Tipo tipo] returns [int dimension, Tipo tipoFinal]
	:	primero=ENTERO
		{
			try{
				$tipo.setDimension($primero.text);
				$dimension = $tipo.getDimension();
				$tipo = $tipo.getTipoBase();
			}catch(Error_8 e){
				e.fila = $primero.line;
				e.columna = $primero.pos;
				throw e;
			}
		}
		 (COMA siguiente=ENTERO
		 {
		 	if($tipo.esArray()){
		 		try{
					$tipo.setDimension($siguiente.text);
					$dimension *= $tipo.getDimension();
					$tipo = $tipo.getTipoBase();
				}catch(Error_8 e){
					e.fila = $siguiente.line;
					e.columna = $siguiente.pos;
					throw e;
				}
			}else{
				throw new Error_10($COMA.line,$COMA.pos);
			}
		}
		)*
		{$tipoFinal = $tipo;};
cambio[Simbolo elemento, TipoLiteral tipo] returns [String trad, int maxstack]
	:	ASIG expr PYC
		{
			
			if($elemento.esIndice()){
				throw new Error_15($ASIG.line,$ASIG.pos);
			}
			String expresion = "";
			TipoLiteral tipoExpr = $expr.tipo;
			if($tipo != tipoExpr){
				if($tipo == TipoLiteral.int32){
					if(tipoExpr == TipoLiteral.float64){
						expresion += "conv.i4\n";
						tipoExpr = TipoLiteral.int32;
					}else{
						throw new Error_6($ASIG.line,$ASIG.pos);
					}
				}else if($tipo == TipoLiteral.bool){
					throw new Error_6($ASIG.line,$ASIG.pos);
				}else if($tipo == TipoLiteral.float64){
					if(tipoExpr == TipoLiteral.int32){
						expresion += "conv.r8\n";
						tipoExpr = TipoLiteral.float64;
					}else{
						throw new Error_6($ASIG.line,$ASIG.pos);
					}
				}
			}
			$trad = $expr.trad + expresion;
		}
	|	PUNTO READLINEI PYC
		{
			if($elemento.esIndice()){
				throw new Error_15($READLINEI.line,$READLINEI.pos);
			}
			if($tipo == TipoLiteral.int32){
				$trad = "call string [mscorlib]System.Console::ReadLine()\n" + "call int32 [mscorlib]System.Int32::Parse(string)\n";
			}
			else
				throw new Error_7($READLINEI.line,$READLINEI.pos);
		}
	|	PUNTO READLINED PYC
		{
			if($elemento.esIndice()){
				throw new Error_15($READLINED.line,$READLINED.pos);
			}
			if($tipo == TipoLiteral.float64){
				$trad = "call string [mscorlib]System.Console::ReadLine()\n" + "call float64 [mscorlib]System.Double::Parse(string)\n";
				$maxstack = 1;
			}
			else
				throw new Error_7($READLINED.line,$READLINED.pos);
		}
	|	PUNTO READLINEB PYC
		{
			if($elemento.esIndice()){
				throw new Error_15($READLINEB.line,$READLINEB.pos);
			}
			if($tipo == TipoLiteral.bool){
				$trad = "call string [mscorlib]System.Console::ReadLine()\n" + "call bool [mscorlib]System.Boolean::Parse(string)\n";
				$maxstack = 1;
			}
			else
				throw new Error_7($READLINEB.line,$READLINEB.pos);
		}
		;

expr returns [String trad, TipoLiteral tipo, int maxstack]
	:	primero = eand 
		{
			$trad = $primero.trad; 
			$tipo = $primero.tipo;
			$maxstack = $primero.maxstack;
		}
		(OR 
		{
			if($tipo != TipoLiteral.bool){
				throw new  Error_4($OR.text,$OR.line,$OR.pos);
			}
		}
		siguiente = eand
		{
			$trad += $siguiente.trad;
			if($siguiente.tipo != TipoLiteral.bool || $tipo != TipoLiteral.bool){
				throw new  Error_4($OR.text,$OR.line,$OR.pos);
			}
			$tipo = TipoLiteral.bool;
			$trad += "or\n";
			$maxstack = Math.max($siguiente.maxstack+1,$maxstack);
		}
		)*;

eand returns [String trad, TipoLiteral tipo, int maxstack]
	:	primero = erel 
		{
			$trad = $primero.trad; 
			$tipo = $primero.tipo;
			$maxstack = $primero.maxstack;
		}
		(AND
		{
			if($tipo != TipoLiteral.bool){
				throw new  Error_4($AND.text,$AND.line,$AND.pos);
			}
		}
		siguiente = erel
		{
			$trad += $siguiente.trad;
			
			if($siguiente.tipo != TipoLiteral.bool){
				throw new  Error_4($AND.text,$AND.line,$AND.pos);
			}
			$tipo = TipoLiteral.bool;
			$trad += "and\n";
			$maxstack = Math.max($siguiente.maxstack+1,$maxstack);
		}
		)*;


esum returns [String trad, TipoLiteral tipo, int maxstack]
	:	primero = term {
			$trad = $primero.trad; 
			$tipo = $primero.tipo;
			$maxstack = $primero.maxstack;
		}
		(ADDOP 
		{
			if($tipo == TipoLiteral.bool){
				throw new  Error_3($ADDOP.text,$ADDOP.line,$ADDOP.pos);
			}
		}
		siguiente = term
		{
			if($siguiente.tipo == TipoLiteral.bool|| $tipo == TipoLiteral.bool){
				throw new  Error_3($ADDOP.text,$ADDOP.line,$ADDOP.pos);
			}
			boolean convertirSiguiente = false;
			if ($tipo == TipoLiteral.int32 && $siguiente.tipo == TipoLiteral.int32) {
				$tipo = TipoLiteral.int32;
			} else if ($tipo == TipoLiteral.int32) { // $siguiente.tipo == TipoLiteral.float64
				$trad += "conv.r8\n";
				$tipo = TipoLiteral.float64;
			} else if ($siguiente.tipo == TipoLiteral.int32) { // $primero.tipo == TipoLiteral.float64
				convertirSiguiente = true;
				$tipo = TipoLiteral.float64;
			} else { // $siguiente.tipo == TipoLiteral.float64 && $primero.tipo == TipoLiteral.float64
				$tipo = TipoLiteral.float64;
			}

			$trad += $siguiente.trad;
			if(convertirSiguiente){
				$trad+= "conv.r8\n";
			}
			if($ADDOP.text.equals("+")){
			    $trad += "add\n";
			}else{
			    $trad += "sub\n";
			}
			$maxstack = Math.max($siguiente.maxstack+1,$maxstack);
		})*;
erel returns [String trad, TipoLiteral tipo, int maxstack]
	:	primero = esum 
		{
			$trad = $primero.trad; 
			$tipo = $primero.tipo;
			$maxstack = $primero.maxstack;
		}
		(RELOP siguiente = esum
		{
			boolean convertirSiguiente = false;
			if (($tipo == TipoLiteral.int32 || $tipo == TipoLiteral.bool) && ($siguiente.tipo == TipoLiteral.int32 || $siguiente.tipo == TipoLiteral.bool)) {
			} else if ($tipo == TipoLiteral.int32 || $tipo == TipoLiteral.bool) { // $siguiente.tipo == TipoLiteral.float64
				$trad += "conv.r8\n";
			} else if ($siguiente.tipo == TipoLiteral.int32 || $siguiente.tipo == TipoLiteral.bool) { // $primero.tipo == TipoLiteral.float64
				convertirSiguiente = true;
			}

			$trad += $siguiente.trad;
			if(convertirSiguiente){
				$trad+= "conv.r8\n";
			}
			$tipo = TipoLiteral.bool;
			
			if($RELOP.text.equals("==")){
			    $trad += "ceq\n";
			}else if($RELOP.text.equals("!=")){
			    $trad += "ceq\n" + "ldc.i4 1\n" + "xor\n";
			}else if($RELOP.text.equals("<")){
			    $trad += "clt\n";
			}else if($RELOP.text.equals(">")){
			    $trad += "cgt\n";
			}else if($RELOP.text.equals("<=")){
			    $trad += "cgt\n" + "ldc.i4 1\n" + "xor\n";
			}else if($RELOP.text.equals(">=")){
			    $trad += "clt\n" + "ldc.i4 1\n" + "xor\n";	
			}
			$maxstack = Math.max($siguiente.maxstack +1,$maxstack);
			
			
		})*;



term returns [String trad, TipoLiteral tipo, int maxstack]
	:	primero = factor 
		{
			$trad = $primero.trad; 
			$tipo = $primero.tipo;
			$maxstack = $primero.maxstack;
		}
		(MULOP
		{
			if($tipo == TipoLiteral.bool){
				throw new  Error_3($MULOP.text,$MULOP.line,$MULOP.pos);
			}
		}
		siguiente = factor
		{
			if($siguiente.tipo == TipoLiteral.bool){
				throw new  Error_3($MULOP.text,$MULOP.line,$MULOP.pos);
			}
			boolean convertirSiguiente = false;
			if ($tipo == TipoLiteral.int32 && $siguiente.tipo == TipoLiteral.int32) {
				$tipo = TipoLiteral.int32;
			} else if ($tipo == TipoLiteral.int32) { // $siguiente.tipo == TipoLiteral.float64
				$trad += "conv.r8\n";
				$tipo = TipoLiteral.float64;
			} else if ($siguiente.tipo == TipoLiteral.int32) { // $primero.tipo == TipoLiteral.float64
				convertirSiguiente = true;
				$tipo = TipoLiteral.float64;
			} else { // $siguiente.tipo == TipoLiteral.float64 && $primero.tipo == TipoLiteral.float64
				$tipo = TipoLiteral.float64;
			}
			$trad += $siguiente.trad;
			if(convertirSiguiente){
				$trad+= "conv.r8\n";
			}
			
			if($MULOP.text.equals("*")){
			    $trad += "mul\n";
			}else{
			    $trad += "div\n"; 
			}
			$maxstack = Math.max($siguiente.maxstack+1,$maxstack);
		})*;

factor returns [String trad, TipoLiteral tipo, int maxstack]
	:	base{$trad = $base.trad; $tipo = $base.tipo;$maxstack = $base.maxstack;}
	|	NOT otro = factor{if($otro.tipo == TipoLiteral.bool){
				$trad = $otro.trad  + "ldc.i4 1\n" + "xor\n";
				$tipo = TipoLiteral.bool;
				$maxstack = Math.max($otro.maxstack,2);
			}else{
				throw new  Error_4($NOT.text,$NOT.line,$NOT.pos);
			}}
	|	PARI ADDOP otro = factor PARD
		{
			if($ADDOP.text.equals("-")){
				if($otro.tipo == TipoLiteral.bool){
					throw new  Error_3($ADDOP.text,$ADDOP.line,$ADDOP.pos);
				}else{
					$trad = $otro.trad + "neg\n";
				}
			}else{
				if($otro.tipo == TipoLiteral.bool){
					throw new  Error_3($ADDOP.text,$ADDOP.line,$ADDOP.pos);
				}else{
					$trad = $otro.trad;
				}	
			}
			$tipo = $otro.tipo;
			$maxstack = $otro.maxstack;
		};

base returns [String trad, TipoLiteral tipo, int maxstack]
	:	ENTERO{$trad = "ldc.i4 " + $ENTERO.text + "\n"; $tipo = TipoLiteral.int32;$maxstack = 1;}
	|	REAL
		{
			/*StringBuilder numeroReal = new StringBuilder($REAL.text);
			numeroReal.setCharAt(numeroReal.indexOf("."), ',');*/
			$trad ="ldc.r8 " + $REAL.text + "\n"; $tipo = TipoLiteral.float64;$maxstack = 1;
		}
	|	BOOLEANO{if($BOOLEANO.text.equals("True")){
				$trad = "ldc.i4 1\n";
			}else{
				$trad = "ldc.i4 0\n";
			} 
			$tipo = TipoLiteral.bool;$maxstack = 1;}
	|	PARI expr PARD{$trad = $expr.trad; $tipo = $expr.tipo;$maxstack = $expr.maxstack;}
	|	ref 
		{
			$trad = $ref.prefijo + "ld" + $ref.sufijo;
			$tipo = $ref.tipoFinal;
			/*$trad = DOLARref.trad;
			$tipo = DOLARref.tipo;
			//$maxstack = ref.maxstack + 1;*/
		}
	|	subref params;

ref returns [String prefijo, String sufijo, Simbolo simbolo, TipoLiteral tipoFinal]
	:	subref
		{
			//try{
			    Simbolo referencia = $subref.simboloFinal;
			    
				
			//}catch(Error_2 e){
			//    e.setFilaColumna($subref.id.getLine(),$subref.id.getCharPositionInLine());
			//    throw e;
			//}
			$prefijo = $subref.prefijo;
			$sufijo = $subref.sufijo;
			$simbolo = $subref.simboloFinal;
			$tipoFinal = $simbolo.tipo.getTipo();
		} 
		/*$variable= $referencia.posicion_locals; 
			    $tipo = $referencia.tipo.getTipo();
			    $tipo_simbolo = $referencia.getTipoSimbolo();
			    $nombre = $referencia.getNombre();
			    $trad = $subref.trad;
			    $array_pasado = "";
			    $getDato = "";
			    $indice = $referencia.tipo.isIndice();
			    $maxstack = 0;*/
		(CORI indices[$subref.simboloFinal, $subref.id, $CORI] CORD
		{
			$prefijo += "ld" + $sufijo;
			$sufijo = "";
			$prefijo += $indices.trad;

			TipoLiteral tipo = referencia.tipo.getTipoFinal();
			if(tipo == TipoLiteral.int32 || tipo == TipoLiteral.bool){
				$sufijo += "elem.i4\n";	
			}else if(tipo == TipoLiteral.float64){
				$sufijo += "elem.r8\n";
			}
			$tipoFinal = tipo;
		}
		)?
		{
			if(referencia.esArray() && $sufijo.equals("")){
				throw new Error_9($subref.id.getText(),$subref.id.getLine(),$subref.id.getCharPositionInLine());
			}
		}
		;

indices[Simbolo elemento, Token id, Token cori] returns [String trad, int maxstack]
	:	primero=expr
		{
			$trad = $primero.trad;
			Tipo tipoElem = $elemento.tipo;
			if(!tipoElem.esArray()){
				throw new Error_11($id.getText(),$id.getLine(),$id.getCharPositionInLine());
			}
			if($primero.tipo == TipoLiteral.float64){
				$trad += "conv.i4\n";
			}else if($primero.tipo == TipoLiteral.bool){
				throw new Error_13($cori.getLine(),$cori .getCharPositionInLine());
			}
			
			int dimensionRestante = tipoElem.tipobase.getDimensionTotal();
			$trad += "ldc.i4 " + dimensionRestante + "\n" + "mul\n";		
			tipoElem = tipoElem.tipobase;
			$maxstack = $primero.maxstack + 1;
		}
		(COMA siguiente=expr
		{
			
			if(!tipoElem.esArray()){
				throw new Error_12($COMA.getLine(),$COMA.getCharPositionInLine());
			}else{
			 	$trad += $siguiente.trad;
				 	if($siguiente.tipo == TipoLiteral.float64){
					$trad += "conv.i4\n";
				}else if($siguiente.tipo == TipoLiteral.bool){
					throw new Error_13($COMA.line,$COMA.pos);
				}
				
				dimensionRestante = tipoElem.tipobase.getDimensionTotal();
				$trad += "ldc.i4 " + dimensionRestante + "\n" + "mul\n" + "add\n";
				tipoElem = tipoElem.tipobase;
			}
			$maxstack = Math.max($siguiente.maxstack + 2, $maxstack);
		}
		)*
		{
			if(tipoElem.esArray()){
				throw new Error_9($id.getText(),$id.getLine(),$id.getCharPositionInLine());
			}
		};

args returns[String trad, int dimension]
	:	{
			$dimension = 0;
			$trad = "";
		}
		(DOUBLE primerid=ID 
		{
			$trad += "float64 '" + $primerid.text + "'";
			$dimension ++;
			tS.add(new Simbolo($primerid.text, numArg, new Tipo(TipoLiteral.float64), Visibilidad.none, TipoSimbolo.argumento));
			numArg++;
		}
		(COMA DOUBLE nuevoid=ID
		{
			$trad += ", float64 '" + $nuevoid.text + "'";
			$dimension ++;
			tS.add(new Simbolo($nuevoid.text, numArg, new Tipo(TipoLiteral.float64), Visibilidad.none, TipoSimbolo.argumento));
			numArg++;
		}
		)*)?;

params returns[String trad,int dimension]
	:	PARI
		{
			$dimension = 0;
			$trad = "";
		}
		(primerexpr=expr
		{
			$trad += $primerexpr.trad;
			if($primerexpr.tipo == TipoLiteral.int32){
				$trad+="conv.r8\n";
			}else if($primerexpr.tipo == TipoLiteral.bool){
				throw new Error_24($PARI.line,$PARI.pos);
			}
			$dimension ++;
		}
		(COMA nuevoexpr=expr
		{
			$trad += $nuevoexpr.trad;
			if($nuevoexpr.tipo == TipoLiteral.int32){
				$trad+="conv.r8\n";
			}else if($nuevoexpr.tipo == TipoLiteral.bool){
				throw new Error_24($COMA.line,$COMA.pos);
			}
			$dimension ++;
		}
		)*)? PARD;

subref returns [String prefijo, String sufijo, Simbolo simboloFinal, Token id]
	:	primerid=ID
		{
			$prefijo = $sufijo = "";


			Simbolo simb = tS.getSimbolo($primerid.text);
			String trad = "";
			switch(simb.getTipoSimbolo()){
				case local:	trad = "loc " + simb.posicion_locals + "\n";
							break;
				case campo:	if(estoyEnMain){
								throw new Error_27($primerid.text,$primerid.line,$primerid.pos);
							}
							$prefijo += "ldarg 0\n";
							trad = "fld " + simb.tipo + " '" + simb.getNombreClase() + "'::'"+simb.getNombre() + "'\n";
							break;
				case argumento:	trad = "arg " + simb.posicion_locals + "\n";
								break;
			}
			$id = $primerid;
			

		}
		(PUNTO nuevoid=ID
		{
			Tipo tipoT = simb.getTipo();
			if(tipoT.getTipo() != TipoLiteral.clase){
				// algo habrá que devolver, que esto no debería estar bien...
				System.err.println("Has puesto subref con punto cuando no es un objeto");
			}

			trad = "ld" + trad;
			$prefijo += trad;
			trad = "";
			tablaSimbolos nuevotS = conjClases.get(simb.getNombreClase());
			simb = nuevotS.getSimbolo($nuevoid.text);
			String tipo;
			if(simb.getTipo().getTipo() == TipoLiteral.clase){
				tipo = simb.getNombreClase();
			}else{
				tipo = simb.getTipo().toString();
			}
			switch(simb.getTipoSimbolo()){
				case local:	trad = "loc " + simb.posicion_locals + "\n";
										break;
				case campo:	trad = "fld " + tipo + " '" + simb.getNombreClase() + "'::'"+simb.getNombre() + "'\n";
										break;
				case argumento:	trad = "arg " + simb.posicion_locals + "\n";
										break;
			}
			$id = $nuevoid;
		}
		)*
		{
			$sufijo = trad;
			$simboloFinal = simb;
		};

/* Analizador léxico: */


CLASS	:	'class';
VOID	:	'void';
MAIN	:	'Main';
INT	:	'int';
DOUBLE	:	'double';
BOOL	:	'bool';
PUBLIC	:	'public';
STATIC	:	'static';
IF	: 	'if';
ELSE	: 	'else';
FOREACH	:	'foreach';
VAR	: 	'var';
IN	: 	'in';
FOR	: 	'for';
TO	: 	'to';
STEP	: 	'step';
WHILE	:	'while';
BREAK	:	'break';
CONTINUE	:	'continue';
NEW	: 	'new';
WRITELINE	:	'System.Console.WriteLine';
READLINEI	: 	'int.Parse(System.Console.ReadLine())';
READLINED	: 	'double.Parse(System.Console.ReadLine())';
READLINEB	: 	'bool.Parse(System.Console.ReadLine())';
RETURN 		:	'return';
PRIVATE		:	'private';


LLAVEI	:	'{';
LLAVED	:	'}';
PARI	:	'(';
PARD	:	')';
CORI	:	'[';
CORD	:	']';
COMA	:	',';
PYC	:	';';
ASIG	:	'=';
OR	:	'|';
AND	:	'&';
RELOP	:	'==' | '!='|'<' | '>' | '<=' | '>=';
ADDOP	:	'+' | '-';
MULOP	:	'*' | '/';
NOT	:	'!';
PUNTO	:	'.';
ENTERO	:	('0'..'9')+ ;
REAL	:	('0'..'9')+'.'('0'..'9')+ ;
BOOLEANO	:	'True'|'False';
ID  	:	('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;



BLANCOS	:	('\t' | '\n' | '\r' | ' ')+ {skip();} ; 

COMENTARIO	:	'/*' (options { greedy = false;} : . )* '*/' {skip();}
		|	'//' (options { greedy = false;} : . )* '\n' {skip();};
 