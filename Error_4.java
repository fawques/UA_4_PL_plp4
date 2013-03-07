
/**
 *
 * @author victor
 */
public class Error_4 extends Exception{
    
    String coderror = "Error 4 (";
    String mensaje1 = "): tipo incompatible en operador logico '";
    String mensaje2 = "'";
    String lexema;
    int fila,columna;
    
    public Error_4(String lex, int _fila, int _columna){
        lexema = lex;
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1 + lexema + mensaje2;
    }
    
    
}
