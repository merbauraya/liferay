<%@ include file="/html/suburstatistic/init.jsp" %>


<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL.toString() %>" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveConfiguration();" %>'>
	<aui:input type="hidden" name="<%= Constants.CMD %>" value="<%= Constants.UPDATE %>" />
	<aui:fieldset>
		<aui:select label="view-type" name="preferences--viewType--">
			<aui:option selected="<%=displayStyle.equalsIgnoreCase(SuburStatUtil.VIEW_MONTHLY_SUMMARY) %>" label="View Monthly Summary" value="<%= SuburStatUtil.VIEW_MONTHLY_SUMMARY %>" />
			<aui:option selected="<%=displayStyle.equalsIgnoreCase(SuburStatUtil.VIEW_MONTHLY_SUMMARY_ITEMTYPE) %>" label="View Monthly Summary -Item Type" value="<%=SuburStatUtil.VIEW_MONTHLY_SUMMARY_ITEMTYPE %>" />
			<aui:option selected="<%=displayStyle.equalsIgnoreCase(SuburStatUtil.VIEW_MONTHLY_SUMMARY_CATEGORY) %>" label="View Monthly Summary -Category" value="<%=SuburStatUtil.VIEW_MONTHLY_SUMMARY_CATEGORY %>" />
			<aui:option selected="<%=displayStyle.equalsIgnoreCase(SuburStatUtil.VIEW_MONTHLY_SUMMARY_TAG) %>" label="View Monthly Summary -Tag" value="<%=SuburStatUtil.VIEW_MONTHLY_SUMMARY_TAG %>" />
		</aui:select>
		<aui:input name="preferences--assetVocabularyIds--" type="hidden" />
		
		<%
		Set<Long> availableAssetVocabularyIdsSet = SetUtil.fromArray(availableAssetVocabularyIds);

		// Left list

		List<KeyValuePair> typesLeftList = new ArrayList<KeyValuePair>();

		for (long assetVocabularyId : assetVocabularyIds) {
			try {
				AssetVocabulary assetVocabulary = AssetVocabularyLocalServiceUtil.getVocabulary(assetVocabularyId);

				assetVocabulary = assetVocabulary.toEscapedModel();

				typesLeftList.add(new KeyValuePair(String.valueOf(assetVocabularyId), _getTitle(assetVocabulary, themeDisplay)));
			}
			catch (NoSuchVocabularyException nsve) {
			}
		}

		// Right list

		List<KeyValuePair> typesRightList = new ArrayList<KeyValuePair>();

		Arrays.sort(assetVocabularyIds);

		for (long assetVocabularyId : availableAssetVocabularyIdsSet) {
			if (Arrays.binarySearch(assetVocabularyIds, assetVocabularyId) < 0) {
				AssetVocabulary assetVocabulary = AssetVocabularyLocalServiceUtil.getVocabulary(assetVocabularyId);

				assetVocabulary = assetVocabulary.toEscapedModel();

				typesRightList.add(new KeyValuePair(String.valueOf(assetVocabularyId), _getTitle(assetVocabulary, themeDisplay)));
			}
		}

		typesRightList = ListUtil.sort(typesRightList, new KeyValuePairComparator(false, true));
		%>

		<div class="<%= allAssetVocabularies ? "hide" : "" %>" id="<portlet:namespace />assetVocabulariesBoxes">
			<liferay-ui:input-move-boxes
				leftBoxName="currentAssetVocabularyIds"
				leftList="<%= typesLeftList %>"
				leftReorder="true"
				leftTitle="current"
				rightBoxName="availableAssetVocabularyIds"
				rightList="<%= typesRightList %>"
				rightTitle="available"
			/>
		</div>
		
		
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>


This is the <b>Subur Statistic</b> portlet in Config mode.
<%=mz %>

<aui:script>
Liferay.provide(
		window,
		'<portlet:namespace />saveConfiguration',
		function() {
			if (document.<portlet:namespace />fm.<portlet:namespace />assetVocabularyIds) {
				document.<portlet:namespace />fm.<portlet:namespace />assetVocabularyIds.value = Liferay.Util.listSelect(document.<portlet:namespace />fm.<portlet:namespace />currentAssetVocabularyIds);
			}

			submitForm(document.<portlet:namespace />fm);
		},
		['liferay-util-list-fields']
	);
	Liferay.Util.toggleSelectBox('<portlet:namespace />viewType', '<%=SuburStatUtil.VIEW_MONTHLY_SUMMARY_CATEGORY%>', '<portlet:namespace />assetVocabulariesBoxes');

</aui:script>
<%!
private String _getTitle(AssetVocabulary assetVocabulary, ThemeDisplay themeDisplay) {
	String title = assetVocabulary.getTitle(themeDisplay.getLanguageId());

	if (assetVocabulary.getGroupId() == themeDisplay.getCompanyGroupId()) {
		title += " (" + LanguageUtil.get(themeDisplay.getLocale(), "global") + ")";
	}

	return title;
}
%>