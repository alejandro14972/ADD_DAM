package XML_SAX_TEST;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/*
 * Utiliza SAX para visualizar el contenido del fichero del apartado b) del ejercicio anterior.
 */
public class FicheroXMLSAX {

	public static void main(String[] args) {
		leerDoc();
	}

	private static void leerDoc() {
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		SAXParser parser;
		try {
			parser = parserFactory.newSAXParser();
			XMLReader procesadorXML = parser.getXMLReader();

			GestorContenido gestor = new GestorContenido();
			procesadorXML.setContentHandler(gestor);

			InputSource fileXML = new InputSource("ejercicio_1_DAT-XML.xml");

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
