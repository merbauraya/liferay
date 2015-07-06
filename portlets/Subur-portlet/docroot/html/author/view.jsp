<%@ include file="/html/init.jsp" %>

<%
	long authorId = ParamUtil.getLong(request, "authorId");

	out.print("au="+authorId);
%>