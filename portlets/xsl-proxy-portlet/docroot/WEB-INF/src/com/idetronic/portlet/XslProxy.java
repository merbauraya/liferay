package com.idetronic.portlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import com.idetronic.portlet.ProxyConstant;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
//import com.liferay.portal.model.PortletPreferences;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.plexobject.transform.XslContentTransformer;
import com.plexobject.web.proxy.HttpProxyImpl;
import com.plexobject.web.proxy.MethodType;
import com.plexobject.web.proxy.ProxyResponse;
import com.plexobject.web.proxy.ProxyState;
import com.plexobject.web.service.*;


/**
 * Portlet implementation class XslProxy
 */
public class XslProxy extends MVCPortlet {
	private HttpProxyImpl proxy;
	private String _portletName;
	private String _portletURL; //action URL
	private String _proxyURL; //our proxied url
	protected String _responseJSP;
	protected String _defaultJSP;
	private String _result;
	private ProxyState _state = null;
	private static Log log = LogFactoryUtil.getLog(XslProxy.class);//  (LMSBookLocalServiceImpl.class);
	private boolean _processed=false;
	
	private ProxyHandler _proxyHandler;
	
	public void init() throws PortletException {
		super.init();
		_responseJSP = getInitParameter("response-view");
		_defaultJSP = getInitParameter("view-template");
		_proxyHandler = new ProxyHandler();
		//create default portlet action
		log.info("init");
		
				
		
		
	}
	 public void processLink(ActionRequest actionRequest, ActionResponse actionResponse)
		        throws IOException, PortletException 
		 {
		 
		 }
	
	 public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException 
	 {
		 
		 log.info("processaction");	
		 //read the config
		 getPortletInfo(actionRequest);
		 
		 
		 String method = actionRequest.getMethod();
		 
		 
		 
		 //get posted/getted params
		 Map<String, String[]> paramMap = actionRequest.getParameterMap();// .getRequestParameterMap();
		 
		 //build our proxy request to target server
		 HttpProxyImpl proxy = new HttpProxyImpl();
		 
		 ProxyResponse pResponse = null;
	 	 
			
		XslContentTransformer xform = new XslContentTransformer(
		            "/com/plexobject/transform/xhtmlTransform.xslt", true);
		Map<String,String> props = new HashMap<String,String>();
		props.put("callbackHandler","www.portlet.com");
		props.put("portletURL",_portletURL);
		    //props.put("portletURL",portletURL);
		
		
		 
		 String origActionURL="",rootURL=_proxyURL;
		 
		 Map<String, String[]> params = new HashMap<String, String[]>();
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
		 
		 String url = origActionURL == "" ? _proxyURL: origActionURL;
		 //set relative URL
		 
		 
		 if (Validator.isNotNull(_state))
			 rootURL = _state.getUri();
		 url = buildProxyURL(url,rootURL);
		
		 log.info("url="+url + " method="+method+ " rooturl="+rootURL);
		 
		 if (_state == null)
			 _state = new ProxyState(url,method);
		 else
			 _state.setUri(url, method);
		 pResponse = proxy.request(_state, params);
		 
		 String response = xform.transform(pResponse.getContents(), props);
		// System.out.print(response);
		 //log.info(response);
		 actionRequest.setAttribute("result", response);
		 actionRequest.setAttribute("url",url);
		 /*
		//show the result 
		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),portletName,
                 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("jspPage", ProxyConstant.RENDER_RESPONSE); // set required parameter that you need in doView or render Method
		//redirectURL.setParameter("content", response);
		actionResponse.sendRedirect(redirectURL.toString()); 

	        */
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
	
	
	private String proxyRequest()
	{
		HttpProxyImpl proxy = new HttpProxyImpl();
		ProxyState state = new ProxyState("http://eprints.uitm.edu.my/cgi/search/simple",
	        MethodType.GET);
		Map<String, String[]> params = new HashMap<String, String[]>();
	    params.put("q", new String[] { "thesis" });
	    params.put("hl", new String[] { "en" });
	    params.put("btnG", new String[] { "Google+Search" });
	    params.put("aq", new String[] { "f" });
	    params.put("oq", new String[] { "" });
	    
	    ProxyResponse pResponse = null;
		try {
			pResponse = proxy.request(state, params);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    XslContentTransformer xform = new XslContentTransformer(
	            "/com/plexobject/transform/xhtmlTransform.xslt", true);
	    Map<String,String> props = new HashMap<String,String>();
		props.put("callbackHandler","www.portlet.com");
	    //props.put("portletURL",portletURL);
	    String x = xform.transform(pResponse.getContents(), props);
	    
	    String content = x;//pResponse.getContents();
	    return content;

	}
	private void getPortletInfo(ActionRequest actionRequest)
	{
		ThemeDisplay themeDisplay =(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) actionRequest.getAttribute("javax.portlet.config");
		_portletName = portletConfig.getPortletName();
		PortletURL pURL = PortletURLFactoryUtil.create(
				actionRequest,
				_portletName + "_WAR_" + _portletName + "portlet",
				themeDisplay.getPlid(),PortletRequest.ACTION_PHASE);
		try {
			pURL.setWindowState(WindowState.NORMAL );
		} catch (WindowStateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		pURL.setParameter(ActionRequest.ACTION_NAME,ProxyConstant.ACTION_LINK);
		_portletURL = pURL.toString();
		
		//read portlet config;
		PortletPreferences preferences = actionRequest.getPreferences();
		String portletResource = ParamUtil.getString(actionRequest, "portletResource");
		 
		if (Validator.isNotNull(portletResource)) 
		{
		     try {
				preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		_proxyURL = preferences.getValue("url","");
		
	}/*
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
		log.info("doView");
		String includeJSP;
		PortletURL url = renderResponse.createRenderURL();
		PortletPreferences prefs = renderRequest.getPreferences();
		//url.setWindowState(WindowState.NORMAL );
		if (Validator.isNull(renderRequest.getAttribute("result")))
			include(_defaultJSP,renderRequest,renderResponse);
		else	
			include(_responseJSP, renderRequest, renderResponse);
		//include("/jsp/view.jsp", renderRequest, renderResponse);
		 
		
    }
	
	protected void include(String path, RenderRequest renderRequest,RenderResponse renderResponse) throws IOException, PortletException
	{
	            PortletRequestDispatcher portletRequestDispatcher =
	                                               getPortletContext().getRequestDispatcher(path);
	            if (portletRequestDispatcher == null)
	            {
	                log.error(path + " is not a valid include");
	            }
	            else
	            {
	                portletRequestDispatcher.include(renderRequest, renderResponse);
	            }
	}
	*/
	protected void include(
			String path, RenderRequest renderRequest,
			RenderResponse renderResponse)
			throws IOException, PortletException {
			PortletRequestDispatcher portletRequestDispatcher =
				getPortletContext().getRequestDispatcher(path);
			if (portletRequestDispatcher == null) {
				log.error(path + " is not a valid include");
			} else {
				portletRequestDispatcher.include(
				renderRequest, renderResponse);
			}
		}

	public void render(RenderRequest renderRequest,RenderResponse renderResponse) throws IOException, PortletException 
	{
		if (!_processed)
		{
			ThemeDisplay themeDisplay =(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PortletConfig portletConfig = (PortletConfig) renderRequest.getAttribute("javax.portlet.config");
			_portletName = portletConfig.getPortletName();
			PortletURL pURL = PortletURLFactoryUtil.create(
					renderRequest,
					_portletName + "_WAR_" + _portletName + "portlet",
					themeDisplay.getPlid(),PortletRequest.ACTION_PHASE);
			pURL.setParameter(ActionRequest.ACTION_NAME,ProxyConstant.ACTION_LINK);
			_portletURL = pURL.toString();
			//read portlet config;
			PortletPreferences preferences = renderRequest.getPreferences();
			String portletResource = ParamUtil.getString(renderRequest, "portletResource");
			 
			if (Validator.isNotNull(portletResource)) 
			{
			     try {
					preferences = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			_proxyURL = preferences.getValue("url","");
			log.info("proxyurl="+_proxyURL);
			
			defaultProxyRequest();
			renderResponse.getWriter().print(_result);
		}
		else
			renderResponse.getWriter().print("processed");
	}
	private void defaultProxyRequest()
	{
		_proxyHandler.setProxyURL(_proxyURL);
		_proxyHandler.setPorletActionUrl(_portletURL);
		_result = _proxyHandler.getResponse();
	}
	
}
