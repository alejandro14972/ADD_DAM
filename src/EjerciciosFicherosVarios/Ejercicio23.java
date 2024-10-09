package EjerciciosFicherosVarios;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio23 {

    public static void main(String[] args) {
      
        File f = new File("leer3.txt");

        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

       
        String texto = "escribir en fichero";

        try {
            FileWriter fw = new FileWriter(f);

            char[] cad = texto.toCharArray();

            for (int i = 0; i < cad.length; i++) {
                fw.write(cad[i]);
            }

            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> save = new ArrayList<String>();

        try {
            FileReader fil = new FileReader(f);

            int n = fil.read();

            
            while (n != -1) {
                char character = (char) n; 
                System.out.print(character); 
                save.add(String.valueOf(character));
                n = fil.read();
            }

            fil.close();

           
            System.out.println("\nContenido del ArrayList:");
            for (String s : save) {
                System.out.print(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
