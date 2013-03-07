
/**
 *
 * @author victor
 */
public class Error_12 extends Exception{
    
    String coderror = "Error 12 (";
    String mensaje1 = "): demasiados indices";
    int fila,columna;
    
    public Error_12(int _fila, int _columna){
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1;
    }
    
    
}
