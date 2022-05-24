package gestorAplicacion.personal;

import java.util.List;
import java.util.ArrayList;
import gestorAplicacion.bienes.*;
import gestorAplicacion.departamentos.*;

public abstract class Trabajo {
	
public enum Dificultad {facil, normal, dificil};
	
	public abstract final Reo reo;
	public static final Dificultad dificultad;
	public static ArrayList<Reo> reos = new ArrayList<Reo>();
	public static ArrayList<Guardia> guardias = new ArrayList<Guardia>();
	public static ArrayList<String> historialTrabajo = new ArrayList<String>();
	
	public abstract void trabajar();
	
	

}
