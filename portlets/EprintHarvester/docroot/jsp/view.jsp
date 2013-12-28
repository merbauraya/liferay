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

<%
	String content = "Please select action to navigate";
	String title="";
	String rAction = request.getParameter("action");
	//String verb = request.getParameter("verb");
	String metadataPrefix =PortalUtil.getOriginalServletRequest(request).getParameter("metadataPrefix");
	String verb = PortalUtil.getOriginalServletRequest(request).getParameter("verb");
	String set =  PortalUtil.getOriginalServletRequest(request).getParameter("set");
	String resumptionToken =  PortalUtil.getOriginalServletRequest(request).getParameter("resumptionToken");
	String sourceXML = eprintURL;
	Hashtable<String, String> prm = new Hashtable<String, String>();
	
	xslUrl = StringUtil.replace(xslUrl,"@portal_url@", themeDisplay.getPortalURL());
	
	if (rAction != null && rAction.equalsIgnoreCase("ListRecord"))
	{
		sourceXML += "?verb=ListRecords&metadataPrefix=oai_dc";

		
	}
	
	if (rAction != null && rAction.equalsIgnoreCase("bySubject"))
	{
		sourceXML += "?verb=ListSets";
		prm.put("set", "subject");
	}
	if (rAction != null && rAction.equalsIgnoreCase("byType"))
	{
		sourceXML += "?verb=ListSets";
		prm.put("set", "type");
	}
	if (verb != null) //user requesting detail record
	{
		sourceXML = eprintURL;
		sourceXML += "?verb="+verb;
		if (set != null && metadataPrefix != null)
			sourceXML += "&set="+set + "&metadataPrefix="+metadataPrefix;
	}
	if (resumptionToken != null)
		sourceXML += "&resumptionToken="+ URLEncoder.encode(resumptionToken,"UTF-8");

	prm.put("portletURL", portletURL);
	if (rAction == null && verb == null)
	{
		content = "<h1>Please select category to browse Online Repository</h1>";
	}else
	{
		
	if (rAction != null || verb != null) 
		//out.println (sourceXML);
		content = XslTransformer.transform(new URL(sourceXML),new URL(xslUrl),prm);
	}
	if (rAction != null)
	{	
		if (rAction.equalsIgnoreCase("bysubject"))
		{
			title = "Browsing by subject";
			String subject = PortalUtil.getOriginalServletRequest(request).getParameter("subject");
			if (subject != null)
				title += " : "+subject;
		}
		if (rAction.equalsIgnoreCase("byType"))
		{
			title = "Browsing by Type";
			String _type = PortalUtil.getOriginalServletRequest(request).getParameter("_type");
			if (_type != null)
				title += " : "+_type;
		}
	}
%>

<%@include file="/jsp/nav.jsp" %>
<div class="eprint-result">
	<h2><%=title %></h2>
<%=content%>
</div>