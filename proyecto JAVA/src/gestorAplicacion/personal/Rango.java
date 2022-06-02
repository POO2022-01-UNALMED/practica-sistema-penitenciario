package gestorAplicacion.personal;

public enum Rango {bachiller("bachiller", 1), carcelero("carcelero", 2), oficial("oficial", 3);	
	
	//este enum tiene 2 paramentros, el rango por nombre y el rango por número.
	
	private final String rango;
	private final int rangoNumero;
	private Rango(String rang, int num) {
	this.rango = rang;
	this.rangoNumero = num;
}



public String getRango() {
	return rango;
}



public int getRangoNumero() {
	return rangoNumero;
}



public String toString() {
	return rango;
 }
}
