package uiMain;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import gestorAplicacion.bienes.*;
import gestorAplicacion.departamentos.*;
import gestorAplicacion.personal.*;

public class Alcaide {

	public static void main(String[] args) {
		
		Prision ascaban = new Prision("Ascaban");
		
		//---------------------------Evaluacion clase abstracta------------------------------------
		
		//El objetivo puntual de Prision es generar todas las celdas, bibliotecas, gimnasios necesarios para que todods
		//los presos puedan acceder a ellas, por tanto a modo de ejemplo se presentará un objeto biblio1 de la clase Patio que nace siendo una
		//biblioteca para mostrar la correcta implemmentación de ua clase abstracta y de un metod abstracto.
		
		//----------------------------------------------------------------------------------------
		
		Patio biblio1 = new Biblioteca("Biblio1", ascaban); // Patio es una clase abstracta la cual es padre de Biblioteca
		System.out.println(biblio1.getHistorialPatio()); //getHistorialPatio es un método abstracto de la clase Patio
		
		
		//---------------------------Evaluacion interfaz-------------------------------------------
		
		Persona persona1 = new Guardia("Jaime", 10001); //Persona es una interfaz y Guardia es su hija
		System.out.println(persona1.getNombre()); // getNombre() es un método de la interfaz Persona el cual es inplementado en la Guardia
		
		//--------------------------Evaluacion de Herencia ---------------------------------------
		
		Gimnasio gim1 = new Gimnasio("Gim1", ascaban);// Gimnasio es hijo de Patio
		System.out.println(gim1.getCapacidad()); //Gimnasio no tiene el metodo getCapacidad(), pero dicho método existe en Patio y por tanto se hereda.
		
		//--------------------------Evaluacion Ligadura Dinámica---------------------------------
	
		Reo genner = new Reo("Genner",20001, true, 10, ascaban); //creacion del reo Genner
		gim1.ingresarReos(genner); //ingreso de reo genner al gimnasio gim1
		System.out.println(gim1.getCantidadReos()); // el método getCantidadReos() es un metodo no abstracto defnido en Patio y definido en gim1 con misma firma y salida, en Patio
													// dicho método tiene establecido que retornará el entero 1, por otro lado en gimnasio dicho método retornará el tamaño del vector reos
													// por ligadura dinámica se tendrá que este último es el que se ejecuta y como solo se ha ingresado un reo entonces este necesariamnete 
													// nos retornará 1.
		
		
		
	
		
		
		
		
		
		
		
		
		
		
	}
}
