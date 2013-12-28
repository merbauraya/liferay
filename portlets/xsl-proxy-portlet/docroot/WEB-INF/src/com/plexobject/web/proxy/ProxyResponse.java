package com.plexobject.web.proxy;

import java.io.Serializable;


/**
 * Class: ProxyResponse
 * 
 * Description: This class stores proxy state and response.
 */
public class ProxyResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private int responseCode;
    private String contents;
    private ProxyState state;

    /**
     * Constructor for ProxyResponse
     */
    public ProxyResponse(int responseCode, String contents, ProxyState state) {
        this.responseCode = responseCode;
        this.contents = contents;
        this.state = state;
    }

    /**
     * @return http response code
     */
    public int getResponseCode() {
        return this.responseCode;
    }

    /**
     * @return XHTML contents
     */
    public String getContents() {
        return this.contents;
    }

    /**
     * @return state associated with the proxy web request
     */
    public ProxyState getState() {
        return this.state;
    }

    @Override
    public String toString() {
        return this.responseCode + "\n" + this.state + "\n" + this.contents;
    }
}
