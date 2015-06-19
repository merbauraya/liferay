<%@ include file="/html/init.jsp" %>
<%
	long subjectId = ParamUtil.getLong(request, "subjectId");
	long itemTypeId = ParamUtil.getLong(request, "itemTypeId");
	String year = ParamUtil.getString(request, "year");
	String author = ParamUtil.getString(request, "author");
	
	SearchContext searchContext = SearchContextFactory.getInstance(request);
	BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
	BooleanQuery classNameQuery = BooleanQueryFactoryUtil.create(searchContext);
    BooleanQuery searchQuery = BooleanQueryFactoryUtil.create(searchContext);
   
    classNameQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, SuburItem.class.getName());
    
    logger.info(subjectId + ":"+ itemTypeId + ":"+ author);
    
    if (!Validator.equals(subjectId, 0))
    {	
    	searchQuery.addRequiredTerm(SuburConstant.FIELD_SUBJECT,subjectId);
    	
    }
    if (!Validator.equals(itemTypeId, 0))
    {
    	searchQuery.addRequiredTerm(SuburConstant.FIELD_ITEM_TYPE,itemTypeId);
    }
  //facet config,subject item type,author and years added
    if (Validator.equals(subjectId, 0))
    {
    	MultiValueFacet subjectFacet = new MultiValueFacet(searchContext);
    	subjectFacet.setFieldName(SuburConstant.FIELD_SUBJECT);
    	searchContext.addFacet(subjectFacet);
    }
    MultiValueFacet authorFacet = null;
    if (Validator.isBlank(author))
    {
    	authorFacet = new MultiValueFacet(searchContext);
    	authorFacet.setFieldName(SuburConstant.FIELD_AUTHOR);
    	    
    }else
    {
    	String authorQry = author.replace(",", "\\,");
    	searchQuery.addRequiredTerm(SuburConstant.FIELD_AUTHOR,author);
    	logger.info(authorQry);
    }
    
    //facet config, item type,author and years added
    MultiValueFacet itemTypeFacet = new MultiValueFacet(searchContext);
    itemTypeFacet.setFieldName(SuburConstant.FIELD_ITEM_TYPE);
    
  
    //year term and facet
    SimpleFacet yearFacet = null;
    if (!Validator.isBlank(year))
    {
    	searchQuery.addRequiredTerm(SuburConstant.FIELD_YEAR, year);
    }else
    {
    	yearFacet = new SimpleFacet(searchContext);
    	yearFacet.setFieldName(SuburConstant.FIELD_YEAR);
    }
    //authorFacet.setStatic(true);
    
    fullQuery.add(classNameQuery, BooleanClauseOccur.MUST);
    fullQuery.add(searchQuery, BooleanClauseOccur.MUST);
    
    
    searchContext.setAttribute("paginationType", "more");
    searchContext.setStart(0);
    searchContext.setEnd(10);
    searchContext.addFacet(authorFacet);
    searchContext.addFacet(yearFacet);
    searchContext.addFacet(itemTypeFacet);
	      
    Indexer indexer = IndexerRegistryUtil.getIndexer(SuburItem.class);

    //Hits hits = indexer.search(searchContext,searchQuery);
	Hits hits =  SearchEngineUtil.search(searchContext, fullQuery); 
    //List<SuburItem> items = new ArrayList<SuburItem>();	
	
    FacetCollector itemTypeFacetCollector = itemTypeFacet.getFacetCollector();
    List<TermCollector> itemTypeTermCollector = itemTypeFacetCollector.getTermCollectors();
    
    //author Facet
    FacetCollector authorFacetCollector = null;
    List<TermCollector> authorTermCollectors = null;
    if (Validator.isBlank(author))
    {
    	authorFacetCollector = authorFacet.getFacetCollector();
    	authorTermCollectors = authorFacetCollector.getTermCollectors();
    }
    
    
   	//year published facet
    FacetCollector yearFacetCollector = null;
    List<TermCollector> yearTermCollector = null;
    if (Validator.isBlank(year)){
    	yearFacetCollector = yearFacet.getFacetCollector();
    	yearTermCollector = yearFacetCollector.getTermCollectors();
    }
    List<SuburItem> items = new ArrayList<SuburItem>();

    for (int i = 0; i < hits.getDocs().length; i++) {
            Document doc = hits.doc(i);

            long itemId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));

            SuburItem item = null;
			
            try {
            	item = SuburItemLocalServiceUtil.fetchSuburItem(itemId);
            } catch (SystemException se) {
                    logger.error(se.getLocalizedMessage());
            }

            items.add(item);
    }
	

//List<Item> suburItems = ItemLocalServiceUtil.getDraftItems();	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("jspPage", "/html/view_subject.jsp");
	portletURL.setParameter("subjectId", String.valueOf(subjectId));
	portletURL.setWindowState(WindowState.NORMAL);
	
	PortletURL deleteEntryURL = renderResponse.createActionURL();
	deleteEntryURL.setParameter(ActionRequest.ACTION_NAME,"deleteEntry");
	deleteEntryURL.setParameter("redirectURL", portletURL.toString());
	
	PortletURL editEntryURL = renderResponse.createRenderURL();
	editEntryURL.setParameter("jspPage", "/html/deposit.jsp");
	editEntryURL.setParameter(Constants.CMD, Constants.EDIT);
	Subject subject=null;
	ItemType itemType=null;
	if (!Validator.equals(subjectId, 0) )
	{
		
		subject = SubjectLocalServiceUtil.fetchSubject(subjectId);
	}
	if (!Validator.equals(itemTypeId, 0))
		itemType = ItemTypeLocalServiceUtil.getItemType(itemTypeId);
		
%>
<h3>
	<ol class="breadcrumb">
	
	<c:if test="<%=!Validator.equals(subjectId, 0) %>">
		<portlet:renderURL var="browseSubjectURL">
			<portlet:param name="subjectId" value="<%=String.valueOf(subjectId) %>" />
			<portlet:param name="jspPage" value="/html/browse.jsp" />
			
		</portlet:renderURL>
		<li>
			Subject : <a href="<%=browseSubjectURL.toString() %>"><%=subject.getSubjectName() %></a>	
		</li>
		
	</c:if>
	<c:if test="<%=!Validator.equals(itemTypeId, 0) %>">
		<portlet:renderURL var="browseItemTypeURL">
			<portlet:param name="itemTypeId" value="<%=String.valueOf(itemType.getItemTypeId()) %>" />
			<portlet:param name="jspPage" value="/html/browse.jsp" />
			
		</portlet:renderURL>
		<li>
		Item Type : <a href="<%=browseItemTypeURL.toString() %>"><%=itemType.getItemTypeName() %></a>
		</li>
	</c:if>
	<c:if test="<%=!Validator.isBlank(year) %>">
		<portlet:renderURL var="browseYearURL">
			<portlet:param name="year" value="<%=year %>" />
			<portlet:param name="jspPage" value="/html/browse.jsp" />
			
		</portlet:renderURL>
		<li>
		Year Published : <a href="<%=browseYearURL.toString() %>"><%=year %></a>
		</li>
	</c:if>
	
	
	
	
	
	</ol>

</h3>
<aui:layout>
	<aui:column columnWidth="75" first="true">	
		<liferay-ui:search-container
			emptyResultsMessage="no-item-were-found"
			iteratorURL="<%=portletURL %>"
			total = "<%= items.size() %>"
		>
			<liferay-ui:search-container-results
				results="<%= items %>"
			/>
			<liferay-ui:search-container-row
				className="com.idetronic.subur.model.SuburItem"
				escapedModel="<%= true %>"
				keyProperty="itemId"
				modelVar="item"
			>
			<liferay-ui:search-container-column-text
						name="title"
						title="<%= item.getTitle() %>"
					/>
			
			<liferay-ui:search-container-column-text
						name="createDate"
						buffer="buffer"
			>
				<%
					buffer.append(dateFormatDate.format(item.getCreateDate()));
				%>
			</liferay-ui:search-container-column-text>	
			<liferay-ui:search-container-column-text
				name="Last Modified"
				buffer="buffer"
			>
				<%
					buffer.append(timeFormatDate.format(item.getModifiedDate()));
				%>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name="Action">		
				<liferay-ui:icon-menu>
						<%
						editEntryURL.setParameter("itemId", Long.toString(item.getItemId()  ));
						deleteEntryURL.setParameter("itemId", Long.toString(item.getItemId() ));
						
						
						%>
						<liferay-ui:icon image="edit" url="<%=editEntryURL.toString()  %>" />
						<liferay-ui:icon-delete url="<%=deleteEntryURL.toString()  %>" />
				
				</liferay-ui:icon-menu>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</aui:column>
	
	
	<aui:column columnWidth="25" last="true">
		
		<%
		
			
		%>
		<c:if test="<%= Validator.isNotNull(itemTypeTermCollector) && Validator.equals(itemTypeId, 0) %>">
			<ul class="nav nav-list">
				<li class="nav-header">Top 10 Item Types</li>
			<%
				for (int i=0;i<itemTypeTermCollector.size();i++)
				{
					TermCollector itemTypeTerm = itemTypeTermCollector.get(i);
					ItemType _itemType = ItemTypeLocalServiceUtil.getItemType(Long.valueOf(itemTypeTerm.getTerm()));
					String itemTypeLabel = _itemType.getItemTypeName() + " ("+ itemTypeTerm.getFrequency() + ")";
					if (i > 9)
						break;
			
				PortletURL browseURL = renderResponse.createRenderURL();
				browseURL.setParameter("jspPage", "/html/browse.jsp");
				browseURL.setParameter("subjectId", String.valueOf(subjectId));
				browseURL.setParameter("itemTypeId", String.valueOf(_itemType.getItemTypeId()));
				browseURL.setParameter("year", year);
				
			%>
				<li><a href="<%=browseURL.toString()%>"><%=itemTypeLabel %></a>
			<%	
				}
			%>
			
			</ul>
		
		
		</c:if>
		
		
		
		<c:if test="<%= Validator.isNotNull(authorTermCollectors) %>">
			<ul class="nav nav-list">
				<li class="nav-header">Authors</li>
		<%
			//for (MetadataValueView author: authors) 
			for (int i=0;i < authorTermCollectors.size();i++)
			{
				TermCollector authorTerm = authorTermCollectors.get(i);
				
				String authorLabel = authorTerm.getTerm() + " ("+ authorTerm.getFrequency() + ")";

				PortletURL browseURL = renderResponse.createRenderURL();
				browseURL.setParameter("jspPage", "/html/browse.jsp");
				browseURL.setParameter("subjectId", String.valueOf(subjectId));
				browseURL.setParameter("itemTypeId", String.valueOf(itemTypeId));
				browseURL.setParameter("author", authorTerm.getTerm());
		%>
				<li><a href="<%=browseURL.toString() %>"><%=authorLabel %></a>
		<%
		}
		%>
			</ul>
		</c:if>
		<c:if test="<%= Validator.isNotNull(yearTermCollector) && Validator.isBlank(year) %>">
			<ul class="nav nav-list">
				<li class="nav-header">Years</li>
		<%
			//for (MetadataValueView author: authors) 
			for (int i=0;i < yearTermCollector.size();i++)
			{
				TermCollector yearTerm = yearTermCollector.get(i);
				
				String authorLabel = yearTerm.getTerm() + " ("+ yearTerm.getFrequency() + ")";
				PortletURL browseURL = renderResponse.createRenderURL();
				browseURL.setParameter("jspPage", "/html/browse.jsp");
				browseURL.setParameter("subjectId", String.valueOf(subjectId));
				browseURL.setParameter("itemTypeId", String.valueOf(itemTypeId));
				browseURL.setParameter("author", author);
				browseURL.setParameter("year", yearTerm.getTerm());
				
		%>
				<li><a href="<%=browseURL.toString() %>"><%=authorLabel %></a>
		<%
		}
		%>	
			
		</c:if>
		

		<%-- <% for(MetadataPropertyValue author: authors) {
				String authorLabel = author.getTextValue()  + " ("+ author.getItemCount() + ")";
		%>		
			<li>
				<a href="#"><%=authorLabel %></a>
			</li>
		<%} %> --%>
		
		
	</aui:column>
</aui:layout>

<%!
        private static Log logger = LogFactoryUtil.getLog("docroot.html.browse_jsp");
%>