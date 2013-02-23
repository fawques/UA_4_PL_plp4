
import java.util.ArrayList;



/**
 *
 * @author victor
 */
public class Tipo {
    
    String tipo;
    int dimension;
    Tipo tipobase;
    
    public Tipo(String _tipo, int _dim, Tipo _tipobase){
        tipo = _tipo;
        dimension = _dim;
        tipobase = _tipobase;
    }
    
    public Tipo(Tipo _anterior){
        tipo = _anterior.tipo;
        dimension = _anterior.dimension;
        tipobase = _anterior.tipobase;
    }
    
    public String getTipo(){
		return tipo;
	}
	
    public int getDimension(){
		return dimension;
	}
	
    public Tipo getTipoBase(){
		return tipobase;
	}
	
	public String toString(){
		if (tipo.equals("array")){
			//return tipobase.toStringSoloTipo() + "[]";   <--- forma buena de mostrarlo
			return "[] -> " + tipobase.toString();
		}else{
			return tipo;
		}
		
	}
	
	private String toStringSoloTipo(){
		if (tipo.equals("array")){
			return tipobase.toStringSoloTipo();
		}else{
			return tipo;
		}
		
	}
	
}
