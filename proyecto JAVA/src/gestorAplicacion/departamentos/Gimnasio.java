package gestorAplicacion.departamentos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import gestorAplicacion.personal.Guardia;
import gestorAplicacion.personal.Reo;

public class Gimnasio extends Patio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Prision prision;
	private static ArrayList<Gimnasio> gimnasiosTotales = new ArrayList<Gimnasio>();
	
	////////////Constructores
	
	public Gimnasio(String nombre, Prision prision) {
		super(20, nombre, new ArrayList<Reo>(), new ArrayList<Guardia>());
		this.prision = prision;
		super.addHistorialPatio("Has creado un gimnasio cuyo nombre es "+ nombre);
		prision.getGimnasios().add(this);
		gimnasiosTotales.add(this);
	}

	/////////Metodos
	
	////este metodo ingresa reos a una instancia del gimnasio y en caso de que esta cantidad exceda la capacidad del gimnasio entonces nos dará una alerta
	public String ingresarReos(Reo reo) {
		if (getReos().size()+getGuardias().size()+1 <= getCapacidad()) {
			getReos().add(reo);
			//// aca ingresamos este movimiento al historial del gimnaasio
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				String str1 = reo.getNombre();
				super.addHistorialPatio("Has ingresado al reo: "+ str1 +", de código: "+reo.getCodigo()+", a ejercitarse, ojala no se vuelvan mas fuertes que los guardias y hagan un motin. El número actual de reos en el gimnasio "+this.getNombre()+" es de "+this.getCantidadReos() +" "+ dtf.format(LocalDateTime.now())+"\n");
				this.prision.addHistoriaPrision(getHistorialPatio().get(getHistorialPatio().size()-1));
			return ("Has ingresado al reo: "+ str1 +", de código: "+reo.getCodigo()+", a ejercitarse, ojala no se vuelvan mas fuertes que los guardias y hagan un motin");	
		}
		else{
			return("Has colocado una cantidad de Reos que excede la capacidad del gimnasio");
		}
	}
	
	///// este metodo nos permite sacar un reo de una instancia de gimnasio
	public String sacarReos(Reo reo) {
		getReos().remove(getReos().indexOf(reo));
		//// aca ingresamos este movimiento al historial del gimnasio
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			super.addHistorialPatio("Has sacado al reo "+ reo.getNombre()+" con codigo "+reo.getCodigo()+" del gimnasio con nombre "+this.getNombre()+", "+ dtf.format(LocalDateTime.now())+"\n");
			this.prision.addHistoriaPrision(getHistorialPatio().get(getHistorialPatio().size()-1));
		return "Has sacado al reo "+ reo.getNombre()+" con codigo "+reo.getCodigo()+" del gimnasio con nombre "+this.getNombre();
	}
	
	//// en este método ingresamos guardias a este gimnasio, en caso de que este numero exceda la cantidad máxima de personas existentes en el gimnasio entonces nos dará una alerta
	public String ingresarGuardias(Guardia guardia) {
		if (getReos().size()+getGuardias().size()+1 <= getCapacidad()) {
			getGuardias().add(guardia);
			///// aca registramos este movimiento en el historial de gimansio 
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				String str1 = guardia.getNombre();
				super.addHistorialPatio("Has ingresado al guardia: "+ str1 +" a darles trato humanitario a los reos por si intentan hacer un motin. El numero actual de guardias en "+this.getNombre()+" es de "+this.getCantidadGuardias()+" "+ dtf.format(LocalDateTime.now())+"\n");
				this.prision.addHistoriaPrision(getHistorialPatio().get(getHistorialPatio().size()-1));
			return("Has ingresado al guardia: "+ str1 +" a darles trato humanitario a los reos por si intentan hacer un motin");	
		}
		else{
			return("Has colocado una cantidad de guardias que excede la capacidad del gimnasio");
		}
	}
	
	///// en este metodo sacamos a los reos del gimnasio 
	public String sacarGuardias(Guardia guardia) {
		getGuardias().remove(getGuardias().indexOf(guardia));
		//// ingresamos este movimiento en el historial de gimnasio 
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			super.addHistorialPatio("Has sacado al guardia "+ guardia.getNombre()+" con codigo "+guardia.getCodigo()+" del gimnasio con nombre "+this.getNombre()+", "+ dtf.format(LocalDateTime.now())+"\n");
			this.prision.addHistoriaPrision(getHistorialPatio().get(getHistorialPatio().size()-1));
		return "Has sacado al guardia "+ guardia.getNombre()+" con codigo "+guardia.getCodigo()+" del gimnasio con nombre "+this.getNombre();
	}
	
	//// este metodo permite darle una labor en el gimansio al reo, esta labor le posibilitara al reo reducir su condena
	public String laborarReo(Reo reo, int horas) {
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		float k = reo.getCondena();
		float redCondena = 24*365*reo.getCondena() - (1/2)*horas/24 ;
		reo.setCondena(redCondena);
		String aviso = "Reducción de "+k+" a "+reo.getCondena()+"para el reo con código "+reo.getCodigo()+" "+ dtf2.format(LocalDateTime.now())+"\n";
		super.addHistorialPatio(aviso);
		this.prision.addHistoriaPrision(getHistorialPatio().get(getHistorialPatio().size()-1));
		return ("El reo con codigo "+reo.getCodigo()+" cuyo nombre es "+reo.getNombre()+" ha levantado pesas durante "+horas+
				" horas, por tanto se le rebaja por cada dos horas de ejercicio una hora de condena.");
		
	}
	
	/////////setters y getters
	
	public int getCantidadReos() {
		return getReos().size();
	}
	public int getCantidadGuardias() {
		return getGuardias().size();
	}

	public Prision getPrision() {
		return prision;
	}

	public void setPrision(Prision prision) {
		this.prision = prision;
	}

	public static ArrayList<Gimnasio> getGimnasiosTotales() {
		return gimnasiosTotales;
	}

	public static void setGimnasiosTotales(ArrayList<Gimnasio> gimnasiosTotales) {
		Gimnasio.gimnasiosTotales = gimnasiosTotales;
	}

}
