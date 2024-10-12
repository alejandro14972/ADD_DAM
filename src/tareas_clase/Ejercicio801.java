package tareas_clase;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio801 {

	public static void main(String[] args) {
		File f4 = new File("entrada801.dat");
		estadisticaLeer(f4);
	}
		
	private static void estadisticaLeer(File f4) {
		int numAlumnos = 0;
		double mediaEdad=0;
		int maxEdad = 0, minEdad = 0;
		int sumEdades=0;
		int aux = 0;
	
		ArrayList<Integer> edalm = new ArrayList<>(); 
		
		
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream(f4));
			
		    while (true) {
		        try {
		            int n = dis.readInt();
		            aux = aux + 1;
		            edalm.add(n);
		        
		        } catch (EOFException e) {
		            
		            System.out.print("");
		            break;
		        }
		    }
		    
		    
		   
		    
		  //aqui ya puedo trabajar con los datos en un array:
		    totalAlumnos(aux);
		    ordenarEdades(edalm);
		    mostraralumnosMenoresEdad(edalm);  
		    masyminEdad(edalm, maxEdad, minEdad);
		    mediaEdadAlumno(edalm, aux, mediaEdad);
		    desviacionEdad(edalm, mediaEdad); 
		    
		} catch (IOException e) {
		    e.printStackTrace();
		}
	
	}
	
	private static void desviacionEdad(ArrayList<Integer> edalm, double mediaEdad) {
		  ArrayList<Double> desviacion = new ArrayList<>(); 
		    
		    for (int i = 0; i < edalm.size(); i++) {
				desviacion.add(((edalm.get(i) - mediaEdad) * (edalm.get(i) - mediaEdad)));
			}
		    
		    double sumadesviacion=0;
		    for (int i = 0; i < desviacion.size(); i++) {
				 sumadesviacion += desviacion.get(i);
			}
		    
		    double mediadesviacion = sumadesviacion / desviacion.size();
		    
		    System.out.println("Desviación: " + Math.sqrt(mediadesviacion));
		
	}


	private static void mediaEdadAlumno(ArrayList<Integer> edalm, int aux, double mediaEdad) {
		
		int sumatotal=0;
		
	    for (int i = 0; i < edalm.size(); i++) {
			 sumatotal += edalm.get(i);
		}
	    
	    mediaEdad = sumatotal / aux;
	    System.out.println("Media edad es: " + mediaEdad);
		
		
		
	}


	private static void masyminEdad(ArrayList<Integer> edalm, int maxEdad, int minEdad) {
		maxEdad = Collections.max(edalm);
	    minEdad = Collections.min(edalm);
	    
	    System.out.println("El alumno con mayor edad tiene: "+ maxEdad );
	    System.out.println("El alumno con menos edad tiene: "+ minEdad);
		
	}


	private static void mostraralumnosMenoresEdad(ArrayList<Integer> edalm) {
		
		   int aux2= 0;
		    for (Integer ed : edalm) {
				if (ed < 18) {
					aux2+=1;
				}
			}
		    System.out.println("\nHay " + aux2 + " alumnos menores de edad.");
		
	}


	private static void ordenarEdades(ArrayList<Integer> edalm) {
		
		 Collections.sort(edalm);
		 
		 System.out.println("Mostrar edades ordenadas: ");
		 
		    for (int i = 0; i < edalm.size(); i++) {
				 System.out.print(edalm.get(i) + " - ");
			}		
	}

	private static void totalAlumnos(int a) {
		System.out.println("El total de alumnos es de: " + a);
	}
	
	private static void metodoObjectOutputStream(File f4) {
		// TODO Auto-generated method stub
		// escribir
		try {
			ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(f4));

			int edades[] = {20, 30, 40, 50};
			
			oo.writeObject(edades);

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
