
/**
 *
 * @author victor
 */
public class Error_27 extends Exception{
    
    String coderror = "Error 27 (";
    String mensaje1 = "' no accesible desde Main";
    String lexema;
    int fila,columna;
    
    public Error_27(String lex, int _fila, int _columna){
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
        return coderror + fila + "," + (columna+1) + "): miembro '" + lexema + mensaje1;
    }
    
    
}
