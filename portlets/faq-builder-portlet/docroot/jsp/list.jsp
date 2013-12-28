<%@include file="/jsp/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%
PortletURL entryURL = renderResponse.createRenderURL();
entryURL.setParameter("jspPage", "/jsp/entry.jsp");
%>

<a class="btn btn-primary" href="<%= entryURL %>">New FAQ Entry</a>&nbsp; 
<a href="<portlet:renderURL/>">&laquo; Go Back</a>
  
<%
	
	List<FAQEntry> faqsTemp = (List<FAQEntry>)	request.getAttribute("SEARCH_RESULT");
	List<FAQEntry> faqs = Validator.isNotNull(faqsTemp)? 
				ListUtil.copy(faqsTemp): FAQEntryLocalServiceUtil.getFAQEntries(0, -1) ;

	//List<FAQEntry> faqs = FAQEntryLocalServiceUtil.getFAQEntries(0, -1);//  .getAll();
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("jspPage", FAQConstant.PAGE_LIST);
	
	PortletURL deleteFaqURL = renderResponse.createActionURL();
	deleteFaqURL.setParameter(ActionRequest.ACTION_NAME,FAQConstant.ACTION_DELETE_FAQ);
	deleteFaqURL.setParameter("redirectURL", iteratorURL.toString());
	
	PortletURL editFaqURL = renderResponse.createRenderURL();
	editFaqURL.setParameter("jspPage", FAQConstant.EDIT_FAQ);
	editFaqURL.setParameter("backURL", themeDisplay.getURLCurrent());
	Integer delta = (Integer)request.getAttribute("delta"); 
	
	PortletURL addURL = renderResponse.createRenderURL();
	addURL.setParameter("jspPage",FAQConstant.EDIT_FAQ);
	String catMsg="";
	%>
	<portlet:actionURL var="searchFaqURL" 	name="<%= FAQConstant.ACTION_SEARCH_FAQS %>" />

<aui:form action="<%= searchFaqURL.toString() %>">
<aui:input name="searchTerm" label="Search Term"/>
<aui:button type="submit" value="<%= LanguageUtil.get(locale, FAQConstant.KEY_SEARCH) %>" />
</aui:form>

<h1>List of FAQ Entry</h1>
<liferay-ui:search-container delta="10" emptyResultsMessage="Sorry. There are no items to display."
	iteratorURL="<%= iteratorURL %>">
	<liferay-ui:search-container-results total="<%= faqs.size() %>"
		results="<%= ListUtil.subList(faqs,searchContainer.getStart(),searchContainer.getEnd()) %>"/>

	<liferay-ui:search-container-row modelVar="faq" className="FAQEntry">
	<liferay-ui:search-container-column-text name="Category" property="category" />
	<liferay-ui:search-container-column-text name="question" property="question" orderableProperty="question" />
	<liferay-ui:search-container-column-text name="Date Added" property="createDate">
	
	</liferay-ui:search-container-column-text>
	<liferay-ui:search-container-column-text name="Action">
		<liferay-ui:icon-menu>
			<%
			editFaqURL.setParameter("faqId", Long.toString(faq.getEntryId()));
			deleteFaqURL.setParameter("faqId", Long.toString(faq.getEntryId()));
			addURL.setParameter("category", faq.getCategory());
			catMsg = "Add in '"+faq.getCategory()+ "'";
			%>
			<liferay-ui:icon image="edit" url="<%=editFaqURL.toString()  %>" />
			<liferay-ui:icon image="page" url="<%= addURL.toString() %>" label="true" message="<%= catMsg %>"/>
			<liferay-ui:icon-delete url="<%=deleteFaqURL.toString()  %>" />
	
		</liferay-ui:icon-menu>
	
	</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</liferay-ui:search-container>