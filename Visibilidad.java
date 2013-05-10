public enum Visibilidad{
	publico,privado,none;
	@Override
	public String toString(){
		switch(this){
			case publico: return "public";
			case privado: return "private";
			case none: return "";
			default:	return "ERROR";
		}
	}
}