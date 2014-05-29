<%@ include file="/html/eventview/init.jsp" %>
<liferay-portlet:actionURL portletConfiguration="true" var="configActionUrl"/>
<%
	int view_Type=0; 
	
	boolean showTitle = viewConfig.getShowInternalTitle();// preferences.getValue("showTitle", "false");
	
%>


<aui:form name="fm" method="POST" action="<%=configActionUrl.toString() %>" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "submitConfig();" %>'>
	<aui:fieldset>
		<aui:input type="text" name="internalTitle" label="Internal Title"
			value="<%=viewConfig.getInternalTitle() %>" />
		
		<aui:input type="checkbox" name="showInternalTitle" label="Show Internal Title" 
			checked="<%=showTitle %>"
		/>
		
		<aui:select  name="viewType" label="View Type">
			<aui:option selected="<%= (viewType==EventViewConstant.VIEW_UPCOMING_EVENT) %>"	
				value="<%=EventViewConstant.VIEW_UPCOMING_EVENT %>"> 
				<liferay-ui:message key="Upcoming Event" />
			</aui:option>
		
			<aui:option selected="<%= (viewType == EventViewConstant.VIEW_MONTH_VIEW) %>"	
				value="<%=EventViewConstant.VIEW_MONTH_VIEW %>">
				<liferay-ui:message key="Month Event" />
			</aui:option>
		
		</aui:select>
		
		<aui:select name="maxDaysToQuery" label="Max No of Days to Query">
			<aui:option value="10"
				selected="<%=viewConfig.getMaxDaysToQuery() == 10 %>">
				<liferay-ui:message key="10"></liferay-ui:message>
			</aui:option>
			<aui:option value="30"
				selected="<%=viewConfig.getMaxDaysToQuery() == 30 %>">
				<liferay-ui:message key="30"></liferay-ui:message>
			</aui:option>
			<aui:option value="60"
				selected="<%=viewConfig.getMaxDaysToQuery() == 60 %>">
				<liferay-ui:message key="60"></liferay-ui:message>
			</aui:option>
			<aui:option value="100"
				selected="<%=viewConfig.getMaxDaysToQuery() == 100 %>">
				<liferay-ui:message key="100"></liferay-ui:message>
			</aui:option>
			<aui:option value="365"
				selected="<%=viewConfig.getMaxDaysToQuery() == 365 %>">
				<liferay-ui:message key="365"></liferay-ui:message>
			</aui:option>
		</aui:select>
		<aui:select name="maxItemToDisplay" label="Max Item To Display">
			<aui:option value="5"
				selected="<%=viewConfig.getMaxItemToDisplay() == 5 %>">
				<liferay-ui:message key="5"></liferay-ui:message>
			</aui:option>
			<aui:option value="10"
				selected="<%=viewConfig.getMaxItemToDisplay() == 10 %>">
				<liferay-ui:message key="10"></liferay-ui:message>
			</aui:option>
			<aui:option value="15"
				selected="<%=viewConfig.getMaxItemToDisplay() == 15 %>">
				<liferay-ui:message key="15"></liferay-ui:message>
			</aui:option>
			<aui:option value="20"
				selected="<%=viewConfig.getMaxItemToDisplay() == 20 %>">
				<liferay-ui:message key="20"></liferay-ui:message>
			</aui:option>
		</aui:select>
		<aui:select name="upcomingViewType" label="View Type">
			<aui:option value="<%=EventViewConstant.UPCOMING_VIEW_SIMPLE %>"
				selected="<%= (viewConfig.getUpcomingViewType() ==EventViewConstant.UPCOMING_VIEW_SIMPLE) %>">
				<liferay-ui:message key="Simple" />
			</aui:option>
			<aui:option value="<%=EventViewConstant.UPCOMING_VIEW_GRAPHICAL %>"
				selected="<%= (viewConfig.getUpcomingViewType() ==EventViewConstant.UPCOMING_VIEW_GRAPHICAL) %>">
				<liferay-ui:message key="Graphical" />
			</aui:option>
		</aui:select>
		<aui:button type="submit" value="Save" />
	</aui:fieldset>

</aui:form>
<aui:script>
  Liferay.provide(
       window,
        '<portlet:namespace />submitConfig',
        function() {
        
        	document.<portlet:namespace />fm.submit();
        }, ['liferay-util-list-fields']
       );
 </aui:script>
