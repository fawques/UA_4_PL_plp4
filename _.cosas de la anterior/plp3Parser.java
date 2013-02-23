// $ANTLR 3.4 plp3.g 2013-02-05 13:37:26

	import java.lang.String;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class plp3Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADDOP", "ASIG", "BEGIN", "BLANCOS", "COMA", "COMENTARIO", "DO", "DOSP", "ELSE", "END", "ENDIF", "FUNCTION", "ID", "IF", "INTEGER", "MULOP", "NENTERO", "NREAL", "PARD", "PARI", "PROGRAM", "PYC", "REAL", "RELOP", "THEN", "VAR", "WHILE", "WRITELN"
    };

    public static final int EOF=-1;
    public static final int ADDOP=4;
    public static final int ASIG=5;
    public static final int BEGIN=6;
    public static final int BLANCOS=7;
    public static final int COMA=8;
    public static final int COMENTARIO=9;
    public static final int DO=10;
    public static final int DOSP=11;
    public static final int ELSE=12;
    public static final int END=13;
    public static final int ENDIF=14;
    public static final int FUNCTION=15;
    public static final int ID=16;
    public static final int IF=17;
    public static final int INTEGER=18;
    public static final int MULOP=19;
    public static final int NENTERO=20;
    public static final int NREAL=21;
    public static final int PARD=22;
    public static final int PARI=23;
    public static final int PROGRAM=24;
    public static final int PYC=25;
    public static final int REAL=26;
    public static final int RELOP=27;
    public static final int THEN=28;
    public static final int VAR=29;
    public static final int WHILE=30;
    public static final int WRITELN=31;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public plp3Parser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public plp3Parser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return plp3Parser.tokenNames; }
    public String getGrammarFileName() { return "plp3.g"; }


    	tablaSimbolos tS;
    	public void emitErrorMessage(String msg) {
    		System.err.println(msg);
    		System.exit(1);
    	}



    // $ANTLR start "s"
    // plp3.g:50:1: s returns [String resultado] : PROGRAM ID PYC vsp[\"main_\"] bloque[\"main_\"] EOF ;
    public final String s() throws RecognitionException {
        String resultado = null;


        Token ID1=null;
        String vsp2 =null;

        String bloque3 =null;


        try {
            // plp3.g:51:2: ( PROGRAM ID PYC vsp[\"main_\"] bloque[\"main_\"] EOF )
            // plp3.g:51:4: PROGRAM ID PYC vsp[\"main_\"] bloque[\"main_\"] EOF
            {
            match(input,PROGRAM,FOLLOW_PROGRAM_in_s64); 

            tS = new tablaSimbolos();

            ID1=(Token)match(input,ID,FOLLOW_ID_in_s68); 

            match(input,PYC,FOLLOW_PYC_in_s70); 

            pushFollow(FOLLOW_vsp_in_s72);
            vsp2=vsp("main_");

            state._fsp--;


            pushFollow(FOLLOW_bloque_in_s75);
            bloque3=bloque("main_");

            state._fsp--;



            	resultado = "// program " + (ID1!=null?ID1.getText():null) + "\n" + vsp2 + "int main()" + bloque3;
            	

            match(input,EOF,FOLLOW_EOF_in_s81); 

            }

        }

        	catch (RecognitionException re) {
        		reportError(re);
        		System.exit(1);
        	}catch (Exception e) {
        //		e.printStackTrace();
        		System.err.println(e);
        		System.exit(1);
        	}

        finally {
        	// do for sure before leaving
        }
        return resultado;
    }
    // $ANTLR end "s"



    // $ANTLR start "vsp"
    // plp3.g:56:1: vsp[String prefijo] returns [String trad] : ( unvsp[$prefijo] )+ ;
    public final String vsp(String prefijo) throws RecognitionException {
        String trad = null;


        String unvsp4 =null;


        try {
            // plp3.g:57:2: ( ( unvsp[$prefijo] )+ )
            // plp3.g:57:4: ( unvsp[$prefijo] )+
            {
            trad = "";

            // plp3.g:57:18: ( unvsp[$prefijo] )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==FUNCTION||LA1_0==VAR) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // plp3.g:57:20: unvsp[$prefijo]
            	    {
            	    pushFollow(FOLLOW_unvsp_in_vsp100);
            	    unvsp4=unvsp(prefijo);

            	    state._fsp--;


            	    trad += unvsp4;

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

        }

        	catch (RecognitionException re) {
        		reportError(re);
        		System.exit(1);
        	}catch (Exception e) {
        //		e.printStackTrace();
        		System.err.println(e);
        		System.exit(1);
        	}

        finally {
        	// do for sure before leaving
        }
        return trad;
    }
    // $ANTLR end "vsp"



    // $ANTLR start "unvsp"
    // plp3.g:59:1: unvsp[String prefijo] returns [String trad] : ( FUNCTION ID DOSP tipo PYC vsp[nuevoPrefijo] bloque[nuevoPrefijo] PYC | VAR ( v[$prefijo] )+ );
    public final String unvsp(String prefijo) throws RecognitionException {
        String trad = null;


        Token ID5=null;
        String vsp6 =null;

        String tipo7 =null;

        String bloque8 =null;

        String v9 =null;


        try {
            // plp3.g:60:2: ( FUNCTION ID DOSP tipo PYC vsp[nuevoPrefijo] bloque[nuevoPrefijo] PYC | VAR ( v[$prefijo] )+ )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==FUNCTION) ) {
                alt3=1;
            }
            else if ( (LA3_0==VAR) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // plp3.g:60:4: FUNCTION ID DOSP tipo PYC vsp[nuevoPrefijo] bloque[nuevoPrefijo] PYC
                    {
                    match(input,FUNCTION,FOLLOW_FUNCTION_in_unvsp121); 

                    ID5=(Token)match(input,ID,FOLLOW_ID_in_unvsp123); 


                    		String nuevoPrefijo = prefijo;
                    		try {
                    				tS.add((ID5!=null?ID5.getText():null), prefijo, "funcion");
                                } catch (Sem_LexYaExiste ex) {
                    				ex.fila = (ID5!=null?ID5.getLine():0);
                    				ex.columna = (ID5!=null?ID5.getCharPositionInLine():0);
                    				throw ex;
                                }
                            String nombre_funcion = (ID5!=null?ID5.getText():null);
                    		tS = new tablaSimbolos(tS);
                    		
                    		if (!prefijo.equals("main_")) {
                    			nombre_funcion = prefijo + (ID5!=null?ID5.getText():null);
                    			nuevoPrefijo += (ID5!=null?ID5.getText():null) + "_";
                    		} else {
                    			nuevoPrefijo = (ID5!=null?ID5.getText():null) + "_";
                    		}
                    	

                    match(input,DOSP,FOLLOW_DOSP_in_unvsp129); 

                    pushFollow(FOLLOW_tipo_in_unvsp131);
                    tipo7=tipo();

                    state._fsp--;


                    match(input,PYC,FOLLOW_PYC_in_unvsp133); 

                    pushFollow(FOLLOW_vsp_in_unvsp135);
                    vsp6=vsp(nuevoPrefijo);

                    state._fsp--;


                    pushFollow(FOLLOW_bloque_in_unvsp138);
                    bloque8=bloque(nuevoPrefijo);

                    state._fsp--;


                    match(input,PYC,FOLLOW_PYC_in_unvsp141); 


                    		tS = tS.pop();
                    		trad = vsp6 + tipo7 + " " + nombre_funcion + "()" + bloque8;
                    	

                    }
                    break;
                case 2 :
                    // plp3.g:85:4: VAR ( v[$prefijo] )+
                    {
                    match(input,VAR,FOLLOW_VAR_in_unvsp150); 

                    String aux ="";

                    // plp3.g:85:26: ( v[$prefijo] )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==ID) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // plp3.g:85:28: v[$prefijo]
                    	    {
                    	    pushFollow(FOLLOW_v_in_unvsp156);
                    	    v9=v(prefijo);

                    	    state._fsp--;


                    	    aux +=v9;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);


                    trad = aux;

                    }
                    break;

            }
        }

        	catch (RecognitionException re) {
        		reportError(re);
        		System.exit(1);
        	}catch (Exception e) {
        //		e.printStackTrace();
        		System.err.println(e);
        		System.exit(1);
        	}

        finally {
        	// do for sure before leaving
        }
        return trad;
    }
    // $ANTLR end "unvsp"



    // $ANTLR start "v"
    // plp3.g:87:1: v[String prefijo] returns [String trad] : primerID= ID ( COMA nuevoID= ID )* DOSP tipo PYC ;
    public final String v(String prefijo) throws RecognitionException {
        String trad = null;


        Token primerID=null;
        Token nuevoID=null;
        String tipo10 =null;


        try {
            // plp3.g:88:2: (primerID= ID ( COMA nuevoID= ID )* DOSP tipo PYC )
            // plp3.g:88:4: primerID= ID ( COMA nuevoID= ID )* DOSP tipo PYC
            {
            primerID=(Token)match(input,ID,FOLLOW_ID_in_v182); 


            	    String aux =prefijo + (primerID!=null?primerID.getText():null);
            	    String id = prefijo + (primerID!=null?primerID.getText():null);
                        // vamos asignando notipo para luego poner el tipo encontrado
                        ArrayList<Simbolo> variables_sin_tipo = new ArrayList<Simbolo>();
                        Simbolo simbolo = new Simbolo((primerID!=null?primerID.getText():null), id, "NOTIPO");
                        try {
                            tS.add(simbolo);
                        } catch (Sem_LexYaExiste ex) {
                            ex.fila = (primerID!=null?primerID.getLine():0);
                            ex.columna = (primerID!=null?primerID.getCharPositionInLine():0);
                            throw ex;
                        }
                        variables_sin_tipo.add(simbolo);
            	

            // plp3.g:104:2: ( COMA nuevoID= ID )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==COMA) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // plp3.g:104:4: COMA nuevoID= ID
            	    {
            	    match(input,COMA,FOLLOW_COMA_in_v191); 

            	    nuevoID=(Token)match(input,ID,FOLLOW_ID_in_v197); 


            	    		    aux += ", " + prefijo + (nuevoID!=null?nuevoID.getText():null);
            	    		    simbolo = new Simbolo((nuevoID!=null?nuevoID.getText():null), prefijo + (nuevoID!=null?nuevoID.getText():null), "NOTIPO");
            	    	            id = prefijo + (nuevoID!=null?nuevoID.getText():null);
            	    	
            	    	            try {
            	    		                tS.add(simbolo);
            	    		            } catch (Sem_LexYaExiste ex) {
            	    		                ex.fila = (nuevoID!=null?nuevoID.getLine():0);
            	    		                ex.columna = (nuevoID!=null?nuevoID.getCharPositionInLine():0);
            	    		                throw ex;
            	    		            }
            	    		
            	    	            variables_sin_tipo.add(simbolo);
            	    		

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            match(input,DOSP,FOLLOW_DOSP_in_v208); 

            pushFollow(FOLLOW_tipo_in_v210);
            tipo10=tipo();

            state._fsp--;



            	//recolocamos el tipo
                        for (Simbolo item : variables_sin_tipo) {
            	        	item.tipo = tipo10;
                        }
                        variables_sin_tipo.clear();
            	

            match(input,PYC,FOLLOW_PYC_in_v216); 

            trad = tipo10 + " " + aux + ";\n";

            }

        }

        	catch (RecognitionException re) {
        		reportError(re);
        		System.exit(1);
        	}catch (Exception e) {
        //		e.printStackTrace();
        		System.err.println(e);
        		System.exit(1);
        	}

        finally {
        	// do for sure before leaving
        }
        return trad;
    }
    // $ANTLR end "v"



    // $ANTLR start "tipo"
    // plp3.g:129:1: tipo returns [String tipo] : ( INTEGER | REAL );
    public final String tipo() throws RecognitionException {
        String tipo = null;


        try {
            // plp3.g:130:2: ( INTEGER | REAL )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==INTEGER) ) {
                alt5=1;
            }
            else if ( (LA5_0==REAL) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // plp3.g:130:4: INTEGER
                    {
                    match(input,INTEGER,FOLLOW_INTEGER_in_tipo231); 

                    tipo = "int";

                    }
                    break;
                case 2 :
                    // plp3.g:131:4: REAL
                    {
                    match(input,REAL,FOLLOW_REAL_in_tipo238); 

                    tipo = "double";

                    }
                    break;

            }
        }

        	catch (RecognitionException re) {
        		reportError(re);
        		System.exit(1);
        	}catch (Exception e) {
        //		e.printStackTrace();
        		System.err.println(e);
        		System.exit(1);
        	}

        finally {
        	// do for sure before leaving
        }
        return tipo;
    }
    // $ANTLR end "tipo"



    // $ANTLR start "bloque"
    // plp3.g:133:1: bloque[String prefijo] returns [String trad] : BEGIN sinstr[$prefijo] END ;
    public final String bloque(String prefijo) throws RecognitionException {
        String trad = null;


        String sinstr11 =null;


        try {
            // plp3.g:134:2: ( BEGIN sinstr[$prefijo] END )
            // plp3.g:134:4: BEGIN sinstr[$prefijo] END
            {
            match(input,BEGIN,FOLLOW_BEGIN_in_bloque255); 

            pushFollow(FOLLOW_sinstr_in_bloque257);
            sinstr11=sinstr(prefijo);

            state._fsp--;


            match(input,END,FOLLOW_END_in_bloque260); 

            trad = "{\n" + sinstr11 + "\n}\n";

            }

        }

        	catch (RecognitionException re) {
        		reportError(re);
        		System.exit(1);
        	}catch (Exception e) {
        //		e.printStackTrace();
        		System.err.println(e);
        		System.exit(1);
        	}

        finally {
        	// do for sure before leaving
        }
        return trad;
    }
    // $ANTLR end "bloque"



    // $ANTLR start "sinstr"
    // plp3.g:136:1: sinstr[String prefijo] returns [String trad] : primerinstr= instr[$prefijo] ( PYC nuevoinstr= instr[$prefijo] )* ;
    public final String sinstr(String prefijo) throws RecognitionException {
        String trad = null;


        String primerinstr =null;

        String nuevoinstr =null;


        try {
            // plp3.g:137:3: (primerinstr= instr[$prefijo] ( PYC nuevoinstr= instr[$prefijo] )* )
            // plp3.g:137:5: primerinstr= instr[$prefijo] ( PYC nuevoinstr= instr[$prefijo] )*
            {
            pushFollow(FOLLOW_instr_in_sinstr283);
            primerinstr=instr(prefijo);

            state._fsp--;


            String aux =primerinstr;

            // plp3.g:137:68: ( PYC nuevoinstr= instr[$prefijo] )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==PYC) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // plp3.g:137:69: PYC nuevoinstr= instr[$prefijo]
            	    {
            	    match(input,PYC,FOLLOW_PYC_in_sinstr289); 

            	    pushFollow(FOLLOW_instr_in_sinstr295);
            	    nuevoinstr=instr(prefijo);

            	    state._fsp--;


            	    aux += "\n" + nuevoinstr;

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            trad = aux; 

            }

        }

        	catch (RecognitionException re) {
        		reportError(re);
        		System.exit(1);
        	}catch (Exception e) {
        //		e.printStackTrace();
        		System.err.println(e);
        		System.exit(1);
        	}

        finally {
        	// do for sure before leaving
        }
        return trad;
    }
    // $ANTLR end "sinstr"



    // $ANTLR start "instr"
    // plp3.g:139:1: instr[String prefijo] returns [String trad] : ( bloque[$prefijo] | ID ASIG e[$prefijo] | IF e[$prefijo] THEN primerinstr= instr[$prefijo] ( ELSE nuevoinstr= instr[$prefijo] )? ENDIF | WHILE e[$prefijo] DO primerinstr= instr[$prefijo] | WRITELN PARI e[$prefijo] PARD );
    public final String instr(String prefijo) throws RecognitionException {
        String trad = null;


        Token ID13=null;
        Token ASIG15=null;
        Token IF17=null;
        Token ELSE18=null;
        Token WHILE20=null;
        Token WRITELN22=null;
        String primerinstr =null;

        String nuevoinstr =null;

        String bloque12 =null;

        plp3Parser.e_return e14 =null;

        plp3Parser.e_return e16 =null;

        plp3Parser.e_return e19 =null;

        plp3Parser.e_return e21 =null;


        try {
            // plp3.g:140:2: ( bloque[$prefijo] | ID ASIG e[$prefijo] | IF e[$prefijo] THEN primerinstr= instr[$prefijo] ( ELSE nuevoinstr= instr[$prefijo] )? ENDIF | WHILE e[$prefijo] DO primerinstr= instr[$prefijo] | WRITELN PARI e[$prefijo] PARD )
            int alt8=5;
            switch ( input.LA(1) ) {
            case BEGIN:
                {
                alt8=1;
                }
                break;
            case ID:
                {
                alt8=2;
                }
                break;
            case IF:
                {
                alt8=3;
                }
                break;
            case WHILE:
                {
                alt8=4;
                }
                break;
            case WRITELN:
                {
                alt8=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }

            switch (alt8) {
                case 1 :
                    // plp3.g:140:4: bloque[$prefijo]
                    {
                    pushFollow(FOLLOW_bloque_in_instr317);
                    bloque12=bloque(prefijo);

                    state._fsp--;


                    trad = bloque12;

                    }
                    break;
                case 2 :
                    // plp3.g:141:4: ID ASIG e[$prefijo]
                    {
                    ID13=(Token)match(input,ID,FOLLOW_ID_in_instr325); 


                    		Simbolo simb;
                    		String tipo;
                            try {
                                simb = tS.getSimbolo((ID13!=null?ID13.getText():null));
                    //            tipo = simb.tipo;
                                if (simb.tipo.equals("funcion")) {
                                    throw new Sem_NoVar((ID13!=null?ID13.getText():null), (ID13!=null?ID13.getLine():0), (ID13!=null?ID13.getCharPositionInLine():0));
                                }
                                        } catch (Sem_LexNoDefinido ex) {
                                ex.fila = (ID13!=null?ID13.getLine():0);
                    			ex.columna = (ID13!=null?ID13.getCharPositionInLine():0);
                                throw ex;
                            }
                    	

                    ASIG15=(Token)match(input,ASIG,FOLLOW_ASIG_in_instr332); 

                    pushFollow(FOLLOW_e_in_instr334);
                    e14=e(prefijo);

                    state._fsp--;



                    		trad = simb.nombre_completo + " =";
                    		if ((e14!=null?e14.tipo:null).equals("bool")) {
                                    throw new Sem_AsigNoBool((ASIG15!=null?ASIG15.getLine():0), (ASIG15!=null?ASIG15.getCharPositionInLine():0));
                            } else if (simb.tipo.equals("double")) {
                                trad += "r ";
                                if ((e14!=null?e14.tipo:null).equals("int")) {
                                    trad += "itor(" + (e14!=null?e14.trad:null) + ");";
                                } else {
                                    trad += (e14!=null?e14.trad:null) + ";";
                                }
                            } else if (simb.tipo.equals("int")) {
                                trad += "i " + (e14!=null?e14.trad:null) + ";";
                                if ((e14!=null?e14.tipo:null).equals("double")) {
                                    throw new Sem_DebeSerReal((ID13!=null?ID13.getText():null), (ID13!=null?ID13.getLine():0), (ID13!=null?ID13.getCharPositionInLine():0));
                                }
                            }
                    	

                    }
                    break;
                case 3 :
                    // plp3.g:176:4: IF e[$prefijo] THEN primerinstr= instr[$prefijo] ( ELSE nuevoinstr= instr[$prefijo] )? ENDIF
                    {
                    IF17=(Token)match(input,IF,FOLLOW_IF_in_instr344); 

                    pushFollow(FOLLOW_e_in_instr346);
                    e16=e(prefijo);

                    state._fsp--;



                    			if (!"bool".equals((e16!=null?e16.tipo:null))) {
                    	            throw new Sem_DebeSerBool("if", (IF17!=null?IF17.getLine():0), (IF17!=null?IF17.getCharPositionInLine():0));
                    	        }
                    	    

                    match(input,THEN,FOLLOW_THEN_in_instr358); 

                    pushFollow(FOLLOW_instr_in_instr364);
                    primerinstr=instr(prefijo);

                    state._fsp--;



                        		trad = "if(" + (e16!=null?e16.trad:null) + ")\n" + primerinstr;
                        	

                    // plp3.g:186:5: ( ELSE nuevoinstr= instr[$prefijo] )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==ELSE) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // plp3.g:186:6: ELSE nuevoinstr= instr[$prefijo]
                            {
                            ELSE18=(Token)match(input,ELSE,FOLLOW_ELSE_in_instr380); 

                            pushFollow(FOLLOW_instr_in_instr386);
                            nuevoinstr=instr(prefijo);

                            state._fsp--;



                            	    	trad += "\n" + (ELSE18!=null?ELSE18.getText():null) + "\n" + nuevoinstr;
                            	    

                            }
                            break;

                    }


                    match(input,ENDIF,FOLLOW_ENDIF_in_instr403); 

                    }
                    break;
                case 4 :
                    // plp3.g:191:4: WHILE e[$prefijo] DO primerinstr= instr[$prefijo]
                    {
                    WHILE20=(Token)match(input,WHILE,FOLLOW_WHILE_in_instr408); 

                    pushFollow(FOLLOW_e_in_instr410);
                    e19=e(prefijo);

                    state._fsp--;



                    			if (!"bool".equals((e19!=null?e19.tipo:null))) {
                    	            throw new Sem_DebeSerBool("while", (WHILE20!=null?WHILE20.getLine():0), (WHILE20!=null?WHILE20.getCharPositionInLine():0));
                    	        }
                    	    

                    match(input,DO,FOLLOW_DO_in_instr421); 

                    pushFollow(FOLLOW_instr_in_instr427);
                    primerinstr=instr(prefijo);

                    state._fsp--;



                        		trad = "while(" + (e19!=null?e19.trad:null) + ")\n" + primerinstr;
                        	

                    }
                    break;
                case 5 :
                    // plp3.g:201:7: WRITELN PARI e[$prefijo] PARD
                    {
                    WRITELN22=(Token)match(input,WRITELN,FOLLOW_WRITELN_in_instr443); 

                    match(input,PARI,FOLLOW_PARI_in_instr445); 

                    pushFollow(FOLLOW_e_in_instr447);
                    e21=e(prefijo);

                    state._fsp--;



                    			if ("bool".equals((e21!=null?e21.tipo:null))) {
                    				throw new Sem_WritelnNoBool((WRITELN22!=null?WRITELN22.getLine():0), (WRITELN22!=null?WRITELN22.getCharPositionInLine():0));
                    	        }
                    	    

                    match(input,PARD,FOLLOW_PARD_in_instr456); 


                    			String aux;
                    	        if ((e21!=null?e21.tipo:null).equals("double")) {
                    	            aux = "%g";
                    	        } else {
                    	            aux = "%d";
                    	        }
                    			trad = "printf(\"" + aux + "\\n\"," + (e21!=null?e21.trad:null) + ");";
                    		

                    }
                    break;

            }
        }

        	catch (RecognitionException re) {
        		reportError(re);
        		System.exit(1);
        	}catch (Exception e) {
        //		e.printStackTrace();
        		System.err.println(e);
        		System.exit(1);
        	}

        finally {
        	// do for sure before leaving
        }
        return trad;
    }
    // $ANTLR end "instr"


    public static class e_return extends ParserRuleReturnScope {
        public String trad;
        public String tipo;
    };


    // $ANTLR start "e"
    // plp3.g:218:1: e[String prefijo] returns [String trad, String tipo] : primerexpr= expr[$prefijo] ( RELOP nuevoexpr= expr[$prefijo] )? ;
    public final plp3Parser.e_return e(String prefijo) throws RecognitionException {
        plp3Parser.e_return retval = new plp3Parser.e_return();
        retval.start = input.LT(1);


        Token RELOP23=null;
        plp3Parser.expr_return primerexpr =null;

        plp3Parser.expr_return nuevoexpr =null;


        try {
            // plp3.g:219:2: (primerexpr= expr[$prefijo] ( RELOP nuevoexpr= expr[$prefijo] )? )
            // plp3.g:219:4: primerexpr= expr[$prefijo] ( RELOP nuevoexpr= expr[$prefijo] )?
            {
            pushFollow(FOLLOW_expr_in_e479);
            primerexpr=expr(prefijo);

            state._fsp--;



            			retval.tipo = (primerexpr!=null?primerexpr.tipo:null);
            			retval.trad = (primerexpr!=null?primerexpr.trad:null);
            			String primertrad = retval.trad;
            		

            // plp3.g:225:2: ( RELOP nuevoexpr= expr[$prefijo] )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RELOP) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // plp3.g:225:3: RELOP nuevoexpr= expr[$prefijo]
                    {
                    RELOP23=(Token)match(input,RELOP,FOLLOW_RELOP_in_e488); 

                    pushFollow(FOLLOW_expr_in_e494);
                    nuevoexpr=expr(prefijo);

                    state._fsp--;



                    			String nuevotrad = (nuevoexpr!=null?nuevoexpr.trad:null);
                    			String relop = (RELOP23!=null?RELOP23.getText():null);
                    			if (relop.equals("<>")) {
                                    relop = "!=";
                                } else if (relop.equals("=")) {
                                    relop = "==";
                                }

                                if (primerexpr.tipo.equals("double")) {
                                    relop += "r";
                                    if ((nuevoexpr!=null?nuevoexpr.tipo:null).equals("int")) {
                                       nuevotrad  = "itor(" + nuevotrad + ")";
                                    }
                                } else if ((nuevoexpr!=null?nuevoexpr.tipo:null).equals("double")) {
                                    relop += "r";
                                    primertrad = "itor(" + primertrad + ")";
                                } else {
                                    relop += "i";
                                }

                                retval.trad = primertrad + " " + relop + " " + nuevotrad;
                                retval.tipo = "bool";
                    		

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


        }

        	catch (RecognitionException re) {
        		reportError(re);
        		System.exit(1);
        	}catch (Exception e) {
        //		e.printStackTrace();
        		System.err.println(e);
        		System.exit(1);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "e"


    public static class expr_return extends ParserRuleReturnScope {
        public String trad;
        public String tipo;
    };


    // $ANTLR start "expr"
    // plp3.g:252:1: expr[String prefijo] returns [String trad, String tipo] : primerterm= term[$prefijo] ( ADDOP nuevoterm= term[$prefijo] )* ;
    public final plp3Parser.expr_return expr(String prefijo) throws RecognitionException {
        plp3Parser.expr_return retval = new plp3Parser.expr_return();
        retval.start = input.LT(1);


        Token ADDOP24=null;
        plp3Parser.term_return primerterm =null;

        plp3Parser.term_return nuevoterm =null;


        try {
            // plp3.g:253:2: (primerterm= term[$prefijo] ( ADDOP nuevoterm= term[$prefijo] )* )
            // plp3.g:253:4: primerterm= term[$prefijo] ( ADDOP nuevoterm= term[$prefijo] )*
            {
            pushFollow(FOLLOW_term_in_expr523);
            primerterm=term(prefijo);

            state._fsp--;



            			retval.trad = (primerterm!=null?primerterm.trad:null);
            			String nuevatrad = null;
            			String nuevotipo = "NOTIPO";
            			String tipoanterior = (primerterm!=null?primerterm.tipo:null);
            		

            // plp3.g:260:2: ( ADDOP nuevoterm= term[$prefijo] )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==ADDOP) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // plp3.g:260:3: ADDOP nuevoterm= term[$prefijo]
            	    {
            	    ADDOP24=(Token)match(input,ADDOP,FOLLOW_ADDOP_in_expr532); 


            	    			String addop = (ADDOP24!=null?ADDOP24.getText():null);
            	    	        if (addop.equals("div")) {
            	    	            addop = "/i";
            	    	            nuevatrad = addop;
            	    	            nuevotipo = "int";
            	    	        } else if (addop.equals("/")) {
            	    	            addop = "/r";
            	    				nuevatrad = addop;	
            	    	            nuevotipo = "double";
            	    	        } else {
            	    	            nuevatrad = addop;
            	    	        }
            	    		

            	    pushFollow(FOLLOW_term_in_expr544);
            	    nuevoterm=term(prefijo);

            	    state._fsp--;



            	    			if (nuevotipo.equals("NOTIPO")) {
            	                    if (tipoanterior.equals("int") && nuevoterm.tipo.equals("int")) {
            	                        nuevatrad = retval.trad + " " + nuevatrad + "i" + " " + nuevoterm.trad;
            	                        nuevotipo = "int";
            	                    } else if (tipoanterior.equals("int")) { // nuevoterm.tipo.equals("double")
            	                        retval.trad = " itor(" + retval.trad + ")";
            	                        nuevatrad = retval.trad + " " + nuevatrad + "r" + " " + nuevoterm.trad;
            	                        nuevotipo = "double";
            	                    } else if (nuevoterm.tipo.equals("int")) { // primerfactor.tipo.equals("double")
            	                        nuevatrad = retval.trad + " " + nuevatrad + "r" + " itor(" + nuevoterm.trad + ")";
            	                        nuevotipo = "double";
            	                    } else { // factor.tipo.equals("double") && primerfactor.tipo.equals("double")
            	                        nuevatrad = retval.trad + " " + nuevatrad + "r" + " " + nuevoterm.trad;
            	                        nuevotipo = "double";
            	                    }
            	                } else {
            	                    if (nuevotipo.equals("int")) {
            	                        if (tipoanterior.equals("double") || nuevoterm.tipo.equals("double")) {
            	                            throw new Sem_DivDebeSerEntero((ADDOP24!=null?ADDOP24.getLine():0), (ADDOP24!=null?ADDOP24.getCharPositionInLine():0));
            	                        } else {
            	                            nuevatrad = retval.trad + " " + nuevatrad + " " + nuevoterm.trad;
            	                        }
            	                    } else {
            	                        if (tipoanterior.equals("int")) {
            	                            retval.trad = " itor(" + retval.trad + ")";
            	                        }
            	                        if (nuevoterm.tipo.equals("int")) {
            	                            nuevoterm.trad = " itor(" + nuevoterm.trad + ")";
            	                        }
            	                        nuevatrad = retval.trad + " " + nuevatrad + " " + nuevoterm.trad;
            	                    }
            	                }
            	                retval.trad = nuevatrad;
            	                nuevatrad = "";
            	                tipoanterior = nuevotipo;
            	                nuevotipo = "NOTIPO";
            	    		

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            retval.tipo = tipoanterior;

            }

            retval.stop = input.LT(-1);


        }

        	catch (RecognitionException re) {
        		reportError(re);
        		System.exit(1);
        	}catch (Exception e) {
        //		e.printStackTrace();
        		System.err.println(e);
        		System.exit(1);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expr"


    public static class term_return extends ParserRuleReturnScope {
        public String trad;
        public String tipo;
    };


    // $ANTLR start "term"
    // plp3.g:316:1: term[String prefijo] returns [String trad, String tipo] : primerfactor= factor[$prefijo] ( MULOP nuevofactor= factor[$prefijo] )* ;
    public final plp3Parser.term_return term(String prefijo) throws RecognitionException {
        plp3Parser.term_return retval = new plp3Parser.term_return();
        retval.start = input.LT(1);


        Token MULOP25=null;
        plp3Parser.factor_return primerfactor =null;

        plp3Parser.factor_return nuevofactor =null;


        try {
            // plp3.g:317:2: (primerfactor= factor[$prefijo] ( MULOP nuevofactor= factor[$prefijo] )* )
            // plp3.g:317:4: primerfactor= factor[$prefijo] ( MULOP nuevofactor= factor[$prefijo] )*
            {
            pushFollow(FOLLOW_factor_in_term574);
            primerfactor=factor(prefijo);

            state._fsp--;



            			retval.trad = (primerfactor!=null?primerfactor.trad:null);
            			String nuevatrad = null;
            			String nuevotipo = "NOTIPO";
            			String tipoanterior = (primerfactor!=null?primerfactor.tipo:null);
            		

            // plp3.g:324:2: ( MULOP nuevofactor= factor[$prefijo] )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==MULOP) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // plp3.g:324:3: MULOP nuevofactor= factor[$prefijo]
            	    {
            	    MULOP25=(Token)match(input,MULOP,FOLLOW_MULOP_in_term584); 


            	    			String mulop = (MULOP25!=null?MULOP25.getText():null);
            	    	        if (mulop.equals("div")) {
            	    	            mulop = "/i";
            	    	            nuevatrad = mulop;
            	    	            nuevotipo = "int";
            	    	        } else if (mulop.equals("/")) {
            	    	            mulop = "/r";
            	    				nuevatrad = mulop;	
            	    	            nuevotipo = "double";
            	    	        } else {
            	    	            nuevatrad = mulop;
            	    	        }
            	    		

            	    pushFollow(FOLLOW_factor_in_term595);
            	    nuevofactor=factor(prefijo);

            	    state._fsp--;



            	    			if (nuevotipo.equals("NOTIPO")) {
            	                    if (tipoanterior.equals("int") && nuevofactor.tipo.equals("int")) {
            	                        nuevatrad = retval.trad + " " + nuevatrad + "i" + " " + nuevofactor.trad;
            	                        nuevotipo = "int";
            	                    } else if (tipoanterior.equals("int")) { // nuevofactor.tipo.equals("double")
            	                        retval.trad = " itor(" + retval.trad + ")";
            	                        nuevatrad = retval.trad + " " + nuevatrad + "r" + " " + nuevofactor.trad;
            	                        nuevotipo = "double";
            	                    } else if (nuevofactor.tipo.equals("int")) { // primerfactor.tipo.equals("double")
            	                        nuevatrad = retval.trad + " " + nuevatrad + "r" + " itor(" + nuevofactor.trad + ")";
            	                        nuevotipo = "double";
            	                    } else { // factor.tipo.equals("double") && primerfactor.tipo.equals("double")
            	                        nuevatrad = retval.trad + " " + nuevatrad + "r" + " " + nuevofactor.trad;
            	                        nuevotipo = "double";
            	                    }
            	                } else {
            	                    if (nuevotipo.equals("int")) {
            	                        if (tipoanterior.equals("double") || nuevofactor.tipo.equals("double")) {
            	                            throw new Sem_DivDebeSerEntero((MULOP25!=null?MULOP25.getLine():0), (MULOP25!=null?MULOP25.getCharPositionInLine():0));
            	                        } else {
            	                            nuevatrad = retval.trad + " " + nuevatrad + " " + nuevofactor.trad;
            	                        }
            	                    } else {
            	                        if (tipoanterior.equals("int")) {
            	                            retval.trad = " itor(" + retval.trad + ")";
            	                        }
            	                        if (nuevofactor.tipo.equals("int")) {
            	                            nuevofactor.trad = " itor(" + nuevofactor.trad + ")";
            	                        }
            	                        nuevatrad = retval.trad + " " + nuevatrad + " " + nuevofactor.trad;
            	                    }
            	                }
            	                retval.trad = nuevatrad;
            	                nuevatrad = "";
            	                tipoanterior = nuevotipo;
            	                nuevotipo = "NOTIPO";
            	    		

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            retval.tipo = tipoanterior;

            }

            retval.stop = input.LT(-1);


        }

        	catch (RecognitionException re) {
        		reportError(re);
        		System.exit(1);
        	}catch (Exception e) {
        //		e.printStackTrace();
        		System.err.println(e);
        		System.exit(1);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "term"


    public static class factor_return extends ParserRuleReturnScope {
        public String trad;
        public String tipo;
    };


    // $ANTLR start "factor"
    // plp3.g:380:1: factor[String prefijo] returns [String trad, String tipo] : ( ID | NENTERO | NREAL | PARI expr[$prefijo] PARD );
    public final plp3Parser.factor_return factor(String prefijo) throws RecognitionException {
        plp3Parser.factor_return retval = new plp3Parser.factor_return();
        retval.start = input.LT(1);


        Token ID26=null;
        Token NENTERO27=null;
        Token NREAL28=null;
        plp3Parser.expr_return expr29 =null;


        try {
            // plp3.g:381:2: ( ID | NENTERO | NREAL | PARI expr[$prefijo] PARD )
            int alt12=4;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt12=1;
                }
                break;
            case NENTERO:
                {
                alt12=2;
                }
                break;
            case NREAL:
                {
                alt12=3;
                }
                break;
            case PARI:
                {
                alt12=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }

            switch (alt12) {
                case 1 :
                    // plp3.g:381:4: ID
                    {
                    ID26=(Token)match(input,ID,FOLLOW_ID_in_factor621); 


                    			String nombre;
                                try {
                                    Simbolo simb = tS.getSimbolo((ID26!=null?ID26.getText():null));
                                    retval.tipo = simb.tipo;
                                    nombre = simb.nombre_completo;
                                    if (retval.tipo.equals("funcion")) {
                                        throw new Sem_NoVar((ID26!=null?ID26.getText():null), (ID26!=null?ID26.getLine():0), (ID26!=null?ID26.getCharPositionInLine():0));
                                    }
                                    retval.trad = nombre;
                                } catch (Sem_LexNoDefinido ex) {
                                    ex.fila = (ID26!=null?ID26.getLine():0);
                                    ex.columna = (ID26!=null?ID26.getCharPositionInLine():0);
                                    throw ex;
                                }
                    		

                    }
                    break;
                case 2 :
                    // plp3.g:398:4: NENTERO
                    {
                    NENTERO27=(Token)match(input,NENTERO,FOLLOW_NENTERO_in_factor630); 

                    retval.trad = (NENTERO27!=null?NENTERO27.getText():null); retval.tipo = "int";

                    }
                    break;
                case 3 :
                    // plp3.g:399:4: NREAL
                    {
                    NREAL28=(Token)match(input,NREAL,FOLLOW_NREAL_in_factor636); 

                    retval.trad = (NREAL28!=null?NREAL28.getText():null); retval.tipo = "double";

                    }
                    break;
                case 4 :
                    // plp3.g:400:4: PARI expr[$prefijo] PARD
                    {
                    match(input,PARI,FOLLOW_PARI_in_factor642); 

                    pushFollow(FOLLOW_expr_in_factor644);
                    expr29=expr(prefijo);

                    state._fsp--;


                    match(input,PARD,FOLLOW_PARD_in_factor647); 

                    retval.trad = "(" + (expr29!=null?expr29.trad:null) + ")"; retval.tipo = (expr29!=null?expr29.tipo:null);

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }

        	catch (RecognitionException re) {
        		reportError(re);
        		System.exit(1);
        	}catch (Exception e) {
        //		e.printStackTrace();
        		System.err.println(e);
        		System.exit(1);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "factor"

    // Delegated rules


 

    public static final BitSet FOLLOW_PROGRAM_in_s64 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ID_in_s68 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_PYC_in_s70 = new BitSet(new long[]{0x0000000020008000L});
    public static final BitSet FOLLOW_vsp_in_s72 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_bloque_in_s75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_s81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unvsp_in_vsp100 = new BitSet(new long[]{0x0000000020008002L});
    public static final BitSet FOLLOW_FUNCTION_in_unvsp121 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ID_in_unvsp123 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_DOSP_in_unvsp129 = new BitSet(new long[]{0x0000000004040000L});
    public static final BitSet FOLLOW_tipo_in_unvsp131 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_PYC_in_unvsp133 = new BitSet(new long[]{0x0000000020008000L});
    public static final BitSet FOLLOW_vsp_in_unvsp135 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_bloque_in_unvsp138 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_PYC_in_unvsp141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_unvsp150 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_v_in_unvsp156 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ID_in_v182 = new BitSet(new long[]{0x0000000000000900L});
    public static final BitSet FOLLOW_COMA_in_v191 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ID_in_v197 = new BitSet(new long[]{0x0000000000000900L});
    public static final BitSet FOLLOW_DOSP_in_v208 = new BitSet(new long[]{0x0000000004040000L});
    public static final BitSet FOLLOW_tipo_in_v210 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_PYC_in_v216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_tipo231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REAL_in_tipo238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BEGIN_in_bloque255 = new BitSet(new long[]{0x00000000C0030040L});
    public static final BitSet FOLLOW_sinstr_in_bloque257 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_END_in_bloque260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instr_in_sinstr283 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_PYC_in_sinstr289 = new BitSet(new long[]{0x00000000C0030040L});
    public static final BitSet FOLLOW_instr_in_sinstr295 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_bloque_in_instr317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_instr325 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ASIG_in_instr332 = new BitSet(new long[]{0x0000000000B10000L});
    public static final BitSet FOLLOW_e_in_instr334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_instr344 = new BitSet(new long[]{0x0000000000B10000L});
    public static final BitSet FOLLOW_e_in_instr346 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_THEN_in_instr358 = new BitSet(new long[]{0x00000000C0030040L});
    public static final BitSet FOLLOW_instr_in_instr364 = new BitSet(new long[]{0x0000000000005000L});
    public static final BitSet FOLLOW_ELSE_in_instr380 = new BitSet(new long[]{0x00000000C0030040L});
    public static final BitSet FOLLOW_instr_in_instr386 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ENDIF_in_instr403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_instr408 = new BitSet(new long[]{0x0000000000B10000L});
    public static final BitSet FOLLOW_e_in_instr410 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_DO_in_instr421 = new BitSet(new long[]{0x00000000C0030040L});
    public static final BitSet FOLLOW_instr_in_instr427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WRITELN_in_instr443 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_PARI_in_instr445 = new BitSet(new long[]{0x0000000000B10000L});
    public static final BitSet FOLLOW_e_in_instr447 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_PARD_in_instr456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_e479 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_RELOP_in_e488 = new BitSet(new long[]{0x0000000000B10000L});
    public static final BitSet FOLLOW_expr_in_e494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_expr523 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ADDOP_in_expr532 = new BitSet(new long[]{0x0000000000B10000L});
    public static final BitSet FOLLOW_term_in_expr544 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_factor_in_term574 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_MULOP_in_term584 = new BitSet(new long[]{0x0000000000B10000L});
    public static final BitSet FOLLOW_factor_in_term595 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ID_in_factor621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NENTERO_in_factor630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NREAL_in_factor636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARI_in_factor642 = new BitSet(new long[]{0x0000000000B10000L});
    public static final BitSet FOLLOW_expr_in_factor644 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_PARD_in_factor647 = new BitSet(new long[]{0x0000000000000002L});

}