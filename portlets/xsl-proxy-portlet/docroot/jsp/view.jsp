<%@include file="/jsp/init.jsp" %>
<%@ page import="com.plexobject.web.service.*" %>
<%@ page import="com.plexobject.web.proxy.*" %>
<%@ page import="com.plexobject.transform.*" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>

<portlet:defineObjects />

<portlet:renderURL var="bySubjectUrl">
	<portlet:param name="action" value="bySubject"></portlet:param>
</portlet:renderURL>
<%
PortletURL actionURL = renderResponse.createActionURL();
actionURL.setParameter(ActionRequest.ACTION_NAME,ProxyConstant.ACTION_URL);

String portletURL =  themeDisplay.getPortalURL();

String baseURL = proxyURL;
String result =(String)request.getAttribute("result");
%>
<%=(String)request.getAttribute("url") %>
<%
	
	if (Validator.isNull(result))
	{
		//we got here 
		HttpProxyImpl proxy = new HttpProxyImpl();
		ProxyState state = new ProxyState(baseURL,MethodType.GET);
		ProxyResponse pResponse = null;
		Map<String, String[]> params = new HashMap<String, String[]>();
		pResponse = proxy.request(state, params);
		XslContentTransformer xform = new XslContentTransformer(
		            "/com/plexobject/transform/xhtmlTransform.xslt", true);
		Map<String,String> props = new HashMap<String,String>();
		props.put("callbackHandler","www.portlet.com");
		props.put("portletURL",actionURL.toString());
		    //props.put("portletURL",portletURL);
		String x = xform.transform(pResponse.getContents(), props);
		    
		result = x;//pResponse.getContents();
	}
		
	

%>
<%=result%>