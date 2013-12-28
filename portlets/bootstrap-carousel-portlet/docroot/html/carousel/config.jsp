<%--
/**
 *  Copyright (c) 2011 Xtivia, Inc. All rights reserved.
 *
 *  This file is part of an Xtivia Portal application.
 *
 *  This library is free software; you can redistribute it and/or modify it under
 *  the terms of the GNU Lesser General Public License as published by the Free
 *  Software Foundation; either version 2.1 of the License, or (at your option)
 *  any later version.
 *
 *  This library is distributed in the hope that it will be useful, but WITHOUT
 *  ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 *  FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 *  details.
 */
--%>

<%@ include file="init.jsp" %>
<portlet:actionURL name="saveConfiguration" var="saveConfigurationUrl">
	<portlet:param name="action" value="saveConfiguration" />
</portlet:actionURL>


<div class="saveMessage">
	<c:if test="${SUCCESS_SAVED_PREFERENCES == true}">
		<span class="portlet-msg-success"><liferay-ui:message key="create.config.preferences.success" /></span>
	</c:if>
</div>

<div class="errorMessage">
	<c:if test="${ERROR_PORTLET_PREFERENCES==true}">
		<span class="portlet-msg-error"><liferay-ui:message key="error.portlet.preferences" />
		</span>
	</c:if>
</div>

<div class="pageTitle" >
	<liferay-ui:message key="configuration-details" />
</div>

<div class="configHelp">
	<a href="#" onClick="javascript:onConfigHelp();">
		<liferay-ui:icon image="help"/>
		<liferay-ui:message key="config.help.text.title" />
	</a>
</div>



<form action="${saveConfigurationUrl}" method="post" name="<portlet:namespace />configuration">
	<table border="0" style="text-align: center;" class="carouselTable">
		
		<tr>
			<td style="text-align: right;">
				<div class="portlet-form-field-label">
					<liferay-ui:message key="background.color" />
				</div>
			</td>
			<td style="text-align: left;">
				<input class="portlet-form-input-field" size="30" name="backgroundColor" value="<c:out value="${carousel.backgroundColor }" />" />
				<liferay-ui:icon image="help" url="javascript:onBackgroundColorHelp();"/>
			</td>
			<td>
				<liferay-ui:error key="background.color.error" message="background.color.error"/>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;">
				<div class="portlet-form-field-label">
					<liferay-ui:message key="width" />
				</div></td>
			<td style="text-align: left;">
				<input class="portlet-form-input-field" size="30" name="width" value="<c:out value="${carousel.width}" />" />
				<label class="portlet-form-field-label"><liferay-ui:message key="pixels" /></label>
			</td>
			<td>
				<liferay-ui:error key="width.errors.number" message="width.errors.number"/>
				<liferay-ui:error key="width.errors.lesser.than.zero" message="width.errors.lesser.than.zero"/>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;">
				<div class="portlet-form-field-label">
					<liferay-ui:message key="height" />
				</div></td>
			<td style="text-align: left;">
				<input class="portlet-form-input-field" size="30" name="height" value="<c:out value="${carousel.height}" />"/>
				<label class="portlet-form-field-label"><liferay-ui:message key="pixels" /></label>
			</td>
			<td>
				<liferay-ui:error key="height.errors.number" message="height.errors.number"/>
				<liferay-ui:error key="height.errors.lesser.than.zero" message="height.errors.lesser.than.zero"/>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;">
				<div class="portlet-form-field-label">
					<liferay-ui:message key="pauseInterval" />					
				</div>
			</td>
			<td style="text-align: left;">
				<input class="portlet-form-input-field" size="30" name="pauseInterval" value="<c:out value="${carousel.pauseInterval}" />" />
				<label class="portlet-form-field-label"><liferay-ui:message key="seconds" /></label>
			</td>
			<td>
				<liferay-ui:error key="pause.errors.number" message="pause.errors.number"/>
				<liferay-ui:error key="pause.errors.lesser.than.zero" message="pause.errors.lesser.than.zero"/>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;">
				<div class="portlet-form-field-label">
					<liferay-ui:message key="tagNames" />
				</div>
			</td>
			<td style="text-align: left;">
				<liferay-ui:asset-tags-selector curTags='${carousel.allTagName}'  />
			</td>
			<td>
				<liferay-ui:error key="tag.error" message="tag.error"/>
			</td>
		</tr>
		
		<tr>
			<td style="text-align: right;">
				<div class="portlet-form-field-label">
					<liferay-ui:message key="cssStyle.help.text.title" />
				</div>
			</td>
			<td style="text-align: left;">
				<textarea class="portlet-form-input-field" rows="15" cols="27" name="cssStyle"><c:out value="${carousel.cssStyle}" /></textarea>
			    <liferay-ui:icon image="help" url="javascript:onCSSHelp();"/>
			</td>
		</tr>

	</table>

	<div class="saveButton">
		<input type="button" value="Save" onClick="submitForm(document.<portlet:namespace />configuration);" />
	</div>
</form>

<script type="text/javascript" charset="utf-8">
    function onCSSHelp(){	
     	AUI().use('aui-dialog', 'aui-io', 'event', 'event-custom', function(A) {
    		   
    	    var dialog = new A.Dialog({
    	            title: '<liferay-ui:message key="cssStyle.help.text.title" />',
    	            centered: true,
    	            draggable: true,
    	            modal: true,
    	            height: 400,
	 				width: 650,
	 		   }).plug(A.Plugin.IO, {uri: '/carousel-portlet/html/carousel/cssStyleHelp.jsp'}).render();
	           dialog.show();     
    	  });
	}
    function onConfigHelp(){	
     	AUI().use('aui-dialog', 'aui-io', 'event', 'event-custom', function(A) {
    		   
    	    var dialog = new A.Dialog({
    	            title: '<liferay-ui:message key="config.help.text.title" />',
    	            centered: true,
    	            draggable: true,
    	            modal: true,
    	            height: 600,
	 				width: 840,
	 		   }).plug(A.Plugin.IO, {uri: '/carousel-portlet/html/carousel/setupHelp.jsp'}).render();
	           dialog.show();     
    	  });
	} 
    function onBackgroundColorHelp(){	
     	AUI().use('aui-dialog', 'aui-io', 'event', 'event-custom', function(A) {
    		   
    	    var dialog = new A.Dialog({
    	            title: '<liferay-ui:message key="background.color.help" />',
    	            centered: true,
    	            draggable: true,
    	            modal: true,
    	            height: 300,
	 				width: 450,
	 		   }).plug(A.Plugin.IO, {uri: '/carousel-portlet/html/carousel/backgroundColorHelp.jsp'}).render();
	           dialog.show();     
    	  });
	} 
</script>
