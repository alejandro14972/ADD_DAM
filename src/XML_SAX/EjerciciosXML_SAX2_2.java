package XML_SAX;
import java.io.IOException;
import java.util.ArrayList;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/*
 * Ejercicio 2: Lectura de un archivo XML simple usando SAX
 * Usa SAX para leer el archivo y mostrar solo los nombres de los 
 * empleados que pertenecen al departamento de "Ventas", 
 * calcula la media de sus edades y muestra por pantalla cuel es esta
 */
public class EjerciciosXML_SAX2_2 {

	public static void main(String[] args) {
		leerDoc();
	}

	private static void leerDoc() {
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		SAXParser parser;
		try {
			parser = parserFactory.newSAXParser();
			XMLReader procesadorXML = parser.getXMLReader();

			GestorContenidoXMLSAX2_2 gestor = new GestorContenidoXMLSAX2_2();
			procesadorXML.setContentHandler(gestor);

			InputSource fileXML = new InputSource("./ficherosEjerciciosxml/empleados.xml");
			
			ArrayList<Integer> edades = gestor.getEdadesventas();
			System.out.println(edades);
			
			double sumEdades = 0;
			
			for (int i = 0; i < edades.size(); i++) {
				sumEdades+= edades.get(i);
			}
			
			System.out.println(sumEdades);
			
			try {
				procesadorXML.parse(fileXML);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
