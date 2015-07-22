<%@include file="/html/init.jsp"%>

<%@page import="java.util.Set"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.liferay.portal.kernel.util.SetUtil"%>
<%@page import="com.liferay.portal.kernel.util.KeyValuePair"%>
<%@page import="com.liferay.portlet.asset.NoSuchVocabularyException"%>
<%@page import="com.liferay.portal.kernel.util.KeyValuePairComparator"%>
<%@page import="com.idetronic.subur.util.SuburStatUtil"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>

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

String displayType = portletPreferences.getValue("viewType", "monthlySummary");
PortletPreferences preferences = renderRequest.getPreferences();
String portletResource = ParamUtil.getString(request, "portletResource");
if (Validator.isNotNull(portletResource)) 
{
	preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}
String mz = preferences.getValue("itemType","");

%>