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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page import="com.liferay.util.JS" %>
<portlet:defineObjects />

This is the <b>Test Portlet</b> portlet.
<aui:nav ariaLabel='Layout Controls' collapsible="false" cssClass='xxx' icon="pencil" id="navAddControls">

<aui:nav-item anchorCssClass="toggle-controls-link" cssClass="toggle-controls" iconCssClass='icon-eye-open' id="toggleControls" label="edit-controls" />
</aui:nav>
