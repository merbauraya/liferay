<%@include file="/html/eprint/init.jsp" %>
By Subject id view :
<%
	String subjectId = (String) request.getAttribute("subjectId");
	List<Eprint> eprints = (List<Eprint>)request.getAttribute("eprints");	
	String rowCss="portlet-section-body results-row";
	final String altRowCss = "portlet-section-alternate results-row alt";
	
	PortletURL iteratorURL = resourceResponse.createRenderURL();// renderResponse.createRenderURL();
	iteratorURL.setParameter("jspPage", "/html/eprintview/bysubject.jsp");
	
%>

<liferay-ui:search-container delta="10" emptyResultsMessage="Sorry. There are no items to display.Please select another subject"
	iteratorURL="<%= iteratorURL %>">
	<liferay-ui:search-container-results total="<%= eprints.size() %>"
		results="<%= ListUtil.subList(eprints,searchContainer.getStart(),
									  searchContainer.getEnd()) %>"/>

	<liferay-ui:search-container-row modelVar="eprint" className="Eprint">
	<liferay-ui:search-container-column-text name="Title" property="title" />
	<liferay-ui:search-container-column-text name="Type" property="eprintType" />
	<liferay-ui:search-container-column-text name="Date Added">
		<fmt:formatDate value="<%=eprint.getCreatedDate() %>"
			pattern="dd-MMM-yyyy" />
	</liferay-ui:search-container-column-text>
	
</liferay-ui:search-container-row>

	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</liferay-ui:search-container>