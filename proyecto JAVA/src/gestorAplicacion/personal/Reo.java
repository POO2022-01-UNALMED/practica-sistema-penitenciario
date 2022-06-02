package gestorAplicacion.personal;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import gestorAplicacion.bienes.*;
import gestorAplicacion.departamentos.*;

public class Reo implements Persona, Serializable{

	private static final long serialVersionUID = 1L;
	private final String nombre;
	private final int codigo;
	private final boolean genero; //Tomaremos que 1 sea hombre, 0 mujer.
	private float condena;
	private Prision prision;
	private Celda celda;
	private Trabajo trabajo;
	private Patio patio;
	private int horasTrabajadasTotales;
	private int comportamiento; //El comportamiento subir� trabajando y haciendo actividades de los patios, luego esto determinar� cuantos a�os de condena se reducen
	private static ArrayList<Reo> reosTotales = new ArrayList<Reo>();
	private static ArrayList<String> historialReos = new ArrayList<String>();
	
	// a�adir un enum?
	
	/////////////Constructores
	
	public Reo(String nombre, int codigo, boolean genero, int condena) {
		
		this.nombre = nombre;
		this.codigo = codigo;
		this.genero = genero;
		this.condena = condena;
		reosTotales.add(this);
		
	}

	public Reo(String nombre, int codigo, boolean genero, int condena, Prision prision) {
		
		this(nombre, codigo, genero, condena);
		this.prision = prision;
		prision.addReos(this);
		
		//A�ade al historial
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
		prision.addHistorialReos("El reo: "+nombre+", con c�digo: "+codigo+", ha ingreado con "+condena+" a�os de condena a la prisi�n: "+prision.getNombre()+Tiempo);
		
	}

	public Reo(String nombre, int codigo, boolean genero, int condena, Prision prision, Celda celda) {
		this(nombre, codigo, genero, condena, prision);
		
		if(celda.getReosPertenecientes().size()+1 > 2) {
			
			//A�ade al historial
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
			prision.addHistorialReos("El reo: "+nombre+", con c�digo: "+codigo+" no se le pudo asignar celda porque est� llena"+Tiempo);
	
		}
		else {
			this.celda=celda;
			celda.asignarReo(this);
			
			//A�ade al historial
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
			prision.addHistorialReos("El reo: "+nombre+", con c�digo: "+codigo+", ha ingreado a la celda n�mero: "+celda.getNumCelda()+Tiempo);
		}
		
		
	}
	
	/////////////Metodos
	
	public String trabajar() {
		if (this.getTrabajo() == null) {
			return "Reo no tiene trabajo";
		}
		else {
			int ConstTrab = this.getTrabajo().getConstanteTrabajo();
			int HorasDelTurno = this.getTrabajo().getHorasQueLlevaHacerUnTurno();
			
			this.getTrabajo().sumarHorasTrabajadas();
			this.sumarComportamiento(ConstTrab*HorasDelTurno); 
			
			//A�ade al historial
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
			prision.addHistorialTrabajos("El reo: "+this.nombre+", con codigo: "+this.codigo+", "
					+ "ha ido a trabajar de "+this.getTrabajo().getNombre()+". "
					+ "Sumando un total de: "+this.trabajo.getHorasTrabajadas()+" horas trabajadas en este oficio, "
					+ "y un total de: "+this.horasTrabajadasTotales+" horas trabajadas en total"+Tiempo);
			return "El reo: "+this.nombre+", con codigo: "+this.codigo+", "
			+ "ha ido a trabajar de "+this.getTrabajo().getNombre()+". "
			+ "Sumando un total de: "+this.trabajo.getHorasTrabajadas()+" horas trabajadas en este oficio, "
			+ "y un total de: "+this.horasTrabajadasTotales+" horas trabajadas en total"+Tiempo;
		}
		
	}
	
	public String recrear(Biblioteca biblioteca, int horas) {
		if(this.patio instanceof Biblioteca && this.patio == biblioteca) {
			return ((Biblioteca)patio).laborarReo(this, horas);
		}
		else {
			return "El reo no puede puede recrearse en otro patio que no sea de el";
		}
	}
	
	public String recrear(Gimnasio gimnasio, int horas) {
		if(this.patio instanceof Gimnasio && this.patio == gimnasio) {
			return ((Gimnasio)patio).laborarReo(this, horas);
		}
		else {
			return "El reo no puede puede recrearse en otro patio que no sea de el";
		}
	}
	
	public void sumarComportamiento(int x) {
		this.comportamiento += x;
	}
	
	public void restarComportamiento(int x) {
		this.comportamiento -= x;
	}
	
	//////////Setters y Getters
	
	
	public void sumarHorasTrabajadasTotales(int x) {
		this.horasTrabajadasTotales += x;
	}

	public float getCondena() {
		return condena;
	}

	public void setCondena(float condena) {
		this.condena = condena;
	}

	public Prision getPrision() {
		return prision;
	}

	public void setPrision(Prision prision) {
		//A�ade al historial
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
		
		if(this.getPrision() != null) {
			this.prision.addHistorialReos("El reo: "+this.nombre+", con c�digo: "+this.codigo+" ha salido de la prisi�n: "+this.prision.getNombre()+", y ser� trasladado a: "+prision.getNombre()+Tiempo);
			prision.addHistorialReos("El reo: "+this.nombre+", con c�digo: "+this.codigo+" ha salido de la prisi�n: "+this.prision.getNombre()+", y ser� trasladado a: "+prision.getNombre()+Tiempo);
			this.prision.getReos().remove(this);
			this.prision = prision;
			prision.addReos(this);			
		}else {
			this.prision=prision;
			prision.addReos(this);
			prision.addHistorialReos("El reo: "+this.nombre+", con c�digo: "+this.codigo+" ha ingresado a la prision: "+prision.getNombre()+Tiempo);
		}
		
		
	}

	public Celda getCelda() {
		return celda;
	}

	public void setCelda(Celda celda) {
		//A�ade al historial
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
		if	(celda == null) {
			this.prision.addHistorialReos("El reo: "+this.nombre+", con c�digo: "+this.codigo+" ha sido sacado de la celda n�mero: "+this.celda.getNumCelda()+Tiempo);
			this.celda=null;
			return;
		}
		else if(celda.getReosPertenecientes().size()+1<=2){
			if(this.getCelda()!=null) {
					this.getCelda().sacarReo(this);
					celda.asignarReo(this);
					this.celda=celda;
					this.prision.addHistorialReos("El reo: "+this.nombre+", con c�digo: "+this.codigo+" ha sido trasladado a la celda n�mero: "+this.celda.getNumCelda()+Tiempo);
			}
				
			else {
				celda.asignarReo(this);
				this.celda=celda;
				this.prision.addHistorialReos("El reo: "+this.nombre+", con c�digo: "+this.codigo+" ha sido trasladado a la celda n�mero: "+this.celda.getNumCelda()+Tiempo);
			}
		}
		else {
			this.prision.addHistorialReos("El reo: "+this.nombre+", con c�digo: "+this.codigo+" no se puede trasladas a esta celda porque est� llena"+Tiempo);
		}
	}

	public Trabajo getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(Trabajo trabajo) {
		//A�ade al historial
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
		
		if (trabajo == null) {
			this.trabajo=trabajo;
			//ya se removio de la lista de prision en la clase Trabajo
			this.prision.addHistorialReos("El reo: "+this.nombre+", con c�digo: "+this.codigo+"ha renunciado a su trabajo"+Tiempo);
			return	;
		}
		if (this.getPrision() != null) {
			this.trabajo = trabajo;
			this.getPrision().getTrabajos().add(trabajo);
			this.prision.addHistorialReos("El reo: "+this.nombre+", con c�digo: "+this.codigo+"ha ingresado al trabajo de "+this.trabajo.getNombre()+Tiempo);
		}
		else {
			this.prision.addHistorialReos("El reo: "+this.nombre+", con c�digo: "+this.codigo+"no puedo ingresar al trabajo de "+this.trabajo.getNombre()+" porque no tiene asignada una prisi�n"+Tiempo);
		}
		
		
	}

	public Patio getPatio() {
		return patio;
	}

	public void setPatio(Patio patio) {
		this.patio = patio;
	}

	public int getHorasTrabajadasTotales() {
		return horasTrabajadasTotales;
	}

	public void setHorasTrabajadasTotales(int horasTrabajadasTotales) {
		this.horasTrabajadasTotales = horasTrabajadasTotales;
	}

	public int getComportamiento() {
		return comportamiento;
	}

	public void setComportamiento(int comportamiento) {
		this.comportamiento = comportamiento;
	}

	public static ArrayList<Reo> getReosTotales() {
		return reosTotales;
	}

	public static void setReosTotales(ArrayList<Reo> reosTotales) {
		Reo.reosTotales = reosTotales;
	}

	public static ArrayList<String> getHistorialReos() {
		return historialReos;
	}

	public static void setHistorialReos(ArrayList<String> historialReos) {
		Reo.historialReos = historialReos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
	
}