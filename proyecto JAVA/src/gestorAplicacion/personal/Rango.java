package gestorAplicacion.personal;

public enum Rango {bachiller("bachiller"), carcelero("carcelero"), oficial("ficial");	
	
private String rango;
private Rango(String rang) {
	this.rango = rang;
}

public String toString() {
	return rango;
}
}
