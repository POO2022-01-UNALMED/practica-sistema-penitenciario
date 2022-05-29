package gestorAplicacion.departamentos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import gestorAplicacion.personal.Guardia;
import gestorAplicacion.personal.Reo;

public class Gimnasio extends Patio{
	int numMancuernas;
	
	public Gimnasio(String nombre) {
		this(100, nombre, new ArrayList<Reo>(), new ArrayList<Guardia>(), 200);
		
	}

	public Gimnasio(int capacidad, String nombre, ArrayList<Reo> reos, ArrayList<Guardia> guardias, int numMancuernas) {
		super(capacidad, nombre, reos, guardias);
		this.numMancuernas = numMancuernas;
	}

	public int getNumMancuernas() {
		return numMancuernas;
	}

	public void setNumMancuernas(int numMancuernas) {
		this.numMancuernas = numMancuernas;
	}
	

	public String ingresarReos(Reo reo) {
		if (getReos().size()+getGuardias().size()+1 <= getCapacidad()) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			getReos().add(reo);
			String str1 = "";
			for (int i = 0; i < getReos().size(); i++) {
				str1+= getReos().get(i).getNombre()+" con código "+getReos().get(i).getCodigo()+", ";
				
			}
			String str2= str1+ dtf.format(LocalDateTime.now())+".";
			ArrayList<String> a = new ArrayList<String>(); 
			super.setHistorialPatio("Ingresaste a los reos"+str2);
			return("Has ingresado a los reos: "+ str1 +" a ejercitarsen, ojalá no se vuelvan más fuertes que los guardias y hagan un motin" );	
		}
		else {
			return("Has colocado una cantidad de Reos que excede la capacidad del gimnasio");
		}
	}
	public String ingresarGuardias(Guardia guardia) {
		if (getReos().size()+getGuardias().size()+1 <= getCapacidad()) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			getGuardias().add(guardia);
			String str1 = "";
			for (int i = 0; i < getGuardias().size(); i++) {
				str1+= getGuardias().get(i).getRango()+getGuardias().get(i).getNombre()+" con código "+getGuardias().get(i).getCodigo()+", ";
				
			}
			String str2= str1+ dtf.format(LocalDateTime.now())+".";
			ArrayList<String> a = new ArrayList<String>(); 
			super.setHistorialPatio("Ingresaste al "+str2);
			return("Has ingresado a los guardias: "+ str1 +" a darles trato humanitario a los reos por si intentan hacer un motín" );	
		}
		else {
			return("Has colocado una cantidad de guardias que excede la capacidad del gimnasio");
		}
	}
	public String laborarReo(Reo reo, int horas) {
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		int k = reo.getCondena();
		int redCondena = reo.getCondena() - (1/2)*horas/24 ;
		reo.setCondena(redCondena);
		String aviso = "Reducción de "+k+"a "+reo.getCondena()+"para el reo con código"+reo.getCodigo()+ dtf2.format(LocalDateTime.now());
		ArrayList<String> a = new ArrayList<String>();
		super.setHistorialPatio(aviso);
		return ("El reo con código "+reo.getCodigo()+"cuyo nombre es"+reo.getNombre()+" ha levantado pesas durante "+horas+
				" horas, por tanto se le rebaja por cada dos horas de ejercicio una hora de condena.");
	}
	
	

}
