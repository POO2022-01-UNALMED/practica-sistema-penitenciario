package uiMain;

import java.util.List;

import java.util.ArrayList;
import java.util.Scanner;
import gestorAplicacion.bienes.*;
import gestorAplicacion.departamentos.*;
import gestorAplicacion.personal.*;

public class Alcaide {

	public static void main(String[] args) {
		Reo genner = new Reo("Genner",1001, true, 10);
		Reo andres = new Reo("Andres",1002, true, 10);
		Reo faidher= new Reo("Faidher",1003, true, 10);
		Reo alejandro = new Reo("Alejandro",1001, true, 10);
		
		Prision azkaban = new Prision("Azkaban");
		Prision torreOscura = new Prision("Torre Oscura");
		
		ArrayList<Bus> listaBusesAzkaban = new ArrayList<Bus>();
		for (int i = 0; i < 6; i++) {
			String k = "A100"+i;
			listaBusesAzkaban.add(new Bus(k,azkaban));
		}
		
		ArrayList<Bus> listaBusesTorreOscura = new ArrayList<Bus>();
		for (int i = 0; i < 6; i++) {
			String k = "T100"+i;
			listaBusesTorreOscura.add(new Bus(k,torreOscura));
		}
		
		//___________________________________FUNCIONALIDAD 1: HISTORIAL DE LAS PRISIONES________________________________________________
		
		
	}
}
