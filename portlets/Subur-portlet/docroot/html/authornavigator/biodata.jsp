<%
	List<AuthorSite> authorSites = AuthorSiteLocalServiceUtil.findByAuthorId(author.getAuthorId());
%>
<h3>Sites</h3>
<c:if test="authorSites.size() >0">
	<ul>
</c:if>
<%
	for (AuthorSite authorSite : authorSites)
	{
%>
		<li><a href="<%=authorSite.getSiteURL() %>"><%=authorSite.getSiteName() %></a></li>

<%	
	}
%>
<c:if test="authorSites.size() >0">
	</ul>
</c:if>