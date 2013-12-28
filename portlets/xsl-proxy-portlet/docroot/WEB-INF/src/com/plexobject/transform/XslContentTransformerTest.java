package com.plexobject.transform;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;


public class XslContentTransformerTest extends TestCase {
    private ContentTransformer transformer;

    protected void setUp() throws Exception {
        transformer = new XslContentTransformer(
                "/com.plexobject/transform/xhtmlTransform.xslt", true);
    }

    public void testTransform() throws Exception {
        Map<String, String> properties = new HashMap<String, String>();
        properties.put("callbackHandler", "test");
        properties.put("callbackWorkflowId", "1");
        properties.put("callbackTaskId", "a");
        InputStream in = getClass().getResourceAsStream(
                "/com.plexobject/transform/XslContentTransformerTest.html");
        assertNotNull("failed to find html", in);
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }

        String contents = sb.toString();
        String result = transformer.transform(contents, properties);
        //
        assertTrue(result.indexOf("/web/guest/home") != -1);
        assertTrue(result
                .indexOf("name=\"_TaskDetailsPortlet_WAR_JasperPortal_Form\"") != -1);
        assertTrue(result
                .indexOf("<input type=\"hidden\" name=\"_TaskDetailsPortlet_WAR_JasperPortal_action\" value=\"ProxyWorkflowHandler\"") != -1);
        assertTrue(result
                .indexOf("<input type=\"hidden\" name=\"_TaskDetailsPortlet_WAR_JasperPortal_workflowInstanceId\" value=\"1\">") != -1);
        assertTrue(result
                .indexOf("<input type=\"hidden\" name=\"_TaskDetailsPortlet_WAR_JasperPortal_workflowTaskId\" value=\"a\">") != -1);

    }
}
