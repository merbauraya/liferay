<%@ include file="/html/init.jsp" %>


<%
	//orcid researcher search
	//pub.orcid.org/search/orcid-bio/?q=family-name:Smith
	SuburItem suburItem = (SuburItem)request.getAttribute("suburItem");
	/*
	List<MetadataPropertyValue> authors = Collections.emptyList();
	int[] authorsIndexes = null;
	
	if (Validator.isNotNull(suburItem))
	{
		authors = MetadataPropertyValueLocalServiceUtil.getAuthor(suburItem.getItemId());
		authorsIndexes = new int[authors.size()];
		for (int i = 0;i < authors.size(); i++){
			authorsIndexes[i] = i;
		}
		
	}
	
	if (Validator.isNull(suburItem) || authors.isEmpty())
	{
		authors = new ArrayList<MetadataPropertyValue>();
		authors.add(new MetadataPropertyValueImpl());
		authorsIndexes =  new int[] {0};
	}
	*/
%>




<%
	//String indexes = StringUtil.merge(authorsIndexes);
	String authorsIndexes = "0";
%>


<%
	long[] authorIds = ItemAuthorLocalServiceUtil.getAuthorId(suburItem.getItemId());
	List<Author> authors = AuthorLocalServiceUtil.getAuthors(authorIds);
	

%>
<liferay-util:buffer var="removeAuthorIcon">
	<liferay-ui:icon
		image="unlink"
		label="<%= true %>"
		message="remove"
	/>
</liferay-util:buffer>
<h3><liferay-ui:message key="edit-authors" /></h3>
<liferay-ui:search-container
	curParam="authorsCur"
	headerNames="First Name,Last Name,null"
	id="authorsSearchContainer"
	iteratorURL="<%= currentURLObj %>"
	total="<%= authors.size() %>"
>
	<liferay-ui:search-container-results
		results="<%= authors.subList(searchContainer.getStart(), searchContainer.getResultEnd()) %>"
	/>

	<liferay-ui:search-container-row
		className="com.idetronic.subur.model.Author"
		keyProperty="authorId"
		modelVar="author"
	>
		
		<liferay-ui:search-container-column-text
			name="First Name"
			value="<%= HtmlUtil.escape(author.getFirstName()) %>"
		/>
		<liferay-ui:search-container-column-text
			name="Last Name"
			value="<%= HtmlUtil.escape(author.getLastName()) %>"
		/>
		<liferay-ui:search-container-column-text>
				<a class="modify-link" data-rowId="<%= author.getAuthorId() %>" href="javascript:;"><%= removeAuthorIcon %></a>
		</liferay-ui:search-container-column-text>
		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<liferay-ui:icon cssClass="edit-author" iconCssClass="icon-edit"
	label="<%=true%>"
	linkCssClass="<%=renderResponse.getNamespace() +\"btnAddExp btn\"%>"
	message="add" url="javascript:;" />


		
<aui:input name="authorsIndexes" id="authorsIndexes"
	type="hidden" 
	value="<%=authorsIndexes%>" />
	






<portlet:resourceURL var="authorLookupURL" id="authorLookup">
</portlet:resourceURL>




<portlet:renderURL var="addAuthorURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="itemId" value="<%=String.valueOf(suburItem.getItemId()) %>"/>
	<portlet:param name="mvcPath" value="/html/deposit/authorlookup.jsp"/>
	<portlet:param name="event" value="addAuthor" />
</portlet:renderURL>


<portlet:actionURL name="addAuthor" var="addAuthorActionURL">
	
</portlet:actionURL>

<aui:script use="aui-base,aui-toggler,liferay-util-window,aui-datatable,datatable-formatters">
var totIndex = 0;
A.one('.<portlet:namespace />btnAddExp').on('click',function(event) {
		//event.preventDefault();
		Liferay.Util.selectEntity(
			{
				dialog: {
					constrain: true,
					modal: true,
					width: 600
				},
				id: '<portlet:namespace />addAuthor',
				title: '<liferay-ui:message arguments="search-author" key="select-author" />',
				uri: '<%=addAuthorURL%>',
				eventName: '<portlet:namespace />addAuthor',
			},
			function (event)
			{
				
				<portlet:namespace />addAuthor(event.authorid,event.firstname,event.lastname,event.searchcontainername);
				
				
			}
			
			
		);
	}
);


Liferay.provide(
		window,
		'<portlet:namespace />addNewAuthor',
		function(authorJson){
			
			var authorAjaxReq = A.io.request('<%=addAuthorActionURL.toString()%>',{ 
                dataType: 'json', 
                method:'POST', 
                data:{<portlet:namespace />authorId: authorJson.authorId,
                	  <portlet:namespace />firstName: authorJson.firstName,
                	  <portlet:namespace />lastName: authorJson.lastName,
                	  <portlet:namespace />type: "author",
                	  <portlet:namespace />idType: "local",
                	  <portlet:namespace />itemId: '<%=suburItem.getItemId()%>'
                
                }, 
                autoLoad:false, 
                sync:false, 
                on: { success:function(){ 
                    var data=this.get('responseData'); 
                    authorData=data; 
                }} 
            }); 
            authorAjaxReq.start(); 
			
			
			
			
			
			
		}
			
		
		
		
);

</aui:script>
<aui:script use="aui-base,escape,liferay-search-container">
Liferay.provide(
		window,
		'<portlet:namespace />addAuthor',
		function(authorId, firstName, lastName,searchContainer) {
			var A = AUI();
			
			var searchContainerName = '<portlet:namespace />' + searchContainer + 'SearchContainer';

			searchContainer = Liferay.SearchContainer.get(searchContainerName);
			
			
			var rowColumns = [];

			rowColumns.push(A.Escape.html(firstName));
			rowColumns.push(A.Escape.html(lastName));
			

			
			rowColumns.push('<a class="modify-link" data-rowId="' + authorId + '" href="javascript:;"><%= UnicodeFormatter.toString(removeAuthorIcon) %></a>');
			
			
			searchContainer.addRow(rowColumns, authorId);
			searchContainer.updateDataStore();
		}
		
	);

</aui:script>
<aui:script use="liferay-search-container">
	var searchContainer = Liferay.SearchContainer.get('<portlet:namespace />authorsSearchContainer');

	searchContainer.get('contentBox').delegate(
	'click',
	function(event) {
		var link = event.currentTarget;
		var tr = link.ancestor('tr');
		
		searchContainer.deleteRow(tr, link.getAttribute('data-rowId'));
		
		
	},
	'.modify-link'
);
</aui:script>
	