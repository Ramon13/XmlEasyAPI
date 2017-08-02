package br.com.ramon.xml.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class EscrevendoXmls {

	public static void main(String[] args)throws Exception {
		
		final String url = "xml-test-01.xml";
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(url);
		
		Element rootTag = doc.getDocumentElement();
 		
		Element horarioTag = doc.createElement("horario");
		horarioTag.setAttribute("id", "6");
		rootTag.appendChild(horarioTag);
		
		Element diaSemanaTag = doc.createElement("dia-semana");
		diaSemanaTag.setTextContent("Sábado");
		horarioTag.appendChild(diaSemanaTag);
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		
		DOMSource domSource = new DOMSource(doc);
		try(OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(url), "UTF-8") ){
			StreamResult streamResult = new StreamResult(osw);
			transformer.transform(domSource, streamResult);
		}
		
	}
}





