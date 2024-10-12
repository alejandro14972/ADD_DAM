package tareas_clase;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Ejercicio805V2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		File d = new File("C:\\Users\\aleja\\eclipse-workspace\\ADD_DAM\\ficheros");
		File f = new File(d,"fichero805.txt");

		try {
			BufferedReader bf = new BufferedReader(new FileReader(f));
			
			String linea;
			
			ArrayList<Integer> datos = new ArrayList<Integer>();
			 while ((linea = bf.readLine()) != null) {
				
				int numero = Integer.parseInt(linea.trim());
				datos.add(numero);
			
			}
			bf.close();
			
			   //System.out.println("Números almacenados en el ArrayList: " + datos);
			
			System.out.println("El numero total de valores es: "+ datos.size());
			
			   for (int i = 0; i < datos.size(); i++) {
				   System.out.println(datos.get(i));
			   }
			   
			   calcularMedia(datos);
			   
			   
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

	private static void calcularMedia(ArrayList<Integer> datos) {
		// TODO Auto-generated method stub
		
		int suma=0;
		float media=0;
		
		for (int i = 0; i < datos.size(); i++) {
			suma+= datos.get(i);
		}
		
	
		System.out.println(media= suma / datos.size());
		
	}

}
