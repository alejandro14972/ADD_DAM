package tareas_clase;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio806 {

	public static void main(String[] args) {
		
		File d = new File("C:\\Users\\aleja\\eclipse-workspace\\ADD_DAM\\ficheros");
		File f = new File(d,"datos806.dat");
		
		metodoObjectOutputStream(f);
		ArrayList<Double> datos =new ArrayList<>();
		leerDatos(f, datos);
	}
	
	
	
	
	private static void leerDatos(File f, ArrayList<Double> datos) {

        try (DataInputStream fi = new DataInputStream(new FileInputStream(f))) {
          
            while (true) {
                try {
                    Double n = fi.readDouble();
                    datos.add(n);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        double suma=0;
        for (Double numeros : datos) {
        	suma += numeros;
			
		}
        System.out.println(suma/datos.size() + " media");
        System.out.println(Collections.max(datos) + " la maxima");
        System.out.println(Collections.min(datos) + " la mínima");
    }




	private static void metodoObjectOutputStream(File f) {
		try {
			DataOutputStream oo = new DataOutputStream(new FileOutputStream(f));

			oo.writeDouble(7.3);
			oo.writeDouble(5.3);
			oo.writeDouble(8.5);
			oo.writeDouble(6.2);

			oo.close();
			
			System.out.println("escrito");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
