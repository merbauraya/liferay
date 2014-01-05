<%@ include file="/html/calendarevent/init.jsp" %>

<%
String eventType = ParamUtil.getString(request, "eventType", "ALL_EVENT");
List<CalEvent> lstRenderEvent = new ArrayList<CalEvent>();
List<CalEvent> lstEvents = (List<CalEvent>)request.getAttribute("events");
EventDisplayModel evModel = (EventDisplayModel) request.getAttribute("evModel");
Map<String, Integer> map = new HashMap<String, Integer>();
int i = 0;
int maxEventDisplay = Integer.parseInt(evModel.getMaxEventDisplay());
for (CalEvent cev : lstEvents) 
{
	if (eventType == CalendarConstant.ALL_EVENT){
		if (i < Integer.parseInt(evModel.getMaxAllEventDisplay()))
			lstRenderEvent.add(cev);
		i++;
	}
	else 
	{
		if (cev.getType().equalsIgnoreCase(eventType))
		{
			if (map.containsKey(eventType))
				map.put(eventType, map.get(eventType)+1);
			else
				map.put(eventType, 0);
			if (maxEventDisplay > map.get(eventType))
				lstRenderEvent.add(cev);
		}
		
	}
		
}

%>
<div id="<%=eventType.replaceAll(" ","-")%>" class="tab-pane fade <%=eventType.equals(CalendarConstant.ALL_EVENT)? "active in":"" %>">
	<c:choose>
	    <c:when test="<%= (lstRenderEvent == null) %>">
			<div class="alert alert-warning">
				<strong>Error retrieving event. Please retry again</strong>
			
			</div>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="<%= (lstRenderEvent.size() == 0) %>">
					<div class="alert alert-info">
						<strong>No event defined</strong>
					</div>
				</c:when>
			<c:otherwise>


<%
	for (CalEvent ce : lstRenderEvent) {
		GregorianCalendar nextOccur = new GregorianCalendar();
		nextOccur.setTime(ce.getStartDate());					
		//nextOccur.set(Calendar.DAY_OF_MONTH, Calendar.DAY_OF_MONTH);
		//nextOccur.set(Calendar.MONTH, Calendar.MONTH);
		
		Date date = Time.getDate(nextOccur.getTime(), TimeZoneUtil.getDefault());
		
		SimpleDateFormat dfMonth = new SimpleDateFormat("MMM",locale);
		SimpleDateFormat evTime = new SimpleDateFormat("h:mm a",locale);
		SimpleDateFormat dfYear = new SimpleDateFormat("yyyy",locale);
		SimpleDateFormat dfDay = new SimpleDateFormat("dd",locale);
		String monthYear = dfMonth.format(Time.getDate(nextOccur.getTime(), TimeZoneUtil.getDefault()));
		monthYear += " " + dfYear.format(Time.getDate(nextOccur.getTime(), TimeZoneUtil.getDefault()));
%>	
	
				<div class="cl-event-item">
					<div class="cl-event-date">
						<div class="cl-event-month">
							<%=monthYear%>
						</div>
						<div class="cl-event-day">
							<%=dfDay.format(Time.getDate(nextOccur.getTime(), TimeZoneUtil.getDefault()))%> 
						</div>
					
					</div>
					<div class="cl-event-info">
						<div class="cl-event-title">
							<a href="/c/calendar/find_event?eventId=<%=ce.getEventId()%>"><%=ce.getTitle()%></a>
						</div>
						<div class="cl-event-time">
							Start : <%=evTime.format(Time.getDate(nextOccur.getTime(), TimeZoneUtil.getDefault())) %>
							Duration: 
							<c:choose>
								<c:when test="<%(ce.getAllDay()== true ))%>">
									All Day Event
								</c:when>
								<c:otherwise>
									<%=ce.getDurationHour() %> hour		
								</c:otherwise>
							</c:choose>
							
						</div>
						<div class="cl-event-location">
							Location: <%=ce.getLocation() %>
						</div>
						<div class="cl-event-detail">
							<img alt="<%=  LanguageUtil.get(pageContext, "expande") %>" class="<portlet:namespace />entry-expander cl-entry-expander" src='<%= themeDisplay.getPathThemeImage() %>/arrows/01_plus.png' />
								<span>View Detail Info</span>
							<div class="cl-event-desc aui-helper-hidden row">
								<%=ce.getDescription() %>
							</div>
						</div>
					</div>
				</div>
	
	
	<%
		}
	%>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
</div>