<%@ include file="/html/tabview/init.jsp" %>
<liferay-portlet:actionURL portletConfiguration="true" var="configActionUrl"/>
<%
	int view_Type=0; 
	
	//boolean showTitle = viewConfig.getShowInternalTitle();// preferences.getValue("showTitle", "false");
	
	String redirect = ParamUtil.getString(request, "redirect");

	String organizationName = StringPool.BLANK;

	Organization organization = null; 

	if (organizationId > 0) {
		organization = OrganizationLocalServiceUtil.getOrganization(organizationId);

		organizationName = organization.getName();
	}
	
%>
<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="organizationId" type="hidden" value="<%= organizationId %>" />

	<aui:fieldset>
		
		<div id="<portlet:namespace />usersSelectionOptions">
			<aui:field-wrapper label="organization">
				<div class="input-append">
					<liferay-ui:input-resource id="organizationName" url="<%= HtmlUtil.escape(organizationName) %>" />

					<aui:button name="selectOrganizationButton" value="select" />

					<aui:button disabled="<%= organizationId <= 0 %>" name="removeOrganizationButton" onClick='<%= renderResponse.getNamespace() + "removeOrganization();" %>' value="remove" />
				</div>
			</aui:field-wrapper>
		</div>

	
		<aui:select label="maximum-items-to-display" name="max">
			<aui:option label="5" selected="<%= max == 5 %>" />
			<aui:option label="6" selected="<%= max == 6 %>" />
			<aui:option label="7" selected="<%= max == 7 %>" />
			<aui:option label="8" selected="<%= max == 8 %>" />
			<aui:option label="9" selected="<%= max == 9 %>" />
			<aui:option label="10" selected="<%= max == 10 %>" />
			
		</aui:select>

		

		
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

<aui:script>
	function <portlet:namespace />removeOrganization() {
		document.<portlet:namespace />fm.<portlet:namespace />organizationId.value = "";

		document.getElementById('<portlet:namespace />organizationName').value = "";

		Liferay.Util.toggleDisabled('#<portlet:namespace />removeOrganizationButton', true);
	}
</aui:script>

<aui:script use="aui-base">
	A.one('#<portlet:namespace />selectOrganizationButton').on(
		'click',
		function(event) {
			Liferay.Util.selectEntity(
				{
					dialog: {
						constrain: true,
						modal: true
					},
					id: '<portlet:namespace />selectOrganization',
					title: '<liferay-ui:message arguments="organization" key="select-x" />',
					uri: '<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="struts_action" value="/portlet_configuration/select_organization" /><portlet:param name="tabs1" value="organizations" /></portlet:renderURL>'
				},
				function(event) {
					document.<portlet:namespace />fm.<portlet:namespace />organizationId.value = event.organizationid;

					document.getElementById('<portlet:namespace />organizationName').value = event.name;

					Liferay.Util.toggleDisabled('#<portlet:namespace />removeOrganizationButton', false);
				}
			);
		}
	);

	
</aui:script>


