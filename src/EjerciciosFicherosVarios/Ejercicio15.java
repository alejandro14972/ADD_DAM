package EjerciciosFicherosVarios;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ejercicio15 {

    public static void main(String[] args) {
       
        File f = new File("C:\\Users\\aleja\\eclipse-workspace\\AADD_EJERCICIO1\\Directorio\\teclado.txt");

   
        SimpleDateFormat objeto = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

  
        long ultModific = f.lastModified();
        

       
        System.out.println(ultModific);

        
        System.out.println("Última modificación: " + objeto.format(new Date(ultModific)));
    }
}
