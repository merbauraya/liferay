package com.idetronic.eprint.admin.data;

import java.io.File;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.ResultSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class EprintXmlBuilder {
	private static Document doc;
	public static String buildXMLBySubject(ResultSet rs) throws Exception
	{
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		Element rootElement = null;
		Element level2 = null;
		Element level3 = null;
		Element level4 = null;
		Element level5 = null;
		Element level6 = null;
		try {
			docBuilder = docFactory.newDocumentBuilder();
			doc = docBuilder.newDocument();
			rootElement = doc.createElement("item");
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		// root elements
		String saveL2 = "";
		String saveL3 = "";
		String saveL4 = "";
		String saveL5 = "";
		String saveL6 = "";
		
		int i = 0;
		while (rs.next())
		{
			if (i == 0) {
				rootElement = createElement(rs.getString("l1_subjectname"),rs.getString("l1_subjectid"),"1","0");
				doc.appendChild(rootElement);
				
			}
			i++;
			if (!saveL2.equalsIgnoreCase(rs.getString("l2_subjectid")))
			{
				if (level2 != null){
					rootElement.appendChild(level2);
					
				}
				level2 = createElement(rs.getString("l2_subjectname"),rs.getString("l2_subjectid"),"2",rs.getString("l2_total"));
				
			}
			if (rs.getString("l3_subjectname") != null)
			{
				if (saveL3 != null && !saveL3.equalsIgnoreCase(rs.getString("l3_subjectid")))
				{
					level3 = createElement(rs.getString("l3_subjectname"),rs.getString("l3_subjectid"),"3",rs.getString("l3_total"));
					level2.appendChild(level3);
				}
	
			}
			if (rs.getString("l4_subjectid") != null)
			{
				if (!saveL4.equalsIgnoreCase(rs.getString("l4_subjectid")))
				{
					level4 = createElement(rs.getString("l4_subjectname"),rs.getString("l4_subjectid"),"4",rs.getString("l4_total"));
					
					level3.appendChild(level4);
				}
				
				
			}
			if (rs.getString("l5_subjectid") != null)
			{
				if (!saveL5.equalsIgnoreCase(rs.getString("l5_subjectid")))
				{
					level5 = createElement(rs.getString("l5_subjectname"),rs.getString("l5_subjectid"),"5",rs.getString("l5_total"));
					level4.appendChild(level5);
				}
			}
			if (rs.getString("l6_subjectid") != null)
			{
				if (!saveL6.equalsIgnoreCase(rs.getString("l6_subjectid")))
				{
					level6 = createElement(rs.getString("l6_subjectname"),rs.getString("l6_subjectid"),"6",rs.getString("l6_total"));
					level5.appendChild(level6);
				}
			}
				
				
			
			saveL2 = (rs.getString("l2_subjectid") == null ? "":rs.getString("l2_subjectid"));
			saveL3 = (rs.getString("l3_subjectid") == null ? "":rs.getString("l3_subjectid"));
			saveL4 = (rs.getString("l4_subjectid") == null ? "":rs.getString("l4_subjectid"));
			saveL5 = (rs.getString("l5_subjectid") == null ? "":rs.getString("l5_subjectid"));
			saveL6 = (rs.getString("l6_subjectid") == null ? "":rs.getString("l6_subjectid"));
		}
		rootElement.appendChild(level2);
		writeXML();
		return getXML();
	}
	private static String getXML() throws Exception
	{
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;
		
		transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		Writer outWriter = new StringWriter();
		StreamResult result = new StreamResult(outWriter);
		
		transformer.transform(source, result);
		return outWriter.toString();
		
		
		
		
		
	}
	private static void writeXML()
	{
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;
		try {
			transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("/home/matle/tmp/gen.xml"));
			
			transformer.transform(source, result);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 
		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);
 
		
	}
	private static Element createElement(String name,String key,String level,String total)
	{
		Element elem = doc.createElement("item");
		setElementAttribute(elem,name,key,level,total);
		return elem;
	}
	private static void setElementAttribute(Element elem,String name,String key,String level,String total)
	{
		Attr attr = doc.createAttribute("name");
		attr.setValue(name);
		elem.setAttribute("name", name);
		elem.setAttribute("key", key);
		elem.setAttribute("level", level);
		elem.setAttribute("total", total);
	}

}
