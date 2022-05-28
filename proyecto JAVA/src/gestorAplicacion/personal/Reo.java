package gestorAplicacion.personal;

import java.util.List;
import java.util.ArrayList;
import gestorAplicacion.bienes.*;
import gestorAplicacion.departamentos.*;

public class Reo {

	private final String nombre;
	private final int codigo;
	private final boolean genero; //Tomaremos que 1 sea hombre, 0 mujer.
	private int condena;
	private Prision prision;
	private Celda celda;
	private Trabajo trabajo;
	private int comportamiento; //El comportamiento subirá trabajando y haciendo actividades de los patios, luego esto determinará cuantos años de condena se reducen
	
	// aï¿½adir un enum?
	
	private static ArrayList<String> historialReos = new ArrayList<String>();
	
	public void trabajar() {
		if (this.getTrabajo() == null) {
			return;
		}
		else {
			int k = this.getTrabajo().trabajar();
			this.sumarComportamiento(k);
		}
		
	}
	
	public Reo(String nombre, int codigo, boolean genero, int condena) {
		
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.genero = genero;
		this.condena = condena;
		
	}

	public Reo(String nombre, int codigo, boolean genero, int condena, Prision prision) {
		
		this(nombre, codigo, genero, condena);
		this.prision = prision;
		
	}

	public Reo(String nombre, int codigo, boolean genero, int condena, Prision prision, Celda celda) {
		
		this(nombre, codigo, genero, condena, prision);
		this.celda = celda;
		
	}

	public Reo(String nombre, int codigo, boolean genero, int condena, Prision prision, Celda celda, Trabajo trabajo) {
		this(nombre, codigo, genero, condena, prision, celda);
		this.trabajo = trabajo;
	}

	public int getCondena() {
		return condena;
	}
	

	public void setCondena(int condena) {
		this.condena = condena;
	}
	

	public Prision getPrision() {
		return prision;
	}
	

	public void setPrision(Prision prision) {
		this.prision = prision;
	}
	

	public Trabajo getTrabajo() {
		return trabajo;
	}
	

	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}
	

	public String getNombre() {
		return nombre;
	}
	

	public int getCodigo() {
		return codigo;
	}
	

	public boolean isGenero() {
		return genero;
	}
	
	public Celda getCelda() {
		return celda;
	}

	public void setCelda(Celda celda) {
		this.celda = celda;
	}

	public ArrayList<String> getHistorialReo() {
		return historialReos;
	}
	
	public int getComportamiento() {
		return comportamiento;
	}
	
	public void setComportamiento(int comportamiento) {
		this.comportamiento = comportamiento;
	}
	
	public void sumarComportamiento(int x) {
		this.comportamiento += x;
	}
	
	public void restarComportamiento(int x) {
		this.comportamiento -= x;
	}

	//public void setHistorialReo(ArrayList<String> historialReo) {
	//	this.historialReo = historialReo;
	//}
	
	
	
	
	
	

}