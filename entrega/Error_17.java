
/**
 *
 * @author victor
 */
public class Error_17 extends Exception{
    
    String coderror = "Error 17 (";
    String mensaje1 = "): la expresion debe ser de tipo numerico";
    int fila,columna;
    
    public Error_17(int _fila, int _columna){
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1;
    }
    
    
}
