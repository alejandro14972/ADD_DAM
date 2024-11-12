package XML_EJERCICIO_1;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * 
 * a) Crea un fichero "FichPersona.dat”, que almacene varios objetos persona.	
 * 
 */

public class Ejercicio1_DAT {

	public static void main(String[] args) {
		File d = new File("C:\\Users\\aleja\\eclipse-workspace\\ADD_DAM\\ficheros");
		File f4 = new File(d, "ejercicio_1_DAT-XML.dat");

		ArrayList<Object> personas = new ArrayList<Object>();

		Persona[] personaArray = { new Persona("Alejandro", "1107545C", 654654765, 26),
				new Persona("Juan", "1104545C", 654654765, 25), new Persona("Alberto", "1123545C", 65465365, 26),
				new Persona("María", "1167545C", 654654765, 20) };
		
		for (int i = 0; i < personaArray.length; i++) {
			personas.add(personaArray[i]);
		}
		
		escribirDocumento(f4, personas);
	}

	
	private static void escribirDocumento(File f4, ArrayList<Object> personas) {
		try {
			ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(f4));

			for (int i = 0; i < personas.size(); i++) {
				oo.writeObject(personas.get(i));
			}

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
