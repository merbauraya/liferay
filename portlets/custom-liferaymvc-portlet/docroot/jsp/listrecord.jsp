<%
/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
%>
<%@include file="/jsp/init.jsp" %>
<%@ page import="java.util.Hashtable"%>


<portlet:defineObjects />


<br>
<a href="${listRecordUrl}">List Record </a>

<%
	String action = request.getParameter("set");
	String xmlUrl;
	if (action != null)
	{
		String verb = request.getParameter("verb");
		String metadataPrefix = request.getParameter("metadataPrefix");
		xmlUrl = "http://http://eprints.uitm.edu.my/cgi/oai2";
		xmlUrl += "?verb="+verb+"&amp;metadataPrefix="+metadataPrefix+"&amp;set="+action;
		
	}else
	{
		xmlUrl = StringUtil.replace(listRecordXmlUrl,"@portal_url@", themeDisplay.getPortalURL());
	}

	//String xmlUrl = StringUtil.replace(listRecordXmlUrl,"@portal_url@", themeDisplay.getPortalURL());
	
	xslUrl = StringUtil.replace(xslUrl,"@portal_url@", themeDisplay.getPortalURL());

	//out.println(xslUrl);
	//out.println(listRecordXmlUrl);
	String content = "";
	try
	{
		URL xml = new URL(xmlUrl);
		
		URL xsl = new URL(xslUrl);
		Hashtable<String, String> prm = new Hashtable<String, String>();
		prm.put("portletURL", portletURL);
		content = XslTransformer.transform(xml,xsl,prm);
	} catch (Exception e){
		out.println(e.getMessage());
	}
	out.println("listrecord.jsp");
%>
<%= content %>
