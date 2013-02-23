
/**
 *
 * @author victor
 */
public class Sem_DivDebeSerEntero extends Exception{
    
    String coderror = "Error 11 (";
    String mensaje1 = "): los dos operandos de 'div' deben ser enteros";
    int fila,columna;
    
    public Sem_DivDebeSerEntero(int _fila, int _columna){
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1;
    }
    
    
}
