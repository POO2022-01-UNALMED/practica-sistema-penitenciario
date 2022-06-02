package gestorAplicacion.personal;

import java.io.Serializable;
//import gestorAplicacion.personal.*;
//import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
//import gestorAplicacion.bienes.*;
import gestorAplicacion.departamentos.*;

public class Guardia implements Persona, Serializable{

	private static final long serialVersionUID = 1L;
	private final String nombre;
	private final int codigo;
	private Prision prision;
	private Rango rango=Rango.bachiller;
	//private static ArrayList<String> historialGuardias = new ArrayList<String>();
	private static ArrayList<Guardia> guardiasTotales = new ArrayList<Guardia>();
	
	//////////Constructores
	
	public Guardia(String nombre, int codigo) {
		
		this.nombre = nombre;
		this.codigo = codigo;
		guardiasTotales.add(this);
		
	}
	
	public Guardia(String nombre, int codigo, Rango rango) {
		
		this(nombre, codigo);
		this.rango = rango;
		prision.getGuardias().add(this);

	}

	public Guardia(String nombre, int codigo, Prision prision) {
		
		this(nombre, codigo);
		this.prision = prision;
		prision.getGuardias().add(this);
		
		//A�ade al historial
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
		prision.addHistorialGuardias("El bachiller "+nombre+", con codigo: "+codigo+", ha sido trasladado a la prision: "+prision.getNombre()+Tiempo);
		
	}
	

	public Guardia(String nombre, int codigo, Prision prision, Rango rango) {
		
		this(nombre, codigo);
		this.prision = prision;
		this.rango = rango;
		prision.getGuardias().add(this);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
		prision.addHistorialGuardias("El "+rango.getRango()+" "+nombre+", con codigo: "+codigo+", ha sido trasladado a la prision: "+prision.getNombre()+Tiempo);
		
	}


	//////////Metodos
	
	public void promocionarGuardia() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
		
		if(this.getRango()==Rango.bachiller) {
			this.setRango(Rango.carcelero);
			
			prision.addHistorialGuardias("El guardia "+this.nombre+", con codigo: "+this.codigo+" ha sido promocionado a: "+this.rango.getRango()+Tiempo);
		}
		else if(this.getRango()==Rango.carcelero) {
			this.setRango(Rango.oficial);
			
			prision.addHistorialGuardias("El guardia "+this.nombre+", con codigo: "+this.codigo+" ha sido promocionado a: "+this.rango.getRango()+Tiempo);
		}
		else {
			prision.addHistorialGuardias("El guardia "+this.nombre+" no pudo ser promocionado"+Tiempo);
			return;}
		
		
	}
	
	public String meterReoCelda(Reo reo, Celda celda) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
		
		if (this.rango == Rango.bachiller) {
			
			prision.addHistorialGuardias("El bachiller "+this.nombre+", de c�digo: "+this.codigo+", ha intentado meter el reo de codigo: "+reo.getCodigo()+" a la celda: "+celda.getNumCelda()+", pero no tiene los permisos para realizar esta accion"+Tiempo);
			return "El bachiller "+this.nombre+", de codigo: "+this.codigo+", ha intentado meter el reo de codigo: "+reo.getCodigo()+" a la celda: "+celda.getNumCelda()+", pero no tiene los permisos para realizar esta accion"+Tiempo;
		}
		else if(reo.getCelda() != null) {
			prision.addHistorialGuardias("El "+this.rango.getRango()+" "+this.nombre+", de codigo: "+this.codigo+", ha intentado meter al reo de codigo: "+reo.getCodigo()+" a la celda: "+celda.getNumCelda()+", pero este ya esta en una celda"+Tiempo);
			return "El "+this.rango.getRango()+" "+this.nombre+", de codigo: "+this.codigo+", ha intentado meter al reo de codigo: "+reo.getCodigo()+" a la celda: "+celda.getNumCelda()+", pero este ya esta en una celda"+Tiempo;
		}
		else if(celda.getReosPertenecientes().size()+1 <= 2){
			//celda.asignarReo(reo);
			reo.setCelda(celda);
            
			prision.addHistorialGuardias("El reo de codigo: "+reo.getCodigo()+", ha sido ingresado a la celda numero "+celda.getNumCelda()+" por el "+this.rango.getRango()+" "+this.nombre+", de codigo: "+this.codigo+Tiempo);	
			return "El reo de codigo: "+reo.getCodigo()+", ha sido ingresado a la celda numero "+celda.getNumCelda()+" por el "+this.rango.getRango()+" "+this.nombre+", de codigo: "+this.codigo+Tiempo;
		}
		else {
			prision.addHistorialGuardias("El reo de codigo: "+reo.getCodigo()+", no puede ser ingresado a la celda numero "+celda.getNumCelda()+" por el "+this.rango.getRango()+" "+this.nombre+", de codigo: "+this.codigo+", pues esta llena"+Tiempo);	
			return "El reo de codigo: "+reo.getCodigo()+", no puede ser ingresado a la celda numero "+celda.getNumCelda()+" por el "+this.rango.getRango()+" "+this.nombre+", de codigo: "+this.codigo+", pues esta llena"+Tiempo;
		}
				
	}

	public void sacarReoCelda(Reo reo) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
		
		if (this.rango == Rango.bachiller) {
			prision.addHistorialGuardias("El bachiller "+this.nombre+" ha intentado sacar el reo de codigo: "+reo.getCodigo()+" de una celda pero no tiene los permisos para realizar esta accion"+Tiempo);
		}
		else if(reo.getCelda() == null) {
			prision.addHistorialGuardias("El "+this.rango.getRango()+" "+this.nombre+", de codigo: "+this.codigo+" ha intentado sacar al reo de c�digo: "+reo.getCodigo()+" de su celda pero este no tiene una asignada en el momento"+Tiempo);
		}
		else{
			reo.getCelda().sacarReo(reo);
			reo.setCelda(null);
			prision.addHistorialGuardias("El "+this.rango.getRango()+" "+this.nombre+", de codigo: "+this.codigo+" ha sacado al reo de c�digo: "+reo.getCodigo()+" de su celda"+Tiempo);
		}
	}
	
	public String meterReoPatio(Reo reo, Biblioteca patio) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
		
		if(reo.getPatio() !=null) {
			prision.addHistorialGuardias("El "+this.rango.getRango()+" "+this.nombre+", de codigo: "+this.codigo+" ha intentado meter al reo de codigo: "+reo.getCodigo()+" a la biblioteca: "+reo.getPatio().getNombre()+", pero este ya esta en un patio "+Tiempo);
			prision.addHistorialReos("El reo de codigo: "+reo.getCodigo()+" lo han intentado meter a la biblioteca "+reo.getPatio().getNombre()+" por el "+this.rango.getRango()+" "+this.nombre+" de codigo "+this.codigo+" pero este ya esta en un patio "+Tiempo);
			return "El reo "+reo.getNombre()+" ya tiene una biblioteca asignada";
		}
		else if(patio.getReos().size()+1 <= patio.getCapacidad()){
				patio.ingresarReos(reo);
				reo.setPatio(patio);
				prision.addHistorialGuardias("El "+this.rango.getRango()+" "+this.nombre+", de codigo: "+this.codigo+" ha movido al reo de codigo: "+reo.getCodigo()+" a la biblioteca: "+reo.getPatio().getNombre()+Tiempo);
				prision.addHistorialReos("El reo de codigo: "+reo.getCodigo()+" lo ha movido a la biblioteca "+reo.getPatio().getNombre()+" por el "+this.rango.getRango()+" "+this.nombre+" de codigo "+this.codigo+Tiempo);
				return "El reo "+reo.getNombre()+" ha sido existosamente asignado a la biblioteca "+patio.getNombre();
		}
		else {
				prision.addHistorialGuardias("El "+this.rango.getRango()+" "+this.nombre+", de codigo: "+this.codigo+" ha intentado mover al reo de codigo: "+reo.getCodigo()+" a la biblioteca: "+reo.getPatio().getNombre()+" pero este patio esta lleno"+Tiempo);
				prision.addHistorialReos("El reo de codigo: "+reo.getCodigo()+" lo han intentado meter a la biblioteca "+reo.getPatio().getNombre()+" por el "+this.rango.getRango()+" "+this.nombre+" de codigo "+this.codigo+" pero este patio esta lleno"+Tiempo);
				return "La biblioteca esta llena, ingrese al reo "+reo.getNombre()+" a otra biblioteca";
		}
	}
	
	public String meterReoPatio(Reo reo, Gimnasio patio) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
		
		if(reo.getPatio() !=null) {
			prision.addHistorialGuardias("El "+this.rango.getRango()+" "+this.nombre+", de codigo: "+this.codigo+" ha intentado meter al reo de codigo: "+reo.getCodigo()+" al gimnasio: "+reo.getPatio().getNombre()+", pero este ya esta en un patio"+Tiempo);
			prision.addHistorialReos("El reo de codigo: "+reo.getCodigo()+" lo han intentado meter al gimnasio "+reo.getPatio().getNombre()+" por el "+this.rango.getRango()+" "+this.nombre+" de codigo "+this.codigo+" pero esta está llena"+Tiempo);
			return "El reo "+reo.getNombre()+" ya tiene un gimnasio asignado";
		}
		else if(patio.getReos().size()+1 <= patio.getCapacidad()){
				patio.ingresarReos(reo);
				reo.setPatio(patio);
				prision.addHistorialGuardias("El "+this.rango.getRango()+" "+this.nombre+", de codigo: "+this.codigo+" ha movido al reo de codigo: "+reo.getCodigo()+" al gimnasio: "+reo.getPatio().getNombre()+Tiempo);
				prision.addHistorialReos("El reo de codigo: "+reo.getCodigo()+" lo ha movido al gimnasio "+reo.getPatio().getNombre()+" por el "+this.rango.getRango()+" "+this.nombre+" de codigo "+this.codigo+Tiempo);
				return "El reo "+reo.getNombre()+" ha sido existosamente asignado al gimnasio "+patio.getNombre();
		}
		else {
				prision.addHistorialGuardias("El "+this.rango.getRango()+" "+this.nombre+", de codigo: "+this.codigo+" ha intentado mover al reo de codigo: "+reo.getCodigo()+" al gimnasio: "+reo.getPatio().getNombre()+" pero este patio esta lleno"+Tiempo);
				prision.addHistorialReos("El reo de codigo: "+reo.getCodigo()+" lo han intentado meter al gimnasio "+reo.getPatio().getNombre()+" por el "+this.rango.getRango()+" "+this.nombre+" de codigo "+this.codigo+" pero este patio esta lleno"+Tiempo);
				return "El gimnasio esta lleno, ingrese al reo "+reo.getNombre()+" a otro gimnasio";
		}
	}
	
	public void sacarReoPatio(Reo reo) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
		
		if(reo.getPatio() == null) {
			prision.addHistorialGuardias("El "+this.rango.getRango()+" "+this.nombre+", de codigo: "+this.codigo+" ha intentado sacar al reo de codigo: "+reo.getCodigo()+" de su patio pero este no tiene uno asignado en el momento"+Tiempo);
			prision.addHistorialReos("El "+this.rango.getRango()+" "+this.nombre+", de codigo: "+this.codigo+" ha intentado sacar al reo de codigo: "+reo.getCodigo()+" de su patio pero este no tiene uno asignado en el momento"+Tiempo);
		}
		else{
			reo.getPatio().sacarReos(reo);
			reo.setPatio(null);
			prision.addHistorialGuardias("El "+this.rango.getRango()+" "+this.nombre+", de c�digo: "+this.codigo+" ha sacado al reo de c�digo: "+reo.getCodigo()+" de su patio"+Tiempo);
			prision.addHistorialReos("El "+this.rango.getRango()+" "+this.nombre+", de c�digo: "+this.codigo+" ha sacado al reo de c�digo: "+reo.getCodigo()+" de su patio"+Tiempo);
		}
	}
	
	////////Setters y getters

	public Prision getPrision() {
		return prision;
	}

	public void setPrision(Prision prision) {
		//A�ade al historial
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
		
		if(this.getPrision() != null) {
			this.prision.addHistorialGuardias("El "+this.rango.getRango()+" "+this.nombre+" con codigo "+this.codigo+", ha salido de la prisi�n: "+this.prision.getNombre()+", y ser� trasladado a: "+prision.getNombre()+Tiempo);
			prision.addHistorialGuardias("El "+this.rango.getRango()+" "+this.nombre+" con codigo "+this.codigo+", ha salido de la prisi�n: "+this.prision.getNombre()+", y ser� trasladado a: "+prision.getNombre()+Tiempo);
			this.prision.getGuardias().remove(this);
			this.prision = prision;
			prision.addGuardias(this);	
		}else {
			this.prision=prision;
			prision.addGuardias(this);
			prision.addHistorialGuardias("El "+this.rango.getRango()+" "+this.nombre+" con codigo "+this.codigo+", ha ingresado a la prision: "+prision.getNombre()+Tiempo);
		}
	}

	public Rango getRango() {
		return rango;
	}

	public void setRango(Rango rango) {
		this.rango = rango;
	}

	public static ArrayList<Guardia> getGuardiasTotales() {
		return guardiasTotales;
	}

	public static void setGuardiasTotales(ArrayList<Guardia> guardiasTotales) {
		Guardia.guardiasTotales = guardiasTotales;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCodigo() {
		return codigo;
	}
	
}
