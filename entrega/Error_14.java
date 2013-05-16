
/**
 *
 * @author victor
 */
public class Error_14 extends Exception{
    
    String coderror = "Error 14 (";
    String mensaje1 = "): tipo '";
    String mensaje2 = "' incompatible con la declaracion";
    String lexema;
    int fila,columna;
    
    public Error_14(String lex, int _fila, int _columna){
        lexema = lex;
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1 + lexema + mensaje2;
    }
    
    
}
