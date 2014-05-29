<%@ include file="/html/tabview/init.jsp" %>
<%
	List<Eprint> results = new ArrayList<Eprint>();
	List<String> headerNames = new ArrayList<String>();	
headerNames.add("name");
headerNames.add("size");
PortletURL portletURL = renderResponse.createRenderURL();



//SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 10, portletURL, headerNames, "no-requests-were-found");
//searchContainer.setEmptyResultsMessage("no-documents-were-found");
 
results = EprintLocalServiceUtil.getEprints(0, 10);//  DLFileEntryLocalServiceUtil.getGroupFileEntries(themeDisplay.getScopeGroupId(), 0, 10);


for (int i=0; i<results.size();i++)
	{
		Eprint eprint = results.get(i);
		ResultRow row = new ResultRow(eprint, eprint.getEprintId(), i);
		//DLFileVersion fileVersion = fileEntry.getLatestFileVersion(false);
		String docURL = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/pathfinder/-/eprint/" + eprint.getUrlTitle();
		
%>
<div title="<%= HtmlUtil.escape(eprint.getTitle()) %>">

	<liferay-ui:icon
		
		label="<%= true %>"
		message="<%= eprint.getTitle() %>"
		url="<%= docURL %>"
	/>
</div>
<%	



	}
%>