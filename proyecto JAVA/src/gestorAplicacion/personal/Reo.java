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
	private int comportamiento; //El comportamiento subirá trabajando y haciendo actividades de los patios, luego esto determinará cuantos años de condena se reducen
	
	// aï¿½adir un enum?
	
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
			
			//Añade al historial
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
			prision.addHistorialTrabajos("El reo: "+this.nombre+", con código: "+this.codigo+", "
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
		
		//Añade al historial
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
		prision.addHistorialReos("El reo: "+nombre+", con código: "+codigo+", ha ingreado con "+condena+" años de condena a la prisión: "+prision+Tiempo);
		prision.addReos(this);
	}

	public Reo(String nombre, int codigo, boolean genero, int condena, Prision prision, Celda celda) {
		this(nombre, codigo, genero, condena, prision);
		
		if(celda.getReosPertenecientes().size()+1 > 2) {
			//Añade al historial
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
			prision.addHistorialReos("El reo: "+nombre+", con código: "+codigo+" no se le pudo asignar celda porque está llena"+Tiempo);
	
		}
		else {
			this.celda=celda;
			celda.asignarReo(this);
			
			//Añade al historial
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
			prision.addHistorialReos("El reo: "+nombre+", con código: "+codigo+", ha ingreado a la celda número: "+celda.getNumCelda()+Tiempo);
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
		//Añade al historial
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
		
		if(this.getPrision() != null) {
			this.prision.addHistorialReos("El reo: "+this.nombre+", con código: "+this.codigo+" ha salido de la prisión: "+this.prision.getNombre()+", y será trasladado a: "+prision.getNombre()+Tiempo);
			prision.addHistorialReos("El reo: "+this.nombre+", con código: "+this.codigo+" ha salido de la prisión: "+this.prision.getNombre()+", y será trasladado a: "+prision.getNombre()+Tiempo);
			this.prision.getReos().remove(this);
			this.prision = prision;
			prision.addReos(this);			
		}else {
			this.prision=prision;
			prision.addReos(this);
			prision.addHistorialReos("El reo: "+this.nombre+", con código: "+this.codigo+"ha ingresado a la prision: "+prision.getNombre()+Tiempo);
		}
		
		
	}
	

	public Trabajo getTrabajo() {
		return trabajo;
	}
	

	public void setTrabajo(Trabajo trabajo) {
		//Añade al historial
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
		
		if (this.getPrision() != null) {
			this.trabajo = trabajo;
			
			this.prision.addHistorialReos("El reo: "+this.nombre+", con código: "+this.codigo+"ha ingresado al trabajo de "+this.trabajo.getNombre()+Tiempo);
		}
		else {
			this.prision.addHistorialReos("El reo: "+this.nombre+", con código: "+this.codigo+"no puedo ingresar al trabajo de "+this.trabajo.getNombre()+" porque no tiene asignada una prisión"+Tiempo);
		}
		
		
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
		//Añade al historial
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
				
		if(celda.getReosPertenecientes().size()+1>2){
			if(this.getCelda()!=null) {
					this.getCelda().sacarReo(this);
					celda.asignarReo(this);
					this.prision.addHistorialReos("El reo: "+this.nombre+", con código: "+this.codigo+" ha sido trasladado a la celda número: "+this.celda.getNumCelda()+Tiempo);
			}
				
			else {
				celda.asignarReo(this);
				this.prision.addHistorialReos("El reo: "+this.nombre+", con código: "+this.codigo+" ha sido trasladado a la celda número: "+this.celda.getNumCelda()+Tiempo);
			}
		}
		else {
			this.prision.addHistorialReos("El reo: "+this.nombre+", con código: "+this.codigo+" no se puede trasladas a esta celda porque está llena"+Tiempo);
		}
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