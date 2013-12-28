package com.plexobject.web.proxy;

import java.util.HashMap;
import java.util.Map;

import com.plexobject.transform.XslContentTransformer;

import junit.framework.TestCase;


public class HttpProxyImplTest extends TestCase {
    private HttpProxyImpl proxy;

    protected void setUp() throws Exception {
        proxy = new HttpProxyImpl();
    }

    public void testGet() throws Exception {
        ProxyState state = new ProxyState("http://www.google.com/search",
                MethodType.GET);
        Map<String, String[]> params = new HashMap<String, String[]>();
        params.put("q", new String[] { "amazon" });
        params.put("hl", new String[] { "en" });
        params.put("btnG", new String[] { "Google+Search" });
        params.put("aq", new String[] { "f" });
        params.put("oq", new String[] { "" });
        ProxyResponse response = proxy.request(state, params);
        
        
        
        
        
        assertTrue(response.getResponseCode() == 200);
        assertTrue(response.getContents().indexOf("q=http://www.amazon.com") != -1);
    }

    public void testPost() throws Exception {
        ProxyState state = new ProxyState("http://www.google.com/search",
                MethodType.POST);
        Map<String, String[]> params = new HashMap<String, String[]>();
        params.put("q", new String[] { "amazon" });
        params.put("hl", new String[] { "en" });
        params.put("btnG", new String[] { "Google+Search" });
        params.put("aq", new String[] { "f" });
        params.put("oq", new String[] { "" });
        ProxyResponse response = proxy.request(state, params);
        assertTrue(response.getResponseCode() == 501);
    }
}
