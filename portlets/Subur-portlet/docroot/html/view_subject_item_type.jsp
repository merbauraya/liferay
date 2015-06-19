<%@include file="/html/init.jsp"%>
/*
	View list of Subur Item by Subject and Item Type

*/
<%
	long subjectId = ParamUtil.getLong(request, "subjectId");
	long itemTypeId = ParamUtil.getLong(request, "itemTypeId");
	
%>