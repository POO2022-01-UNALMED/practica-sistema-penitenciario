package uiMain;

import java.util.List;
import baseDatos.Serializador;
import baseDatos.Deserializador;
import java.util.ArrayList;
import java.util.Scanner;
import gestorAplicacion.bienes.*;
import gestorAplicacion.departamentos.*;
import gestorAplicacion.personal.*;

public class Alcaide {
	static Scanner sc = new Scanner(System.in);
	static long readLong() {
		return sc.nextLong();	
	}
	
	static String readIn() {
		sc.nextLine();
		return sc.nextLine();
	}

	public static void main(String[] args) {
		
		Deserializador.deserializarTodo();
		Prision azkaban = Prision.getPrisiones().get(0);
		Prision torreOscura = Prision.getPrisiones().get(1);
		Reo genner = Reo.getReosTotales().get(0);
		Reo andres = Reo.getReosTotales().get(1);
		Reo faidher = Reo.getReosTotales().get(2);
		Reo alejandro = Reo.getReosTotales().get(3);
		System.out.println(genner.getPrision().getNombre());
		System.out.println(faidher.getPrision().getNombre());
		System.out.println(alejandro.getPrision().getNombre());
		Guardia jaime = Guardia.getGuardiasTotales().get(0);
		Guardia david = Guardia.getGuardiasTotales().get(1);
		Guardia julian = Guardia.getGuardiasTotales().get(2);
		Guardia oswaldo = Guardia.getGuardiasTotales().get(3);
		ArrayList<Bus> listaBusesAzkaban = azkaban.getBuses();
		ArrayList<Bus> listaBusesTorreOscura = torreOscura.getBuses();
		ArrayList<Reo> prisionerosFA = new ArrayList<Reo>(); 
		prisionerosFA.add(alejandro);
		prisionerosFA.add(faidher);
		ArrayList<Guardia> guardiasFA = new ArrayList<Guardia>();
		guardiasFA.add(oswaldo);
		guardiasFA.add(julian);
	
		

//		/////////////////////////////PRISIONES POR DEFECTO//////////////////////////////////////
//		Prision azkaban = new Prision("Azkaban");	
//		Prision torreOscura = new Prision("Torre Oscura");
//		
//		///////////////////////////////REOS POR DEFECTO//////////////////////////////////////////////
//		Reo genner = new Reo("Genner",1001, true, 10);
//		Reo andres = new Reo("Andres",1002, true, 10);
//		Reo faidher= new Reo("Faidher",1003, true, 10);
//		Reo alejandro = new Reo("Alejandro",1001, true, 10);
//		
//		//////////////////////////////GUARDIAS POR DEFECTO//////////////////////////////////////////
//		Guardia jaime = new Guardia("Jaime", 2001, azkaban, Rango.oficial);
//		Guardia david = new Guardia("David", 2003, azkaban, Rango.carcelero);
//		Guardia julian = new Guardia("Julian", 2002, torreOscura, Rango.oficial);
//		Guardia oswaldo = new Guardia("Oswaldo", 2004, torreOscura, Rango.carcelero);
//		//Guardia aprendiz = new Guardia("Aprendiz", 2005, torreOscura, Rango.bachiller);
//		
//		
//		//////////////////////////////LISTADO DE BUSES POR DEFECTO/////////////////////////////////
//		ArrayList<Bus> listaBusesAzkaban = new ArrayList<Bus>();
//		for (int i = 0; i < 6; i++) {
//			listaBusesAzkaban.add(new Bus(azkaban));
//		}
//		ArrayList<Bus> listaBusesTorreOscura = new ArrayList<Bus>();
//		for (int i = 0; i < 6; i++) {
//			listaBusesTorreOscura.add(new Bus(torreOscura));
//		}
//		/////////////////////////////ASIGNACION DE REOS A PRISIONES/////////////////////////
//		genner.setPrision(azkaban);
//		andres.setPrision(azkaban);
//		faidher.setPrision(torreOscura);
//		alejandro.setPrision(torreOscura);
//		
//		//azkaban.getBibliotecas().get(0).ingresarReos(genner);
//		//azkaban.getGimnasios().get(0).ingresarReos(andres);
//		jaime.meterReoPatio(andres, azkaban.getGimnasios().get(0));
//		jaime.meterReoPatio(genner, azkaban.getBibliotecas().get(0));
//		
//		ArrayList<Reo> prisionerosFA = new ArrayList<Reo>(); 
//		prisionerosFA.add(alejandro);
//		prisionerosFA.add(faidher);
//		
//		ArrayList<Guardia> guardiasFA = new ArrayList<Guardia>();
//		//guardiasFA.add(aprendiz);
//		guardiasFA.add(oswaldo);
//		guardiasFA.add(julian);
//		
//		System.out.println(Prision.getPrisiones().get(0).getNombre());
//		System.out.println(Prision.getPrisiones().get(1).getNombre());
//		System.out.println(Prision.getPrisionesCreadas());
//		Serializador.serializarTodo();
		
	


		int opcion;
		do {
			
			System.out.println("Que operación desea realizar?");
			System.out.println("1. Movilización reos");
			System.out.println("2. Ver historial de prision");
			System.out.println("3. Reducir condena a reo");
			System.out.println("4. Recrear a reo");
			System.out.println("5. Poner a trabajar a reo");
			System.out.println("6. Terminar");
			opcion = (int) readLong();
			
			switch(opcion) {
				case 1: moverReos(prisionerosFA, guardiasFA, azkaban, listaBusesTorreOscura); break;
				case 2: verHistorial(azkaban); break;
				case 3: reducirCondena(andres); break;
				case 4: recrearReo(genner, azkaban); break;
				case 5: trabajarReo(andres, OpcionTrabajo.Barrendero); break;
				case 6:
					Serializador.serializarTodo();
					break;
					

				
			} 
		}while (opcion != 6);
	
	}
	static void moverReos(ArrayList<Reo> reos,ArrayList<Guardia> guardias, Prision p, ArrayList<Bus> buses){
	
		System.out.println(buses.get(0).llevarReos(reos, guardias , p));
		
	}
	static void verHistorial(Prision prision){
		
		System.out.println(prision.getHistorialPrision());
		
	}
	static void reducirCondena(Reo reo){
		if (reo.getCondena() <= 0) {
			if (reo.getPatio() != null) {
				System.out.println(reo.getPatio().sacarReos(reo));
			}
			reo.getPrision().getReos().remove(reo.getPrision().getReos().indexOf(reo));
			System.out.println("El reo con nombre: "+ reo.getNombre()+" y cuyo codigo es " + reo.getCodigo()
			+" ha tenido un buen comportamiento durante su estadía en prision y por tanto queda liberado.");
			reo=null;
		}
		else if (reo.getTrabajo() != null) {
			//System.out.println(reo.getComportamiento());
			float a = reo.getComportamiento();
			float b = 200;
			float k = reo.getCondena()- a/b;
			reo.setCondena(k);
			System.out.println("Ahora la condena del reo "+reo.getNombre()+" será "+reo.getCondena());
			//reo.setHorasTrabajadasTotales(0);
			//Trabajo.renunciarTrabajoReo(reo);
			reo.setComportamiento(0);
			
		}
		else {
			System.out.println("El reo "+reo.getNombre()+" no tiene trabajo, asignele uno");
		}
	}
	static void recrearReo(Reo reo, Prision prision){
		if (reo.getPatio() instanceof Biblioteca) {System.out.println(reo.recrear((Biblioteca)reo.getPatio(), 10));}
		else if(reo.getPatio() instanceof Gimnasio){System.out.println(reo.recrear((Gimnasio)reo.getPatio(), 10));}
		
	}
	static void trabajarReo(Reo reo, OpcionTrabajo op){
			System.out.println(Trabajo.asignarTrabajoReo(reo, op));
		}
		
		
	}
//	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////7	
//		//___________________________________FUNCIONALIDAD 1: HISTORIAL DE LAS PRISIONES_____________________________________________
//		
//		
//		System.out.println(azkaban.getHistorialPrision()); /// historial de Azkaban
//		System.out.println(torreOscura.getHistorialPrision()); /// historial de Torre Oscura
//		
//		//__________________________________FUNCIONALIDAD 2: MOVILIZACIÓN DE REOS POR EL SISTEMA PENITENCIARIO________________________
//		prisionerosFA.add(alejandro);
//		prisionerosFA.add(faidher);
//		ArrayList<Guardia> guardiasFA = new ArrayList<Guardia>();
//		guardiasFA.add(julian);
//		guardiasFA.add(oswaldo);
//		listaBusesTorreOscura.get(0).llevarReos(prisionerosFA, guardiasFA, azkaban);
//		//System.out.println(torreOscura.getHistorialPrision());
//		//System.out.println(azkaban.getHistorialPrision());
//		if (azkaban.getReos().size() !=0) {
//			for (int i =0; i < azkaban.getReos().size(); i++) {
//				System.out.println(azkaban.getReos().get(i).getNombre());
//			}
//		}
//		else {
//			System.out.println("No hay reos");
//		}
//
//		if (torreOscura.getReos().size() !=0) {
//			for (int i =0; i < torreOscura.getReos().size(); i++) {
//				System.out.println(torreOscura.getReos().get(i).getNombre());
//			}
//		}
//		else {
//			System.out.println("No hay reos");
//		}
//		//__________________________________FUNCIONALIDAD 3: REDUCCION DE CONDENAS_________________________
//		azkaban.getBibliotecas().get(0).ingresarReos(andres);
//		azkaban.getBibliotecas().get(0).laborarReo(andres, 10);
//		
//		
//		
//		
//		
//		
//		
//		
//		
//
//	}
//}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Prision cali = new Prision(10,"Tierra media","Barad-dur");
//Prision manizales = new Prision(7,"Manizales","breee");
//
//
//Reo r1 = new Reo("Andres", 101, true, 12, cali);
//Reo r2 = new Reo("Genner", 102, true, 20, manizales);
//Reo r3 = new Reo("Faidher", 103, true, 43);
//
//Guardia g1 = new Guardia("Habibi", 2001);
//Guardia g2 = new Guardia("Alonso", 2002, cali, Rango.oficial);
//
//Gimnasio gym = new Gimnasio("European Gym", cali);
//Biblioteca bib = new Biblioteca("Publica Piloto", cali);
//
//Celda celda = new Celda(999, cali);
//
//r2.setPrision(cali);
//r3.setPrision(cali);
//g1.setPrision(cali);
//
//g1.meterReoCelda(r1, celda);
//g1.promocionarGuardia();
//g1.meterReoCelda(r1, celda);
//g2.meterReoCelda(r2, celda);
//g1.meterReoCelda(r3, celda);
//
//g1.meterReoPatio(r1, gym);
//g1.meterReoPatio(r2, bib);
//r1.recrear(bib, 2);
//r1.recrear(gym, 2);
//
////g.meterReoCelda(r, celda);
//
//for (int i = 0; i < cali.getHistorialGuardias().size(); i++) {
//	System.out.println(cali.getHistorialGuardias().get(i));
//}
//
//System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\");
//
//for (int i = 0; i < cali.getHistorialReos().size(); i++) {
//	System.out.println(cali.getHistorialReos().get(i));
//}
//
//}
//}
