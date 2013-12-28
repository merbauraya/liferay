<%@include file="/jsp/init.jsp" %>

<form action="<liferay-portlet:actionURL portletConfiguration="true" />"
method="post" name="<portlet:namespace />fm">
 
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
 
<table class="lfr-table">
<tr>
    <td>Eprint OAI URL</td>
        <td><input type="text" name="<portlet:namespace />eprintURL"  value="<%=eprintURL %>"/>
    </td>
 </tr>

<tr>
    <td>Record Source</td>
        <td><input type="text" name="<portlet:namespace />listrecord"  value="<%=listRecordXmlUrl %>"/>
    </td>
 </tr>
 <tr>	
    <td>Structure/Subject Source</td>
        <td><input type="text" name="<portlet:namespace />listset"  value="<%=listSetXmlUrl %>" />
    </td>
</tr>
 <tr>	
    <td>XSL Source</td>
        <td><input type="text" name="<portlet:namespace />xsl"  value="<%=xslUrl %>" />
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