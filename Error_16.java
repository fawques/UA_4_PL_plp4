
/**
 *
 * @author victor
 */
public class Error_16 extends Exception{
    
    String coderror = "Error 16 (";
    String mensaje1 = "): instruccion '";
    String mensaje2 = "' no permitida fuera de un bucle";
    String lexema;
    int fila,columna;
    
    public Error_16(String lex, int _fila, int _columna){
        lexema = lex;
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1 + lexema + mensaje2;
    }
    
    
}
