<%@include file="/jsp/init.jsp" %>
<%@ page import="java.util.Hashtable"%>
<%

String action = PortalUtil.getOriginalServletRequest(request).getParameter("verb");
String xmlUrl = StringUtil.replace(listSetXmlUrl,"@portal_url@", themeDisplay.getPortalURL());
xslUrl = StringUtil.replace(xslUrl,"@portal_url@", themeDisplay.getPortalURL());

if (action != null && action.equalsIgnoreCase("listrecords"))
{
	String metadataPrefix = PortalUtil.getOriginalServletRequest(request).getParameter("metadataPrefix");
	String set = PortalUtil.getOriginalServletRequest(request).getParameter("set");
	xmlUrl = eprintURL +"?verb="+action+"&metadataPrefix="+metadataPrefix+
			"&set="+set;
	
}
	out.println(action);

	
	
	String content="";
	String raction = request.getParameter("action");
	try
	{
		Hashtable<String, String> prm = new Hashtable<String, String>();
		prm.put("portletURL", portletURL);
		content = XslTransformer.transform(new URL(xmlUrl),new URL(xslUrl),prm); 
	} catch (Exception e){
		out.println(e.getMessage());
	}
	out.println("listSet.jsp");
	out.println(action);
%>
<%= content %>