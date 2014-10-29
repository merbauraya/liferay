<%@ include file="/html/directory/init.jsp" %>

<portlet:renderURL var="searchUserURL">
	<portlet:param name="jspPage" value="/html/directory/user_search.jsp"></portlet:param>
	
</portlet:renderURL>

<aui:form action="<%=searchUserURL %>">
	<aui:input name="q" label="Search"/>
	<aui:button type="submit" />
</aui:form>

<liferay-ui:search-container var="xxContainer" delta="15">
		<liferay-ui:search-container-results>
		
			
		</liferay-ui:search-container-results>
	
<%
	out.print(xxContainer.getOrderByCol());

%>

</liferay-ui:search-container>
