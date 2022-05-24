package gestorAplicacion.departamentos;

import java.util.List;
import java.util.ArrayList;
import gestorAplicacion.personal.*;
import gestorAplicacion.bienes.*;

public class Prision {
	
	private final int numCeldas;
	private final int numPatios;
	private int numGuardias;
	private int numReos;
	private int numBuses;
	private final boolean genero; // 1 hombre, 0 mujer.
	private final String localizacion;
	private final String nombre;
	private static int prisionesCreadas=0;
	
	
	//Falta aun mucho, discutir sobre si se a�ade a Alcaide o aqu� muchas cosas
	public Prision(int numCeldas, int numPatios, int numGuardias, int numReos, int numBuses, boolean genero,
			String localizacion, String nombre) {
		super();
		this.numCeldas = numCeldas;
		this.numPatios = numPatios;
		this.numGuardias = numGuardias;
		this.numReos = numReos;
		this.numBuses = numBuses;
		this.genero = genero;
		this.localizacion = localizacion;
		this.nombre = nombre;
	}


	public int getNumGuardias() {
		return numGuardias;
	}


	public void setNumGuardias(int numGuardias) {
		this.numGuardias = numGuardias;
	}


	public int getNumReos() {
		return numReos;
	}


	public void setNumReos(int numReos) {
		this.numReos = numReos;
	}


	public int getNumBuses() {
		return numBuses;
	}


	public void setNumBuses(int numBuses) {
		this.numBuses = numBuses;
	}


	public static int getPrisionesCreadas() {
		return prisionesCreadas;
	}


	public static void setPrisionesCreadas(int prisionesCreadas) {
		Prision.prisionesCreadas = prisionesCreadas;
	}


	public int getNumCeldas() {
		return numCeldas;
	}


	public int getNumPatios() {
		return numPatios;
	}


	public boolean isGenero() {
		return genero;
	}


	public String getLocalizacion() {
		return localizacion;
	}


	public String getNombre() {
		return nombre;
	}
	
	
	
}
