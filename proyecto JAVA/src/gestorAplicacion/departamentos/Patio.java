package gestorAplicacion.departamentos;

import java.util.List;
import java.util.ArrayList;
import gestorAplicacion.personal.*;
import gestorAplicacion.bienes.*;

public abstract class Patio {

	private final int capacidad;
	private final String nombre;
	private int prueba;
	private ArrayList<Reo> reos;
	private ArrayList<Guardia> guardias;
	private ArrayList<String> historialPatio;

	public Patio(int capacidad, String nombre, int prueba, ArrayList<Reo> reos, ArrayList<Guardia> guardias,
			ArrayList<String> historialPatio) {
		super();
		this.capacidad = capacidad;
		this.nombre = nombre;
		this.prueba = prueba;
		this.reos = reos;
		this.guardias = guardias;
		this.historialPatio = historialPatio;
	}
	
	public int getPrueba() {
		return prueba;
	}
	public void setPrueba(int prueba) {
		this.prueba = prueba;
	}
	public List<Reo> getReos() {
		return reos;
	}
	public void setReos(ArrayList<Reo> reos) {
		this.reos = reos;
	}
	public List<Guardia> getGuardias() {
		return guardias;
	}
	public void setGuardias(ArrayList<Guardia> guardias) {
		this.guardias = guardias;
	}
	public List<String> getHistorialPatio() {
		return historialPatio;
	}
	public void setHistorialPatio(ArrayList<String> historialPatio) {
		this.historialPatio.addAll(historialPatio);
	}
	public int getCapacidad() {
		return capacidad;
	}
	public String getNombre() {
		return nombre;
	}
	
	public abstract void ingresarReos(ArrayList<Reo> reos); //con este metodo se ingresará reos a las clases hijas 
	
	public abstract void laborarReo(Reo reo, int horas); // con este metodo se pondrá hacer labores correspondientes a cada reo para que redutca la pena

	//public abstract void ingresarGuardias(ArrayList<Guardia> guardia);
}
