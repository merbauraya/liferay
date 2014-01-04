<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletURL"%> 
<%@page import="com.idetronic.portlet.ProxyConstant"%>

<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.liferay.portal.kernel.util.Constants" %>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.util.PortalUtil" %>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %>
<%@page import="javax.portlet.PortletPreferences" %>
<%@page import="javax.portlet.WindowState" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil" %>
<portlet:defineObjects />
<liferay-theme:defineObjects/>
<%
WindowState windowState = liferayPortletRequest.getWindowState();

String currentURL = PortalUtil.getCurrentURL(request);

PortletPreferences preferences = renderRequest.getPreferences();
 
String portletResource = ParamUtil.getString(request, "portletResource");
 
if (Validator.isNotNull(portletResource)) 
{
    preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

String proxyURL = preferences.getValue("url","");


%>