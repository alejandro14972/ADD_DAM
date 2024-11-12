package XML_EJERCICIO_1;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


/*
 * b) Tomando como base el fichero anterior, crea un documento XML usando DOM.
 */

public class Ejercicio1_XML {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		File d = new File("C:\\Users\\aleja\\eclipse-workspace\\ADD_DAM\\ficheros");
		File f4 = new File(d, "ejercicio_1_DAT-XML.dat");
		leerDAT(f4);

	}

	private static void leerDAT(File f4) {

		ArrayList<Object> datos = new ArrayList<Object>();

		try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(f4))) {

			Persona p = null;

			while (true) {
				try {
					p = (Persona) oi.readObject();
					datos.add(p); // ALMACENAR DATOS EN EL ARRAYLIST
					// System.out.println(p.toString());
				} catch (EOFException e) {
					System.out.println("No hay más objetos en el archivo.");
					break;
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * for (int i = 0; i < datos.size(); i++) { Persona persona = (Persona)
		 * datos.get(i); System.out.println(persona.getNombre()); }
		 */

		crearFichero(datos);

	}

	private static void crearFichero(ArrayList<Object> datos) {
		File d = new File("C:\\Users\\aleja\\eclipse-workspace\\ADD_DAM\\ficheros");
		File f = new File(d, "ejercicio_1_DAT-XML.xml");

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document document = implementation.createDocument(null, "Personas", null);
			document.setXmlVersion("1.0");

			for (int i = 0; i < datos.size(); i++) {
				Persona p = (Persona) datos.get(i); //ANOTAR ESTO PARA FUTUROS EJERCICIOS
				
				Element raiz = document.createElement("persona");
				document.getDocumentElement().appendChild(raiz);

				crearElement("nombre", p.getNombre(), raiz, document);
				crearElement("dni", p.getDni(), raiz, document);
				crearElement("telefono", String.valueOf(p.getTelefono()), raiz, document);
				crearElement("edad", String.valueOf(p.getEdad()), raiz, document);
			}

			Source source = new DOMSource(document);

			try {
				Result res = new StreamResult(f);

				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				transformer.transform(source, res);

			} catch (TransformerException e) {
				e.printStackTrace();
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

	}

	private static void crearElement(String datoEmple, String valor, Element raiz, Document document) {
		Element elem = document.createElement(datoEmple);
		Text texto = document.createTextNode(valor);
		elem.appendChild(texto);
		raiz.appendChild(elem);
	}

}
