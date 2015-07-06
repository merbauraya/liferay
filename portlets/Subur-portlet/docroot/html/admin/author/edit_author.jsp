<%@ include file="/html/init.jsp" %>

<%

	String redirect = ParamUtil.getString(request, "redirect");
	String backURL = ParamUtil.getString(request, "backURL", redirect);

	
	String[] titles = StringUtil.split(authorTitleString, ",");
	long authorId = ParamUtil.getLong(request,"authorId");
	Author author = null;
	if (Validator.isNotNull(authorId))
	{
		author = AuthorLocalServiceUtil.getAuthor(authorId);
	}
%>
<liferay-ui:header
	backURL="<%= backURL %>"
	localizeTitle="<%= (author == null) %>"
	title='<%= (author == null) ? "new-author" : author.getLastName()+","+author.getFirstName() %>'
/>
<portlet:actionURL var="editAuthorActionURL" name="editAuthor">

	<portlet:param name="backURL" value="<%= backURL %>" />
</portlet:actionURL>
<aui:form action="<%=editAuthorActionURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= (author == null) ? Constants.ADD : Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="authorId" type="hidden" value="<%= authorId %>" />
	
	<aui:model-context bean="<%= author %>" model="<%= Author.class %>" />
	<aui:fieldset>
		<aui:select name="title">
		<%	for (String authorTitle : titles) {
			boolean selected = false;
			if ((author != null) && (author.getTitle() == authorTitle))
				selected = true;
		%>
			<aui:option selected="<%= selected %>"  value="<%=authorTitle %>"><%=authorTitle %></aui:option>
		<%
		}
		%>
		</aui:select>
		<aui:input name="firstName" />
	
		<aui:input name="lastName" />
		<aui:input name="personalSite" />
		
		
		<aui:button-row>
			<aui:button type="submit" />

			<aui:button href="<%= redirect %>" type="cancel" />
		</aui:button-row>
	</aui:fieldset>



<%
	boolean autoFocus = true;
	PortletResponse portletResponse = (PortletResponse)request.getAttribute(JavaConstants.JAVAX_PORTLET_RESPONSE);
	String contentCallback = portletResponse.getNamespace() + "getSuggestionsContent";
	
	String curTags = StringPool.BLANK;
	if (author!= null)
	{
		List<Expertise> curExpertises = AuthorLocalServiceUtil.getExpertises(authorId);
		curTags = ListUtil.toString(curExpertises,"expertiseName");
	}
	
	long[] groupIds = new long[] {themeDisplay.getScopeGroupId() } ;
	String className = SuburItem.class.getName();
	String namespace = portletResponse.getNamespace();
	String hiddenInput = "expertiseNames";
	String id = GetterUtil.getString((String)request.getAttribute("liferay-ui:asset-tags-selector:id"));
	out.print(id);
%>
<div class="lfr-tags-selector-content" id="<%= namespace + id %>assetTagsSelector">
	<aui:input name="<%= hiddenInput %>" type="hidden" />

	<input class="lfr-tag-selector-input" id="<%= id %>assetTagNames" maxlength="75" size="15" title="<liferay-ui:message key="add-tags" />" type="text" />
</div>

<aui:script use="expertise-tags-selector">
	new Liferay.ExpertiseTagsSelector(
		{
			allowSuggestions: <%= false %>,
			contentBox: '#<%= namespace + id %>assetTagsSelector',

			<c:if test="<%= Validator.isNotNull(contentCallback) %>">
				contentCallback: function() {
					if (window.<%= contentCallback %>) {
						return <%= contentCallback %>();
					}
				},
			</c:if>

			curEntries: '<%= HtmlUtil.escapeJS(curTags) %>',

			<c:if test="<%= groupIds != null %>">
				groupIds: '<%= StringUtil.merge(groupIds) %>',
			</c:if>

			hiddenInput: '#<%= namespace + hiddenInput %>',
			input: '#<%= id %>assetTagNames',
			instanceVar: '<%= namespace + id %>',
			portalModelResource: <%= Validator.isNotNull(className) && (ResourceActionsUtil.isPortalModelResource(className) || className.equals(Group.class.getName())) %>
		}
	).render();

	<c:if test="<%= autoFocus %>">
		Liferay.Util.focusFormField('#<%= id %>assetTagNames');
	</c:if>
</aui:script>
</aui:form>