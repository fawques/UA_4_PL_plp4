grammar plp3;

/* Traduce con ANTLR un fichero de expresiones infijas separadas por punto 
   y coma a notación prefija. Usa una gramática EBNF.
*/ 

@header {
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
	tablaSimbolos tS;
	int numEtiqueta = 0;
	int numVariable = 1;
	public void emitErrorMessage(String msg) {
		System.err.println(msg);
		System.exit(1);
	}
}

/* Analizador sintáctico: */
aAux returns [String resultado]
	:	{tS = new tablaSimbolos();}clase{$resultado = ".assembly extern mscorlib {}\n" + ".assembly 'aaa' {}\n" + $clase.trad;};

s[String archivo] returns [String resultado]
	:	{tS = new tablaSimbolos();}clase{$resultado = ".assembly extern mscorlib {}\n" + ".assembly '" + $archivo + "' {}\n" + $clase.trad;};

clase returns [String trad]
	:	CLASS SINGLE LLAVEI {$trad=".class 'Single' extends [mscorlib]System.Object \n{\n";} metodo {$trad+=$metodo.trad + "\n}";} LLAVED;

// ==================================================================================================================================================================================================================================================================================================================================================================================================================================  MAXSTACK  ================================================================================================================================================================================================================================================================================================================================================================================================================================================= //

metodo returns [String trad]
	:	PUBLIC STATIC VOID MAIN PARI PARD bloque[-1, -1,true]{$trad = ".method static public void main () cil managed \n{\n.entrypoint\n.maxstack 1000"/*+$bloque.maxstack*/+"\n.locals(int32)\n"+$bloque.trad+"\n ret\n}";};

// ==================================================================================================================================================================================================================================================================================================================================================================================================================================  MAXSTACK  ================================================================================================================================================================================================================================================================================================================================================================================================================================================= //

tipoSimple returns [String trad, int line, int pos]
	:	INT {$trad = "int32";$line = $INT.line; $pos = $INT.pos;}
	|	DOUBLE {$trad = "float64";$line = $DOUBLE.line; $pos = $DOUBLE.pos;}
	|	BOOL {$trad="bool";$line = $BOOL.line; $pos = $BOOL.pos;};
	
decl returns [String trad]
	:	tipoSimple primervarid = varid[$tipoSimple.trad] 
		{
			$trad = ".locals(" + $primervarid.resultado.toString();
		}
		(COMA nuevovarid = varid[$tipoSimple.trad]
		{
			$trad+=", " + $nuevovarid.resultado.toString();
		}
		)* PYC 
		{
			$trad += ")\n";
		};
	
varid[String tipo] returns [Tipo resultado]
	:	ID 
		{
			$resultado = new Tipo($tipo);
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
			try{
				tS.add($ID.text,$resultado,numVariable);
				numVariable++;
			}catch(Error_1 ex){
				ex.setFilaColumna($ID.line,$ID.pos);
				throw ex;
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
		| decl
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
			if($expr.tipo.equals("bool")){
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
			if($expr.tipo.equals("bool")){
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
				String tFinal = array.getTipoFinal();
				$trad = ".locals(" + tFinal + ", int32)\n";
				Tipo tipoIterador = new Tipo(tFinal,true);
				int posicion = numVariable;

				tS.add($iterador.text,tipoIterador,numVariable);
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
				if(tipoIterador.tipo.equals("int32") || tipoIterador.tipo.equals("bool")){
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
			Tipo tipoIterador = new Tipo("int32",true);
			int posicion =numVariable;
			tS.add($ID.text,tipoIterador,numVariable);
				numVariable++;
			$trad += $inicializacion.trad;
			$trad += "stloc " + posicion + "\n";
			$maxstack = $inicializacion.maxstack;
			
		}
		TO limite=expr
		{
			$trad += ".locals(int32)\n" + $limite.trad;
			numVariable++;
			if($limite.tipo.equals("float64")){
				$trad+= "conv.i4";
			}else if($limite.tipo.equals("bool")){
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
	|	ref cambio[$ref.variable,$ref.trad,$ref.indice,$ref.tipo]{$trad = $cambio.trad;$maxstack = Math.max($ref.maxstack,$cambio.maxstack);}
	|	ID 
		{
			Simbolo simb = tS.getSimbolo($ID.text);
			String tipo_final_simbolo = simb.getTipoFinal();
			Tipo tipo_simbolo = simb.getTipo();
			if(!simb.esArray()){
				throw new Error_11($ID.text,$ID.line,$ID.pos);
			}
		}
		ASIG NEW tipoSimple 
		{
			if(!tipo_final_simbolo.equals($tipoSimple.trad)){
				String lexema;
				if($tipoSimple.trad.equals("int32")){
					lexema = "int";
				}else if($tipoSimple.trad.equals("float64")){
					lexema = "double";
				}else{
					lexema = "bool";
				}
				throw new Error_14(lexema,$tipoSimple.line, $tipoSimple.pos);
			}
			
			
		}
		 CORI dims[tipo_simbolo] CORD
		 {
		 	if($dims.tipoFinal.array){
		 		throw new Error_10( $CORD.line,$CORD.pos);
		 	}
		 }
		 PYC
		 {
		 	String auxTipo;
		 	$trad = "ldc.i4 " + $dims.dimension + "\n";
		 	if($tipoSimple.trad.equals("int32") || $tipoSimple.trad.equals("bool")){
		 		auxTipo = "[mscorlib]System.Int32";
		 	}else{
		 		auxTipo = "[mscorlib]System.Double";
		 	}
		 	$trad +="newarr " + auxTipo + "\n" + "stloc " + simb.posicion_locals + "\n";
		 	$maxstack = 1;
		 }
	|	WRITELINE PARI expr PARD PYC{
			$trad = $expr.trad;
			$trad += "call void [mscorlib]System.Console::WriteLine(" + $expr.tipo + ")\n";
			$maxstack = $expr.maxstack;
		};

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
		 	if($tipo.array){
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
cambio[int variable, String array_pasado, boolean indice, String tipo] returns [String trad, int maxstack]
	:	ASIG expr PYC
		{
			String expresion = $expr.trad;
			if($indice){
				throw new Error_15($ASIG.line,$ASIG.pos);
			}

			String tipoExpr = $expr.tipo;
			if(!$tipo.equals(tipoExpr)){
				if($tipo.equals("int32")){
					if(tipoExpr.equals("float64")){
						expresion += "conv.i4\n";
						tipoExpr = "int32";
					}else{
						throw new Error_6($ASIG.line,$ASIG.pos);
					}
				}else if($tipo.equals("bool")){
					throw new Error_6($ASIG.line,$ASIG.pos);
				}else{ // tipo = float64
					if(tipoExpr.equals("int32")){
						expresion += "conv.r8\n";
						tipoExpr = "float64";
					}else{
						throw new Error_6($ASIG.line,$ASIG.pos);
					}
				}
			}

			if($array_pasado.equals("")){
				$trad = expresion + "stloc " + $variable + "\n";
				$maxstack = $expr.maxstack;				
			}else{
				
				$trad = "ldloc " + $variable + "\n" + $array_pasado + expresion + "stelem.";		
				if(tipoExpr.equals("int32") || tipoExpr.equals("bool")){
					$trad += "i4\n";	
				}else{
					$trad += "r8\n";
				}
				$maxstack = Math.max($expr.maxstack, 1); // TODO: añadir array_pasado
			}

		}
	|	PUNTO READLINEI PYC
		{
			if($indice){
				throw new Error_15($READLINEI.line,$READLINEI.pos);
			}
			if($tipo.equals("int32")){
				if($array_pasado.equals("")){
					$trad = "call string [mscorlib]System.Console::ReadLine()\n" + "call int32 [mscorlib]System.Int32::Parse(string)\n";
					$trad += "stloc " + $variable +  "\n";
				}else{
					$trad = "ldloc " + $variable + "\n" + $array_pasado + "call string [mscorlib]System.Console::ReadLine()\n" + "call int32 [mscorlib]System.Int32::Parse(string)\n";
					$trad += "stelem.i4 \n";
				}
				$maxstack = 1; // TODO: añadir array_pasado
			}
			else
				throw new Error_7($READLINEI.line,$READLINEI.pos);
		}
	|	PUNTO READLINED PYC
		{
			if($indice){
				throw new Error_15($READLINED.line,$READLINED.pos);
			}
			if($tipo.equals("float64")){
					if($array_pasado.equals("")){
					$trad = "call string [mscorlib]System.Console::ReadLine()\n" + "call float64 [mscorlib]System.Double::Parse(string)\n";
					$trad += "stloc " + $variable +  "\n";
				}else{
					$trad = "ldloc " + $variable + "\n" + $array_pasado + "call string [mscorlib]System.Console::ReadLine()\n" + "call float64 [mscorlib]System.Double::Parse(string)\n";
					$trad += "stelem.i4 \n";
				}
				$maxstack = 1; // TODO: añadir array_pasado
			}
			else
				throw new Error_7($READLINED.line,$READLINED.pos);
		}
	|	PUNTO READLINEB PYC
		{
			if($indice){
				throw new Error_15($READLINEB.line,$READLINEB.pos);
			}
			if($tipo.equals("bool")){
				if($array_pasado.equals("")){
					$trad = "call string [mscorlib]System.Console::ReadLine()\n" + "call bool [mscorlib]System.Boolean::Parse(string)\n";
					$trad += "stloc " + $variable +  "\n";
				}else{
					$trad = "ldloc " + $variable + "\n" + $array_pasado + "call string [mscorlib]System.Console::ReadLine()\n" + "call bool [mscorlib]System.Boolean::Parse(string)\n";
					$trad += "stelem.i4 \n";
				}
				$maxstack = 1; // TODO: añadir array_pasado
			}
			else
				throw new Error_7($READLINEB.line,$READLINEB.pos);
			
		};

expr returns [String trad, String tipo, int maxstack]
	:	primero = eand 
		{
			$trad = $primero.trad; 
			$tipo = $primero.tipo;
			$maxstack = $primero.maxstack;
		}
		(OR 
		{
			if(!$tipo.equals("bool")){
				throw new  Error_4($OR.text,$OR.line,$OR.pos);
			}
		}
		siguiente = eand
		{
			$trad += $siguiente.trad;
			if(!$siguiente.tipo.equals("bool") || !$tipo.equals("bool")){
				throw new  Error_4($OR.text,$OR.line,$OR.pos);
			}
			$tipo = "bool";
			$trad += "or\n";
			$maxstack = Math.max($siguiente.maxstack+1,$maxstack);
		}
		)*;

eand returns [String trad, String tipo, int maxstack]
	:	primero = erel 
		{
			$trad = $primero.trad; 
			$tipo = $primero.tipo;
			$maxstack = $primero.maxstack;
		}
		(AND
		{
			if(!$tipo.equals("bool")){
				throw new  Error_4($AND.text,$AND.line,$AND.pos);
			}
		}
		siguiente = erel
		{
			$trad += $siguiente.trad;
			
			if(!$siguiente.tipo.equals("bool")){
				throw new  Error_4($AND.text,$AND.line,$AND.pos);
			}
			$tipo = "bool";
			$trad += "and\n";
			$maxstack = Math.max($siguiente.maxstack+1,$maxstack);
		}
		)*;


esum returns [String trad, String tipo, int maxstack]
	:	primero = term {
			$trad = $primero.trad; 
			$tipo = $primero.tipo;
			$maxstack = $primero.maxstack;
		}
		(ADDOP 
		{
			if($tipo.equals("bool")){
				throw new  Error_3($ADDOP.text,$ADDOP.line,$ADDOP.pos);
			}
		}
		siguiente = term
		{
			if($siguiente.tipo.equals("bool")|| $tipo.equals("bool")){
				throw new  Error_3($ADDOP.text,$ADDOP.line,$ADDOP.pos);
			}
			boolean convertirSiguiente = false;
			if ($tipo.equals("int32") && $siguiente.tipo.equals("int32")) {
				$tipo = "int32";
			} else if ($tipo.equals("int32")) { // $siguiente.tipo.equals("float64")
				$trad += "conv.r8\n";
				$tipo = "float64";
			} else if ($siguiente.tipo.equals("int32")) { // $primero.tipo.equals("float64")
				convertirSiguiente = true;
				$tipo = "float64";
			} else { // $siguiente.tipo.equals("float64") && $primero.tipo.equals("float64")
				$tipo = "float64";
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
erel returns [String trad, String tipo, int maxstack]
	:	primero = esum 
		{
			$trad = $primero.trad; 
			$tipo = $primero.tipo;
			$maxstack = $primero.maxstack;
		}
		(RELOP siguiente = esum
		{
			boolean convertirSiguiente = false;
			if (($tipo.equals("int32") || $tipo.equals("bool")) && ($siguiente.tipo.equals("int32") || $siguiente.tipo.equals("bool"))) {
			} else if ($tipo.equals("int32") || $tipo.equals("bool")) { // $siguiente.tipo.equals("float64")
				$trad += "conv.r8\n";
			} else if ($siguiente.tipo.equals("int32") || $siguiente.tipo.equals("bool")) { // $primero.tipo.equals("float64")
				convertirSiguiente = true;
			}

			$trad += $siguiente.trad;
			if(convertirSiguiente){
				$trad+= "conv.r8\n";
			}
			$tipo = "bool";
			
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



term returns [String trad, String tipo, int maxstack]
	:	primero = factor 
		{
			$trad = $primero.trad; 
			$tipo = $primero.tipo;
			$maxstack = $primero.maxstack;
		}
		(MULOP
		{
			if($tipo.equals("bool")){
				throw new  Error_3($MULOP.text,$MULOP.line,$MULOP.pos);
			}
		}
		siguiente = factor
		{
			if($siguiente.tipo.equals("bool")){
				throw new  Error_3($MULOP.text,$MULOP.line,$MULOP.pos);
			}
			boolean convertirSiguiente = false;
			if ($tipo.equals("int32") && $siguiente.tipo.equals("int32")) {
				$tipo = "int32";
			} else if ($tipo.equals("int32")) { // $siguiente.tipo.equals("float64")
				$trad += "conv.r8\n";
				$tipo = "float64";
			} else if ($siguiente.tipo.equals("int32")) { // $primero.tipo.equals("float64")
				convertirSiguiente = true;
				$tipo = "float64";
			} else { // $siguiente.tipo.equals("float64") && $primero.tipo.equals("float64")
				$tipo = "float64";
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

factor returns [String trad, String tipo, int maxstack]
	:	base{$trad = $base.trad; $tipo = $base.tipo;$maxstack = $base.maxstack;}
	|	NOT otro = factor{if($otro.tipo.equals("bool")){
				$trad = $otro.trad  + "ldc.i4 1\n" + "xor\n";
				$tipo = "bool";
				$maxstack = Math.max($otro.maxstack,2);
			}else{
				throw new  Error_4($NOT.text,$NOT.line,$NOT.pos);
			}}
	|	PARI ADDOP otro = factor PARD
		{
			if($ADDOP.text.equals("-")){
				if($otro.tipo.equals("bool")){
					throw new  Error_3($ADDOP.text,$ADDOP.line,$ADDOP.pos);
				}else{
					$trad = $otro.trad + "neg\n";
				}
			}else{
				if($otro.tipo.equals("bool")){
					throw new  Error_3($ADDOP.text,$ADDOP.line,$ADDOP.pos);
				}else{
					$trad = $otro.trad;
				}	
			}
			$tipo = $otro.tipo;
			$maxstack = $otro.maxstack;
		};

base returns [String trad, String tipo, int maxstack]
	:	ENTERO{$trad = "ldc.i4 " + $ENTERO.text + "\n"; $tipo = "int32";$maxstack = 1;}
	|	REAL
		{
			/*StringBuilder numeroReal = new StringBuilder($REAL.text);
			numeroReal.setCharAt(numeroReal.indexOf("."), ',');*/
			$trad ="ldc.r8 " + $REAL.text + "\n"; $tipo = "float64";$maxstack = 1;
		}
	|	BOOLEANO{if($BOOLEANO.text.equals("True")){
				$trad = "ldc.i4 1\n";
			}else{
				$trad = "ldc.i4 0\n";
			} 
			$tipo = "bool";$maxstack = 1;}
	|	PARI expr PARD{$trad = $expr.trad; $tipo = $expr.tipo;$maxstack = $expr.maxstack;}
	|	ref {$trad = "ldloc " + $ref.variable + "\n" + $ref.trad + $ref.getDato;$tipo = $ref.tipo;$maxstack = $ref.maxstack + 1;};

ref returns [int variable, String tipo, String trad, String getDato, boolean indice, int maxstack]
	:	ID 
		{
			Simbolo referencia;
			try{
			    referencia = tS.getSimbolo($ID.text);
			    $variable= referencia.posicion_locals; 
			    $tipo = referencia.tipo.getTipo();
			    $trad = "";
			    $getDato = "";
			    $indice = referencia.tipo.isIndice();
			    $maxstack = 0;
			}catch(Error_2 e){
			    e.setFilaColumna($ID.line,$ID.pos);
			    throw e;
			}


		} 
		(CORI indices[referencia, $ID] CORD
		{
			$tipo = referencia.tipo.getTipoFinal();
			$trad += "\n" + $indices.trad ;
			$getDato = "ldelem.";
			if($tipo.equals("int32") || $tipo.equals("bool")){
				$getDato += "i4\n";	
			}else{
				$getDato += "r8\n";
			}
			$maxstack += $indices.maxstack + 1;
		}
		)?
		{
			if(referencia.esArray() && $getDato.equals("")){
				throw new Error_9($ID.text,$ID.line,$ID.pos);
			}
		};

indices[Simbolo elemento, Token id] returns [String trad, int maxstack]
	:	primero=expr
		{
			$trad = $primero.trad;
			Tipo tipoElem = $elemento.tipo;
			if(!tipoElem.array){
				throw new Error_11($id.getText(),$id.getLine(),$id.getCharPositionInLine());
			}
			if($primero.tipo.equals("float64")){
				$trad += "conv.i4\n";
			}else if($primero.tipo.equals("bool")){
				throw new Error_13($id.getLine(),$id.getCharPositionInLine());
			}
			
			int dimensionRestante = tipoElem.tipobase.getDimensionTotal();
			$trad += "ldc.i4 " + dimensionRestante + "\n" + "mul\n";		
			tipoElem = tipoElem.tipobase;
			$maxstack = $primero.maxstack + 1;
		}
		(COMA siguiente=expr
		{
			
			if(!tipoElem.array){
				throw new Error_12($COMA.getLine(),$COMA.getCharPositionInLine());
			}else{
			 	$trad += $siguiente.trad;
				 	if($siguiente.tipo.equals("float64")){
					$trad += "conv.i4\n";
				}else if($siguiente.tipo.equals("bool")){
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
			if(tipoElem.array){
				throw new Error_9($id.getText(),$id.getLine(),$id.getCharPositionInLine());
			}
		};

/* Analizador léxico: */


CLASS	:	'class';
SINGLE	:	'Single';
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
 