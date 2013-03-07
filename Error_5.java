
/**
 *
 * @author victor
 */
public class Error_5 extends Exception{
    
    String coderror = "Error 5 (";
    String mensaje1 = "): la expresion debe ser de tipo booleano en la instruccion '";
    String mensaje2 = "'";
    String lexema;
    int fila,columna;
    
    public Error_5(String lex, int _fila, int _columna){
        lexema = lex;
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1 + lexema + mensaje2;
    }
    
    
}
