
/**
 *
 * @author victor
 */
public class Error_19 extends Exception{
    
    String coderror = "Error 19 (";
    String mensaje1 = "): identificador '";
    String mensaje2 = "' usado incorrectamente";
    String lexema;
    int fila,columna;
    
    public Error_19(String lex, int _fila, int _columna){
        lexema = lex;
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1 + lexema + mensaje2;
    }
    
    
}
