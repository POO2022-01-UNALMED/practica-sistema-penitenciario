package gestorAplicacion.personal;

import java.io.Serializable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
//import gestorAplicacion.bienes.*;
//import gestorAplicacion.departamentos.*;

public class Trabajo implements Serializable{
	
	//Cada instancia de Trabajo representa un trabajo que le corresponde a un único reo, este trabajo llevara los datos de
	//varias estadisticas correspondientes al oficio del reo.
	
	private static final long serialVersionUID = 1L;
	private OpcionTrabajo trabajo; //Trabajo el cual estará inscrito
	private final Reo reo; //Reo que se le asigna el trabajo, notese que es final, no se puede re asignar a otro reo
	private int horasTrabajadas; //las horas que lleva el reo trabajando en este oficio
	private static ArrayList<Reo> reos = new ArrayList<Reo>(); //Lista de reos que están trabajando 
	private static ArrayList<Trabajo> trabajosTotales = new ArrayList<Trabajo>(); //trabajos totales que se han creado, sirve para serializar.
	//private static ArrayList<String> historialTrabajo = new ArrayList<String>();
	
	///////////////////////////////Constructores
	
	private Trabajo(Reo reo, OpcionTrabajo trabajo) {
		this.reo = reo;
		this.trabajo = trabajo;
		Trabajo.reos.add(reo);
		trabajosTotales.add(this);
	}
	
	//////////////////////////////Metodos
	
	//Funcion que le va a asignar un trabajo a un reo
	
	public static String asignarTrabajoReo(Reo reo, OpcionTrabajo trabajo) {
		Trabajo trabajoDelReo = new Trabajo(reo, trabajo); //Se crea la instancia del trabajo que se le asignará al reo
		reo.setTrabajo(trabajoDelReo); // Se le informa a la insancia reo sobre su nuevo trabajo asignandosele
		
		//A�ade al historial
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			String Tiempo = dtf.format(LocalDateTime.now())+".";
		
			reo.getPrision().addHistorialTrabajos("El reo: "+reo.getNombre()+", con codigo: "+reo.getCodigo()+", se ha inscrito al trabajo: "+trabajo.getNombre()+". "+Tiempo);
			return "El reo: "+reo.getNombre()+", con codigo: "+reo.getCodigo()+", se ha inscrito al trabajo: "+trabajo.getNombre()+". "+Tiempo;
		
	}
	
	//Funcion para desasignarle el trabajo a un reo
	
	public static void renunciarTrabajoReo(Reo reo) {
		String NombreDeTrabajoARenunciar = reo.getTrabajo().getNombre(); //Almacena el trabajo del reo
		trabajosTotales.remove(reo.getTrabajo());	//Quita el trabajo de la lista de todos los trabajos 
		reo.getPrision().getTrabajos().remove(reo.getTrabajo());	//Quita el trabajo de la prisión (Que fue asignada allá desde la clase reo)
		reo.setTrabajo(null);	// le quita el trabajo al reo totalmente 
		Trabajo.reos.remove(reo); //Quita al reo de la lista de reos que estaban asignados a un trabajo, así removiendo todo rastro de este trabajo.		
		
		//A�ade al historial
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			String Tiempo = dtf.format(LocalDateTime.now())+".";
		
			reo.getPrision().addHistorialTrabajos("El reo: "+reo.getNombre()+", con codigo: "+reo.getCodigo()+", ha renunciado a su trabajo como: "+NombreDeTrabajoARenunciar+". "+Tiempo);
	}
	
	///////// Setters y getters
	

	public void sumarHorasTrabajadas(int x) {
		
		horasTrabajadas += x;
		
		this.reo.sumarHorasTrabajadasTotales(this.getHorasQueLlevaHacerUnTurno()); //A las que ha trabajado un reo se le suman las que demoran hacer un turno de un oficio específico.
	}

	public OpcionTrabajo getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(OpcionTrabajo trabajo) {
		this.trabajo = trabajo;
	}

	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	public static ArrayList<Reo> getReos() {
		return reos;
	}

	public static void setReos(ArrayList<Reo> reos) {
		Trabajo.reos = reos;
	}

	public static ArrayList<Trabajo> getTrabajosTotales() {
		return trabajosTotales;
	}

	public static void setTrabajosTotales(ArrayList<Trabajo> trabajosTotales) {
		Trabajo.trabajosTotales = trabajosTotales;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Reo getReo() {
		return reo;
	}
	
	public String getNombre() {
		return this.trabajo.getNombre();
	}
	
	public int getHorasQueLlevaHacerUnTurno() {
		return this.trabajo.getHorasQueLlevaHacerUnTurno();
	}
	
	public int getConstanteTrabajo() {
		return this.trabajo.getConstanteDeDificultad();
	}

	

}
