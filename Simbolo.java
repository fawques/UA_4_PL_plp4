

/**
 *
 * @author victor
 */
public class Simbolo {

    String nombre;
    int posicion_locals;
    Tipo tipo;
    
    
    public Simbolo(String _nombre, int _pos, Tipo _tipo) {
        nombre = _nombre;
        posicion_locals = _pos;
        tipo = _tipo;
    }
    
    public Tipo getTipo(){
		return tipo;
	}
    
    public String getTipoFinal(){
		String aux = tipo.getTipo();
		if(aux.equals("array")){
			return tipo.getTipoFinal();
		} else{
			return aux;
		}
	}
	
	public boolean esArray(){
		return tipo.array;
	}
	
	public int getDimension(){
		return tipo.getDimensionTotal();
	}
    
    @Override
    public String toString(){
		return nombre + ":" + tipo + "@" + posicion_locals;
	}
	
	@Override
    public boolean equals(Object simb){
        Simbolo s = (Simbolo)simb;
        return (nombre == null ? s.nombre == null : nombre.equals(s.nombre));
    }
}
