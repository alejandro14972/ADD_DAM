package EjerciciosFicherosVarios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Ejercicio25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File f = new File("leer.txt");
		
		try {
			FileReader fr =new FileReader(f);
			
			BufferedReader filtro = new BufferedReader(fr);
			
			String linea;
			int aux=0;
			linea = filtro.readLine();
			
			while (linea!=null) {
				System.out.println(linea);
				linea= filtro.readLine();
				aux += 1;
			}
			
			fr.close();
			System.out.println(aux + " lineas en el fichero");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
		
		

	}

}
