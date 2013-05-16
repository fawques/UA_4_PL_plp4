
/**
 *
 * @author victor
 */
public class Error_30 extends Exception{
    
    String coderror = "Error 30 (";
    String mensaje1 = "): constructor usado incorrectamente";
    int fila,columna;
    
    public Error_30(int _fila, int _columna){
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1;
    }
    
    
}
