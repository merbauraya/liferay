
<subur:item-categorization-filter
	assetType="item"
	portletURL="<%= portletURL%>"
/>

<% 
	int end = searchContainer.getEnd();
	int start = searchContainer.getStart();
	int total = AssetEntryServiceUtil.getEntriesCount(assetEntryQuery);
	assetEntryQuery.setEnd(end);
	assetEntryQuery.setStart(start);
	
	long[] catIds = assetEntryQuery.getAllCategoryIds();
	
	List<AssetEntry> assetEntries = AssetEntryLocalServiceUtil.getEntries(assetEntryQuery);
	
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