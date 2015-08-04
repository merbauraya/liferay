<%
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
%>

<%@ include file="/html/subur/init.jsp" %>

<liferay-portlet:renderURL varImpl="searchURL">
        <portlet:param name="mvcPath" value="/html/search/subur_search.jsp" />
</liferay-portlet:renderURL>



<liferay-portlet:renderURL varImpl="uploadFileURL">
        <portlet:param name="mvcPath" value="/html/fileupload/view.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="adminAuthor">
        <portlet:param name="mvcPath" value="/html/admin/author/view.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="testPageURL">
        <portlet:param name="mvcPath" value="/html/test/1.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:resourceURL varImpl="xURL" id="serveFile">
        <portlet:param name="fileAssetId" value="25044" />
</liferay-portlet:resourceURL>

<%
	String itemId = renderRequest.getParameter("itemId");
	
	String x = ParamUtil.getString(request, "categoryId");
	String z = ParamUtil.getString(request, "tag");
	String y = ParamUtil.getString(request,"itemTypeId");
	String authorId =  ParamUtil.getString(request,"authorId");
	

	PortletURL portletURL = renderResponse.createRenderURL();
	SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, delta, portletURL, null, null);
	
	if (!paginationType.equals("none")) {
		searchContainer.setDelta(delta);
		searchContainer.setDeltaConfigurable(false);
	}
	
	searchContainer.setEmptyResultsMessage("no-results-found");
%>



<aui:form action="<%=searchURL%>" name="fm" inlineLabel="<%= true %>">
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	<%@ include file="/html/admin/subur/top_nav.jsp" %>
</aui:form>
<div class="subscribe-action">
	<c:if test="<%= enableRSS %>">
		<liferay-portlet:resourceURL varImpl="rssURL">
			<portlet:param name="struts_action" value="/asset_publisher/rss" />
		</liferay-portlet:resourceURL>

		<liferay-ui:rss resourceURL="<%= rssURL %>" />
	</c:if>

</div>

<%
	
	String itemTypeId = ParamUtil.getString(request, "itemTypeId");
	String[] itemTypeIds = StringUtil.split(itemTypeId);

	boolean filterByTagOrCategory = false;
	

	String[] allAssetTagNames = new String[0];
	String assetTagName = ParamUtil.getString(request, "tag");
	
	long siteGroupIds = themeDisplay.getSiteGroupId();
	String[] assetTagNames = StringUtil.split(assetTagName);
	
	AssetEntryQuery assetEntryQuery = new AssetEntryQuery();
	Map<String, Object> attributes = new HashMap<String, Object>();
	attributes.put("itemType", 1);
	assetEntryQuery.setAttribute("itemType", 1);
	
	
	//assetEntryQuery.setAttributes(attributes);
	//assetEntry.setModelAttributes(attributes);
	//assetEntryLocalService.updateAssetEntry(assetEntry);
	
	
	
if (Validator.isNotNull(assetTagName)) {
	allAssetTagNames = new String[] {assetTagName};
	filterByTagOrCategory = true;
	long[] assetTagIds = AssetTagLocalServiceUtil.getTagIds(siteGroupIds, allAssetTagNames);
	if (useOrOperatorTagSearch)
		assetEntryQuery.setAnyTagIds(assetTagIds);
	else
		assetEntryQuery.setAllTagIds(assetTagIds);
	
	for (String tagName : assetTagNames)
		PortalUtil.setPageKeywords(tagName + StringPool.SPACE, request);
}
//process category
	long assetCategoryId = 0L;
	String assetCategoryTitle = null;
	String assetVocabularyTitle = null;
	long[] allAssetCategoryIds = new long[0];
	
	String categoryId = ParamUtil.getString(request, "categoryId", StringPool.BLANK);
	filterByTagOrCategory = filterByTagOrCategory? true: Validator.isNotNull(categoryId);
	
	String[] categoryIds = StringUtil.split(categoryId);
	
	if (categoryIds.length == 1)
	{
		assetCategoryId = Long.parseLong(categoryIds[0]);
		if (assetCategoryId > 0)
		{
			allAssetCategoryIds = assetEntryQuery.getAllCategoryIds();
			if (!ArrayUtil.contains(allAssetCategoryIds, assetCategoryId)) {
				assetEntryQuery.setAllCategoryIds(ArrayUtil.append(allAssetCategoryIds, assetCategoryId));
			}
			
			AssetCategory assetCategory = AssetCategoryLocalServiceUtil.getCategory(assetCategoryId);
			
			assetCategory = assetCategory.toEscapedModel();
		
			assetCategoryTitle = assetCategory.getTitle(locale);
		
			AssetVocabulary assetVocabulary = AssetVocabularyLocalServiceUtil.getAssetVocabulary(assetCategory.getVocabularyId());
		
			assetVocabulary = assetVocabulary.toEscapedModel();
		
			assetVocabularyTitle = assetVocabulary.getTitle(locale);
		
			PortalUtil.setPageKeywords(assetCategoryTitle, request);
		}
	} else if (categoryIds.length > 1)
	{
		assetCategoryId = Long.parseLong(categoryIds[0]);
		List<Long> categoryIdsList = new ArrayList<Long>();
		
		for(String categoryIdString : categoryIds) {
		  	long id = Long.parseLong(categoryIdString);
		  	if (id != 0L) {
		  		categoryIdsList.add(id);
		  	}
		}
		
		if (useOrOperatorCategorySearch) {
			assetEntryQuery.setAnyCategoryIds(ArrayUtil.toLongArray(categoryIdsList));
		}
		else {
			assetEntryQuery.setAllCategoryIds(ArrayUtil.toLongArray(categoryIdsList));
			
		}
	}
	
	
	long clId = ClassNameLocalServiceUtil.getClassNameId(SuburItem.class.getName());
	long[] classNameIds = {clId}; 
	assetEntryQuery.setClassNameIds(classNameIds);
	assetEntryQuery.setOrderByCol1(orderByColumn1);
	assetEntryQuery.setOrderByCol2(orderByColumn2);
	assetEntryQuery.setOrderByType1(orderByType1);
	assetEntryQuery.setOrderByType2(orderByType2);
%>
<div class="">
	<%@ include file="/html/view/process_view_l.jsp" %>


<c:if test='<%= !paginationType.equals("none") && (searchContainer.getTotal() > searchContainer.getResults().size()) %>'>
	
	<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" type="<%= paginationType %>" />
</c:if>	
	
	
	
</div>
<%!
private static Log _log = LogFactoryUtil.getLog("subur.html.view");
%>