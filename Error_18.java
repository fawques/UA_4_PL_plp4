
/**
 *
 * @author victor
 */
public class Error_18 extends Exception{
    
    String coderror = "Error 18: debe existir un unico metodo Main";
    
    public Error_18(){}
    
    @Override
    public String toString(){
        return coderror;
    }
    
    
}
