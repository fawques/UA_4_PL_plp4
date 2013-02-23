
/**
 *
 * @author victor
 */
public class Sem_AsigNoBool extends Exception{
    
    String coderror = "Error 9 (";
    String mensaje1 = "): el operador ':=' no admite expresiones relacionales";
    int fila,columna;
    
    public Sem_AsigNoBool(int _fila, int _columna){
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1;
    }
    
    
}
