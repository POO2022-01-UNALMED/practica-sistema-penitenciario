package gestorAplicacion.bienes;

import gestorAplicacion.personal.*;
import gestorAplicacion.departamentos.*;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Bus {
	
	private final int placa;
	private Prision prision;
	private ArrayList<String> historialBus;
	private static int busesCreados=0;
	
	public Bus(int placa, Prision prision) {
		super();
		this.placa = placa;
		this.prision = prision;
		this.historialBus = new ArrayList<String>();
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

	public void addHistorialBus(String s) {
		this.historialBus.add(s);
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
	
	public String llevarReos(ArrayList<Reo> reos, ArrayList<Guardia> guardias, Prision prisionDestino ) {
		if (reos.size()+guardias.size() <= 30){
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			String streo = "";
			String stgua = "";
			String nombre = reos.get(0).getNombre();
			for (int i = 0; i< reos.size(); i++) {
				reos.get(i).setPrision(prisionDestino);
				streo += "nombre: "+ reos.get(i).getNombre() + " cuyo código es: "+reos.get(i).getCodigo();
				guardias.get(i).setPrision(prisionDestino);
				stgua += "nombre: "+ guardias.get(i).getNombre() + " cuyo código es: "+guardias.get(i).getCodigo();
				
			}
			return "Has enviado a los reos "+streo+" de "+nombre+" con destino a la prisión "+prisionDestino.getNombre()+" cuyos guardias son: "+stgua+"."+ dtf.format(LocalDateTime.now());
		}
		else {
			return "Error, numero de reos y guardias superior a la capacidad del bus";
		}
	}
	
	

	
	
}
