package EjerciciosFicherosVarios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File d = new File(".");
		
		File f= new File(d, "fichero.txt");
		
		try {
			/*f.createNewFile();
			FileWriter fo = new FileWriter(f);
			fo.write("MI NOMBRE ES JAN");
			fo.close();
			*/
			FileReader fr = new FileReader(f);
			
			int n;
			while ((n = fr.read())!=-1) {
				System.out.print((char)n);
			}
			
			fr.close();
			
			/////////////////////////////////////////
			BufferedReader frb = new BufferedReader(new FileReader("fichero.txt"));
			
			String linea;
			while ((linea = frb.readLine()) != null) {
				System.out.println(linea);
			}
			
			frb.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (f.isDirectory()) {
			System.out.println("es directorio");
		} else {
			System.out.println("es fichero");
		}
		
	}

}
