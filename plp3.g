grammar plp3;

/* Traduce con ANTLR un fichero de expresiones infijas separadas por punto 
   y coma a notaciÃ³n prefija. Usa una gramÃ¡tica EBNF.
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
	:	PUBLIC STATIC VOID MAIN PARI PARD bloque{$trad = ".method static public void main () cil managed \n{\n.entrypoint\n.maxstack 1000\n.locals(int32)\n"+$bloque.trad+"\n ret\n}";};

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
			           tS.add($ID.text,$resultado);
			}catch(Sem_LexYaExiste ex){
			           ex.setFilaColumna($ID.line,$ID.pos);
			           throw ex;
			}
		       };

declins returns [String trad]
	:	{$trad = "";}(instr {$trad += $instr.trad;}| decl{$trad += $decl.trad;
	// ==========================================================	
		//System.out.println("tS = "+tS.getAll());
	// ==========================================================		
		})*;

bloque returns [String trad]
	:	{tS = new tablaSimbolos(tS);}LLAVEI declins LLAVED{$trad = $declins.trad;tS = tS.pop();};

instr returns [String trad]
	:	bloque{$trad = $bloque.trad;}
	|	IF PARI expr 
		{
			int etiqElse = -1;
			int etiqFin = -1;
			if($expr.tipo.equals("bool")){
				etiqFin = numEtiqueta;
				numEtiqueta++;
				etiqElse = numEtiqueta;
				numEtiqueta++;
				$trad = $expr.trad + "ldc.i4 0\n" + "beq et" + etiqElse + "\n";
			}else{
				// throw Error 5
			}
			
		}
		PARD insif=instr
		{
			$trad += $insif.trad + "br et"+etiqFin + "\n";
			$trad += "et" + etiqElse + ": ";
		}
		(ELSE inselse=instr
		{
			$trad += $inselse.trad;
		}
		)?{$trad += "et" + etiqFin + ": ";}
	|	WHILE PARI expr PARD contenido=instr
		{
			if($expr.tipo.equals("bool")){
				int etiqInicio = numEtiqueta;
				numEtiqueta++;
				int etiqFin = numEtiqueta;
				numEtiqueta++;
				$trad = "et" + etiqInicio + ": " + $expr.trad + "ldc.i4 0\n" + "beq et" + etiqFin + "\n";
				$trad += $contenido.trad + "br et" + etiqInicio + "\n" + "et" + etiqFin + ": ";
			}else{
				// throw error
			}
		}
	|	FOREACH PARI VAR ID IN ID PARD instr{$trad = "instr";}
	|	FOR PARI INT ID ASIG inicializacion=expr
		{
			tS = new tablaSimbolos(tS);
			$trad = ".locals(int32)\n";
			Tipo tipoIterador = new Tipo("int32",true);
			tS.add($ID.text,tipoIterador);
			Simbolo iterador = tS.getSimbolo("i");
			$trad += $inicializacion.trad;
			$trad += "stloc " + iterador.posicion_locals + "\n";
			
		}
		TO limite=expr
		{
			$trad += $limite.trad + "stloc 0\n";
			int etiqIni = numEtiqueta;
			numEtiqueta++;
			int etiqFin = numEtiqueta;
			numEtiqueta++;

		}
		 STEP (ADDOP)? ENTERO PARD contenido=instr
		{
			$trad+= "et" + etiqIni + ": " + "ldloc " + iterador.posicion_locals + "\n" + "ldloc 0\n";
			if($ADDOP == null || $ADDOP.text.equals("+")){
				$trad += "bgt et" + etiqFin + "\n";
			}else{
				$trad += "blt et" + etiqFin + "\n";			
			}
			 
			$trad+= $contenido.trad;
			
			$trad += "ldloc " + iterador.posicion_locals + "\n" + "ldc.i4 " + $ENTERO.text + "\n";
			
			if($ADDOP == null || $ADDOP.text.equals("+")){
				$trad += "add\n";
			}else{
				$trad += "sub\n";
			}
			$trad += "stloc " + iterador.posicion_locals + "\n";
			
			
			$trad += "br et" + etiqIni + "\n" + "et" + etiqFin + ": ";
			tS = tS.pop();
		}
	|	BREAK PYC{$trad = "instr";}
	|	CONTINUE PYC{$trad = "instr";}
	|	ref cambio[$ref.variable,$ref.trad,$ref.indice]{$trad = $cambio.trad;}
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
cambio[int variable, String array_pasado, boolean indice] returns [String trad]
	:	ASIG expr PYC
		{
			if($indice){
				//throw Error 15
				System.err.println("ERROR 15");
				System.exit(1);
			}
			if($array_pasado.equals("")){
				$trad = $expr.trad + "stloc " + $variable + "\n";				
			}else{
				
				$trad = "ldloc " + $variable + "\n" + $array_pasado + $expr.trad + "stelem.";
				if($expr.tipo.equals("int32") || $expr.tipo.equals("bool")){
					$trad += "i4\n";	
				}else{
					$trad += "r8\n";
				}
			}

		}
	|	PUNTO READLINEI PYC{$trad = "call string [mscorlib]System.Console::ReadLine()\n" + "call int32 [mscorlib]System.Int32::Parse(string)\n"+ "stloc " + $variable +  "\n";}
	|	PUNTO READLINED PYC{$trad = "call string [mscorlib]System.Console::ReadLine()\n" + "call float64 [mscorlib]System.Double::Parse(string)\n"+ "stloc " + $variable +  "\n";}
	|	PUNTO READLINEB PYC{$trad = "call string [mscorlib]System.Console::ReadLine()\n" + "call bool [mscorlib]System.Boolean::Parse(string)\n"+ "stloc " + $variable +  "\n";};

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
				throw new  Sem_DebeSerBool($OR.text,$OR.line,$OR.pos);
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
				throw new  Sem_DebeSerBool($AND.text,$AND.line,$AND.pos);
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
				throw new  Sem_DebeSerNum($ADDOP.text,$ADDOP.line,$ADDOP.pos);
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
				throw new  Sem_DebeSerNum($MULOP.text,$MULOP.line,$MULOP.pos);
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
				throw new  Sem_DebeSerBool($NOT.text,$NOT.line,$NOT.pos);
			}}
	|	PARI ADDOP otro = factor PARD
		{
			if($ADDOP.text.equals("-")){
				if($otro.tipo.equals("bool")){
					throw new  Sem_DebeSerNum($ADDOP.text,$ADDOP.line,$ADDOP.pos);
				}else{
					$trad = $otro.trad + "neg\n";
				}
			}else{
				if($otro.tipo.equals("bool")){
					throw new  Sem_DebeSerNum($ADDOP.text,$ADDOP.line,$ADDOP.pos);
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
			}catch(Sem_LexNoDefinido e){
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
 