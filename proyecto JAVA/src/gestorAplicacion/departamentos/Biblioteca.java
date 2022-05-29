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
	
	public Biblioteca(int capacidad, String nombre, ArrayList<Reo> reos, ArrayList<Guardia> guardias,
			ArrayList<String> historialPatio, int numLibros, String generos, int numEstantes) {
		super(capacidad, nombre, reos, guardias);
		this.numLibros = numLibros;
		this.generos = generos;
		this.numEstantes = numEstantes;
	}
	
	public String ingresarReos(Reo reo) {
		if (getReos().size()+getGuardias().size()+1 <= getCapacidad()) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			getReos().add(reo);
			String str1 = "";
			for (int i = 0; i < getReos().size(); i++) {
				str1+= getReos().get(i).getNombre()+"con código "+getReos().get(i).getCodigo()+", ";
				
			}
			String str2= str1+ dtf.format(LocalDateTime.now())+".";
			ArrayList<String> a = new ArrayList<String>(); 
			super.setHistorialPatio("Ingresaste a los reos"+str2);
			return ("Has ingresado a los reos: "+ str1 +" a estudiar, ojalá no se tiren POO" );	
		}
		else{
			return("Has colocado una cantidad de Reos que excede la capacidad de la biblioteca");
		}
		
		
	}
	public String ingresarGuardias(Guardia guardia) {
		if (getReos().size()+getGuardias().size()+1 <= getCapacidad()) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			getGuardias().add(guardia);
			String str1 = "";
			for (int i = 0; i < getGuardias().size(); i++) {
				str1+= getGuardias().get(i).getNombre()+" con código "+getGuardias().get(i).getCodigo()+", ";
				
			}
			String str2= str1+ dtf.format(LocalDateTime.now())+".";
			ArrayList<String> a = new ArrayList<String>(); 
			super.setHistorialPatio("Ingresaste al "+str2);
			return("Has ingresado a los guardias: "+ str1 +" a cuidar a los reos por si les da un derrame estudiando POO" );	
		}
		else{
			return("Has colocado una cantidad de guardias que excede la capacidad del gimnasio");
		}
	}
	public String laborarReo(Reo reo, int horas) {
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		int k = reo.getCondena();
		int redCondena = reo.getCondena() - horas/24 ;
		reo.setCondena(redCondena);
		String aviso = "Reducción de "+k+"a "+reo.getCondena()+"para el reo con código"+reo.getCodigo()+ dtf2.format(LocalDateTime.now());
		ArrayList<String> a = new ArrayList<String>();
		super.setHistorialPatio(aviso);
		return ("El reo con código "+reo.getCodigo()+"cuyo nombre es"+reo.getNombre()+" ha estudiado POO durante "+horas+
				", por tanto esta pobre alma será recompensada con una reducción de condena.");
		
	}
	
	
	
	
	
	
	
	

	
	

}
