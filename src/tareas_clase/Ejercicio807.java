package tareas_clase;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Ejercicio807 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		File d = new File("C:\\\\Users\\\\aleja\\\\eclipse-workspace\\\\ADD_DAM\\\\ficheros");
		File f = new File(d,"entrada807.dat");
		
		metodoObjectOutputStream(f);
		
		int aux20 = 0;
		ArrayList<Integer> datos = new ArrayList<Integer>();
		
		
		try {
			DataInputStream di = new DataInputStream(new FileInputStream(f));
			
			while (true) {
					try {
						int n= di.readInt();
						
						if (aux20 < 20) {
							datos.add(n);
							aux20 +=1;
						}

					}catch (EOFException e) {
						// TODO: handle exception
						break;
					}
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		Collections.sort(datos);
		for (int i = 0; i < datos.size(); i++) {
			System.out.print(datos.get(i) + " - ");
		}
		
		System.out.println(" ");
		System.out.println(datos.size());
		
		
		metodoGrabar(datos);

	}
	
	
	private static void metodoGrabar(ArrayList<Integer> datos) {
		
		File d = new File("C:\\\\Users\\\\aleja\\\\eclipse-workspace\\\\ADD_DAM\\\\ficheros");
		File f = new File(d,"entrada807Grabar.dat");
		
		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(f));
			
			for (int i = 0; i < datos.size(); i++) {
				try {
					dos.writeInt(datos.get(i));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("todo grabado");
		
		
	}


	private static void metodoObjectOutputStream(File f) {
		try {
			DataOutputStream oo = new DataOutputStream(new FileOutputStream(f));

			
			Random random = new Random();
			int min = 0;
			int max = 10;
			
			for (int i = 0; i < 25; i++) {
				int randonNumero = random.nextInt((max-min)+1)+min;
				oo.writeInt(randonNumero);
				System.out.println(randonNumero);
			}

			oo.close();
			
			System.out.println("Listo");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
