
/**
 *
 * @author victor
 */
public class Error_10 extends Exception{
    
    String coderror = "Error 10 (";
    String mensaje1 = "): numero de dimensiones incorrecto";
    int fila,columna;
    
    public Error_10(int _fila, int _columna){
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1;
    }
    
    
}
