package XML;

import java.io.Serializable;


/**
 * clase asociada a Ejercicios2XMLAlumnos.java
 */
public class Estudiantes implements Serializable{
    private String nombre;
    private int edad;
    private double nota;

    public Estudiantes(String nombre, int edad, double nota) {
    	super();
        this.nombre = nombre;
        this.edad = edad;
        this.nota = nota;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public double getNota() { return nota; }
    
    

    public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	@Override
    public String toString() {
        return "Alumno [nombre=" + nombre + ", edad=" + edad + ", nota=" + nota + "]";
    }
}

