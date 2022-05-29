package gestorAplicacion.personal.trabajos;

import gestorAplicacion.personal.Trabajo;
import gestorAplicacion.personal.Trabajo.Dificultad;
import gestorAplicacion.personal.*;

public class Barrendero extends Trabajo{
	
	public final Reo reo;
	public static final Dificultad dificultad=Dificultad.facil;
	public static final int horasQueLlevaHacerUnTurno=3;
	
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

	@Override	
	public Dificultad getDificultad() {
		return this.dificultad;
	}

	@Override
	public int getHorasTrabajadas() {
		return this.horasTrabajadas;
	}

	@Override
	public void sumarHorasTrabajadas() {
		this.horasTrabajadas += horasQueLlevaHacerUnTurno;
		this.reo.sumarHorasTrabajadasTotales(horasQueLlevaHacerUnTurno);
	}

	@Override
	public int getHorasQueLlevaHacerUnTurno() {
		return Barrendero.horasQueLlevaHacerUnTurno;
	}
	
	
}
