package gestorAplicacion.departamentos;


import java.util.ArrayList;
import gestorAplicacion.personal.*;
import gestorAplicacion.bienes.*;

import static java.lang.Math. *;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import baseDatos.Deserializador;
import baseDatos.Serializador;

public class Prision{
	

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
	
	public Prision() {
		Deserializador.deserializar(this);
	}
	
	public Prision(String nombre) {
		this(1000, "Antioquia", nombre);
	} 
	
	public Prision(int numReos,
			String localizacion, String nombre) {
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
	}
	
	public static ArrayList<Prision> getPrisiones(){
		return prisiones;
	}
	
	public ArrayList<Bus> getBuses(){
		return buses;
	}
	
	public ArrayList<Trabajo> getTrabajos() {
		return trabajos;
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

	public void addReos(Reo reo) {
		this.reos.add(reo);
	}

	public ArrayList<Guardia> getGuardias() {
		return guardias;
	}

	public void addGuardias(Guardia guardia) {
		this.guardias.add(guardia);
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
	public ArrayList<String> getHistorialReos(){
		return this.historialReos;
	}
	
	public ArrayList<String> getHistorialGuardias(){
		return this.historialGuardias;
	}

	public ArrayList<String> getHistorialTrabajos(){
		return this.historialTrabajos;
	}
	public ArrayList<Biblioteca> getBibliotecas(){
		return this.bibliotecas;
	}
	public ArrayList<Gimnasio> getGimnasios(){
		return this.gimnasios;
	}

	public ArrayList<Celda> getCeldas(){
		return this.celdas;
	}


	
	
	public void addHistorialReos(String s) {
		this.historialReos.add(s);
		int ult = historialReos.size()-1;
		String stringReos = this.historialReos.get(ult)+"\n";
		this.historialPrision+=stringReos;
		
		
	}
	
	public void addHistorialGuardias(String s) {
		this.historialGuardias.add(s);
		int ult = historialGuardias.size()-1;
		String stringGuardias = this.historialGuardias.get(ult)+"\n";
		this.historialPrision+=stringGuardias;
	}
	
	public void addHistorialTrabajos(String s) {
		this.historialTrabajos.add(s);
		
	}
	private ArrayList<Biblioteca> generarBibliotecas() {
		double numbiblio = ceil(this.numReos/1000);
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
	
	private ArrayList<Gimnasio> generarGims() {
		double numgim = ceil(this.numReos/200);
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
		double numceldas = ceil(this.numReos/2);
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
	
	public String getHistorialPrision() {
		return this.historialPrision;
	}
	public void addHistoriaPrision(String s) {
		this.historialPrision+=s;
	}

	public void setReos(ArrayList<Reo> reos) {
		this.reos = reos;
	}

	public void setGuardias(ArrayList<Guardia> guardias) {
		this.guardias = guardias;
	}

	public void setHistorialReos(ArrayList<String> historialReos) {
		this.historialReos = historialReos;
	}

	public void setHistorialGuardias(ArrayList<String> historialGuardias) {
		this.historialGuardias = historialGuardias;
	}

	public void setHistorialTrabajos(ArrayList<String> historialTrabajos) {
		this.historialTrabajos = historialTrabajos;
	}

	public void setHistorialPrision(String historialPrision) {
		this.historialPrision = historialPrision;
	}

	public void setBibliotecas(ArrayList<Biblioteca> bibliotecas) {
		this.bibliotecas = bibliotecas;
	}

	public void setGimnasios(ArrayList<Gimnasio> gimnasios) {
		this.gimnasios = gimnasios;
	}

	public void setCeldas(ArrayList<Celda> celdas) {
		this.celdas = celdas;
	}

	public void setTrabajos(ArrayList<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}

	public void setBuses(ArrayList<Bus> buses) {
		this.buses = buses;
	}

	public static void setPrisiones(ArrayList<Prision> prisiones) {
		Prision.prisiones = prisiones;
	}
	
	
	
}
	
	
	
	
	
	
	