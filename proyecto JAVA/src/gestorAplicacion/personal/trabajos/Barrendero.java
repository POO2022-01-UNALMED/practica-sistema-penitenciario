package gestorAplicacion.personal.trabajos;

import gestorAplicacion.personal.Trabajo;
import gestorAplicacion.personal.*;

public class Barrendero extends Trabajo{
	
	public final Reo reo;
	public static final Dificultad dificultad=Dificultad.facil;
	
	public Barrendero(Reo reo) {
		this.reo = reo;
		Barrendero.reos.add(reo);
	}
	
	public static void asignarTrabajoReo(Reo reo) {
		Trabajo trabajoDelReo = new Barrendero(reo);
		reo.setTrabajo(trabajoDelReo);
	}
	
	public static void renunciarTrabajoReo(Reo reo) {
		reo.setTrabajo(null);
		Barrendero.reos.remove(reo);
	}
		
	
}
