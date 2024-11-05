package XML;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class Ejercicios2XMLAlumnos {

	public static void main(String[] args) {
		ArrayList<Estudiantes> estudiante = cargarFicheroEstudiantes();
		crearDocumentoEstudiantesnotas(estudiante);
	}


	private static void crearDocumentoEstudiantesnotas(ArrayList<Estudiantes> estudiantes) {
		File archivo = new File("C:\\Users\\aleja\\eclipse-workspace\\ADD_DAM\\ficherosEjerciciosxml\\alumnosClasificado.xml");
		DocumentBuilderFactory dbFatory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbuBuilder;
		
		try {
			dbuBuilder = dbFatory.newDocumentBuilder();
			Document doc = dbuBuilder.newDocument();
			
			Element rootElement = doc.createElement("notas"); //elemnto root
			doc.appendChild(rootElement);
			
			ArrayList<Estudiantes> suspensos = new ArrayList<Estudiantes>();
			ArrayList<Estudiantes> aprobados = new ArrayList<Estudiantes>();
			ArrayList<Estudiantes> notables = new ArrayList<Estudiantes>();
			ArrayList<Estudiantes> sobresalientes = new ArrayList<Estudiantes>();
			
			for(Estudiantes estudiante : estudiantes ) {

				if (estudiante.getNota() <5) {
					suspensos.add(estudiante);
				}else if(estudiante.getNota() <7) {
					aprobados.add(estudiante);
				}else if(estudiante.getNota()<9) {
					notables.add(estudiante);
				}else {
					sobresalientes.add(estudiante);
				}
			}
				
				crearElement(doc, rootElement, "suspensos", suspensos);
				crearElement(doc, rootElement, "aprobados", aprobados);
				crearElement(doc, rootElement, "notables", notables);
				crearElement(doc, rootElement, "sobresalientes", sobresalientes);
				
			
			TransformerFactory transfac = TransformerFactory.newInstance();
			try {
				Transformer transformer = transfac.newTransformer();
				
				DOMSource source = new DOMSource();
				StreamResult result = new StreamResult(archivo);
				
				try {
					transformer.transform(source, result);
				} catch (TransformerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}



	private static ArrayList<Estudiantes> cargarFicheroEstudiantes() {
		// TODO Auto-generated method stub
		ArrayList<Estudiantes> estudiantes = new ArrayList<Estudiantes>(); //almacenamiento
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = null;
	    try {
	        builder = factory.newDocumentBuilder();
	    } catch (ParserConfigurationException e) {
	        e.printStackTrace();
	    }

	    try {
	        Document doc = builder.parse(new File("C:\\Users\\aleja\\eclipse-workspace\\ADD_DAM\\ficherosEjerciciosxml\\alumnos.xml"));
	        //System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());

	        NodeList alumno = doc.getElementsByTagName("alumno");
	        for (int i = 0; i < alumno.getLength(); i++) {
	            Node alumn = alumno.item(i);
	            
	            if (alumn.getNodeType() == Node.ELEMENT_NODE) {
	                Element elemento = (Element) alumn;
	                
	                String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
	                System.out.println("Nombre: " + nombre);
	                int edad = Integer.parseInt(elemento.getElementsByTagName("edad").item(0).getTextContent());
	                System.out.println("Edad: " + edad);
	                double nota = Double.parseDouble(elemento.getElementsByTagName("nota").item(0).getTextContent());
	                System.out.println("nota: " + nota);
	                
	                estudiantes.add(new Estudiantes(nombre, edad, nota));
	                
	            }
	        }
	        System.out.println(estudiantes.size());
	        return estudiantes;

	    } catch (SAXException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return estudiantes;
		
	}
	
	private static void crearElement(Document doc, Element root, String categoria, ArrayList<Estudiantes> estudiante) {
		Element category = doc.createElement(categoria);
		root.appendChild(category);
		Element numero = doc.createElement("numero");
		Text text = doc.createTextNode(String.valueOf(estudiante.size()));
		numero.appendChild(text);
		category.appendChild(numero);
		
		Element listEstudiante = doc.createElement("alumnos");
		category.appendChild(listEstudiante);
		
		for (Estudiantes estu : estudiante) {
			Element elementoAlumno = doc.createElement("alumno");
			Text textoNombre = doc.createTextNode(estu.getNombre());
			elementoAlumno.appendChild(textoNombre);
			listEstudiante.appendChild(elementoAlumno);
		}
		
	}
	
	

}
