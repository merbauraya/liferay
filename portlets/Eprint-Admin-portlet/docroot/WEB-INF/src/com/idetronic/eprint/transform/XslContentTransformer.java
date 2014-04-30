package com.idetronic.eprint.transform;
import java.util.Map;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.idetronic.eprint.transform.ContentTransformer;

public class XslContentTransformer implements ContentTransformer{
	private final String xslUri;
	private static final Map<String, Map<String, String>> xslProperties = new HashMap<String, Map<String, String>>();
	private volatile Transformer transformer;
	public XslContentTransformer(String xslUri)
	{
		this.xslUri = xslUri;
	}
	public String transform(String contents, Map<String, String> properties)
            throws TransformationException
    {
		initTransformer();
		final long started = System.currentTimeMillis();
	    contents = contents.replaceAll("<!--.*?-->", "");
	    InputStream in = new ByteArrayInputStream(contents.getBytes());
	     
	    final Source xmlSource = new StreamSource(in);
        final ByteArrayOutputStream out = new ByteArrayOutputStream(
                (int) contents.length());

        final Result result = new StreamResult(out);
        final Map<String, String> props = new HashMap<String, String>();
        
        for (Map.Entry<String, String> e : properties.entrySet()) {
            transformer.setParameter(e.getKey(), e.getValue());
        
        }
        
        try {
            transformer.transform(xmlSource, result);
        } catch (TransformerException e) {
            throw new TransformationException("Failed to transform ", e);
        }
       
        
        
        return new String(out.toByteArray());
		
    }
     // no synchronization needed, multiple initialization is acceptable
    private final void initTransformer() {
        if (transformer == null) {
            try {
                TransformerFactory transFact = TransformerFactory.newInstance();
                InputStream in = getClass().getResourceAsStream(xslUri);
                if (in == null) {
                    throw new TransformationException("failed to find xslt "
                            + xslUri);
                }
                Source xsltSource = new StreamSource(in);
                transformer = transFact.newTransformer(xsltSource);
            } catch (TransformationException e) {
                throw e;
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e) {
                throw new TransformationException(
                        "Failed to initialize XSL transformer", e);
            }
        }
    }        

}
