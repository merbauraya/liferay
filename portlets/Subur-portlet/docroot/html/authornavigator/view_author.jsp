<%@ include file="/html/init.jsp" %>

<%
	long authorId = ParamUtil.getLong(request, "authorId");
	
	Author author = AuthorLocalServiceUtil.fetchAuthor(authorId);
	List<Expertise> expertises = AuthorLocalServiceUtil.getExpertises(authorId);
	
%>
<c:choose>
	<c:when test="<%= author == null %>">
		<liferay-ui:message key="no-author-found"></liferay-ui:message>
	</c:when>
	<c:otherwise>
		<%@ include file="/html/authornavigator/author_detail.jsp" %>
	</c:otherwise>

</c:choose>