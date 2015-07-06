<%@include file="/html/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.search.QueryConfig" %>
<%@ page import="com.liferay.portal.kernel.search.TermQuery" %>
<%@ page import="com.liferay.portal.kernel.search.WildcardQuery" %>
<%@ page import="com.liferay.portal.kernel.search.TermQueryFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.search.StringQueryFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.search.BooleanClause" %>
<%@ page import="com.liferay.portal.kernel.search.BooleanClauseFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.search.Query" %>
<%@ page import="com.liferay.portal.kernel.search.SearchResultUtil" %>
<%@ page import="com.idetronic.subur.search.SuburSearchUtil" %>
<%@ page import="com.liferay.portal.kernel.search.SearchResult" %>
<%@ page import="com.liferay.portal.kernel.search.Summary" %>
<%@ page import="com.liferay.util.MathUtil" %>



<%
    String keywords = ParamUtil.getString(request, "keywords");
	String redirect = ParamUtil.getString(request, "redirect");
	String author = ParamUtil.getString(request,"author");
	String title = ParamUtil.getString(request,"title");
	String year = ParamUtil.getString(request,"year");
	String andOperator = ParamUtil.getString(request,"andOperator");
	boolean advanceSearch = ParamUtil.getBoolean(request, "advancedSearch");
	boolean matchAll = Validator.equals(andOperator, "1");
	String authorFirstName = ParamUtil.getString(request,"authorFirstName");
	String authorLastName = ParamUtil.getString(request,"authorLastName");
%>


<liferay-portlet:renderURL varImpl="searchURL">
        <portlet:param name="mvcPath" value="/html/search/subur_search.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="viewURL">
        <portlet:param name="mvcPath" value="/html/view.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
	<%@ include file="/html/admin/subur/top_nav.jsp" %>
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
    <liferay-portlet:renderURLParams varImpl="searchURL" />

    <liferay-ui:header
        backURL="<%= viewURL.toString() %>"
        title="search"
    />

    
</aui:form>
<%
	PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setParameter("jspPage", SuburConstant.PAGE_SUBUR_SEARCH);
	portletURL.setParameter("redirect", redirect);
	portletURL.setParameter("keywords", keywords);
	%>

<liferay-ui:search-container
		emptyResultsMessage='<%= LanguageUtil.format(pageContext, "no-entries-were-found-that-matched-the-keywords-x", "<strong>" + HtmlUtil.escape(keywords) + "</strong>") %>'
		iteratorURL="<%= portletURL %>"
	>

<%
        SearchContext searchContext = SearchContextFactory.getInstance(request);
		BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
		
		
	    BooleanQuery searchQuery = BooleanQueryFactoryUtil.create(searchContext);
	   
	    
	    Query stringQuery = null;
	    
	    
	    if (advanceSearch){
	    	
	    	
	    	stringQuery = SuburSearchUtil.buildSearchQuery(request, searchContext);
	    	BooleanClause clause = BooleanClauseFactoryUtil.create(searchContext, stringQuery, BooleanClauseOccur.MUST.getName());
    		searchContext.setBooleanClauses(new BooleanClause[] {clause});
    		String keywordList;
    		StringBuilder sb = new StringBuilder();
    		if (!Validator.isBlank(title))
    			sb.append(title).append(StringPool.SPACE);
    		if (!Validator.isBlank(authorFirstName))
    			sb.append(authorFirstName).append(StringPool.SPACE);
    		if (!Validator.isBlank(authorLastName))
    			sb.append(authorLastName).append(StringPool.SPACE);
    		if (!Validator.isBlank(year))
    			sb.append(year).append(StringPool.SPACE);
    		
    		
    		searchContext.setKeywords(sb.toString());
	    
	    }else
	    {
	    	/*
	    	searchQuery.addTerm(SuburConstant.FIELD_YEAR, keywords);
	    	searchQuery.addTerm(Field.TITLE, keywords);
	    	searchQuery.addTerm(SuburConstant.FIELD_AUTHOR, keywords);
	    	BooleanClause clause = BooleanClauseFactoryUtil.create(searchContext, searchQuery, BooleanClauseOccur.MUST.getName());
	    	*/
	    	searchContext.setKeywords(keywords);
	    	
	    	//searchContext.setBooleanClauses(new BooleanClause[] {clause});
	    }
    
	    
	    
	    QueryConfig queryConfig = new QueryConfig();

		queryConfig.setHighlightEnabled(true);
		queryConfig.setHitsProcessingEnabled(true);
		searchContext.setQueryConfig(queryConfig);
	    
		
        searchContext.setAttribute("paginationType", "more");
        searchContext.setStart(searchContainer.getStart());
        searchContext.setEnd(searchContainer.getEnd());
        //_log.info(fullQuery.toString());
        Indexer indexer = IndexerRegistryUtil.getIndexer(SuburItem.class);

        Hits hits = indexer.search(searchContext);
        searchContainer.setTotal(hits.getLength());
        
        PortletURL hitURL = renderResponse.createRenderURL();

		hitURL.setParameter("struts_action", "/blogs/view_entry");
		hitURL.setParameter("redirect", currentURL);
		searchContainer.setTotal(hits.getLength());
		
%>
	<liferay-ui:search-container-results
			results="<%= SearchResultUtil.getSearchResults(hits, locale, hitURL) %>"
		/>
	<liferay-ui:search-container-row
			className="com.liferay.portal.kernel.search.SearchResult"
			modelVar="searchResult"
		>
        	<%
			SuburItem entry = SuburItemLocalServiceUtil.getSuburItem(searchResult.getClassPK());

			entry = entry.toEscapedModel();

			Summary summary = searchResult.getSummary();
			String searchDescription = entry.getSearchDescription(); 
			%>
        	<portlet:renderURL var="rowURL" windowState="<%= LiferayWindowState.MAXIMIZED.toString() %>">
				<portlet:param name="jspPage" value="/html/renderer/item_full.jsp" />
				<portlet:param name="itemId" value="<%= String.valueOf(entry.getItemId())%>" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="urlTitle" value="<%= StringPool.BLANK %>" />
			</portlet:renderURL>
        <liferay-ui:app-view-search-entry
				cssClass='<%= MathUtil.isEven(index) ? "search" : "search alt" %>'
				description="<%= (searchDescription  != StringPool.BLANK) ? searchDescription : entry.getItemAbstract() %>"
				queryTerms="<%= hits.getQueryTerms() %>"
				thumbnailSrc="<%= StringPool.BLANK %>"
				title="<%= (summary != null) ? HtmlUtil.escape(summary.getTitle()) : entry.getTitle() %>"
				url="<%= rowURL %>"
			/>
		</liferay-ui:search-container-row> 

		<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" type="more" />
	</liferay-ui:search-container>
        
		

<%
        if (Validator.isNotNull(keywords)) {
                currentURL = PortalUtil.getCurrentURL(request);
                PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(
                                pageContext, "search") + ": " + keywords, currentURL);
        }
%>

<%!
        private static Log _log = LogFactoryUtil.getLog("docroot.html.search.view_search_jsp");
%>