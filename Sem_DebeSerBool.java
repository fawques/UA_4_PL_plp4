
/**
 *
 * @author victor
 */
public class Sem_DebeSerBool extends Exception{
    
    String coderror = "Error 4 (";
    String mensaje1 = "): tipo incompatible en operador logico '";
    String mensaje2 = "'";
    String lexema;
    int fila,columna;
    
    public Sem_DebeSerBool(String lex, int _fila, int _columna){
        lexema = lex;
        fila = _fila;
        columna = _columna;
    }
    
    @Override
    public String toString(){
        return coderror + fila + "," + (columna+1) + mensaje1 + lexema + mensaje2;
    }
    
    
}
