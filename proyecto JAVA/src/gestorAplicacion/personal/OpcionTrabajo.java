package gestorAplicacion.personal;


enum Dificultad {facil, normal, dificil};

public enum OpcionTrabajo {Barrendero(Dificultad.facil, 1 ,3),Bibliotecario(Dificultad.normal, 2, 5),Profesor(Dificultad.dificil, 3, 8);

	public final Dificultad dificultad;
	public final int constanteDeDificultad;
	public final int horasQueLlevaHacerUnTurno;
	private OpcionTrabajo(Dificultad dif, int y, int x) {
		dificultad = dif;
		constanteDeDificultad = y;
		horasQueLlevaHacerUnTurno = x;
	}
}
