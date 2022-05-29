package gestorAplicacion.personal;


enum Dificultad {facil, normal, dificil};

public enum OpcionTrabajo {Barrendero("barrendero", Dificultad.facil, 1 ,3), Bibliotecario("bibliotecario", Dificultad.normal, 2, 5),Profesor("profesor", Dificultad.dificil, 3, 8);
	
	private final String nombre;
	private final Dificultad dificultad;
	private final int constanteDeDificultad;
	private final int horasQueLlevaHacerUnTurno;
	private OpcionTrabajo(String nombre, Dificultad dif, int y, int x) {
		this.nombre = nombre;
		dificultad = dif;
		constanteDeDificultad = y;
		horasQueLlevaHacerUnTurno = x;
	}
	public Dificultad getDificultad() {
		return dificultad;
	}
	public int getConstanteDeDificultad() {
		return constanteDeDificultad;
	}
	public int getHorasQueLlevaHacerUnTurno() {
		return horasQueLlevaHacerUnTurno;
	}
	public String getNombre() {
		return nombre;
	}
	
	
}
