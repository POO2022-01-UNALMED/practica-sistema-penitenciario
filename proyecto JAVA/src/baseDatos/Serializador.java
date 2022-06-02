package baseDatos;

//import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
//import java.io.PrintWriter;
import java.util.ArrayList;

import gestorAplicacion.bienes.Bus;
import gestorAplicacion.departamentos.Biblioteca;
import gestorAplicacion.departamentos.Celda;
import gestorAplicacion.departamentos.Gimnasio;
import gestorAplicacion.departamentos.Prision;
import gestorAplicacion.personal.Reo;
import gestorAplicacion.personal.Guardia;
import gestorAplicacion.personal.Trabajo;
//import uiMain.Alcaide;

public class Serializador {
	/**
	 * Serializamos una lista por el nombre de la clase
	 * 
	 * @param <E>       el generico se usa para poder agredar las clases que se
	 *                  crearon
	 * @param lista     Una lista de objetos
	 * @param className El nombre de la clase que queremos usar como nombre del
	 *                  archivo
	 */
	public static <E> void serializar(ArrayList<E> lista, String className) {
		FileOutputStream fileOut;

		try {
			String path = System.getProperty("user.dir") + "/src/baseDatos/temp/" + className + ".txt";
			// se crea un fileoutputstream para saber donde serializar los archivos
			fileOut = new FileOutputStream(path);
			// Se crea un objeto output stream para poder escribir en el archivo
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			// Guardamos la lista de objetos
			out.writeObject(lista);
			out.close();
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Serializamos todas las clases que necesitamos
	 */
	public static void serializarTodo() {
		Serializador.serializar(Prision.getPrisiones(), "prisiones");
		Serializador.serializar(Reo.getReosTotales(), "reos");
		Serializador.serializar(Guardia.getGuardiasTotales(), "guardias");
		Serializador.serializar(Trabajo.getTrabajosTotales(), "trabajos");
		Serializador.serializar(Bus.getBusesTotales(), "buses");
		Serializador.serializar(Biblioteca.getBibliotecasTotales(), "bibliotecas");
		Serializador.serializar(Gimnasio.getGimnasiosTotales(), "gimnasios");
		Serializador.serializar(Celda.getCeldasTotales(), "celdas");
	}
}


//


//public class Serializador {
//	private static File rutaTemp = new File("src/baseDatos/temp");
//	
//	 //Esto se encagar de serializar las listas que est�n creadas en la clase Alcaide
//	public static void serializador(Prision prision) {
//		FileOutputStream fos;
//		ObjectOutputStream oos;
//		File[] docs = rutaTemp.listFiles();
//		PrintWriter pw;
//		
//		//Este for borra el contenido de los archivos al momento de guardar los objetos
//		//para evitar que haya redundancia en los archivos
//		for(File file : docs) {
//			try {
//				//Al crear este pw y pasarle la ruta del archivo
//				//boora lo que haya en ellos automaticamente
//				pw = new PrintWriter(file);
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		for(File file : docs) {
//			if(file.getAbsolutePath().contains("reos")) {
//				try {
//					fos = new FileOutputStream(file);
//					oos = new ObjectOutputStream(fos);
//					oos.writeObject(prision.getReos());
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				
//			}
//			else if(file.getAbsolutePath().contains("guardias")) {
//				try {
//					fos = new FileOutputStream(file);
//					oos = new ObjectOutputStream(fos);
//					oos.writeObject(prision.getGuardias());
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				
//			}
//			else if(file.getAbsolutePath().contains("trabajos")) {
//				try {
//					fos = new FileOutputStream(file);
//					oos = new ObjectOutputStream(fos);
//					oos.writeObject(prision.getTrabajos());
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				
//			}
//			else if(file.getAbsolutePath().contains("bibliotecas")) {
//				try {
//					fos = new FileOutputStream(file);
//					oos = new ObjectOutputStream(fos);
//					oos.writeObject(prision.getReos());
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				
//			}
//			else if(file.getAbsolutePath().contains("gimnasios")) {
//				try {
//					fos = new FileOutputStream(file);
//					oos = new ObjectOutputStream(fos);
//					oos.writeObject(prision.getGimnasios());
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				
//			}
//			else if(file.getAbsolutePath().contains("buses")) {
//				try {
//					fos = new FileOutputStream(file);
//					oos = new ObjectOutputStream(fos);
//					oos.writeObject(prision.getBuses());
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				
//			}
//			else if(file.getAbsolutePath().contains("prisiones")) {
//				try {
//					fos = new FileOutputStream(file);
//					oos = new ObjectOutputStream(fos);
//					oos.writeObject(Prision.getPrisiones());
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				
//			}
//			
//			else if(file.getAbsolutePath().contains("celdas")) {
//				try {
//					fos = new FileOutputStream(file);
//					oos = new ObjectOutputStream(fos);
//					oos.writeObject(prision.getCeldas());
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				
//			}
//			
//			else if(file.getAbsolutePath().contains("numreos")) {
//				try {
//					fos = new FileOutputStream(file);
//					oos = new ObjectOutputStream(fos);
//					oos.writeObject(prision.getNumReos());
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				
//			}
//			else if(file.getAbsolutePath().contains("nombreprision")) {
//				try {
//					fos = new FileOutputStream(file);
//					oos = new ObjectOutputStream(fos);
//					oos.writeObject(prision.getNombre());
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				
//			}
//			else if(file.getAbsolutePath().contains("localizacionprision")) {
//				try {
//					fos = new FileOutputStream(file);
//					oos = new ObjectOutputStream(fos);
//					oos.writeObject(prision.getLocalizacion());
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				
//			}
//			else if(file.getAbsolutePath().contains("losobjetosprision")) {
//				try {
//					fos = new FileOutputStream(file);
//					oos = new ObjectOutputStream(fos);
//					oos.writeObject(Prision.getPrisiones());
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				
//			}
//		}
//	}
//
//}
