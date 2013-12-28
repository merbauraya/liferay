package com.plexobject.web.proxy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.client.CookieStore;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import com.plexobject.io.IoUtil;

public class HttpProxyImpl implements HttpProxy {
    private static final int CONNECTION_TIMEOUT_MILLIS = 30000;

    /**
     * This method issues a GET or POST request based on method and URI URI specified in the ProxyState
     * and adds given parameters to the request.
     * 
     * @param state
     *            - proxy state
     * @param params
     *            - name/value pairs of parameters that are sent to the get
     *            request
     */
    public ProxyResponse request(ProxyState state, Map<String, String[]> params)
            throws IOException {
        if (state.getMethod() == MethodType.GET) {
            return get(state, params);
        } else {
            return post(state, params);
        }
    }


    /**
     * This method issues a GET request on the URI specified in the ProxyState
     * and adds given parameters to the request.
     * 
     * @param state
     *            - proxy state
     * @param params
     *            - name/value pairs of parameters that are sent to the get
     *            request
     */
    private ProxyResponse get(ProxyState state, Map<String, String[]> params)
            throws IOException {
        GetMethod method = new GetMethod(state.getUri());
        method.setQueryString(toNameValues(params));
        return doRequest(state, params, method);
    }

    /**
     * This method issues a POST request on the URI specified in the ProxyState
     * and adds given parameters to the request.
     * 
     * @param state
     *            - proxy state
     * @param params
     *            - name/value pairs of parameters that are sent to the POST
     *            request
     */
    private ProxyResponse post(ProxyState state, Map<String, String[]> params)
            throws IOException {
        PostMethod method = new PostMethod(state.getUri());
        method.setRequestBody(toNameValues(params));
        return doRequest(state, params, method);
    }

    private ProxyResponse doRequest(ProxyState proxyState,
            Map<String, String[]> params, HttpMethodBase method)
            throws IOException {
        long started = System.currentTimeMillis();
        HttpClient client = new HttpClient();
        client.getHttpConnectionManager().getParams().setConnectionTimeout(
                CONNECTION_TIMEOUT_MILLIS);
        client.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler(3, false));

        HttpState initialState = new HttpState();
        for (Cookie cookie : proxyState.getCookies()) {
            initialState.addCookie(cookie);
        }
        client.setState(initialState);

        try {
            int statusCode = client.executeMethod(method);
            String contents = IoUtil.read(method.getResponseBodyAsStream());
            //
            Cookie[] cookies = client.getState().getCookies();
            for (Cookie cookie : cookies) {
                proxyState.addCookie(cookie);
            }

            return new ProxyResponse(statusCode, contents, proxyState);
        } catch (RuntimeException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw new IOException("failed to process request", e);
        } finally {
            method.releaseConnection();
        }
    }

    private NameValuePair[] toNameValues(Map<String, String[]> params) {
        if (params == null || params.size() == 0) {
            return new NameValuePair[0];
        }
        List<NameValuePair> nvPairs = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String[]> e : params.entrySet()) {
            String[] values = e.getValue();
            for (int j = 0; j < values.length; j++) {
                nvPairs.add(new NameValuePair(e.getKey(), values[j]));
            }
        }
        return (NameValuePair[]) nvPairs.toArray(new NameValuePair[nvPairs
                .size()]);
    }
}
