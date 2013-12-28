<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
 
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
 
 
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="javax.portlet.WindowState" %>
<%@ page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@ page import="javax.portlet.ActionRequest" %>
<%@ page import="javax.portlet.PortletPreferences" %>
 
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="java.net.URL" %>
<%@page import="java.io.*" %>
<%@page import="com.idetronic.portlet.model.staff_active" %>
<%@page import="com.liferay.portal.kernel.util.StringUtil" %>
<%@page import="com.idetronic.portlet.service.staff_activeLocalServiceUtil" %> 
<liferay-theme:defineObjects />
<portlet:defineObjects />
<liferay-portlet:renderURL var = "portletURL" portletName="custom-liferaymvc_WAR_custom-liferaymvcportlet"/>
<portlet:actionURL name="addName" var="addNameUrl"></portlet:actionURL> 

<portlet:renderURL var="listSetUrl">
	<portlet:param name="jspPage" value="/jsp/listSet.jsp" />
	<portlet:param name="action"  value="listset" />
</portlet:renderURL>

<portlet:renderURL var="listByTypeUrl">
	<portlet:param name="jspPage" value="/jsp/listSet.jsp" />
	<portlet:param name="action"  value="type" />
</portlet:renderURL>
<portlet:renderURL var="listRecordUrl">
	
	<portlet:param name="action" value="ListRecord"></portlet:param>
</portlet:renderURL>
<portlet:renderURL var="bySubjectUrl">
	<portlet:param name="action" value="bySubject"></portlet:param>
</portlet:renderURL>
<portlet:renderURL var="byTypeUrl">
	<portlet:param name="action" value="byType"></portlet:param>
</portlet:renderURL>
<%


String currentURL = PortalUtil.getCurrentURL(request);
 
PortletPreferences preferences = renderRequest.getPreferences();
 
String portletResource = ParamUtil.getString(request, "portletResource");
 
if (Validator.isNotNull(portletResource)) 
{
    preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

String dbUrl = preferences.getValue("dbUrl","jdbc:postgresql://127.0.0.1:5432/mydatabase");
String  dbPassword = preferences.getValue("dbPassword","password");
String dbUser = preferences.getValue("dbUser","user");
String  dbDriver = preferences.getValue("dbDriver", "org.postgresql.Driver");

 

 
// get our portlet URL

%>