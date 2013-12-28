<%@include file="/html/library/init.jsp"%>
<%@page import="com.library.LibraryConstants"%>
<h1>Add / Edit Form</h1>
<br/><a href="<portlet:renderURL/>">&laquo; Go Back</a>

<%
PortletURL updateBookURL = renderResponse.createActionURL();
updateBookURL.setParameter(
ActionRequest.ACTION_NAME, LibraryConstants.ACTION_UPDATE_BOOK);
%>
<aui:form name="fm" method="POST"
action="<%= updateBookURL.toString() %>">
<aui:input name="bookTitle" label="Book Title" helpMessage="Book title">
	<aui:validator name="required" errorMessage="Please enter book title"/>
</aui:input>
<aui:input name="author" />
<aui:button type="submit" value="Save" />
</aui:form>



<aui:script>
Liferay.Util.focusFormField(
document.<portlet:namespace/>fm.<portlet:namespace/>bookTitle);
</aui:script>