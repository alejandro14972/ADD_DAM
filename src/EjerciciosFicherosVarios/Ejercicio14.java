package EjerciciosFicherosVarios;

import java.io.File;

public class Ejercicio14 {

	public static void main(String[] args) {
		
		//C:\Users\aleja\eclipse-workspace\AADD_EJERCICIO1\Directorio.teclado1.txt
		
		
		File f = new File("C:\\Users\\aleja\\eclipse-workspace\\AADD_EJERCICIO1\\Directorio\\teclado1.txt");
		
		System.out.println(f.length());
		
		String nombre= f.getName();
	
		if (f.delete()) {
			System.out.println("archivo borrado: " + nombre);
		} else {
			System.out.println("error");
		}
	
	}

}
