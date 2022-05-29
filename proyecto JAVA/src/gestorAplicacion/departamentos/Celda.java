package gestorAplicacion.departamentos;

import java.util.List;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import gestorAplicacion.personal.*;
import gestorAplicacion.bienes.*;
import java.time.LocalDateTime;

public class Celda {
	
	private final int numCelda;
	private final int capacidadMax;
	private ArrayList<Reo> reosPertenecientes;
	private static ArrayList<String> historialCelda = new ArrayList<String>();
	
	public Celda(int numCelda) {
		this(numCelda, 2, new ArrayList<Reo>());
	}
	public Celda(int numCelda, int capacidadMax, ArrayList<Reo> reosPertenecientes) {
		super();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		this.numCelda = numCelda;
		this.capacidadMax = capacidadMax;
		this.reosPertenecientes = reosPertenecientes;
		addHistorialCelda("Anadiste la celda: "+this.numCelda+". "+dtf.format(LocalDateTime.now()));
		
	}
	
	public ArrayList<Reo> getReosPertenecientes() {
		return reosPertenecientes;
	}
	public void setReosPertenecientes(ArrayList<Reo> reosPertenecientes) {
		this.reosPertenecientes = reosPertenecientes;
	}
	public static ArrayList<String> getHistorialCelda() {
		return historialCelda;
	}
	public static void addHistorialCelda(String hist) {
		historialCelda.add(hist);
	}
	public int getNumCelda() {
		return numCelda;
	}
	public int getCapacidadMax() {
		return capacidadMax;
	}
	
	
	
	
	
}
