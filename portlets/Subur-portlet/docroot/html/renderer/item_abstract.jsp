<%@include file="/html/init.jsp"%>

<%
	SuburItem suburItem = (SuburItem)request.getAttribute("suburItem");
	suburItem = suburItem.toEscapedModel();


%>
<dl>
	<dt>Date Deposited</dt>
	<dd><%= suburItem.getCreateDate() %></dd>
	<dt>Last Modified</dt>
	<dd><%= suburItem.getModifiedDate() %>
	<dt>Author</dt>
	<%
		long[] authorIds = ItemAuthorLocalServiceUtil.getAuthorId(suburItem.getItemId());
		List<Author> authors = AuthorLocalServiceUtil.getAuthors(authorIds);
		
		for (Author author: authors)
		{
			author = author.toEscapedModel();	
		
	%>
	<dd>
			<%=author.getFirstName() %>
	
	</dd>
	<%} %>
	

</dl>