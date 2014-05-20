<%@ include file="/html/eventview/init.jsp" %>
<%

PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("jspPage", "/html/eventview/view.jsp");

List<CalendarBooking> events = EventViewUtil.getCurrentMonthEvent(themeDisplay, false);


%>

<liferay-ui:search-container
		emptyResultsMessage='No results to display'
		iteratorURL="<%= portletURL %>"
	>
	<liferay-ui:search-container-results
			total="<%=events.size() %>"
			results="<%= ListUtil.subList(events,searchContainer.getStart(),searchContainer.getEnd()) %>"
		/>
	<liferay-ui:search-container-row
			className="CalendarBooking"
			modelVar="entry">
		
			<liferay-ui:search-container-column-text
				name="date"
				value="<%=dateFormatLongDate.format(entry.getStartTime())+ \",\" + dateFormatDate.format(entry.getStartTime()) %>"
			/>
			<%
				String href = "javascript:viewEventDetail('"+ entry.getCalendarBookingId() + "')";
			%>
			<liferay-ui:search-container-column-text
				name="title"
				value="<%= entry.getTitle(locale) %>"
				href="<%=href %>"
				
				
			/>
			
		
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</liferay-ui:search-container>

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
