package XML_SAX;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * archivo asociado a FicheroXMLSAX.java
 */

public class GestorContenidoXMLSAX2_2 extends DefaultHandler {

	private boolean esDepartamento;
	private boolean esDepartamentoVentas;
	private boolean esNombre;
	private boolean esEdad;
	private String nombre;
	private String departamento;
	private int edad;
	
	ArrayList<Integer> edadesventas = new ArrayList<Integer>();
	

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("departamento")) {
			esDepartamento = true;
		} else if (qName.equalsIgnoreCase("nombre")) {
			esNombre = true;
		} else if (qName.equalsIgnoreCase("edad")) {
			esEdad = true;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (esNombre) {
			nombre = new String(ch, start, length);
			esNombre = false;
		} else if (esEdad) {
			edad = Integer.parseInt(new String(ch, start, length));
			esEdad = false;
		} else if (esDepartamento) {
			departamento = new String(ch, start, length).trim();
			if (departamento.equalsIgnoreCase("Ventas")) {
				esDepartamentoVentas = true;
			}
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if (qName.equalsIgnoreCase("departamento")) {
			if (esDepartamentoVentas) {
				System.out.println("Empleado: " + nombre);
				System.out.println("Departamento: " + departamento);
				System.out.println("Edad: " + edad);
				edadesventas.add(edad);
				esDepartamentoVentas =  false;
			}
		}
	}

	public boolean isEsDepartamento() {
		return esDepartamento;
	}

	public void setEsDepartamento(boolean esDepartamento) {
		this.esDepartamento = esDepartamento;
	}

	public boolean isEsDepartamentoVentas() {
		return esDepartamentoVentas;
	}

	public void setEsDepartamentoVentas(boolean esDepartamentoVentas) {
		this.esDepartamentoVentas = esDepartamentoVentas;
	}

	public boolean isEsNombre() {
		return esNombre;
	}

	public void setEsNombre(boolean esNombre) {
		this.esNombre = esNombre;
	}

	public boolean isEsEdad() {
		return esEdad;
	}

	public void setEsEdad(boolean esEdad) {
		this.esEdad = esEdad;
	}

	public String getNombre() {
		return nombre;
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

	public ArrayList<Integer> getEdadesventas() {
		return edadesventas;
	}

	public void setEdadesventas(ArrayList<Integer> edadesventas) {
		this.edadesventas = edadesventas;
	}

}
