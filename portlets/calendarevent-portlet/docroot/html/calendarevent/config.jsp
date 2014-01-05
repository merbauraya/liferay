<%@ include file="/html/calendarevent/init.jsp" %>
<%@ page import="com.idetronic.calendarevent.EventDisplayModel" %>
<liferay-portlet:actionURL portletConfiguration="true" var="configActionUrl"/>

<%
	EventDisplayModel evModel = (EventDisplayModel)request.getAttribute("evModel");

%>
<aui:form name="fm" method="POST"
	action="<%=configActionUrl.toString() %>">
	<aui:input name="maxAllEventDisplay" value="${evModel.getMaxAllEventDisplay() }" label="Maximun All Event to be displayed" />
	<aui:input name="maxEventDisplay" value="${evModel.getMaxEventDisplay() }" label="Maximum individu event to be displayed" />
	<aui:field-wrapper name="showEmptyEventType" label="Show empty event">
		<aui:input inlineField="true" checked="<%= (evModel.getShowEmptyEventType().equalsIgnoreCase(\"0\") ? true : false) %>" inlineLabel="Hide" name="showEmptyEventType" type="radio" value="0" label="Hide" />
		<aui:input inlineField="true" checked="<%= (evModel.getShowEmptyEventType().equalsIgnoreCase(\"0\") ? false : true) %>" inlineLabel="Show" name="showEmptyEventType" type="radio" value="1" label="Show" />
	
	</aui:field-wrapper>
	
	<aui:button type="submit" value="Save"></aui:button>
</aui:form>