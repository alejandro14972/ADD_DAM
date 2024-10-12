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
import java.io.RandomAccessFile;
import java.util.Scanner;

public class MetodosV2 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File d = new File("C:\\Users\\aleja\\eclipse-workspace\\ADD_DAM\\ficheros");
		File f = new File(d, "metodos.txt");
		File f2 = new File(d,"metodos.dat");
		File f3 = new File(d,"datos.dat");
		File f4 = new File(d,"datosObject.dat");
		File f5 = new File("ficheroaleat.dat");

		//metodosFile(f);
		//metodosFileWriter(f);
		//metodosFileReader(f);
		//metodosBufferWritter(f);
		//metodosBufferRead(f);
		//metodoFileOutputStream(f2);
		//metodoFileInputStream(f2);
		//metodoDataOutputStream(f3);
		//metodoDataInputStream(f3);
		//metodoObjectOutputStream(f4);
		//metodoObjectInputStream(f4);
		//metodoAccesoAleatorioEscribir(f5);
		//mostrarFichero(f5);
		//pasarPosicion(f5);
		//pasarPosicionEscribir(f5);
	}
	
	private static void pasarPosicionEscribir(File f5) {
		int num = 0;
		try {
			RandomAccessFile ra = new RandomAccessFile(f5, "rw");
			
			System.out.println("dime posicion");
			num = sc.nextInt();
			num = (num -1)*4;
			ra.seek(num);
			
			
			System.out.println("reescribir dato");
			int num2 = sc.nextInt();
			ra.writeInt(num2);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void pasarPosicion(File f5) {
		int num = 0;
		try {
			RandomAccessFile ra = new RandomAccessFile(f5, "rw");

			do {
			System.out.println("dime posicion");
			num = sc.nextInt();
			
			if (num==0) {
				System.out.println("Saliendo...");
				break;
			}
			
			num = (num -1)*4;
			ra.seek(num);
			
			System.out.println(ra.readInt());
		
			
			}while (true);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void mostrarFichero(File f) {
		
		int num = 0;
		try {

			RandomAccessFile ra = new RandomAccessFile(f, "rw");

			System.out.println("cuanto pesa mi fichero: " + ra.length());
			ra.seek(0);
			
			while (ra.getFilePointer()<ra.length()) {
				num= ra.readInt();
				System.out.println(num);
			}

		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//metodos aleatorios
	private static void metodoAccesoAleatorioEscribir(File f5) {
		
		try {

			RandomAccessFile ra = new RandomAccessFile(f5, "rw");

			ra.seek(0);
			int num=1;
			while (num!=0) {
				System.out.println("Dame un numero: 0 terminar");
				 num = sc.nextInt();
				 if (num!=0) {
					 ra.writeInt(num);	
				}
				 		
			}
			ra.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
			fo.write("\n");
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
