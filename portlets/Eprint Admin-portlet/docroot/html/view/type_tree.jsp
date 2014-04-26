<%@include file="/html/eprint/init.jsp" %>

<%
	List<Object> results = EprintLocalServiceUtil.byTypeSummary();
	
	for (int i=0; i < eprintTypes.size();i++ )
	{
		out.print(eprintTypes.get(i));
	}

%>
