package EjerciciosFicherosVarios;
import java.io.File;
import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Escribe el nombre del fichero");
		String name = sc.nextLine();
		
		File directorio = new File("Directorio");
		File fichero = new File (directorio, name);
		
		try {
			directorio.mkdir();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println(directorio.getAbsolutePath());
		
		try {
			if (fichero.createNewFile()) {
				System.out.println("Archivo txt creado correctamente: " + fichero.getName());
			} else {
				System.out.println("error");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		System.out.println("El fichero tiene permisos de:");
		
		
		if (fichero.canRead() && fichero.canWrite()) {
			System.out.println("El archivo se puede leer y escribir");
		} else if (fichero.canRead()) {
			System.out.println("El archivo se puede leer");
		} else if(fichero.canWrite()) {
			System.out.println("El archivo se puede escribir");
		}else {
			System.out.println("No se puede leer y escribir");
		}
		
	}

}
