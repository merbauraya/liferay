<%@ include file="/html/init.jsp" %>
<%@ page import="com.idetronic.subur.util.AuthorUtil" %>

<%
	String authorSalutationString = GetterUtil.getString(portletPreferences.getValue("authorSalutation",StringPool.BLANK), StringPool.BLANK);
	String authorSiteNameString = GetterUtil.getString(portletPreferences.getValue("authorSiteName", StringPool.BLANK))	;		
	String authorCategoryXML = GetterUtil.getString(portletPreferences.getValue("authorCategory", StringPool.BLANK))	;
%>
