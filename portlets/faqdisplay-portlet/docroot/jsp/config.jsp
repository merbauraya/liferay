<%@include file="/jsp/init.jsp" %>
<liferay-portlet:actionURL portletConfiguration="true" var="configActionUrl"/>


<%
	
	List<Object> cats = FAQEntryLocalServiceUtil.getCategory();
	List leftList = new ArrayList();
	List rightList = new ArrayList();
	if (Validator.isNotNull(selectedCategory))
	{
		 for (String retval: selectedCategory.split(",")){
	         rightList.add(new KeyValuePair(retval,retval));
	      }
		
	}
	
	
	for (Object c : cats)
	{
		Object r[] = (Object[]) c;
		
		leftList.add(new KeyValuePair((String)r[0],(String)r[0]));
		
	}

%>
<form name="fm" method="POST" action="<%=configActionUrl.toString() %>" inlineLabel="true">
	<aui:layout>
		
		 
			<liferay-ui:input-move-boxes
					leftBoxName="availableCat"
					leftList="<%= leftList %>"
					leftReorder="true"
					leftTitle="selected"
					rightBoxName="selectedCat"
					rightList="<%= rightList %>"
					rightTitle="available"
				/>
   
	</aui:layout>
	<aui:input type="hidden" name="toList"/>

 	 <input type="button" value="Submit" onclick="<portlet:namespace />submitForm();">
 
</form>
<aui:script>
  Liferay.provide(
       window,
        '<portlet:namespace />submitForm',
        function() {
        document.fm.<portlet:namespace />toList.value = Liferay.Util.listSelect(document.fm.<portlet:namespace />selectedCat);
        
        document.fm.submit();
        }, ['liferay-util-list-fields']
       );
 </aui:script>