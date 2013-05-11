
import java.util.ArrayList;



/**
 *
 * @author victor
 */
public class tablaSimbolos {
    
    ArrayList<Simbolo> lista;
    tablaSimbolos anterior;
    String nombre;
    
    public tablaSimbolos(){
        lista = new ArrayList<Simbolo>();
        anterior = null;
        nombre = "";
    }
    
    public tablaSimbolos(tablaSimbolos _anterior){
        lista = new ArrayList<Simbolo>();
        anterior = _anterior;
        nombre = _anterior.getNombre();
    }

    public tablaSimbolos(tablaSimbolos _anterior, String _nombre){
        lista = new ArrayList<Simbolo>();
        anterior = _anterior;
        nombre = _nombre;
    }

    public String getNombre(){
        return nombre;
    }
    
    public void add(String nombre, Tipo tipo, int posicion_max, Visibilidad _vis, TipoSimbolo tipoSimb) throws Error_1{
        Simbolo item = new Simbolo(nombre,posicion_max, tipo,_vis, tipoSimb);
        if (!contiene(item)) {
            lista.add(item);
        }else{
            throw new Error_1(item.nombre, 0, 0);
        }
    }
    
    public int add(Simbolo item) throws Error_1{
        if (!contiene(item)) {
            lista.add(item);
            return item.posicion_locals;
        }else{
            throw new Error_1(item.nombre, 0, 0);
        }
    }
    
    public Tipo getTipo(String nombre) throws Error_2 {
        for (Simbolo simbolo : lista) {
            if (simbolo.nombre.equals(nombre)) {
                return simbolo.tipo;
            }
        }
        // ha terminado la lista y no lo ha encontrado, llamamos a la lista anterior.
        if (anterior != null) {
            return anterior.getTipo(nombre);
        }
        // no se ha encontrado el símbolo
        throw new Error_2(nombre, 0, 0);
    }
    
    public Simbolo getSimbolo(String nombre) throws Error_2 {
        for (Simbolo simbolo : lista) {
            if (simbolo.nombre.equals(nombre)) {
                return simbolo;
            }
        }
        // ha terminado la lista y no lo ha encontrado, llamamos a la lista anterior.
        if (anterior != null) {
            return anterior.getSimbolo(nombre);
        }
        // no se ha encontrado el símbolo
        throw new Error_2(nombre, 0, 0);
    }
    
    public ArrayList<Simbolo> getAll(){
		ArrayList<Simbolo> listado = new ArrayList<Simbolo>();
		if (anterior != null)
		{
			listado.addAll(anterior.getAll());
		}
		listado.addAll(lista);
		return listado;
		
	}

    
    public tablaSimbolos pop(){
        return anterior;
    }

    private boolean contieneTodo(Simbolo item) {
        if(anterior == null){
           return lista.contains(item); 
        }else{
            if(!lista.contains(item)) {
                return anterior.contiene(item);
            }else{
                return true;
            }
        }
    }
    
    private boolean contiene(Simbolo item) {
        return lista.contains(item);
    }

    @Override
    public String toString(){
        String salida = "tabla de símbolos: " + "\n";
        for (Simbolo s : lista) {
            salida += s + "\n";
        }
        return salida;
    }

}
