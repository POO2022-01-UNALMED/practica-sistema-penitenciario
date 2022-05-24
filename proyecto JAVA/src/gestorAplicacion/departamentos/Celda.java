package gestorAplicacion.departamentos;

import java.util.List;
import java.util.ArrayList;
import gestorAplicacion.personal.*;
import gestorAplicacion.bienes.*;

public class Celda {
	
	private final int numCelda;
	private final int capacidadMax;
	private ArrayList<Reo> reosPertenecientes;
	private ArrayList<String> historialCelda;
	
	public Celda(int numCelda, int capacidadMax, ArrayList<Reo> reosPertenecientes, ArrayList<String> historialCelda) {
		super();
		this.numCelda = numCelda;
		this.capacidadMax = capacidadMax;
		this.reosPertenecientes = reosPertenecientes;
		this.historialCelda = historialCelda;
	}
	
	public ArrayList<Reo> getReosPertenecientes() {
		return reosPertenecientes;
	}
	public void setReosPertenecientes(ArrayList<Reo> reosPertenecientes) {
		this.reosPertenecientes = reosPertenecientes;
	}
	public ArrayList<String> getHistorialCelda() {
		return historialCelda;
	}
	public void setHistorialCelda(ArrayList<String> historialCelda) {
		this.historialCelda = historialCelda;
	}
	public int getNumCelda() {
		return numCelda;
	}
	public int getCapacidadMax() {
		return capacidadMax;
	}
	
	
	
}
