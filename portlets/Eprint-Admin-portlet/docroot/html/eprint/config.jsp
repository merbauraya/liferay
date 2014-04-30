<%@include file="/html/eprint/init.jsp"%>
<%@page import="com.idetronic.eprint.admin.EprintAdminConfig" %>
<liferay-portlet:actionURL portletConfiguration="true" var="configActionUrl"/>
<%
EprintAdminConfig epConfig = (EprintAdminConfig)request.getAttribute("eprintConfig");	
String cChecked = epConfig.getUseDefaultUser() ? "checked": "";
%>
<form action="<%=configActionUrl.toString() %>" role="form" method="post" class="form-horizontal" name="<portlet:namespace />configuration">
	<div class="checkbox">
    <label>
      <input <%=cChecked %> type="checkbox" name="useDefaultUser"> Use default user for importing repository.User id[<span><%=epConfig.getUserId() %> </span>]
    </label>
  </div>
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Save</button>
    </div>
  

</form>


