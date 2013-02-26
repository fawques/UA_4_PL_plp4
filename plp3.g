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
	public void emitErrorMessage(String msg) {
		System.err.println(msg);
		System.exit(1);
	}
}

/* Analizador sintáctico: */


/* 
s returns [String resultado]
	:	PROGRAM {tS = new tablaSimbolos();} ID PYC vsp["main_"] bloque["main_"]
	{
	$resultado = "// program " + $ID.text + "\n" + $vsp.trad + "int main()" + $bloque.trad;
	} EOF;

vsp [String prefijo] returns [String trad]
	:	{$trad = "";} ( unvsp[$prefijo] {trad += $unvsp.trad;} )+;

unvsp [String prefijo] returns [String trad]
	:	FUNCTION ID
	{
		String nuevoPrefijo = $prefijo;
		try {
				tS.add($ID.text, $prefijo, "funcion");
            } catch (Sem_LexYaExiste ex) {
				ex.fila = $ID.line;
				ex.columna = $ID.pos;
				throw ex;
            }
        String nombre_funcion = $ID.text;
		tS = new tablaSimbolos(tS);
		
		if (!$prefijo.equals("main_")) {
			nombre_funcion = $prefijo + $ID.text;
			nuevoPrefijo += $ID.text + "_";
		} else {
			nuevoPrefijo = $ID.text + "_";
		}
	}
	DOSP tipo PYC vsp[nuevoPrefijo] bloque[nuevoPrefijo] PYC 
	{
		tS = tS.pop();
		$trad = $vsp.trad + $tipo.tipo + " " + nombre_funcion + "()" + $bloque.trad;
	}
	|	VAR {String aux ="";} ( v[$prefijo] {aux +=$v.trad;})+ {$trad = aux;};

v [String prefijo] returns [String trad]
	:	primerID = ID 
	{
	    String aux =$prefijo + $primerID.text;
	    String id = $prefijo + $primerID.text;
            // vamos asignando notipo para luego poner el tipo encontrado
            ArrayList<Simbolo> variables_sin_tipo = new ArrayList<Simbolo>();
            Simbolo simbolo = new Simbolo($primerID.text, id, "NOTIPO");
            try {
                tS.add(simbolo);
            } catch (Sem_LexYaExiste ex) {
                ex.fila = $primerID.line;
                ex.columna = $primerID.pos;
                throw ex;
            }
            variables_sin_tipo.add(simbolo);
	}
	( COMA nuevoID = ID
		{
		    aux += ", " + $prefijo + $nuevoID.text;
		    simbolo = new Simbolo($nuevoID.text, $prefijo + $nuevoID.text, "NOTIPO");
	            id = $prefijo + $nuevoID.text;
	
	            try {
		                tS.add(simbolo);
		            } catch (Sem_LexYaExiste ex) {
		                ex.fila = $nuevoID.line;
		                ex.columna = $nuevoID.pos;
		                throw ex;
		            }
		
	            variables_sin_tipo.add(simbolo);
		} )* 
	DOSP tipo 
	{
	//recolocamos el tipo
            for (Simbolo item : variables_sin_tipo) {
	        	item.tipo = $tipo.tipo;
            }
            variables_sin_tipo.clear();
	} PYC {$trad = $tipo.tipo + " " + aux + ";\n";};

tipo	returns [String tipo]
	:	INTEGER {$tipo = "int";}
	|	REAL {$tipo = "float64";};

bloque	[String prefijo] returns [String trad]
	:	BEGIN sinstr[$prefijo] END {$trad = "{\n" + $sinstr.trad + "\n}\n";};
	
sinstr [String prefijo] returns [String trad]
 	:	primerinstr = instr[$prefijo] {String aux =$primerinstr.trad;} (PYC nuevoinstr = instr[$prefijo] {aux += "\n" + $nuevoinstr.trad;})* {$trad = aux; };

instr [String prefijo] returns [String trad]
	:	bloque[$prefijo] {$trad = $bloque.trad;}
	|	ID 
	{
		Simbolo simb;
		String tipo;
        try {
            simb = tS.getSimbolo($ID.text);
//            tipo = simb.tipo;
            if (simb.tipo.equals("funcion")) {
                throw new Sem_NoVar($ID.text, $ID.line, $ID.pos);
            }
                    } catch (Sem_LexNoDefinido ex) {
            ex.fila = $ID.line;
			ex.columna = $ID.pos;
            throw ex;
        }
	}
	ASIG e[$prefijo] 
	{
		$trad = simb.nombre_completo + " =";
		if ($e.tipo.equals("bool")) {
                throw new Sem_AsigNoBool($ASIG.line, $ASIG.pos);
        } else if (simb.tipo.equals("float64")) {
            $trad += "r ";
            if ($e.tipo.equals("int")) {
                $trad += "itor(" + $e.trad + ");";
            } else {
                $trad += $e.trad + ";";
            }
        } else if (simb.tipo.equals("int")) {
            $trad += "i " + $e.trad + ";";
            if ($e.tipo.equals("float64")) {
                throw new Sem_DebeSerReal($ID.text, $ID.line, $ID.pos);
            }
        }
	}
	|	IF e[$prefijo] 
		{
			if (!"bool".equals($e.tipo)) {
	            throw new Sem_DebeSerBool("if", $IF.line, $IF.pos);
	        }
	    }
    THEN primerinstr = instr[$prefijo] 
    	{
    		$trad = "if(" + $e.trad + ")\n" + $primerinstr.trad;
    	}
    (ELSE nuevoinstr = instr[$prefijo]
	    {
	    	$trad += "\n" + $ELSE.text + "\n" + $nuevoinstr.trad;
	    }
    )? ENDIF
	|	WHILE e[$prefijo]
		{
			if (!"bool".equals($e.tipo)) {
	            throw new Sem_DebeSerBool("while", $WHILE.line, $WHILE.pos);
	        }
	    }
    DO primerinstr = instr[$prefijo]
    	{
    		$trad = "while(" + $e.trad + ")\n" + $primerinstr.trad;
    	}
    |	WRITELN PARI e[$prefijo]
		{
			if ("bool".equals($e.tipo)) {
				throw new Sem_WritelnNoBool($WRITELN.line, $WRITELN.pos);
	        }
	    }
	 PARD
		{
			String aux;
	        if ($e.tipo.equals("float64")) {
	            aux = "\%g";
	        } else {
	            aux = "\%d";
	        }
			$trad = "printf(\"" + aux + "\\n\"," + $e.trad + ");";
		};

e [String prefijo] returns [String trad, String tipo]
	:	primerexpr = expr[$prefijo]
		{
			$tipo = $primerexpr.tipo;
			$trad = $primerexpr.trad;
			String primertrad = $trad;
		}
	(RELOP nuevoexpr = expr[$prefijo] 
		{
			String nuevotrad = $nuevoexpr.trad;
			String relop = $RELOP.text;
			if (relop.equals("<>")) {
                relop = "!=";
            } else if (relop.equals("=")) {
                relop = "==";
            }

            if (primerexpr.tipo.equals("float64")) {
                relop += "r";
                if ($nuevoexpr.tipo.equals("int")) {
                   nuevotrad  = "itor(" + nuevotrad + ")";
                }
            } else if ($nuevoexpr.tipo.equals("float64")) {
                relop += "r";
                primertrad = "itor(" + primertrad + ")";
            } else {
                relop += "i";
            }

            $trad = primertrad + " " + relop + " " + nuevotrad;
            $tipo = "bool";
		}
	)?;

expr [String prefijo] returns [String trad, String tipo]
	:	primerterm = term[$prefijo]
		{
			$trad = $primerterm.trad;
			//String $trad = null;
			String $tipo = "NOTIPO";
			String tipoanterior = $primerterm.tipo;
		}
	(ADDOP 
		{
			String addop = $ADDOP.text;
	        if (addop.equals("div")) {
	            addop = "/i";
	            //$trad = addop;
	            $tipo = "int";
	        } else if (addop.equals("/")) {
	            addop = "/r";
				//$trad = addop;	
	            $tipo = "float64";
	        } else {
	            //$trad = addop;
	        }
		}
	nuevoterm = term[$prefijo]
		{
			if ($tipo.equals("NOTIPO")) {
                if (tipoanterior.equals("int") && nuevoterm.tipo.equals("int")) {
                    //$trad = $trad + " " + $trad + "i" + " " + nuevoterm.trad;
                    $tipo = "int";
                } else if (tipoanterior.equals("int")) { // nuevoterm.tipo.equals("float64")
                    $trad = " itor(" + $trad + ")";
                    //$trad = $trad + " " + $trad + "r" + " " + nuevoterm.trad;
                    $tipo = "float64";
                } else if (nuevoterm.tipo.equals("int")) { // primerfactor.tipo.equals("float64")
                    //$trad = $trad + " " + $trad + "r" + " itor(" + nuevoterm.trad + ")";
                    $tipo = "float64";
                } else { // factor.tipo.equals("float64") && primerfactor.tipo.equals("float64")
                    //$trad = $trad + " " + $trad + "r" + " " + nuevoterm.trad;
                    $tipo = "float64";
                }
            } else {
                if ($tipo.equals("int")) {
                    if (tipoanterior.equals("float64") || nuevoterm.tipo.equals("float64")) {
                        throw new Sem_DivDebeSerEntero($ADDOP.line, $ADDOP.pos);
                    } else {
                        //$trad = $trad + " " + $trad + " " + nuevoterm.trad;
                    }
                } else {
                    if (tipoanterior.equals("int")) {
                        $trad = " itor(" + $trad + ")";
                    }
                    if (nuevoterm.tipo.equals("int")) {
                        nuevoterm.trad = " itor(" + nuevoterm.trad + ")";
                    }
                    //$trad = $trad + " " + $trad + " " + nuevoterm.trad;
                }
            }
            //$trad = $trad;
            //$trad = "";
            tipoanterior = $tipo;
            $tipo = "NOTIPO";
		}
	)* {$tipo = tipoanterior;};

term [String prefijo] returns [String trad, String tipo]
	:	primerfactor = factor[$prefijo]	
		{
			$trad = $primerfactor.trad;
			//String $trad = null;
			String $tipo = "NOTIPO";
			String tipoanterior = $primerfactor.tipo;
		}
	(MULOP
		{
			String mulop = $MULOP.text;
	        if (mulop.equals("div")) {
	            mulop = "/i";
	            //$trad = mulop;
	            $tipo = "int";
	        } else if (mulop.equals("/")) {
	            mulop = "/r";
				//$trad = mulop;	
	            $tipo = "float64";
	        } else {
	            //$trad = mulop;
	        }
		}
	nuevofactor = factor[$prefijo]
		{
			if ($tipo.equals("NOTIPO")) {
                if (tipoanterior.equals("int") && $siguiente.tipo.equals("int")) {
                    //$trad = $trad + " " + $trad + "i" + " " + nuevofactor.trad;
                    $tipo = "int";
                } else if (tipoanterior.equals("int")) { // $siguiente.tipo.equals("float64")
                    $trad = " itor(" + $trad + ")";
                    //$trad = $trad + " " + $trad + "r" + " " + nuevofactor.trad;
                    $tipo = "float64";
                } else if ($siguiente.tipo.equals("int")) { // primerfactor.tipo.equals("float64")
                    //$trad = $trad + " " + $trad + "r" + " itor(" + nuevofactor.trad + ")";
                    $tipo = "float64";
                } else { // factor.tipo.equals("float64") && primerfactor.tipo.equals("float64")
                    //$trad = $trad + " " + $trad + "r" + " " + nuevofactor.trad;
                    $tipo = "float64";
                }
            } else {
                if ($tipo.equals("int")) {
                    if (tipoanterior.equals("float64") || $siguiente.tipo.equals("float64")) {
                        throw new Sem_DivDebeSerEntero($MULOP.line, $MULOP.pos);
                    } else {
                        //$trad = $trad + " " + $trad + " " + nuevofactor.trad;
                    }
                } else {
                    if (tipoanterior.equals("int")) {
                        $trad = " itor(" + $trad + ")";
                    }
                    if ($siguiente.tipo.equals("int")) {
                        nuevofactor.trad = " itor(" + nuevofactor.trad + ")";
                    }
                    //$trad = $trad + " " + $trad + " " + nuevofactor.trad;
                }
            }
            //$trad = $trad;
            //$trad = "";
            tipoanterior = $tipo;
            $tipo = "NOTIPO";
		}
	)* {$tipo = tipoanterior;};

factor [String prefijo] returns [String trad, String tipo]
	:	ID
		{
			String nombre;
            try {
                Simbolo simb = tS.getSimbolo($ID.text);
                $tipo = simb.tipo;
                nombre = simb.nombre_completo;
                if ($tipo.equals("funcion")) {
                    throw new Sem_NoVar($ID.text, $ID.line, $ID.pos);
                }
                $trad = nombre;
            } catch (Sem_LexNoDefinido ex) {
                ex.fila = $ID.line;
                ex.columna = $ID.pos;
                throw ex;
            }
		}
	|	NENTERO{$trad = $NENTERO.text; $tipo = "int";}
	|	NREAL{$trad = $NREAL.text; $tipo = "float64";}
	|	PARI expr[$prefijo] PARD {$trad = "(" + $expr.trad + ")"; $tipo = $expr.tipo;};
*/

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
			$resultado = new Tipo($tipo,0,null);
		       } 
		       (CORI 
		       {
		       	$resultado = new Tipo("array",0,$resultado);
		       }
		       (COMA
		       {
		       	$resultado = new Tipo("array",0,$resultado);
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
	:	bloque{$trad = "{\n"+$bloque.trad+";}";}
	|	IF PARI expr PARD instr (ELSE instr)? {$trad = "instr";}
	|	WHILE PARI expr PARD instr{$trad = "instr";}
	|	FOREACH PARI VAR ID IN ID PARD instr{$trad = "instr";}
	|	FOR PARI INT ID ASIG expr TO expr STEP (ADDOP)? ENTERO PARD instr{$trad = "instr";}
	|	BREAK PYC{$trad = "instr";}
	|	CONTINUE PYC{$trad = "instr";}
	|	ref cambio[$ref.variable]{$trad = $cambio.trad;}
	|	ID ASIG NEW tipoSimple CORI dims CORD PYC{$trad = "instr";}
	|	WRITELINE PARI expr PARD PYC{
			$trad = $expr.trad;
			String aux = $expr.tipo;
			/*if(aux.equals("bool"))
				aux = "int32";*/
			$trad += "call void [mscorlib]System.Console::WriteLine(" + aux + ")\n";
		};

dims returns [String trad]
	:	ENTERO (COMA ENTERO)*;

cambio[int variable] returns [String trad]
	:	ASIG expr PYC{$trad = $expr.trad + "stloc " + $variable + "\n";}
	|	PUNTO READLINEI PYC{$trad = "call string [mscorlib]System.Console::ReadLine()\n" + "call int32 [mscorlib]System.Int32::Parse(string)\n"+ "stloc " + $variable +  "\n";}
	|	PUNTO READLINED PYC{$trad = "call string [mscorlib]System.Console::ReadLine()\n" + "call float64 [mscorlib]System.Double::Parse(string)\n"+ "stloc " + $variable +  "\n";}
	|	PUNTO READLINEB PYC{$trad = "call string [mscorlib]System.Console::ReadLine()\n" + "call bool [mscorlib]System.Boolean::Parse(string)\n"+ "stloc " + $variable +  "\n";};

expr returns [String trad, String tipo]
	:	primero = eand 
		{
			$trad = $primero.trad; 
			$tipo = $primero.tipo;
		}
		(OR 
		{
			if(!$tipo.equals("bool")){
				throw new  Sem_DebeSerBool($OR.text,$OR.line,$OR.pos);
			}
		}
		siguiente = eand
		{
			$trad += $siguiente.trad;
			$tipo = "bool";
			if(!$siguiente.tipo.equals("bool")){
				throw new  Sem_DebeSerBool($OR.text,$OR.line,$OR.pos);
			}
			$trad += "or\n";
		}
		)*;

eand returns [String trad, String tipo]
	:	primero = erel 
		{
			$trad = $primero.trad; 
			$tipo = $primero.tipo;
		}
		(AND 
		{
			if(!$tipo.equals("bool")){
				throw new  Sem_DebeSerBool($AND.text,$AND.line,$AND.pos);
			}
		}
		siguiente = erel
		{
			$trad += $siguiente.trad;
			$tipo = "bool";
			if(!$siguiente.tipo.equals("bool")){
				throw new  Sem_DebeSerBool($AND.text,$AND.line,$AND.pos);
			}
			$trad += "and\n";
		}
		)*;

erel returns [String trad, String tipo]
	:	primero = esum 
		{
			$trad = $primero.trad; 
			$tipo = $primero.tipo;
		}
		(RELOP siguiente = esum
		{
			$trad += $siguiente.trad;$tipo = "bool";
			if($RELOP.text.equals("==")){
			    $trad += "ceq\n";
			}else if($RELOP.text.equals("!=")){
			    $trad += "ceq\n" + "ldc.i4 1\n" + "xor\n";
			}else if($RELOP.text.equals("<")){
			    $trad += "sub\n" + "ldc.i4 0\n" + "clt\n";
			}else if($RELOP.text.equals(">")){
			    $trad += "sub\n" + "ldc.i4 0\n" + "cgt\n";
			}else if($RELOP.text.equals("<=")){
			    $trad += "sub\n" + "dup\n" + "stloc 0\n" + "ldc.i4 0\n" + "clt\n" + "ldloc 0\n" + "ldc.i4 0\n" + "ceq\n" + "or\n";
			}else if($RELOP.text.equals(">=")){
			    $trad += "sub\n" + "dup\n" + "stloc 0\n" + "ldc.i4 0\n" + "cgt\n" + "ldloc 0\n" + "ldc.i4 0\n" + "ceq\n" + "or\n";
			}
			
			
		})*;


esum returns [String trad, String tipo]
	:	primero = term {
			$trad = $primero.trad; 
			$tipo = $primero.tipo;
			if($tipo.equals("bool")){
			    //throw error 3
			}
		}
		(ADDOP siguiente = term
		{
			if($siguiente.tipo.equals("bool")){
			    //throw error 3
			}
			$trad += $siguiente.trad;$tipo = "int32"/*"int/real == comprobar =="*/;
			if($ADDOP.text.equals("+")){
			    $trad += "add\n";
			}else{
			    $trad += "sub\n";
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
			boolean convertirSiguiente = false;
			if ($tipo.equals("int32") && $siguiente.tipo.equals("int32")) {
				$tipo = "int32";
			} else if ($tipo.equals("int32")) { // $siguiente.tipo.equals("float64")
				$trad += "conf.r8\n";
				$tipo = "float64";
			} else if ($siguiente.tipo.equals("int32")) { // $primero.tipo.equals("float64")
				convertirSiguiente = true;
				$tipo = "float64";
			} else { // $siguiente.tipo.equals("float64") && $primero.tipo.equals("float64")
				$tipo = "float64";
			}
			$trad += $siguiente.trad;
			if(convertirSiguiente){
				$trad+= "conf.r8\n";
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
					//throw error 3
				}else{
					$trad = $otro.trad + "neg\n";
				}
			}else{
				if($otro.tipo.equals("bool")){
					//throw error 3
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
		|	ref {$trad = "ldloc " + $ref.variable + "\n"; $tipo = $ref.tipo;};

ref returns [int variable, String tipo]
	:	ID 
		{
			try{
			    Simbolo referencia = tS.getSimbolo($ID.text);
			    $variable= referencia.posicion_locals; 
			    $tipo = referencia.tipo.toString();
			}catch(Sem_LexNoDefinido e){
			    e.setFilaColumna($ID.line,$ID.pos);
			    throw e;
			}
		} 
		(CORI indices CORD{System.err.println("========== Aún no implementado ==========");})?;

indices returns [String trad]
	:	expr (COMA expr)*;

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
 