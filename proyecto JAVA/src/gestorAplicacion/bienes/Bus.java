package gestorAplicacion.bienes;

import gestorAplicacion.personal.*;
import gestorAplicacion.departamentos.*;
import java.util.List;
import java.util.ArrayList;

public class Bus {
	
	private final int placa;
	private final int capacidad;
	private Prision prision;
	private List<String> historialBus;
	private static int busesCreados=0;
	
	public Bus(int placa, int capacidad, Prision prision, List<String> historialBus) {
		super();
		this.placa = placa;
		this.capacidad = capacidad;
		this.prision = prision;
		this.historialBus = historialBus;
	}

	public Prision getPrision() {
		return prision;
	}

	public void setPrision(Prision prision) {
		this.prision = prision;
	}

	public List<String> getHistorialBus() {
		return historialBus;
	}

	public void setHistorialBus(List<String> historialBus) {
		this.historialBus = historialBus;
	}

	public static int getBusesCreados() {
		return busesCreados;
	}

	public static void setBusesCreados(int busesCreados) {
		Bus.busesCreados = busesCreados;
	}

	public int getPlaca() {
		return placa;
	}

	public int getCapacidad() {
		return capacidad;
	}
	
	

	
	
}
