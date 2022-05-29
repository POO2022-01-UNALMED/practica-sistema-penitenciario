package gestorAplicacion.personal;

public enum Rango {bachiller("bachiller", 1), carcelero("carcelero", 2), oficial("oficial", 3);	
	
public final String rango;
public final int rangoNum;
private Rango(String rang, int num) {
	this.rango = rang;
	this.rangoNum = num;
}

public String toString() {
	return rango;
 }
}
