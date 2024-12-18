package XML_EJERCICIO_1;

import java.io.Serializable;

/*
 * calse asociada a Ejercicio1_DAT.java
 */
public class Persona implements Serializable{
	
	
	String nombre;
	String dni;
	int telefono;
	int edad;
	
	
	public Persona(String nombre, String dni, int telefono, int edad) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
		this.edad = edad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", dni=" + dni + ", telefono=" + telefono + ", edad=" + edad + "]";
	}
	
	


	
	
	
	
	
	
	
	
	
	

}
