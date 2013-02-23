// $ANTLR 3.4 plp3.g 2013-02-05 13:37:26

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class plp3Lexer extends Lexer {
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


          public void emitErrorMessage(String msg) {

            System.err.println(msg);

            System.exit(1);

          }

        

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public plp3Lexer() {} 
    public plp3Lexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public plp3Lexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "plp3.g"; }

    // $ANTLR start "PARI"
    public final void mPARI() throws RecognitionException {
        try {
            int _type = PARI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:405:6: ( '(' )
            // plp3.g:405:8: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PARI"

    // $ANTLR start "PARD"
    public final void mPARD() throws RecognitionException {
        try {
            int _type = PARD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:406:6: ( ')' )
            // plp3.g:406:8: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PARD"

    // $ANTLR start "MULOP"
    public final void mMULOP() throws RecognitionException {
        try {
            int _type = MULOP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:407:7: ( '*' | '/' | 'div' )
            int alt1=3;
            switch ( input.LA(1) ) {
            case '*':
                {
                alt1=1;
                }
                break;
            case '/':
                {
                alt1=2;
                }
                break;
            case 'd':
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
                    // plp3.g:407:9: '*'
                    {
                    match('*'); 

                    }
                    break;
                case 2 :
                    // plp3.g:407:15: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 3 :
                    // plp3.g:407:21: 'div'
                    {
                    match("div"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MULOP"

    // $ANTLR start "ADDOP"
    public final void mADDOP() throws RecognitionException {
        try {
            int _type = ADDOP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:408:7: ( '+' | '-' )
            // plp3.g:
            {
            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ADDOP"

    // $ANTLR start "RELOP"
    public final void mRELOP() throws RecognitionException {
        try {
            int _type = RELOP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:409:7: ( '<' | '>' | '<=' | '>=' | '=' | '<>' )
            int alt2=6;
            switch ( input.LA(1) ) {
            case '<':
                {
                switch ( input.LA(2) ) {
                case '=':
                    {
                    alt2=3;
                    }
                    break;
                case '>':
                    {
                    alt2=6;
                    }
                    break;
                default:
                    alt2=1;
                }

                }
                break;
            case '>':
                {
                int LA2_2 = input.LA(2);

                if ( (LA2_2=='=') ) {
                    alt2=4;
                }
                else {
                    alt2=2;
                }
                }
                break;
            case '=':
                {
                alt2=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // plp3.g:409:9: '<'
                    {
                    match('<'); 

                    }
                    break;
                case 2 :
                    // plp3.g:409:15: '>'
                    {
                    match('>'); 

                    }
                    break;
                case 3 :
                    // plp3.g:409:21: '<='
                    {
                    match("<="); 



                    }
                    break;
                case 4 :
                    // plp3.g:409:28: '>='
                    {
                    match(">="); 



                    }
                    break;
                case 5 :
                    // plp3.g:409:35: '='
                    {
                    match('='); 

                    }
                    break;
                case 6 :
                    // plp3.g:409:41: '<>'
                    {
                    match("<>"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RELOP"

    // $ANTLR start "PYC"
    public final void mPYC() throws RecognitionException {
        try {
            int _type = PYC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:410:5: ( ';' )
            // plp3.g:410:7: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PYC"

    // $ANTLR start "DOSP"
    public final void mDOSP() throws RecognitionException {
        try {
            int _type = DOSP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:411:6: ( ':' )
            // plp3.g:411:8: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOSP"

    // $ANTLR start "COMA"
    public final void mCOMA() throws RecognitionException {
        try {
            int _type = COMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:412:6: ( ',' )
            // plp3.g:412:8: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMA"

    // $ANTLR start "ASIG"
    public final void mASIG() throws RecognitionException {
        try {
            int _type = ASIG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:413:6: ( ':=' )
            // plp3.g:413:8: ':='
            {
            match(":="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ASIG"

    // $ANTLR start "VAR"
    public final void mVAR() throws RecognitionException {
        try {
            int _type = VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:414:5: ( 'var' )
            // plp3.g:414:7: 'var'
            {
            match("var"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VAR"

    // $ANTLR start "REAL"
    public final void mREAL() throws RecognitionException {
        try {
            int _type = REAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:415:6: ( 'real' )
            // plp3.g:415:8: 'real'
            {
            match("real"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "REAL"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:416:9: ( 'integer' )
            // plp3.g:416:11: 'integer'
            {
            match("integer"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "PROGRAM"
    public final void mPROGRAM() throws RecognitionException {
        try {
            int _type = PROGRAM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:417:9: ( 'program' )
            // plp3.g:417:11: 'program'
            {
            match("program"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PROGRAM"

    // $ANTLR start "BEGIN"
    public final void mBEGIN() throws RecognitionException {
        try {
            int _type = BEGIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:418:7: ( 'begin' )
            // plp3.g:418:9: 'begin'
            {
            match("begin"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BEGIN"

    // $ANTLR start "END"
    public final void mEND() throws RecognitionException {
        try {
            int _type = END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:419:5: ( 'end' )
            // plp3.g:419:7: 'end'
            {
            match("end"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "END"

    // $ANTLR start "FUNCTION"
    public final void mFUNCTION() throws RecognitionException {
        try {
            int _type = FUNCTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:420:10: ( 'function' )
            // plp3.g:420:12: 'function'
            {
            match("function"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FUNCTION"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:421:4: ( 'if' )
            // plp3.g:421:6: 'if'
            {
            match("if"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "THEN"
    public final void mTHEN() throws RecognitionException {
        try {
            int _type = THEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:422:6: ( 'then' )
            // plp3.g:422:8: 'then'
            {
            match("then"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "THEN"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:423:6: ( 'else' )
            // plp3.g:423:8: 'else'
            {
            match("else"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "ENDIF"
    public final void mENDIF() throws RecognitionException {
        try {
            int _type = ENDIF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:424:7: ( 'endif' )
            // plp3.g:424:9: 'endif'
            {
            match("endif"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ENDIF"

    // $ANTLR start "WHILE"
    public final void mWHILE() throws RecognitionException {
        try {
            int _type = WHILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:425:7: ( 'while' )
            // plp3.g:425:9: 'while'
            {
            match("while"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHILE"

    // $ANTLR start "DO"
    public final void mDO() throws RecognitionException {
        try {
            int _type = DO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:426:4: ( 'do' )
            // plp3.g:426:6: 'do'
            {
            match("do"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DO"

    // $ANTLR start "WRITELN"
    public final void mWRITELN() throws RecognitionException {
        try {
            int _type = WRITELN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:427:9: ( 'writeln' )
            // plp3.g:427:11: 'writeln'
            {
            match("writeln"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WRITELN"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:429:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
            // plp3.g:429:8: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // plp3.g:429:27: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // plp3.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "NREAL"
    public final void mNREAL() throws RecognitionException {
        try {
            int _type = NREAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:430:7: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
            // plp3.g:430:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )+
            {
            // plp3.g:430:9: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // plp3.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            match('.'); 

            // plp3.g:430:23: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // plp3.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NREAL"

    // $ANTLR start "NENTERO"
    public final void mNENTERO() throws RecognitionException {
        try {
            int _type = NENTERO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:431:9: ( ( '0' .. '9' )+ )
            // plp3.g:431:11: ( '0' .. '9' )+
            {
            // plp3.g:431:11: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // plp3.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NENTERO"

    // $ANTLR start "BLANCOS"
    public final void mBLANCOS() throws RecognitionException {
        try {
            int _type = BLANCOS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:433:9: ( ( '\\t' | '\\n' | '\\r' | ' ' )+ )
            // plp3.g:433:11: ( '\\t' | '\\n' | '\\r' | ' ' )+
            {
            // plp3.g:433:11: ( '\\t' | '\\n' | '\\r' | ' ' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= '\t' && LA7_0 <= '\n')||LA7_0=='\r'||LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // plp3.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BLANCOS"

    // $ANTLR start "COMENTARIO"
    public final void mCOMENTARIO() throws RecognitionException {
        try {
            int _type = COMENTARIO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:435:12: ( '(*' ( options {greedy=false; } : . )* '*)' )
            // plp3.g:435:14: '(*' ( options {greedy=false; } : . )* '*)'
            {
            match("(*"); 



            // plp3.g:435:19: ( options {greedy=false; } : . )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='*') ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1==')') ) {
                        alt8=2;
                    }
                    else if ( ((LA8_1 >= '\u0000' && LA8_1 <= '(')||(LA8_1 >= '*' && LA8_1 <= '\uFFFF')) ) {
                        alt8=1;
                    }


                }
                else if ( ((LA8_0 >= '\u0000' && LA8_0 <= ')')||(LA8_0 >= '+' && LA8_0 <= '\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // plp3.g:435:49: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            match("*)"); 



            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMENTARIO"

    public void mTokens() throws RecognitionException {
        // plp3.g:1:8: ( PARI | PARD | MULOP | ADDOP | RELOP | PYC | DOSP | COMA | ASIG | VAR | REAL | INTEGER | PROGRAM | BEGIN | END | FUNCTION | IF | THEN | ELSE | ENDIF | WHILE | DO | WRITELN | ID | NREAL | NENTERO | BLANCOS | COMENTARIO )
        int alt9=28;
        alt9 = dfa9.predict(input);
        switch (alt9) {
            case 1 :
                // plp3.g:1:10: PARI
                {
                mPARI(); 


                }
                break;
            case 2 :
                // plp3.g:1:15: PARD
                {
                mPARD(); 


                }
                break;
            case 3 :
                // plp3.g:1:20: MULOP
                {
                mMULOP(); 


                }
                break;
            case 4 :
                // plp3.g:1:26: ADDOP
                {
                mADDOP(); 


                }
                break;
            case 5 :
                // plp3.g:1:32: RELOP
                {
                mRELOP(); 


                }
                break;
            case 6 :
                // plp3.g:1:38: PYC
                {
                mPYC(); 


                }
                break;
            case 7 :
                // plp3.g:1:42: DOSP
                {
                mDOSP(); 


                }
                break;
            case 8 :
                // plp3.g:1:47: COMA
                {
                mCOMA(); 


                }
                break;
            case 9 :
                // plp3.g:1:52: ASIG
                {
                mASIG(); 


                }
                break;
            case 10 :
                // plp3.g:1:57: VAR
                {
                mVAR(); 


                }
                break;
            case 11 :
                // plp3.g:1:61: REAL
                {
                mREAL(); 


                }
                break;
            case 12 :
                // plp3.g:1:66: INTEGER
                {
                mINTEGER(); 


                }
                break;
            case 13 :
                // plp3.g:1:74: PROGRAM
                {
                mPROGRAM(); 


                }
                break;
            case 14 :
                // plp3.g:1:82: BEGIN
                {
                mBEGIN(); 


                }
                break;
            case 15 :
                // plp3.g:1:88: END
                {
                mEND(); 


                }
                break;
            case 16 :
                // plp3.g:1:92: FUNCTION
                {
                mFUNCTION(); 


                }
                break;
            case 17 :
                // plp3.g:1:101: IF
                {
                mIF(); 


                }
                break;
            case 18 :
                // plp3.g:1:104: THEN
                {
                mTHEN(); 


                }
                break;
            case 19 :
                // plp3.g:1:109: ELSE
                {
                mELSE(); 


                }
                break;
            case 20 :
                // plp3.g:1:114: ENDIF
                {
                mENDIF(); 


                }
                break;
            case 21 :
                // plp3.g:1:120: WHILE
                {
                mWHILE(); 


                }
                break;
            case 22 :
                // plp3.g:1:126: DO
                {
                mDO(); 


                }
                break;
            case 23 :
                // plp3.g:1:129: WRITELN
                {
                mWRITELN(); 


                }
                break;
            case 24 :
                // plp3.g:1:137: ID
                {
                mID(); 


                }
                break;
            case 25 :
                // plp3.g:1:140: NREAL
                {
                mNREAL(); 


                }
                break;
            case 26 :
                // plp3.g:1:146: NENTERO
                {
                mNENTERO(); 


                }
                break;
            case 27 :
                // plp3.g:1:154: BLANCOS
                {
                mBLANCOS(); 


                }
                break;
            case 28 :
                // plp3.g:1:162: COMENTARIO
                {
                mCOMENTARIO(); 


                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\1\uffff\1\27\2\uffff\1\23\3\uffff\1\33\1\uffff\11\23\1\uffff\1"+
        "\51\3\uffff\1\23\1\53\2\uffff\3\23\1\57\10\23\2\uffff\1\3\1\uffff"+
        "\1\70\2\23\1\uffff\2\23\1\76\5\23\1\uffff\1\104\4\23\1\uffff\1\111"+
        "\1\23\1\113\2\23\1\uffff\2\23\1\120\1\121\1\uffff\1\23\1\uffff\1"+
        "\123\3\23\2\uffff\1\23\1\uffff\1\23\1\131\1\132\1\23\1\134\2\uffff"+
        "\1\135\2\uffff";
    static final String DFA9_eofS =
        "\136\uffff";
    static final String DFA9_minS =
        "\1\11\1\52\2\uffff\1\151\3\uffff\1\75\1\uffff\1\141\1\145\1\146"+
        "\1\162\1\145\1\154\1\165\2\150\1\uffff\1\56\3\uffff\1\166\1\60\2"+
        "\uffff\1\162\1\141\1\164\1\60\1\157\1\147\1\144\1\163\1\156\1\145"+
        "\2\151\2\uffff\1\60\1\uffff\1\60\1\154\1\145\1\uffff\1\147\1\151"+
        "\1\60\1\145\1\143\1\156\1\154\1\164\1\uffff\1\60\1\147\1\162\1\156"+
        "\1\146\1\uffff\1\60\1\164\1\60\2\145\1\uffff\1\145\1\141\2\60\1"+
        "\uffff\1\151\1\uffff\1\60\1\154\1\162\1\155\2\uffff\1\157\1\uffff"+
        "\1\156\2\60\1\156\1\60\2\uffff\1\60\2\uffff";
    static final String DFA9_maxS =
        "\1\172\1\52\2\uffff\1\157\3\uffff\1\75\1\uffff\1\141\1\145\1\156"+
        "\1\162\1\145\1\156\1\165\1\150\1\162\1\uffff\1\71\3\uffff\1\166"+
        "\1\172\2\uffff\1\162\1\141\1\164\1\172\1\157\1\147\1\144\1\163\1"+
        "\156\1\145\2\151\2\uffff\1\172\1\uffff\1\172\1\154\1\145\1\uffff"+
        "\1\147\1\151\1\172\1\145\1\143\1\156\1\154\1\164\1\uffff\1\172\1"+
        "\147\1\162\1\156\1\146\1\uffff\1\172\1\164\1\172\2\145\1\uffff\1"+
        "\145\1\141\2\172\1\uffff\1\151\1\uffff\1\172\1\154\1\162\1\155\2"+
        "\uffff\1\157\1\uffff\1\156\2\172\1\156\1\172\2\uffff\1\172\2\uffff";
    static final String DFA9_acceptS =
        "\2\uffff\1\2\1\3\1\uffff\1\4\1\5\1\6\1\uffff\1\10\11\uffff\1\30"+
        "\1\uffff\1\33\1\34\1\1\2\uffff\1\11\1\7\14\uffff\1\31\1\32\1\uffff"+
        "\1\26\3\uffff\1\21\10\uffff\1\12\5\uffff\1\17\5\uffff\1\13\4\uffff"+
        "\1\23\1\uffff\1\22\4\uffff\1\16\1\24\1\uffff\1\25\5\uffff\1\14\1"+
        "\15\1\uffff\1\27\1\20";
    static final String DFA9_specialS =
        "\136\uffff}>";
    static final String[] DFA9_transitionS = {
            "\2\25\2\uffff\1\25\22\uffff\1\25\7\uffff\1\1\1\2\1\3\1\5\1\11"+
            "\1\5\1\uffff\1\3\12\24\1\10\1\7\3\6\2\uffff\32\23\6\uffff\1"+
            "\23\1\16\1\23\1\4\1\17\1\20\2\23\1\14\6\23\1\15\1\23\1\13\1"+
            "\23\1\21\1\23\1\12\1\22\3\23",
            "\1\26",
            "",
            "",
            "\1\30\5\uffff\1\31",
            "",
            "",
            "",
            "\1\32",
            "",
            "\1\34",
            "\1\35",
            "\1\37\7\uffff\1\36",
            "\1\40",
            "\1\41",
            "\1\43\1\uffff\1\42",
            "\1\44",
            "\1\45",
            "\1\46\11\uffff\1\47",
            "",
            "\1\50\1\uffff\12\24",
            "",
            "",
            "",
            "\1\52",
            "\12\23\7\uffff\32\23\6\uffff\32\23",
            "",
            "",
            "\1\54",
            "\1\55",
            "\1\56",
            "\12\23\7\uffff\32\23\6\uffff\32\23",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "",
            "",
            "\12\23\7\uffff\32\23\6\uffff\32\23",
            "",
            "\12\23\7\uffff\32\23\6\uffff\32\23",
            "\1\71",
            "\1\72",
            "",
            "\1\73",
            "\1\74",
            "\12\23\7\uffff\32\23\6\uffff\10\23\1\75\21\23",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "",
            "\12\23\7\uffff\32\23\6\uffff\32\23",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "",
            "\12\23\7\uffff\32\23\6\uffff\32\23",
            "\1\112",
            "\12\23\7\uffff\32\23\6\uffff\32\23",
            "\1\114",
            "\1\115",
            "",
            "\1\116",
            "\1\117",
            "\12\23\7\uffff\32\23\6\uffff\32\23",
            "\12\23\7\uffff\32\23\6\uffff\32\23",
            "",
            "\1\122",
            "",
            "\12\23\7\uffff\32\23\6\uffff\32\23",
            "\1\124",
            "\1\125",
            "\1\126",
            "",
            "",
            "\1\127",
            "",
            "\1\130",
            "\12\23\7\uffff\32\23\6\uffff\32\23",
            "\12\23\7\uffff\32\23\6\uffff\32\23",
            "\1\133",
            "\12\23\7\uffff\32\23\6\uffff\32\23",
            "",
            "",
            "\12\23\7\uffff\32\23\6\uffff\32\23",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( PARI | PARD | MULOP | ADDOP | RELOP | PYC | DOSP | COMA | ASIG | VAR | REAL | INTEGER | PROGRAM | BEGIN | END | FUNCTION | IF | THEN | ELSE | ENDIF | WHILE | DO | WRITELN | ID | NREAL | NENTERO | BLANCOS | COMENTARIO );";
        }
    }
 

}