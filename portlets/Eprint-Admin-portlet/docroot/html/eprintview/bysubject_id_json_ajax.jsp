<%@include file="/html/eprint/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.json.JSONArray" %>

<%
	JSONArray jsonResponse = (JSONArray) request.getAttribute("jsonResponse");
	out.print(jsonResponse.toString());

%>