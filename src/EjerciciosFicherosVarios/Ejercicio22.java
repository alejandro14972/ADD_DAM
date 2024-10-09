package EjerciciosFicherosVarios;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File f = new File("leer2.txt");
		crear(f);
		leer(f);
	}

	private static void crear(File f) {
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void leer(File f) {
		try {
			FileReader fr = new FileReader(f);

			int n;
			n = fr.read();

			while (n != -1) {
				System.out.print((char) n);
				n = fr.read();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
