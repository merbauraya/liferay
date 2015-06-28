<%@include file="/html/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.search.QueryConfig" %>
<%@ page import="com.liferay.portal.kernel.search.TermQuery" %>
<%@ page import="com.liferay.portal.kernel.search.WildcardQuery" %>
<%@ page import="com.liferay.portal.kernel.search.TermQueryFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.search.StringQueryFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.search.BooleanClause" %>
<%@ page import="com.liferay.portal.kernel.search.BooleanClauseFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.search.Query" %>
<%@ page import="com.idetronic.subur.search.SuburSearchUtil" %>


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
        SearchContext searchContext = SearchContextFactory.getInstance(request);
		BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
		
		
	    BooleanQuery searchQuery = BooleanQueryFactoryUtil.create(searchContext);
	   
	    
	    Query stringQuery = null;
	    
	    
	    if (advanceSearch){
	    	
	    	
	    	stringQuery = SuburSearchUtil.buildSearchQuery(request, searchContext);
	    	BooleanClause clause = BooleanClauseFactoryUtil.create(searchContext, stringQuery, BooleanClauseOccur.MUST.getName());
    		searchContext.setBooleanClauses(new BooleanClause[] {clause});
	    	
	    
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

		searchContext.setQueryConfig(queryConfig);
	    
	    
        searchContext.setKeywords(keywords);
        searchContext.setAttribute("paginationType", "more");
        searchContext.setStart(0);
        searchContext.setEnd(10);
        //_log.info(fullQuery.toString());
        Indexer indexer = IndexerRegistryUtil.getIndexer(SuburItem.class);

        Hits hits = indexer.search(searchContext);
		//Hits hits =  SearchEngineUtil.search(searchContext, fullQuery); 
        List<SuburItem> items = new ArrayList<SuburItem>();

        for (int i = 0; i < hits.getDocs().length; i++) {
                Document doc = hits.doc(i);

                long itemId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));

                SuburItem item = null;
				
                try {
                	item = SuburItemLocalServiceUtil.fetchSuburItem(itemId);
                } catch (SystemException se) {
                        _log.error(se.getLocalizedMessage());
                }

                items.add(item);
        }
       
%>

<liferay-ui:search-container delta="10" emptyResultsMessage="no-entries-were-found">
        <liferay-ui:search-container-results
                results="<%= items %>"
                total="<%= items.size() %>"
        />

        <liferay-ui:search-container-row
                className="com.idetronic.subur.model.SuburItem"
                keyProperty="itemId" modelVar="item" escapedModel="<%=true%>">
                <liferay-ui:search-container-column-text name="Entry" value="<%=Long.toString(item.getItemId())%>" />

                <liferay-ui:search-container-column-text property="title" />

                

                <liferay-ui:search-container-column-jsp
            path="/html/action/item_actions.jsp"
            align="right" />
        </liferay-ui:search-container-row>

        <liferay-ui:search-iterator />
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