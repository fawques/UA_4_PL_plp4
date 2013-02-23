
/**
 *
 * @author victor
 */
public class Sem_WritelnNoBool extends Exception{
    
    String coderror = "Error 12 (";
    String mensaje1 = "): 'writeln' no admite expresiones booleanas";
    int fila,columna;
    
    public Sem_WritelnNoBool(int _fila, int _columna){
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1;
    }
    
    
}
