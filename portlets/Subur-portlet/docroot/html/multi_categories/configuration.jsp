
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="com.liferay.portal.kernel.template.TemplateHandlerRegistryUtil"%>
<%@page import="com.liferay.portal.kernel.template.TemplateHandler"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.KeyValuePairComparator"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Set"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.SetUtil"%>
<%@page import="com.liferay.portlet.asset.NoSuchVocabularyException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.KeyValuePair"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>

<%@ include file="/html/multi_categories/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveConfiguration();" %>'>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />

	<aui:fieldset>

		<aui:input label="label-multi-categories-tags-select-root-category"
			name="preferences--selectRootCategory--" 
			type="checkbox" checked="<%=selectRootCategory %>"/>

		<aui:select label="vocabularies" name="preferences--allAssetVocabularies--">
			<aui:option label="all" selected="<%= allAssetVocabularies %>" value="<%= true %>" />
			<aui:option label="filter[action]" selected="<%= !allAssetVocabularies %>" value="<%= false %>" />
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

		<div class="display-template">

			<%
			TemplateHandler templateHandler = TemplateHandlerRegistryUtil.getTemplateHandler(AssetCategory.class.getName());
			%>

			<liferay-ui:ddm-template-selector
				classNameId="<%= PortalUtil.getClassNameId(templateHandler.getClassName()) %>"
				displayStyle="<%= displayStyle %>"
				displayStyleGroupId="<%= displayStyleGroupId %>"
				refreshURL="<%= currentURL %>"
				showEmptyOption="<%= true %>"
			/>
		</div>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

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

	Liferay.Util.toggleSelectBox('<portlet:namespace />allAssetVocabularies', 'false', '<portlet:namespace />assetVocabulariesBoxes');
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