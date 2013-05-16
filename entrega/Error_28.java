
/**
 *
 * @author victor
 */
public class Error_28 extends Exception{
    
    String coderror = "Error 28 (";
    String mensaje1 = "): la referencia es de tipo objeto";
    int fila,columna;
    
    public Error_28(int _fila, int _columna){
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1;
    }
    
    
}
