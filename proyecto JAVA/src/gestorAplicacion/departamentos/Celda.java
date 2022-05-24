package gestorAplicacion.departamentos;

import java.util.List;
import java.util.ArrayList;
import gestorAplicacion.personal.*;
import gestorAplicacion.bienes.*;

public class Celda {
	
	private final int numCelda;
	private final int capacidadMax;
	private List<Reo> reosPertenecientes;
	private List<String> historialCelda;
	
	public Celda(int numCelda, int capacidadMax, List<Reo> reosPertenecientes, List<String> historialCelda) {
		super();
		this.numCelda = numCelda;
		this.capacidadMax = capacidadMax;
		this.reosPertenecientes = reosPertenecientes;
		this.historialCelda = historialCelda;
	}

	public List<Reo> getReosPertenecientes() {
		return reosPertenecientes;
	}

	public void setReosPertenecientes(List<Reo> reosPertenecientes) {
		this.reosPertenecientes = reosPertenecientes;
	}

	public List<String> getHistorialCelda() {
		return historialCelda;
	}

	public void setHistorialCelda(List<String> historialCelda) {
		this.historialCelda = historialCelda;
	}

	public int getNumCelda() {
		return numCelda;
	}

	public int getCapacidadMax() {
		return capacidadMax;
	}
	
	
	
	
	
	public List<Reo> getReosPertenecientes() {
		return reosPertenecientes;
	}
	public void setReosPertenecientes(List<Reo> reosPertenecientes) {
		this.reosPertenecientes = reosPertenecientes;
	}
	public List<String> getHistorialCelda() {
		return historialCelda;
	}
	public void setHistorialCelda(List<String> historialCelda) {
		this.historialCelda = historialCelda;
	}
	public int getNumCelda() {
		return numCelda;
	}
	public int getCapacidadMax() {
		return capacidadMax;
	}
	
	
	
}
