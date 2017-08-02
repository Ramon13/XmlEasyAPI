package br.com.ramon.xml;

import java.util.Arrays;

import org.w3c.dom.Element;

import org.w3c.dom.NodeList;

public class XmlInput extends XmlIO {

	public XmlInput(String pathFile, XmlIO.FileOperation fileOperation) {
		super(pathFile, fileOperation);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Retorna o conteúdo em forma de string do ultimo
	 * nó especificado no varargs
	 * 	@param id Id do nó abaixo da raiz no xml
	 * 	@param tagNames array de nós do xml a ser percorrido
	 * 	@return Retorna o valor do ultimo nó especificado no array "tagNames"
	**/
	public String getElementByTagName(int id, String... tagNames){
	
		NodeList listElements = rootTag.getElementsByTagName(tagNames[0]);
		
		for(int i = 0 ; i < listElements.getLength() ; i++){
			Element element = (Element) listElements.item(i);
			String idTag = element.getAttribute("id");
			
			if(Integer.valueOf(idTag) == id){
				for(int j = 0 ; j < tagNames.length ; j++){
					if(j == (tagNames.length - 1)){
						System.out.println(j + " " + tagNames.length);
						String[] s = element.getElementsByTagName(tagNames[j]).item(0).getTextContent().trim().split("\n");
						return s[0];
					}
				}	
			}
			
		}
		
		return null;
	}
	
	public String[] getElementByTagName2(int id, String tagName){
		NodeList listElements = rootTag.getElementsByTagName(tagName);

		for(int i = 0 ; i < listElements.getLength() ; i++){
			Element element = (Element) listElements.item(i);
			String idTag = element.getAttribute("id");
			
//			if(Integer.valueOf(idTag) == id){
//				String s[] = element.getTextContent().split("\n");
//				for (int j = 0; j < s.length; j++) {
//					s[j] = s[j].trim();
//				}
//				return s;	
//			}
			String s[] = element.getTextContent().split("\n");
			for (int j = 0; j < s.length; j++) {
				s[j] = s[j].trim();
			}
			
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		//XmlInput xmlInput = new XmlInput("xml-test-01.xml");
		XmlOutput xmlOutput = new XmlOutput("xml-test-01.xml", XmlIO.FileOperation.CREATE_XML_FILE);
		
		xmlOutput.createRootTagElement("horarios");
		
	}
	
	
	
}




