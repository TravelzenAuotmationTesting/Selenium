package com.selemium.utility;

import java.io.File;
import java.util.List;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

public class XmlIO {
	
	public Element getRoot(String xmlPath) {
		SAXReader reader = new SAXReader();
		File file = new File(xmlPath);
		Document document = null;
		try {
			document = reader.read(file);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element root = document.getRootElement();
		return root;
	}

	public List<Element> getElements(Element element, String nodeName) {
		@SuppressWarnings("unchecked")
		List<Element> nodes = element.elements(nodeName);
		return nodes;
	}

	public Element getElementById(List<Element> elements, String ID) {
		Element element = null;
		for (Element subElement : elements) {
			if (subElement.attribute("id").getText().equals(ID)) {
				element = subElement;
				break;
			}
		}
		return element;
	}
}
