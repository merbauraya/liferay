<%@ include file="/html/calendarevent/init.jsp" %>

<%
	List<CalEvent> lstEvents = (List<CalEvent>) request.getAttribute("lstEvents");
	EventDisplayModel evModel = (EventDisplayModel) request.getAttribute("evModel");
	String[] eventTypes = CalendarHelper.getEventType();
	request.setAttribute("events", lstEvents);	
	request.setAttribute("evModel",evModel);
%>

       <liferay-util:include page="/html/calendarevent/render_event.jsp" servletContext="<%=this.getServletContext() %>">
			<liferay-util:param name="eventType" value="<%=CalendarConstant.ALL_EVENT %>" />
		</liferay-util:include>
       
       <% for (String eventType: eventTypes) 
       		
       
       {%>
       	 <liferay-util:include page="/html/calendarevent/render_event.jsp" servletContext="<%=this.getServletContext() %>">
			<liferay-util:param name="eventType" value="<%=eventType %>" />
		</liferay-util:include>
       		
        
        <%} %>
        
      
      
<liferay-util:include page="/html/calendarevent/divtoogle.jsp" servletContext="<%=this.getServletContext() %>"/>
		
    