package br.com.ramon.xml;



import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XmlOutput extends XmlIO {

	
	public XmlOutput(String pathFile, XmlIO.FileOperation fileOperation) {
		super(pathFile, fileOperation);
		// TODO Auto-generated constructor stub
	}
	
	
	public void createRootTagElement(String rootTagName){
		Element rootTagElement = document.createElement(rootTagName);
		document.appendChild(rootTagElement);
		transformXml();
	}

	public void createElementUnderRootTag(int elementId, String elementName){
		Element element = document.createElement(elementName);
		element.setAttribute("id", String.valueOf(elementId));
		rootTag.appendChild(element);
		
		
		transformXml();
	}
	
	public void createElementUnderRootTag(int elementId, String elementName, String content){
		Element element = document.createElement(elementName);
		element.setAttribute("id", String.valueOf(elementId));
		element.setTextContent(content);
		rootTag.appendChild(element);
		
		
		transformXml();
	}
	
	
	public void createElement(int idNode, String elementName , String... tagNames){
		
		Element element = getNodeById(idNode, tagNames);
		Element newElement = document.createElement(elementName);
		element.appendChild(newElement);
		transformXml();
	}
	
	public void setTextContent(String textContent, int idNode, String... tagNames){
		Element element = getNodeById(idNode, tagNames);
		element.setTextContent(textContent);
		transformXml();
	}
}



