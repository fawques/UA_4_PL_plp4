
/**
 *
 * @author victor
 */
public class Error_22 extends Exception{
    
    String coderror = "Error 22 (";
    String mensaje1 = "): aqui no puede usarse return";
    int fila,columna;
    
    public Error_22(int _fila, int _columna){
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1;
    }
    
    
}
