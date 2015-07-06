<%@ include file="/html/authornavigator/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.dao.search.DateSearchEntry" %>


<%
	List<Author> authors = AuthorLocalServiceUtil.findByGroupCompany(themeDisplay.getCompanyId(),
			themeDisplay.getScopeGroupId(),0,max);


%>
<c:choose>
	<c:when test="<%= authors.isEmpty() %>">
		<liferay-ui:message key="there-are-no-recent-authors" />
	</c:when>
	<c:otherwise>
	<%
		SearchContainer searchContainer = new SearchContainer();
		List resultRows = searchContainer.getResultRows();
		int i = 0;
		for (Author author: authors)
		{
			
			PortletURL viewAuthorURL = renderResponse.createActionURL();
			viewAuthorURL.setParameter("authorId", String.valueOf(author.getAuthorId()));
			
			
	%>
	<div class="author-nav-details">
		<a href="<%= viewAuthorURL.toString() %>">
			<%= author.getDisplayName() %>
		</a>
		<span> (<%= author.getItemCount() %> )</span>
	</div>
	
				
			
			
	<%
		}
	%>	
	
		<liferay-ui:search-iterator paginate="<%= false %>" searchContainer="<%= searchContainer %>" />
	</c:otherwise>
</c:choose>


