<%@include file="/html/init.jsp"%>

<%
    String keywords = ParamUtil.getString(request, "keywords");
%>

<liferay-portlet:renderURL varImpl="searchURL">
        <portlet:param name="mvcPath" value="/html/search/view_search.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="viewURL">
        <portlet:param name="mvcPath" value="/html/view.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
    <liferay-portlet:renderURLParams varImpl="searchURL" />

    <liferay-ui:header
        backURL="<%= viewURL.toString() %>"
        title="search"
    />

    <div class="search-form">
        <span class="aui-search-bar">
            <aui:input inlineField="<%= true %>" label="" name="keywords" size="30" title="search-entries" type="text" />

            <aui:button type="submit" value="search" />
        </span>
    </div>
</aui:form>

<%
        SearchContext searchContext = SearchContextFactory
        .getInstance(request);
		BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
		BooleanQuery classNameQuery = BooleanQueryFactoryUtil.create(searchContext);
	    BooleanQuery searchQuery = BooleanQueryFactoryUtil.create(searchContext);
	    classNameQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, SuburItem.class.getName());
	    
	    
	    searchQuery.addTerm(SuburConstant.FIELD_YEAR, keywords);
	    searchQuery.addTerm(Field.TITLE, keywords);
	    
	    fullQuery.add(classNameQuery, BooleanClauseOccur.MUST);
	    fullQuery.add(searchQuery, BooleanClauseOccur.MUST);
	    
        searchContext.setKeywords(keywords);
        searchContext.setAttribute("paginationType", "more");
        searchContext.setStart(0);
        searchContext.setEnd(10);

        Indexer indexer = IndexerRegistryUtil.getIndexer(SuburItem.class);

        //Hits hits = indexer.search(searchContext,searchQuery);
		Hits hits =  SearchEngineUtil.search(searchContext, fullQuery); 
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