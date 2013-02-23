

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
    
    public String toString(){
		return nombre + ":" + tipo + "@" + posicion_locals;
	}
	
	@Override
    public boolean equals(Object simb){
        Simbolo s = (Simbolo)simb;
        return (nombre == null ? s.nombre == null : nombre.equals(s.nombre));
    }
}
