<%@include file="/html/eprint/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.LocaleUtil" %>
 <%@ page import="java.util.ResourceBundle" %>
<%
	String eprintType = ParamUtil.getString(request, "type");
	String assetTagName = ParamUtil.getString(request, "tag");

%>


<portlet:renderURL var="renderURL">
<portlet:param name="jspPage" value="/html/view/bysubject.jsp" />
</portlet:renderURL>
<portlet:renderURL var="byDivisionURL">
<portlet:param name="jspPage" value="/html/view/bydivision.jsp" />
</portlet:renderURL>

<portlet:renderURL var="detailURL">
<portlet:param name="jspPage" value="/html/view/detail.jsp" />
<portlet:param name="eprintId" value="12" />
</portlet:renderURL>


<portlet:actionURL name="browseBySubject" var="browseBySubjectURL" />
<liferay-portlet:resourceURL id="bySubject" var="bySubjectUrl"/>
This is the <b>Eprint Harvester</b> portlet in View mode.
<%
	//List<EprintSubject> ep = EprintSubjectServiceUtil.getAll();

%>
<a href="<%=renderURL.toString()%>">By Subject</a>
<a href="<%=byDivisionURL.toString() %>">By Division </a>
<a href="<%=detailURL.toString() %>">By Division </a>

<%
  String lang = LocaleUtil.toLanguageId(themeDisplay.getLocale());	
  out.print(themeDisplay.getLocale() + "lang="+lang);
  ResourceBundle res = portletConfig.getResourceBundle(themeDisplay.getLocale());
  out.print(res.getString("model.resource.com.idetronic.eprint.model.Eprint"));
  
%>