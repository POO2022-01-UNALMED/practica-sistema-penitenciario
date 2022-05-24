package gestorAplicacion.personal;

import java.util.List;
import java.util.ArrayList;
import gestorAplicacion.bienes.*;
import gestorAplicacion.departamentos.*;

public class Trabajo {
	
	private enum Dificultad {facil, normal, dificil};
	
	private final String nombre;
	private final Dificultad dificultad;
	private ArrayList<Reo> reos = new ArrayList<Reo>();
	private ArrayList<Guardia> guardias = new ArrayList<Guardia>();
	private ArrayList<String> historialTrabajo = new ArrayList<String>();
	
	public Trabajo(String nombre, Dificultad dificultad) {
		this.nombre = nombre;
		this.dificultad = dificultad;
	}

	public String getNombre() {
		return nombre;
	}

	public Dificultad getDificultad() {
		return dificultad;
	}

	public ArrayList<Reo> getReos() {
		return reos;
	}

	public ArrayList<Guardia> getGuardias() {
		return guardias;
	}

	public ArrayList<String> getHistorialTrabajo() {
		return historialTrabajo;
	}
	
	
	
}
