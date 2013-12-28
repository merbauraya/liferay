package com.idetronic.portlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.plexobject.transform.XslContentTransformer;
import com.plexobject.web.proxy.HttpProxyImpl;
import com.plexobject.web.proxy.ProxyResponse;
import com.plexobject.web.proxy.ProxyState;

public class ProxyHandler {
	private String _proxyURL; //our original profixed URL
	private String _currentURL; //store most recent abs url
	private String _portletURL; // our processAction portlet URL
	private static Log log = LogFactoryUtil.getLog(ProxyHandler.class);//  (LMSBookLocalServiceImpl.class);
	
	
	ProxyHandler(){} //default constructor
	ProxyHandler(String proxyURL,String portletURL)
	{
		_proxyURL = proxyURL;
		_portletURL = portletURL;
	}
	
	//default request
	public String getResponse()
	{
		log.info("prx="+_proxyURL);
		return getRequestResponse(_proxyURL,"GET",null);
	}
	public String getResponse(String uri,String method, Map<String, String[]> paramMap)
	{
		
		
		
		
		 
		 
		String ret = null;
		return ret;
	}
	
	private String getRequestResponse(String uri,String method,Map<String, String[]> paramMap)
	{
		
		String origActionURL="";
		String rootURL="";
		
		//build our proxy request to target server
		HttpProxyImpl proxy = new HttpProxyImpl();
		 
		ProxyResponse pResponse = null;
	 	 
			
		XslContentTransformer xform = new XslContentTransformer(
		            "/com/plexobject/transform/xhtmlTransform.xslt", true);
		Map<String,String> props = new HashMap<String,String>();
		props.put("callbackHandler","www.portlet.com");
		props.put("portletURL",_portletURL);
		
		//build our params request
		Map<String, String[]> params = new HashMap<String, String[]>(); 
		if (Validator.isNotNull(paramMap))
		{
			Iterator i = paramMap.keySet().iterator();
			 while ( i.hasNext() )
			 {
				 String key = (String) i.next();
				 String value = ((String[]) paramMap.get( key ))[ 0 ];
				 
				 
				 if (key.equalsIgnoreCase("origUrl"))//test for regular link e.g. a href
					 origActionURL = value;
				 else if (key.equalsIgnoreCase("_originalActionUrl"))//test for form link
					 origActionURL = value;
				 else if (key.equalsIgnoreCase("rootURL"))
					 rootURL = value;
				 else
					 params.put(key, paramMap.get( key ));
				 //log.info("Key="+ key + " value=" + value);
			 
		 }
		}
		 String url = origActionURL == "" ? _proxyURL: origActionURL;
		 url = buildProxyURL(url,rootURL);
		 ProxyState state = new ProxyState(url,method);
		 try {
			pResponse = proxy.request(state, params);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 String response = xform.transform(pResponse.getContents(), props);
		// System.out.print(response);
		
		
		
		String ret = null;
		return response;
	}
	
	private String buildProxyURL(String url,String rootURL)
	{
		 if (url.startsWith("http://"))
			 return url;
		 if (url.startsWith("https://"))
			 return url;
		 if (url.startsWith("ftp://"))
			 return url;
		 //we have relative url, construct based on root rul
		 return rootURL+url;
		 
	}
	public void setProxyURL(String uri)
	{
		this._proxyURL = uri;
	}
	public void setPorletActionUrl(String uri)
	{
		this._portletURL = uri;
	}
	
}
