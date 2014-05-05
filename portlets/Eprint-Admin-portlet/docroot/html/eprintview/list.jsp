<%@include file="/html/eprint/init.jsp" %>

<%
String keywords = ParamUtil.getString(request, "q");
String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="jspPage" value="/html/eprintview/list.jsp" />
</liferay-portlet:renderURL>


<%
	
PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setParameter("jspPage", "/bookmarks/search");
	
	portletURL.setParameter("q", keywords);
	%>
<aui:form action="<%= searchURL %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	

	<liferay-ui:header
			backURL="<%= redirect %>"
			title="search"
	/>
	<div class="form-search">
		<liferay-ui:input-search autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>" id="q" name="q" placeholder='<%= LanguageUtil.get(locale, "keywords") %>' />
	</div>
	
	<liferay-ui:search-container
			emptyResultsMessage='<%= LanguageUtil.format(pageContext, "no-entries-were-found-that-matched-the-keywords-x", "<strong>" + HtmlUtil.escape(keywords) + "</strong>") %>'
			iteratorURL="<%= portletURL %>"
		>

<%
	
	Hits hits = EprintLocalServiceUtil.getHits(keywords, themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
	
	
	
	//Hits hits = indexer.search(searchContext);

	searchContainer.setTotal(hits.getLength());
%>
	<liferay-ui:search-container-results
			results="<%= EprintUtil.getEntries(hits) %>"
		/>

		<liferay-ui:search-container-row
			className="Object"
			modelVar="obj"
		>
			<%
				Eprint entry = (Eprint)obj;
	
				PortletURL pURL = EprintHelper.getViewDetailUrl(themeDisplay, request, 0);
				String rowHREF=pURL.toString();
				rowHREF = rowHREF.substring(0,rowHREF.length()-1); 
			
			%>
			
				<liferay-ui:app-view-search-entry
					cssClass='<%= MathUtil.isEven(index) ? "search" : "search alt" %>'
					description="<%=  entry.getSummary() %>"
					mbMessages="<%= null%>"
					queryTerms="<%= null %>"
					thumbnailSrc="<%= StringPool.BLANK %>"
					title="<%=  entry.getTitle() %>"
					url="<%= rowHREF+ entry.getUrlTitle() %>"
				/>	
			</liferay-ui:search-container-row>					
			<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" type="more" />
		</liferay-ui:search-container>
	</aui:form>