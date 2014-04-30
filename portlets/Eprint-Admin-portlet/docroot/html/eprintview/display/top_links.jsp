<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/eprint/init.jsp" %>
<%
	Eprint entry  = (Eprint)request.getAttribute("eprint");
%>
<c:if test="<%= canEdit %>">
	<div class="lfr-meta-actions edit-actions entry">
		<table class="lfr-table">
		<tr>
			<c:if test="<%= canEdit %>">
				<td>
					<portlet:renderURL var="editEntryURL">
						<portlet:param name="jspPage" value="<%=EprintConstant.EDIT_EPRINT_PAGE %>" />
						<portlet:param name="eprintId" value="<%= String.valueOf(entry.getEprintId()) %>" />
					</portlet:renderURL>
				
					

					<liferay-ui:icon
						image="edit"
						label="<%= true %>"
						url="<%= editEntryURL %>"
					/>
				</td>
			</c:if>

			

			<c:if test="<%= canEdit %>">
				<td>
					<portlet:renderURL var="viewURL">
						<portlet:param name="struts_action" value="/blogs/view" />
					</portlet:renderURL>

					<portlet:actionURL var="deleteEntryURL">
						<portlet:param name="struts_action" value="/blogs/edit_entry" />
						<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
						<portlet:param name="redirect" value="<%= viewURL %>" />
						<portlet:param name="entryId" value="<%= String.valueOf(entry.getEprintId()) %>" />
					</portlet:actionURL>

					<liferay-ui:icon-delete
						label="<%= true %>"
						url="<%= deleteEntryURL %>"
					/>
				</td>
			</c:if>
			<td>
			Filter By Type:
				<portlet:renderURL var="viewByType">
						<portlet:param name="type" value="<%=entry.getEprintType() %>" />
				</portlet:renderURL>
				<a href="<%=viewByType %>"><%=entry.getEprintType() %></a>
				
			</td>
		</tr>
		</table>
	</div>
</c:if>