
/**
 *
 * @author victor
 */
public class Error_6 extends Exception{
    
    String coderror = "Error 6 (";
    String mensaje1 = "): tipos incompatibles en la instruccion de asignacion";
    int fila,columna;
    
    public Error_6(int _fila, int _columna){
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1;
    }
    
    
}
