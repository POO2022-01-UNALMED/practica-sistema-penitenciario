package uiMain;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import gestorAplicacion.bienes.*;
import gestorAplicacion.departamentos.*;
import gestorAplicacion.personal.*;

public class Alcaide {

	public static void main(String[] args) {
		
		Prision cali = new Prision("Cali");
		Prision manizales = new Prision("Manizales");

		
		Reo r1 = new Reo("Andres", 101, true, 12, cali);
		Reo r2 = new Reo("Genner", 102, true, 20, manizales);
		Reo r3 = new Reo("Faidher", 103, true, 43);
		
		Guardia g1 = new Guardia("Habibi", 2001);
		Guardia g2 = new Guardia("Alonso", 2002, cali, Rango.oficial);
		
		
		
		Celda celda = new Celda(999);
		
		r2.setPrision(cali);
		r3.setPrision(cali);
		g1.setPrision(cali);
		
		g1.meterReoCelda(r1, celda);
		g1.promocionarGuardia();
		g1.meterReoCelda(r1, celda);
		g2.meterReoCelda(r2, celda);
		g1.meterReoCelda(r3, celda);
		g2.sacarReoCelda(r1);
		g2.meterReoCelda(r3, celda);
		
		
		
//		g.meterReoCelda(r, celda);
		
		for (int i = 0; i < cali.getHistorialGuardias().size(); i++) {
			System.out.println(cali.getHistorialGuardias().get(i));
		}
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\");
		for (int i = 0; i < cali.getHistorialReos().size(); i++) {
			System.out.println(cali.getHistorialReos().get(i));
		}
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\");
		for (int i = 0; i < celda.getHistorialCelda().size(); i++) {
			System.out.println(celda.getHistorialCelda().get(i));
		}
//	}
	}

}

