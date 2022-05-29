package gestorAplicacion.personal;

import java.util.List;
import java.util.ArrayList;
import gestorAplicacion.bienes.*;
import gestorAplicacion.departamentos.*;
import gestorAplicacion.personal.Trabajo.Dificultad;

public abstract class Trabajo {
	
public enum Dificultad {facil, normal, dificil};
	
	public Reo reo;
	public int horasTrabajadas;
	public static Dificultad dificultad;
	public static int horasQueLlevaHacerUnTurno;
	public static ArrayList<Reo> reos = new ArrayList<Reo>();
	public static ArrayList<Guardia> guardias = new ArrayList<Guardia>();
	public static ArrayList<String> historialTrabajo = new ArrayList<String>();
	
	
	public int constanteTrabajo() {
		int k;
		
		if (this.getDificultad() == Dificultad.facil) {
			k = 1;
		}
		else if (this.getDificultad() == Dificultad.normal){
			k = 2;
		}
		else if (this.getDificultad() == Dificultad.dificil) {
			k = 3;
		}
		else {k=0;}
				
		return k;
	}
	
	public abstract Dificultad getDificultad();
	public abstract int getHorasTrabajadas();
	public abstract void sumarHorasTrabajadas();
	public abstract int getHorasQueLlevaHacerUnTurno();
	

}
