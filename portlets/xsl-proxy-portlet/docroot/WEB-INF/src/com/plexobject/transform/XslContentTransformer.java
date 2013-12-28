package com.plexobject.transform;

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

import org.w3c.tidy.Tidy;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class XslContentTransformer implements ContentTransformer {
    public static final String ACTION = "form_action";
    public static final String METHOD = "form_method";
    private static Log log = LogFactoryUtil.getLog(XslContentTransformer.class);//  (LMSBookLocalServiceImpl.class);
    private static final Map<String, Map<String, String>> xslProperties = new HashMap<String, Map<String, String>>();
    private volatile Transformer transformer;
    private final String xslUri;
    private final boolean useTidy;

    public XslContentTransformer(final String xslUri, final boolean useTidy) {
        this.xslUri = xslUri;
        this.useTidy = useTidy;
    }

    public static final String setAction(final String callbackHandler,
            final String action) {
        getPropertiesForCallback(callbackHandler).put(ACTION, action);
        return "";
    }

    public static final String getAction(final String callbackHandler) {
        return getPropertiesForCallback(callbackHandler).get(ACTION);
    }

    public static final String setMethod(final String callbackHandler,
            final String method) {
        getPropertiesForCallback(callbackHandler).put(METHOD, method);
        return "";
    }

    public static final String getMethod(final String callbackHandler) {
        return getPropertiesForCallback(callbackHandler).get(METHOD);
    }

    /**
     * This method transforms given contents
     * 
     * @param contents
     *            - input contents
     * @param properties
     *            - input/output properties for transformation
     * @return transformed contents
     * @throws TransformationException
     *             - when error occurs while transforming content.
     */
    public String transform(String contents, Map<String, String> properties)
            throws TransformationException {
        initTransformer();
        
        final long started = System.currentTimeMillis();
        contents = contents.replaceAll("<!--.*?-->", "");
        InputStream in = new ByteArrayInputStream(contents.getBytes());
        if (useTidy) {
            in = tidy(in, (int) contents.length());
        }

        //
        final Source xmlSource = new StreamSource(in);
        final ByteArrayOutputStream out = new ByteArrayOutputStream(
                (int) contents.length());

        final Result result = new StreamResult(out);
        String callbackHandler = properties.get("callbackHandler");
        if (callbackHandler == null) {
            callbackHandler = Thread.currentThread().getName();
        }
        final Map<String, String> props = new HashMap<String, String>();
        xslProperties.put(callbackHandler, props);
        transformer.setParameter("callbackHandler", callbackHandler);
        
        for (Map.Entry<String, String> e : properties.entrySet()) {
            transformer.setParameter(e.getKey(), e.getValue());
        }
        try {
            transformer.transform(xmlSource, result);
        } catch (TransformerException e) {
            throw new TransformationException("Failed to transform " + contents, e);
        }
        properties.put(ACTION, getAction(callbackHandler));
        properties.put(METHOD, getMethod(callbackHandler));
        xslProperties.remove(callbackHandler);
        return new String(out.toByteArray());
    }

    private static final Map<String, String> getPropertiesForCallback(
            String callbackHandler) {
        final Map<String, String> props = xslProperties.get(callbackHandler);
        if (props == null) {
            throw new NullPointerException(
                    "Failed to find properties for callback " + callbackHandler);
        }
        return props;
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

    private final InputStream tidy(InputStream in, int length) {
        ByteArrayOutputStream out = new ByteArrayOutputStream(length);
        Tidy converter = new Tidy();
        converter.setQuiet(true);
        converter.setShowWarnings(false);
        converter.setTidyMark(false);
        converter.setXmlOut(true);
        converter.setXmlPi(true);
        converter.setXmlPIs(true);
        converter.setNumEntities(true);
        converter.setDocType("omit");
        converter.setUpperCaseTags(false);
        converter.setUpperCaseAttrs(false);
        converter.setFixComments(true);
        converter.parse(in, out);
        return new ByteArrayInputStream(out.toByteArray());
    }
}
