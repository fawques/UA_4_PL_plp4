
/**
 *
 * @author victor
 */
public class Error_31 extends Exception{
    
    String coderror = "Error 31 (";
    String mensaje1 = "): un constructor no puede devolver nada";
    int fila,columna;
    
    public Error_31(int _fila, int _columna){
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1;
    }
    
    
}
