package com.plexobject.web.proxy;

import java.io.IOException;
import java.util.Map;

public interface HttpProxy {
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
            throws IOException;
}
