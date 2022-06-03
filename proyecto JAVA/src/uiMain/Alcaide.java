package uiMain;

import java.util.List;
import baseDatos.Serializador;
import baseDatos.Deserializador;
import java.util.ArrayList;
import java.util.Scanner;
import gestorAplicacion.bienes.*;
import gestorAplicacion.departamentos.*;
import gestorAplicacion.personal.*;
import static java.lang.Math. *;

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
		
		//////////////Deserialización
		
		Deserializador.deserializarTodo();
	
		Prision azkaban = Prision.getPrisiones().get(0);
		Prision orthanac = Prision.getPrisiones().get(1);
		
		Reo genner = Reo.getReosTotales().get(0);
		Reo andres = Reo.getReosTotales().get(1);
		Reo faidher = Reo.getReosTotales().get(2);
		Reo alejandro = Reo.getReosTotales().get(3);
		
		Guardia jaime = Guardia.getGuardiasTotales().get(0);
		Guardia david = Guardia.getGuardiasTotales().get(1);
		Guardia julian = Guardia.getGuardiasTotales().get(2);
		Guardia oswaldo = Guardia.getGuardiasTotales().get(3);
		
		ArrayList<Bus> listaBusesAzkaban = azkaban.getBuses();
		ArrayList<Bus> listaBusesOrthanac = orthanac.getBuses();
		
		ArrayList<Reo> prisionerosFA = new ArrayList<Reo>(); 
		prisionerosFA.add(alejandro);
		prisionerosFA.add(faidher);
		
		ArrayList<Guardia> guardiasFA = new ArrayList<Guardia>();
		guardiasFA.add(julian);
		guardiasFA.add(oswaldo);
		
		Serializador.serializarTodo(); //// En caso de que el sistema crashee, se guarda la penultima sesión iniciada, ¿ingenioso, no?
		
		//////////Como se definieron las instancias originalmente
		
//		///////////////////////////PRISIONES POR DEFECTO//////////////////////////////////////
//		Prision azkaban = new Prision(100, "Inglaterra", "Azkaban");
//		Prision orthanac = new Prision(50, "Tierra Media", "Orthanc");
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
//		Guardia julian = new Guardia("Julian", 2002, orthanac, Rango.oficial);
//		Guardia oswaldo = new Guardia("Oswaldo", 2004, orthanac, Rango.carcelero);
//		//Guardia aprendiz = new Guardia("Aprendiz", 2005, orthanac, Rango.bachiller);
//		
//		//System.out.println(azkaban.getGuardias().size());
//		
//		//////////////////////////////LISTADO DE BUSES POR DEFECTO/////////////////////////////////
//		ArrayList<Bus> listaBusesAzkaban = new ArrayList<Bus>();
//		for (int i = 0; i < 6; i++) {
//			listaBusesAzkaban.add(new Bus(azkaban));
//		}
//		ArrayList<Bus> listaBusesOrthanac = new ArrayList<Bus>();
//		for (int i = 0; i < 6; i++) {
//			listaBusesOrthanac.add(new Bus(orthanac));
//		}
//		/////////////////////////////ASIGNACION DE REOS A PRISIONES/////////////////////////
//		genner.setPrision(azkaban);
//		andres.setPrision(azkaban);
//		faidher.setPrision(orthanac);
//		alejandro.setPrision(orthanac);
//		
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

//		Serializador.serializarTodo();
		

		int opcion;
		do {
			System.out.println("\nQue operación desea realizar?");
			System.out.println("1. Movilización reos");
			System.out.println("2. Ver historial de prision");
			System.out.println("3. Reducir condena a reo");
			System.out.println("4. Recrear a reo");
			System.out.println("5. Poner a trabajar a reo");
			System.out.println("6. Salir y guardar\n");
			opcion = (int) readLong();
			
			switch(opcion) {
				case 1: moverReos(prisionerosFA, guardiasFA,orthanac, azkaban, listaBusesOrthanac, jaime); break;
				case 2: verHistorial(azkaban); break;
				case 3: reducirCondena(andres); break;
				case 4: recrearReo(genner,jaime, 10); break;
				case 5: trabajarReo(andres); break;
				case 6:
					Serializador.serializarTodo();
					break;
				
			} 
		}while (opcion != 6);
	
 }
//}
	static void moverReos(ArrayList<Reo> reos,ArrayList<Guardia> guardias,Prision a, Prision p, ArrayList<Bus> buses, Guardia guarCarcel){
		System.out.println(buses.get(0).llevarReos(reos, guardias, a, p));
		for (int j = 0; j < reos.size(); j++) {
			System.out.println(guarCarcel.meterReoCelda(reos.get(j), p.getCeldas().get(j)));
		}
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
			reo = null;
		}
		else if (reo.getTrabajo() != null) {
			//System.out.println(reo.getComportamiento());
			float a = reo.getComportamiento();
			float b = 200;
			float k = reo.getCondena()- a/b;
			reo.setCondena(k);
			System.out.println("Ahora la condena del reo "+reo.getNombre()+" será de "+reo.getCondena()+" años.");
			reo.setComportamiento(0);
			//reo.setHorasTrabajadasTotales(0);
			//Trabajo.renunciarTrabajoReo(reo);
			
		}
		else {
			System.out.println("El reo "+reo.getNombre()+" no tiene trabajo, asignele uno");
		}
	}
	static void recrearReo(Reo reo,Guardia guardia, int horas){
		if (reo.getPatio() instanceof Biblioteca) {
			System.out.println(reo.recrear((Biblioteca)reo.getPatio(), horas));
		}
		else if (reo.getPatio() instanceof Gimnasio) {
			System.out.println(reo.recrear((Gimnasio)reo.getPatio(), horas));
		}
		else {
			System.out.println(guardia.meterReoPatio(reo, reo.getPrision().getBibliotecas().get(0)));
			System.out.println(reo.recrear((Biblioteca)reo.getPatio(), horas));
		}
		
	}
	static void trabajarReo(Reo reo){
			//Trabajo.asignarTrabajoReo(reo, op);
			//System.out.println(reo.trabajar());
		if (reo.getPatio() instanceof Biblioteca) {
			if(reo.getTrabajo() == null || reo.getTrabajo().getTrabajo()!=OpcionTrabajo.Bibliotecario ) {
				Trabajo.asignarTrabajoReo(reo, OpcionTrabajo.Bibliotecario);
			}
				System.out.println(reo.trabajar());
			}
		else if (reo.getPatio() instanceof Gimnasio) {
			if(reo.getTrabajo() == null || reo.getTrabajo().getTrabajo()!=OpcionTrabajo.Profesor ) {
				Trabajo.asignarTrabajoReo(reo, OpcionTrabajo.Profesor);
			}
			System.out.println(reo.trabajar());
			
		}
		else {
			if(reo.getTrabajo() == null || reo.getTrabajo().getTrabajo()!=OpcionTrabajo.Barrendero ) {
				Trabajo.asignarTrabajoReo(reo, OpcionTrabajo.Barrendero);
			}
			System.out.println(reo.trabajar());
		}
			
	}
		
		
}
