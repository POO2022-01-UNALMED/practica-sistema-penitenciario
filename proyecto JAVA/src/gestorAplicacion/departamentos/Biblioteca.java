package gestorAplicacion.departamentos;

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import gestorAplicacion.personal.Guardia;
import gestorAplicacion.personal.Reo;

public class Biblioteca extends Patio{
	int numLibros;
	String generos;
	int numEstantes;
	
	public Biblioteca(int capacidad, String nombre, int prueba, ArrayList<Reo> reos, ArrayList<Guardia> guardias,
			ArrayList<String> historialPatio, int numLibros, String generos, int numEstantes) {
		super(capacidad, nombre, prueba, reos, guardias, historialPatio);
		this.numLibros = numLibros;
		this.generos = generos;
		this.numEstantes = numEstantes;
	}
	
	public void ingresarReos(ArrayList<Reo> reos) {
		if (reos.size() <= getCapacidad()) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			setReos(reos);
			String str1 = "Se ha ingresado los reos: ";
			for (int i = 0; i < reos.size(); i++) {
				str1+= reos.get(i).getNombre()+"con código "+reos.get(i).getCodigo()+", ";
				
			}
			String str2= str1+ dtf.format(LocalDateTime.now())+".";
			ArrayList<String> a = new ArrayList<String>(); 
			a.add(str2);
			super.setHistorialPatio(a);
			System.out.println("Has ingresado a los reos"+ str1 +" a estudiar, ojalá no se tiren POO" );	
		}
		else {
			System.out.println("Has colocado una cantidad de Reos que excede la capacidad de la biblioteca");
		}
		
		
	}
	public void laborarReo(Reo reo, int horas) {
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		int k = reo.getCondena();
		int redCondena = reo.getCondena() - horas/24 ;
		reo.setCondena(redCondena);
		System.out.println("El reo con código "+reo.getCodigo()+"cuyo nombre es"+reo.getNombre()+" ha estudiado POO durante "+horas+
				", por tanto esta pobre alma será recompensada con una reducción de condena.");
		String aviso = "Reducción de "+k+"a "+reo.getCondena()+"para el reo con código"+reo.getCodigo()+ dtf2.format(LocalDateTime.now());
		ArrayList<String> a = new ArrayList<String>();
		a.add(aviso);
		super.setHistorialPatio(a);
	}
	
	
	
	
	
	
	
	

	
	

}
