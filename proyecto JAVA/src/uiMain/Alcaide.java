package uiMain;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import gestorAplicacion.bienes.*;
import gestorAplicacion.departamentos.*;
import gestorAplicacion.personal.*;

public class Alcaide {

	public static void main(String[] args) {
		
		Prision ascaban = new Prision("ascaban");
		System.out.println(ascaban.historialPrision());
	}

}

