package gestorAplicacion.departamentos;

import java.util.List;
import java.util.ArrayList;
import gestorAplicacion.personal.*;
import gestorAplicacion.bienes.*;

public abstract class Patio {

	private final int CAPACIDAD;
	private final String nombre;
	private ArrayList<Reo> reos;
	private ArrayList<Guardia> guardias;
	private static ArrayList<String> historialPatio = new ArrayList<String>();
	

	public Patio(int capacidad, String nombre, ArrayList<Reo> reos, ArrayList<Guardia> guardias) {
		super();
		this.CAPACIDAD = capacidad;
		this.nombre = nombre;
		this.reos = reos;
		this.guardias = guardias;
	}
	
	public ArrayList<Reo> getReos() {
		return reos;
	}
	public void setReos(ArrayList<Reo> reos) {
		this.reos = reos;
	}
	public ArrayList<Guardia> getGuardias() {
		return guardias;
	}
	public void setGuardias(ArrayList<Guardia> guardias) {
		this.guardias = guardias;
	}
	public static ArrayList<String> getHistorialPatio() {
		return historialPatio;
	}
	public static void addHistorialPatio(String hist) {
		historialPatio.add(hist);
	}
	public int getCapacidad() {
		return CAPACIDAD;
	}
	public String getNombre() {
		return nombre;
	}
	
	public abstract String ingresarReos(Reo reo); //con este metodo se ingresará reos a las clases hijas 
	

	public abstract String ingresarGuardias(Guardia guardia); //con este metodo se ingresará reos a las clases hijas 
	
	
	public abstract String laborarReo(Reo reo, int horas); // con este metodo se pondrá hacer labores correspondientes a cada reo para que redutca la pena

	//public abstract void ingresarGuardias(ArrayList<Guardia> guardia);
}
