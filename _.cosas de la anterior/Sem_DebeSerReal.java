
/**
 *
 * @author victor
 */
public class Sem_DebeSerReal extends Exception{
    
    String coderror = "Error 8 (";
    String mensaje1 = "' debe ser de tipo real";
    String lexema;
    int fila,columna;
    
    public Sem_DebeSerReal(String lex, int _fila, int _columna){
        lexema = lex;
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + "): '" + lexema + mensaje1;
    }
    
    
}
