package br.com.ramon.xml.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class LendoXmls {

	public static void main(String[] args)throws Exception {
		
		List<Horarios> segundaHorarios = new ArrayList<>();
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(new File("xml-test-01.xml"));
		
		Element rootTag = doc.getDocumentElement();
		NodeList horarioNodeList = rootTag.getElementsByTagName("horario");
		
		for(int i = 0 ; i < horarioNodeList.getLength() ; i++){
			Element horarioTag = (Element) horarioNodeList.item(i);
			
			String diaSemana = horarioTag.getElementsByTagName("dia-semana").item(0).getTextContent();
			if(diaSemana.equals("Segunda")){
				String horarioInicio = horarioTag.getElementsByTagName("horario-inicio").item(0).getTextContent();
				String horarioFim = horarioTag.getElementsByTagName("horario-fim").item(0).getTextContent();
				segundaHorarios.add(new Horarios(diaSemana, horarioInicio, horarioFim));
			}
		}
		
		for(Horarios h : segundaHorarios){
			System.out.println(h.toString());
		}
		
	}
}










