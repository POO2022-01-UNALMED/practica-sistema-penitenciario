package gestorAplicacion.departamentos;

import java.util.List;
import java.util.ArrayList;
import gestorAplicacion.personal.*;
import gestorAplicacion.bienes.*;

public class Patio {

	private final int capacidad;
	private final String nombre;
	private int prueba;
	private List<Reo> reos;
	private List<Guardia> guardias;
	private List<String> historialPatio;

	public int getPrueba() {
		return prueba;
	}
	public void setPrueba(int prueba) {
		this.prueba = prueba;
	}
	public List<Reo> getReos() {
		return reos;
	}
	public void setReos(List<Reo> reos) {
		this.reos = reos;
	}
	public List<Guardia> getGuardias() {
		return guardias;
	}
	public void setGuardias(List<Guardia> guardias) {
		this.guardias = guardias;
	}
	public List<String> getHistorialPatio() {
		return historialPatio;
	}
	public void setHistorialPatio(List<String> historialPatio) {
		this.historialPatio = historialPatio;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public String getNombre() {
		return nombre;
	}


}
