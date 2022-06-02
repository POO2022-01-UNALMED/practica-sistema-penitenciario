package gestorAplicacion.personal;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import java.util.List;
import java.util.ArrayList;
//import gestorAplicacion.bienes.*;
import gestorAplicacion.departamentos.*;

public class Reo implements Persona, Serializable{

	private static final long serialVersionUID = 1L;
	private final String nombre;
	private final int codigo;
	private final boolean genero; //Tomaremos que 1 sea hombre, 0 mujer.
	private float condena;
	private Prision prision; //prisión asignada al reo, no es final, puede ser trsladado a otra
	private Celda celda; //celda que se le asigna
	private Trabajo trabajo; //trabajo que se le asigna, no es obligatorio que el reo esté trabajando
	private Patio patio; //patio en el que está el reo, puede cambiar entre gimnasio, biblioteca o ninguno para recrearse en estos
	private int horasTrabajadasTotales; 
	private int comportamiento; //El comportamiento subira trabajando y haciendo actividades de los patios, luego esto determinara cuanto tiempo de condena se reducen
	private static ArrayList<Reo> reosTotales = new ArrayList<Reo>();
	private static ArrayList<String> historialReos = new ArrayList<String>(); //historial de todos los movimientos que hacen los reos
	
	
	
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
			prision.addHistorialReos("El reo: "+nombre+", con codigo: "+codigo+", ha ingreado con "+condena+" a�os de condena a la prision: "+prision.getNombre()+Tiempo);
		
	}

	public Reo(String nombre, int codigo, boolean genero, int condena, Prision prision, Celda celda) {
		this(nombre, codigo, genero, condena, prision);
		
		if(celda.getReosPertenecientes().size()+1 > 2) { //las celdas tienen una capacidad máxima de 2 reos, revisamos si no hay espacio
			
			//A�ade al historial
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
				prision.addHistorialReos("El reo: "+nombre+", con codigo: "+codigo+" no se le pudo asignar celda porque esta llena"+Tiempo);
	
		}
		else {
			this.celda=celda;
			celda.asignarReo(this);
			
			//A�ade al historial
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
				prision.addHistorialReos("El reo: "+nombre+", con codigo: "+codigo+", ha ingreado a la celda numero: "+celda.getNumCelda()+Tiempo);
		}
		
		
	}
	
	/////////////Metodos
	
	public String trabajar() {
		if (this.getTrabajo() == null) {
			return "Reo no tiene trabajo";
		}
		else {
			
			//obtenemos constantes que son especificas de cada trabajo, dependiendo de su dificultad y las horas que lleva hacer un turno
			int ConstTrab = this.getTrabajo().getConstanteTrabajo();
			int HorasDelTurno = this.getTrabajo().getHorasQueLlevaHacerUnTurno();
			
			//Con una ecuacion simple suma al comportamiento por ser juicioso y trabajar
			this.trabajo.sumarHorasTrabajadas(this.trabajo.getHorasQueLlevaHacerUnTurno());
			this.sumarComportamiento(ConstTrab*HorasDelTurno); 
			
			//A�ade al historial
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
			
				prision.addHistorialTrabajos("El reo: "+this.nombre+", con codigo: "+this.codigo+", "
						+ "ha ido a trabajar de "+this.trabajo.getNombre()+". "
						+ "Se fue a hacer un turno de "+ this.trabajo.getHorasQueLlevaHacerUnTurno() +" horas y lleva un total de"
							+ ": "+this.horasTrabajadasTotales+" horas trabajadas en total"+Tiempo);
				return "El reo: "+this.nombre+", con codigo: "+this.codigo+", "
				+ "ha ido a trabajar de "+this.trabajo.getNombre()+". "
				+ "Se fue a hacer un turno de "+ this.trabajo.getHorasQueLlevaHacerUnTurno() +" horas y lleva un total de"
				+ ": "+this.horasTrabajadasTotales+" horas trabajadas en total"+Tiempo;
		}
		
	}
	
	//Estos metodos ponen a hacer actividades al reo en un patio especifico, verificando primero que sí pueda 
	
	public String recrear(Biblioteca biblioteca, int horas) {
		if(this.patio instanceof Biblioteca && this.patio == biblioteca) { 
			return ((Biblioteca)patio).laborarReo(this, horas);	//En la biblioteca aprenden poo
		}
		else {
			return "El reo no puede puede recrearse en otro patio que no sea de el";
		}
	}
	
	public String recrear(Gimnasio gimnasio, int horas) {
		if(this.patio instanceof Gimnasio && this.patio == gimnasio) {	
			return ((Gimnasio)patio).laborarReo(this, horas);	//en el gym se ejercitan 
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
	
	//este set tomara todas las precauciones para que se haga un traslado correcto de prision a prision

	public void setPrision(Prision prision) {
		//Añade al historial
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
		
		if(this.getPrision() != null) {
			this.prision.addHistorialReos("El reo: "+this.nombre+", con codigo: "+this.codigo+" ha salido de la prision: "+this.prision.getNombre()+", y sera trasladado a: "+prision.getNombre()+Tiempo);
			prision.addHistorialReos("El reo: "+this.nombre+", con codigo: "+this.codigo+" ha salido de la prision: "+this.prision.getNombre()+", y sera trasladado a: "+prision.getNombre()+Tiempo);
			this.prision.getReos().remove(this);
			this.prision = prision;
			prision.addReos(this);			
		}else {
			this.prision=prision;
			prision.addReos(this);
			prision.addHistorialReos("El reo: "+this.nombre+", con codigo: "+this.codigo+" ha ingresado a la prision: "+prision.getNombre()+Tiempo);
		}
		
		
	}

	public Celda getCelda() {
		return celda;
	}

	//este set tomara todas las precauciones de que se re asigne la celda de forma correcta
	
	public void setCelda(Celda celda) {
		//A�ade al historial
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
		if	(celda == null) {
			this.prision.addHistorialReos("El reo: "+this.nombre+", con codigo: "+this.codigo+" ha sido sacado de la celda numero: "+this.celda.getNumCelda()+Tiempo);
			this.celda=null;
			return;
		}
		else if(celda.getReosPertenecientes().size()+1<=2){ //revisa que la celda tenga espacio para que el reo pueda entrar a ella
			if(this.getCelda()!=null) {
					this.getCelda().sacarReo(this);
					celda.asignarReo(this);
					this.celda=celda;
					this.prision.addHistorialReos("El reo: "+this.nombre+", con codigo: "+this.codigo+" ha sido trasladado a la celda numero: "+this.celda.getNumCelda()+Tiempo);
			}
				
			else {
				celda.asignarReo(this);
				this.celda=celda;
				this.prision.addHistorialReos("El reo: "+this.nombre+", con codigo: "+this.codigo+" ha sido trasladado a la celda numero: "+this.celda.getNumCelda()+Tiempo);
			}
		}
		else {
			this.prision.addHistorialReos("El reo: "+this.nombre+", con codigo: "+this.codigo+" no se puede trasladas a esta celda porque esta llena"+Tiempo);
		}
	}

	public Trabajo getTrabajo() {
		return trabajo;
	}
	
	//Este set se encarga de asignar correctamente un trabajo a un reo, asegurandose que se registre en el sistema de forma exitosa 
	
	public void setTrabajo(Trabajo trabajo) {
		//A�ade al historial
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
		
		if (trabajo == null) {
			this.trabajo=trabajo;
			//ya se removio de la lista de prision en la clase Trabajo así que es seguro hacer esto
			this.prision.addHistorialReos("El reo: "+this.nombre+", con codigo: "+this.codigo+", ha renunciado a su trabajo"+Tiempo);
			return	;
		}
		if (this.getPrision() != null) {
			this.trabajo = trabajo;
			this.getPrision().getTrabajos().add(trabajo);
			this.prision.addHistorialReos("El reo: "+this.nombre+", con codigo: "+this.codigo+", ha ingresado al trabajo de "+this.trabajo.getNombre()+Tiempo);
		}
		else {
			this.prision.addHistorialReos("El reo: "+this.nombre+", con codigo: "+this.codigo+", no puedo ingresar al trabajo de "+this.trabajo.getNombre()+" porque no tiene asignada una prision"+Tiempo);
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