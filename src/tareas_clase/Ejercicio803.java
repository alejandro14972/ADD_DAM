package tareas_clase;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio803 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("RUTA origen");
		Scanner sc = new Scanner(System.in);
		String dir = sc.nextLine();
		
		System.out.println("NOMBRE DEL FICHERO DE ORIGEN");
		Scanner sc2 = new Scanner(System.in);
		String f = sc2.nextLine();
		
		System.out.println("RUTA DESTINO");
		Scanner sc3 = new Scanner(System.in);
		String dird = sc.nextLine();
		
		System.out.println("NOMBRE DEL FICHERO DESTINO");
		Scanner sc4 = new Scanner(System.in);
		String fd = sc2.nextLine();
		
		File origen = new File(dir,f);
		File destino = new File(dird,fd);
		
		try {
		
			FileReader fr = new FileReader(origen);	
			FileWriter frd = new FileWriter(destino);
		
		int n;
		int aux = 0;
		
			while ((n = fr.read()) != -1) {
				System.out.print((char) n);
				
				frd.append((char)n);
				aux +=1;
				
			}
			
			frd.close();
			
			System.out.println(" caracteres grabados: " + aux);
		
		} catch (IOException e) {
		
		e.printStackTrace();
	
	}

	}

}
