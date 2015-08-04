<%@ include file="/html/init.jsp" %>
<%
//read preferences
	String itemToShow = GetterUtil.getString(portletPreferences.getValue("itemToShow", null), "latest");
	String displayStyle = GetterUtil.getString(portletPreferences.getValue("displayStyle", null), "list");
	String orderByColumn1 = GetterUtil.getString(portletPreferences.getValue("orderByColumn1", "modifiedDate"));
	String orderByColumn2 = GetterUtil.getString(portletPreferences.getValue("orderByColumn2", "title"));
	String orderByType1 = GetterUtil.getString(portletPreferences.getValue("orderByType1", "DESC"));
	String orderByType2 = GetterUtil.getString(portletPreferences.getValue("orderByType2", "ASC"));
	int delta = GetterUtil.getInteger(portletPreferences.getValue("delta", null), SearchContainer.DEFAULT_DELTA);
	String paginationType = GetterUtil.getString(portletPreferences.getValue("paginationType", "none"));
	String itemIdentifier = GetterUtil.getString(portletPreferences.getValue("itemIdentifier", StringPool.BLANK));
	//default
	boolean showEditEntryPermissions = true;
	boolean showSearch = true; 
	
	boolean useOrOperatorCategorySearch = GetterUtil.getBoolean(portletPreferences.getValue("useOrOperatorCategorySearch", Boolean.FALSE.toString()));
	boolean useOrOperatorTagSearch = GetterUtil.getBoolean(portletPreferences.getValue("useOrOperatorTagSearch", Boolean.FALSE.toString()));
	
	boolean enableRSS = !PortalUtil.isRSSFeedsEnabled() ? false : GetterUtil.getBoolean(portletPreferences.getValue("enableRss", null));
	int rssDelta = GetterUtil.getInteger(portletPreferences.getValue("rssDelta", StringPool.BLANK), SearchContainer.DEFAULT_DELTA);
	String rssDisplayStyle = portletPreferences.getValue("rssDisplayStyle", RSSUtil.DISPLAY_STYLE_ABSTRACT);
	String rssFeedType = portletPreferences.getValue("rssFeedType", RSSUtil.FEED_TYPE_DEFAULT);
	String rssName = portletPreferences.getValue("rssName", portletDisplay.getTitle());


	String authorTitleString = GetterUtil.getString(portletPreferences.getValue("authorTitle",StringPool.BLANK), StringPool.BLANK);
	String authorSiteNameString = GetterUtil.getString(portletPreferences.getValue("authorSiteName", StringPool.BLANK))	;		
%>