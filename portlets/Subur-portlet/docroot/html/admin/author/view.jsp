<%@ include file="/html/init.jsp" %>
<%@ page import="com.idetronic.subur.search.AuthorSearch" %>
<%@ page import="com.idetronic.subur.search.AuthorSearchTerms" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("jspPage", "/html/admin/author/view.jsp");
	pageContext.setAttribute("portletURL", portletURL);

	String portletURLString = portletURL.toString();
%>

<aui:form action="<%= portletURLString %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="portletURL" />
	<%
	String toolbarItem = ParamUtil.getString(request, "toolbarItem");

	AuthorSearch searchContainer = new AuthorSearch(renderRequest, portletURL);

	List headerNames = searchContainer.getHeaderNames();

	headerNames.add(StringPool.BLANK);
	%>
	<aui:nav-bar>
		<aui:nav>
			<portlet:renderURL var="viewAuthorsURL">
				<portlet:param name="jspPage" value="/html/admin/author/view.jsp" />
			</portlet:renderURL>

			
				<liferay-portlet:renderURL varImpl="addAuthorURL">
					<portlet:param name="jspPage" value="/html/admin/author/edit_author.jsp" />
					<portlet:param name="redirect" value="<%= viewAuthorsURL %>" />
				</liferay-portlet:renderURL>

				 <aui:nav-item href="<%=addAuthorURL.toString() %>" iconCssClass="icon-add"
                      label="add" selected='<%=true %>' />
			
		</aui:nav>

		<aui:nav-bar-search cssClass="pull-right" file="/html/admin/author/author_search.jsp" searchContainer="<%= searchContainer %>" />
	</aui:nav-bar>
	
<%
	AuthorSearchTerms searchTerms = (AuthorSearchTerms)searchContainer.getSearchTerms();
	List<Author> authors = AuthorLocalServiceUtil.search(searchTerms.getKeywords(),searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
	int total = authors.size();
	searchContainer.setTotal(total);
	List results = ListUtil.subList(authors, searchContainer.getStart(), searchContainer.getEnd());

	searchContainer.setResults(results);

	

	portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCur()));
	%>

	<aui:input name="authorsRedirect" type="hidden" value="<%= portletURL.toString() %>" />

	<%
	List resultRows = searchContainer.getResultRows();

	for (int i = 0; i < results.size(); i++) {
		Author author = (Author)results.get(i);

		author = author.toEscapedModel();

		ResultRow row = new ResultRow(author, author.getAuthorId(), i);

		PortletURL rowURL = null;

		
			rowURL = renderResponse.createRenderURL();

			rowURL.setParameter("jspPage", "/html/admin/author/edit_author.jsp");
			rowURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
			rowURL.setParameter("authorId", String.valueOf(author.getAuthorId()));
		
		// First Name

		row.addText(author.getFirstName(), rowURL);
		row.addText(author.getLastName(), rowURL);
		
		// Type

		//row.addText(LanguageUtil.get(pageContext, role.getTypeLabel()), rowURL);

		

		// Action

		row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/admin/author/author_action.jsp");

		// CSS

		//row.setClassName(RolesAdminUtil.getCssClassName(role));
		//row.setClassHoverName(RolesAdminUtil.getCssClassName(role));

		// Add result row

		resultRows.add(row);
	}
	%>

	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</aui:form>