
/**
 *
 * @author victor
 */
public class Error_25 extends Exception{
    
    String coderror = "Error 25 (";
    String mensaje1 = "): no se permite la declaracion de arrays de objetos";
    int fila,columna;
    
    public Error_25(int _fila, int _columna){
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1;
    }
    
    
}
