
<subur:item-categorization-filter
	assetType="item"
	portletURL="<%= portletURL%>"
/>

<% 
	int end = searchContainer.getEnd();
	int start = searchContainer.getStart();
	
	
	
	long[] anyItemTypeIds = new long[]{};
	long[] allItemTypeIds = new long[]{};
	//set item types
	if (itemTypeIds.length == 1)
	{
		long itId = Long.parseLong(itemTypeIds[0]);
		if (itId > 0)
			anyItemTypeIds = new long[]{itId};
		
	}else if (itemTypeIds.length > 1)
	{
		List<Long> itemTypeIdsList = new ArrayList<Long>();
		
		for(String itemTypeIdString : itemTypeIds) {
		  	long id = Long.parseLong(itemTypeIdString);
		  	if (id != 0L) {
		  		itemTypeIdsList.add(id);
		  	}
		}
		
		if (useOrOperatorCategorySearch) {
			anyItemTypeIds = ArrayUtil.toLongArray(itemTypeIdsList);
			
			
		}
		else {
			allItemTypeIds = ArrayUtil.toLongArray(itemTypeIdsList);
			
		}
		
	}
	
	int total = SuburItemLocalServiceUtil.getEntriesCount(assetEntryQuery,anyItemTypeIds,allItemTypeIds);
	assetEntryQuery.setEnd(end);
	assetEntryQuery.setStart(start);
	
	long[] catIds = assetEntryQuery.getAllCategoryIds();
	
	List<AssetEntry> assetEntries = SuburItemLocalServiceUtil.getAssetEntries(assetEntryQuery,anyItemTypeIds,allItemTypeIds);
	
	//need to filter out item type
	
	searchContainer.setTotal(total);
	
	searchContainer.setResults(assetEntries);
	request.setAttribute("view.jsp-results", assetEntries);
%>
	
<%
	for (int assetEntryIndex = 0; assetEntryIndex < assetEntries.size(); assetEntryIndex++) {
		AssetEntry assetEntry = assetEntries.get(assetEntryIndex);
		AssetRendererFactory assetRendererFactory = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(assetEntry.getClassName());
		AssetRenderer assetRenderer = assetRendererFactory.getAssetRenderer(assetEntry.getClassPK());
		String title = assetRenderer.getTitle(locale);
		String suburItemId = String.valueOf(assetEntry.getClassPK());
		boolean show = true;
		boolean print = false;

		request.setAttribute("view.jsp-assetEntryIndex", new Integer(assetEntryIndex));

		request.setAttribute("view.jsp-assetEntry", assetEntry);
		request.setAttribute("view.jsp-assetRendererFactory", assetRendererFactory);
		request.setAttribute("view.jsp-assetRenderer", assetRenderer);

		request.setAttribute("view.jsp-title", title);

		request.setAttribute("view.jsp-show", new Boolean(show));
		request.setAttribute("view.jsp-print", new Boolean(print));
		request.setAttribute("view.jsp-itemId", suburItemId);

		try {
	%>

			<%@ include file="/html/renderer/view_display.jspf" %>

	<%
		}
		catch (Exception e) {
			_log.error(e.getMessage());
		}
		
		
	}
	
	%>
	
	


<%


%>