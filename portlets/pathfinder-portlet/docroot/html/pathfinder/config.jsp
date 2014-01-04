<%@include file="/html/pathfinder/init.jsp" %>
 
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
<td style="text-align: left;">
				<textarea class="portlet-form-input-field" rows="15" cols="27" name="<portlet:namespace />xsl"> value="<%=xsl %>" /></textarea>
			    <liferay-ui:icon image="help" url="javascript:onCSSHelp();"/>
			</td>


 <tr>	
    <td>Structure/Subject Source</td>
        <td><input type="text" name="<portlet:namespace />listset"  value="<%=listSetXmlUrl %>" />
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