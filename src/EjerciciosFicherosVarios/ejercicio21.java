package EjerciciosFicherosVarios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ejercicio21 {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		File f = new File("leer1.txt");
		
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileReader fr = new FileReader(f);
			
			int n;
			n = fr.read();
			
			while(n!=-1) {
				System.out.print((char)n);
				n=fr.read();
			}
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		
	}
	

	

}
