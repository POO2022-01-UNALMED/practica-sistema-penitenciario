package uiMain;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import gestorAplicacion.bienes.*;
import gestorAplicacion.departamentos.*;
import gestorAplicacion.personal.*;
import gestorAplicacion.personal.Guardia.Rango;
import gestorAplicacion.personal.trabajos.Barrendero;

public class Alcaide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Reo r = new Reo("Mauri", 1200, false, 32);
		Barrendero.asignarTrabajoReo(r);
		System.out.println(r.getTrabajo());
		
		Reo r2 = new Reo("enner", 1201, false, 19);
		Barrendero.asignarTrabajoReo(r2);
		System.out.println(r2.getTrabajo());
		
		r.trabajar();
		System.out.println(r.getComportamiento());
	}

}

