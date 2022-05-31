package gestorAplicacion.personal;

import java.io.Serializable;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import gestorAplicacion.bienes.*;
import gestorAplicacion.departamentos.*;

public class Trabajo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private OpcionTrabajo trabajo;
	private final Reo reo;
	private int horasTrabajadas;
	private static ArrayList<Reo> reos = new ArrayList<Reo>();
	private static ArrayList<Guardia> guardias = new ArrayList<Guardia>();
	private static ArrayList<Trabajo> trabajosTotales = new ArrayList<Trabajo>();
	//private static ArrayList<String> historialTrabajo = new ArrayList<String>();
	
	private Trabajo(Reo reo, OpcionTrabajo trabajo) {
		this.reo = reo;
		this.trabajo = trabajo;
		Trabajo.reos.add(reo);
		trabajosTotales.add(this);
	}
	
	public static String asignarTrabajoReo(Reo reo, OpcionTrabajo trabajo) {
		Trabajo trabajoDelReo = new Trabajo(reo, trabajo);
		reo.setTrabajo(trabajoDelReo);
		
		//A�ade al historial
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = dtf.format(LocalDateTime.now())+".";
		
		reo.getPrision().addHistorialTrabajos("El reo: "+reo.getNombre()+", con c�digo: "+reo.getCodigo()+", se ha inscrito al trabajo: "+trabajo.getNombre()+". "+Tiempo);
		return "El reo: "+reo.getNombre()+", con c�digo: "+reo.getCodigo()+", se ha inscrito al trabajo: "+trabajo.getNombre()+". "+Tiempo;
		
	}
	
	public static void renunciarTrabajoReo(Reo reo) {
		String NombreDeTrabajoARenunciar = reo.getTrabajo().getNombre();
		trabajosTotales.remove(reo.getTrabajo());
		reo.getPrision().getTrabajos().remove(reo.getTrabajo());
		reo.setTrabajo(null);
		Trabajo.reos.remove(reo);
		
		
		//A�ade al historial
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = dtf.format(LocalDateTime.now())+".";
		
		reo.getPrision().addHistorialTrabajos("El reo: "+reo.getNombre()+", con c�digo: "+reo.getCodigo()+", ha renunciado a su trabajo como: "+NombreDeTrabajoARenunciar+". "+Tiempo);
	}
	
	public int getHorasTrabajadas() {
		return this.horasTrabajadas;
	}

	public void sumarHorasTrabajadas() {
		this.horasTrabajadas += this.getHorasQueLlevaHacerUnTurno();
		this.reo.sumarHorasTrabajadasTotales(this.getHorasQueLlevaHacerUnTurno());
	}

	public String getNombre() {
		return this.trabajo.getNombre();
	}
	
	public Dificultad getDificultad() {
		return this.trabajo.getDificultad();
	}
	
	public int getHorasQueLlevaHacerUnTurno() {
		return this.trabajo.getHorasQueLlevaHacerUnTurno();
	}
	
	public int getConstanteTrabajo() {
		return this.trabajo.getConstanteDeDificultad();
	}

	public OpcionTrabajo getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(OpcionTrabajo trabajo) {
		this.trabajo = trabajo;
	}

	public static ArrayList<Reo> getReos() {
		return reos;
	}

	public static void setReos(ArrayList<Reo> reos) {
		Trabajo.reos = reos;
	}

	public static ArrayList<Guardia> getGuardias() {
		return guardias;
	}

	public static void setGuardias(ArrayList<Guardia> guardias) {
		Trabajo.guardias = guardias;
	}

	public static ArrayList<Trabajo> getTrabajosTotales() {
		return trabajosTotales;
	}

	public static void setTrabajosTotales(ArrayList<Trabajo> trabajosTotales) {
		Trabajo.trabajosTotales = trabajosTotales;
	}

	public Reo getReo() {
		return reo;
	}

	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	
	

}
