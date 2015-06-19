<%
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
%>

<%@ include file="/html/init.jsp" %>

<liferay-portlet:renderURL varImpl="searchURL">
        <portlet:param name="mvcPath" value="/html/search/view_search.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL varImpl="depositURL">
        <portlet:param name="mvcPath" value="/html/deposit/new.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL varImpl="draftDepositURL">
        <portlet:param name="mvcPath" value="/html/deposit/draft_list.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL varImpl="bySubjectURL">
        <portlet:param name="mvcPath" value="/html/by_subject.jsp" />
</liferay-portlet:renderURL>


<liferay-portlet:renderURL varImpl="uploadFileURL">
        <portlet:param name="mvcPath" value="/html/fileupload/upload.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="adminAuthor">
        <portlet:param name="mvcPath" value="/html/admin/author/view.jsp" />
</liferay-portlet:renderURL>
<%
	String itemId = renderRequest.getParameter("itemId");

%>

<a class="btn btn-primary" href="<%= depositURL %>">New Deposit</a>&nbsp; 

<a class="btn btn-primary" href="<%=draftDepositURL %>">Draft Deposit</a>
<a class="btn btn-primary" href="<%=bySubjectURL %>">Browse By Subject</a>
<a class="btn btn-primary" href="<%=uploadFileURL %>">Upload File</a>
<a class="btn btn-primary" href="<%=adminAuthor %>">Author Admin</a>
<aui:form action="<%= searchURL %>" method="get" name="fm">
    <liferay-portlet:renderURLParams varImpl="searchURL" />

    <div class="search-form">
        <span class="aui-search-bar">
            <aui:input inlineField="<%= true %>" label="" name="keywords" size="30" title="search-entries" type="text" />

            <aui:button type="submit" value="search" />
        </span>
    </div>
</aui:form>
