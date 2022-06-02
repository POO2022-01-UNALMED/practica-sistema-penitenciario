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
		
		
		
		/////////////////////////////PRISIONES POR DEFECTO//////////////////////////////////////
		Prision azkaban = new Prision("Azkaban");
		Prision torreOscura = new Prision("Torre Oscura");
		
		///////////////////////////////REOS POR DEFECTO//////////////////////////////////////////////
		Reo genner = new Reo("Genner",1001, true, 10);
		Reo andres = new Reo("Andres",1002, true, 10);
		Reo faidher= new Reo("Faidher",1003, true, 10);
		Reo alejandro = new Reo("Alejandro",1001, true, 10);
		
		//////////////////////////////GUARDIAS POR DEFECTO//////////////////////////////////////////
		Guardia jaime = new Guardia("Jaime", 2001, azkaban, Rango.oficial);
		Guardia david = new Guardia("David", 2003, azkaban, Rango.carcelero);
		Guardia julian = new Guardia("Julian", 2002, torreOscura, Rango.oficial);
		Guardia oswaldo = new Guardia("Oswaldo", 2004, torreOscura, Rango.carcelero);
		//Guardia aprendiz = new Guardia("Aprendiz", 2005, torreOscura, Rango.bachiller);
		
		//////////////////////////////LISTADO DE BUSES POR DEFECTO/////////////////////////////////
		ArrayList<Bus> listaBusesAzkaban = new ArrayList<Bus>();
		for (int i = 0; i < 6; i++) {
			listaBusesAzkaban.add(new Bus(azkaban));
		}
		ArrayList<Bus> listaBusesTorreOscura = new ArrayList<Bus>();
		for (int i = 0; i < 6; i++) {
			listaBusesTorreOscura.add(new Bus(torreOscura));
		}
		/////////////////////////////ASIGNACION DE REOS A PRISIONES/////////////////////////
		genner.setPrision(azkaban);
		andres.setPrision(azkaban);
		faidher.setPrision(torreOscura);
		alejandro.setPrision(torreOscura);
		
		//azkaban.getBibliotecas().get(0).ingresarReos(genner);
		//azkaban.getGimnasios().get(0).ingresarReos(andres);
		jaime.meterReoPatio(andres, azkaban.getGimnasios().get(0));
		jaime.meterReoPatio(genner, azkaban.getBibliotecas().get(0));
		
		ArrayList<Reo> prisionerosFA = new ArrayList<Reo>(); 
		prisionerosFA.add(alejandro);
		prisionerosFA.add(faidher);
		
		ArrayList<Guardia> guardiasFA = new ArrayList<Guardia>();
		//guardiasFA.add(aprendiz);
		guardiasFA.add(oswaldo);
		guardiasFA.add(julian);
		
//		System.out.println(Prision.getPrisiones().get(0).getNombre());
//		System.out.println(Prision.getPrisiones().get(1).getNombre());
//		System.out.println(Prision.getPrisionesCreadas());
		//Serializador.serializarTodo();
		
	//}
	//}
//}
//}
		Deserializador.deserializarTodo();
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
				case 1: moverReos(prisionerosFA, guardiasFA,torreOscura, azkaban, listaBusesTorreOscura, jaime); break;
				case 2: verHistorial(azkaban); break;
				case 3: reducirCondena(andres); break;
				case 4: recrearReo(genner,azkaban.getBibliotecas().get(0), 10); break;
				case 5: trabajarReo(andres, OpcionTrabajo.Barrendero); break;
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
		}
		else if (reo.getTrabajo() != null) {
			System.out.println(reo.getComportamiento());
			float a = reo.getComportamiento();
			float b = 200;
			float k = reo.getCondena()- a/b;
			reo.setCondena(k);
			System.out.println("Ahora la condena del reo "+reo.getNombre()+" será "+reo.getCondena());
			reo.setHorasTrabajadasTotales(0);
			Trabajo.renunciarTrabajoReo(reo);
			
		}
		else {
			System.out.println("El reo "+reo.getNombre()+" no tiene trabajo, asignele uno");
		}
	}
	static void recrearReo(Reo reo,Biblioteca biblioteca, int horas){
		System.out.println(reo.recrear(biblioteca, 10));
	}
	static void recrearReo(Reo reo,Gimnasio gimnasio, int horas){
		System.out.println(reo.recrear(gimnasio, 10));
	}
	static void trabajarReo(Reo reo, OpcionTrabajo op){
			Trabajo.asignarTrabajoReo(reo, op);
			System.out.println(reo.trabajar());
			
		}
		
		
	}
