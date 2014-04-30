<%@include file="/html/eprint/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.LocaleUtil" %>
 <%@ page import="java.util.ResourceBundle" %>
<%
	String eprintType = ParamUtil.getString(request, "type");
	String assetTagName = ParamUtil.getString(request, "tag");

%>
<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="jspPage" value="/html/eprintview/list.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:actionURL name="search" var="zzURL">
	
</liferay-portlet:actionURL>
<portlet:resourceURL var="navURL"/>


<portlet:resourceURL var="bySubjectURL">
	<portlet:param name="jspPage" value="/html/eprintview/bysubject.jsp" />
	<portlet:param name="isAjax" value="1"/>
	<portlet:param name="reqFormat" value="json"/>
	<portlet:param name="resType" value="bySubjectId" />
	<portlet:param name="subjectName" value="Latest Entry" />
	
</portlet:resourceURL>
<portlet:renderURL var="byDivisionURL">
<portlet:param name="jspPage" value="/html/eprintview/bydivision.jsp" />
</portlet:renderURL>

<portlet:renderURL var="detailURL">
<portlet:param name="jspPage" value="/html/eprintview/detail.jsp" />
<portlet:param name="eprintId" value="12" />
</portlet:renderURL>


<portlet:actionURL name="browseBySubject" var="browseBySubjectURL" />
<liferay-portlet:resourceURL id="bySubject" var="bySubjectUrl"/>

<div class="navbar">
	<div class="navbar-inner">
		<ul class="nav">
			<li><a class="eprint-nav" id="eprint-by-subject" href="#">By Subject</a></li>
			<li><a class="eprint-nav" id="eprint-by-division" href="#">By Division </a></li>
		</ul>
		<div class="collapse nav-collapse">
			<div class="navbar-search pull-right">
				<div class="form-search">
					<aui:form action="<%=searchURL %>" method="get" name="fm">
						<liferay-portlet:renderURLParams varImpl="searchURL" />
						<div class="input-append">
							<input name="q" type="text" placeholder="Search" class="search-query span9">
							<button class="btn" type="submit">Search</button>
						
						</div>
					</aui:form>
				
									
				</div>
			
			</div>
		
		</div>
	</div>

</div>




