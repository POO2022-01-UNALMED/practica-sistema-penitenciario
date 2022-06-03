package gestorAplicacion.departamentos;

import java.io.Serializable;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import gestorAplicacion.personal.Guardia;
import gestorAplicacion.personal.Reo;

public class Biblioteca extends Patio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Prision prision;
	private static ArrayList<Biblioteca> bibliotecasTotales = new ArrayList<Biblioteca>();
	
	//////////Constructores
	
	public Biblioteca(String nombre, Prision prision) {
		super(100, nombre, new ArrayList<Reo>(), new ArrayList<Guardia>());
		this.prision = prision;
		super.addHistorialPatio("Has creado una biblioteca cuyo nombre es "+ nombre);
		prision.getBibliotecas().add(this);
		bibliotecasTotales.add(this);

	}
	
	/////////////metodos
	
	//// este metodo ingresa reos a una instancia de la biblioteca y en caso de que esta cantidad exceda la capacidad de la biblioteca entonces nos dará una alerta
	public String ingresarReos(Reo reo) {
		if (getReos().size()+getGuardias().size()+1 <= getCapacidad()) {
			reo.setPatio(this);
			getReos().add(reo);
			
			
			///acá se añade al historial este movimiento
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				String str1 = reo.getNombre();
				super.addHistorialPatio("Has ingresado al reo: "+ str1 +" a estudiar en la biblioteca: "+this.getNombre()+", ojala no se tiren POO. La cantidad actual de reos en la biblioteca "+this.getNombre()+" es de "+this.getCantidadReos()+" "+ dtf.format(LocalDateTime.now())+"\n");
				this.prision.addHistoriaPrision(getHistorialPatio().get(getHistorialPatio().size()-1));
			return ("Has ingresado al reo: "+ str1 +" a estudiar, ojala no se tiren POO. La cantidad actual de reos en la biblioteca "+this.getNombre()+" es de "+this.getCantidadReos() );	
		}
		else{
			return("Has colocado una cantidad de Reos que excede la capacidad de la biblioteca");
		}
		
		
	}
	
	//// este metodo nos permite sacar un reo de una instancia de bibioteca
	public String sacarReos(Reo reo) {
		getReos().remove(getReos().indexOf(reo));
		//// aca ingresamos al historial el movimiento en cuestión
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			super.addHistorialPatio("Has sacado al reo "+ reo.getNombre()+" con codigo "+reo.getCodigo()+" de la biblioteca con nombre "+this.getNombre()+", "+ dtf.format(LocalDateTime.now())+"\n");
			this.prision.addHistoriaPrision(getHistorialPatio().get(getHistorialPatio().size()-1));
		return "Has sacado al reo "+ reo.getNombre()+" con codigo "+reo.getCodigo()+" de la biblioteca con nombre "+this.getNombre();
	}
	
	///// en este método ingresamos guardias a esta biblioteca, en caso de que este numero exceda la cantidad máxima de personas existentes en la biblioteca entonces nos dará una alerta
	public String ingresarGuardias(Guardia guardia) {
		if (getReos().size()+getGuardias().size()+1 <= getCapacidad()) {
			getGuardias().add(guardia);
			String str1 = guardia.getNombre();
			//// aca ingresaos al historial este movimiento
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				super.addHistorialPatio("Has ingresado al guardia: "+ str1 +" a cuidar a los reos por si les da un derrame estudiando POO. El numero actual de guardias en "+this.getNombre()+" es de "+this.getCantidadGuardias()+" "+ dtf.format(LocalDateTime.now())+"\n");
				this.prision.addHistoriaPrision(getHistorialPatio().get(getHistorialPatio().size()-1));
			return("Has ingresado al guardia: "+ str1 +" a cuidar a los reos por si les da un derrame estudiando POO. La cantidad actual de guardias en la biblioteca "+ this.getNombre()+" es de "+this.getCantidadGuardias());	
		}
		else{
			return("Has colocado una cantidad de guardias que excede la capacidad del biblioteca");
		}
	}
	
	
	//// en este modelo sacamos a los guardias de una instancia dde biblioteca 
	public String sacarGuardias(Guardia guardia) {
		getGuardias().remove(getGuardias().indexOf(guardia));
		/// ingresa al historial de biblioteca este movimiento
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			super.addHistorialPatio("Has sacado al guardia "+ guardia.getNombre()+" con codigo "+guardia.getCodigo()+" de la biblioteca con nombre "+this.getNombre()+", "+ dtf.format(LocalDateTime.now())+"\n");
			this.prision.addHistoriaPrision(getHistorialPatio().get(getHistorialPatio().size()-1));
		return "Has sacado al guardia "+ guardia.getNombre()+" con codigo "+guardia.getCodigo()+" de la biblioteca con nombre "+this.getNombre();
	}
	////////// acá tenemos un método que le asignará una labor al reo en la biblioteca, esta labor permitirá que el reo pueda rebajar su condena
	
	public String laborarReo(Reo reo, int horas) {
		float k = reo.getCondena();
		float redCondena = 24*365*reo.getCondena() - horas/24 ;
		reo.setCondena(redCondena);
		/// acá ingresamos este movimiento al historial de la instancia de biblioteca
			DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			String aviso = "Reducción de "+k+" a "+reo.getCondena()+"para el reo con código "+reo.getCodigo()+" "+ dtf2.format(LocalDateTime.now())+"\n";
			super.addHistorialPatio(aviso);
			this.prision.addHistoriaPrision(getHistorialPatio().get(getHistorialPatio().size()-1));
		return ("El reo con codigo "+reo.getCodigo()+" cuyo nombre es "+reo.getNombre()+" ha estudiado POO durante "+horas+
				" horas, por tanto esta pobre alma será recompensada con una reduccion de condena.");
		
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

	public static ArrayList<Biblioteca> getBibliotecasTotales() {
		return bibliotecasTotales;
	}

	public static void setBibliotecasTotales(ArrayList<Biblioteca> bibliotecasTotales) {
		Biblioteca.bibliotecasTotales = bibliotecasTotales;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
