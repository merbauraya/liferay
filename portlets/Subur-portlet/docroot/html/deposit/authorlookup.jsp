
<%@ include file="/html/init.jsp" %>
<%@ page import="com.idetronic.subur.search.AuthorSearch" %>
<%@ page import="com.idetronic.subur.search.AuthorSearchTerms" %>

<%
	long itemId = Long.parseLong(request.getParameter("itemId"));
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "addAuthor");

	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("jspPage", "/html/deposit/authorlookup.jsp");
	portletURL.setParameter("eventName", eventName);
	portletURL.setParameter("itemId", String.valueOf(itemId));
	
%>
<aui:form action="<%= portletURL.toString() %>" method="post" name="selectAuthorFm">
	
	<div class="form-search">
		<liferay-ui:input-search autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>" placeholder='<%= LanguageUtil.get(locale, "keywords") %>' />
	</div>
	

	<liferay-ui:search-container
		headerNames="First Name,Last Name"
		searchContainer="<%= new AuthorSearch(renderRequest,portletURL) %>"
	>
	<%
		AuthorSearchTerms searchTerms = (AuthorSearchTerms)searchContainer.getSearchTerms();
	%>
	<liferay-ui:search-container-results>
		<%
		List<Author> authors = AuthorLocalServiceUtil.search(searchTerms.getKeywords(),
				themeDisplay.getCompanyId(),themeDisplay.getScopeGroupId(),
				searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
		total = authors.size();
		searchContainer.setTotal(total);
		results = ListUtil.subList(authors, searchContainer.getStart(), searchContainer.getEnd());
		
		searchContainer.setResults(results);
		%>
	
	
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row
			className="com.idetronic.subur.model.Author"
			keyProperty="authorId"
			modelVar="author"
		>
		
		<liferay-ui:search-container-column-text
				name="firstName"
				value="<%= HtmlUtil.escape(author.getFirstName()) %>"
				orderable="<%= true %>"
		/>
		<liferay-ui:search-container-column-text
				name="Last Name"
				value="<%= HtmlUtil.escape(author.getLastName()) %>"
		/>
		
		<liferay-ui:search-container-column-text>
			<%
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("authorid",author.getAuthorId());
			data.put("firstname",author.getFirstName());
			data.put("lastname",author.getLastName());
			data.put("searchcontainername", "authors");
			%>
			
			<aui:button cssClass="selector-button" data="<%= data %>" value="choose" />
			
		</liferay-ui:search-container-column-text>
			
		
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
	
</liferay-ui:search-container>
	
	
	
	

</aui:form>
<portlet:resourceURL var="authorLookupURL" id="<%=SuburConstant.RESOURCE_AUTHOR_LOOKUP %>">




	
</portlet:resourceURL>




<aui:script use="aui-base">
	var Util = Liferay.Util;

	A.one('#<portlet:namespace />selectAuthorFm').delegate(
		'click',
		function(event) {
			var result = Util.getAttributes(event.currentTarget, 'data-');

			Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>', result);

			Util.getWindow().destroy();
		},
		'.selector-button'
	);
</aui:script>