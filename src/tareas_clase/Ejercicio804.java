package tareas_clase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio804 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("RUTA");
		Scanner sc = new Scanner(System.in);
		String dir = sc.nextLine();
		
		System.out.println("NOMBRE DEL FICHERO");
		Scanner sc2 = new Scanner(System.in);
		String f = sc2.nextLine();
		
		File d = new File(dir,f);
		
		numeroCaracteres(d);
		numeroPalabrasLineas(d);

	}
	
	private static void numeroCaracteres(File f) {
		try {
			FileReader fr =  new FileReader(f);
			
			int n;
			int aux= 0;
			
			while ((n = fr.read()) != -1) {
				if (n!=' ') {
					aux =aux + 1;
				}
			}
			System.out.println(aux + " caracteres");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void numeroPalabrasLineas(File f) {
		 
		try {
			FileReader fr = new FileReader(f);
			BufferedReader bf = new BufferedReader(fr);
			String linea;
			String frase ="";
			int aux = 0;
			linea  = bf.readLine();
		
			
			while (linea!=null) {
				if (linea != null) {
					//System.out.println(linea);
					frase += linea;
					linea= bf.readLine();
					aux += 1;
				}
				
			}
			bf.close();
			System.out.println(aux + " Lineas");
			
			System.out.println(frase);
			
			String[] auxpalabras = frase.split(" ");
			
			System.out.println(auxpalabras.length + " palabras");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		 
		 
	}

}
