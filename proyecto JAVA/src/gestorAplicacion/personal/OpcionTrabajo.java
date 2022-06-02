package gestorAplicacion.personal;


enum Dificultad {facil, normal, dificil};

public enum OpcionTrabajo {Barrendero("barrendero", Dificultad.facil, 1 ,3), Bibliotecario("bibliotecario", Dificultad.normal, 2, 5),Profesor("profesor", Dificultad.dificil, 3, 8);
	
	//el enum trabajo tiene 4 atributos por cada elemento, el nombre, la dificultad (que es otro enum), la constante de dificultad, y el número de horas que lleva hacer un turno
	//la constante de dificultad y el número de horas que lleva hacer un turno determinaran cómo le sube el comportamiento al reo y este es directamente proporcional a los años de 
	//condena que le reducen. por tanto a más dificil el trabajo más años de condena le quitan por hacer este
	
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
