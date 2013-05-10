

/**
 *
 * @author victor
 */
public class Simbolo {

    String nombre;
    int posicion_locals;
    Tipo tipo;
    Visibilidad visibilidad;
    TipoSimbolo tipo_simb;
    
    
    public Simbolo(String _nombre, int _pos, Tipo _tipo, TipoSimbolo _tipoSimb) {
        nombre = _nombre;
        posicion_locals = _pos;
        tipo = _tipo;
        tipo_simb = _tipoSimb;
    }
    
    public Tipo getTipo(){
		return tipo;
	}
    
    public tipoLiteral getTipoFinal(){
		tipoLiteral aux = tipo.getTipo();
		if(aux == tipoLiteral.array){
			return tipo.getTipoFinal();
		} else{
			return aux;
		}
	}
	
	public boolean esArray(){
		return tipo.esArray();
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
