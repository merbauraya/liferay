<%@include file="/jsp/init.jsp" %>

<liferay-theme:defineObjects/>
<%
WindowState windowState = liferayPortletRequest.getWindowState();
PortletPreferences preferences = renderRequest.getPreferences();
String portletResource = ParamUtil.getString(request, "portletResource");

if (Validator.isNotNull(portletResource)) 
{
    preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}
String  selectedCategory = preferences.getValue("selectedCategory","");
%>