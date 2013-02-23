
/**
 *
 * @author victor
 */
public class Sem_NoVar extends Exception{
    
    String coderror = "Error 7 (";
    String mensaje1 = "' no es una variable";
    String lexema;
    int fila,columna;
    
    public Sem_NoVar(String lex, int _fila, int _columna){
        lexema = lex;
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + "): '" + lexema + mensaje1;
    }
    
    
}
