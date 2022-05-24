package gestorAplicacion.personal;

import java.util.List;
import java.util.ArrayList;
import gestorAplicacion.bienes.*;
import gestorAplicacion.departamentos.*;

public class Guardia {
	
	private enum Rango {bachiller, carcelero, oficial};
	private String nombre;
	private int codigo;
	private Rango rango;
	private Prision prision;
	private List<String> historialGuardia;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Rango getRango() {
		return rango;
	}
	public void setRango(Rango rango) {
		this.rango = rango;
	}
	public Prision getPrision() {
		return prision;
	}
	public void setPrision(Prision prision) {
		this.prision = prision;
	}
	public List<String> getHistorialGuardia() {
		return historialGuardia;
	}
	public void setHistorialGuardia(List<String> historialGuardia) {
		this.historialGuardia = historialGuardia;
	}
	
	
	

}
