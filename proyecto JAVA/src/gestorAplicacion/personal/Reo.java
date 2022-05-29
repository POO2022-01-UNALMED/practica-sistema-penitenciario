package gestorAplicacion.personal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import gestorAplicacion.bienes.*;
import gestorAplicacion.departamentos.*;

public class Reo {

	private final String nombre;
	private final int codigo;
	private final boolean genero; //Tomaremos que 1 sea hombre, 0 mujer.
	private int condena;
	private Prision prision;
	private Celda celda;
	private Trabajo trabajo;
	private int horasTrabajadasTotales;
	private int comportamiento; //El comportamiento subir� trabajando y haciendo actividades de los patios, luego esto determinar� cuantos a�os de condena se reducen
	
	// a�adir un enum?
	
	private static ArrayList<String> historialReos = new ArrayList<String>();
	
	public void trabajar() {
		if (this.getTrabajo() == null) {
			return;
		}
		else {
			int ConstTrab = this.getTrabajo().getConstanteTrabajo();
			int HorasDelTurno = this.getTrabajo().getHorasQueLlevaHacerUnTurno();
			
			this.getTrabajo().sumarHorasTrabajadas();
			this.sumarComportamiento(ConstTrab*HorasDelTurno); 
			
			//A�ade al historial
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
			prision.addHistorialTrabajos("El reo: "+this.nombre+", con c�digo: "+this.codigo+", "
					+ "ha ido a trabajar de "+this.getTrabajo().getNombre()+". "
					+ "Sumando un total de: "+this.trabajo.getHorasTrabajadas()+" horas trabajadas en este oficio, "
					+ "y un total de: "+this.horasTrabajadasTotales+" horas trabajadas en total"+Tiempo);
		}
		
	}
	
	public Reo(String nombre, int codigo, boolean genero, int condena) {
	
		this.nombre = nombre;
		this.codigo = codigo;
		this.genero = genero;
		this.condena = condena;
		
	}

	public Reo(String nombre, int codigo, boolean genero, int condena, Prision prision) {
		
		this(nombre, codigo, genero, condena);
		this.prision = prision;
		
		//A�ade al historial
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
		prision.addHistorialReos("El reo: "+nombre+", con c�digo: "+codigo+", ha ingreado con "+condena+" a�os de condena a la prisi�n: "+prision+Tiempo);
	}

	public Reo(String nombre, int codigo, boolean genero, int condena, Prision prision, Celda celda) {
		this(nombre, codigo, genero, condena, prision);
		
		if(celda.getReosPertenecientes().size()+1 > celda.getCapacidadMax()) {
			//A�ade al historial
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
			prision.addHistorialReos("El reo: "+nombre+", con c�digo: "+codigo+", ha ingreado con "+condena+" a�os de condena a la prisi�n: "+prision+". No se le pudo asignar celda porque est� llena"+Tiempo);
		}
		else {
			this.celda=celda;
			celda.asignarReo(this);
			
			//A�ade al historial
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
			prision.addHistorialReos("El reo: "+nombre+", con c�digo: "+codigo+", ha ingreado con "+condena+" a�os de condena a la celda n�mero: "+celda.getNumCelda()+", de la prisi�n: "+prision+Tiempo);
		}
		
		
	}
		
	public int getCondena() {
		return condena;
	}
	

	public void setCondena(int condena) {
		this.condena = condena;
	}
	

	public Prision getPrision() {
		return prision;
	}
	

	public void setPrision(Prision prision) {
		this.prision = prision;
	}
	

	public Trabajo getTrabajo() {
		return trabajo;
	}
	

	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}
	

	public String getNombre() {
		return nombre;
	}
	

	public int getCodigo() {
		return codigo;
	}
	

	public boolean isGenero() {
		return genero;
	}
	
	public Celda getCelda() {
		return celda;
	}

	public void setCelda(Celda celda) {
		this.celda = celda;
	}

	public ArrayList<String> getHistorialReo() {
		return historialReos;
	}
	
	public int getComportamiento() {
		return comportamiento;
	}
	
	public void setComportamiento(int comportamiento) {
		this.comportamiento = comportamiento;
	}
	
	public void sumarComportamiento(int x) {
		this.comportamiento += x;
	}
	
	public void restarComportamiento(int x) {
		this.comportamiento -= x;
	}
	
	public void sumarHorasTrabajadasTotales(int x) {
		this.horasTrabajadasTotales += x;
	}
	
	public int getHorasTrabajadasTotales() {
		return this.horasTrabajadasTotales;
	}

	//public void setHistorialReo(ArrayList<String> historialReo) {
	//	this.historialReo = historialReo;
	//}
	
	
	
	
	
	

}