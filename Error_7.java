
/**
 *
 * @author victor
 */
public class Error_7 extends Exception{
    
    String coderror = "Error 7 (";
    String mensaje1 = "): tipos incompatibles en la instruccion de lectura";
    int fila,columna;
    
    public Error_7(int _fila, int _columna){
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1;
    }
    
    
}
