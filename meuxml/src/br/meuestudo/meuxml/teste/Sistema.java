package br.meuestudo.meuxml.teste;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.meuestudo.meuxml.model.Produto;

public class Sistema {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		
		/*
		 * Validação XML
		 */
		
		fabrica.setValidating(true);
		fabrica.setNamespaceAware(true);
		fabrica.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		
		DocumentBuilder builder = fabrica.newDocumentBuilder();
		
		Document documento = builder.parse("src/vendas.xml");
		Element tipoDinheiro = documento.getDocumentElement();

		NodeList produtos = documento.getElementsByTagName("produto");

		for (int i = 0; i < produtos.getLength(); i++) {

			Element produto = (Element) produtos.item(i);
			String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
			Double preco = Double.parseDouble(produto.getElementsByTagName("preco").item(0).getTextContent());
			
			Produto item = new Produto(nome, preco);
			System.out.println(item.toString() +" - "+ tipoDinheiro.getAttribute("moeda"));
		}
		
	}

}
