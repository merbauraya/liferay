<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This file is part of Liferay Social Office. Liferay Social Office is free
 * software: you can redistribute it and/or modify it under the terms of the GNU
 * Affero General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * Liferay Social Office is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Liferay Social Office. If not, see http://www.gnu.org/licenses/agpl-3.0.html.
 */
--%>

<%@ include file="/html/init.jsp" %>

<%
User user2 = (User)request.getAttribute("view_user.jsp-user");

boolean showCompleteYourProfile = GetterUtil.getBoolean((String)request.getAttribute("view_user.jsp-showCompleteYourProfile"), false);

List<ServiceExperience> serviceExperiences = null;
String selectedTag = "";
List userExpertises = null;
ExpertiseTag expertiseTag = null;
UserEntries_ExpertiseTags userTag = null;

if (user2 != null) {
	serviceExperiences = ServiceExperienceLocalServiceUtil.getUserServiceExperience(user2.getUserId());
	userExpertises = UserEntries_ExpertiseTagsLocalServiceUtil.getUserEntry(user2.getUserId());
	

}
%>

<c:if test="<%= (serviceExperiences != null) && !serviceExperiences.isEmpty() %>">

	<%
	for (ServiceExperience serviceExperience : serviceExperiences) {
		String startDate = dateFormatDate.format(serviceExperience.getStartDate());

		String endDate = null;

		if (serviceExperience.getEndDate() != null) {
			endDate = dateFormatDate.format(serviceExperience.getEndDate());
		}
		else {
			endDate = LanguageUtil.get(pageContext, "current");
		}
	%>

		<div class="field-group service section" data-extension="true" data-sectionId="projects" data-title="<%= LanguageUtil.get(pageContext, "projects") %>">
			<h3><%= HtmlUtil.escape(serviceExperience.getTitle()) %>:</h3>

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

<c:if test="<%= showCompleteYourProfile && (themeDisplay.getUserId() == user2.getUserId()) && serviceExperiences.isEmpty() %>">
	<div class="profile-actions">
		<p class="portlet-msg alert alert-info"><liferay-ui:message key="add-service-experience" />:</p>

		<div class="field-actions-toolbar">
			<ul class="settings-actions">
				<li class="action-field component lfr-token settings-field" data-extension="true" data-sectionId="service_experience" data-title="<%= LanguageUtil.get(pageContext, "service-experience") %>">
					<div class="settings-field-content">
						<i class="icon-plus-sign"></i>

						<span class="settings-label"><liferay-ui:message key="add" /></span>
					</div>
				</li>
			</ul>
		</div>
	</div>
</c:if>
<div class="user-information-title">Expertise</div>
<div class="service section">
	<div class="property-list">
	
	
		<%
			
			for (Object obj: userExpertises)
			{
				StringBuilder sb = new StringBuilder();	
				Object[] arrayobject=(Object[])obj;
				expertiseTag = (ExpertiseTag) arrayobject[0];
				userTag = (UserEntries_ExpertiseTags) arrayobject[1];
				
				String tag = expertiseTag.getTagName();
				PortletURL searchURL = ((LiferayPortletResponse)renderResponse).createRenderURL("3");

				searchURL.setWindowState(WindowState.MAXIMIZED);
				
				String tagInfo = "<span class='tag label label-info'>"+tag+"</span>";
				searchURL.setParameter("groupId", "0");
				searchURL.setParameter("keywords", tag);
				searchURL.setParameter("struts_action", "/search/search");
				sb.append("<a href=\"");
				sb.append(searchURL);
				sb.append("\">");
				sb.append(tagInfo);
				sb.append("</a>");
				
			%>
			
				<%= sb.toString() %>
				
			<%	
			}
		%>
	
		
	</div>
</div>
<c:if test="<%= showCompleteYourProfile && (themeDisplay.getUserId() == user2.getUserId()) && userExpertises.isEmpty() %>">
	<div class="profile-actions">
		<p class="portlet-msg alert alert-info"><liferay-ui:message key="add-expertise" />:</p>

		<div class="field-actions-toolbar">
			<ul class="settings-actions">
				<li class="action-field component lfr-token settings-field" data-extension="true" data-sectionId="user_expertise" data-title="<%= LanguageUtil.get(pageContext, "service-experience") %>">
					<div class="settings-field-content">
						<i class="icon-plus-sign"></i>

						<span class="settings-label"><liferay-ui:message key="add" /></span>
					</div>
				</li>
			</ul>
		</div>
	</div>
</c:if>
<style>
	.user-information-title{margin-bottom:10px !important;}
	.section {margin-bottom:10px;}
	.section .tag {padding:5px 4px;}
</style>