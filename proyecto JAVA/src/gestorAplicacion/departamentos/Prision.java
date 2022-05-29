package gestorAplicacion.departamentos;


import java.util.ArrayList;
import gestorAplicacion.personal.*;
import gestorAplicacion.bienes.*;

public class Prision {
	
	
	private final int numCeldas;
	private final int numPatios;
	private final int numGuardias;
	private final int numReos;
	private final int numBuses;
	private final boolean genero; // 1 hombre, 0 mujer.
	private final String localizacion;
	private final String nombre;
	private static int prisionesCreadas;
	private ArrayList<Reo> reos = new ArrayList<Reo>();
	private ArrayList<Guardia> guardias = new ArrayList<Guardia>();
	private ArrayList<String> historialReos = new ArrayList<String>();
	private ArrayList<String> historialGuardias = new ArrayList<String>();
	private ArrayList<String> historialTrabajos = new ArrayList<String>();
	private ArrayList<String> historialPrision = new ArrayList<String>();
	
	
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

	public static int getPrisionesCreadas() {
		return prisionesCreadas;
	}

	public static void setPrisionesCreadas(int prisionesCreadas) {
		Prision.prisionesCreadas = prisionesCreadas;
	}

	public static ArrayList<Reo> getReos() {
		return reos;
	}

	public static void setReos(ArrayList<Reo> reos) {
		Prision.reos = reos;
	}

	public static ArrayList<Guardia> getGuardias() {
		return guardias;
	}

	public static void setGuardias(ArrayList<Guardia> guardias) {
		Prision.guardias = guardias;
	}

	public int getNumCeldas() {
		return numCeldas;
	}

	public int getNumPatios() {
		return numPatios;
	}

	public int getNumGuardias() {
		return numGuardias;
	}

	public int getNumReos() {
		return numReos;
	}

	public int getNumBuses() {
		return numBuses;
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
	
	public String historialListas() {
		ArrayList<String> patioList = Patio.getHistorialPatio();
		ArrayList<String> celdaList = Patio.getHistorialPatio();
	}
	
	
	
}
	
	
	
	
	
	
	