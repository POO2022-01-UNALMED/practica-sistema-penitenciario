package gestorAplicacion.personal;


import gestorAplicacion.departamentos.Prision;


public interface Persona {
	public String getNombre();
	public int getCodigo();
	public void setPrision(Prision prision);
	public Prision getPrision();
	//
	
}