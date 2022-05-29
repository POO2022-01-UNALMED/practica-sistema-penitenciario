package gestorAplicacion.personal;

import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import gestorAplicacion.bienes.*;
import gestorAplicacion.departamentos.*;

public class Trabajo{
	
	private OpcionTrabajo trabajo;
	private final Reo reo;
	private int horasTrabajadas;
	private static ArrayList<Reo> reos = new ArrayList<Reo>();
	private static ArrayList<Guardia> guardias = new ArrayList<Guardia>();
	//private static ArrayList<String> historialTrabajo = new ArrayList<String>();
	
	private Trabajo(Reo reo, OpcionTrabajo trabajo) {
		this.reo = reo;
		this.trabajo = trabajo;
		Trabajo.reos.add(reo);
		
	}
	
	public static void asignarTrabajoReo(Reo reo, OpcionTrabajo trabajo) {
		Trabajo trabajoDelReo = new Trabajo(reo, trabajo);
		reo.setTrabajo(trabajoDelReo);
		
		//Añade al historial
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = dtf.format(LocalDateTime.now())+".";
		
		reo.getPrision().addHistorialTrabajos("El reo: "+reo.getNombre()+", con código: "+reo.getCodigo()+", se ha inscrito al trabajo: "+trabajo.getNombre()+". "+Tiempo);
		
	}
	
	public static void renunciarTrabajoReo(Reo reo) {
		String NombreDeTrabajoARenunciar = reo.getTrabajo().getNombre();
		reo.setTrabajo(null);
		Trabajo.reos.remove(reo);
		
		//Añade al historial
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = dtf.format(LocalDateTime.now())+".";
		
		reo.getPrision().addHistorialTrabajos("El reo: "+reo.getNombre()+", con código: "+reo.getCodigo()+", ha renunciado a su trabajo como: "+NombreDeTrabajoARenunciar+". "+Tiempo);
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

	
	

}
