<%@ include file="/html/init.jsp" %>
<%@ page import="com.liferay.portlet.documentlibrary.model.DLFileEntry" %>
<%@ page import="com.liferay.portlet.documentlibrary.model.DLFileVersion" %>
<%@ page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.blogs.service.BlogsEntryServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@ page import="com.idetronic.eprint.service.EprintLocalServiceUtil"%> 
<%@ page import="com.idetronic.eprint.model.Eprint" %>
<%@ page import="com.liferay.portal.model.Organization" %>
<%@ page import="com.liferay.portal.service.OrganizationLocalServiceUtil" %>
<%@ page import="com.idetronic.tabview.TabViewConfig" %>
<%@ page import="com.liferay.portlet.blogs.service.permission.BlogsEntryPermission" %>
<%@ page import="com.liferay.portlet.documentlibrary.service.permission.DLFileEntryPermission" %>


<%
	long organizationId = GetterUtil.getLong(portletPreferences.getValue("organizationId", "0"));
	int max = GetterUtil.getInteger(portletPreferences.getValue("max", "10"));
	TabViewConfig viewConfig = (TabViewConfig)request.getAttribute("config");
%>