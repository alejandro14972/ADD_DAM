package EjerciciosFicherosVarios;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ejercicio18 {
	
	public static void main(String[] args) {
		SimpleDateFormat objeto = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		File d = new File("directorio18");
		
		if (d.mkdir()) {
			System.out.println("directorio creado" + d.getName());
		} else {
			System.out.println("directorio ya existe");
		}
		
				File f = new File(d, "fichero18.txt");
				try {
					f.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("archivo creado");
			
		
		
		File d2 = new File("./directorio18");
		
		//System.out.println(d2.getAbsolutePath());
		
		System.out.println(d2.getName()+ " es un " +(d2.isDirectory()?"directorio":"es un fichero"));
		
		String fichs[]= d2.list();
		
		for (int i = 0; i < fichs.length; i++) {
			
			File aux = new File(d2,fichs[i]);
			
			System.out.println(aux.getName());
			System.out.println("LECTURA: " + aux.canRead());
			System.out.println("Escritura: " + aux.canWrite());
			System.out.println("bytes: " + aux.length());
			
			long ultModific = aux.lastModified();
			System.out.println("Última modificación: " + objeto.format(new Date(ultModific)));
		
			System.out.println();
			boolean r = aux.renameTo(new File(d2, "Frenombrado.txt"));
			
			if (r) {
				System.out.println("renombrado a " + "Frenombrado.txt");
			}else {
				System.out.println("error en el renombramiento");
			}
			
			
			System.out.println("borrar fichero renombrado: ");
			System.out.println("1-SI");
			System.out.println("2-NO");
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("marque una opción: ");
			int key = sc.nextInt();
			
			switch (key) {
			case 1: {
				
				File d3 = new File("./directorio18");
				
				String fichs3[] = d3.list();
				File aux3 = new File(d3, fichs3[i]);
				
				for (int j = 0; j < fichs3.length; j++) {
					System.out.println("fichero borrado: " + fichs3[i]);
					aux3.delete();
				}
				System.out.println("archivo borrado");
				break;
			}
			
			case 2:{
				System.out.println("no borrado");
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + key);
			}
		}
	}

}
