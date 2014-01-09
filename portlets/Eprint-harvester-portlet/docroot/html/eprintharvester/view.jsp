<%@ include file="/html/eprintharvester/init.jsp" %>

<portlet:actionURL name="browseBySubject" var="browseBySubjectURL" />
<liferay-portlet:resourceURL id="bySubject" var="bySubjectUrl"/>
This is the <b>Eprint Harvester</b> portlet in View mode.
<%
	//List<EprintSubject> ep = EprintSubjectServiceUtil.getAll();

%>
<a href="<%=browseBySubjectURL.toString()%>">By Subject</a>