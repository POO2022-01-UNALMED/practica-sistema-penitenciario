package gestorAplicacion.personal;

import java.util.List;
import java.util.ArrayList;
import gestorAplicacion.bienes.*;
import gestorAplicacion.departamentos.*;

public class Reo {

	private final String nombre;
	private final int codigo;
	private final boolean Genero; //Tomaremos que 1 sea hombre, 0 mujer.
	private int condena;
	private Prision prision;
	private Trabajo trabajo;
	// añadir un enum?
	private List<String> historialReo;
	
}
