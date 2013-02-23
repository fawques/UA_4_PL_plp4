// $ANTLR 3.4 plp3.g 2013-02-23 13:29:41

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class plp3Lexer extends Lexer {
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

    // $ANTLR start "CLASS"
    public final void mCLASS() throws RecognitionException {
        try {
            int _type = CLASS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:528:7: ( 'class' )
            // plp3.g:528:9: 'class'
            {
            match("class"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CLASS"

    // $ANTLR start "SINGLE"
    public final void mSINGLE() throws RecognitionException {
        try {
            int _type = SINGLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:529:8: ( 'Single' )
            // plp3.g:529:10: 'Single'
            {
            match("Single"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SINGLE"

    // $ANTLR start "VOID"
    public final void mVOID() throws RecognitionException {
        try {
            int _type = VOID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:530:6: ( 'void' )
            // plp3.g:530:8: 'void'
            {
            match("void"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VOID"

    // $ANTLR start "MAIN"
    public final void mMAIN() throws RecognitionException {
        try {
            int _type = MAIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:531:6: ( 'Main' )
            // plp3.g:531:8: 'Main'
            {
            match("Main"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MAIN"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:532:5: ( 'int' )
            // plp3.g:532:7: 'int'
            {
            match("int"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "DOUBLE"
    public final void mDOUBLE() throws RecognitionException {
        try {
            int _type = DOUBLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:533:8: ( 'double' )
            // plp3.g:533:10: 'double'
            {
            match("double"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOUBLE"

    // $ANTLR start "BOOL"
    public final void mBOOL() throws RecognitionException {
        try {
            int _type = BOOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:534:6: ( 'bool' )
            // plp3.g:534:8: 'bool'
            {
            match("bool"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BOOL"

    // $ANTLR start "PUBLIC"
    public final void mPUBLIC() throws RecognitionException {
        try {
            int _type = PUBLIC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:535:8: ( 'public' )
            // plp3.g:535:10: 'public'
            {
            match("public"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PUBLIC"

    // $ANTLR start "STATIC"
    public final void mSTATIC() throws RecognitionException {
        try {
            int _type = STATIC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:536:8: ( 'static' )
            // plp3.g:536:10: 'static'
            {
            match("static"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STATIC"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:537:4: ( 'if' )
            // plp3.g:537:7: 'if'
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

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:538:6: ( 'else' )
            // plp3.g:538:9: 'else'
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

    // $ANTLR start "FOREACH"
    public final void mFOREACH() throws RecognitionException {
        try {
            int _type = FOREACH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:539:9: ( 'foreach' )
            // plp3.g:539:11: 'foreach'
            {
            match("foreach"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FOREACH"

    // $ANTLR start "VAR"
    public final void mVAR() throws RecognitionException {
        try {
            int _type = VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:540:5: ( 'var' )
            // plp3.g:540:8: 'var'
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

    // $ANTLR start "IN"
    public final void mIN() throws RecognitionException {
        try {
            int _type = IN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:541:4: ( 'in' )
            // plp3.g:541:7: 'in'
            {
            match("in"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IN"

    // $ANTLR start "FOR"
    public final void mFOR() throws RecognitionException {
        try {
            int _type = FOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:542:5: ( 'for' )
            // plp3.g:542:8: 'for'
            {
            match("for"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FOR"

    // $ANTLR start "TO"
    public final void mTO() throws RecognitionException {
        try {
            int _type = TO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:543:4: ( 'to' )
            // plp3.g:543:7: 'to'
            {
            match("to"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TO"

    // $ANTLR start "STEP"
    public final void mSTEP() throws RecognitionException {
        try {
            int _type = STEP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:544:6: ( 'step' )
            // plp3.g:544:9: 'step'
            {
            match("step"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STEP"

    // $ANTLR start "WHILE"
    public final void mWHILE() throws RecognitionException {
        try {
            int _type = WHILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:545:7: ( 'while' )
            // plp3.g:545:9: 'while'
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

    // $ANTLR start "BREAK"
    public final void mBREAK() throws RecognitionException {
        try {
            int _type = BREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:546:7: ( 'break' )
            // plp3.g:546:9: 'break'
            {
            match("break"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BREAK"

    // $ANTLR start "CONTINUE"
    public final void mCONTINUE() throws RecognitionException {
        try {
            int _type = CONTINUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:547:10: ( 'continue' )
            // plp3.g:547:12: 'continue'
            {
            match("continue"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CONTINUE"

    // $ANTLR start "NEW"
    public final void mNEW() throws RecognitionException {
        try {
            int _type = NEW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:548:5: ( 'new' )
            // plp3.g:548:8: 'new'
            {
            match("new"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NEW"

    // $ANTLR start "WRITELINE"
    public final void mWRITELINE() throws RecognitionException {
        try {
            int _type = WRITELINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:549:11: ( 'System.Console.WriteLine' )
            // plp3.g:549:13: 'System.Console.WriteLine'
            {
            match("System.Console.WriteLine"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WRITELINE"

    // $ANTLR start "READLINE"
    public final void mREADLINE() throws RecognitionException {
        try {
            int _type = READLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:550:10: ( ( 'int' | 'double' | 'bool' ) '.Parse(System.Console.ReadLine())' )
            // plp3.g:550:13: ( 'int' | 'double' | 'bool' ) '.Parse(System.Console.ReadLine())'
            {
            // plp3.g:550:13: ( 'int' | 'double' | 'bool' )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 'i':
                {
                alt1=1;
                }
                break;
            case 'd':
                {
                alt1=2;
                }
                break;
            case 'b':
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
                    // plp3.g:550:14: 'int'
                    {
                    match("int"); 



                    }
                    break;
                case 2 :
                    // plp3.g:550:20: 'double'
                    {
                    match("double"); 



                    }
                    break;
                case 3 :
                    // plp3.g:550:29: 'bool'
                    {
                    match("bool"); 



                    }
                    break;

            }


            match(".Parse(System.Console.ReadLine())"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "READLINE"

    // $ANTLR start "LLAVEI"
    public final void mLLAVEI() throws RecognitionException {
        try {
            int _type = LLAVEI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:553:8: ( '{' )
            // plp3.g:553:10: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LLAVEI"

    // $ANTLR start "LLAVED"
    public final void mLLAVED() throws RecognitionException {
        try {
            int _type = LLAVED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:554:8: ( '}' )
            // plp3.g:554:10: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LLAVED"

    // $ANTLR start "PARI"
    public final void mPARI() throws RecognitionException {
        try {
            int _type = PARI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:555:6: ( '(' )
            // plp3.g:555:8: '('
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
            // plp3.g:556:6: ( ')' )
            // plp3.g:556:8: ')'
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

    // $ANTLR start "CORI"
    public final void mCORI() throws RecognitionException {
        try {
            int _type = CORI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:557:6: ( '[' )
            // plp3.g:557:8: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CORI"

    // $ANTLR start "CORD"
    public final void mCORD() throws RecognitionException {
        try {
            int _type = CORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:558:6: ( ']' )
            // plp3.g:558:8: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CORD"

    // $ANTLR start "COMA"
    public final void mCOMA() throws RecognitionException {
        try {
            int _type = COMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:559:6: ( ',' )
            // plp3.g:559:8: ','
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

    // $ANTLR start "PYC"
    public final void mPYC() throws RecognitionException {
        try {
            int _type = PYC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:560:5: ( ';' )
            // plp3.g:560:7: ';'
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

    // $ANTLR start "ASIG"
    public final void mASIG() throws RecognitionException {
        try {
            int _type = ASIG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:561:6: ( '=' )
            // plp3.g:561:8: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ASIG"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:562:4: ( '|' )
            // plp3.g:562:6: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:563:5: ( '&' )
            // plp3.g:563:7: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "RELOP"
    public final void mRELOP() throws RecognitionException {
        try {
            int _type = RELOP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:564:7: ( '==' | '!=' | '<' | '>' | '<=' | '>=' )
            int alt2=6;
            switch ( input.LA(1) ) {
            case '=':
                {
                alt2=1;
                }
                break;
            case '!':
                {
                alt2=2;
                }
                break;
            case '<':
                {
                int LA2_3 = input.LA(2);

                if ( (LA2_3=='=') ) {
                    alt2=5;
                }
                else {
                    alt2=3;
                }
                }
                break;
            case '>':
                {
                int LA2_4 = input.LA(2);

                if ( (LA2_4=='=') ) {
                    alt2=6;
                }
                else {
                    alt2=4;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // plp3.g:564:9: '=='
                    {
                    match("=="); 



                    }
                    break;
                case 2 :
                    // plp3.g:564:16: '!='
                    {
                    match("!="); 



                    }
                    break;
                case 3 :
                    // plp3.g:564:21: '<'
                    {
                    match('<'); 

                    }
                    break;
                case 4 :
                    // plp3.g:564:27: '>'
                    {
                    match('>'); 

                    }
                    break;
                case 5 :
                    // plp3.g:564:33: '<='
                    {
                    match("<="); 



                    }
                    break;
                case 6 :
                    // plp3.g:564:40: '>='
                    {
                    match(">="); 



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

    // $ANTLR start "ADDOP"
    public final void mADDOP() throws RecognitionException {
        try {
            int _type = ADDOP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:565:7: ( '+' | '-' )
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

    // $ANTLR start "MULOP"
    public final void mMULOP() throws RecognitionException {
        try {
            int _type = MULOP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:566:7: ( '*' | '/' )
            // plp3.g:
            {
            if ( input.LA(1)=='*'||input.LA(1)=='/' ) {
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
    // $ANTLR end "MULOP"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:567:5: ( '!' )
            // plp3.g:567:7: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "PUNTO"
    public final void mPUNTO() throws RecognitionException {
        try {
            int _type = PUNTO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:568:7: ( '.' )
            // plp3.g:568:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PUNTO"

    // $ANTLR start "ENTERO"
    public final void mENTERO() throws RecognitionException {
        try {
            int _type = ENTERO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:569:8: ( ( '0' .. '9' )+ )
            // plp3.g:569:10: ( '0' .. '9' )+
            {
            // plp3.g:569:10: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                    alt3=1;
                }


                switch (alt3) {
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
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ENTERO"

    // $ANTLR start "REAL"
    public final void mREAL() throws RecognitionException {
        try {
            int _type = REAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:570:6: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
            // plp3.g:570:8: ( '0' .. '9' )+ '.' ( '0' .. '9' )+
            {
            // plp3.g:570:8: ( '0' .. '9' )+
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

            // plp3.g:570:22: ( '0' .. '9' )+
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
    // $ANTLR end "REAL"

    // $ANTLR start "BOOLEANO"
    public final void mBOOLEANO() throws RecognitionException {
        try {
            int _type = BOOLEANO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:571:10: ( 'True' | 'False' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='T') ) {
                alt6=1;
            }
            else if ( (LA6_0=='F') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // plp3.g:571:12: 'True'
                    {
                    match("True"); 



                    }
                    break;
                case 2 :
                    // plp3.g:571:19: 'False'
                    {
                    match("False"); 



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
    // $ANTLR end "BOOLEANO"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:572:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // plp3.g:572:8: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // plp3.g:572:27: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= '0' && LA7_0 <= '9')||(LA7_0 >= 'A' && LA7_0 <= 'Z')||LA7_0=='_'||(LA7_0 >= 'a' && LA7_0 <= 'z')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // plp3.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
            	    break loop7;
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

    // $ANTLR start "BLANCOS"
    public final void mBLANCOS() throws RecognitionException {
        try {
            int _type = BLANCOS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // plp3.g:576:9: ( ( '\\t' | '\\n' | '\\r' | ' ' )+ )
            // plp3.g:576:11: ( '\\t' | '\\n' | '\\r' | ' ' )+
            {
            // plp3.g:576:11: ( '\\t' | '\\n' | '\\r' | ' ' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= '\t' && LA8_0 <= '\n')||LA8_0=='\r'||LA8_0==' ') ) {
                    alt8=1;
                }


                switch (alt8) {
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
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
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
            // plp3.g:578:12: ( '/*' ( options {greedy=false; } : . )* '*/' | '//' ( options {greedy=false; } : . )* '\\n' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='/') ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1=='*') ) {
                    alt11=1;
                }
                else if ( (LA11_1=='/') ) {
                    alt11=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }
            switch (alt11) {
                case 1 :
                    // plp3.g:578:14: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 



                    // plp3.g:578:19: ( options {greedy=false; } : . )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0=='*') ) {
                            int LA9_1 = input.LA(2);

                            if ( (LA9_1=='/') ) {
                                alt9=2;
                            }
                            else if ( ((LA9_1 >= '\u0000' && LA9_1 <= '.')||(LA9_1 >= '0' && LA9_1 <= '\uFFFF')) ) {
                                alt9=1;
                            }


                        }
                        else if ( ((LA9_0 >= '\u0000' && LA9_0 <= ')')||(LA9_0 >= '+' && LA9_0 <= '\uFFFF')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // plp3.g:578:49: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    match("*/"); 



                    skip();

                    }
                    break;
                case 2 :
                    // plp3.g:579:5: '//' ( options {greedy=false; } : . )* '\\n'
                    {
                    match("//"); 



                    // plp3.g:579:10: ( options {greedy=false; } : . )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0=='\n') ) {
                            alt10=2;
                        }
                        else if ( ((LA10_0 >= '\u0000' && LA10_0 <= '\t')||(LA10_0 >= '\u000B' && LA10_0 <= '\uFFFF')) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // plp3.g:579:40: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    match('\n'); 

                    skip();

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
    // $ANTLR end "COMENTARIO"

    public void mTokens() throws RecognitionException {
        // plp3.g:1:8: ( CLASS | SINGLE | VOID | MAIN | INT | DOUBLE | BOOL | PUBLIC | STATIC | IF | ELSE | FOREACH | VAR | IN | FOR | TO | STEP | WHILE | BREAK | CONTINUE | NEW | WRITELINE | READLINE | LLAVEI | LLAVED | PARI | PARD | CORI | CORD | COMA | PYC | ASIG | OR | AND | RELOP | ADDOP | MULOP | NOT | PUNTO | ENTERO | REAL | BOOLEANO | ID | BLANCOS | COMENTARIO )
        int alt12=45;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // plp3.g:1:10: CLASS
                {
                mCLASS(); 


                }
                break;
            case 2 :
                // plp3.g:1:16: SINGLE
                {
                mSINGLE(); 


                }
                break;
            case 3 :
                // plp3.g:1:23: VOID
                {
                mVOID(); 


                }
                break;
            case 4 :
                // plp3.g:1:28: MAIN
                {
                mMAIN(); 


                }
                break;
            case 5 :
                // plp3.g:1:33: INT
                {
                mINT(); 


                }
                break;
            case 6 :
                // plp3.g:1:37: DOUBLE
                {
                mDOUBLE(); 


                }
                break;
            case 7 :
                // plp3.g:1:44: BOOL
                {
                mBOOL(); 


                }
                break;
            case 8 :
                // plp3.g:1:49: PUBLIC
                {
                mPUBLIC(); 


                }
                break;
            case 9 :
                // plp3.g:1:56: STATIC
                {
                mSTATIC(); 


                }
                break;
            case 10 :
                // plp3.g:1:63: IF
                {
                mIF(); 


                }
                break;
            case 11 :
                // plp3.g:1:66: ELSE
                {
                mELSE(); 


                }
                break;
            case 12 :
                // plp3.g:1:71: FOREACH
                {
                mFOREACH(); 


                }
                break;
            case 13 :
                // plp3.g:1:79: VAR
                {
                mVAR(); 


                }
                break;
            case 14 :
                // plp3.g:1:83: IN
                {
                mIN(); 


                }
                break;
            case 15 :
                // plp3.g:1:86: FOR
                {
                mFOR(); 


                }
                break;
            case 16 :
                // plp3.g:1:90: TO
                {
                mTO(); 


                }
                break;
            case 17 :
                // plp3.g:1:93: STEP
                {
                mSTEP(); 


                }
                break;
            case 18 :
                // plp3.g:1:98: WHILE
                {
                mWHILE(); 


                }
                break;
            case 19 :
                // plp3.g:1:104: BREAK
                {
                mBREAK(); 


                }
                break;
            case 20 :
                // plp3.g:1:110: CONTINUE
                {
                mCONTINUE(); 


                }
                break;
            case 21 :
                // plp3.g:1:119: NEW
                {
                mNEW(); 


                }
                break;
            case 22 :
                // plp3.g:1:123: WRITELINE
                {
                mWRITELINE(); 


                }
                break;
            case 23 :
                // plp3.g:1:133: READLINE
                {
                mREADLINE(); 


                }
                break;
            case 24 :
                // plp3.g:1:142: LLAVEI
                {
                mLLAVEI(); 


                }
                break;
            case 25 :
                // plp3.g:1:149: LLAVED
                {
                mLLAVED(); 


                }
                break;
            case 26 :
                // plp3.g:1:156: PARI
                {
                mPARI(); 


                }
                break;
            case 27 :
                // plp3.g:1:161: PARD
                {
                mPARD(); 


                }
                break;
            case 28 :
                // plp3.g:1:166: CORI
                {
                mCORI(); 


                }
                break;
            case 29 :
                // plp3.g:1:171: CORD
                {
                mCORD(); 


                }
                break;
            case 30 :
                // plp3.g:1:176: COMA
                {
                mCOMA(); 


                }
                break;
            case 31 :
                // plp3.g:1:181: PYC
                {
                mPYC(); 


                }
                break;
            case 32 :
                // plp3.g:1:185: ASIG
                {
                mASIG(); 


                }
                break;
            case 33 :
                // plp3.g:1:190: OR
                {
                mOR(); 


                }
                break;
            case 34 :
                // plp3.g:1:193: AND
                {
                mAND(); 


                }
                break;
            case 35 :
                // plp3.g:1:197: RELOP
                {
                mRELOP(); 


                }
                break;
            case 36 :
                // plp3.g:1:203: ADDOP
                {
                mADDOP(); 


                }
                break;
            case 37 :
                // plp3.g:1:209: MULOP
                {
                mMULOP(); 


                }
                break;
            case 38 :
                // plp3.g:1:215: NOT
                {
                mNOT(); 


                }
                break;
            case 39 :
                // plp3.g:1:219: PUNTO
                {
                mPUNTO(); 


                }
                break;
            case 40 :
                // plp3.g:1:225: ENTERO
                {
                mENTERO(); 


                }
                break;
            case 41 :
                // plp3.g:1:232: REAL
                {
                mREAL(); 


                }
                break;
            case 42 :
                // plp3.g:1:237: BOOLEANO
                {
                mBOOLEANO(); 


                }
                break;
            case 43 :
                // plp3.g:1:246: ID
                {
                mID(); 


                }
                break;
            case 44 :
                // plp3.g:1:249: BLANCOS
                {
                mBLANCOS(); 


                }
                break;
            case 45 :
                // plp3.g:1:257: COMENTARIO
                {
                mCOMENTARIO(); 


                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\16\42\10\uffff\1\70\2\uffff\1\71\2\uffff\1\44\1\uffff\1"+
        "\73\2\42\3\uffff\7\42\1\107\1\110\7\42\1\121\2\42\5\uffff\7\42\1"+
        "\133\1\42\1\135\2\uffff\7\42\1\147\1\uffff\1\42\1\151\6\42\1\160"+
        "\1\uffff\1\161\2\uffff\1\42\1\163\3\42\1\167\1\170\1\42\1\uffff"+
        "\1\42\1\uffff\1\173\1\42\1\175\3\42\2\uffff\1\42\1\uffff\1\u0082"+
        "\2\42\2\uffff\1\42\1\u0086\1\uffff\1\173\1\uffff\1\42\1\u0088\1"+
        "\42\1\u008a\1\uffff\1\u008b\1\u008c\1\42\1\uffff\1\42\5\uffff\1"+
        "\u008f\1\u0090\2\uffff";
    static final String DFA12_eofS =
        "\u0091\uffff";
    static final String DFA12_minS =
        "\1\11\1\154\1\151\2\141\1\146\2\157\1\165\1\164\1\154\2\157\1\150"+
        "\1\145\10\uffff\1\75\2\uffff\1\75\2\uffff\1\52\1\uffff\1\56\1\162"+
        "\1\141\3\uffff\1\141\2\156\1\163\1\151\1\162\1\151\2\60\1\165\1"+
        "\157\1\145\1\142\1\141\1\163\1\162\1\60\1\151\1\167\5\uffff\1\165"+
        "\1\154\1\163\1\164\1\147\1\164\1\144\1\60\1\156\1\56\2\uffff\1\142"+
        "\1\154\1\141\1\154\1\164\1\160\1\145\1\60\1\uffff\1\154\1\60\1\145"+
        "\2\163\1\151\1\154\1\145\1\60\1\uffff\1\60\2\uffff\1\154\1\56\1"+
        "\153\2\151\2\60\1\141\1\uffff\1\145\1\uffff\1\60\1\145\1\60\1\156"+
        "\1\145\1\155\2\uffff\1\145\1\uffff\1\60\2\143\2\uffff\1\143\1\60"+
        "\1\uffff\1\60\1\uffff\1\165\1\60\2\56\1\uffff\2\60\1\150\1\uffff"+
        "\1\145\5\uffff\2\60\2\uffff";
    static final String DFA12_maxS =
        "\1\175\1\157\1\171\1\157\1\141\1\156\1\157\1\162\1\165\1\164\1\154"+
        "\2\157\1\150\1\145\10\uffff\1\75\2\uffff\1\75\2\uffff\1\57\1\uffff"+
        "\1\71\1\162\1\141\3\uffff\1\141\2\156\1\163\1\151\1\162\1\151\2"+
        "\172\1\165\1\157\1\145\1\142\1\145\1\163\1\162\1\172\1\151\1\167"+
        "\5\uffff\1\165\1\154\1\163\1\164\1\147\1\164\1\144\1\172\1\156\1"+
        "\172\2\uffff\1\142\1\154\1\141\1\154\1\164\1\160\1\145\1\172\1\uffff"+
        "\1\154\1\172\1\145\2\163\1\151\1\154\1\145\1\172\1\uffff\1\172\2"+
        "\uffff\1\154\1\172\1\153\2\151\2\172\1\141\1\uffff\1\145\1\uffff"+
        "\1\172\1\145\1\172\1\156\1\145\1\155\2\uffff\1\145\1\uffff\1\172"+
        "\2\143\2\uffff\1\143\1\172\1\uffff\1\172\1\uffff\1\165\1\172\1\56"+
        "\1\172\1\uffff\2\172\1\150\1\uffff\1\145\5\uffff\2\172\2\uffff";
    static final String DFA12_acceptS =
        "\17\uffff\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\uffff\1\41\1"+
        "\42\1\uffff\1\43\1\44\1\uffff\1\47\3\uffff\1\53\1\54\1\45\23\uffff"+
        "\1\40\1\46\1\55\1\50\1\51\12\uffff\1\16\1\12\10\uffff\1\20\11\uffff"+
        "\1\15\1\uffff\1\5\1\27\10\uffff\1\17\1\uffff\1\25\6\uffff\1\3\1"+
        "\4\1\uffff\1\7\3\uffff\1\21\1\13\2\uffff\1\52\1\uffff\1\1\4\uffff"+
        "\1\23\3\uffff\1\22\1\uffff\1\2\1\26\1\6\1\10\1\11\2\uffff\1\14\1"+
        "\24";
    static final String DFA12_specialS =
        "\u0091\uffff}>";
    static final String[] DFA12_transitionS = {
            "\2\43\2\uffff\1\43\22\uffff\1\43\1\32\4\uffff\1\31\1\uffff\1"+
            "\21\1\22\1\44\1\34\1\25\1\34\1\36\1\35\12\37\1\uffff\1\26\1"+
            "\33\1\27\1\33\2\uffff\5\42\1\41\6\42\1\4\5\42\1\2\1\40\6\42"+
            "\1\23\1\uffff\1\24\3\uffff\1\42\1\7\1\1\1\6\1\12\1\13\2\42\1"+
            "\5\4\42\1\16\1\42\1\10\2\42\1\11\1\14\1\42\1\3\1\15\3\42\1\17"+
            "\1\30\1\20",
            "\1\45\2\uffff\1\46",
            "\1\47\17\uffff\1\50",
            "\1\52\15\uffff\1\51",
            "\1\53",
            "\1\55\7\uffff\1\54",
            "\1\56",
            "\1\57\2\uffff\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\33",
            "",
            "",
            "\1\33",
            "",
            "",
            "\1\72\4\uffff\1\72",
            "",
            "\1\74\1\uffff\12\37",
            "\1\75",
            "\1\76",
            "",
            "",
            "",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\23\42\1\106\6\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115\3\uffff\1\116",
            "\1\117",
            "\1\120",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\122",
            "\1\123",
            "",
            "",
            "",
            "",
            "",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\134",
            "\1\136\1\uffff\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32"+
            "\42",
            "",
            "",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\4\42\1\146\25\42",
            "",
            "\1\150",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "",
            "\1\162",
            "\1\136\1\uffff\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32"+
            "\42",
            "\1\164",
            "\1\165",
            "\1\166",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\171",
            "",
            "\1\172",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\174",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "",
            "",
            "\1\u0081",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u0083",
            "\1\u0084",
            "",
            "",
            "\1\u0085",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\1\u0087",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u0089",
            "\1\136\1\uffff\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32"+
            "\42",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u008d",
            "",
            "\1\u008e",
            "",
            "",
            "",
            "",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( CLASS | SINGLE | VOID | MAIN | INT | DOUBLE | BOOL | PUBLIC | STATIC | IF | ELSE | FOREACH | VAR | IN | FOR | TO | STEP | WHILE | BREAK | CONTINUE | NEW | WRITELINE | READLINE | LLAVEI | LLAVED | PARI | PARD | CORI | CORD | COMA | PYC | ASIG | OR | AND | RELOP | ADDOP | MULOP | NOT | PUNTO | ENTERO | REAL | BOOLEANO | ID | BLANCOS | COMENTARIO );";
        }
    }
 

}