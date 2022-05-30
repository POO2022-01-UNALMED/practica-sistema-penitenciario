package gestorAplicacion.departamentos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import gestorAplicacion.personal.Guardia;
import gestorAplicacion.personal.Reo;

public class Gimnasio extends Patio{
	
	private Prision prision;
	public Gimnasio(String nombre, Prision prision) {
		super(20, nombre, new ArrayList<Reo>(), new ArrayList<Guardia>());
		this.prision = prision;
		super.addHistorialPatio("Has creado un gimnasio cuyo nombre es "+ nombre);
	}

	public String ingresarReos(Reo reo) {
		if (getReos().size()+getGuardias().size()+1 <= getCapacidad()) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			getReos().add(reo);
			String str1 = reo.getNombre();
			super.addHistorialPatio("Has ingresado al reo: "+ str1 +" a ejercitarsen, ojala no se vuelvan mas fuertes que los guardias y hagan un motin, " + dtf.format(LocalDateTime.now())+"\n");
			this.prision.addHistoriaPrision(getHistorialPatio().get(getHistorialPatio().size()-1));
			return ("Has ingresado al reo: "+ str1 +" a ejercitarsen, ojala no se vuelvan mas fuertes que los guardias y hagan un motin");	
		}
		else{
			return("Has colocado una cantidad de Reos que excede la capacidad de la biblioteca");
		}
	}
	public String sacarReos(Reo reo) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		getReos().remove(getReos().indexOf(reo));
		super.addHistorialPatio("Has sacado al reo "+ reo.getNombre()+" con codigo "+reo.getCodigo()+" del gimnasio con nombre "+this.getNombre()+", "+ dtf.format(LocalDateTime.now())+"\n");
		this.prision.addHistoriaPrision(getHistorialPatio().get(getHistorialPatio().size()-1));
		return "Has sacado al reo "+ reo.getNombre()+" con codigo "+reo.getCodigo()+" del gimnasio con nombre "+this.getNombre();
	}
	public String ingresarGuardias(Guardia guardia) {
		if (getReos().size()+getGuardias().size()+1 <= getCapacidad()) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			getGuardias().add(guardia);
			String str1 = guardia.getNombre();
			super.addHistorialPatio("Has ingresado al guardia: "+ str1 +" a darles trato humanitario a los reos por si intentan hacer un motin"+ dtf.format(LocalDateTime.now())+"\n");
			this.prision.addHistoriaPrision(getHistorialPatio().get(getHistorialPatio().size()-1));
			return("Has ingresado al guardia: "+ str1 +" a darles trato humanitario a los reos por si intentan hacer un motin");	
		}
		else{
			return("Has colocado una cantidad de guardias que excede la capacidad del gimnasio");
		}
	}
	public String sacarGuardias(Guardia guardia) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		getGuardias().remove(getGuardias().indexOf(guardia));
		super.addHistorialPatio("Has sacado al guardia "+ guardia.getNombre()+" con codigo "+guardia.getCodigo()+" del gimnasio con nombre "+this.getNombre()+", "+ dtf.format(LocalDateTime.now())+"\n");
		this.prision.addHistoriaPrision(getHistorialPatio().get(getHistorialPatio().size()-1));
		return "Has sacado al guardia "+ guardia.getNombre()+" con codigo "+guardia.getCodigo()+" del gimnasio con nombre "+this.getNombre();
	}
	
	public String laborarReo(Reo reo, int horas) {
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		int k = reo.getCondena();
		int redCondena = reo.getCondena() - (1/2)*horas/24 ;
		reo.setCondena(redCondena);
		String aviso = "Reducción de "+k+" a "+reo.getCondena()+"para el reo con código "+reo.getCodigo()+" "+ dtf2.format(LocalDateTime.now())+"\n";
		super.addHistorialPatio(aviso);
		this.prision.addHistoriaPrision(getHistorialPatio().get(getHistorialPatio().size()-1));
		return ("El reo con codigo "+reo.getCodigo()+"cuyo nombre es"+reo.getNombre()+" ha levantado pesas durante "+horas+
				" horas, por tanto se le rebaja por cada dos horas de ejercicio una hora de condena.");
		
	}
	
	public int getCantidadReos() {
		return getReos().size();
	}
	public int getCantidadGuardias() {
		return getGuardias().size();
	}
	
	

}
