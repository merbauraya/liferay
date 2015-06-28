<%@ include file="/html/taglib/subur/init.jsp" %>
<%@ page import="java.lang.reflect.Method" %>
<%@ page import="java.lang.reflect.Array" %>
<%



long itemId = GetterUtil.getLong((String)request.getAttribute("subur:item-author-display:itemId"));
PortletURL viewAuthorURL =(PortletURL) request.getAttribute("subur:item-author-display:viewAuthorURL");
Object itemAuthor  = (Object)PortletBeanLocatorUtil.locate("Subur-portlet","ItemAuthorLocalService");

Method getAuthorMethod = itemAuthor.getClass().getMethod("getAuthorArray",new Class[]{long.class});

Object authors =  getAuthorMethod.invoke(itemAuthor,itemId);
Class type = authors.getClass();
Object authorList = null; 
if (type.isArray())
{
	int length = Array.getLength(authors);
	  
     Class componentType = type.getComponentType();
     authorList = Array.newInstance(componentType, length);
     for (int i=0; i<length; i++) {
        Array.set(authorList, i, Array.get(authors, i));
     }
}
%>

	<%
		if (authorList != null && Array.getLength(authorList) > 0){
			for (int i = 0; i < Array.getLength(authorList) ; i++)
			{
				Object author = Array.get(authorList,i);
				String lastName = (String)author.getClass().getMethod("getLastName", null).invoke(author);
				String firstName = (String)author.getClass().getMethod("getFirstName", null).invoke(author);
				String displayName = (String)author.getClass().getMethod("getDisplayName",null).invoke(author);
				
				long authorId = (Long)author.getClass().getMethod("getAuthorId", null).invoke(author);
				
				if (viewAuthorURL != null)
					viewAuthorURL.setParameter("authorId",String.valueOf(authorId));
				
		%>
				<c:choose>
					<c:when test="<%= viewAuthorURL != null %>">
						<a class="author-link" href="<%= HtmlUtil.escape(viewAuthorURL.toString()) %>"><%= displayName %></a>
						
					</c:when>
					<c:otherwise>
						<%= displayName.concat(StringPool.BLANK) %>
					
					</c:otherwise>
				</c:choose>
				
		<%
			}
		} else
		{
		%>
		<liferay-ui:message key="no-author-found" />
		<%} 
	%>

