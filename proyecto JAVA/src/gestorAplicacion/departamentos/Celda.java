package gestorAplicacion.departamentos;

import java.util.List;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import gestorAplicacion.personal.*;
import gestorAplicacion.bienes.*;
import java.time.LocalDateTime;

public class Celda {
	
	private final int NUMCELDA;
	private final int CAPACIDADMAX;
	private ArrayList<Reo> reosPertenecientes;
	private static ArrayList<String> historialCelda = new ArrayList<String>();
	
	public Celda(int numCelda) {
		this(numCelda, 2, new ArrayList<Reo>());
	}
	public Celda(int numCelda, int capacidadMax, ArrayList<Reo> reosPertenecientes) {
		super();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		this.NUMCELDA = numCelda;
		this.CAPACIDADMAX = capacidadMax;
		this.reosPertenecientes = reosPertenecientes;
		addHistorialCelda("Anadiste la celda: "+this.NUMCELDA+". "+dtf.format(LocalDateTime.now()));
		
	}
	
	public ArrayList<Reo> getReosPertenecientes() {
		return reosPertenecientes;
	}
	public void setReosPertenecientes(ArrayList<Reo> reosPertenecientes) {
		this.reosPertenecientes = reosPertenecientes;
	}
	public static ArrayList<String> getHistorialCelda() {
		return historialCelda;
	}
	public static void addHistorialCelda(String hist) {
		historialCelda.add(hist);
	}
	public int getNumCelda() {
		return NUMCELDA;
	}
	public int getCapacidadMax() {
		return CAPACIDADMAX;
	}
	
	public String asignarReo(Reo reo) {
		if (this.reosPertenecientes.size()+1 <= this.CAPACIDADMAX) {
			DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			this.reosPertenecientes.add(reo);
			String str1 = "Haz añadido al reo con codigo: "+reo.getCodigo()+" a la celda numero "+ this.NUMCELDA;
			addHistorialCelda(str1+" "+dtf2.format(LocalDateTime.now()));
			return str1;
		}
		else {
			return "No puedes anadir a este reo, la capacidad maxima de la celda ha sido superada";
			
		}
	}
	public Reo sacarReo(Reo reo) {
		if (this.reosPertenecientes.contains(reo)) {
			this.reosPertenecientes.remove(this.reosPertenecientes.indexOf(reo));
			return reo;
		}
		else {
			return null;
		}
	}
	
	
	
	
	
}
