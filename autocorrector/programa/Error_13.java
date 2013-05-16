
/**
 *
 * @author victor
 */
public class Error_13 extends Exception{
    
    String coderror = "Error 13 (";
    String mensaje1 = "): indice de tipo incompatible";
    int fila,columna;
    
    public Error_13(int _fila, int _columna){
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1;
    }
    
    
}
