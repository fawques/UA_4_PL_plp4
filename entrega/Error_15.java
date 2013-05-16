
/**
 *
 * @author victor
 */
public class Error_15 extends Exception{
    
    String coderror = "Error 15 (";
    String mensaje1 = "): la variable que se intenta modificar es una variable indice";
    int fila,columna;
    
    public Error_15(int _fila, int _columna){
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1;
    }
    
    
}
