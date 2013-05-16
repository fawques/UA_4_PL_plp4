
/**
 *
 * @author victor
 */
public class Error_3 extends Exception{
    
    String coderror = "Error 3 (";
    String mensaje1 = "): tipo incompatible en operador aritmetico '";
    String mensaje2 = "'";
    String lexema;
    int fila,columna;
    
    public Error_3(String lex, int _fila, int _columna){
        lexema = lex;
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1 + lexema + mensaje2;
    }
    
    
}
