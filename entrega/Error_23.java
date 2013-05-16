
/**
 *
 * @author victor
 */
public class Error_23 extends Exception{
    
    String coderror = "Error 23 (";
    String mensaje1 = "): valor devuelto de tipo incompatible";
    int fila,columna;
    
    public Error_23(int _fila, int _columna){
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1;
    }
    
    
}
