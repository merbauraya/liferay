<%
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import ="com.liferay.portal.kernel.dao.orm.*"%>
<%@page import ="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil" %>
<%@page import ="com.liferay.portal.kernel.exception.SystemException" %>
<%@page import ="com.liferay.portlet.documentlibrary.model.*" %>
<%@page import="java.util.List"%>

<portlet:defineObjects />

This is the <b>Folder Search</b> portlet.
<%
List<Object> folderList = null;
DLFolder folder;

	DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DLFolder.class);
	Criterion criterion = null;
	criterion = RestrictionsFactoryUtil.ilike("name", "public"); 
	dynamicQuery.add(criterion);
	

	try {
		folderList = DLFolderLocalServiceUtil.dynamicQuery(dynamicQuery);
					
	}catch (SystemException ex)
	{
		ex.printStackTrace();
	}
	
	
	for (int i = 0; i < folderList.size();i++)
	{
		folder = (DLFolder)folderList.get(i);
		out.println(folder.getName());
	}

%>