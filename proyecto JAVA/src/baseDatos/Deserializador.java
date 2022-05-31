package baseDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import gestorAplicacion.personal.*;
import gestorAplicacion.departamentos.*;
import gestorAplicacion.bienes.*;

public class Deserializador {
	public static <E> void deserializador(List<E> list, String className) {
		FileInputStream fileIn;
		try {
			// Creamos una cadena con la ruta del archivo que vamos a cargar
			String path = System.getProperty("user.dir") + "/src/baseDatos/temp/" + className + ".txt";
			System.out.println(path);
			// utilizamos un file para crear este archivo si no existe aun
			File archivo = new File(path);
			archivo.createNewFile(); // Crea un nuevo archivo si no existe

			// usamos un FileInputStream para poder saber de donde cargar el archivo
			fileIn = new FileInputStream(path);

			// Si el archivo esta vacio se lanza un throw EOFException y se muestra como un
			// mensaje de vacio, pero si no se usa el objeto in para leer el archivo
			ObjectInputStream in = new ObjectInputStream(fileIn);

			// Lee el listado de elementos
			ArrayList<E> listado = (ArrayList<E>) in.readObject();

			// Recorro el ArrayList
			for (E el : listado) {
				list.add(el);
			}

			in.close();
			fileIn.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Esta vacio");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Funcion para deserializar toda la aplicacion Generic IT
	 */
	public static void deserializarTodo() {
		Deserializador.deserializador(Prision.getPrisiones(), "prisiones");
		Deserializador.deserializador(Reo.getReosTotales(), "reos");
		Deserializador.deserializador(Guardia.getGuardiasTotales(), "guardias");
		Deserializador.deserializador(Trabajo.getTrabajosTotales(), "trabajos");
		Deserializador.deserializador(Bus.getBusesTotales(), "buses");
		Deserializador.deserializador(Biblioteca.getBibliotecasTotales(), "bibliotecas");
		Deserializador.deserializador(Gimnasio.getGimnasiosTotales(), "gimnasios");
	}
}

//

//public class Deserializador {
//	//aqu� definimos la ruta que contiene temp
//	private static File rutaTemp = new File("src/baseDatos/temp");
//	//carga las listas de objetos que hay almacenados
//	public static void deserializar(Prision prision) {
//		File[] docs = rutaTemp.listFiles();
//		FileInputStream fis;
//		ObjectInputStream ois;
//		
//		for (File file : docs) {
//			if (file.getAbsolutePath().contains("reos")) {
//				try {
//					fis = new FileInputStream(file);
//					ois = new ObjectInputStream(fis);
//					
//					prision.setReos((ArrayList<Reo>)ois.readObject());
//				} catch(FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				} catch (ClassNotFoundException e){
//					e.printStackTrace();
//				}
//			}
//			else if(file.getAbsolutePath().contains("guardias")) {
//				try {
//					fis = new FileInputStream(file);
//					ois = new ObjectInputStream(fis);
//					
//					prision.setGuardias((ArrayList<Guardia>)ois.readObject());
//				} catch(FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				} catch (ClassNotFoundException e){
//					e.printStackTrace();
//				}
//			}
//			else if(file.getAbsolutePath().contains("trabajos")) {
//				try {
//					fis = new FileInputStream(file);
//					ois = new ObjectInputStream(fis);
//					
//					prision.setTrabajos((ArrayList<Trabajo>)ois.readObject());
//				} catch(FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				} catch (ClassNotFoundException e){
//					e.printStackTrace();
//				}
//			}
//			else if(file.getAbsolutePath().contains("bibliotecas")) {
//				try {
//					fis = new FileInputStream(file);
//					ois = new ObjectInputStream(fis);
//					
//					prision.setBibliotecas((ArrayList<Biblioteca>)ois.readObject());
//				} catch(FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				} catch (ClassNotFoundException e){
//					e.printStackTrace();
//				}
//			}
//			else if(file.getAbsolutePath().contains("gimnasios")) {
//				try {
//					fis = new FileInputStream(file);
//					ois = new ObjectInputStream(fis);
//					
//					prision.setGimnasios((ArrayList<Gimnasio>)ois.readObject());
//				} catch(FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				} catch (ClassNotFoundException e){
//					e.printStackTrace();
//				}
//			}
//			else if(file.getAbsolutePath().contains("prisiones")) {
//				try {
//					fis = new FileInputStream(file);
//					ois = new ObjectInputStream(fis);
//					
//					Prision.setPrisiones((ArrayList<Prision>)ois.readObject());//Tal vez esto da�e la vaina
//				} catch(FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				} catch (ClassNotFoundException e){
//					e.printStackTrace();
//				}
//			}
//			else if(file.getAbsolutePath().contains("buses")) {
//				try {
//					fis = new FileInputStream(file);
//					ois = new ObjectInputStream(fis);
//					
//					prision.setBuses((ArrayList<Bus>)ois.readObject());
//				} catch(FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				} catch (ClassNotFoundException e){
//					e.printStackTrace();
//				}
//			}
////			else if(file.getAbsolutePath().contains("numreos")) {
////				try {
////					fis = new FileInputStream(file);
////					ois = new ObjectInputStream(fis);
////					
////					prision.numReos = ((int) ois.readObject());
////				} catch(FileNotFoundException e) {
////					e.printStackTrace();
////				} catch (IOException e) {
////					e.printStackTrace();
////				} catch (ClassNotFoundException e){
////					e.printStackTrace();
////				}
////			}
//			else if(file.getAbsolutePath().contains("buses")) {
//				try {
//					fis = new FileInputStream(file);
//					ois = new ObjectInputStream(fis);
//					
//					prision.setBuses((ArrayList<Bus>)ois.readObject());
//				} catch(FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				} catch (ClassNotFoundException e){
//					e.printStackTrace();
//				}
//			}
//			else if(file.getAbsolutePath().contains("losobjetosprision")) {
//				try {
//					fis = new FileInputStream(file);
//					ois = new ObjectInputStream(fis);
//					
//					Prision.setPrisiones((ArrayList<Prision>)ois.readObject());
//				} catch(FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				} catch (ClassNotFoundException e){
//					e.printStackTrace();
//				}
//			}
//			
//		
//		
//		
//		
//		
//		}
//		
//		
//		
//	}
//
//}
