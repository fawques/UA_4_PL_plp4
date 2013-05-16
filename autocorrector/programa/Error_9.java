
/**
 *
 * @author victor
 */
public class Error_9 extends Exception{
    
    String coderror = "Error 9 (";
    String mensaje1 = "): numero insuficiente de indices en el array '";
    String mensaje2 = "'";
    String lexema;
    int fila,columna;
    
    public Error_9(String lex, int _fila, int _columna){
        lexema = lex;
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1 + lexema + mensaje2;
    }
    
    
}
