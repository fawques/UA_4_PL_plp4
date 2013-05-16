public enum TipoLiteral{
	array,int32,float64,bool,clase;

	public static TipoLiteral convertir (String entrada){
		if("array".equals(entrada))
		{
			return TipoLiteral.array;
		}else if("int32".equals(entrada)){
			return TipoLiteral.int32;
		}else if("float64".equals(entrada)){
			return TipoLiteral.float64;
		}else if("bool".equals(entrada)){
			return TipoLiteral.bool;
		}else if("clase".equals(entrada)){
			return TipoLiteral.clase;
		}else{
			return null;
		}
	}

	@Override
	public String toString(){
		switch(this){
			case array: return "array";
			case int32: return "int32";
			case float64: return "float64";
			case bool: return "bool";
			case clase: return "clase";
			default:	return "ERROR";
		}
	}

}