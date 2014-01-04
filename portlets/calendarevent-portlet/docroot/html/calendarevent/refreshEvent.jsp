<%@ include file="/html/calendarevent/init.jsp" %>

<%
	List<CalEvent> lstEvents = (List<CalEvent>) request.getAttribute("lstEvents");
	String[] eventTypes = CalendarHelper.getEventType();
	request.setAttribute("events", lstEvents);	
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
		
    