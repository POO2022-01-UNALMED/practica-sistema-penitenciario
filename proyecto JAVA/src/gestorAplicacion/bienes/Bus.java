package gestorAplicacion.bienes;

import java.io.Serializable;
import gestorAplicacion.personal.*;
import gestorAplicacion.departamentos.*;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Bus implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public final String placa;
	private Prision prision;
	private ArrayList<String> historialBus;
	private static int busesCreados=0;
	private static ArrayList<Bus> busesTotales = new ArrayList<Bus>();  
	
	public Bus(String placa, Prision prision) {
		super();
		this.placa = placa;
		this.prision = prision;
		this.historialBus = new ArrayList<String>();
		prision.getBuses().add(this);
	}

	public Prision getPrision() {
		return prision;
	}

	public void setPrision(Prision prision) {
		this.prision.getBuses().remove(this);
		this.prision = prision;
		prision.getBuses().add(this);
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

	public String getPlaca() {
		return placa;
	}
	
	//////////// se asume que los reos seleccionados pertenecen todos a una misma instancia de prision
	public String llevarReos(ArrayList<Reo> reos, ArrayList<Guardia> guardias,Prision prisionOriginal, Prision prisionDestino ) {
		if (prisionOriginal.getReos().size() == 0 || reos.get(0).getPrision()!= prisionOriginal) {
			return "No hay reos en la prisión original o los reos que seleccionó NO pertenecen a la prision original";
		}
		else {
			if (reos.size()+guardias.size() <= 30){
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				String streo = "";
				String stgua = "";
				//String nombre = reos.get(0).getNombre();
				for (int i = 0; i< reos.size(); i++) {
					reos.get(i).setPrision(prisionDestino);
					streo += "nombre: "+ reos.get(i).getNombre() + " cuyo código es: "+reos.get(i).getCodigo()+ ", ";
					guardias.get(i).setPrision(prisionDestino);
					stgua += "nombre: "+ guardias.get(i).getNombre() + " cuyo código es: "+guardias.get(i).getCodigo()+ ", ";
					
				}
				
				return "Has enviado a los reos "+streo+" con destino a la prisión "+prisionDestino.getNombre()+" cuyos guardias son: "+stgua+"."+ dtf.format(LocalDateTime.now());
			}
			else {
				return "Error, numero de reos y guardias superior a la capacidad del bus";
			}
		}
	}

	public static ArrayList<Bus> getBusesTotales() {
		return busesTotales;
	}

	public static void setBusesTotales(ArrayList<Bus> busesTotales) {
		Bus.busesTotales = busesTotales;
	}

	public void setHistorialBus(ArrayList<String> historialBus) {
		this.historialBus = historialBus;
	}
	
	

	
	
}
