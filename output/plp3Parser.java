// $ANTLR 3.4 /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g 2013-02-21 21:12:31

	import java.lang.String;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
@SuppressWarnings({"all", "warnings", "unchecked"})
public class plp3Parser extends DebugParser {
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


public static final String[] ruleNames = new String[] {
    "invalidRule", "tipoSimple", "bloque", "instr", "base", "dims", "ref", 
    "eand", "esum", "metodo", "cambio", "varid", "indices", "term", "erel", 
    "decl", "factor", "clase", "expr", "s", "declins"
};

public static final boolean[] decisionCanBacktrack = new boolean[] {
    false, // invalid decision
    false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false, false, false, false, false, false
};

 
    public int ruleLevel = 0;
    public int getRuleLevel() { return ruleLevel; }
    public void incRuleLevel() { ruleLevel++; }
    public void decRuleLevel() { ruleLevel--; }
    public plp3Parser(TokenStream input) {
        this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
    }
    public plp3Parser(TokenStream input, int port, RecognizerSharedState state) {
        super(input, state);
        DebugEventSocketProxy proxy =
            new DebugEventSocketProxy(this, port, null);

        setDebugListener(proxy);
        try {
            proxy.handshake();
        }
        catch (IOException ioe) {
            reportError(ioe);
        }
    }

public plp3Parser(TokenStream input, DebugEventListener dbg) {
    super(input, dbg, new RecognizerSharedState());
}

protected boolean evalPredicate(boolean result, String predicate) {
    dbg.semanticPredicate(result, predicate);
    return result;
}

    public String[] getTokenNames() { return plp3Parser.tokenNames; }
    public String getGrammarFileName() { return "/home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g"; }


    	tablaSimbolos tS;
    	public void emitErrorMessage(String msg) {
    		System.err.println(msg);
    		System.exit(1);
    	}



    // $ANTLR start "s"
    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:403:1: s returns [String resultado] : clase ;
    public final String s() throws RecognitionException {
        String resultado = null;


        String clase1 =null;


        try { dbg.enterRule(getGrammarFileName(), "s");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(403, 0);

        try {
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:404:2: ( clase )
            dbg.enterAlt(1);

            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:404:4: clase
            {
            dbg.location(404,4);
            tS = new tablaSimbolos();
            dbg.location(404,31);
            pushFollow(FOLLOW_clase_in_s66);
            clase1=clase();

            state._fsp--;

            dbg.location(404,36);
            resultado = ".assembly extern mscorlib {}\n" + clase1;

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
        dbg.location(404, 97);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "s");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return resultado;
    }
    // $ANTLR end "s"



    // $ANTLR start "clase"
    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:406:1: clase returns [String trad] : CLASS SINGLE LLAVEI metodo LLAVED ;
    public final String clase() throws RecognitionException {
        String trad = null;


        String metodo2 =null;


        try { dbg.enterRule(getGrammarFileName(), "clase");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(406, 0);

        try {
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:407:2: ( CLASS SINGLE LLAVEI metodo LLAVED )
            dbg.enterAlt(1);

            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:407:4: CLASS SINGLE LLAVEI metodo LLAVED
            {
            dbg.location(407,4);
            match(input,CLASS,FOLLOW_CLASS_in_clase80); 
            dbg.location(407,10);
            match(input,SINGLE,FOLLOW_SINGLE_in_clase82); 
            dbg.location(407,17);
            match(input,LLAVEI,FOLLOW_LLAVEI_in_clase84); 
            dbg.location(407,24);
            trad =".class 'Single' extends[mscorlib]System.Object {\n";
            dbg.location(407,86);
            pushFollow(FOLLOW_metodo_in_clase88);
            metodo2=metodo();

            state._fsp--;

            dbg.location(407,93);
            trad+=metodo2 + "\n}";
            dbg.location(407,124);
            match(input,LLAVED,FOLLOW_LLAVED_in_clase92); 

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
        dbg.location(407, 129);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "clase");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return trad;
    }
    // $ANTLR end "clase"



    // $ANTLR start "metodo"
    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:409:1: metodo returns [String trad] : PUBLIC STATIC VOID MAIN PARI PARD bloque ;
    public final String metodo() throws RecognitionException {
        String trad = null;


        String bloque3 =null;


        try { dbg.enterRule(getGrammarFileName(), "metodo");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(409, 0);

        try {
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:410:2: ( PUBLIC STATIC VOID MAIN PARI PARD bloque )
            dbg.enterAlt(1);

            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:410:4: PUBLIC STATIC VOID MAIN PARI PARD bloque
            {
            dbg.location(410,4);
            match(input,PUBLIC,FOLLOW_PUBLIC_in_metodo105); 
            dbg.location(410,11);
            match(input,STATIC,FOLLOW_STATIC_in_metodo107); 
            dbg.location(410,18);
            match(input,VOID,FOLLOW_VOID_in_metodo109); 
            dbg.location(410,23);
            match(input,MAIN,FOLLOW_MAIN_in_metodo111); 
            dbg.location(410,28);
            match(input,PARI,FOLLOW_PARI_in_metodo113); 
            dbg.location(410,33);
            match(input,PARD,FOLLOW_PARD_in_metodo115); 
            dbg.location(410,38);
            pushFollow(FOLLOW_bloque_in_metodo117);
            bloque3=bloque();

            state._fsp--;

            dbg.location(410,44);
            trad = ".method static public void main () cil managed \n{\n.entrypoint\n"+bloque3+"\n}";

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
        dbg.location(410, 140);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "metodo");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return trad;
    }
    // $ANTLR end "metodo"



    // $ANTLR start "tipoSimple"
    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:412:1: tipoSimple returns [String trad] : ( INT | DOUBLE | BOOL );
    public final String tipoSimple() throws RecognitionException {
        String trad = null;


        try { dbg.enterRule(getGrammarFileName(), "tipoSimple");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(412, 0);

        try {
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:413:2: ( INT | DOUBLE | BOOL )
            int alt1=3;
            try { dbg.enterDecision(1, decisionCanBacktrack[1]);

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

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(1);}

            switch (alt1) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:413:4: INT
                    {
                    dbg.location(413,4);
                    match(input,INT,FOLLOW_INT_in_tipoSimple131); 
                    dbg.location(413,8);
                    trad = "int32";

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:414:4: DOUBLE
                    {
                    dbg.location(414,4);
                    match(input,DOUBLE,FOLLOW_DOUBLE_in_tipoSimple138); 
                    dbg.location(414,11);
                    trad = "float64";

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:415:4: BOOL
                    {
                    dbg.location(415,4);
                    match(input,BOOL,FOLLOW_BOOL_in_tipoSimple145); 
                    dbg.location(415,9);
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
        dbg.location(415, 23);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "tipoSimple");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return trad;
    }
    // $ANTLR end "tipoSimple"



    // $ANTLR start "decl"
    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:417:1: decl returns [String trad] : tipoSimple primervarid= varid[$tipoSimple.trad] ( COMA nuevovarid= varid[$tipoSimple.trad] )* PYC ;
    public final String decl() throws RecognitionException {
        String trad = null;


        plp3Parser.varid_return primervarid =null;

        plp3Parser.varid_return nuevovarid =null;

        String tipoSimple4 =null;


        try { dbg.enterRule(getGrammarFileName(), "decl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(417, 0);

        try {
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:418:2: ( tipoSimple primervarid= varid[$tipoSimple.trad] ( COMA nuevovarid= varid[$tipoSimple.trad] )* PYC )
            dbg.enterAlt(1);

            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:418:4: tipoSimple primervarid= varid[$tipoSimple.trad] ( COMA nuevovarid= varid[$tipoSimple.trad] )* PYC
            {
            dbg.location(418,4);
            pushFollow(FOLLOW_tipoSimple_in_decl161);
            tipoSimple4=tipoSimple();

            state._fsp--;

            dbg.location(418,27);
            pushFollow(FOLLOW_varid_in_decl167);
            primervarid=varid(tipoSimple4);

            state._fsp--;

            dbg.location(418,53);

            		tS.add((primervarid!=null?primervarid.trad:null),(primervarid!=null?primervarid.resultado:null));

            		trad = ".locals(" + (primervarid!=null?primervarid.resultado:null);
            	
            dbg.location(422,3);
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:422:3: ( COMA nuevovarid= varid[$tipoSimple.trad] )*
            try { dbg.enterSubRule(2);

            loop2:
            do {
                int alt2=2;
                try { dbg.enterDecision(2, decisionCanBacktrack[2]);

                int LA2_0 = input.LA(1);

                if ( (LA2_0==COMA) ) {
                    alt2=1;
                }


                } finally {dbg.exitDecision(2);}

                switch (alt2) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:422:4: COMA nuevovarid= varid[$tipoSimple.trad]
            	    {
            	    dbg.location(422,4);
            	    match(input,COMA,FOLLOW_COMA_in_decl172); 
            	    dbg.location(422,20);
            	    pushFollow(FOLLOW_varid_in_decl178);
            	    nuevovarid=varid(tipoSimple4);

            	    state._fsp--;

            	    dbg.location(423,2);
            	    trad+=", " + tipoSimple4+ " '" + (nuevovarid!=null?nuevovarid.trad:null) + "'";tS.add((nuevovarid!=null?nuevovarid.trad:null),(nuevovarid!=null?nuevovarid.resultado:null));

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);
            } finally {dbg.exitSubRule(2);}

            dbg.location(423,116);
            match(input,PYC,FOLLOW_PYC_in_decl186); 
            dbg.location(423,120);
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
        dbg.location(423, 134);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "decl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return trad;
    }
    // $ANTLR end "decl"


    public static class varid_return extends ParserRuleReturnScope {
        public String trad;
        public Tipo resultado;
    };


    // $ANTLR start "varid"
    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:425:1: varid[String tipo] returns [String trad, Tipo resultado] : ID ( CORI ( COMA )* CORD )? ;
    public final plp3Parser.varid_return varid(String tipo) throws RecognitionException {
        plp3Parser.varid_return retval = new plp3Parser.varid_return();
        retval.start = input.LT(1);


        Token ID5=null;

        try { dbg.enterRule(getGrammarFileName(), "varid");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(425, 0);

        try {
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:426:2: ( ID ( CORI ( COMA )* CORD )? )
            dbg.enterAlt(1);

            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:426:4: ID ( CORI ( COMA )* CORD )?
            {
            dbg.location(426,4);
            ID5=(Token)match(input,ID,FOLLOW_ID_in_varid203); 
            dbg.location(426,7);
            retval.trad = (ID5!=null?ID5.getText():null);retval.resultado = new Tipo(tipo,0,null);
            dbg.location(426,63);
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:426:63: ( CORI ( COMA )* CORD )?
            int alt4=2;
            try { dbg.enterSubRule(4);
            try { dbg.enterDecision(4, decisionCanBacktrack[4]);

            int LA4_0 = input.LA(1);

            if ( (LA4_0==CORI) ) {
                alt4=1;
            }
            } finally {dbg.exitDecision(4);}

            switch (alt4) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:426:64: CORI ( COMA )* CORD
                    {
                    dbg.location(426,64);
                    match(input,CORI,FOLLOW_CORI_in_varid208); 
                    dbg.location(426,69);
                    retval.resultado = new Tipo("array",0,retval.resultado);
                    dbg.location(426,115);
                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:426:115: ( COMA )*
                    try { dbg.enterSubRule(3);

                    loop3:
                    do {
                        int alt3=2;
                        try { dbg.enterDecision(3, decisionCanBacktrack[3]);

                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==COMA) ) {
                            alt3=1;
                        }


                        } finally {dbg.exitDecision(3);}

                        switch (alt3) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:426:116: COMA
                    	    {
                    	    dbg.location(426,116);
                    	    match(input,COMA,FOLLOW_COMA_in_varid212); 
                    	    dbg.location(426,120);
                    	    retval.resultado = new Tipo("array",0,retval.resultado);

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(3);}

                    dbg.location(426,169);
                    match(input,CORD,FOLLOW_CORD_in_varid217); 

                    }
                    break;

            }
            } finally {dbg.exitSubRule(4);}


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
        dbg.location(426, 174);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "varid");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "varid"



    // $ANTLR start "declins"
    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:428:1: declins returns [String trad] : ( instr | decl )* ;
    public final String declins() throws RecognitionException {
        String trad = null;


        String instr6 =null;

        String decl7 =null;


        try { dbg.enterRule(getGrammarFileName(), "declins");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(428, 0);

        try {
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:429:2: ( ( instr | decl )* )
            dbg.enterAlt(1);

            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:429:4: ( instr | decl )*
            {
            dbg.location(429,4);
            trad = "";
            dbg.location(429,17);
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:429:17: ( instr | decl )*
            try { dbg.enterSubRule(5);

            loop5:
            do {
                int alt5=3;
                try { dbg.enterDecision(5, decisionCanBacktrack[5]);

                int LA5_0 = input.LA(1);

                if ( (LA5_0==BREAK||LA5_0==CONTINUE||(LA5_0 >= FOR && LA5_0 <= IF)||LA5_0==LLAVEI||(LA5_0 >= WHILE && LA5_0 <= WRITELINE)) ) {
                    alt5=1;
                }
                else if ( (LA5_0==BOOL||LA5_0==DOUBLE||LA5_0==INT) ) {
                    alt5=2;
                }


                } finally {dbg.exitDecision(5);}

                switch (alt5) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:429:18: instr
            	    {
            	    dbg.location(429,18);
            	    pushFollow(FOLLOW_instr_in_declins234);
            	    instr6=instr();

            	    state._fsp--;

            	    dbg.location(429,24);
            	    trad += instr6 + "\n";

            	    }
            	    break;
            	case 2 :
            	    dbg.enterAlt(2);

            	    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:429:56: decl
            	    {
            	    dbg.location(429,56);
            	    pushFollow(FOLLOW_decl_in_declins239);
            	    decl7=decl();

            	    state._fsp--;

            	    dbg.location(429,60);
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
            } finally {dbg.exitSubRule(5);}


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
        dbg.location(433, 5);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "declins");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return trad;
    }
    // $ANTLR end "declins"



    // $ANTLR start "bloque"
    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:435:1: bloque returns [String trad] : LLAVEI declins LLAVED ;
    public final String bloque() throws RecognitionException {
        String trad = null;


        String declins8 =null;


        try { dbg.enterRule(getGrammarFileName(), "bloque");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(435, 0);

        try {
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:436:2: ( LLAVEI declins LLAVED )
            dbg.enterAlt(1);

            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:436:4: LLAVEI declins LLAVED
            {
            dbg.location(436,4);
            tS = new tablaSimbolos(tS);
            dbg.location(436,33);
            match(input,LLAVEI,FOLLOW_LLAVEI_in_bloque256); 
            dbg.location(436,40);
            pushFollow(FOLLOW_declins_in_bloque258);
            declins8=declins();

            state._fsp--;

            dbg.location(436,48);
            match(input,LLAVED,FOLLOW_LLAVED_in_bloque260); 
            dbg.location(436,54);
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
        dbg.location(436, 91);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "bloque");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return trad;
    }
    // $ANTLR end "bloque"



    // $ANTLR start "instr"
    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:438:1: instr returns [String trad] : ( bloque | IF PARI expr PARD instr ( ELSE instr )? | WHILE PARI expr PARD instr | FOREACH PARI VAR ID IN ID PARD instr | FOR PARI INT ID ASIG expr TO expr STEP ( ADDOP )? ENTERO PARD instr | BREAK PYC | CONTINUE PYC | ref cambio | ID ASIG NEW tipoSimple CORI dims CORD PYC | WRITELINE PARI expr PARD PYC );
    public final String instr() throws RecognitionException {
        String trad = null;


        String bloque9 =null;

        plp3Parser.expr_return expr10 =null;


        try { dbg.enterRule(getGrammarFileName(), "instr");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(438, 0);

        try {
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:439:2: ( bloque | IF PARI expr PARD instr ( ELSE instr )? | WHILE PARI expr PARD instr | FOREACH PARI VAR ID IN ID PARD instr | FOR PARI INT ID ASIG expr TO expr STEP ( ADDOP )? ENTERO PARD instr | BREAK PYC | CONTINUE PYC | ref cambio | ID ASIG NEW tipoSimple CORI dims CORD PYC | WRITELINE PARI expr PARD PYC )
            int alt8=10;
            try { dbg.enterDecision(8, decisionCanBacktrack[8]);

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

                        dbg.recognitionException(nvae);
                        throw nvae;

                    }
                }
                else if ( (LA8_8==CORI||LA8_8==PUNTO) ) {
                    alt8=8;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 8, input);

                    dbg.recognitionException(nvae);
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

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(8);}

            switch (alt8) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:439:4: bloque
                    {
                    dbg.location(439,4);
                    pushFollow(FOLLOW_bloque_in_instr274);
                    bloque9=bloque();

                    state._fsp--;

                    dbg.location(439,10);
                    trad = "{\n"+bloque9+";}";

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:440:4: IF PARI expr PARD instr ( ELSE instr )?
                    {
                    dbg.location(440,4);
                    match(input,IF,FOLLOW_IF_in_instr280); 
                    dbg.location(440,7);
                    match(input,PARI,FOLLOW_PARI_in_instr282); 
                    dbg.location(440,12);
                    pushFollow(FOLLOW_expr_in_instr284);
                    expr();

                    state._fsp--;

                    dbg.location(440,17);
                    match(input,PARD,FOLLOW_PARD_in_instr286); 
                    dbg.location(440,22);
                    pushFollow(FOLLOW_instr_in_instr288);
                    instr();

                    state._fsp--;

                    dbg.location(440,28);
                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:440:28: ( ELSE instr )?
                    int alt6=2;
                    try { dbg.enterSubRule(6);
                    try { dbg.enterDecision(6, decisionCanBacktrack[6]);

                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==ELSE) ) {
                        alt6=1;
                    }
                    } finally {dbg.exitDecision(6);}

                    switch (alt6) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:440:29: ELSE instr
                            {
                            dbg.location(440,29);
                            match(input,ELSE,FOLLOW_ELSE_in_instr291); 
                            dbg.location(440,34);
                            pushFollow(FOLLOW_instr_in_instr293);
                            instr();

                            state._fsp--;


                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(6);}

                    dbg.location(440,42);
                    trad = "instr";

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:441:4: WHILE PARI expr PARD instr
                    {
                    dbg.location(441,4);
                    match(input,WHILE,FOLLOW_WHILE_in_instr302); 
                    dbg.location(441,10);
                    match(input,PARI,FOLLOW_PARI_in_instr304); 
                    dbg.location(441,15);
                    pushFollow(FOLLOW_expr_in_instr306);
                    expr();

                    state._fsp--;

                    dbg.location(441,20);
                    match(input,PARD,FOLLOW_PARD_in_instr308); 
                    dbg.location(441,25);
                    pushFollow(FOLLOW_instr_in_instr310);
                    instr();

                    state._fsp--;

                    dbg.location(441,30);
                    trad = "instr";

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:442:4: FOREACH PARI VAR ID IN ID PARD instr
                    {
                    dbg.location(442,4);
                    match(input,FOREACH,FOLLOW_FOREACH_in_instr316); 
                    dbg.location(442,12);
                    match(input,PARI,FOLLOW_PARI_in_instr318); 
                    dbg.location(442,17);
                    match(input,VAR,FOLLOW_VAR_in_instr320); 
                    dbg.location(442,21);
                    match(input,ID,FOLLOW_ID_in_instr322); 
                    dbg.location(442,24);
                    match(input,IN,FOLLOW_IN_in_instr324); 
                    dbg.location(442,27);
                    match(input,ID,FOLLOW_ID_in_instr326); 
                    dbg.location(442,30);
                    match(input,PARD,FOLLOW_PARD_in_instr328); 
                    dbg.location(442,35);
                    pushFollow(FOLLOW_instr_in_instr330);
                    instr();

                    state._fsp--;

                    dbg.location(442,40);
                    trad = "instr";

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:443:4: FOR PARI INT ID ASIG expr TO expr STEP ( ADDOP )? ENTERO PARD instr
                    {
                    dbg.location(443,4);
                    match(input,FOR,FOLLOW_FOR_in_instr336); 
                    dbg.location(443,8);
                    match(input,PARI,FOLLOW_PARI_in_instr338); 
                    dbg.location(443,13);
                    match(input,INT,FOLLOW_INT_in_instr340); 
                    dbg.location(443,17);
                    match(input,ID,FOLLOW_ID_in_instr342); 
                    dbg.location(443,20);
                    match(input,ASIG,FOLLOW_ASIG_in_instr344); 
                    dbg.location(443,25);
                    pushFollow(FOLLOW_expr_in_instr346);
                    expr();

                    state._fsp--;

                    dbg.location(443,30);
                    match(input,TO,FOLLOW_TO_in_instr348); 
                    dbg.location(443,33);
                    pushFollow(FOLLOW_expr_in_instr350);
                    expr();

                    state._fsp--;

                    dbg.location(443,38);
                    match(input,STEP,FOLLOW_STEP_in_instr352); 
                    dbg.location(443,43);
                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:443:43: ( ADDOP )?
                    int alt7=2;
                    try { dbg.enterSubRule(7);
                    try { dbg.enterDecision(7, decisionCanBacktrack[7]);

                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==ADDOP) ) {
                        alt7=1;
                    }
                    } finally {dbg.exitDecision(7);}

                    switch (alt7) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:443:44: ADDOP
                            {
                            dbg.location(443,44);
                            match(input,ADDOP,FOLLOW_ADDOP_in_instr355); 

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(7);}

                    dbg.location(443,52);
                    match(input,ENTERO,FOLLOW_ENTERO_in_instr359); 
                    dbg.location(443,59);
                    match(input,PARD,FOLLOW_PARD_in_instr361); 
                    dbg.location(443,64);
                    pushFollow(FOLLOW_instr_in_instr363);
                    instr();

                    state._fsp--;

                    dbg.location(443,69);
                    trad = "instr";

                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:444:4: BREAK PYC
                    {
                    dbg.location(444,4);
                    match(input,BREAK,FOLLOW_BREAK_in_instr369); 
                    dbg.location(444,10);
                    match(input,PYC,FOLLOW_PYC_in_instr371); 
                    dbg.location(444,13);
                    trad = "instr";

                    }
                    break;
                case 7 :
                    dbg.enterAlt(7);

                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:445:4: CONTINUE PYC
                    {
                    dbg.location(445,4);
                    match(input,CONTINUE,FOLLOW_CONTINUE_in_instr377); 
                    dbg.location(445,13);
                    match(input,PYC,FOLLOW_PYC_in_instr379); 
                    dbg.location(445,16);
                    trad = "instr";

                    }
                    break;
                case 8 :
                    dbg.enterAlt(8);

                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:446:4: ref cambio
                    {
                    dbg.location(446,4);
                    pushFollow(FOLLOW_ref_in_instr385);
                    ref();

                    state._fsp--;

                    dbg.location(446,8);
                    pushFollow(FOLLOW_cambio_in_instr387);
                    cambio();

                    state._fsp--;

                    dbg.location(446,14);
                    trad = "instr";

                    }
                    break;
                case 9 :
                    dbg.enterAlt(9);

                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:447:4: ID ASIG NEW tipoSimple CORI dims CORD PYC
                    {
                    dbg.location(447,4);
                    match(input,ID,FOLLOW_ID_in_instr393); 
                    dbg.location(447,7);
                    match(input,ASIG,FOLLOW_ASIG_in_instr395); 
                    dbg.location(447,12);
                    match(input,NEW,FOLLOW_NEW_in_instr397); 
                    dbg.location(447,16);
                    pushFollow(FOLLOW_tipoSimple_in_instr399);
                    tipoSimple();

                    state._fsp--;

                    dbg.location(447,27);
                    match(input,CORI,FOLLOW_CORI_in_instr401); 
                    dbg.location(447,32);
                    pushFollow(FOLLOW_dims_in_instr403);
                    dims();

                    state._fsp--;

                    dbg.location(447,37);
                    match(input,CORD,FOLLOW_CORD_in_instr405); 
                    dbg.location(447,42);
                    match(input,PYC,FOLLOW_PYC_in_instr407); 
                    dbg.location(447,45);
                    trad = "instr";

                    }
                    break;
                case 10 :
                    dbg.enterAlt(10);

                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:448:4: WRITELINE PARI expr PARD PYC
                    {
                    dbg.location(448,4);
                    match(input,WRITELINE,FOLLOW_WRITELINE_in_instr413); 
                    dbg.location(448,14);
                    match(input,PARI,FOLLOW_PARI_in_instr415); 
                    dbg.location(448,19);
                    pushFollow(FOLLOW_expr_in_instr417);
                    expr10=expr();

                    state._fsp--;

                    dbg.location(448,24);
                    match(input,PARD,FOLLOW_PARD_in_instr419); 
                    dbg.location(448,29);
                    match(input,PYC,FOLLOW_PYC_in_instr421); 
                    dbg.location(448,32);

                    			// TODO: mostrar bien según el tipo de lo que muestras
                    			trad = (expr10!=null?expr10.trad:null);
                    			trad = "call void [mscorlib]System.Console::WriteLine(" + (expr10!=null?expr10.tipo:null) + ")\n";
                    		

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
        dbg.location(452, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "instr");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return trad;
    }
    // $ANTLR end "instr"



    // $ANTLR start "dims"
    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:454:1: dims returns [String trad] : ENTERO ( COMA ENTERO )* ;
    public final String dims() throws RecognitionException {
        String trad = null;


        try { dbg.enterRule(getGrammarFileName(), "dims");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(454, 0);

        try {
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:455:2: ( ENTERO ( COMA ENTERO )* )
            dbg.enterAlt(1);

            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:455:4: ENTERO ( COMA ENTERO )*
            {
            dbg.location(455,4);
            match(input,ENTERO,FOLLOW_ENTERO_in_dims435); 
            dbg.location(455,11);
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:455:11: ( COMA ENTERO )*
            try { dbg.enterSubRule(9);

            loop9:
            do {
                int alt9=2;
                try { dbg.enterDecision(9, decisionCanBacktrack[9]);

                int LA9_0 = input.LA(1);

                if ( (LA9_0==COMA) ) {
                    alt9=1;
                }


                } finally {dbg.exitDecision(9);}

                switch (alt9) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:455:12: COMA ENTERO
            	    {
            	    dbg.location(455,12);
            	    match(input,COMA,FOLLOW_COMA_in_dims438); 
            	    dbg.location(455,17);
            	    match(input,ENTERO,FOLLOW_ENTERO_in_dims440); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);
            } finally {dbg.exitSubRule(9);}


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
        dbg.location(455, 24);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "dims");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return trad;
    }
    // $ANTLR end "dims"



    // $ANTLR start "cambio"
    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:457:1: cambio returns [String trad] : ( ASIG expr PYC | PUNTO READLINE PYC );
    public final String cambio() throws RecognitionException {
        String trad = null;


        try { dbg.enterRule(getGrammarFileName(), "cambio");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(457, 0);

        try {
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:458:2: ( ASIG expr PYC | PUNTO READLINE PYC )
            int alt10=2;
            try { dbg.enterDecision(10, decisionCanBacktrack[10]);

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

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(10);}

            switch (alt10) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:458:4: ASIG expr PYC
                    {
                    dbg.location(458,4);
                    match(input,ASIG,FOLLOW_ASIG_in_cambio455); 
                    dbg.location(458,9);
                    pushFollow(FOLLOW_expr_in_cambio457);
                    expr();

                    state._fsp--;

                    dbg.location(458,14);
                    match(input,PYC,FOLLOW_PYC_in_cambio459); 

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:459:4: PUNTO READLINE PYC
                    {
                    dbg.location(459,4);
                    match(input,PUNTO,FOLLOW_PUNTO_in_cambio464); 
                    dbg.location(459,10);
                    match(input,READLINE,FOLLOW_READLINE_in_cambio466); 
                    dbg.location(459,19);
                    match(input,PYC,FOLLOW_PYC_in_cambio468); 

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
        dbg.location(459, 21);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "cambio");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return trad;
    }
    // $ANTLR end "cambio"


    public static class expr_return extends ParserRuleReturnScope {
        public String trad;
        public String tipo;
    };


    // $ANTLR start "expr"
    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:461:1: expr returns [String trad, String tipo] : primero= eand ( OR siguiente= eand )* ;
    public final plp3Parser.expr_return expr() throws RecognitionException {
        plp3Parser.expr_return retval = new plp3Parser.expr_return();
        retval.start = input.LT(1);


        plp3Parser.eand_return primero =null;

        plp3Parser.eand_return siguiente =null;


        try { dbg.enterRule(getGrammarFileName(), "expr");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(461, 0);

        try {
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:462:2: (primero= eand ( OR siguiente= eand )* )
            dbg.enterAlt(1);

            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:462:4: primero= eand ( OR siguiente= eand )*
            {
            dbg.location(462,12);
            pushFollow(FOLLOW_eand_in_expr485);
            primero=eand();

            state._fsp--;

            dbg.location(462,19);
            retval.trad = (primero!=null?primero.trad:null); retval.tipo = (primero!=null?primero.tipo:null);
            dbg.location(462,66);
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:462:66: ( OR siguiente= eand )*
            try { dbg.enterSubRule(11);

            loop11:
            do {
                int alt11=2;
                try { dbg.enterDecision(11, decisionCanBacktrack[11]);

                int LA11_0 = input.LA(1);

                if ( (LA11_0==OR) ) {
                    alt11=1;
                }


                } finally {dbg.exitDecision(11);}

                switch (alt11) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:462:67: OR siguiente= eand
            	    {
            	    dbg.location(462,67);
            	    match(input,OR,FOLLOW_OR_in_expr489); 
            	    dbg.location(462,80);
            	    pushFollow(FOLLOW_eand_in_expr495);
            	    siguiente=eand();

            	    state._fsp--;

            	    dbg.location(462,86);
            	    retval.trad += (siguiente!=null?siguiente.trad:null);retval.tipo = "bool";
            	    			retval.trad += "add\n" + "ldc.i4 0\n" + "cneq [ETIQUETA SI SE CUMPLE EL OR]\n";

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);
            } finally {dbg.exitSubRule(11);}


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
        dbg.location(463, 79);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "expr");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "expr"


    public static class eand_return extends ParserRuleReturnScope {
        public String trad;
        public String tipo;
    };


    // $ANTLR start "eand"
    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:465:1: eand returns [String trad, String tipo] : primero= erel ( AND siguiente= erel )* ;
    public final plp3Parser.eand_return eand() throws RecognitionException {
        plp3Parser.eand_return retval = new plp3Parser.eand_return();
        retval.start = input.LT(1);


        plp3Parser.erel_return primero =null;

        plp3Parser.erel_return siguiente =null;


        try { dbg.enterRule(getGrammarFileName(), "eand");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(465, 0);

        try {
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:466:2: (primero= erel ( AND siguiente= erel )* )
            dbg.enterAlt(1);

            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:466:4: primero= erel ( AND siguiente= erel )*
            {
            dbg.location(466,12);
            pushFollow(FOLLOW_erel_in_eand515);
            primero=erel();

            state._fsp--;

            dbg.location(466,19);
            retval.trad = (primero!=null?primero.trad:null); retval.tipo = (primero!=null?primero.tipo:null);
            dbg.location(466,66);
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:466:66: ( AND siguiente= erel )*
            try { dbg.enterSubRule(12);

            loop12:
            do {
                int alt12=2;
                try { dbg.enterDecision(12, decisionCanBacktrack[12]);

                int LA12_0 = input.LA(1);

                if ( (LA12_0==AND) ) {
                    alt12=1;
                }


                } finally {dbg.exitDecision(12);}

                switch (alt12) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:466:67: AND siguiente= erel
            	    {
            	    dbg.location(466,67);
            	    match(input,AND,FOLLOW_AND_in_eand519); 
            	    dbg.location(466,81);
            	    pushFollow(FOLLOW_erel_in_eand525);
            	    siguiente=erel();

            	    state._fsp--;

            	    dbg.location(466,87);
            	    retval.trad += (siguiente!=null?siguiente.trad:null);retval.tipo = "bool";
            	    			retval.trad += "mul\n" + "ldc.i4 0\n" + "bneq [ETIQUETA SI SE CUMPLE EL AND]\n";

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);
            } finally {dbg.exitSubRule(12);}


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
        dbg.location(467, 80);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "eand");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "eand"


    public static class erel_return extends ParserRuleReturnScope {
        public String trad;
        public String tipo;
    };


    // $ANTLR start "erel"
    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:469:1: erel returns [String trad, String tipo] : primero= esum ( RELOP siguiente= esum )* ;
    public final plp3Parser.erel_return erel() throws RecognitionException {
        plp3Parser.erel_return retval = new plp3Parser.erel_return();
        retval.start = input.LT(1);


        Token RELOP11=null;
        plp3Parser.esum_return primero =null;

        plp3Parser.esum_return siguiente =null;


        try { dbg.enterRule(getGrammarFileName(), "erel");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(469, 0);

        try {
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:470:2: (primero= esum ( RELOP siguiente= esum )* )
            dbg.enterAlt(1);

            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:470:4: primero= esum ( RELOP siguiente= esum )*
            {
            dbg.location(470,12);
            pushFollow(FOLLOW_esum_in_erel545);
            primero=esum();

            state._fsp--;

            dbg.location(470,19);
            retval.trad = (primero!=null?primero.trad:null); retval.tipo = (primero!=null?primero.tipo:null);
            dbg.location(470,66);
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:470:66: ( RELOP siguiente= esum )*
            try { dbg.enterSubRule(13);

            loop13:
            do {
                int alt13=2;
                try { dbg.enterDecision(13, decisionCanBacktrack[13]);

                int LA13_0 = input.LA(1);

                if ( (LA13_0==RELOP) ) {
                    alt13=1;
                }


                } finally {dbg.exitDecision(13);}

                switch (alt13) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:470:67: RELOP siguiente= esum
            	    {
            	    dbg.location(470,67);
            	    RELOP11=(Token)match(input,RELOP,FOLLOW_RELOP_in_erel549); 
            	    dbg.location(470,83);
            	    pushFollow(FOLLOW_esum_in_erel555);
            	    siguiente=esum();

            	    state._fsp--;

            	    dbg.location(470,89);
            	    retval.trad += (siguiente!=null?siguiente.trad:null);retval.tipo = "bool";
            	    			if((RELOP11!=null?RELOP11.getText():null).equals("==")){
            	    			    retval.trad += "sub\n" + "ldc.i4 0\n" + "ceq [ETIQUETA SI SE CUMPLE EL ==]\n";
            	    			}else if((RELOP11!=null?RELOP11.getText():null).equals("!=")){
            	    			    retval.trad += "sub\n" + "ldc.i4 0\n" + "cneq [ETIQUETA SI SE CUMPLE EL !=]\n";
            	    			}else if((RELOP11!=null?RELOP11.getText():null).equals("<")){
            	    			    retval.trad += "sub\n" + "ldc.i4 0\n" + "cgt [ETIQUETA SI SE CUMPLE EL <]\n";
            	    			}else if((RELOP11!=null?RELOP11.getText():null).equals(">")){
            	    			    retval.trad += "sub\n" + "ldc.i4 0\n" + "clt [ETIQUETA SI SE CUMPLE EL >]\n";
            	    			}else if((RELOP11!=null?RELOP11.getText():null).equals("<=")){
            	    			    retval.trad += "sub\n" + "ldc.i4 0\n" + "cge [ETIQUETA SI SE CUMPLE EL <=]\n";
            	    			}else if((RELOP11!=null?RELOP11.getText():null).equals(">=")){
            	    			    retval.trad += "sub\n" + "ldc.i4 0\n" + "cle [ETIQUETA SI SE CUMPLE EL >=]\n";
            	    			}
            	    			
            	    			
            	    		

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);
            } finally {dbg.exitSubRule(13);}


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
        dbg.location(486, 5);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "erel");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "erel"


    public static class esum_return extends ParserRuleReturnScope {
        public String trad;
        public String tipo;
    };


    // $ANTLR start "esum"
    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:489:1: esum returns [String trad, String tipo] : primero= term ( ADDOP siguiente= term )* ;
    public final plp3Parser.esum_return esum() throws RecognitionException {
        plp3Parser.esum_return retval = new plp3Parser.esum_return();
        retval.start = input.LT(1);


        Token ADDOP12=null;
        plp3Parser.term_return primero =null;

        plp3Parser.term_return siguiente =null;


        try { dbg.enterRule(getGrammarFileName(), "esum");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(489, 0);

        try {
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:490:2: (primero= term ( ADDOP siguiente= term )* )
            dbg.enterAlt(1);

            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:490:4: primero= term ( ADDOP siguiente= term )*
            {
            dbg.location(490,12);
            pushFollow(FOLLOW_term_in_esum576);
            primero=term();

            state._fsp--;

            dbg.location(490,19);
            retval.trad = (primero!=null?primero.trad:null); retval.tipo = (primero!=null?primero.tipo:null);
            dbg.location(490,66);
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:490:66: ( ADDOP siguiente= term )*
            try { dbg.enterSubRule(14);

            loop14:
            do {
                int alt14=2;
                try { dbg.enterDecision(14, decisionCanBacktrack[14]);

                int LA14_0 = input.LA(1);

                if ( (LA14_0==ADDOP) ) {
                    alt14=1;
                }


                } finally {dbg.exitDecision(14);}

                switch (alt14) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:490:67: ADDOP siguiente= term
            	    {
            	    dbg.location(490,67);
            	    ADDOP12=(Token)match(input,ADDOP,FOLLOW_ADDOP_in_esum580); 
            	    dbg.location(490,83);
            	    pushFollow(FOLLOW_term_in_esum586);
            	    siguiente=term();

            	    state._fsp--;

            	    dbg.location(490,89);
            	    retval.trad += (siguiente!=null?siguiente.trad:null);retval.tipo = "int/real == comprobar ==";
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
            } finally {dbg.exitSubRule(14);}


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
        dbg.location(496, 5);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "esum");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "esum"


    public static class term_return extends ParserRuleReturnScope {
        public String trad;
        public String tipo;
    };


    // $ANTLR start "term"
    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:498:1: term returns [String trad, String tipo] : primero= factor ( MULOP siguiente= factor )* ;
    public final plp3Parser.term_return term() throws RecognitionException {
        plp3Parser.term_return retval = new plp3Parser.term_return();
        retval.start = input.LT(1);


        Token MULOP13=null;
        plp3Parser.factor_return primero =null;

        plp3Parser.factor_return siguiente =null;


        try { dbg.enterRule(getGrammarFileName(), "term");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(498, 0);

        try {
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:499:2: (primero= factor ( MULOP siguiente= factor )* )
            dbg.enterAlt(1);

            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:499:4: primero= factor ( MULOP siguiente= factor )*
            {
            dbg.location(499,12);
            pushFollow(FOLLOW_factor_in_term606);
            primero=factor();

            state._fsp--;

            dbg.location(499,21);
            retval.trad = (primero!=null?primero.trad:null); retval.tipo = (primero!=null?primero.tipo:null);
            dbg.location(499,68);
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:499:68: ( MULOP siguiente= factor )*
            try { dbg.enterSubRule(15);

            loop15:
            do {
                int alt15=2;
                try { dbg.enterDecision(15, decisionCanBacktrack[15]);

                int LA15_0 = input.LA(1);

                if ( (LA15_0==MULOP) ) {
                    alt15=1;
                }


                } finally {dbg.exitDecision(15);}

                switch (alt15) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:499:69: MULOP siguiente= factor
            	    {
            	    dbg.location(499,69);
            	    MULOP13=(Token)match(input,MULOP,FOLLOW_MULOP_in_term610); 
            	    dbg.location(499,85);
            	    pushFollow(FOLLOW_factor_in_term616);
            	    siguiente=factor();

            	    state._fsp--;

            	    dbg.location(499,93);
            	    retval.trad += (siguiente!=null?siguiente.trad:null);retval.tipo = "bool";
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
            } finally {dbg.exitSubRule(15);}


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
        dbg.location(505, 5);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "term");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "term"


    public static class factor_return extends ParserRuleReturnScope {
        public String trad;
        public String tipo;
    };


    // $ANTLR start "factor"
    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:507:1: factor returns [String trad, String tipo] : ( base | NOT factor | PARI ADDOP factor PARD );
    public final plp3Parser.factor_return factor() throws RecognitionException {
        plp3Parser.factor_return retval = new plp3Parser.factor_return();
        retval.start = input.LT(1);


        plp3Parser.base_return base14 =null;


        try { dbg.enterRule(getGrammarFileName(), "factor");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(507, 0);

        try {
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:508:2: ( base | NOT factor | PARI ADDOP factor PARD )
            int alt16=3;
            try { dbg.enterDecision(16, decisionCanBacktrack[16]);

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

                    dbg.recognitionException(nvae);
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

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(16);}

            switch (alt16) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:508:4: base
                    {
                    dbg.location(508,4);
                    pushFollow(FOLLOW_base_in_factor632);
                    base14=base();

                    state._fsp--;

                    dbg.location(508,8);
                    retval.trad = (base14!=null?base14.trad:null); retval.tipo = (base14!=null?base14.tipo:null);

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:509:4: NOT factor
                    {
                    dbg.location(509,4);
                    match(input,NOT,FOLLOW_NOT_in_factor638); 
                    dbg.location(509,8);
                    pushFollow(FOLLOW_factor_in_factor640);
                    factor();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:510:4: PARI ADDOP factor PARD
                    {
                    dbg.location(510,4);
                    match(input,PARI,FOLLOW_PARI_in_factor645); 
                    dbg.location(510,9);
                    match(input,ADDOP,FOLLOW_ADDOP_in_factor647); 
                    dbg.location(510,15);
                    pushFollow(FOLLOW_factor_in_factor649);
                    factor();

                    state._fsp--;

                    dbg.location(510,22);
                    match(input,PARD,FOLLOW_PARD_in_factor651); 

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
        dbg.location(510, 25);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "factor");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "factor"


    public static class base_return extends ParserRuleReturnScope {
        public String trad;
        public String tipo;
    };


    // $ANTLR start "base"
    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:512:1: base returns [String trad, String tipo] : ( ENTERO | REAL | BOOLEANO | PARI expr PARD | ref );
    public final plp3Parser.base_return base() throws RecognitionException {
        plp3Parser.base_return retval = new plp3Parser.base_return();
        retval.start = input.LT(1);


        Token ENTERO15=null;
        Token REAL16=null;
        Token BOOLEANO17=null;
        plp3Parser.expr_return expr18 =null;


        try { dbg.enterRule(getGrammarFileName(), "base");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(512, 0);

        try {
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:513:2: ( ENTERO | REAL | BOOLEANO | PARI expr PARD | ref )
            int alt17=5;
            try { dbg.enterDecision(17, decisionCanBacktrack[17]);

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

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(17);}

            switch (alt17) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:513:4: ENTERO
                    {
                    dbg.location(513,4);
                    ENTERO15=(Token)match(input,ENTERO,FOLLOW_ENTERO_in_base664); 
                    dbg.location(513,10);
                    retval.trad = (ENTERO15!=null?ENTERO15.getText():null); retval.tipo = "int32";

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:514:4: REAL
                    {
                    dbg.location(514,4);
                    REAL16=(Token)match(input,REAL,FOLLOW_REAL_in_base670); 
                    dbg.location(514,8);
                    retval.trad = (REAL16!=null?REAL16.getText():null); retval.tipo = "float64";

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:515:4: BOOLEANO
                    {
                    dbg.location(515,4);
                    BOOLEANO17=(Token)match(input,BOOLEANO,FOLLOW_BOOLEANO_in_base676); 
                    dbg.location(515,12);
                    retval.trad = (BOOLEANO17!=null?BOOLEANO17.getText():null); retval.tipo = "bool";

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:516:4: PARI expr PARD
                    {
                    dbg.location(516,4);
                    match(input,PARI,FOLLOW_PARI_in_base682); 
                    dbg.location(516,9);
                    pushFollow(FOLLOW_expr_in_base684);
                    expr18=expr();

                    state._fsp--;

                    dbg.location(516,14);
                    match(input,PARD,FOLLOW_PARD_in_base686); 
                    dbg.location(516,18);
                    retval.trad = (expr18!=null?expr18.trad:null); retval.tipo = (expr18!=null?expr18.tipo:null);

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:517:4: ref
                    {
                    dbg.location(517,4);
                    pushFollow(FOLLOW_ref_in_base692);
                    ref();

                    state._fsp--;

                    dbg.location(517,8);
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
        dbg.location(517, 38);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "base");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "base"



    // $ANTLR start "ref"
    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:519:1: ref returns [String trad] : ID ( CORI indices CORD )? ;
    public final String ref() throws RecognitionException {
        String trad = null;


        try { dbg.enterRule(getGrammarFileName(), "ref");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(519, 0);

        try {
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:520:2: ( ID ( CORI indices CORD )? )
            dbg.enterAlt(1);

            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:520:4: ID ( CORI indices CORD )?
            {
            dbg.location(520,4);
            match(input,ID,FOLLOW_ID_in_ref707); 
            dbg.location(520,7);
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:520:7: ( CORI indices CORD )?
            int alt18=2;
            try { dbg.enterSubRule(18);
            try { dbg.enterDecision(18, decisionCanBacktrack[18]);

            int LA18_0 = input.LA(1);

            if ( (LA18_0==CORI) ) {
                alt18=1;
            }
            } finally {dbg.exitDecision(18);}

            switch (alt18) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:520:8: CORI indices CORD
                    {
                    dbg.location(520,8);
                    match(input,CORI,FOLLOW_CORI_in_ref710); 
                    dbg.location(520,13);
                    pushFollow(FOLLOW_indices_in_ref712);
                    indices();

                    state._fsp--;

                    dbg.location(520,21);
                    match(input,CORD,FOLLOW_CORD_in_ref714); 

                    }
                    break;

            }
            } finally {dbg.exitSubRule(18);}


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
        dbg.location(520, 26);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "ref");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return trad;
    }
    // $ANTLR end "ref"



    // $ANTLR start "indices"
    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:522:1: indices returns [String trad] : expr ( COMA expr )* ;
    public final String indices() throws RecognitionException {
        String trad = null;


        try { dbg.enterRule(getGrammarFileName(), "indices");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(522, 0);

        try {
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:523:2: ( expr ( COMA expr )* )
            dbg.enterAlt(1);

            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:523:4: expr ( COMA expr )*
            {
            dbg.location(523,4);
            pushFollow(FOLLOW_expr_in_indices729);
            expr();

            state._fsp--;

            dbg.location(523,9);
            // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:523:9: ( COMA expr )*
            try { dbg.enterSubRule(19);

            loop19:
            do {
                int alt19=2;
                try { dbg.enterDecision(19, decisionCanBacktrack[19]);

                int LA19_0 = input.LA(1);

                if ( (LA19_0==COMA) ) {
                    alt19=1;
                }


                } finally {dbg.exitDecision(19);}

                switch (alt19) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/victor/Dropbox/__Universidad/4o/PL/plp3/plp3.g:523:10: COMA expr
            	    {
            	    dbg.location(523,10);
            	    match(input,COMA,FOLLOW_COMA_in_indices732); 
            	    dbg.location(523,15);
            	    pushFollow(FOLLOW_expr_in_indices734);
            	    expr();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);
            } finally {dbg.exitSubRule(19);}


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
        dbg.location(523, 20);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "indices");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return trad;
    }
    // $ANTLR end "indices"

    // Delegated rules


 

    public static final BitSet FOLLOW_clase_in_s66 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLASS_in_clase80 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_SINGLE_in_clase82 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_LLAVEI_in_clase84 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_metodo_in_clase88 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_LLAVED_in_clase92 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PUBLIC_in_metodo105 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_STATIC_in_metodo107 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_VOID_in_metodo109 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_MAIN_in_metodo111 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_PARI_in_metodo113 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_PARD_in_metodo115 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_bloque_in_metodo117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_tipoSimple131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_tipoSimple138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_tipoSimple145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tipoSimple_in_decl161 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_varid_in_decl167 = new BitSet(new long[]{0x0000002000001000L});
    public static final BitSet FOLLOW_COMA_in_decl172 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_varid_in_decl178 = new BitSet(new long[]{0x0000002000001000L});
    public static final BitSet FOLLOW_PYC_in_decl186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_varid203 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_CORI_in_varid208 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_COMA_in_varid212 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_CORD_in_varid217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instr_in_declins234 = new BitSet(new long[]{0x000180000AF24502L});
    public static final BitSet FOLLOW_decl_in_declins239 = new BitSet(new long[]{0x000180000AF24502L});
    public static final BitSet FOLLOW_LLAVEI_in_bloque256 = new BitSet(new long[]{0x000180000EF24500L});
    public static final BitSet FOLLOW_declins_in_bloque258 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_LLAVED_in_bloque260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bloque_in_instr274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_instr280 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_PARI_in_instr282 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_expr_in_instr284 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_PARD_in_instr286 = new BitSet(new long[]{0x0001800008F04400L});
    public static final BitSet FOLLOW_instr_in_instr288 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ELSE_in_instr291 = new BitSet(new long[]{0x0001800008F04400L});
    public static final BitSet FOLLOW_instr_in_instr293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_instr302 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_PARI_in_instr304 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_expr_in_instr306 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_PARD_in_instr308 = new BitSet(new long[]{0x0001800008F04400L});
    public static final BitSet FOLLOW_instr_in_instr310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOREACH_in_instr316 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_PARI_in_instr318 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_VAR_in_instr320 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ID_in_instr322 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_IN_in_instr324 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ID_in_instr326 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_PARD_in_instr328 = new BitSet(new long[]{0x0001800008F04400L});
    public static final BitSet FOLLOW_instr_in_instr330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_instr336 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_PARI_in_instr338 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_INT_in_instr340 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ID_in_instr342 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ASIG_in_instr344 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_expr_in_instr346 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_TO_in_instr348 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_expr_in_instr350 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_STEP_in_instr352 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_ADDOP_in_instr355 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ENTERO_in_instr359 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_PARD_in_instr361 = new BitSet(new long[]{0x0001800008F04400L});
    public static final BitSet FOLLOW_instr_in_instr363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BREAK_in_instr369 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_PYC_in_instr371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTINUE_in_instr377 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_PYC_in_instr379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ref_in_instr385 = new BitSet(new long[]{0x0000001000000040L});
    public static final BitSet FOLLOW_cambio_in_instr387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_instr393 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ASIG_in_instr395 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_NEW_in_instr397 = new BitSet(new long[]{0x0000000002020100L});
    public static final BitSet FOLLOW_tipoSimple_in_instr399 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_CORI_in_instr401 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_dims_in_instr403 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CORD_in_instr405 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_PYC_in_instr407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WRITELINE_in_instr413 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_PARI_in_instr415 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_expr_in_instr417 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_PARD_in_instr419 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_PYC_in_instr421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENTERO_in_dims435 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_COMA_in_dims438 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ENTERO_in_dims440 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ASIG_in_cambio455 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_expr_in_cambio457 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_PYC_in_cambio459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PUNTO_in_cambio464 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_READLINE_in_cambio466 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_PYC_in_cambio468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_eand_in_expr485 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_OR_in_expr489 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_eand_in_expr495 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_erel_in_eand515 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_AND_in_eand519 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_erel_in_eand525 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_esum_in_erel545 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_RELOP_in_erel549 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_esum_in_erel555 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_term_in_esum576 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ADDOP_in_esum580 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_term_in_esum586 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_factor_in_term606 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_MULOP_in_term610 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_factor_in_term616 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_base_in_factor632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_factor638 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_factor_in_factor640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARI_in_factor645 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ADDOP_in_factor647 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_factor_in_factor649 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_PARD_in_factor651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENTERO_in_base664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REAL_in_base670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEANO_in_base676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARI_in_base682 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_expr_in_base684 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_PARD_in_base686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ref_in_base692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_ref707 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_CORI_in_ref710 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_indices_in_ref712 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CORD_in_ref714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_indices729 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_COMA_in_indices732 = new BitSet(new long[]{0x0000008480480200L});
    public static final BitSet FOLLOW_expr_in_indices734 = new BitSet(new long[]{0x0000000000001002L});

}