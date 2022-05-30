package gestorAplicacion.departamentos;


import java.util.ArrayList;
import gestorAplicacion.personal.*;
import gestorAplicacion.bienes.*;

import static java.lang.Math. *;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
	private String historialPrision;
	
	
	public Prision(String nombre) {
		this(100, 100, 100, 1000, 10, true, "Antioquia", nombre);
	} 
	
	public Prision(int numCeldas, int numPatios, int numGuardias, int numReos, int numBuses, boolean genero,
			String localizacion, String nombre) {
		super();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		this.numCeldas = numCeldas;
		this.numPatios = numPatios;
		this.numGuardias = numGuardias;
		this.numReos = numReos;
		this.numBuses = numBuses;
		this.genero = genero;
		this.localizacion = localizacion;
		this.nombre = nombre;
		
		historialPrision = "Bienvenido alcaide a su nuevo sistema carcelario totalmente virtual, ¡Jamás ser alcaide había sido tan fácil!.\n"
				+ "Procederemos a crear la prisión "+this.getNombre()+" como lo ordenó. "+dtf.format(LocalDateTime.now())+"\n"
				+"////////////////CREANDO BIBLIOTECAS///////////////////\n";
		generarBibliotecas();
		generarGims();
		generarCeldas();
		//generarBuses();
	}

	public static int getPrisionesCreadas() {
		return prisionesCreadas;
	}

	public static void setPrisionesCreadas(int prisionesCreadas) {
		Prision.prisionesCreadas = prisionesCreadas;
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
	
	public void addHistorialReos(String s) {
		this.historialReos.add(s);
	}
	
	public void addHistorialGuardias(String s) {
		this.historialGuardias.add(s);
	}
	
	public void addHistorialTrabajos(String s) {
		this.historialTrabajos.add(s);
	}
	private ArrayList<Biblioteca> generarBibliotecas() {
		double numbiblio = ceil(this.numReos/1000);
		ArrayList<Biblioteca> b = new ArrayList<Biblioteca>();
		for (int i = 0; i <numbiblio; i++) {
			Biblioteca bip = new Biblioteca("biblioteca "+i+1+" de "+this.getNombre());
			b.add(bip);
		}
		for (int i = 0; i < b.size();i++) {
			this.historialPrision += b.get(i).getHistorialPatio()+"\n";
		}
		this.historialPrision+= "//////////////GIMNASIOS///////////////\n";
		return b;
		
	}
	
	private ArrayList<Gimnasio> generarGims() {
		double numgim = ceil(this.numReos/200);
		ArrayList<Gimnasio> b = new ArrayList<Gimnasio>();
		for (int i = 0; i <numgim; i++) {
			Gimnasio gim = new Gimnasio("Gimnasio "+i+1+" de "+this.getNombre());
			b.add(gim);
		}
		for (int i = 0; i < b.size();i++) {
			this.historialPrision += b.get(i).getHistorialPatio()+"\n";
		}
		this.historialPrision+= "//////////////CELDAS///////////////\n";
		return b;
		
		
	}
	
	private ArrayList<Celda> generarCeldas() {
		double numceldas = ceil(this.numReos/2);
		ArrayList<Celda> b = new ArrayList<Celda>();
		for (int i = 0; i <numceldas; i++) {
			Celda cel = new Celda(i);
			b.add(cel);
		}
		for (int i = 0; i < b.size();i++) {
			this.historialPrision += b.get(i).getHistorialCelda()+"\n";
		}
		this.historialPrision+= "///////////GUARDIAS Y REOS////////////\n";
		return b;
		
	}
	
	public String historialListas() {
		return this.historialPrision;
	}
	
	
	
}
	
	
	
	
	
	
	