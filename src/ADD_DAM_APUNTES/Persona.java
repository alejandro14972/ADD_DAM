package ADD_DAM_APUNTES;

import java.io.Serializable;

public class Persona implements Serializable /*guardar en bytes*/ {

	private String nombre;
	private int edad;
	private boolean carnet;

	public String getNombre() {
		return nombre;
	}

	public Persona(String nombre, int edad, boolean carnet) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.carnet = carnet;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isCarnet() {
		return carnet;
	}

	public void setCarnet(boolean carnet) {
		this.carnet = carnet;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", carnet=" + carnet + "]";
	}

}
