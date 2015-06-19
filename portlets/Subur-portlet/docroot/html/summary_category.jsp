<%@ include file="/html/init.jsp" %>


<liferay-ui:panel-container cssClass="taglib-asset-categories-navigation" extended="<%= true %>">
<%

	boolean selectRootCategory = GetterUtil.getBoolean(portletPreferences.getValue("selectRootCategory", Boolean.TRUE.toString()));
	
	List<AssetVocabulary> assetVocabularies = AssetVocabularyServiceUtil.getGroupsVocabularies(new long[] {scopeGroupId, themeDisplay.getCompanyGroupId()});
	
	long[] availableAssetVocabularyIds = new long[assetVocabularies.size()];
	
	for (int i = 0; i < assetVocabularies.size(); i++) {
		AssetVocabulary assetVocabulary = assetVocabularies.get(i);
	
		availableAssetVocabularyIds[i] = assetVocabulary.getVocabularyId();
	}
	
	boolean allAssetVocabularies = GetterUtil.getBoolean(portletPreferences.getValue("allAssetVocabularies", Boolean.TRUE.toString()));
	
	long[] assetVocabularyIds = availableAssetVocabularyIds;
	
	if (!allAssetVocabularies && (portletPreferences.getValues("assetVocabularyIds", null) != null)) {
		assetVocabularyIds = StringUtil.split(portletPreferences.getValue("assetVocabularyIds", null), 0L);
	}

	String displayStyle = portletPreferences.getValue("displayStyle", StringPool.BLANK);
	long displayStyleGroupId = GetterUtil.getLong(portletPreferences.getValue("displayStyleGroupId", null), themeDisplay.getScopeGroupId());
	long[] vocabularyIds ;
	String[] categoryIds = StringUtil.split(StringPool.BLANK);
	vocabularyIds = availableAssetVocabularyIds;
	
	
	for (long vocabularyId: vocabularyIds)
	{
		int count = SuburUtil.countAssetVocabularyById(vocabularyId);
		AssetVocabulary vocabulary = AssetVocabularyLocalServiceUtil.getAssetVocabulary(vocabularyId);
		vocabulary = vocabulary.toEscapedModel();
		
		%>
		<liferay-ui:panel collapsible="<%= false %>" extended="<%= true %>" persistState="<%= true %>" 
						title="<%= vocabulary.getTitle(locale) %>">
						
					</liferay-ui:panel>
			
	<%
	
	
	
	}
	%>
	</liferay-ui:panel-container>
	
	
