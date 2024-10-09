package EjerciciosFicherosVarios;

import java.io.File;
import java.util.Iterator;

public class ejercicio13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		File direcAct = new File(".");
		String ficheros[] = direcAct.list();
		
		for (int i = 0; i < ficheros.length; i++) {
			System.out.print(ficheros[i] + ": ");
			
			File aux = new File(ficheros[i]);
			
			if (aux.isDirectory()) {
				System.out.println("es un directorio");
			} if(aux.isFile()) {
				System.out.println("es archivo");
			}
		}
	}

}
