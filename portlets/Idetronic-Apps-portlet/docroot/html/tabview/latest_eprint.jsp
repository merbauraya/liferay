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
%>
<c:choose>
<c:when test="<%= results.isEmpty() %>">
	<liferay-ui:message key="there-are-no-Eprints" />

	<br /><br />
</c:when>
<c:otherwise>
	<div class="tbview-ol">
		<ol>

	<%
	for (int i = 0; i < results.size(); i++) {
		Eprint eprint = results.get(i);
		String docURL = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/pathfinder/-/eprint/" + eprint.getUrlTitle();
		
	%>
	
		<li>
			<a href="<%=docURL %>">
				<%=eprint.getTitle() %>
			</a>
		</li>	
			
		
		
	

	<%
	}
	%>
		</ol>
	</div>
</c:otherwise>
</c:choose>


