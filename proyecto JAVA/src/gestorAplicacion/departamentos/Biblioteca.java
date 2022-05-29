package gestorAplicacion.departamentos;


import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import gestorAplicacion.personal.Guardia;
import gestorAplicacion.personal.Reo;

public class Biblioteca extends Patio{
	
	public Biblioteca(String nombre) {
		super(100, nombre, new ArrayList<Reo>(), new ArrayList<Guardia>());

	}
	
	public String ingresarReos(Reo reo) {
		if (getReos().size()+getGuardias().size()+1 <= getCapacidad()) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			getReos().add(reo);
			String str1 = "";
			for (int i = 0; i < getReos().size(); i++) {
				str1+= getReos().get(i).getNombre()+"con codigo "+getReos().get(i).getCodigo()+", ";
				
			}
			String str2= str1+ dtf.format(LocalDateTime.now())+".";
			super.addHistorialPatio("Ingresaste a los reos"+str2);
			return ("Has ingresado a los reos: "+ str1 +" a estudiar, ojala no se tiren POO" );	
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
				str1+= getGuardias().get(i).getNombre()+" con codigo "+getGuardias().get(i).getCodigo()+", ";
				
			}
			String str2= str1+ dtf.format(LocalDateTime.now())+".";
			super.addHistorialPatio("Ingresaste al "+str2);
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
		super.addHistorialPatio(aviso);
		return ("El reo con codigo "+reo.getCodigo()+"cuyo nombre es"+reo.getNombre()+" ha estudiado POO durante "+horas+
				", por tanto esta pobre alma será recompensada con una reduccion de condena.");
		
	}
	
	
	
	
	
	
	
	

	
	

}
