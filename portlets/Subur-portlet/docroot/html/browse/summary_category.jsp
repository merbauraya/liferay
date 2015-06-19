<%@ include file="/html/init.jsp" %>


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
	vocabularyIds = availableAssetVocabularyIds;
	
	
	for (long vocabularyId: vocabularyIds)
	{
		int count = SuburUtil.countAssetVocabularyById(vocabularyId);
		AssetVocabulary vocabulary = AssetVocabularyLocalServiceUtil.getAssetVocabulary(vocabularyId);
		%>
		
			
	<%
	}
	%>
	xxxx
	
