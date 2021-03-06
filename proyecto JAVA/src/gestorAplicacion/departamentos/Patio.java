package gestorAplicacion.departamentos;

import java.io.Serializable;
//import java.util.List;
import java.util.ArrayList;
import gestorAplicacion.personal.*;
//import gestorAplicacion.bienes.*;

public abstract class Patio implements Serializable{

	private static final long serialVersionUID = 1L;
	private final int CAPACIDAD;
	private final String nombre;
	private ArrayList<Reo> reos;
	private ArrayList<Guardia> guardias;
	private ArrayList<String> historialPatio=new ArrayList<String>();
	
	/////////Constructor para las clases hijas
	
	

	public Patio(int capacidad, String nombre, ArrayList<Reo> reos, ArrayList<Guardia> guardias) {
		super();
		this.CAPACIDAD = capacidad;
		this.nombre = nombre;
		this.reos = reos;
		this.guardias = guardias;
		
	}
	
	/////////metodos abstractos (por definicion estos los instanseara las clases hijas)
	
public abstract String ingresarReos(Reo reo); 
	public abstract String sacarReos(Reo reo); 
	

	public abstract String ingresarGuardias(Guardia guardia); 
	
	public abstract String sacarGuardias(Guardia guardia);
	
	protected abstract String laborarReo(Reo reo, int horas); 
	
	//// metodo no abstracto 
	
	//// este metodo se sobrecargar√° y permitir√° que las instancias de esta clase abstracta puedan registrar sus movimientos
	public String historialPATIO() {
		String strfinal = "";
		for (int i = 0; i < historialPatio.size(); i++) {
			strfinal += historialPatio.get(i)+"\n";
		}
		return strfinal;
	}
	
	////////Setters y getters
	
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
	public ArrayList<String> getHistorialPatio() {
		return historialPatio;
	}
	public void addHistorialPatio(String hist) {
		historialPatio.add(hist);
	}
	public int getCapacidad() {
		return CAPACIDAD;
	}
	public String getNombre() {
		return nombre;
	}
	
	public int getCantidadReos() {
		return 0;
	}
	
	public int getCantidadGuardias() {
		return 0;
	}
	
}
