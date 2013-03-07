
/**
 *
 * @author victor
 */
public class Error_8 extends Exception{
    
    String coderror = "Error 8 (";
    String mensaje1 = "): tamanyo incorrecto";
    int fila,columna;
    
    public Error_8(int _fila, int _columna){
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1;
    }
    
    
}
