package gestorAplicacion.personal;

import java.util.List;
import java.util.ArrayList;
import gestorAplicacion.bienes.*;
import gestorAplicacion.departamentos.*;

public abstract class Trabajo {
	
public enum Dificultad {facil, normal, dificil};
	
	public Reo reo;
	public static Dificultad dificultad;
	public static ArrayList<Reo> reos = new ArrayList<Reo>();
	public static ArrayList<Guardia> guardias = new ArrayList<Guardia>();
	public static ArrayList<String> historialTrabajo = new ArrayList<String>();
	public int horasTrabajadas;
	
	public int trabajar() {
		int k;
		
		if (Trabajo.dificultad == Dificultad.facil) {
			k = 1;
		}
		else if (Trabajo.dificultad == Dificultad.normal){
			k = 2;
		}
		else {
			k = 3;
		}
				
		return k;
		
	}
	
	

}
