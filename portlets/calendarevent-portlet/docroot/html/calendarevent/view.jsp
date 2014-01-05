<%@ include file="/html/calendarevent/init.jsp" %>

<portlet:resourceURL  var="refreshEventAjaxUrl"></portlet:resourceURL >

<%
String[] eventTypes = CalendarHelper.getEventType();
List<CalEvent> lstEvents;
EventDisplayModel evModel = (EventDisplayModel)request.getAttribute("evModel");
lstEvents = CalendarHelper.getMonthEvent(themeDisplay,evModel); 
request.setAttribute("events", lstEvents);	
%>
<div id="dateSliderWrapper">
	<input type="hidden" id="startDate">
	<input type="hidden" id="endDate">
	
	<div id="dateSlider"></div>
</div>

<div class="cl-event-wrapper">
      <ul class="nav nav-tabs" id="cl-event-tab">
        <li class="active"><a data-toggle="tab" href="#<%=CalendarConstant.ALL_EVENT%>">All Event</a></li>
        <% for (String eventType: eventTypes) {%>
        	<li id="<%=CalendarConstant.EVENT_TYPE_ID_PREFIX +eventType.replaceAll(" ","-")%>"><a data-toggle="tab" href="#<%=eventType.replaceAll(" ","-") %>"><%=eventType %></a></li>
        
        <%} %>
      </ul>
      
      <div class="tab-content" id="cl-event-tabContent">
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
      </div>
      

    </div>
    
   
 <aui:script>
 	var d = new Date();
 	var maxDate = new Date(d.getFullYear(),d.getMonth(), 0);
 	//set 1 year date range, 6 prev + 6 fwd
 	var lowDate =  new Date();
 	lowDate.setMonth(d.getMonth()-6);
 	var hiDate = new Date();
 	hiDate.setMonth(d.getMonth()+6);
 	var hiMaxdate = new Date(hiDate.getFullYear(),hiDate.getMonth(),0);
 	
 	var months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"];
    $("#dateSlider").dateRangeSlider({
    bounds: {min: new Date(lowDate.getFullYear(), lowDate.getMonth(), 1), max: new Date(hiDate.getFullYear(),hiDate.getMonth(), hiMaxdate.getDate(), 12, 59, 59)},
    defaultValues: {min: new Date(d.getFullYear(), d.getMonth(), 1), max: new Date(d.getFullYear(), d.getMonth(), maxDate.getDate())},
    scales: [{
      first: function(value){ return value; },
      end: function(value) {return value; },
      next: function(value){
        var next = new Date(value);
        return new Date(next.setMonth(value.getMonth() + 1));
      },
      label: function(value){
        return months[value.getMonth()];
      },
      format: function(tickContainer, tickStart, tickEnd){
        tickContainer.addClass("myCustomClass");
      }
    }]
  });
    
    
        $("#dateSlider").bind("valuesChanged", function(e, data){
            var startDate = data.values.min;
            var endDate = data.values.max;
            var startMonth = parseInt(startDate.getMonth())+1;
            var endMonth = parseInt(endDate.getMonth())+1;
            $("#startDate").val(startDate.getFullYear() + "-" +startMonth + "-"+startDate.getDate() );
            $("#endDate").val(endDate.getFullYear() + "-" +endMonth + "-"+endDate.getDate() );
            
            //$("#minVal").value(data.values.min);
    		<portlet:namespace/>_updateEvent();
    });
    
    function <portlet:namespace/>_updateEvent()
    {
    	jQuery.ajax({
			type: "POST",
			url: "<%=refreshEventAjaxUrl%>",
			cache: false,
			dataType: "html",
			data : {
					startDate: $("#startDate").val(),
					endDate: $("#endDate").val(),
					isAjax: 1,
			},
			success: function(res)
			{
				$("#cl-event-tabContent").html(res);
				
			},
			error: function () {
                    //do stuff on error
                    console.log('Error Occurred');
                }
		});
		
    }
    </aui:script>