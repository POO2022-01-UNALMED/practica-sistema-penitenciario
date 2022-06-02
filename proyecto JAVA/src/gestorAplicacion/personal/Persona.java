 package gestorAplicacion.personal;


import gestorAplicacion.departamentos.Prision;

//Ayuda a extender a Guardia y Reo 

public interface Persona {
	public String getNombre();
	public int getCodigo();
	public void setPrision(Prision prision);
	public Prision getPrision();
	//
	
}