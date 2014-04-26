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

<%@ page import="java.util.List"%> 
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="javax.portlet.ActionRequest"%>
<%@ page import="javax.portlet.PortletURL"%> 
<%@ page import="javax.portlet.ResourceURL"%> 
<%@ page import="javax.portlet.PortletContext" %>
<%@ page import="java.text.Format" %>
<%@ page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portlet.asset.model.AssetEntry" %>
<%@ page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.asset.service.AssetEntryServiceUtil" %>
<%@ page import="com.liferay.portal.service.permission.PortletPermissionUtil" %>
<%@ page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@ page import="com.liferay.portlet.asset.NoSuchEntryException" %>
<%@ page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@ page import="com.liferay.portal.security.auth.PrincipalException" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil" %>
<%@ page import="com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="javax.portlet.WindowState" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<%@ page import="com.idetronic.eprint.EprintConstant"%>
<%@ page import="com.idetronic.eprint.model.Eprint"%>
<%@ page import="com.idetronic.eprint.admin.*"%> 
<%@ page import="com.idetronic.eprint.service.*"%> 
<%@ page import="com.idetronic.eprint.EprintConfig" %>
<%@ page import="com.idetronic.eprint.service.persistence.EprintFinderUtil" %>
<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
boolean canEdit = PortletPermissionUtil.contains(
permissionChecker, layout, portletDisplay.getRootPortletId(), ActionKeys.UPDATE);
boolean canDelete = PortletPermissionUtil.contains(permissionChecker, layout, portletDisplay.getRootPortletId(), ActionKeys.DELETE);

Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);
boolean enableComments = true;
boolean enableFlags = true;
boolean enableRatings = true;
boolean showRelatedAssets = true;
%>