package gestorAplicacion.personal;

import java.util.List;
import java.util.ArrayList;
import gestorAplicacion.bienes.*;
import gestorAplicacion.departamentos.*;

public class Guardia {
	
	private enum Rango {bachiller, carcelero, oficial};
	private String nombre;
	private int codigo;
	private Rango rango;
	private Prision prision;
	private List<String> historialGuardia;

}
