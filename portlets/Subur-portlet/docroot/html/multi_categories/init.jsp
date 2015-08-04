
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetVocabulary"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portlet.asset.service.AssetVocabularyServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>

<%@include file="/html/subur/init.jsp" %>

<%

boolean selectRootCategory = GetterUtil.getBoolean(portletPreferences.getValue("selectRootCategory", Boolean.TRUE.toString()));

List<AssetVocabulary> assetVocabularies = AssetVocabularyServiceUtil.getGroupsVocabularies(new long[] {scopeGroupId, themeDisplay.getCompanyGroupId()});

long[] availableAssetVocabularyIds = new long[assetVocabularies.size()];

for (int i = 0; i < assetVocabularies.size(); i++) {
	AssetVocabulary assetVocabulary = assetVocabularies.get(i);

	availableAssetVocabularyIds[i] = assetVocabulary.getVocabularyId();
}

boolean allAssetVocabularies = GetterUtil.getBoolean(portletPreferences.getValue("allAssetVocabularies", Boolean.TRUE.toString()));
boolean singleVocab = !allAssetVocabularies;

long[] assetVocabularyIds = availableAssetVocabularyIds;

if (!allAssetVocabularies && (portletPreferences.getValues("assetVocabularyIds", null) != null)) {
	assetVocabularyIds = StringUtil.split(portletPreferences.getValue("assetVocabularyIds", null), 0L);
	singleVocab = (assetVocabularyIds.length == 1);
}

displayStyle = portletPreferences.getValue("displayStyle", StringPool.BLANK);
long displayStyleGroupId = GetterUtil.getLong(portletPreferences.getValue("displayStyleGroupId", null), themeDisplay.getScopeGroupId());
%>
