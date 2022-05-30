package gestorAplicacion.departamentos;

import java.util.List;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import gestorAplicacion.personal.*;
import gestorAplicacion.bienes.*;
import java.time.LocalDateTime;

public class Celda {
	
	private final int NUMCELDA;
	private ArrayList<Reo> reosPertenecientes= new ArrayList<Reo>();
	private ArrayList<String> historialCelda = new ArrayList<String>();
	
	public Celda(int numCelda) {
		super();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		this.NUMCELDA = numCelda;
		addHistorialCelda("Anadiste la celda: "+this.NUMCELDA+". "+dtf.format(LocalDateTime.now()));
		
	}
	
	public ArrayList<Reo> getReosPertenecientes() {
		return reosPertenecientes;
	}
	public void setReosPertenecientes(ArrayList<Reo> reosPertenecientes) {
		this.reosPertenecientes = reosPertenecientes;
	}
	public ArrayList<String> getHistorialCelda() {
		return this.historialCelda;
	}
	public void addHistorialCelda(String hist) {
		historialCelda.add(hist);
	}
	public int getNumCelda() {
		return this.NUMCELDA;
	}
	
	public String asignarReo(Reo reo) {
		if (this.reosPertenecientes.size()+1 <= 2) {
			DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			this.reosPertenecientes.add(reo);
			//reo.setCelda(this);
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
			reo.setCelda(null);
			return reo;
		}
		else {
			return null;
		}
	}
	public String historialCELDA() {
		String strfinal = "";
		for (int i = 0 ; i< this.historialCelda.size(); i++) {
			strfinal += this.historialCelda.get(i)+"\n";
		}
		return strfinal;
	}
	
	
	
	
	
}
