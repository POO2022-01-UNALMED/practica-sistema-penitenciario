package gestorAplicacion.bienes;

import java.io.Serializable;
import gestorAplicacion.personal.*;
import gestorAplicacion.departamentos.*;
//import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Bus implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private final String placa;
	private Prision prision;
	private ArrayList<String> historialBus;
	private static int busesCreados=0;
	private static ArrayList<Bus> busesTotales = new ArrayList<Bus>();  
	private static int numPlaca; 
	
	/////////Constructores
	
	public Bus() {
		this.placa= "QHK"+numPlaca;
		numPlaca++;
	}
	
	public Bus(Prision prision) {
		this();
		this.prision = prision;
		this.historialBus = new ArrayList<String>();
		prision.getBuses().add(this);
		busesTotales.add(this);
	}
	
	//////////Metodos
	
	//////////// se asume que los reos seleccionados pertenecen todos a una misma instancia de prision
	public String llevarReos(ArrayList<Reo> reos, ArrayList<Guardia> guardias,Prision prisionOriginal, Prision prisionDestino ) {
//		if (prisionOriginal.getReos().size() == 0 || !(reos.get(0).getPrision().getNombre().equals(prisionOriginal.getNombre()))) {
		if (prisionOriginal.getReos().size() == 0 || reos.get(0).getPrision() != prisionOriginal) {
			return "No hay reos que trasladar en la prisión original o los reos que seleccionó NO pertenecen a la prision original";
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
				}
				for (int j = 0; j < guardias.size(); j++) {
					guardias.get(j).setPrision(prisionDestino);
					stgua += "nombre: "+ guardias.get(j).getNombre() + " cuyo código es: "+guardias.get(j).getCodigo()+ ", ";
				}
				
				return "Has enviado a los reos "+streo+" con destino a la prisión "+prisionDestino.getNombre()+"\n cuyos guardias son: "+stgua+"."+ dtf.format(LocalDateTime.now());
			}
			else {
				return "Error, numero de reos y guardias superior a la capacidad del bus";
			}
		}
	}
	
	///////// Setters y getters
	
	public void addHistorialBus(String s) {
		this.historialBus.add(s);
	}

	public Prision getPrision() {
		return prision;
	}

	public void setPrision(Prision prision) {
		this.prision.getBuses().remove(this);
		this.prision = prision;
		prision.getBuses().add(this);
	}

	public ArrayList<String> getHistorialBus() {
		return historialBus;
	}

	public void setHistorialBus(ArrayList<String> historialBus) {
		this.historialBus = historialBus;
	}

	public static int getBusesCreados() {
		return busesCreados;
	}

	public static void setBusesCreados(int busesCreados) {
		Bus.busesCreados = busesCreados;
	}

	public static ArrayList<Bus> getBusesTotales() {
		return busesTotales;
	}

	public static void setBusesTotales(ArrayList<Bus> busesTotales) {
		Bus.busesTotales = busesTotales;
	}

	public static int getNumPlaca() {
		return numPlaca;
	} 

	public static void setNumPlaca(int numPlaca) {
		Bus.numPlaca = numPlaca;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPlaca() {
		return placa;
	}	
	
}
