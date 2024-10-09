package tareas_clase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio802 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("RUTA");
		Scanner sc = new Scanner(System.in);
		String dir = sc.nextLine();
		
		System.out.println("NOMBRE DEL FICHERO");
		Scanner sc2 = new Scanner(System.in);
		String f = sc2.nextLine();
	
		File d = new File(dir,f);
		
		
		try {
			FileReader fr = new FileReader(d);
			
			int n;
			String frase="";
			
			while ((n = fr.read()) != -1) {
				frase+= (char)n;
			}
			
			String fraseN= frase.replace(' ', '-');
			System.out.println(fraseN.toUpperCase());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
