package EjerciciosFicherosVarios;

import java.io.File;

public class Ejercicio17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File d = new File("directorio17");
		
		
		
		if (d.mkdir()) {
			try {
				File f = new File(d, "fichero17");
				f.createNewFile();
				System.out.println("archivo creado");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else {
			System.out.println("directorio ya existe");
		}
		
		
		
		
		
		
		

	}

}
