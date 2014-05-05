<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="javax.portlet.PortletURL"%> 
<%@ page import="javax.portlet.ActionRequest"%>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="javax.portlet.PortletMode" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page import="com.liferay.portal.kernel.util.TextFormatter" %>
<%@ page import="com.liferay.portal.kernel.bean.BeanParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.KeyValuePair" %>
<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>
<%@ page import="com.liferay.portlet.PortletURLFactoryUtil" %>
<%@ page import="com.idetronic.tazkirah.util.TazkirahUtil" %>
<%@ page import="com.idetronic.tazkirah.model.Tazkirah" %>
<%@ page import="com.idetronic.tazkirah.service.TazkirahLocalServiceUtil" %>
<%@ page import="com.idetronic.tazkirah.TazkirahConfig" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
	String language = portletPreferences.getValue("language", StringPool.BLANK);
	String categories = PropsUtil.get("tazkirah.category");
	//List<String> categoryList = Arrays.asList(categories.split(","));
	String[] displayCategories = StringUtil.split(portletPreferences.getValue("selectedCategory", StringPool.BLANK),",");
	String[] categoryList = StringUtil.split(categories,",");
	String currentURL = PortalUtil.getCurrentCompleteURL(request);
%>