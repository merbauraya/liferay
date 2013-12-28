<%@include file="/html/library/init.jsp"%>
<%@page import="com.library.LibraryConstants"%>
<portlet:renderURL var="updateBookURL">
<portlet:param name="jspPage" value="<%=LibraryConstants.PAGE_UPDATE%>"/>
</portlet:renderURL>
<%
PortletURL listBooksURL = renderResponse.createRenderURL();
listBooksURL.setParameter("jspPage", "/html/library/list.jsp");
%>
<br/><a href="<%= updateBookURL %>">Add new Book &raquo;</a> |
<a href="<%= listBooksURL.toString() %>">Show All Books &raquo;</a>
<hr/>

&nbsp;|&nbsp;

<hr/>

<a href="#" id="jqueryText">jQuery in action</a>
<div id="sayHelloDiv" style="display:none">jQuery is working</div>
<script type="text/javascript">
$(document).ready(function(){
	$('#jqueryText').on('click',function(){
	$('#sayHelloDiv').toggle();
	});
});
</script>

<hr/>
code below in your <div id="tabs">
<ul>

<li><a href="#tabs-1">Tab One</a></li>
tabs support of jQuery
<li><a href="#tabs-2">Tab Two</a></li>
<li><a href="#tabs-3">Tab Three</a></li>
UI library.
</ul>
<div id="tabs-1">Tab 1 content</div>
<div id="tabs-2">Tab 2 content</div>
<div id="tabs-3">Tab 3 content</div>
</div>
<script type="text/javascript">
$(function() {
	$("#tabs").tabs();

});
</script>