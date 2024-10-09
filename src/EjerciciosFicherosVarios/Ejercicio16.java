package EjerciciosFicherosVarios;

import java.io.File;
import java.util.Scanner;

public class Ejercicio16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		File f = new File("C:\\Users\\aleja\\eclipse-workspace\\AADD_EJERCICIO1\\Directorio\\fichero.txt");
		
		String nombreold = f.getName();
		
		 Scanner sc = new Scanner(System.in);
		 System.out.println("nombre nuevo fichero");
		 String name = sc.nextLine();
		 sc.close();
		
		
		boolean r = f.renameTo(new File(f.getParent(), name));
		System.out.println(r);
		
		
		if (r) {
			System.out.println("fichero renombrado de: " + nombreold + "---->" + name );
		} else {
			System.out.println("error");
		}
		
	

	}

}
