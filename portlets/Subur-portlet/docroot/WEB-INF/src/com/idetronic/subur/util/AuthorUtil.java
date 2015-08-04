package com.idetronic.subur.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.idetronic.subur.model.impl.SuburItemImpl;
import com.liferay.portal.kernel.io.unsync.UnsyncStringWriter;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;

public class AuthorUtil {
	
	private static Log logger = LogFactoryUtil.getLog(AuthorUtil.class);
	
	/**
	 * Return author category/VocabularyId map based on xml stored in portlet preferences
	 * @param categoryXML
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static Map<String,Long> getAuthorCategories(String categoryXML) throws ParserConfigurationException, SAXException, IOException
	{
		logger.info(categoryXML);
		if (categoryXML == null ||  categoryXML.isEmpty())
			return null;
		Document doc = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = dbf.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(categoryXML));
		
		doc = docBuilder.parse(is);
		Element docElements = doc.getDocumentElement();
		
		NodeList categoryNodes = docElements.getElementsByTagName("category");//.item(0).getChildNodes();
		
		Map<String,Long> categoryMap = null;
		if (categoryNodes != null && categoryNodes.getLength() > 0)
		{
			categoryMap = new HashMap<String,Long>();
			for (int i=0; i < categoryNodes.getLength();i++)
			{
				Node node = categoryNodes.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE)
				{
					Element eElement = (Element) node;
					String categoryName = eElement.getElementsByTagName("name").item(0).getTextContent();
					String vocabularyId = eElement.getElementsByTagName("vocabularyId").item(0).getTextContent();
					categoryMap.put(categoryName, Long.parseLong(vocabularyId));
					logger.info(vocabularyId);
				}
				
				
				
			}
		
			
		}
		
		

		
		
		return categoryMap;
		
	}
	public static String getAuthorCategoryString(Map<String,Long> categoryMap) throws Exception
	{
		String xml = StringPool.BLANK;
		XMLStreamWriter xmlStreamWriter = null;
		
		UnsyncStringWriter unsyncStringWriter = new UnsyncStringWriter();
		XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
		
		try {
			xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(
					unsyncStringWriter);
			xmlStreamWriter.writeStartDocument();
			xmlStreamWriter.writeStartElement("root");
			
			
			
			xmlStreamWriter.writeStartElement("categories");
			if (categoryMap != null && categoryMap.size() > 0)
			{
				for (Map.Entry<String,Long> entry : categoryMap.entrySet()) {
					xmlStreamWriter.writeStartElement("category");
					
					xmlStreamWriter.writeStartElement("name");
				    xmlStreamWriter.writeCharacters(entry.getKey());
				    xmlStreamWriter.writeEndElement();
					
				    xmlStreamWriter.writeStartElement("vocabularyId");
				    xmlStreamWriter.writeCharacters(String.valueOf(entry.getValue()));
				    xmlStreamWriter.writeEndElement();
					
				    
				  
				    xmlStreamWriter.writeEndElement();
				}
		
			}
			xmlStreamWriter.writeEndElement();//categories
			
			xmlStreamWriter.writeEndElement(); //root
			xml = unsyncStringWriter.toString();
			
		} catch (XMLStreamException e) {
			logger.error(e);
			throw new Exception(e);
		}
		
		
		return xml;
	}

}
