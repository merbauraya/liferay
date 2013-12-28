package com.idetronic.portlet;

import com.liferay.portal.kernel.util.HttpUtil;

import java.io.IOException;
import java.net.URL;
  
import java.util.Enumeration;
import java.util.Hashtable;

import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncStringReader;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XslTransformer {
	public static String transform(String xmlSource,String xslSource)
			throws TransformerConfigurationException, TransformerException

	{
		String output ="";
		TransformerFactory factory = TransformerFactory.newInstance();
		StreamSource xslStream = new StreamSource(xslSource);
		Transformer transformer = factory.newTransformer(xslStream);
		
		StreamSource in = new StreamSource(xmlSource);
		StreamResult out = new StreamResult(output);
		transformer.transform(in,out);
		return out.toString();
		
		
	}
	
	public static String transform(URL xmlUrl,URL xslUrl,Hashtable<String,String> params) throws IOException,TransformerException
	
	{
		String xml = HttpUtil.URLtoString(xmlUrl);
		String xsl = HttpUtil.URLtoString(xslUrl);

		StreamSource xmlSource = new StreamSource(new UnsyncStringReader(xml));
		StreamSource xslSource = new StreamSource(new UnsyncStringReader(xsl));

		TransformerFactory transformerFactory =
			TransformerFactory.newInstance();

		Transformer transformer = transformerFactory.newTransformer(xslSource);
		Enumeration keys = params.keys();

		String prm,value;
		while(keys.hasMoreElements()) {
	         prm = (String) keys.nextElement();
	         value = (String)params.get(prm);
	         transformer.setParameter(prm, value);     
	      }
		
		UnsyncByteArrayOutputStream unsyncByteArrayOutputStream =
			new UnsyncByteArrayOutputStream();

		transformer.transform(
			xmlSource, new StreamResult(unsyncByteArrayOutputStream));

		return unsyncByteArrayOutputStream.toString();
		
	}
	
}
