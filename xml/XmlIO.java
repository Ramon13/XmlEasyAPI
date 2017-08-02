package br.com.ramon.xml;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlIO {
	
	public static enum FileOperation {CREATE_XML_FILE, PARSE_XML_FILE};
	
	private DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	private DocumentBuilder documentBuilder;
	public org.w3c.dom.Document document;
	public org.w3c.dom.Element rootTag;
	public String pathFile;
	
	public XmlIO(String pathFile, XmlIO.FileOperation fileOperation){
		this.pathFile = pathFile;
		try {
			documentBuilder = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		}
		
		if(fileOperation == FileOperation.CREATE_XML_FILE){
			try {
				createANewXmlFile();
			} catch (SAXException | IOException e) {
				e.printStackTrace();
			}
		}
		
		if(fileOperation == FileOperation.PARSE_XML_FILE){
			try {
				parseAExistingXmlFile();
			} catch (SAXException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	}
	
	public void createANewXmlFile() throws SAXException, IOException{
		document = documentBuilder.newDocument();
		rootTag = document.getDocumentElement();
	}
	
	public void parseAExistingXmlFile() throws SAXException, IOException{
		document = documentBuilder.parse(new File(pathFile));
		rootTag = document.getDocumentElement();
	}
	
	
	public void transformXml(){
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer;
		try {
			transformer = tf.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			
			DOMSource domSource = new DOMSource(document);
			try(OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(pathFile), "UTF-8") ){
				StreamResult streamResult = new StreamResult(osw);
				transformer.transform(domSource, streamResult);
			} 
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch(UnsupportedEncodingException e){
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	
	public Element getNodeById(int idNode, String... tagNames){
		NodeList listElements = rootTag.getElementsByTagName(tagNames[0]);
		
		for(int i = 0 ; i < listElements.getLength() ; i++){
			Element element = (Element) listElements.item(i);
			String idTag = element.getAttribute("id");
			
			if(Integer.valueOf(idTag) == idNode){
				for(int j = 0 ; j < tagNames.length ; j++){
					if(j == (tagNames.length - 1)){
						String s  = tagNames[j];
						Element e = (Element) element.getElementsByTagName(s);
						return e;
					}
				}	
			}
			
		}
		
		return null;
	}
	
	
	public void test (){
		
	}
	
	
}
