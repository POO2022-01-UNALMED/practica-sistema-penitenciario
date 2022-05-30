package gestorAplicacion.departamentos;


import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import gestorAplicacion.personal.Guardia;
import gestorAplicacion.personal.Reo;

public class Biblioteca extends Patio{
	private Prision prision;
	
	public Biblioteca(String nombre, Prision prision) {
		super(100, nombre, new ArrayList<Reo>(), new ArrayList<Guardia>());
		this.prision = prision;
		super.addHistorialPatio("Has creado una biblioteca cuyo nombre es "+ nombre);

	}
	
	public String ingresarReos(Reo reo) {
		if (getReos().size()+getGuardias().size()+1 <= getCapacidad()) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			getReos().add(reo);
			String str1 = reo.getNombre();
			super.addHistorialPatio("Has ingresado al reo: "+ str1 +" a estudiar en la biblioteca: "+this.getNombre()+", ojala no se tiren POO. "+ dtf.format(LocalDateTime.now())+"\n");
			this.prision.addHistoriaPrision(getHistorialPatio().get(getHistorialPatio().size()-1));
			return ("Has ingresado al reo: "+ str1 +" a estudiar, ojala no se tiren POO" );	
		}
		else{
			return("Has colocado una cantidad de Reos que excede la capacidad de la biblioteca");
		}
		
		
	}
	public String sacarReos(Reo reo) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		getReos().remove(getReos().indexOf(reo));
		super.addHistorialPatio("Has sacado al reo "+ reo.getNombre()+" con codigo "+reo.getCodigo()+" de la biblioteca con nombre "+this.getNombre()+", "+ dtf.format(LocalDateTime.now())+"\n");
		this.prision.addHistoriaPrision(getHistorialPatio().get(getHistorialPatio().size()-1));
		return "Has sacado al reo "+ reo.getNombre()+" con codigo "+reo.getCodigo()+" de la biblioteca con nombre "+this.getNombre();
	}
	public String ingresarGuardias(Guardia guardia) {
		if (getReos().size()+getGuardias().size()+1 <= getCapacidad()) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			getGuardias().add(guardia);
			String str1 = guardia.getNombre();
			super.addHistorialPatio("Has ingresado al guardia: "+ str1 +" a cuidar a los reos por si les da un derrame estudiando POO"+ dtf.format(LocalDateTime.now())+"\n");
			this.prision.addHistoriaPrision(getHistorialPatio().get(getHistorialPatio().size()-1));
			return("Has ingresado al guardia: "+ str1 +" a cuidar a los reos por si les da un derrame estudiando POO" );	
		}
		else{
			return("Has colocado una cantidad de guardias que excede la capacidad del biblioteca");
		}
	}
	public String sacarGuardias(Guardia guardia) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		getGuardias().remove(getGuardias().indexOf(guardia));
		super.addHistorialPatio("Has sacado al guardia "+ guardia.getNombre()+" con codigo "+guardia.getCodigo()+" de la biblioteca con nombre "+this.getNombre()+", "+ dtf.format(LocalDateTime.now())+"\n");
		this.prision.addHistoriaPrision(getHistorialPatio().get(getHistorialPatio().size()-1));
		return "Has sacado al guardia "+ guardia.getNombre()+" con codigo "+guardia.getCodigo()+" de la biblioteca con nombre "+this.getNombre();
	}
	public String laborarReo(Reo reo, int horas) {
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		int k = reo.getCondena();
		int redCondena = reo.getCondena() - horas/24 ;
		reo.setCondena(redCondena);
		String aviso = "Reducción de "+k+" a "+reo.getCondena()+"para el reo con código "+reo.getCodigo()+" "+ dtf2.format(LocalDateTime.now())+"\n";
		super.addHistorialPatio(aviso);
		this.prision.addHistoriaPrision(getHistorialPatio().get(getHistorialPatio().size()-1));
		return ("El reo con codigo "+reo.getCodigo()+"cuyo nombre es"+reo.getNombre()+" ha estudiado POO durante "+horas+
				", por tanto esta pobre alma será recompensada con una reduccion de condena.");
		
	}

	
	

	
	

}
