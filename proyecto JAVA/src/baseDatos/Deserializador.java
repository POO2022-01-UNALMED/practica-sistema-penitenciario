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

import gestorAplicacion.personal.Guardia;
import gestorAplicacion.personal.Reo;
import gestorAplicacion.departamentos.*;
import gestorAplicacion.bienes.*;

public class Deserializador {
	//aquí definimos la ruta que contiene temp
	private static File rutaTemp = new File("src/baseDatos/temp");
	//carga las listas de objetos que hay almacenados
	public static void deserializar(Prision prision) {
		File[] docs = rutaTemp.listFiles();
		FileInputStream fis;
		ObjectInputStream ois;
		
		for (File file : docs) {
			if (file.getAbsolutePath().contains("reos")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
					
					prision.setReos((ArrayList<Reo>)ois.readObject());
				} catch(FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e){
					e.printStackTrace();
				}
			}
			else if(file.getAbsolutePath().contains("guardias")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
					
					prision.setGuardias((ArrayList<Guardia>)ois.readObject());
				} catch(FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e){
					e.printStackTrace();
				}
			}
			else if(file.getAbsolutePath().contains("trabajos")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
					
					prision.setTrabajos((ArrayList<Trabajo>)ois.readObject());
				} catch(FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e){
					e.printStackTrace();
				}
			}
			else if(file.getAbsolutePath().contains("bibliotecas")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
					
					prision.setBibliotecas((ArrayList<Biblioteca>)ois.readObject());
				} catch(FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e){
					e.printStackTrace();
				}
			}
			else if(file.getAbsolutePath().contains("gimnasios")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
					
					prision.setGimnasios((ArrayList<Gimnasio>)ois.readObject());
				} catch(FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e){
					e.printStackTrace();
				}
			}
			else if(file.getAbsolutePath().contains("prisiones")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
					
					Prision.setPrisiones((ArrayList<Prision>)ois.readObject());//Tal vez esto dañe la vaina
				} catch(FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e){
					e.printStackTrace();
				}
			}
			else if(file.getAbsolutePath().contains("buses")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
					
					prision.setBuses((ArrayList<Bus>)ois.readObject());
				} catch(FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e){
					e.printStackTrace();
				}
			}
		
		
		
		
		
		}
		
		
		
	}

}
