package ADD_DAM_APUNTES;

import java.io.Serializable;

public class Estudiante implements Serializable {

	private String nombre;
	private String Apellidos;
	private String DNI;
	
	
	public Estudiante(String nombre, String apellidos, String dNI) {
		super();
		this.nombre = nombre;
		Apellidos = apellidos;
		DNI = dNI;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}


	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", Apellidos=" + Apellidos + ", DNI=" + DNI + "]";
	}
	
	

}
