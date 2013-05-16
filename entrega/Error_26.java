
/**
 *
 * @author victor
 */
public class Error_26 extends Exception{
    
    String coderror = "Error 26 (";
    String mensaje1 = "): objeto '";
    String mensaje2 = "' no es de clase '";
    String lexema1;
    String lexema2;
    int fila,columna;
    
    public Error_26(String lex1, String lex2, int _fila, int _columna){
        lexema1 = lex1;
        lexema2 = lex2;
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1 + lexema1 + mensaje2 + lexema2 + "'";
    }
    
    
}
