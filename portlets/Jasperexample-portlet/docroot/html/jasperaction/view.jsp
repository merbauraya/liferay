<%@include file="init.jsp"%>
<portlet:resourceURL var="jasperActionURL"  >
<portlet:param name="jspPage" value="/html/jasperaction/view.jsp"/>
</portlet:resourceURL>
<form action="<%=jasperActionURL.toString()%>" name="fm" id="fm" enctype="multipart/form-data" method="post">
<h3>browse jrxml file</h3>
<input name="file" type="file" value=""/ >
<input type="submit" name="userReports" value="getUserreports"></input>
</form>