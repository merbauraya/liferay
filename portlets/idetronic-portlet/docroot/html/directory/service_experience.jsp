<%
List<ServiceExperience> userServiceExperiences = ServiceExperienceLocalServiceUtil.getUserServiceExperience(selUser.getUserId());

Calendar curCal = CalendarFactoryUtil.getCalendar(timeZone, locale);
%>

<c:if test="<%= (userServiceExperiences != null) && !userServiceExperiences.isEmpty() %>">

	<%
	for (ServiceExperience serviceExperience : userServiceExperiences) {
		String startDate = dateFormatDate.format(serviceExperience.getStartDate());

		String endDate = null;

		if (serviceExperience.getEndDate() != null) {
			endDate = dateFormatDate.format(serviceExperience.getEndDate());
		}
		else {
			endDate = LanguageUtil.get(pageContext, "current");
		}
	%>

		<div class="field-group projects section" data-extension="true" data-sectionId="projects" data-title="<%= LanguageUtil.get(pageContext, "projects") %>">
			<h3><%= HtmlUtil.escape(serviceExperience.getTitle()) %> : 
			<%= startDate %> - <%= endDate %>
			
			</h3>

			<div class="project-date property-list">
				<span class="property"><%= startDate %> - <%= endDate %></span>
			</div>

			<div class="project-description property-list">
				<div class="property"><%=serviceExperience.getServiceData() %></div>
			</div>
		</div>

	<%
	}
	%>

</c:if>