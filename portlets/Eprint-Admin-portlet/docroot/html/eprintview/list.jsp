<%@include file="/html/eprint/init.jsp" %>
<%@page import="com.liferay.portal.kernel.search.Indexer" %>
<%@page import="com.liferay.portal.kernel.search.SearchContextFactory" %>
<%@page import="com.liferay.portal.kernel.search.SearchContext" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@page import="com.liferay.portal.kernel.search.Hits" %>
<%@page import="com.liferay.portal.kernel.search.Field" %>
<%@page import="com.liferay.portal.kernel.search.IndexerRegistryUtil" %>
<%@page import="com.liferay.portal.kernel.search.BooleanQuery" %>
<%@page import="com.liferay.portal.kernel.search.BooleanQueryFactoryUtil" %>
<%@page import="com.idetronic.eprint.util.EprintSearcher" %>
<%@page import="com.idetronic.eprint.service.base.EprintLocalServiceBaseImpl" %>
<%@page import="com.idetronic.eprint.util.EprintUtil" %>
<%
String keywords = ParamUtil.getString(request, "q");
%>
List.jsp


<%
	
PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setParameter("jspPage", "/bookmarks/search");
	
	portletURL.setParameter("q", keywords);
	%>


<liferay-ui:search-container
		emptyResultsMessage='<%= LanguageUtil.format(pageContext, "no-entries-were-found-that-matched-the-keywords-x", "<strong>" + HtmlUtil.escape(keywords) + "</strong>") %>'
		iteratorURL="<%= portletURL %>"
	>

<%
	//Indexer indexer = EprintSearcher.getInstance();
	Indexer indexer = IndexerRegistryUtil.getIndexer(Eprint.class);
	SearchContext searchContext = SearchContextFactory.getInstance(request);
	searchContext.setAttribute("paginationType", "more");
	searchContext.setEnd(searchContainer.getEnd());
	searchContext.setKeywords(keywords);
	//searchContext.setAttribute(name, value)
	searchContext.setStart(searchContainer.getStart());
	
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

		//String rowHREF = themeDisplay.getPathMain().concat("/detail/").concat(String.valueOf(entry.getEprintId()));
		PortletURL pURL = EprintHelper.getViewDetailUrl(themeDisplay, request, 0);
		String rowHREF=pURL.toString();
		rowHREF = rowHREF.substring(0,rowHREF.length()-1); 
		%>
		
		<liferay-ui:search-container-column-text
						name="title"
						href="<%= rowHREF+ entry.getUrlTitle() %>"
						title="<%= entry.getTitle() %>"
						value="<%=entry.getTitle() %>"
					/>
		<liferay-ui:search-container-column-text
						name="type"
						title="<%= entry.getEprintType() %>"
						value="<%=entry.getEprintType() %>"
					/>		
			
		</liferay-ui:search-container-row>					
		<liferay-ui:search-iterator type="more" />
	</liferay-ui:search-container>