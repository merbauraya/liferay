<%@ include file="/html/taglib/init.jsp" %>

<%



long itemId = GetterUtil.getLong((String)request.getAttribute("subur-ui:item-author-display:itemId"));
long[] authorIds = ItemAuthorLocalServiceUtil.getAuthorId(itemId);
List<Author> authors = AuthorLocalServiceUtil.getAuthors(authorIds);
%>

This is author taglib