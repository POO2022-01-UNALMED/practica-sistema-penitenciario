package gestorAplicacion.personal;

import gestorAplicacion.personal.Trabajo.Dificultad;

public class test extends Trabajo {
	
	public static final Dificultad dificultad=Dificultad.facil;
	

	public test(Reo reo) {
		super();
		this.reo = reo;
	}

	@Override
	public void trabajar() {

	}

}
