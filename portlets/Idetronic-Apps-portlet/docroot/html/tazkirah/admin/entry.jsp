<%@ include file="/html/init.jsp" %>
<portlet:actionURL var="editEntryURL">
	<portlet:param name="<%=ActionRequest.ACTION_NAME%>" value="editEntry" />
</portlet:actionURL>
<portlet:actionURL var="addEntryURL">
	<portlet:param name="<%=ActionRequest.ACTION_NAME%>" value="addEntry" />
</portlet:actionURL>
<%
	String category = ParamUtil.getString(request, "category");
	long tazkirahId = ParamUtil.getLong(request, "tazkirahId");
	String cmd = ParamUtil.getString(request, Constants.CMD);
	String title = StringPool.BLANK;
	String content = StringPool.BLANK;
	
	String actionURL = addEntryURL;
	
	if (cmd.equals(Constants.EDIT))
	{
		
		actionURL = editEntryURL;
		Tazkirah tazkirah = TazkirahLocalServiceUtil.fetchTazkirah(tazkirahId);
		if (Validator.isNotNull(tazkirah))
		{
			title = tazkirah.getTitle();
			content = tazkirah.getContent();
			category = tazkirah.getCategory();
		}
		
		
	}
	
%>


<aui:form action="<%=actionURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "tazkirahEntry();" %>'>
	<aui:input name="<%= Constants.CMD %>" type="hidden" />
	<aui:input name="tazkirahId" type="hidden" value="<%=tazkirahId %>" />
	<aui:fieldset>
		<aui:select name="category">
			<% 
				for (int i = 0;i < categoryList.length; i++)
				{
			%>
				<aui:option selected="<%=category.equals(categoryList[i]) %>"
					value="<%=categoryList[i] %>">
					<liferay-ui:message key="<%=categoryList[i]  %>" />	
					 </aui:option>
			<%	} %>
		</aui:select>
		<aui:input name="title" value="<%=title %>" />
		<aui:field-wrapper label="content">
			<liferay-ui:input-editor width="100%" />
			<aui:input name="content" type="hidden" />
		</aui:field-wrapper>
		<aui:button type="submit" value="Save" />
	</aui:fieldset>


</aui:form>

<aui:script>
	function <portlet:namespace />initEditor() {
		return "<%= UnicodeFormatter.toString(content) %>";
	}

	

	function <portlet:namespace />tazkirahEntry() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= (Validator.isNull(tazkirahId)) ? Constants.ADD : Constants.UPDATE %>";
		document.<portlet:namespace />fm.<portlet:namespace />content.value = window.<portlet:namespace />editor.getHTML();
		submitForm(document.<portlet:namespace />fm);
	}
</aui:script>