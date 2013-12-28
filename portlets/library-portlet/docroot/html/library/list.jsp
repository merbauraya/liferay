<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@include file="/html/library/init.jsp"%>

<h1>List of books in our Library</h1>

<%
List<LMSBook> books = LMSBookLocalServiceUtil.getLMSBooks(0, -1);
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("jspPage", LibraryConstants.PAGE_LIST);

%>



<liferay-ui:search-container iteratorURL="<%= iteratorURL %>" delta="4" emptyResultsMessage="Sorry. There are no items to display.">
	<liferay-ui:search-container-results 
		total="<%= books.size() %>"
		results="<%= ListUtil.subList(books, 
									 searchContainer.getStart(), 
									 searchContainer.getEnd()) %>"/>
	<liferay-ui:search-container-row modelVar="book"
		className="LMSBook">
		<liferay-ui:search-container-column-text
			name="Book Title" property="bookTitle" />
		<liferay-ui:search-container-column-text name="Author"
			property="author" />
		<liferay-ui:search-container-column-text
			name="Date Added" property="createDate" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</liferay-ui:search-container>