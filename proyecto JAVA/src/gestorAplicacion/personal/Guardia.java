package gestorAplicacion.personal;
import gestorAplicacion.personal.*;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import gestorAplicacion.bienes.*;
import gestorAplicacion.departamentos.*;

public class Guardia{

	private final String nombre;
	private final int codigo;
	private Prision prision;
	private Rango rango=Rango.bachiller;
	private static ArrayList<String> historialGuardias = new ArrayList<String>();
	
	public Guardia(String nombre, int codigo) {
		
		this.nombre = nombre;
		this.codigo = codigo;
		
	}

	public Guardia(String nombre, int codigo, Prision prision) {
		
		this(nombre, codigo);
		this.prision = prision;
		
		//Añade al historial
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
		prision.addHistorialGuardias("El bachiller "+nombre+", con código: "+codigo+", ha sido trasladado a la prisión: "+prision.getNombre()+Tiempo);
		
	}
	

	public Guardia(String nombre, int codigo, Prision prision, Rango rango) {
		
		this(nombre, codigo);
		this.prision = prision;
		this.rango = rango;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
		prision.addHistorialGuardias("El "+rango.getRango()+" "+nombre+", con código: "+codigo+", ha sido trasladado a la prisión: "+prision.getNombre()+Tiempo);
		
	}

	
	public Guardia(String nombre, int codigo, Rango rango) {
		
		this(nombre, codigo);
		this.rango = rango;
		
	}

	public void promocionarGuardia() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
		
		if(this.getRango()==Rango.bachiller) {
			this.setRango(Rango.carcelero);
			
			prision.addHistorialGuardias("El guardia "+this.nombre+", con código: "+this.codigo+" ha sido promocionado a: "+this.rango.getRango()+Tiempo);
		}
		else if(this.getRango()==Rango.carcelero) {
			this.setRango(Rango.oficial);
			
			prision.addHistorialGuardias("El guardia "+this.nombre+", con código: "+this.codigo+" ha sido promocionado a: "+this.rango.getRango()+Tiempo);
		}
		else {
			prision.addHistorialGuardias("El guardia "+this.nombre+" no pudo ser promocionado"+Tiempo);
			return;}
		
		
	}
	
	public void meterReoCelda(Reo reo, Celda celda) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
		
		if (this.rango == Rango.bachiller) {
			
			prision.addHistorialGuardias("El bachiller "+this.nombre+", de código: "+this.codigo+"ha intentado meter el reo de código: "+reo.getCodigo()+" a la celda: "+celda.getNumCelda()+" pero no tiene los permisos para realizar esta acción"+Tiempo);
			return;
		}
		else if(reo.getCelda() != null) {
			prision.addHistorialGuardias("El "+this.rango.getRango()+" "+this.nombre+", de código: "+this.codigo+" ha intentado meter al reo de código: "+reo.getCodigo()+" a la celda: "+celda.getNumCelda()+", pero este ya está en una celda"+Tiempo);
		}
		else if(celda.getReosPertenecientes().size()+1 <= celda.getCapacidadMax()){
			celda.asignarReo(reo);
			reo.setCelda(celda);
            
			prision.addHistorialGuardias("El reo de código: "+reo.getCodigo()+" ha sido ingresado a la celda número "+celda.getNumCelda()+" por el "+this.rango.getRango()+" "+this.nombre+", de código: "+this.codigo+Tiempo);	
		}
		else {
			prision.addHistorialGuardias("El reo de código: "+reo.getCodigo()+" no puede ser ingresado a la celda número "+celda.getNumCelda()+" por el "+this.rango.getRango()+" "+this.nombre+", de código: "+this.codigo+", pues está llena"+Tiempo);	
		}
				
	}

	public void sacarReoCelda(Reo reo) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
		
		if (this.rango == Rango.bachiller) {
			prision.addHistorialGuardias("El bachiller "+this.nombre+" ha intentado sacar el reo de código: "+reo.getCodigo()+" de una celda pero no tiene los permisos para realizar esta acción"+Tiempo);
		}
		else if(reo.getCelda() == null) {
			prision.addHistorialGuardias("El "+this.rango.getRango()+" "+this.nombre+", de código: "+this.codigo+" ha intentado sacar al reo de código: "+reo.getCodigo()+" de su celda pero este no tiene una asignada en el momento"+Tiempo);
		}
		else{
			reo.getCelda().sacarReo(reo);
		}
	}
	
	public Prision getPrision() {
		return prision;
	}
	

	public void setPrision(Prision prision) {
		this.prision = prision;
		
		//Añade al historial
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String Tiempo = ". "+dtf.format(LocalDateTime.now())+".";
		prision.addHistorialGuardias("El "+this.rango.getRango()+" "+this.nombre+" ha sido trasladado a la prisión: "+prision+Tiempo);
	}
	

	public Rango getRango() {
		return rango;
	}
	

	public void setRango(Rango rango) {
		this.rango = rango;
	}
	


	public String getNombre() {
		return nombre;
	}
	

	public int getCodigo() {
		return codigo;
	}
	
	public ArrayList<String> getHistorialGuardia() {
		return historialGuardias;
	}

	//public void setHistorialGuardia(ArrayList<String> historialGuardia) {
	//	this.historialGuardia = historialGuardia;
	//}
	
	
	
	
	
	
}
