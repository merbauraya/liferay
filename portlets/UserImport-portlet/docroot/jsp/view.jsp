<%@include file="/jsp/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>


<%
List<Object> departments = StaffLocalServiceUtil.getDepartment();

for (Object dept : departments)
{
	Object row[] = (Object[]) dept;
	out.println((String) row[0]);
}


%>

