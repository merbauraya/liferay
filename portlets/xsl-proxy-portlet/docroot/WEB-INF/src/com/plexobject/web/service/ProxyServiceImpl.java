package com.plexobject.web.service;
import com.plexobject.web.proxy.*;
import com.plexobject.transform.ContentTransformer;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;


public class ProxyServiceImpl implements ProxyService {
    private HttpProxy httpProxy;
    private ContentTransformer contentTransformer;
    public ProxyServiceImpl(HttpProxy httpProxy, ContentTransformer contentTransformer) {
        this.httpProxy = httpProxy;
        this.contentTransformer = contentTransformer;
    }

    public void render(HttpServletRequest request,  HttpServletResponse response)  throws IOException {
        String url = "http://www.google.com";
        ProxyState state = new ProxyState(url, MethodType.GET);
        String inputXhtml = httpProxy.request(state, null).getContents();
        Map<String, String> properties = new HashMap<String, String>();
        properties.put("callbackState", state.toExternalFormat());
        String transformedXhtml = contentTransformer.transform(inputXhtml, properties);
        response.getWriter().println(transformedXhtml);
    }

    public void submit(HttpServletRequest request,  HttpServletResponse response)  throws IOException {
        String originalActionUrl = request.getParameter("originalActionUrl");
        String orginalMethodType = request.getParameter("orginalMethodType");
        ProxyState userState = ProxyState.valueOf(request.getParameter("userState"));
        Map<String, String[]> params = request.getParameterMap();
        ProxyState state = new ProxyState(originalActionUrl, orginalMethodType);
        state.addCookies(userState.getCookies());
        ProxyResponse proxyResponse = httpProxy.request(state, params);
        response.getWriter().println(proxyResponse.getContents());
    }
}
