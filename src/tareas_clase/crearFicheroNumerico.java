package tareas_clase;

import java.io.*;

public class crearFicheroNumerico {

	public static void main(String[] args) {
		
		
		FileOutputStream ficha;
		try {
			ficha = new FileOutputStream("entrada801.dat");
			DataOutputStream flujo = new DataOutputStream(ficha);
			
			try {
				flujo.writeInt(18);
				flujo.writeInt(19);
				flujo.writeInt(21);
				flujo.writeInt(20);
				flujo.writeInt(28);
				flujo.writeInt(18);
				flujo.writeInt(20);
				flujo.writeInt(21);
				flujo.writeInt(21);
				flujo.writeInt(22);
				flujo.writeInt(24);
				flujo.writeInt(19);
				flujo.writeInt(18);
				flujo.writeInt(21);
				flujo.writeInt(28);
				
				flujo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
