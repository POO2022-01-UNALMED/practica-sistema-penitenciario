package gestorAplicacion.departamentos;

import java.io.Serializable;
//import java.util.List;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import gestorAplicacion.personal.*;
//import gestorAplicacion.bienes.*;
import java.time.LocalDateTime;

public class Celda implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private final int NUMCELDA;
	private final Prision prision;
	private ArrayList<Reo> reosPertenecientes= new ArrayList<Reo>();
	private ArrayList<String> historialCelda = new ArrayList<String>();
	private static ArrayList<Celda> celdasTotales = new ArrayList<Celda>();
	
	////////////constructores
	
	public Celda(int numCelda, Prision prision) {
		super();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		this.NUMCELDA = numCelda;
		this.prision = prision;
		addHistorialCelda("Anadiste la celda: "+this.NUMCELDA+" en la prision: "+prision.getNombre()+". "+dtf.format(LocalDateTime.now()));
		prision.getCeldas().add(this);
		celdasTotales.add(this);
		
	}
	
	/////////metodos
	
	
	/// en este método nosotros ingresamos un reo a una instancia particular de celda existente en la intancia prision, en caso de que se exceda la capacidad maxima de la celda obtendríamos solamente el respectivo aviso
	public String asignarReo(Reo reo) {
		if (this.reosPertenecientes.size()+1 <= 2) {
			this.reosPertenecientes.add(reo);
			//// ingresamos este movimiento al historial de las celdas 
				DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				String str1 = "Haz anadido al reo con codigo: "+reo.getCodigo()+" cuyo nombre es "+reo.getNombre()+" a la celda numero: "+ this.NUMCELDA;
				addHistorialCelda(str1+" "+dtf2.format(LocalDateTime.now())+"\n");
				this.prision.addHistoriaPrision(historialCelda.get(historialCelda.size()-1));
			return str1;
		}
		else {
			return "No puedes anadir a este reo, la capacidad maxima de la celda ha sido superada";
			
		}
	}
	
	//// en este método sacamos a un reo de la celda, en el caso d que el reo pertenezca a la celda, en caso contrario nos retornará un null
	public Reo sacarReo(Reo reo) {
		if (this.reosPertenecientes.contains(reo)) {
			this.reosPertenecientes.remove(this.reosPertenecientes.indexOf(reo));
			
			/// aca ingresamos este movimiento en el historial de celdas
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
			addHistorialCelda("Se ha quitado al reo con c�digo: "+reo.getCodigo()+" de la celda n�mero: "+this.NUMCELDA+Tiempo+"\n");
			this.prision.addHistoriaPrision(historialCelda.get(historialCelda.size()-1));
			return reo;
		}
		else {
			return null;
		}
	}
	
	/// en este metodo conseguimos concatenar todos los estrings ingresados en el array de strings llamado historialcelda, obtenendo asi el historial  
	public String historialCELDA() {
		String strfinal = "";
		for (int i = 0 ; i< this.historialCelda.size(); i++) {
			strfinal += this.historialCelda.get(i)+"\n";
		}
		return strfinal;
	}
	
////////////////////////Setters y getters

	public ArrayList<Reo> getReosPertenecientes() {
		return reosPertenecientes;
	}

	public void setReosPertenecientes(ArrayList<Reo> reosPertenecientes) {
		this.reosPertenecientes = reosPertenecientes;
	}

	public ArrayList<String> getHistorialCelda() {
		return historialCelda;
	}

	public void setHistorialCelda(ArrayList<String> historialCelda) {
		this.historialCelda = historialCelda;
	}

	public static ArrayList<Celda> getCeldasTotales() {
		return celdasTotales;
	}

	public static void setCeldasTotales(ArrayList<Celda> celdasTotales) {
		Celda.celdasTotales = celdasTotales;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getNumCelda() {
		return this.NUMCELDA;
	}

	public Prision getPrision() {
		return prision;
	}
	
	public void addHistorialCelda(String hist) {
		historialCelda.add(hist);
	}
	
}