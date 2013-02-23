import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        plp3Lexer lex = new plp3Lexer(new ANTLRFileStream("/home/victor/Dropbox/__Universidad/4o/PL/plp3/1000_mod.fnt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        plp3Parser g = new plp3Parser(tokens, 49100, null);
        try {
            g.s();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}