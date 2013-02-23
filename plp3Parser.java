// $ANTLR 3.4 plp3.g 2013-02-23 13:29:40

	import java.lang.String;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class plp3Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADDOP", "AND", "ASIG", "BLANCOS", "BOOL", "BOOLEANO", "BREAK", "CLASS", "COMA", "COMENTARIO", "CONTINUE", "CORD", "CORI", "DOUBLE", "ELSE", "ENTERO", "FOR", "FOREACH", "ID", "IF", "IN", "INT", "LLAVED", "LLAVEI", "MAIN", "MULOP", "NEW", "NOT", "OR", "PARD", "PARI", "PUBLIC", "PUNTO", "PYC", "READLINE", "REAL", "RELOP", "SINGLE", "STATIC", "STEP", "TO", "VAR", "VOID", "WHILE", "WRITELINE"
    };

    public static final int EOF=-1;
    public static final int ADDOP=4;
    public static final int AND=5;
    public static final int ASIG=6;
    public static final int BLANCOS=7;
    public static final int BOOL=8;
    public static final int BOOLEANO=9;
    public static final int BREAK=10;
    public static final int CLASS=11;
    public static final int COMA=12;
    public static final int COMENTARIO=13;
    public static final int CONTINUE=14;
    public static final int CORD=15;
    public static final int CORI=16;
    public static final int DOUBLE=17;
    public static final int ELSE=18;
    public static final int ENTERO=19;
    public static final int FOR=20;
    public static final int FOREACH=21;
    public static final int ID=22;
    public static final int IF=23;
    public static final int IN=24;
    public static final int INT=25;
    public static final int LLAVED=26;
    public static final int LLAVEI=27;
    public static final int MAIN=28;
    public static final int MULOP=29;
    public static final int NEW=30;
    public static final int NOT=31;
    public static final int OR=32;
    public static final int PARD=33;
    public static final int PARI=34;
    public static final int PUBLIC=35;
    public static final int PUNTO=36;
    public static final int PYC=37;
    public static final int READLINE=38;
    public static final int REAL=39;
    public static final int RELOP=40;
    public static final int SINGLE=41;
    public static final int STATIC=42;
    public static final int STEP=43;
    public static final int TO=44;
    public static final int VAR=45;
    public static final int VOID=46;
    public static final int WHILE=47;
    public static final int WRITELINE=48;

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
    // plp3.g:403:1: s[String archivo] returns [String resultado] : clase ;
    public final String s(String archivo) throws RecognitionException {
        String resultado = null;


        String clase1 =null;


        try {
            // plp3.g:404:2: ( clase )
            // plp3.g:404:4: clase
            {
            tS = new tablaSimbolos();

            pushFollow(FOLLOW_clase_in_s67);
            clase1=clase();

            state._fsp--;


            resultado = ".assembly extern mscorlib {}\n" + ".assembly '" + archivo + "' {}\n" + clase1;

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



    // $ANTLR start "clase"
    // plp3.g:406:1: clase returns [String trad] : CLASS SINGLE LLAVEI metodo LLAVED ;
    public final String clase() throws RecognitionException {
        String trad = null;


        String metodo2 =null;


        try {
            // plp3.g:407:2: ( CLASS SINGLE LLAVEI metodo LLAVED )
            // plp3.g:407:4: CLASS SINGLE LLAVEI metodo LLAVED
            {
            match(input,CLASS,FOLLOW_CLASS_in_clase81); 

            match(input,SINGLE,FOLLOW_SINGLE_in_clase83); 

            match(input,LLAVEI,FOLLOW_LLAVEI_in_clase85); 

            trad =".class 'Single' extends [mscorlib]System.Object \n{\n";

            pushFollow(FOLLOW_metodo_in_clase89);
            metodo2=metodo();

            state._fsp--;


            trad+=metodo2 + "\n}";

            match(input,LLAVED,FOLLOW_LLAVED_in_clase93); 

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
    // $ANTLR end "clase"



    // $ANTLR start "metodo"
    // plp3.g:409:1: metodo returns [String trad] : PUBLIC STATIC VOID MAIN PARI PARD bloque ;
    public final String metodo() throws RecognitionException {
        String trad = null;


        String bloque3 =null;


        try {
            // plp3.g:410:2: ( PUBLIC STATIC VOID MAIN PARI PARD bloque )
            // plp3.g:410:4: PUBLIC STATIC VOID MAIN PARI PARD bloque
            {
            match(input,PUBLIC,FOLLOW_PUBLIC_in_metodo106); 

            match(input,STATIC,FOLLOW_STATIC_in_metodo108); 

            match(input,VOID,FOLLOW_VOID_in_metodo110); 

            match(input,MAIN,FOLLOW_MAIN_in_metodo112); 

            match(input,PARI,FOLLOW_PARI_in_metodo114); 

            match(input,PARD,FOLLOW_PARD_in_metodo116); 

            pushFollow(FOLLOW_bloque_in_metodo118);
            bloque3=bloque();

            state._fsp--;


            trad = ".method static public void main () cil managed \n{\n.locals()\n.entrypoint\n.maxstack 1000\n"+bloque3+"\n ret\n}";

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
    // $ANTLR end "metodo"



    // $ANTLR start "tipoSimple"
    // plp3.g:412:1: tipoSimple returns [String trad] : ( INT | DOUBLE | BOOL );
    public final String tipoSimple() throws RecognitionException {
        String trad = null;


        try {
            // plp3.g:413:2: ( INT | DOUBLE | BOOL )
            int alt1=3;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt1=1;
                }
                break;
            case DOUBLE:
                {
                alt1=2;
                }
                break;
            case BOOL:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }

            switch (alt1) {
                case 1 :
                    // plp3.g:413:4: INT
                    {
                    match(input,INT,FOLLOW_INT_in_tipoSimple132); 

                    trad = "int32";

                    }
                    break;
                case 2 :
                    // plp3.g:414:4: DOUBLE
                    {
                    match(input,DOUBLE,FOLLOW_DOUBLE_in_tipoSimple139); 

                    trad = "float64";

                    }
                    break;
                case 3 :
                    // plp3.g:415:4: BOOL
                    {
                    match(input,BOOL,FOLLOW_BOOL_in_tipoSimple146); 

                    trad ="bool";

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
    // $ANTLR end "tipoSimple"



    // $ANTLR start "decl"
    // plp3.g:417:1: decl returns [String trad] : tipoSimple primervarid= varid[$tipoSimple.trad] ( COMA nuevovarid= varid[$tipoSimple.trad] )* PYC ;
    public final String decl() throws RecognitionException {
        String trad = null;


        plp3Parser.varid_return primervarid =null;

        plp3Parser.varid_return nuevovarid =null;

        String tipoSimple4 =null;


        try {
            // plp3.g:418:2: ( tipoSimple primervarid= varid[$tipoSimple.trad] ( COMA nuevovarid= varid[$tipoSimple.trad] )* PYC )
            // plp3.g:418:4: tipoSimple primervarid= varid[$tipoSimple.trad] ( COMA nuevovarid= varid[$tipoSimple.trad] )* PYC
            {
            pushFollow(FOLLOW_tipoSimple_in_decl162);
            tipoSimple4=tipoSimple();

            state._fsp--;


            pushFollow(FOLLOW_varid_in_decl168);
            primervarid=varid(tipoSimple4);

            state._fsp--;



            		tS.add((primervarid!=null?primervarid.trad:null),(primervarid!=null?primervarid.resultado:null));

            		trad = ".locals(" + (primervarid!=null?primervarid.resultado:null);
            	

            // plp3.g:422:3: ( COMA nuevovarid= varid[$tipoSimple.trad] )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==COMA) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // plp3.g:422:4: COMA nuevovarid= varid[$tipoSimple.trad]
            	    {
            	    match(input,COMA,FOLLOW_COMA_in_decl173); 

            	    pushFollow(FOLLOW_varid_in_decl179);
            	    nuevovarid=varid(tipoSimple4);

            	    state._fsp--;


            	    trad+=", " + tipoSimple4+ " '" + (nuevovarid!=null?nuevovarid.trad:null) + "'";tS.add((nuevovarid!=null?nuevovarid.trad:null),(nuevovarid!=null?nuevovarid.resultado:null));

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            match(input,PYC,FOLLOW_PYC_in_decl187); 

            trad += ")";

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
    // $ANTLR end "decl"


    public static class varid_return extends ParserRuleReturnScope {
        public String trad;
        public Tipo resultado;
    };


    // $ANTLR start "varid"
    // plp3.g:425:1: varid[String tipo] returns [String trad, Tipo resultado] : ID ( CORI ( COMA )* CORD )? ;
    public final plp3Parser.varid_return varid(String tipo) throws RecognitionException {
        plp3Parser.varid_return retval = new plp3Parser.varid_return();
        retval.start = input.LT(1);


        Token ID5=null;

        try {
            // plp3.g:426:2: ( ID ( CORI ( COMA )* CORD )? )
            // plp3.g:426:4: ID ( CORI ( COMA )* CORD )?
            {
            ID5=(Token)match(input,ID,FOLLOW_ID_in_varid204); 

            retval.trad = (ID5!=null?ID5.getText():null);retval.resultado = new Tipo(tipo,0,null);

            // plp3.g:426:63: ( CORI ( COMA )* CORD )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==CORI) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // plp3.g:426:64: CORI ( COMA )* CORD
                    {
                    match(input,CORI,FOLLOW_CORI_in_varid209); 

                    retval.resultado = new Tipo("array",0,retval.resultado);

                    // plp3.g:426:115: ( COMA )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==COMA) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // plp3.g:426:116: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_varid213); 

                    	    retval.resultado = new Tipo("array",0,retval.resultado);

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    match(input,CORD,FOLLOW_CORD_in_varid218); 

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
    // $ANTLR end "varid"



    // $ANTLR start "declins"
    // plp3.g:428:1: declins returns [String trad] : ( instr | decl )* ;
    public final String declins() throws RecognitionException {
        String trad = null;


        String instr6 =null;

        String decl7 =null;


        try {
            // plp3.g:429:2: ( ( instr | decl )* )
            // plp3.g:429:4: ( instr | decl )*
            {
            trad = "";

            // plp3.g:429:17: ( instr | decl )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==BREAK||LA5_0==CONTINUE||(LA5_0 >= FOR && LA5_0 <= IF)||LA5_0==LLAVEI||(LA5_0 >= WHILE && LA5_0 <= WRITELINE)) ) {
                    alt5=1;
                }
                else if ( (LA5_0==BOOL||LA5_0==DOUBLE||LA5_0==INT) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // plp3.g:429:18: instr
            	    {
            	    pushFollow(FOLLOW_instr_in_declins235);
            	    instr6=instr();

            	    state._fsp--;


            	    trad += instr6 + "\n";

            	    }
            	    break;
            	case 2 :
            	    // plp3.g:429:56: decl
            	    {
            	    pushFollow(FOLLOW_decl_in_declins240);
            	    decl7=decl();

            	    state._fsp--;


            	    trad += decl7+ "\n";
            	    	// ==========================================================	
            	    		System.out.println("tS = "+tS.getAll());
            	    	// ==========================================================		
            	    		

            	    }
            	    break;

            	default :
            	    break loop5;
                }
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
    // $ANTLR end "declins"



    // $ANTLR start "bloque"
    // plp3.g:435:1: bloque returns [String trad] : LLAVEI declins LLAVED ;
    public final String bloque() throws RecognitionException {
        String trad = null;


        String declins8 =null;


        try {
            // plp3.g:436:2: ( LLAVEI declins LLAVED )
            // plp3.g:436:4: LLAVEI declins LLAVED
            {
            tS = new tablaSimbolos(tS);

            match(input,LLAVEI,FOLLOW_LLAVEI_in_bloque257); 

            pushFollow(FOLLOW_declins_in_bloque259);
            declins8=declins();

            state._fsp--;


            match(input,LLAVED,FOLLOW_LLAVED_in_bloque261); 

            trad = declins8;tS = tS.pop();

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



    // $ANTLR start "instr"
    // plp3.g:438:1: instr returns [String trad] : ( bloque | IF PARI expr PARD instr ( ELSE instr )? | WHILE PARI expr PARD instr | FOREACH PARI VAR ID IN ID PARD instr | FOR PARI INT ID ASIG expr TO expr STEP ( ADDOP )? ENTERO PARD instr | BREAK PYC | CONTINUE PYC | ref cambio | ID ASIG NEW tipoSimple CORI dims CORD PYC | WRITELINE PARI expr PARD PYC );
    public final String instr() throws RecognitionException {
        String trad = null;


        String bloque9 =null;

        plp3Parser.expr_return expr10 =null;


        try {
            // plp3.g:439:2: ( bloque | IF PARI expr PARD instr ( ELSE instr )? | WHILE PARI expr PARD instr | FOREACH PARI VAR ID IN ID PARD instr | FOR PARI INT ID ASIG expr TO expr STEP ( ADDOP )? ENTERO PARD instr | BREAK PYC | CONTINUE PYC | ref cambio | ID ASIG NEW tipoSimple CORI dims CORD PYC | WRITELINE PARI expr PARD PYC )
            int alt8=10;
            switch ( input.LA(1) ) {
            case LLAVEI:
                {
                alt8=1;
                }
                break;
            case IF:
                {
                alt8=2;
                }
                break;
            case WHILE:
                {
                alt8=3;
                }
                break;
            case FOREACH:
                {
                alt8=4;
                }
                break;
            case FOR:
                {
                alt8=5;
                }
                break;
            case BREAK:
                {
                alt8=6;
                }
                break;
            case CONTINUE:
                {
                alt8=7;
                }
                break;
            case ID:
                {
                int LA8_8 = input.LA(2);

                if ( (LA8_8==ASIG) ) {
                    int LA8_10 = input.LA(3);

                    if ( (LA8_10==NEW) ) {
                        alt8=9;
                    }
                    else if ( (LA8_10==BOOLEANO||LA8_10==ENTERO||LA8_10==ID||LA8_10==NOT||LA8_10==PARI||LA8_10==REAL) ) {
                        alt8=8;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 10, input);

                        throw nvae;

                    }
                }
                else if ( (LA8_8==CORI||LA8_8==PUNTO) ) {
                    alt8=8;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 8, input);

                    throw nvae;

                }
                }
                break;
            case WRITELINE:
                {
                alt8=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }

            switch (alt8) {
                case 1 :
                    // plp3.g:439:4: bloque
                    {
                    pushFollow(FOLLOW_bloque_in_instr275);
                    bloque9=bloque();

                    state._fsp--;


                    trad = "{\n"+bloque9+";}";

                    }
                    break;
                case 2 :
                    // plp3.g:440:4: IF PARI expr PARD instr ( ELSE instr )?
                    {
                    match(input,IF,FOLLOW_IF_in_instr281); 

                    match(input,PARI,FOLLOW_PARI_in_instr283); 

                    pushFollow(FOLLOW_expr_in_instr285);
                    expr();

                    state._fsp--;


                    match(input,PARD,FOLLOW_PARD_in_instr287); 

                    pushFollow(FOLLOW_instr_in_instr289);
                    instr();

                    state._fsp--;


                    // plp3.g:440:28: ( ELSE instr )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==ELSE) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // plp3.g:440:29: ELSE instr
                            {
                            match(input,ELSE,FOLLOW_ELSE_in_instr292); 

                            pushFollow(FOLLOW_instr_in_instr294);
                            instr();

                            state._fsp--;


                            }
                            break;

                    }


                    trad = "instr";

                    }
                    break;
                case 3 :
                    // plp3.g:441:4: WHILE PARI expr PARD instr
                    {
                    match(input,WHILE,FOLLOW_WHILE_in_instr303); 

                    match(input,PARI,FOLLOW_PARI_in_instr305); 

                    pushFollow(FOLLOW_expr_in_instr307);
                    expr();

                    state._fsp--;


                    match(input,PARD,FOLLOW_PARD_in_instr309); 

                    pushFollow(FOLLOW_instr_in_instr311);
                    instr();

                    state._fsp--;


                    trad = "instr";

                    }
                    break;
                case 4 :
                    // plp3.g:442:4: FOREACH PARI VAR ID IN ID PARD instr
                    {
                    match(input,FOREACH,FOLLOW_FOREACH_in_instr317); 

                    match(input,PARI,FOLLOW_PARI_in_instr319); 

                    match(input,VAR,FOLLOW_VAR_in_instr321); 

                    match(input,ID,FOLLOW_ID_in_instr323); 

                    match(input,IN,FOLLOW_IN_in_instr325); 

                    match(input,ID,FOLLOW_ID_in_instr327); 

                    match(input,PARD,FOLLOW_PARD_in_instr329); 

                    pushFollow(FOLLOW_instr_in_instr331);
                    instr();

                    state._fsp--;


                    trad = "instr";

                    }
                    break;
                case 5 :
                    // plp3.g:443:4: FOR PARI INT ID ASIG expr TO expr STEP ( ADDOP )? ENTERO PARD instr
                    {
                    match(input,FOR,FOLLOW_FOR_in_instr337); 

                    match(input,PARI,FOLLOW_PARI_in_instr339); 

                    match(input,INT,FOLLOW_INT_in_instr341); 

                    match(input,ID,FOLLOW_ID_in_instr343); 

                    match(input,ASIG,FOLLOW_ASIG_in_instr345); 

                    pushFollow(FOLLOW_expr_in_instr347);
                    expr();

                    state._fsp--;


                    match(input,TO,FOLLOW_TO_in_instr349); 

                    pushFollow(FOLLOW_expr_in_instr351);
                    expr();

                    state._fsp--;


                    match(input,STEP,FOLLOW_STEP_in_instr353); 

                    // plp3.g:443:43: ( ADDOP )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==ADDOP) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // plp3.g:443:44: ADDOP
                            {
                            match(input,ADDOP,FOLLOW_ADDOP_in_instr356); 

                            }
                            break;

                    }


                    match(input,ENTERO,FOLLOW_ENTERO_in_instr360); 

                    match(input,PARD,FOLLOW_PARD_in_instr362); 

                    pushFollow(FOLLOW_instr_in_instr364);
                    instr();

                    state._fsp--;


                    trad = "instr";

                    }
                    break;
                case 6 :
                    // plp3.g:444:4: BREAK PYC
                    {
                    match(input,BREAK,FOLLOW_BREAK_in_instr370); 

                    match(input,PYC,FOLLOW_PYC_in_instr372); 

                    trad = "instr";

                    }
                    break;
                case 7 :
                    // plp3.g:445:4: CONTINUE PYC
                    {
                    match(input,CONTINUE,FOLLOW_CONTINUE_in_instr378); 

                    match(input,PYC,FOLLOW_PYC_in_instr380); 

                    trad = "instr";

                    }
                    break;
                case 8 :
                    // plp3.g:446:4: ref cambio
                    {
                    pushFollow(FOLLOW_ref_in_instr386);
                    ref();

                    state._fsp--;


                    pushFollow(FOLLOW_cambio_in_instr388);
                    cambio();

                    state._fsp--;


                    trad = "instr";

                    }
                    break;
                case 9 :
                    // plp3.g:447:4: ID ASIG NEW tipoSimple CORI dims CORD PYC
                    {
                    match(input,ID,FOLLOW_ID_in_instr394); 

                    match(input,ASIG,FOLLOW_ASIG_in_instr396); 

                    match(input,NEW,FOLLOW_NEW_in_instr398); 

                    pushFollow(FOLLOW_tipoSimple_in_instr400);
                    tipoSimple();

                    state._fsp--;


                    match(input,CORI,FOLLOW_CORI_in_instr402); 

                    pushFollow(FOLLOW_dims_in_instr404);
                    dims();

                    state._fsp--;


                    match(input,CORD,FOLLOW_CORD_in_instr406); 

                    match(input,PYC,FOLLOW_PYC_in_instr408); 

                    trad = "instr";

                    }
                    break;
                case 10 :
                    // plp3.g:448:4: WRITELINE PARI expr PARD PYC
                    {
                    match(input,WRITELINE,FOLLOW_WRITELINE_in_instr414); 

                    match(input,PARI,FOLLOW_PARI_in_instr416); 

                    pushFollow(FOLLOW_expr_in_instr418);
                    expr10=expr();

                    state._fsp--;


                    match(input,PARD,FOLLOW_PARD_in_instr420); 

                    match(input,PYC,FOLLOW_PYC_in_instr422); 


                    			// TODO: mostrar bien según el tipo de lo que muestras
                    			trad = (expr10!=null?expr10.trad:null);
                    			trad += "call void [mscorlib]System.Console::WriteLine(" + (expr10!=null?expr10.tipo:null) + ")\n";
                    		

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



    // $ANTLR start "dims"
    // plp3.g:454:1: dims returns [String trad] : ENTERO ( COMA ENTERO )* ;
    public final String dims() throws RecognitionException {
        String trad = null;


        try {
            // plp3.g:455:2: ( ENTERO ( COMA ENTERO )* )
            // plp3.g:455:4: ENTERO ( COMA ENTERO )*
            {
            match(input,ENTERO,FOLLOW_ENTERO_in_dims436); 

            // plp3.g:455:11: ( COMA ENTERO )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==COMA) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // plp3.g:455:12: COMA ENTERO
            	    {
            	    match(input,COMA,FOLLOW_COMA_in_dims439); 

            	    match(input,ENTERO,FOLLOW_ENTERO_in_dims441); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
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
    // $ANTLR end "dims"



    // $ANTLR start "cambio"
    // plp3.g:457:1: cambio returns [String trad] : ( ASIG expr PYC | PUNTO READLINE PYC );
    public final String cambio() throws RecognitionException {
        String trad = null;


        try {
            // plp3.g:458:2: ( ASIG expr PYC | PUNTO READLINE PYC )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==ASIG) ) {
                alt10=1;
            }
            else if ( (LA10_0==PUNTO) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }
            switch (alt10) {
                case 1 :
                    // plp3.g:458:4: ASIG expr PYC
                    {
                    match(input,ASIG,FOLLOW_ASIG_in_cambio456); 

                    pushFollow(FOLLOW_expr_in_cambio458);
                    expr();

                    state._fsp--;


                    match(input,PYC,FOLLOW_PYC_in_cambio460); 

                    }
                    break;
                case 2 :
                    // plp3.g:459:4: PUNTO READLINE PYC
                    {
                    match(input,PUNTO,FOLLOW_PUNTO_in_cambio465); 

                    match(input,READLINE,FOLLOW_READLINE_in_cambio467); 

                    match(input,PYC,FOLLOW_PYC_in_cambio469); 

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
    // $ANTLR end "cambio"


    public static class expr_return extends ParserRuleReturnScope {
        public String trad;
        public String tipo;
    };


    // $ANTLR start "expr"
    // plp3.g:461:1: expr returns [String trad, String tipo] : primero= eand ( OR siguiente= eand )* ;
    public final plp3Parser.expr_return expr() throws RecognitionException {
        plp3Parser.expr_return retval = new plp3Parser.expr_return();
        retval.start = input.LT(1);


        plp3Parser.eand_return primero =null;

        plp3Parser.eand_return siguiente =null;


        try {
            // plp3.g:462:2: (primero= eand ( OR siguiente= eand )* )
            // plp3.g:462:4: primero= eand ( OR siguiente= eand )*
            {
            pushFollow(FOLLOW_eand_in_expr486);
            primero=eand();

            state._fsp--;


            retval.trad = (primero!=null?primero.trad:null); retval.tipo = (primero!=null?primero.tipo:null);

            // plp3.g:462:66: ( OR siguiente= eand )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==OR) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // plp3.g:462:67: OR siguiente= eand
            	    {
            	    match(input,OR,FOLLOW_OR_in_expr490); 

            	    pushFollow(FOLLOW_eand_in_expr496);
            	    siguiente=eand();

            	    state._fsp--;


            	    retval.trad += (siguiente!=null?siguiente.trad:null);retval.tipo = /*"bool"*/"int32";
            	    			retval.trad += "add\n" + "ldc.i4 0\n" + "ceq\n"+ "not\n";

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


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


    public static class eand_return extends ParserRuleReturnScope {
        public String trad;
        public String tipo;
    };


    // $ANTLR start "eand"
    // plp3.g:465:1: eand returns [String trad, String tipo] : primero= erel ( AND siguiente= erel )* ;
    public final plp3Parser.eand_return eand() throws RecognitionException {
        plp3Parser.eand_return retval = new plp3Parser.eand_return();
        retval.start = input.LT(1);


        plp3Parser.erel_return primero =null;

        plp3Parser.erel_return siguiente =null;


        try {
            // plp3.g:466:2: (primero= erel ( AND siguiente= erel )* )
            // plp3.g:466:4: primero= erel ( AND siguiente= erel )*
            {
            pushFollow(FOLLOW_erel_in_eand516);
            primero=erel();

            state._fsp--;


            retval.trad = (primero!=null?primero.trad:null); retval.tipo = (primero!=null?primero.tipo:null);

            // plp3.g:466:66: ( AND siguiente= erel )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==AND) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // plp3.g:466:67: AND siguiente= erel
            	    {
            	    match(input,AND,FOLLOW_AND_in_eand520); 

            	    pushFollow(FOLLOW_erel_in_eand526);
            	    siguiente=erel();

            	    state._fsp--;


            	    retval.trad += (siguiente!=null?siguiente.trad:null);retval.tipo = /*"bool"*/"int32";
            	    			retval.trad += "mul\n" + "ldc.i4 0\n" + "ceq\n"+ "not\n";

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


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
    // $ANTLR end "eand"


    public static class erel_return extends ParserRuleReturnScope {
        public String trad;
        public String tipo;
    };


    // $ANTLR start "erel"
    // plp3.g:469:1: erel returns [String trad, String tipo] : primero= esum ( RELOP siguiente= esum )* ;
    public final plp3Parser.erel_return erel() throws RecognitionException {
        plp3Parser.erel_return retval = new plp3Parser.erel_return();
        retval.start = input.LT(1);


        Token RELOP11=null;
        plp3Parser.esum_return primero =null;

        plp3Parser.esum_return siguiente =null;


        try {
            // plp3.g:470:2: (primero= esum ( RELOP siguiente= esum )* )
            // plp3.g:470:4: primero= esum ( RELOP siguiente= esum )*
            {
            pushFollow(FOLLOW_esum_in_erel546);
            primero=esum();

            state._fsp--;


            retval.trad = (primero!=null?primero.trad:null); retval.tipo = (primero!=null?primero.tipo:null);

            // plp3.g:470:66: ( RELOP siguiente= esum )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RELOP) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // plp3.g:470:67: RELOP siguiente= esum
            	    {
            	    RELOP11=(Token)match(input,RELOP,FOLLOW_RELOP_in_erel550); 

            	    pushFollow(FOLLOW_esum_in_erel556);
            	    siguiente=esum();

            	    state._fsp--;


            	    retval.trad += (siguiente!=null?siguiente.trad:null);retval.tipo = /*"bool"*/"int32";
            	    			if((RELOP11!=null?RELOP11.getText():null).equals("==")){
            	    			    retval.trad += "ceq\n";
            	    			}else if((RELOP11!=null?RELOP11.getText():null).equals("!=")){
            	    			    retval.trad += "ceq\n" + "not\n";
            	    			}else if((RELOP11!=null?RELOP11.getText():null).equals("<")){
            	    			    retval.trad += "sub\n" + "ldc.i4 0\n" + "cgt\n";
            	    			}else if((RELOP11!=null?RELOP11.getText():null).equals(">")){
            	    			    retval.trad += "sub\n" + "ldc.i4 0\n" + "clt\n";
            	    			}else if((RELOP11!=null?RELOP11.getText():null).equals("<=")){
            	    			    retval.trad += "sub\n" + "ldc.i4 0\n" + "cge\n";
            	    			}else if((RELOP11!=null?RELOP11.getText():null).equals(">=")){
            	    			    retval.trad += "sub\n" + "ldc.i4 0\n" + "cle\n";
            	    			}
            	    			
            	    			
            	    		

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


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
    // $ANTLR end "erel"


    public static class esum_return extends ParserRuleReturnScope {
        public String trad;
        public String tipo;
    };


    // $ANTLR start "esum"
    // plp3.g:489:1: esum returns [String trad, String tipo] : primero= term ( ADDOP siguiente= term )* ;
    public final plp3Parser.esum_return esum() throws RecognitionException {
        plp3Parser.esum_return retval = new plp3Parser.esum_return();
        retval.start = input.LT(1);


        Token ADDOP12=null;
        plp3Parser.term_return primero =null;

        plp3Parser.term_return siguiente =null;


        try {
            // plp3.g:490:2: (primero= term ( ADDOP siguiente= term )* )
            // plp3.g:490:4: primero= term ( ADDOP siguiente= term )*
            {
            pushFollow(FOLLOW_term_in_esum577);
            primero=term();

            state._fsp--;


            retval.trad = (primero!=null?primero.trad:null); retval.tipo = (primero!=null?primero.tipo:null);

            // plp3.g:490:66: ( ADDOP siguiente= term )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==ADDOP) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // plp3.g:490:67: ADDOP siguiente= term
            	    {
            	    ADDOP12=(Token)match(input,ADDOP,FOLLOW_ADDOP_in_esum581); 

            	    pushFollow(FOLLOW_term_in_esum587);
            	    siguiente=term();

            	    state._fsp--;


            	    retval.trad += (siguiente!=null?siguiente.trad:null);retval.tipo = "int32"/*"int/real == comprobar =="*/;
            	    			if((ADDOP12!=null?ADDOP12.getText():null).equals("+")){
            	    			    retval.trad += "add\n";
            	    			}else{
            	    			    retval.trad += "sub\n"; // IGUAL ESTO PETA, PONE QUE SUB = VALOR2 - VALOR1
            	    			}
            	    		

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


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
    // $ANTLR end "esum"


    public static class term_return extends ParserRuleReturnScope {
        public String trad;
        public String tipo;
    };


    // $ANTLR start "term"
    // plp3.g:498:1: term returns [String trad, String tipo] : primero= factor ( MULOP siguiente= factor )* ;
    public final plp3Parser.term_return term() throws RecognitionException {
        plp3Parser.term_return retval = new plp3Parser.term_return();
        retval.start = input.LT(1);


        Token MULOP13=null;
        plp3Parser.factor_return primero =null;

        plp3Parser.factor_return siguiente =null;


        try {
            // plp3.g:499:2: (primero= factor ( MULOP siguiente= factor )* )
            // plp3.g:499:4: primero= factor ( MULOP siguiente= factor )*
            {
            pushFollow(FOLLOW_factor_in_term607);
            primero=factor();

            state._fsp--;


            retval.trad = (primero!=null?primero.trad:null); retval.tipo = (primero!=null?primero.tipo:null);

            // plp3.g:499:68: ( MULOP siguiente= factor )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==MULOP) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // plp3.g:499:69: MULOP siguiente= factor
            	    {
            	    MULOP13=(Token)match(input,MULOP,FOLLOW_MULOP_in_term611); 

            	    pushFollow(FOLLOW_factor_in_term617);
            	    siguiente=factor();

            	    state._fsp--;


            	    retval.trad += (siguiente!=null?siguiente.trad:null);retval.tipo = "int32"/*"int/real == comprobar =="*/;
            	    			if((MULOP13!=null?MULOP13.getText():null).equals("*")){
            	    			    retval.trad += "mul\n";
            	    			}else{
            	    			    retval.trad += "div\n"; 
            	    			}
            	    		

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


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
    // plp3.g:507:1: factor returns [String trad, String tipo] : ( base | NOT factor | PARI ADDOP factor PARD );
    public final plp3Parser.factor_return factor() throws RecognitionException {
        plp3Parser.factor_return retval = new plp3Parser.factor_return();
        retval.start = input.LT(1);


        plp3Parser.base_return base14 =null;


        try {
            // plp3.g:508:2: ( base | NOT factor | PARI ADDOP factor PARD )
            int alt16=3;
            switch ( input.LA(1) ) {
            case BOOLEANO:
            case ENTERO:
            case ID:
            case REAL:
                {
                alt16=1;
                }
                break;
            case PARI:
                {
                int LA16_2 = input.LA(2);

                if ( (LA16_2==ADDOP) ) {
                    alt16=3;
                }
                else if ( (LA16_2==BOOLEANO||LA16_2==ENTERO||LA16_2==ID||LA16_2==NOT||LA16_2==PARI||LA16_2==REAL) ) {
                    alt16=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 2, input);

                    throw nvae;

                }
                }
                break;
            case NOT:
                {
                alt16=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;

            }

            switch (alt16) {
                case 1 :
                    // plp3.g:508:4: base
                    {
                    pushFollow(FOLLOW_base_in_factor633);
                    base14=base();

                    state._fsp--;


                    retval.trad = (base14!=null?base14.trad:null); retval.tipo = (base14!=null?base14.tipo:null);

                    }
                    break;
                case 2 :
                    // plp3.g:509:4: NOT factor
                    {
                    match(input,NOT,FOLLOW_NOT_in_factor639); 

                    pushFollow(FOLLOW_factor_in_factor641);
                    factor();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // plp3.g:510:4: PARI ADDOP factor PARD
                    {
                    match(input,PARI,FOLLOW_PARI_in_factor646); 

                    match(input,ADDOP,FOLLOW_ADDOP_in_factor648); 

                    pushFollow(FOLLOW_factor_in_factor650);
                    factor();

                    state._fsp--;


                    match(input,PARD,FOLLOW_PARD_in_factor652); 

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


    public static class base_return extends ParserRuleReturnScope {
        public String trad;
        public String tipo;
    };


    // $ANTLR start "base"
    // plp3.g:512:1: base returns [String trad, String tipo] : ( ENTERO | REAL | BOOLEANO | PARI expr PARD | ref );
    public final plp3Parser.base_return base() throws RecognitionException {
        plp3Parser.base_return retval = new plp3Parser.base_return();
        retval.start = input.LT(1);


        Token ENTERO15=null;
        Token REAL16=null;
        Token BOOLEANO17=null;
        plp3Parser.expr_return expr18 =null;


        try {
            // plp3.g:513:2: ( ENTERO | REAL | BOOLEANO | PARI expr PARD | ref )
            int alt17=5;
            switch ( input.LA(1) ) {
            case ENTERO:
                {
                alt17=1;
                }
                break;
            case REAL:
                {
                alt17=2;
                }
                break;
            case BOOLEANO:
                {
                alt17=3;
                }
                break;
            case PARI:
                {
                alt17=4;
                }
                break;
            case ID:
                {
                alt17=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }

            switch (alt17) {
                case 1 :
                    // plp3.g:513:4: ENTERO
                    {
                    ENTERO15=(Token)match(input,ENTERO,FOLLOW_ENTERO_in_base665); 

                    retval.trad = "ldc.i4 " + (ENTERO15!=null?ENTERO15.getText():null) + "\n"; retval.tipo = "int32";

                    }
                    break;
                case 2 :
                    // plp3.g:514:4: REAL
                    {
                    REAL16=(Token)match(input,REAL,FOLLOW_REAL_in_base671); 

                    retval.trad = (REAL16!=null?REAL16.getText():null); retval.tipo = "float64";

                    }
                    break;
                case 3 :
                    // plp3.g:515:4: BOOLEANO
                    {
                    BOOLEANO17=(Token)match(input,BOOLEANO,FOLLOW_BOOLEANO_in_base677); 

                    retval.trad = (BOOLEANO17!=null?BOOLEANO17.getText():null); retval.tipo = "int32"/*"bool"*/;

                    }
                    break;
                case 4 :
                    // plp3.g:516:4: PARI expr PARD
                    {
                    match(input,PARI,FOLLOW_PARI_in_base683); 

                    pushFollow(FOLLOW_expr_in_base685);
                    expr18=expr();

                    state._fsp--;


                    match(input,PARD,FOLLOW_PARD_in_base687); 

                    retval.trad = (expr18!=null?expr18.trad:null); retval.tipo = (expr18!=null?expr18.tipo:null);

                    }
                    break;
                case 5 :
                    // plp3.g:517:4: ref
                    {
                    pushFollow(FOLLOW_ref_in_base693);
                    ref();

                    state._fsp--;


                    retval.trad = "ref"; retval.tipo = "ref";

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
    // $ANTLR end "base"



    // $ANTLR start "ref"
    // plp3.g:519:1: ref returns [String trad] : ID ( CORI indices CORD )? ;
    public final String ref() throws RecognitionException {
        String trad = null;


        try {
            // plp3.g:520:2: ( ID ( CORI indices CORD )? )
            // plp3.g:520:4: ID ( CORI indices CORD )?
            {
            match(input,ID,FOLLOW_ID_in_ref708); 

            // plp3.g:520:7: ( CORI indices CORD )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==CORI) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // plp3.g:520:8: CORI indices CORD
                    {
                    match(input,CORI,FOLLOW_CORI_in_ref711); 

                    pushFollow(FOLLOW_indices_in_ref713);
                    indices();

                    state._fsp--;


                    match(input,CORD,FOLLOW_CORD_in_ref715); 

                    }
                    break;

            }


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
    // $ANTLR end "ref"



    // $ANTLR start "indices"
    // plp3.g:522:1: indices returns [String trad] : expr ( COMA expr )* ;
    public final String indices() throws RecognitionException {
        String trad = null;


        try {
            // plp3.g:523:2: ( expr ( COMA expr )* )
            // plp3.g:523:4: expr ( COMA expr )*
            {
            pushFollow(FOLLOW_expr_in_indices730);
            expr();

            state._fsp--;


            // plp3.g:523:9: ( COMA expr )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==COMA) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // plp3.g:523:10: COMA expr
            	    {
            	    match(input,COMA,FOLLOW_COMA_in_indices733); 

            	    pushFollow(FOLLOW_expr_in_indices735);
            	    expr();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
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
    // $ANTLR end "indices"

    // Delegated rules


 

    public static final BitSet FOLLOW_clase_in_s67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLASS_in_clase81 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_SINGLE_in_clase83 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_LLAVEI_in_clase85 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_metodo_in_clase89 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_LLAVED_in_clase93 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PUBLIC_in_metodo106 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_STATIC_in_metodo108 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_VOID_in_metodo110 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_MAIN_in_metodo112 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_PARI_in_metodo114 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_PARD_in_metodo116 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_bloque_in_metodo118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_tipoSimple132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_tipoSimple139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_tipoSimple146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tipoSimple_in_decl162 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_varid_in_decl168 = new BitSet(new long[]{0x0000002000001000L});
    public static final BitSet FOLLOW_COMA_in_decl173 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_varid_in_decl179 = new BitSet(new long[]{0x0000002000001000L});
    public static final BitSet FOLLOW_PYC_in_decl187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_varid204 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_CORI_in_varid209 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_COMA_in_varid213 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_CORD_in_varid218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instr_in_declins235 = new BitSet(new long[]{0x000180000AF24502L});
    public static final BitSet FOLLOW_decl_in_declins240 = new BitSet(new long[]{0x000180000AF24502L});
    public static final BitSet FOLLOW_LLAVEI_in_bloque257 = new BitSet(new long[]{0x000180000EF24500L});
    public static final BitSet FOLLOW_declins_in_bloque259 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_LLAVED_in_bloque261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bloque_in_instr275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_instr281 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_PARI_in_instr283 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_expr_in_instr285 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_PARD_in_instr287 = new BitSet(new long[]{0x0001800008F04400L});
    public static final BitSet FOLLOW_instr_in_instr289 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ELSE_in_instr292 = new BitSet(new long[]{0x0001800008F04400L});
    public static final BitSet FOLLOW_instr_in_instr294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_instr303 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_PARI_in_instr305 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_expr_in_instr307 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_PARD_in_instr309 = new BitSet(new long[]{0x0001800008F04400L});
    public static final BitSet FOLLOW_instr_in_instr311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOREACH_in_instr317 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_PARI_in_instr319 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_VAR_in_instr321 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ID_in_instr323 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_IN_in_instr325 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ID_in_instr327 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_PARD_in_instr329 = new BitSet(new long[]{0x0001800008F04400L});
    public static final BitSet FOLLOW_instr_in_instr331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_instr337 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_PARI_in_instr339 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_INT_in_instr341 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ID_in_instr343 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ASIG_in_instr345 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_expr_in_instr347 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_TO_in_instr349 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_expr_in_instr351 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_STEP_in_instr353 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_ADDOP_in_instr356 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ENTERO_in_instr360 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_PARD_in_instr362 = new BitSet(new long[]{0x0001800008F04400L});
    public static final BitSet FOLLOW_instr_in_instr364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BREAK_in_instr370 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_PYC_in_instr372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTINUE_in_instr378 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_PYC_in_instr380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ref_in_instr386 = new BitSet(new long[]{0x0000001000000040L});
    public static final BitSet FOLLOW_cambio_in_instr388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_instr394 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ASIG_in_instr396 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_NEW_in_instr398 = new BitSet(new long[]{0x0000000002020100L});
    public static final BitSet FOLLOW_tipoSimple_in_instr400 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_CORI_in_instr402 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_dims_in_instr404 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CORD_in_instr406 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_PYC_in_instr408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WRITELINE_in_instr414 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_PARI_in_instr416 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_expr_in_instr418 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_PARD_in_instr420 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_PYC_in_instr422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENTERO_in_dims436 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_COMA_in_dims439 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ENTERO_in_dims441 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ASIG_in_cambio456 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_expr_in_cambio458 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_PYC_in_cambio460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PUNTO_in_cambio465 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_READLINE_in_cambio467 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_PYC_in_cambio469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_eand_in_expr486 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_OR_in_expr490 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_eand_in_expr496 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_erel_in_eand516 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_AND_in_eand520 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_erel_in_eand526 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_esum_in_erel546 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_RELOP_in_erel550 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_esum_in_erel556 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_term_in_esum577 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ADDOP_in_esum581 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_term_in_esum587 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_factor_in_term607 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_MULOP_in_term611 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_factor_in_term617 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_base_in_factor633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_factor639 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_factor_in_factor641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARI_in_factor646 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ADDOP_in_factor648 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_factor_in_factor650 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_PARD_in_factor652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENTERO_in_base665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REAL_in_base671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEANO_in_base677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARI_in_base683 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_expr_in_base685 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_PARD_in_base687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ref_in_base693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_ref708 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_CORI_in_ref711 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_indices_in_ref713 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CORD_in_ref715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_indices730 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_COMA_in_indices733 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_expr_in_indices735 = new BitSet(new long[]{0x0000000000001002L});

}