package tareas_clase;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio805 {

	public static void main(String[] args) {
	
	File d = new File("C:\\Users\\aleja\\eclipse-workspace\\ADD_DAM\\ficheros");
	
	File f = new File(d,"entrada801.dat");

	ArrayList<Integer> datos= new ArrayList<Integer>();
	
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream(f));
		
			    while (true) {
			        try {
			            int n = dis.readInt();
			            datos.add(n);
			        } catch (EOFException e) {
			            System.out.print("");
			            break;
			        }
			    }
	    
			    for (int i = 0; i < datos.size(); i++) {
					System.out.println(datos.get(i));
				}
				} catch (IOException e) {
				    e.printStackTrace();
				}
	}
}
	
