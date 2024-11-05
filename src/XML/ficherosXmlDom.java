package XML;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
import java.util.Scanner;

public class ficherosXmlDom {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		crearFichero();
		cargarFichero();
	}

	private static void crearFichero() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document document = implementation.createDocument(null, "Empleados", null);
			document.setXmlVersion("1.0");

			Element raiz = document.createElement("empleado");
			document.getDocumentElement().appendChild(raiz);

			crearElement("id", "1", raiz, document);
			System.out.println("Introduzca el apellido del empleado:");
			String apellido = sc.nextLine();
			crearElement("apellido", apellido, raiz, document);

			System.out.println("Introduzca el departamento del empleado:");
			String departamento = sc.nextLine();
			crearElement("departamento", departamento, raiz, document);

			System.out.println("Introduzca el salario del empleado:");
			String salario = sc.nextLine();
			crearElement("salario", salario, raiz, document);

			// Se crea correctamente el DOMSource asociando el documento creado
			Source source = new DOMSource(document);

			try {
				Result res = new StreamResult(new File("empleados.xml"));
				Result res2 = new StreamResult(System.out);

				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				transformer.transform(source, res); // Guarda el archivo
				transformer.transform(source, res2); // Muestra en consola

			} catch (TransformerException e) {
				e.printStackTrace();
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	private static void cargarFichero() {
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = null;
	    try {
	        builder = factory.newDocumentBuilder();
	    } catch (ParserConfigurationException e) {
	        e.printStackTrace();
	    }

	    try {
	        // Carga el archivo XML
	        Document doc = builder.parse(new File("empleados.xml"));
	        System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());

	        // Obtiene la lista de elementos 'empleado' (en lugar de 'empleados')
	        NodeList empleados = doc.getElementsByTagName("empleado");
	        
	        for (int i = 0; i < empleados.getLength(); i++) {
	            Node emple = empleados.item(i);
	            
	            if (emple.getNodeType() == Node.ELEMENT_NODE) {
	                Element elemento = (Element) emple;

	                // Imprime el contenido de los elementos 'id' y 'apellido'
	                System.out.println("ID: " + elemento.getElementsByTagName("id").item(0).getTextContent());
	                System.out.println("Apellido: " + elemento.getElementsByTagName("apellido").item(0).getTextContent());
	                System.out.println("Salario: " + elemento.getElementsByTagName("salario").item(0).getTextContent());
	            }
	        }

	    } catch (SAXException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}


	private static void crearElement(String datoEmple, String valor, Element raiz, Document document) {
		Element elem = document.createElement(datoEmple);
		Text texto = document.createTextNode(valor);
		elem.appendChild(texto); // Corregido: el texto se añade al nuevo elemento, no a la raíz
		raiz.appendChild(elem); // Luego el elemento se añade a la raíz
	}
}
