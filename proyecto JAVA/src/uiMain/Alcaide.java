package uiMain;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import gestorAplicacion.bienes.*;
import gestorAplicacion.departamentos.*;
import gestorAplicacion.personal.*;

public class Alcaide {

	public static void main(String[] args) {
		Prision Cali = new Prision();
		Reo r = new Reo("Andres", 101, true, 12, Cali);
		Guardia g = new Guardia("Alonso", 01, Cali, Rango.oficial);
		Celda celda = new Celda(999);
		
		g.meterReoCelda(r, celda);
		
		for (int i = 0; i < r.getPrision().historialGuardias.size(); i++) {
			System.out.println(r.getPrision().historialGuardias.get(i));
		}
		
		System.out.println(r.getCelda().getNumCelda());
		
//		Trabajo.asignarTrabajoReo(r, OpcionTrabajo.Bibliotecario);
//		System.out.println(r.getPrision().historialTrabajos.get(0));
//		Trabajo.renunciarTrabajoReo(r);
//		System.out.println(r.getPrision().historialTrabajos.get(1));
//		
//		for (int i = 0; i < r.getPrision().historialTrabajos.size(); i++) {
//			System.out.println(r.getPrision().historialTrabajos.get(i));
//		}
	}

}

