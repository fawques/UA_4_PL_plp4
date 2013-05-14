
/**
 *
 * @author victor
 */
public class Error_20 extends Exception{
    
    String coderror = "Error 20 (";
    String mensaje1 = "' ya esta definido";
    String lexema;
    int fila,columna;
    
    public Error_20(String tipo, String nombre, int args, int _fila, int _columna){
        lexema= tipo + "." + nombre+"(";
        if(args > 0){
            lexema += "float64";
        }
        for(int i = 1; i < args;i++){
            lexema += ",float64";
        }
        lexema += ")";
        fila = _fila;
        columna = _columna;
    }
    
    public void setFilaColumna(int _fila, int _columna){
		fila = _fila;
		columna = _columna;
	}
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + "): el metodo '" + lexema + mensaje1;
    }
    
    
}
