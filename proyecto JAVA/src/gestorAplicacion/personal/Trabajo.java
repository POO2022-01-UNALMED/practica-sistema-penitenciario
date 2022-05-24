package gestorAplicacion.personal;

import java.util.List;
import java.util.ArrayList;
import gestorAplicacion.bienes.*;
import gestorAplicacion.departamentos.*;

public class Trabajo {
	
	private final int capacidad;
	private List<Reo> reos;
	private List<Guardia> guardias;
	private List<String> historialTrabajo;
	
	public Trabajo(int capacidad, List<Reo> reos, List<Guardia> guardias, List<String> historialTrabajo) {
		super();
		this.capacidad = capacidad;
		this.reos = reos;
		this.guardias = guardias;
		this.historialTrabajo = historialTrabajo;
	}
	public List<Reo> getReos() {
		return reos;
	}
	public void setReos(List<Reo> reos) {
		this.reos = reos;
	}
	public List<Guardia> getGuardias() {
		return guardias;
	}
	public void setGuardias(List<Guardia> guardias) {
		this.guardias = guardias;
	}
	public List<String> getHistorialTrabajo() {
		return historialTrabajo;
	}
	public void setHistorialTrabajo(List<String> historialTrabajo) {
		this.historialTrabajo = historialTrabajo;
	}
	public int getCapacidad() {
		return capacidad;
	}
	
	
	
	

	
}
