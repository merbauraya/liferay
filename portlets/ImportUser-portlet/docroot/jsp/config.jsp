<%@include file="/jsp/init.jsp" %>
 
<form action="<liferay-portlet:actionURL portletConfiguration="true" />"
method="post" name="<portlet:namespace />fm">
 
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
 
<table class="lfr-table">
<tr>
    <td>Database URL</td>
        <td><input type="text" name="<portlet:namespace />dbUrl"  value="<%="" %>"/>
    </td>
 </tr>
 <tr>
<tr>
    <td>Jdbc Driver</td>
        <td><input type="text" name="<portlet:namespace />dbDriver"  value="<%=dbDriver %>"/>
    </td>
 </tr>
 <tr>	
    <td>Db User</td>
        <td><input type="text" name="<portlet:namespace />dbUser"  value="<%=dbUser %>" />
    </td>
</tr>
 <tr>	
    <td>Db Password</td>
        <td><input type="text" name="<portlet:namespace />dbPassword"  value="<%=dbPassword %>" />
    </td>
</tr>

<tr>
       <td colspan="2">
            <input type="button" value="<liferay-ui:message key="save" />"
onClick="submitForm(document.<portlet:namespace />fm);" />
       </td>
</tr>
</table>
</form>