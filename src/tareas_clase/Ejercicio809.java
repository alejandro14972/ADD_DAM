package tareas_clase;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import ADD_DAM_APUNTES.Persona;

public class Ejercicio809 {

	public static void main(String[] args) {
		File d = new File("C:\\Users\\aleja\\eclipse-workspace\\ADD_DAM\\ficheros");
		File f4 = new File(d, "miEntrada809.dat");

		metodoObjectOutputStream(f4);
		metodoObjectInputStream(f4);
	}

	private static void metodoObjectInputStream(File f4) {
		try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(f4))) {

			Trabajador t = null;

			while (true) {
				try {

					t = (Trabajador) oi.readObject(); 
					System.out.println(t.toString());
				} catch (EOFException e) {
					System.out.println("No hay más objetos en el archivo.");
					break;
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void metodoObjectOutputStream(File f4) {
		ArrayList<Object> empleados = new ArrayList<Object>();
		Trabajador t1 = new Trabajador("Alex", 20, 2);
		Trabajador t2 = new Trabajador("juan", 40, 5);
		Trabajador t3 = new Trabajador("victor", 60, 3);
		Trabajador t4 = new Trabajador("victor", 60, 3);

		empleados.add(t1);
		empleados.add(t2);
		empleados.add(t3);
		empleados.add(t4);
		

		try {
			ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(f4));

			for (int i = 0; i < empleados.size(); i++) {
				oo.writeObject(empleados.get(i));
			}

			oo.close();
			System.out.println("escrito");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		analisis(empleados);

	}

	private static void analisis(ArrayList<Object> empleados) {

		int cero = 0, uno = 0, dos = 0, tres = 0, cuatro = 0, cinco = 0;

		Trabajador t = null;

		for (int i = 0; i < empleados.size(); i++) {
			t = (Trabajador) empleados.get(i);
			int num = t.getNumeroHijos();

			switch (num) {
			case 0:
				cero++;
				break;
			case 1:
				uno++;
				break;
			case 2:
				dos++;
				break;
			case 3:
				tres++;
				break;
			case 4:
				cuatro++;
				break;
			case 5:
				cinco++;
				break;

			default:
				cinco++;
				break;
			}
		}
		
		System.out.println("con 0 hijos: " + cero);
		System.out.println("con 1 hijos: " + uno);
		System.out.println("con 2 hijos: " + dos);
		System.out.println("con 3 hijos: " + tres);
		System.out.println("con 4 hijos: " + cuatro);
		System.out.println("con 5 hijos: " + cinco);

	}

}
