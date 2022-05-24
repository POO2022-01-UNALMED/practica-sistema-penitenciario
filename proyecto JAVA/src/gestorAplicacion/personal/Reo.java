package gestorAplicacion.personal;

import java.util.List;
import java.util.ArrayList;
import gestorAplicacion.bienes.*;
import gestorAplicacion.departamentos.*;

public class Reo {

	private final String nombre;
	private final int codigo;
	private final boolean Genero; //Tomaremos que 1 sea hombre, 0 mujer.
	private int condena;
	private Prision prision;
	private Trabajo trabajo;
	// a�adir un enum?
	

	private List<String> historialReo;
	public Reo(String nombre, int codigo, boolean genero, int condena, Prision prision, Trabajo trabajo,
			List<String> historialReo) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		Genero = genero;
		this.condena = condena;
		this.prision = prision;
		this.trabajo = trabajo;
		this.historialReo = historialReo;
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
	public List<String> getHistorialReo() {
		return historialReo;
	}
	public void setHistorialReo(List<String> historialReo) {
		this.historialReo = historialReo;
	}
	public String getNombre() {
		return nombre;
	}
	public int getCodigo() {
		return codigo;
	}
	public boolean isGenero() {
		return Genero;
	}
	
	
	
	
}
