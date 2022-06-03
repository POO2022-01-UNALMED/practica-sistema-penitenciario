package gestorAplicacion.departamentos;

import java.io.Serializable;
import java.util.ArrayList;
import gestorAplicacion.personal.*;
import gestorAplicacion.bienes.*;

import static java.lang.Math. *;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//import baseDatos.Deserializador;
//import baseDatos.Serializador;

public class Prision implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//private final int numGuardias;
	public final int numReos;
	//private final int numBuses;
	//private final boolean genero; // 1 hombre, 0 mujer.
	private final String localizacion;
	private final String nombre;
	private static int prisionesCreadas;
	private ArrayList<Reo> reos = new ArrayList<Reo>();
	private ArrayList<Guardia> guardias = new ArrayList<Guardia>();
	private ArrayList<String> historialReos = new ArrayList<String>();
	private ArrayList<String> historialGuardias = new ArrayList<String>();
	private ArrayList<String> historialTrabajos = new ArrayList<String>();
	private String historialPrision;
	private ArrayList<Biblioteca> bibliotecas = new ArrayList<Biblioteca>();
	private ArrayList<Gimnasio> gimnasios= new ArrayList<Gimnasio>();
	private ArrayList<Celda> celdas= new ArrayList<Celda>();
	private ArrayList<Trabajo> trabajos= new ArrayList<Trabajo>();
	private ArrayList<Bus> buses= new ArrayList<Bus>();
	private static ArrayList<Prision> prisiones= new ArrayList<Prision>();
	

	//////////////Constructores
		
	public Prision() {
		this.localizacion="Facultad de Minas";
		this.numReos = 70;
		this.nombre = "Clase de POO";
		//jejejeje.
		prisiones.add(this);
		prisionesCreadas++;
	}
	
	public Prision(String nombre ) {
		this(100, "Antioquia", nombre);
	} 
	
	public Prision(int numReos, String localizacion, String nombre) {
		super();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		this.numReos = numReos;
		this.localizacion = localizacion;
		this.nombre = nombre;
		
		historialPrision = "Bienvenido alcaide a su nuevo sistema carcelario totalmente virtual, ¡Jamás ser alcaide había sido tan fácil!.\n"
				+ "Procederemos a crear la prisión "+this.getNombre()+" como lo ordenó. "+dtf.format(LocalDateTime.now())+"\n"
				+"////////////////CREANDO INSTALACIONES///////////////////\n"+"\n";
		this.bibliotecas = generarBibliotecas();
		this.gimnasios = generarGims();
		this.celdas =generarCeldas();
		prisionesCreadas++;
		prisiones.add(this);
	}
	
	////////////////////// Metodos
	
	
	
	/////Este metodo nos permitira ingrresar un nuevo string en el arraylist historialReos
	public void addHistorialReos(String s) {
		this.historialReos.add(s);
		int ult = historialReos.size()-1;
		String stringReos = this.historialReos.get(ult)+"\n";
		this.historialPrision+=stringReos;
		
		
	}
	
	/////Este metodo nos permitira ingrresar un nuevo string en el arraylist historialGuardias
	public void addHistorialGuardias(String s) {
		this.historialGuardias.add(s);
		int ult = historialGuardias.size()-1;
		String stringGuardias = this.historialGuardias.get(ult)+"\n";
		this.historialPrision+=stringGuardias;
	}
	
	/////Este metodo nos permitira ingrresar un nuevo string en el arraylist historialTrabajos
	public void addHistorialTrabajos(String s) {
		this.historialTrabajos.add(s);
		int ult = historialTrabajos.size()-1;
		String stringTrabajos = this.historialTrabajos.get(ult)+"\n";
		this.historialPrision+=stringTrabajos;
		
	}
	
	/// en este metodo privado inicializamos todas las bibliotecas posibles en la prision en funcion de numreos
	private ArrayList<Biblioteca> generarBibliotecas() {
		float k2 = this.numReos;
		double numbiblio = ceil(k2/1000);
		ArrayList<Biblioteca> b = new ArrayList<Biblioteca>();
		for (int i = 0; i <numbiblio; i++) {
			int k = i+1;
			Biblioteca bip = new Biblioteca("biblioteca "+k+" de "+this.getNombre(), this);
			b.add(bip);
		}
		for (int i = 0; i < b.size();i++) {
			this.historialPrision += b.get(i).historialPATIO()+"\n";
		}
		this.historialPrision+= "\n";
		return b;
		
	}
	
	
	///// este metodo permite inicializar a todos los gimnasios posibles en la prision en funcion del numero de reos
	private ArrayList<Gimnasio> generarGims() {
		float k2 = this.numReos;
		double numgim = ceil(k2/200);
		ArrayList<Gimnasio> b = new ArrayList<Gimnasio>();
		for (int i = 0; i <numgim; i++) {
			int k = i+1;
			Gimnasio gim = new Gimnasio("Gimnasio "+k+" de "+this.getNombre(), this);
			b.add(gim);
		}
		for (int i = 0; i < b.size();i++) {
			this.historialPrision += b.get(i).historialPATIO()+"\n";
		}
		this.historialPrision+= "\n";
		return b;
		
		
	}
	
	private ArrayList<Celda> generarCeldas() {
		float k2 = this.numReos;
		double numceldas = ceil(k2/2);
		ArrayList<Celda> b = new ArrayList<Celda>();
		for (int i = 0; i <numceldas; i++) {
			Celda cel = new Celda(i, this);
			b.add(cel);
		}
		for (int i = 0; i < b.size();i++) {
			this.historialPrision += b.get(i).historialCELDA()+"\n";
		}
		this.historialPrision+= "///////////Bitacora de movimientos realizados en la prision///////////\n"+"\n";
		return b;
		
	}
	
	public void addReos(Reo reo) {
		this.reos.add(reo);
	}
	
	public void addGuardias(Guardia guardia) {
		this.guardias.add(guardia);
	}
	
	public void addHistoriaPrision(String s) {
		this.historialPrision+=s;
	}

	///////////Setters y getters
	
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

	public ArrayList<String> getHistorialReos() {
		return historialReos;
	}

	public void setHistorialReos(ArrayList<String> historialReos) {
		this.historialReos = historialReos;
	}

	public ArrayList<String> getHistorialGuardias() {
		return historialGuardias;
	}

	public void setHistorialGuardias(ArrayList<String> historialGuardias) {
		this.historialGuardias = historialGuardias;
	}

	public ArrayList<String> getHistorialTrabajos() {
		return historialTrabajos;
	}

	public void setHistorialTrabajos(ArrayList<String> historialTrabajos) {
		this.historialTrabajos = historialTrabajos;
	}

	public String getHistorialPrision() {
		return historialPrision;
	}

	public void setHistorialPrision(String historialPrision) {
		this.historialPrision = historialPrision;
	}

	public ArrayList<Biblioteca> getBibliotecas() {
		return bibliotecas;
	}

	public void setBibliotecas(ArrayList<Biblioteca> bibliotecas) {
		this.bibliotecas = bibliotecas;
	}

	public ArrayList<Gimnasio> getGimnasios() {
		return gimnasios;
	}

	public void setGimnasios(ArrayList<Gimnasio> gimnasios) {
		this.gimnasios = gimnasios;
	}

	public ArrayList<Celda> getCeldas() {
		return celdas;
	}

	public void setCeldas(ArrayList<Celda> celdas) {
		this.celdas = celdas;
	}

	public ArrayList<Trabajo> getTrabajos() {
		return trabajos;
	}

	public void setTrabajos(ArrayList<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}

	public ArrayList<Bus> getBuses() {
		return buses;
	}

	public void setBuses(ArrayList<Bus> buses) {
		this.buses = buses;
	}

	public static ArrayList<Prision> getPrisiones() {
		return prisiones;
	}

	public static void setPrisiones(ArrayList<Prision> prisiones) {
		Prision.prisiones = prisiones;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getNumReos() {
		return numReos;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public String getNombre() {
		return nombre;
	}
	
}
	
