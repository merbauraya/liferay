<%@ include file="/html/author/init.jsp" %>

<%

	String redirect = ParamUtil.getString(request, "redirect");
	String backURL = ParamUtil.getString(request, "backURL", redirect);
	String[] siteNameList = StringUtil.split(authorSiteNameString,",");
	
	
	String[] titles = StringUtil.split(authorSalutationString, ",");
	long authorId = ParamUtil.getLong(request,"authorId");
	Author author = null;
	List<AuthorSite> authorSites = Collections.emptyList();
	int[] authorSiteIndexes = null;
	
	
	if (Validator.isNotNull(authorId))
	{
		author = AuthorLocalServiceUtil.getAuthor(authorId);
		authorSites = AuthorSiteLocalServiceUtil.findByAuthorId(authorId);
		authorSiteIndexes = new int[authorSites.size()];
		for (int i = 0; i < authorSites.size(); i++)
		{
			authorSiteIndexes[i] = i;
		}
		
		
		
	}else
	{
		authorSiteIndexes = new int[] {0};
		
	}
	if (authorSites.isEmpty())
	{
		authorSites = new ArrayList<AuthorSite>();
		authorSites.add(new AuthorSiteImpl());
		authorSiteIndexes = new int[] {0};
	}
	if (authorSiteIndexes == null)
	{
		authorSiteIndexes = new int[] {0};
	}
	
%>
isEmpty = <%=authorSiteIndexes.length%>
<liferay-ui:header
	backURL="<%= backURL %>"
	localizeTitle="<%= (author == null) %>"
	title='<%= (author == null) ? "new-author" : author.getDisplayName() %>'
/>
<portlet:actionURL var="editAuthorActionURL" name="editAuthor">

	<portlet:param name="backURL" value="<%= backURL %>" />
</portlet:actionURL>
<aui:form action="<%=editAuthorActionURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "submitForm();" %>'>
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
		<aui:input name="firstName" cssClass="fullwidth" />
		<aui:input name="middleName" cssClass="fullwidth"/>
		<aui:input name="lastName" cssClass="fullwidth"/>
		<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" persistState="<%= true %>" title="categorization">
			<%
				PortletURL portletURL = renderResponse.createRenderURL();
				/*
				String authorVocabularyIdString = null;
				Map<String,Long> authorCategoryMap = AuthorUtil.getAuthorCategories(authorCategoryXML);
				long[] authorVocabs = null;
				
				if (authorCategoryMap != null && authorCategoryMap.size() > 0 )
				{
					authorVocabs = new long[authorCategoryMap.size()];
					int i = 0;
					for (Map.Entry<String,Long> entry : authorCategoryMap.entrySet())
					{
						
						authorVocabs[i] = entry.getValue();
						i++;
					}
					authorVocabularyIdString = StringUtil.merge(authorVocabs);
					
				}
				*/
			%>
			<aui:input 
				classPK="<%= (author != null ? author.getAuthorId(): 0L) %>" 
				model="<%= Author.class %>" 
				name="categories" 
				className="<%= Author.class.getName() %>"
			type="assetCategories" />
				
			
		<aui:input type="hidden" name="categoryIds" id="categoryIds" value=""/>			
		
		
		
		</liferay-ui:panel>
		
		
		
		<h5>
<liferay-ui:message key="author-site"/>
</h5>
		<div id="authorSite">
		<%
			for (int i = 0; i < authorSiteIndexes.length; i++) {
				int authorSiteIndex = authorSiteIndexes[i];
				AuthorSite authorSite = authorSites.get(i);
		%>
		
			<aui:model-context bean="<%= authorSite %>" model="<%= AuthorSite.class %>" />
			<div class="lfr-form-row lfr-form-row-inline">
				<div class="row-fields">
					<aui:input name='<%= "authorSiteId" + authorSiteIndex %>' type="hidden" value="<%= authorSite.getAuthorSiteId() %>" />
					<aui:select inlineField="<%= true %>" label="type" name='<%= "siteName" +  authorSiteIndex%>'>
					<%
						for (String siteName : siteNameList) 
						{
							boolean selected = false;
							if (siteName.equalsIgnoreCase(authorSite.getSiteName())) 
								selected = true;
					%>
						<aui:option selected="<%= selected %>"  value="<%=siteName %>"><%=siteName %></aui:option>
					<%		
						}
					%>
					</aui:select>
					
					<aui:input label="site-url" fieldParam='<%= "siteURL" + authorSiteIndex %>' 
						id='<%= "siteURL" + authorSiteIndex %>'
						inlineField="<%= true %>" 
						name='siteURL' 
						cssClass="fullwidth"
						
						/>
					
				</div>
			
			</div>
		<%
			}
		%>
		<aui:input name="authorSiteIndexes" type="hidden" value="<%= StringUtil.merge(authorSiteIndexes) %>" />
		</div>
		<aui:script use="liferay-auto-fields">
    new Liferay.AutoFields(
    	{
    		contentBox: '#authorSite',
    		fieldIndexes: '<portlet:namespace />authorSiteIndexes',
    		namespace: '<portlet:namespace/>'
    	}
    ).render();
  </aui:script>
	
		
		
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
	
%>
<h5>
<liferay-ui:message key="research-interest"/>
</h5>
<div class="lfr-tags-selector-content" id="<%= namespace + id %>assetTagsSelector">
	<aui:input name="<%= hiddenInput %>" type="hidden" />

	<input class="lfr-tag-selector-input" id="<%= id %>assetTagNames" maxlength="75" size="35" title="<liferay-ui:message key="add-tags" />" type="text" />
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
	<aui:button-row>
	<aui:button type="submit" />
	
	<aui:button href="<%= redirect %>" type="cancel" />
	</aui:button-row>
</aui:form>
<aui:script>
function <portlet:namespace />submitForm()
{
	var A = AUI();
	var assetCategoryIdArr = [];
	var catdIds = A.all('input[name^=<portlet:namespace/>assetCategoryIds]');
	
	catdIds.each(function(){
		assetCategoryIdArr.push(this.val());
		
		
		
	});
	A.one("#<portlet:namespace/>categoryIds").val(assetCategoryIdArr);
	alert(assetCategoryIdArr);
	submitForm(document.<portlet:namespace />fm);
	
}
</aui:script>


<%!
private static Log _log = LogFactoryUtil.getLog("subur.html.edit.author");
%>