
/**
 *
 * @author victor
 */
public class Error_32 extends Exception{
    
    String coderror = "Error 32 (";
    String mensaje1 = "): un metodo debe devolver algo";
    int fila,columna;
    
    public Error_32(int _fila, int _columna){
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1;
    }
    
    
}
