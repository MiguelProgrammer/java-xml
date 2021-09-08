package br.meuestudo.meuxml.teste;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Sistema {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = fabrica.newDocumentBuilder();
		
		Document documento = builder.parse("src/vendas.xml");
		
		NodeList formasDePagamento = documento.getElementsByTagName("nome");
		Element fdp = (Element) formasDePagamento.item(0);
		String formaPagamento = fdp.getTextContent();
		System.out.println(formaPagamento);
		
	}

}
