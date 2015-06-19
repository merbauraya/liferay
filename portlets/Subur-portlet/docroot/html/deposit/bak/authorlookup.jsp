
<%@ include file="/html/item.jsp" %>
<%@ page import="com.idetronic.subur.search.AuthorSearch" %>
<%@ page import="com.idetronic.subur.search.AuthorSearchTerms" %>

<%
	long itemId = Long.parseLong(request.getParameter("itemId"));
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "addAuthor");

	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("jspPage", "/html/deposit/authorlookup.jsp");
	portletURL.setParameter("eventName", eventName);
	portletURL.setParameter("itemId", String.valueOf(itemId));
	
%>
<aui:form action="<%= portletURL.toString() %>" method="post" name="selectAuthorFm">
	<liferay-ui:header
		title="author"
	/>
	<div class="form-search">
		<liferay-ui:input-search autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>" placeholder='<%= LanguageUtil.get(locale, "keywords") %>' />
	</div>
	
	<liferay-util:buffer var="selectAuthorIcon">
	<liferay-ui:icon
		image="unlink"
		label="<%= true %>"
		message="select"
	/>
</liferay-util:buffer>
	<liferay-ui:search-container
		headerNames="First Name,Last Name"
		searchContainer="<%= new AuthorSearch(renderRequest,portletURL) %>"
	>
	<%
		AuthorSearchTerms searchTerms = (AuthorSearchTerms)searchContainer.getSearchTerms();
	%>
	<liferay-ui:search-container-results>
		<%
		List<Author> authors = AuthorLocalServiceUtil.search(searchTerms.getKeywords(),searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
		total = authors.size();
		searchContainer.setTotal(total);
		results = ListUtil.subList(authors, searchContainer.getStart(), searchContainer.getEnd());
		
		searchContainer.setResults(results);
		%>
	
	
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row
			className="com.idetronic.subur.model.Author"
			keyProperty="authorId"
			modelVar="author"
		>
		
		<liferay-ui:search-container-column-text
				name="First Name"
				value="<%= HtmlUtil.escape(author.getFirstName()) %>"
				orderable="<%= true %>"
		/>
		<liferay-ui:search-container-column-text
				name="Last Name"
				value="<%= HtmlUtil.escape(author.getLastName()) %>"
		/>
		
		<liferay-ui:search-container-column-text>
			<%
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("authorId",author.getAuthorId());
			data.put("firstName",author.getFirstName());
			data.put("lastName",author.getLastName());
			data.put("searchcontainername", "authors");
			%>
			
			<aui:button cssClass="selector-button" data="<%= data %>" value="choose" />
			<a class="modify-link" data="<%= data %> <%= selectAuthorIcon %></a>
		</liferay-ui:search-container-column-text>
			
		
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
	
</liferay-ui:search-container>
	
	
	
	<aui:fieldset>
		<aui:column width="<%=50 %>">
			<aui:input id="firstName" name="firstName"/>
		</aui:column>
		<aui:column width="<%=50 %>">
			<aui:input id="lastName" name="lastName"/>
		</aui:column>
	</aui:fieldset>
	<aui:input name="authorId" type="hidden"/>
	<aui:input name="authorIdType" type="hidden"/>
	<aui:row>
		
		<aui:button name="addAuthor" type="button" value="Add" />
		<aui:button name="cancelAuthor" type="button" value="Cancel" />
	</aui:row>


</aui:form>
<portlet:resourceURL var="authorLookupURL" id="<%=SuburConstant.RESOURCE_AUTHOR_LOOKUP %>">




	
</portlet:resourceURL>
<aui:script>
    AUI().use('autocomplete-list','aui-base','aui-io-request','autocomplete-filters','autocomplete-highlighters',function (A) { 
    var authorData; 
    
    new A.AutoCompleteList({ 
        allowBrowserAutocomplete: 'true', 
        activateFirstItem: 'true', 
        inputNode: '#<portlet:namespace />firstName', 
        resultTextLocator:'name', 
        render: 'true', 
        resultHighlighter: 'phraseMatch', 
        resultFilters:['phraseMatch'], 
        source:function(){ 
            var inputValue=A.one("#<portlet:namespace />firstName").get('value'); 
            console.log(inputValue);
            var authorAjaxReq = A.io.request('<%=authorLookupURL.toString()%>',{ 
                dataType: 'json', 
                method:'GET', 
                data:{<portlet:namespace />keyword: inputValue, }, 
                autoLoad:false, 
                sync:false, 
                on: { success:function(){ 
                    var data=this.get('responseData'); 
                    authorData=data; 
                }} 
            }); 
            authorAjaxReq.start(); 
        	return authorData;
        },
        on: {
    		select: function(event) {
    			var result = event.result.raw;
    			A.one('#<portlet:namespace/>authorId').val(result.key);
    			
    			console.log(result);
    		}
    	},
    }); 
    A.one('#<portlet:namespace/>addAuthor').on('click', function(event) {
    	console.log('add click');
    	var author = {
        			firstName: A.one("#<portlet:namespace />firstName").get('value'),
        			lastName : A.one("#<portlet:namespace />lastName").get('value'),
        			authorId : "123",
        			idType   : A.one("#<portlet:namespace />authorIdType").get('value'),
    	}
    	console.log(event);
    	console.log(event.currentTarget);
    	// Invoke a function with processgin results and dialog id
    	Liferay.Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>', author);
    	Liferay.Util.getWindow().destroy();
    });
    
    A.one('#<portlet:namespace/>cancelAuthor').on('click', function(event) {
    	// Let's suppose that "data" contains the processing results
    	var author = {
        			firstName: A.one("#<portlet:namespace />firstName").get('value'),
        			lastName : A.one("#<portlet:namespace />lastName").get('value'),
        			authorId : A.one("#<portlet:namespace />authorId").get('value'),
        			idType   : A.one("#<portlet:namespace />authorIdType").get('value'),
    	}
    	// Invoke a function with processgin results and dialog id
    	Liferay.Util.getOpener().<portlet:namespace/>closePopup(null, '<%= HtmlUtil.escapeJS(eventName) %>');
    });
    
    
    
});
Liferay.provide(window,'addAuthor',
	function() {
    	var A = AUI();
    	
    	var author = {
    			firstName: A.one("#<portlet:namespace />firstName").get('value'),
    			lastName : A.one("#<portlet:namespace />lastName").get('value'),
    			authorId : A.one("#<portlet:namespace />authorId").get('value'),
    			idType   : A.one("#<portlet:namespace />authorIdType").get('value'),
    			
    	}
        <portlet:namespace/>updateAuthorDisplay(author);
           
});
function <portlet:namespace/>updateAuthorDisplay(author)
{
	var opener = Liferay.Util.getOpener();
	console.log('upd');
	//opener.updateAuthor(author);
	var openingPage = Liferay.Util.getOpener().Liferay;
	
	//openingPage.fire('updateAuthor',author);
	Liferay.Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>', author);
	//openingPage.closePopup('<portlet:namespace/>addEditAuthor');
	console.log('<%= HtmlUtil.escapeJS(eventName) %>');
	//opener.closePopup('<portlet:namespace/>addEditAuthor');
	opener.closePopup('<%= HtmlUtil.escapeJS(eventName) %>');
}


</aui:script>
<aui:script use="aui-base">
	var Util = Liferay.Util;

	A.one('#<portlet:namespace />selectAuthorFm').delegate(
		'click',
		function(event) {
			var result = Util.getAttributes(event.currentTarget, 'data-');

			Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>', result);

			Util.getWindow().destroy();
		},
		'.selector-button'
	);
</aui:script>