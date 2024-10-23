package XML;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ejercicio1_LEERXML {

	public static void main(String[] args) {
		
		File d = new File("C:\\Users\\aleja\\eclipse-workspace\\ADD_DAM\\ficheros");
		File f = new File(d, "ejercicio_1_DAT-XML.xml");
		
		 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder builder = null;
		    try {
		        builder = factory.newDocumentBuilder();
		    } catch (ParserConfigurationException e) {
		        e.printStackTrace();
		    }

		    try {
		        
		        Document doc = builder.parse(f);
		        System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());

	
		        NodeList personas = doc.getElementsByTagName("persona");
		        
		        for (int i = 0; i < personas.getLength(); i++) {
		            Node person = personas.item(i);
		            
		            if (person.getNodeType() == Node.ELEMENT_NODE) {
		                Element elemento = (Element) person;

		     
		                System.out.print("Nombre: " + elemento.getElementsByTagName("nombre").item(0).getTextContent() +" ");
		                System.out.print("DNI: " + elemento.getElementsByTagName("dni").item(0).getTextContent()+ " ");
		                System.out.print("Teléfono: " + elemento.getElementsByTagName("telefono").item(0).getTextContent()+ " ");
		                System.out.print("Edad: " + elemento.getElementsByTagName("edad").item(0).getTextContent()+" ");
		                
		                
		            }
		            System.out.println();
		        }

		    } catch (SAXException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }

	}

}
