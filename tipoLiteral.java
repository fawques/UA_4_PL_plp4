public enum tipoLiteral{
	array,int32,float64,bool,clase;

	public static tipoLiteral convertir (String entrada){
		if("array".equals(entrada))
		{
			return tipoLiteral.array;
		}else if("int32".equals(entrada)){
			return tipoLiteral.int32;
		}else if("float64".equals(entrada)){
			return tipoLiteral.float64;
		}else if("bool".equals(entrada)){
			return tipoLiteral.bool;
		}else if("clase".equals(entrada)){
			return tipoLiteral.clase;
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