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
	String rAction = request.getParameter("action");
	//String verb = request.getParameter("verb");
	String metadataPrefix =PortalUtil.getOriginalServletRequest(request).getParameter("metadataPrefix");
	String verb = PortalUtil.getOriginalServletRequest(request).getParameter("verb");
	String set =  PortalUtil.getOriginalServletRequest(request).getParameter("set");
	String resumptionToken =  PortalUtil.getOriginalServletRequest(request).getParameter("resumptionToken");
	String sourceXML = eprintURL;
	Hashtable<String, String> prm = new Hashtable<String, String>();
	
	
	if (rAction != null && rAction.equalsIgnoreCase("ListRecord"))
		sourceXML += "?verb=ListRecords&metadataPrefix=oai_dc";
	
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
		sourceXML += "?verb="+verb + "&set="+set + "&metadataPrefix="+metadataPrefix;
	}
	out.println("verb="+verb);
	out.println(sourceXML);
	prm.put("portletURL", portletURL);
	if (rAction != null || verb != "")
		content = XslTransformer.transform(new URL(sourceXML),new URL(xslUrl),prm);
	
%>
<%=content%>