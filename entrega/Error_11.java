
/**
 *
 * @author victor
 */
public class Error_11 extends Exception{
    
    String coderror = "Error 11 (";
    String mensaje1 = "): el identificador '";
    String mensaje2 = "' no es de tipo array";
    String lexema;
    int fila,columna;
    
    public Error_11(String lex, int _fila, int _columna){
        lexema = lex;
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1 + lexema + mensaje2;
    }
    
    
}
