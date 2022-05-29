package gestorAplicacion.personal;

import java.util.List;
import java.util.ArrayList;
import gestorAplicacion.bienes.*;
import gestorAplicacion.departamentos.*;

public class Trabajo {
	
	private OpcionTrabajo trabajo;
	private final Reo reo;
	private int horasTrabajadas;
	private static ArrayList<Reo> reos = new ArrayList<Reo>();
	private static ArrayList<Guardia> guardias = new ArrayList<Guardia>();
	private static ArrayList<String> historialTrabajo = new ArrayList<String>();
	
	public Trabajo(Reo reo, OpcionTrabajo trabajo) {
		this.reo = reo;
		this.trabajo = trabajo;
		Trabajo.reos.add(reo);
		
	}
	
	public static void asignarTrabajoReo(Reo reo, OpcionTrabajo trabajo) {
		Trabajo trabajoDelReo = new Trabajo(reo, trabajo);
		reo.setTrabajo(trabajoDelReo);
	}
	
	public static void renunciarTrabajoReo(Reo reo) {
		reo.setTrabajo(null);
		Trabajo.reos.remove(reo);
	}
	
	public int getHorasTrabajadas() {
		return this.horasTrabajadas;
	}

	public void sumarHorasTrabajadas() {
		this.horasTrabajadas += this.getHorasQueLlevaHacerUnTurno();
		this.reo.sumarHorasTrabajadasTotales(this.getHorasQueLlevaHacerUnTurno());
	}

	public Dificultad getDificultad() {
		return this.trabajo.dificultad;
	}
	
	public int getHorasQueLlevaHacerUnTurno() {
		return this.trabajo.horasQueLlevaHacerUnTurno;
	}
	
	public int constanteTrabajo() {
		return this.trabajo.constanteDeDificultad;
	}
	
	

}
