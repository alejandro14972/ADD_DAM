package tareas_clase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ejercicio808 {

	public static void main(String[] args) {
	        File d = new File("C:\\Users\\aleja\\eclipse-workspace\\ADD_DAM\\ficheros");
	        File f = new File(d, "808matriz.dat");
	        
	        try {
				ObjectInputStream oi = new ObjectInputStream(new FileInputStream(f));
				
				try {
					int [][] matriz2 = new int[30][5];
					matriz2= (int[][]) oi.readObject();
					 oi.close();
					 
					
			            for (int i = 0; i < 5; i++) {
			                for (int j = 0; j < 30; j++) {
			                    System.out.print(matriz2[i][j] + "\t");
			                }
			                System.out.println();
			            }
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        
	        
	        
	        
	    }

	}


