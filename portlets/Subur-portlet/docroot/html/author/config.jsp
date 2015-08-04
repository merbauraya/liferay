<%@ include file="/html/author/init.jsp" %>


<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />
<aui:form action="<%= configurationActionURL  %>" method="post" name="fm">

	<aui:input cssClass="fullwidth" value="<%= authorSalutationString %>" label="author-title-list" name="preferences--authorSalutation--" />
	<aui:input cssClass="fullwidth" value="<%= authorSiteNameString %>" label="author-site-name-list" name="preferences--authorSiteName--" />
	
	<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" persistState="<%= true %>" title="categorization">
	
	<%
	
	List<AssetVocabulary> groupVocabularies = AssetVocabularyLocalServiceUtil.getGroupVocabularies(themeDisplay.getScopeGroupId());
	
	
	int[] authorCategoryIndexes = null;
	Map<String,Long> authorCategoryMap = AuthorUtil.getAuthorCategories(authorCategoryXML);
	List<String> authorMapList = Collections.emptyList();
	
	
	if (authorCategoryMap != null)
	{
		authorCategoryIndexes = new int[authorCategoryMap.size()];
		authorMapList = new ArrayList<String>();

		int i = 0;
		for (Map.Entry<String,Long> entry : authorCategoryMap.entrySet() )
		{
			//out.print(entry.getKey() + "::"+ entry.getValue());
			authorCategoryIndexes[i] = i;
			authorMapList.add(i, entry.getKey());
			i++;
		}
	
		
	}else
	{
		authorCategoryIndexes = new int[]{0};
	}
	
	if (authorMapList.isEmpty())
	{
		authorMapList = new ArrayList<String>();
		authorMapList.add(StringPool.BLANK);
		authorCategoryMap = new HashMap<String,Long>();
		authorCategoryMap.put(StringPool.BLANK, 0L);
		
	}
	
	%>
		<div id="authorCategory">
	<%
		for (int i = 0; i < authorCategoryIndexes.length; i++)
		{
			int authorCategoryIndex = authorCategoryIndexes[i];
			String categoryName = authorMapList.get(i);
			long vocabularyId = authorCategoryMap.get(categoryName);
	
	%>	
		<div class="lfr-form-row">
			<div class="row-fields">
				<aui:col width="<%=50 %>">
					<aui:input name='<%= "authorCategory" + authorCategoryIndex %>' 
						type="hidden" value="<%= authorCategoryIndex %>" />
					
					<aui:input type="text" cssClass="fullwidth" label="category"
						name='<%= "categoryName" + authorCategoryIndex  %>' 
						value="<%=categoryName %>" 
					/>
				</aui:col>
				<aui:col width="<%=50 %>">
					<aui:select cssClass="small-input" inlineField="<%= true %>" label="type" name='<%= "vocabulary" +  authorCategoryIndex%>'>
					<%
						for (AssetVocabulary vocab: groupVocabularies) 
						{
							boolean selected = vocab.getVocabularyId() == vocabularyId;
					%>
						<aui:option selected="<%= selected %>"  value="<%=vocab.getVocabularyId() %>"><%=vocab.getName() %></aui:option>
					
					<%
						
						}
					%>
					
					</aui:select>
				</aui:col>
			</div>
		</div>	
				
	<%
		}
	%>
			<aui:input name="authorCategoryIndexes" type="hidden" value="<%= StringUtil.merge(authorCategoryIndexes) %>" />
			
		</div>
	</liferay-ui:panel>
	<aui:script use="liferay-auto-fields">
    new Liferay.AutoFields(
        	{
        		contentBox: '#authorCategory',
        		fieldIndexes: '<portlet:namespace />authorCategoryIndexes',
        		namespace: '<portlet:namespace/>'
        	}
        ).render();
  </aui:script>		
  
  
	
	
	<div class="button-holder">
		<aui:button type="submit" value="save"></aui:button>
	</div>
</aui:form>


		