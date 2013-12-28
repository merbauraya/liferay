<%@include file="/jsp/init.jsp" %>
<liferay-portlet:actionURL portletConfiguration="true" var="configActionUrl"/>



<form name="fm" method="POST" action="<%=configActionUrl.toString() %>" inlineLabel="false">
	<aui:layout>
		<aui:input name="url" value="<%=proxyURL %>"></aui:input>
		 
			
   
	</aui:layout>
	
 	 <input type="Submit" value="Save">
 
</form>
