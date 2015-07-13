<%@include file="/html/suburstatistic/init.jsp"%>

<%
	PortletURL updStatURL = renderResponse.createActionURL();
	

%>
<portlet:actionURL var="updateStatURL" name="updateStats">
    <portlet:param name="jspPage" value="/edit.jsp" />
</portlet:actionURL>


	<a href="<%= updateStatURL.toString() %>">Update Stat</a>


