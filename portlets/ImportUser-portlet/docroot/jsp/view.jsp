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

<%@include file="/jsp/init.jsp" %>

<%@ page import="java.sql.*, javax.portlet.*, javax.naming.*, javax.sql.*" %>
<%@ page import="com.idetronic.portlet.ImportUser" %>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
This is the <b>ImportUser</b> portlet.
<%
	/*List<Object> departments = staff_activeLocalServiceUtil.getDepartment();
	for (Object dept : departments )
	{
		Object row[] = (Object[]) dept;
		out.println ((String) row[0]);
	}*/
//	Class.forName(dbDriver);
//	Coconn = DriverManager.getConnection(DB_URL, USER, PASS);	


//Class drvClass = driverLoader.loadClass(driverClassName);
//	Driver driver = drvClass.newInstance();

	String DATASOURCE_CONTEXT = "java:comp/env/jdbc/sims";
	Connection result = null;
	try {
		Context initialContext = new InitialContext();
		if ( initialContext == null)
		{
			out.println("Cannot get initialContext");
		}
		
		DataSource datasource = (DataSource)initialContext.lookup(DATASOURCE_CONTEXT);
		Connection conn = datasource.getConnection();
		ImportUser.importUser(conn, themeDisplay);
		

	}
	catch ( NamingException ex ) {
	out.println("Cannot get connection: " + ex);
	}
	catch(SQLException ex){
		out.println("Cannot get connection: " + ex); 
		
}
     
     %>