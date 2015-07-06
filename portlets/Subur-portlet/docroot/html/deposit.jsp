<%@ include file="/html/init.jsp" %>
<%
String itemIdString = (String)request.getAttribute("itemId");
if (Validator.isNull(itemIdString))
	itemIdString = ParamUtil.getString(request, "itemId");
long itemId = 0;
SuburItem suburItem = null;
if (Validator.isNotNull(itemIdString))
{
	itemId = Long.valueOf(itemIdString);
	suburItem = SuburItemLocalServiceUtil.getSuburItem(itemId);
	request.setAttribute("suburItem",suburItem);
}
	
	//out.print("itemId="+itemId);
String redirect = ParamUtil.getString(request, "redirect");
String backURL = ParamUtil.getString(request, "backURL", redirect);

String[] item = {"identity","author","categorization","upload","license","permission"};
String[][] categorySections = {item};

%>

<portlet:actionURL name="depositItem" var="depositItemURL"/>


<aui:form method="post" action="<%=depositItemURL%>" name="fm" enctype="multipart/form-data" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "submitForm();" %>'>
	<aui:input name="itemId" type="hidden" value="<%= suburItem.getItemId() %>"/>
	<aui:input name="redirect" value="<%= redirect%>" type="hidden" />
	<aui:model-context bean="<%=suburItem%>" model="<%=SuburItem.class%>" />


<liferay-util:buffer var="htmlTop">
		
			<div class="htmlTop">
				<div class="float-container">
					<span>htmlTop</span>
				</div>
			</div>
		
	</liferay-util:buffer>

	<liferay-util:buffer var="htmlBottom">
		<div class="htmlBottom">
				<div class="float-container">
					<span>htmlBottom</span>
				</div>
			</div>
			
		
	</liferay-util:buffer>

<liferay-ui:form-navigator

    backURL="<%=backURL %>"
    categoryNames="<%= _CATEGORY_NAMES %>"
    categorySections="<%= categorySections %>"
    formName="fm"
    htmlBottom="<%=htmlBottom %>"
    jspPath="/html/deposit/" 
    showButtons="<%=true %>"
/>

<aui:script>
	
		
		function <portlet:namespace />submitForm()
		{
			var A = AUI();
			var assetCategoryIdArr = [];
			var catdIds = A.all('input[name^=<portlet:namespace/>assetCategoryIds]');
			
			catdIds.each(function(){
				assetCategoryIdArr.push(this.val());
				
				
				
			});
			A.one("#<portlet:namespace/>categoryIds").val(assetCategoryIdArr);
			
			var assetTagNames = A.one('input[name^=<portlet:namespace/>assetTagNames]').val();
			A.one("#<portlet:namespace/>tagNames").val(assetTagNames);		
			
			submitForm(document.<portlet:namespace />fm);
		}
		
		
		
		
	

</aui:script>

</aui:form>




<%!
private static final String[] _CATEGORY_NAMES = {"item"};
%>