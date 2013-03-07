grammar plp3;

/* Traduce con ANTLR un fichero de expresiones infijas separadas por punto 
   y coma a notación prefija. Usa una gramática EBNF.
*/ 

@header {
	import java.lang.String;
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
sAux returns[String resultado]
	:	{tS = new tablaSimbolos();}clase{$resultado = ".assembly extern mscorlib {}\n" + ".assembly '" + "PruebaVariables.fnt" + "' {}\n" + $clase.trad;};

s[String archivo] returns [String resultado]
	:	{tS = new tablaSimbolos();}clase{$resultado = ".assembly extern mscorlib {}\n" + ".assembly '" + $archivo + "' {}\n" + $clase.trad;};

clase returns [String trad]
	:	CLASS SINGLE LLAVEI {$trad=".class 'Single' extends [mscorlib]System.Object \n{\n";} metodo {$trad+=$metodo.trad + "\n}";} LLAVED;

metodo returns [String trad]
	:	PUBLIC STATIC VOID MAIN PARI PARD bloque[-1, -1]{$trad = ".method static public void main () cil managed \n{\n.entrypoint\n.maxstack 1000\n.locals(int32)\n"+$bloque.trad+"\n ret\n}";};

tipoSimple returns [String trad]
	:	INT {$trad = "int32";}
	|	DOUBLE {$trad = "float64";}
	|	BOOL {$trad="bool";};
	
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
	:	ID {
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

declins[int etiquetaBreakBucle, int etiquetaContinueBucle] returns [String trad]
	:	{$trad = "";}(instr[$etiquetaBreakBucle, $etiquetaContinueBucle] {$trad += $instr.trad;}| decl{$trad += $decl.trad;
	// ==========================================================	
		//System.out.println("tS = "+tS.getAll());
	// ==========================================================		
		})*;

bloque[int etiquetaBreakBucle, int etiquetaContinueBucle] returns [String trad]
	:	{tS = new tablaSimbolos(tS);}LLAVEI declins[$etiquetaBreakBucle, $etiquetaContinueBucle] LLAVED{$trad = $declins.trad;tS = tS.pop();};

instr[int etiquetaBreakBucle, int etiquetaContinueBucle] returns [String trad]
@init{
		int etiqFin = -1;
		int etiqIni = -1;
		int etiqContinue = -1;
	}
	:	bloque[$etiquetaBreakBucle, $etiquetaContinueBucle]{$trad = $bloque.trad;}
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
			}else{
				throw new Error_5($IF.text,$IF.line,$IF.pos);
			}
			
		}
		PARD insif=instr[$etiquetaBreakBucle,$etiquetaContinueBucle]
		{
			$trad += $insif.trad + "br et"+etiqFin + "\n";
			$trad += "et" + etiqElse + ": ";
		}
		(ELSE inselse=instr[$etiquetaBreakBucle,$etiquetaContinueBucle]
		{
			$trad += $inselse.trad;
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
		PARD contenido=instr[etiqFin,etiqIni]
		{
				$trad = "et" + etiqIni + ": " + $expr.trad + "ldc.i4 0\n" + "beq et" + etiqFin + "\n";
				$trad += $contenido.trad + "br et" + etiqIni + "\n" + "et" + etiqFin + ": ";
			
		}
	|	FOREACH PARI VAR iterador=ID IN idArray=ID
		{
			Simbolo array = tS.getSimbolo($idArray.text);
			if(array.esArray()){
				tS = new tablaSimbolos(tS);
				String tFinal = array.getTipoFinal();
				$trad = ".locals(" + tFinal + ")\n";
				Tipo tipoIterador = new Tipo(tFinal,true);
				int posicion = numVariable;
				tS.add($iterador.text,tipoIterador,numVariable);
				numVariable++;

				etiqIni = numEtiqueta;
				numEtiqueta++;

				etiqFin = numEtiqueta;
				numEtiqueta++;

				etiqContinue = numEtiqueta;
				numEtiqueta++;

				$trad += "ldc.i4 0\n" + "stloc 0\n";
				$trad += "et" + etiqIni + ": ";
				$trad += "ldloc 0\n" + "ldc.i4 " + (array.getDimension()-1) + "\n" + "bgt et" + etiqFin + "\n";
				$trad += "ldloc " + array.posicion_locals + "\n";
				$trad += "ldloc 0\n" + "ldelem.";
				if(tipoIterador.tipo.equals("int32") || tipoIterador.tipo.equals("bool")){
					$trad += "i4\n";	
				}else{
					$trad += "r8\n";
				}
				$trad += "stloc " + posicion + "\n"; // y lo guardamos en el iterador

			}else{
				// TODO: throw error 11
				System.err.println("error 11");
				System.exit(1);
			}
		}
		PARD contenido=instr[etiqFin,etiqContinue]
		{
			$trad += $contenido.trad;
			$trad += "et" + etiqContinue + ": ldloc 0\n" + "ldc.i4 1\n" + "add\n" + "stloc 0\n" + "br et" + etiqIni + "\n";
			$trad += "et" + etiqFin + ": ";
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
			
		}
		TO limite=expr
		{
			$trad += ".locals(int32)\n" + $limite.trad;
			numVariable++;
			if($limite.tipo.equals("float64")){
				$trad+= "conv.i4";
			}else if($limite.tipo.equals("bool")){
				// TODO: throw error 17 $TO.line
				System.err.println("error 17");
				System.exit(1);
			}
			$trad += "stloc " + (posicion+1) + "\n";
			etiqIni = numEtiqueta;
			numEtiqueta++;
			etiqFin = numEtiqueta;
			numEtiqueta++;
			etiqContinue = numEtiqueta;
			numEtiqueta++;

		}
		STEP (ADDOP)? ENTERO PARD contenido=instr[etiqFin,etiqContinue]
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
		}
	|	BREAK PYC
		{
			if($etiquetaBreakBucle != -1){
				$trad = "br et" + $etiquetaBreakBucle + "\n";
			}else{
				// throw Error 16
				System.err.println("Error 16");
				System.exit(1);
			}
			
		}
	|	CONTINUE PYC{
			if($etiquetaContinueBucle != -1){
				$trad = "br et"+$etiquetaContinueBucle + "\n";
			}else{
				// throw Error 16
				System.err.println("Error 16");
				System.exit(1);
			}
		}
	|	ref cambio[$ref.variable,$ref.trad,$ref.indice,$ref.tipo]{$trad = $cambio.trad;}
	|	ID 
		{
			Simbolo simb = tS.getSimbolo($ID.text);
			String tipo_final_simbolo = simb.getTipoFinal();
			Tipo tipo_simbolo = simb.getTipo();
			if(!simb.esArray()){
				//throw Error 11
			}
		}
		ASIG NEW tipoSimple 
		{
			if(!tipo_final_simbolo.equals($tipoSimple.trad)){
				// throw Error 14
			}
			
			
		}
		 CORI dims[tipo_simbolo] CORD
		 {
		 	if($dims.tipoFinal.array){
		 		//throw Error 10 $CORD.line $CORD.pos
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
		 }
	|	WRITELINE PARI expr PARD PYC{
			$trad = $expr.trad;
			String aux = $expr.tipo;
			/*if(aux.equals("bool"))
				aux = "int32";*/
			$trad += "call void [mscorlib]System.Console::WriteLine(" + aux + ")\n";
		};

dims[Tipo tipo] returns [int dimension, Tipo tipoFinal]
	:	primero=ENTERO
		{
			try{
				$tipo.setDimension($primero.text);
				$dimension = $tipo.getDimension();
				$tipo = $tipo.getTipoBase();
			}catch(Exception e/*Error8*/){
				// e.fila = $primero.line;
				// e.col = $primero.pos;
				// throw e;
			}
		}
		 (COMA siguiente=ENTERO
		 {
		 	if($tipo.array){
		 		try{
					$tipo.setDimension($siguiente.text);
					$dimension *= $tipo.getDimension();
					$tipo = $tipo.getTipoBase();
				}catch(Exception e/*Error8*/){
					// e.fila = $siguiente.line;
					// e.col = $siguiente.pos;
					// throw e;
				}
			}else{
				//throw Error 10
			}
		}
		 )*
		 {$tipoFinal = $tipo;};
cambio[int variable, String array_pasado, boolean indice, String tipo] returns [String trad]
	:	ASIG expr PYC
		{
			String expresion = $expr.trad;
			if($indice){
				//throw Error 15
				System.err.println("ERROR 15");
				System.exit(1);
			}

			if(!$tipo.equals($expr.tipo)){
				if($tipo.equals("int32")){
					if($expr.tipo.equals("float64")){
						expresion += "conv.i4\n";
					}else{
						throw new Error_6($ASIG.line,$ASIG.pos);
					}
				}else if($tipo.equals("bool")){
					throw new Error_6($ASIG.line,$ASIG.pos);
				}else{ // tipo = float64
					if($expr.tipo.equals("int32")){
						expresion += "conv.r8\n";
					}else{
						throw new Error_6($ASIG.line,$ASIG.pos);
					}
				}
			}

			if($array_pasado.equals("")){
				$trad = expresion + "stloc " + $variable + "\n";				
			}else{
				
				$trad = "ldloc " + $variable + "\n" + $array_pasado + expresion + "stelem.";
				if($expr.tipo.equals("int32") || $expr.tipo.equals("bool")){
					$trad += "i4\n";	
				}else{
					$trad += "r8\n";
				}
			}

		}
	|	PUNTO READLINEI PYC
		{
			if($tipo.equals("int32"))
				$trad = "call string [mscorlib]System.Console::ReadLine()\n" + "call int32 [mscorlib]System.Int32::Parse(string)\n"+ "stloc " + $variable +  "\n";
			else
				throw new Error_7($READLINEI.line,$READLINEI.pos);
		}
	|	PUNTO READLINED PYC
		{
			if($tipo.equals("float64"))
				$trad = "call string [mscorlib]System.Console::ReadLine()\n" + "call float64 [mscorlib]System.Double::Parse(string)\n"+ "stloc " + $variable +  "\n";
			else
				throw new Error_7($READLINED.line,$READLINED.pos);
		}
	|	PUNTO READLINEB PYC
		{
			if($tipo.equals("bool"))
				$trad = "call string [mscorlib]System.Console::ReadLine()\n" + "call bool [mscorlib]System.Boolean::Parse(string)\n"+ "stloc " + $variable +  "\n";
			else
				throw new Error_7($READLINEB.line,$READLINEB.pos);
			
		};

expr returns [String trad, String tipo]
	:	primero = eand 
		{
			$trad = $primero.trad; 
			$tipo = $primero.tipo;
		}
		(OR siguiente = eand
		{
			$trad += $siguiente.trad;
			if(!$siguiente.tipo.equals("bool") || !$tipo.equals("bool")){
				throw new  Error_4($OR.text,$OR.line,$OR.pos);
			}
			$tipo = "bool";
			$trad += "or\n";
		}
		)*;

eand returns [String trad, String tipo]
	:	primero = erel 
		{
			$trad = $primero.trad; 
			$tipo = $primero.tipo;
		}
		(AND siguiente = erel
		{
			$trad += $siguiente.trad;
			
			if(!$siguiente.tipo.equals("bool") || !$tipo.equals("bool")){
				throw new  Error_4($AND.text,$AND.line,$AND.pos);
			}
			$tipo = "bool";
			$trad += "and\n";
		}
		)*;


esum returns [String trad, String tipo]
	:	primero = term {
			$trad = $primero.trad; 
			$tipo = $primero.tipo;
		}
		(ADDOP siguiente = term
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
		})*;
erel returns [String trad, String tipo]
	:	primero = esum 
		{
			$trad = $primero.trad; 
			$tipo = $primero.tipo;
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
			    $trad += "sub\n" + "dup\n" + "stloc 0\n" + "ldc.i4 0\n" + "clt\n" + "ldloc 0\n" + "ldc.i4 0\n" + "ceq\n" + "or\n";
			}else if($RELOP.text.equals(">=")){
			    $trad += "sub\n" + "dup\n" + "stloc 0\n" + "ldc.i4 0\n" + "cgt\n" + "ldloc 0\n" + "ldc.i4 0\n" + "ceq\n" + "or\n";
			}
			
			
		})*;



term returns [String trad, String tipo]
	:	primero = factor 
		{
			$trad = $primero.trad; 
			$tipo = $primero.tipo;
		}
		(MULOP siguiente = factor
		{
			if($siguiente.tipo.equals("bool") || $tipo.equals("bool")){
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
		})*;

factor returns [String trad, String tipo]
	:	base{$trad = $base.trad; $tipo = $base.tipo;}
	|	NOT otro = factor{if($otro.tipo.equals("bool")){
				$trad = $otro.trad  + "ldc.i4 1\n" + "xor\n";
				$tipo = "bool";
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
		};

base returns [String trad, String tipo]
	:	ENTERO{$trad = "ldc.i4 " + $ENTERO.text + "\n"; $tipo = "int32";}
	|	REAL{$trad ="ldc.r8 " +  $REAL.text + "\n"; $tipo = "float64";}
	|	BOOLEANO{if($BOOLEANO.text.equals("True")){
				$trad = "ldc.i4 1\n";
			}else{
				$trad = "ldc.i4 0\n";
			} 
			$tipo = "bool";}
	|	PARI expr PARD{$trad = $expr.trad; $tipo = $expr.tipo;}
	|	ref {$trad = "ldloc " + $ref.variable + "\n" + $ref.trad + $ref.getDato;$tipo = $ref.tipo;};

ref returns [int variable, String tipo, String trad, String getDato, boolean indice]
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
			}catch(Error_2 e){
			    e.setFilaColumna($ID.line,$ID.pos);
			    throw e;
			}
		} 
		(CORI indices[referencia] CORD
		{
			if(!$tipo.equals("array")){
				// throw error 11
			}
			$tipo = referencia.tipo.getTipoFinal();
			$trad += "\n" + $indices.trad ;
			$getDato = "ldelem.";
			if($tipo.equals("int32") || $tipo.equals("bool")){
				$getDato += "i4\n";	
			}else{
				$getDato += "r8\n";
			}
		}
		)?;

indices[Simbolo elemento] returns [String trad]
	:	primero=expr
		{
			$trad = $primero.trad;
			Tipo tipoElem = $elemento.tipo;
			if($primero.tipo.equals("float64")){
				$trad += "conv.i4\n";
			}else if($primero.tipo.equals("bool")){
				// throw error 13
			}
			
			// TODO: comprobar si el índice se sale de rango...
			
			int dimensionRestante = tipoElem.tipobase.getDimensionTotal();
			$trad += "ldc.i4 " + dimensionRestante + "\n" + "mul\n";			
		}
		 (COMA siguiente=expr
		 {
		 	$trad += $siguiente.trad;
		 	tipoElem = tipoElem.tipobase;
		 	if($siguiente.tipo.equals("float64")){
				$trad += "conv.i4\n";
			}else if($siguiente.tipo.equals("bool")){
				// throw error 13
			}
			
			// TODO: comprobar si el índice se sale de rango...
			dimensionRestante = tipoElem.tipobase.getDimensionTotal();
			$trad += "ldc.i4 " + dimensionRestante + "\n" + "mul\n" + "add\n";
		 }
		 )*;

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
 