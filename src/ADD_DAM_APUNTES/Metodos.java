package ADD_DAM_APUNTES;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Metodos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File f = new File("metodos.txt");
		File f2 = new File("metodos.dat");
		File f3 = new File("datos.dat");
		File f4 = new File("datosObject.dat");

		// metodosFile(f);
		// metodosFileWriter(f);
		// metodosFileReader(f);
		// metodosBufferRead(f);
		// metodosBufferWritter(f);
		// metodoFileOutputStream(f2);
		// metodoFileInputStream(f2);
		// metodoDataOutputStream(f3);
		// metodoDataInputStream(f3);
		// metodoObjectOutputStream(f4);
		// metodoObjectInputStream(f4);
	}
	
	//métodos de objetos
	private static void metodoObjectInputStream(File f4) {
	    // TODO Auto-generated method stub

	    try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(f4))) {
	        
	        Persona p;
	        
	        while (true) {
	            try {
	                // Intentamos leer el objeto
	                p = (Persona) oi.readObject();
	                System.out.println(p.toString());
	            } catch (EOFException e) {
	                // Se alcanza el final del archivo
	                System.out.println("No hay más objetos en el archivo.");
	                break;  // Rompemos el ciclo al final del archivo
	            } catch (ClassNotFoundException e) {
	                // Si la clase no es encontrada
	                e.printStackTrace();
	            }
	        }

	    } catch (FileNotFoundException e) {
	        // Si no se encuentra el archivo
	        e.printStackTrace();
	    } catch (IOException e) {
	        // Cualquier otra excepción de I/O
	        e.printStackTrace();
	    }
	}

	private static void metodoObjectOutputStream(File f4) {
		// TODO Auto-generated method stub
		// escribir
		try {
			ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(f4));

			Persona p = new Persona("Alex", 20, true);
			oo.writeObject(p);

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

	// metodos para datos primitivos
	private static void metodoDataInputStream(File f3) {

		try {
			DataInputStream dis = new DataInputStream(new FileInputStream(f3));

			while (true) {
				String s = dis.readUTF();
				int n = dis.readInt();
				System.out.println("Nombre: " + s + " Edad: " + n);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Fin");
		}

	}

	private static void metodoDataOutputStream(File f3) {
		// TODO Auto-generated method stub
		String[] nombres = { "Alex", "Juan" };
		int[] edades = { 2, 4 };

		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(f3));

			for (int i = 0; i < edades.length; i++) {
				dos.writeUTF(nombres[i]);
				dos.writeInt(edades[i]);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Flujos de 8 bits
	private static void metodoFileOutputStream(File f2) {
		// TODO Auto-generated method stub

		try {
			FileOutputStream fo = new FileOutputStream(f2);
			f2.createNewFile();
			for (int i = 0; i < 10; i++) {
				fo.write(i);
			}
			fo.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void metodoFileInputStream(File f2) {
		// TODO Auto-generated method stub
		try {
			FileInputStream fi = new FileInputStream(f2);

			int i;
			while ((i = fi.read()) != -1) {
				System.out.println(i);
			}
			fi.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/// Flujos de 16bits
	private static void metodosBufferWritter(File f) {

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write("Buffer String");
			bw.newLine();
			bw.write("mas Buffer");
			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void metodosFile(File f) {

		System.out.println(f.canWrite());
		System.out.println(f.canRead());

		try {
			System.out.println(f.createNewFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void metodosFileWriter(File f) {

		try {
			FileWriter fo = new FileWriter(f);
			fo.write("ESCRIBIENDO FILE WRITER()");
			fo.append("Finalizado...");
			fo.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void metodosFileReader(File f) {
		try {
			FileReader fr = new FileReader(f);

			int n;

			while ((n = fr.read()) != -1) {
				System.out.print((char) n);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void metodosBufferRead(File f) {

		try {
			BufferedReader br = new BufferedReader(new FileReader(f));

			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
