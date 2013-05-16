
/**
 *
 * @author victor
 */
public class Error_24 extends Exception{
    
    String coderror = "Error 24 (";
    String mensaje1 = "): tipo incompatible en el parametro";
    int fila,columna;
    
    public Error_24(int _fila, int _columna){
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1;
    }
    
    
}
