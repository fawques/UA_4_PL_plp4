
/**
 *
 * @author victor
 */
public class Error_29 extends Exception{
    
    String coderror = "Error 29 (";
    String mensaje1 = "): tipo incompatible en operador relacional '";
    String lexema;
    int fila,columna;
    
    public Error_29(String lex, int _fila, int _columna){
        lexema = lex;
        fila = _fila;
        columna = _columna;
    }
    
    public void setFilaColumna(int _fila, int _columna){
		fila = _fila;
		columna = _columna;
	}
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1 + lexema + "'";
    }
    
    
}
