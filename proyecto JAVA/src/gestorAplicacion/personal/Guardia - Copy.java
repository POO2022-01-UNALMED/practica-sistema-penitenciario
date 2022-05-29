package gestorAplicacion.personal;
import gestorAplicacion.personal.*;
import java.util.List;
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
		
	}
	

	public Guardia(String nombre, int codigo, Prision prision, Rango rango) {
		
		this(nombre, codigo, prision);
		this.rango = rango;
		
	}

	
	public Guardia(String nombre, int codigo, Rango rango) {
		
		this(nombre, codigo);
		this.rango = rango;
		
	}

	
	public void meterReoCelda(Reo reo, Celda celda) {
		if (this.rango == Rango.bachiller || reo.getCelda() != null) {
			return;
		}
		else {
			//celda.asignarReo(reo);
			reo.setCelda(celda);
		}
				
	}
	
	
	public Prision getPrision() {
		return prision;
	}
	

	public void setPrision(Prision prision) {
		this.prision = prision;
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
