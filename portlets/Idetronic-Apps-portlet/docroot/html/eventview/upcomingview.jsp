<%@ include file="/html/eventview/init.jsp" %>
<%

	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("jspPage", "/html/eventview/view.jsp");
	List<CalendarBooking> events = EventViewUtil.getUpComingEvent(themeDisplay, 10, 100);// .getCurrentMonthEvent(themeDisplay, false);


	%>
	
	<%
		for (CalendarBooking ce: events)
		{
			GregorianCalendar nextOccur = new GregorianCalendar();
			nextOccur.setTimeInMillis(ce.getStartTime());					
			
			Date date = Time.getDate(nextOccur.getTime(), TimeZoneUtil.getDefault());
			
			SimpleDateFormat dfMonth = new SimpleDateFormat("MMM",locale);
			SimpleDateFormat dfDayName = new SimpleDateFormat("EEE");
			SimpleDateFormat evTime = new SimpleDateFormat("h:mm a",locale);
			SimpleDateFormat dfYear = new SimpleDateFormat("yyyy",locale);
			SimpleDateFormat dfDay = new SimpleDateFormat("dd",locale);
			String month = dfMonth.format(Time.getDate(nextOccur.getTime(), TimeZoneUtil.getDefault()));
			//monthYear += " " + dfYear.format(Time.getDate(nextOccur.getTime(), TimeZoneUtil.getDefault()));
			String year = dfYear.format(Time.getDate(nextOccur.getTime(), TimeZoneUtil.getDefault()));
			String day = dfDayName.format(Time.getDate(nextOccur.getTime(), TimeZoneUtil.getDefault()));
		
	
	%>
	<div class="cl-event-item">
		<div class="cl-event-date">
			<div class="cl-event-year">
				<%=year %>
			</div>
			<div class="cl-event-dayname">
				<%=day %>
			</div>
			<div class="cl-event-month">
				<%=month%>
			</div>
			<div class="cl-event-day">
				<%=dfDay.format(Time.getDate(nextOccur.getTime(), TimeZoneUtil.getDefault()))%> 
			</div>
		
		</div>
		<div class="cl-event-info">
			<div class="cl-event-title">
				<%
					String popLink = "javascript:viewEventDetail('"+ce.getCalendarBookingId()+"')";
					String tmpTitle = ce.getTitle(locale);
					String shortTitle = tmpTitle.substring(0, Math.min(tmpTitle.length(), 50));
							
				%>
				<a href="<%=popLink%>">
				
				<%=shortTitle%></a>
			

			</div>
			<div class="cl-event-time">
				Start : <%=dateFormatTime.format(ce.getStartTime()) %>
				<c:choose>
					<c:when test="<%=ce.getAllDay() %>">
						- All Day Event
					</c:when>
					<c:otherwise>
						-  <%=dateFormatTime.format(ce.getEndTime()) %>	
					</c:otherwise>
				</c:choose>
				
				
				
			</div>
			<div class="cl-event-location">
				Location: <%=ce.getLocation() %>
			</div>
			
		</div>
	</div>
	
	
	<%
		}
	%>
	

	<aui:script>
		
		Liferay.provide(
		window,
		'viewEventDetail',
		function(eventId) {
			var instance = this;
			var portletURL = new Liferay.PortletURL.createRenderURL();
			portletURL.setParameter("eventId",eventId);
			portletURL.setWindowState('pop_up');
			portletURL.setParameter("jspPage", "/html/eventview/view-detail.jsp");
			portletURL.setPortletId("<%=portletId %>");
		

			var url=portletURL.toString();

				Liferay.Util.openWindow(
					{
						cache: false,
						dialog: {
							align: Liferay.Util.Window.ALIGN_CENTER,
							after: {
								render: function(event) {
									this.set('y', this.get('y') + 50);
								}
							},
							
						},
						dialogIframe: {
							id: 'eventDetail',
							uri: url
						},
						title: 'Event Detail',
						uri: url
					}
				);
		},
		['liferay-util-window']
	);
			



				
</aui:script>