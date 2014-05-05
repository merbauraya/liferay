<%@include file="/html/eprint/init.jsp" %>
<script src="<%=request.getContextPath()%>/js/jquery.dataTables.js"/></script>
<script src="<%=request.getContextPath()%>/js/date.ddmmmyy.sort.js"/></script>
<portlet:resourceURL  var="browseBySubjectIdURL" />



<%
	String type = ParamUtil.getString(request, "itemType");
	String redirect = ParamUtil.getString(request, "redirect");
	String title = "View by type : " +type;
	Hits hits = EprintLocalServiceUtil.getByType(type, themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
	
	PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setParameter("typeName", type);

%>
<liferay-ui:header
			backURL="javascript:history.go(-1);"
			title="<%= title %>"
	/>

<liferay-ui:search-container
			emptyResultsMessage='<%= LanguageUtil.format(pageContext, "no-entries-were-found-that-matched-the-keywords-x", "<strong>" + HtmlUtil.escape(type) + "</strong>") %>'
			iteratorURL="<%= portletURL %>"
		>
<%
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