

<%@include file="/jsp/init.jsp"%>
<%
PortletURL listURL = renderResponse.createRenderURL();
listURL.setParameter("jspPage", "/jsp/list.jsp");
%>

<a class="btn btn-primary" href="<%= listURL %>">FAQ List</a>&nbsp; 


<h1>Add / Edit FAQ</h1>

<%
PortletURL addEntryUrl = renderResponse.createActionURL();
addEntryUrl.setParameter(ActionRequest.ACTION_NAME, "addEntry");

PortletURL updateEntryUrl = renderResponse.createActionURL();
updateEntryUrl.setParameter(ActionRequest.ACTION_NAME, "editFaq");

//listType mm =new ListType;
//Strin xx = ListTypeConstants..fdsafds;
String faqId = request.getParameter("faqId");
String category="",question="",answer="";
PortletURL actionURL;

if (faqId != null) //edit mode
{
	actionURL = updateEntryUrl;
	long id = Long.parseLong(faqId);
	FAQEntry faq = FAQEntryLocalServiceUtil.fetchFAQEntry(id);
	category = faq.getCategory();
	question = faq.getQuestion();
	answer = faq.getAnswer();
	
}
else
{
	actionURL = addEntryUrl;
	//test if we are adding faq in specific category
	category = request.getParameter("category");
}
%>


<aui:form name="fm" method="POST" action="<%= actionURL.toString() %>"  onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "updateFaq();" %>'>
	<aui:fieldset>
		<aui:input name="<%= Constants.CMD %>" type="hidden" />
		<aui:input name="category" label="Category" value="<%= category %>" />
		<aui:input name="faqid" type="hidden" value="<%= faqId%>" />
		<aui:input name="question" label="Question" value="<%= question %>" />
		
		<aui:field-wrapper label="Answer">
			<liferay-ui:input-editor width="100%" />

			<aui:input name="answer" type="hidden" />
		</aui:field-wrapper>
	
		<aui:button type="submit" value="Save" />
		<aui:button href="<%= listURL.toString() %>" type="cancel" />
	</aui:fieldset>
</aui:form>
<aui:script>
	function <portlet:namespace />initEditor() {
		return "<%= UnicodeFormatter.toString(answer) %>";
	}

	

	function <portlet:namespace />updateFaq() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= (faqId == null) ? Constants.ADD : Constants.UPDATE %>";
		document.<portlet:namespace />fm.<portlet:namespace />answer.value = window.<portlet:namespace />editor.getHTML();
		submitForm(document.<portlet:namespace />fm);
	}
</aui:script>
