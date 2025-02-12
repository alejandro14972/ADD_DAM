package ADD_DAM_APUNTES;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;



public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File d = new File("./");
		File f = new File(d, "estudiante.dat");

		ArrayList<Estudiante> lista = new ArrayList<Estudiante>();

		// Estudiante est = new Estudiante("Alejandro", "Gonzalez", "7272772x");
		// Estudiante est2 = new Estudiante("Juan", "Gonzalez", "7272772x");

		// lista.add(est2);
		// lista.add(est);

		Estudiante[] est = new Estudiante[2];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < est.length; i++) {

			System.out.println("nombre alumno " + i);
			String nombre = sc.nextLine();
			String apellidos = sc.nextLine();
			String DNI = sc.nextLine();

			est[i] = new Estudiante(nombre, apellidos, DNI);
			lista.add(est[i]);

		}

		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).toString());
		}

		almacenardatos(lista, f);
		leer(f);

	}

	private static void almacenardatos(ArrayList<Estudiante> lista, File f) {

		try {
			ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(f));

			for (int i = 0; i < lista.size(); i++) {
				oo.writeObject(lista.get(i));
				System.out.println("escrito");
			}

			oo.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void leer(File f4) {
		// TODO Auto-generated method stub

		try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(f4))) {

			Estudiante p;

			while (true) {
				try {
					// Intentamos leer el objeto
					p = (Estudiante) oi.readObject();
					System.out.println(p.toString());

				} catch (EOFException e) {
					// Se alcanza el final del archivo
					System.out.println("No hay más objetos en el archivo.");
					break; // Rompemos el ciclo al final del archivo
				} catch (ClassNotFoundException e) {
					// Si la clase no es encontrada
					e.printStackTrace();
				}
			}

			oi.close();

		} catch (FileNotFoundException e) {
			// Si no se encuentra el archivo
			e.printStackTrace();
		} catch (IOException e) {
			// Cualquier otra excepción de I/O
			e.printStackTrace();
		}
	}

}
