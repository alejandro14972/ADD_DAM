package EjerciciosFicherosVarios;

import java.io.File;
import java.io.FileReader;

public class Ejercicio24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File f = new File("leer3.txt");
		
		try {
			FileReader fil = new FileReader(f);
			
			int n;
			n=fil.read();
			System.out.println(n);
			
			int aux = 0;
			
			while(n!=-1) {
				System.out.print((char)n);
				n=fil.read();
				
				/*if (n=='a'||n=='e'||n=='i'||n=='o'||n=='u') {
					aux +=1;
				} */
				
				if (vocal((char) n)) {
					aux +=1;
				}
			}
			System.out.println(" ");
			System.out.println("total de vocales: " + aux);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public static boolean vocal(char n) {
		return n == 'a' || n == 'e' || n == 'i' || n == 'o' || n == 'u' || 
	           n == 'A' || n == 'E' || n == 'I' || n == 'O' || n == 'U';
		
	}
	


}
