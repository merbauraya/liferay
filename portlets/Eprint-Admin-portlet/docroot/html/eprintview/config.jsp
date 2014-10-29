<%@ include file="/html/eprintview/init.jsp" %>
<%
	EprintConfig eprintConfig = (EprintConfig)request.getAttribute("eprintConfig");
	String[] socialBookmarksTypesArray = StringUtil.split(portletPreferences.getValue("socialBookmarksTypes", PropsUtil.get(PropsKeys.SOCIAL_BOOKMARK_TYPES)));

%> 
<liferay-portlet:actionURL portletConfiguration="true" var="configActionUrl"/>

<liferay-ui:error key="eprintURL" message="Please enter a valid Eprint URL" />
<form action="<%=configActionUrl.toString() %>" role="form" method="post" name="<portlet:namespace />configuration">
	<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:fieldset>
		<aui:input cssClass="lfr-input-text-container" label="EprintURL" name="preferences--eprintURL--" value="<%= eprintURL %>" />
		
	
  		<aui:input name="preferences--enableFlags--" type="checkbox" value="<%= enableFlags %>" />

	<aui:input name="preferences--enableRelatedAssets--" type="checkbox" value="<%= enableRelatedAssets %>" />

	<aui:input name="preferences--enableRatings--" type="checkbox" value="<%= enableRatings %>" />
	

	<aui:fieldset>
		<aui:input name="preferences--enableSocialBookmarks--" type="checkbox" value="<%= enableSocialBookmarks %>" />

		<div class="social-boomarks-options" id="<portlet:namespace />socialBookmarksOptions">
			<aui:select label="display-style" name="preferences--socialBookmarksDisplayStyle--">
				<aui:option label="simple" selected='<%= socialBookmarksDisplayStyle.equals("simple") %>' />
				<aui:option label="vertical" selected='<%= socialBookmarksDisplayStyle.equals("vertical") %>' />
				<aui:option label="horizontal" selected='<%= socialBookmarksDisplayStyle.equals("horizontal") %>' />
			</aui:select>

			<aui:select label="display-position" name="preferences--socialBookmarksDisplayPosition--">
				<aui:option label="top" selected='<%= socialBookmarksDisplayPosition.equals("top") %>' />
				<aui:option label="bottom" selected='<%= socialBookmarksDisplayPosition.equals("bottom") %>' />
			</aui:select>

			<aui:field-wrapper label="social-bookmarks">

				<%
				for (String type : PropsUtil.getArray(PropsKeys.SOCIAL_BOOKMARK_TYPES)) {
				%>

					<aui:field-wrapper inlineLabel="right" label="<%= type %>">
						<aui:input checked="<%= ArrayUtil.contains(socialBookmarksTypesArray, type) %>" name="preferences--socialBookmarksTypes--" type="checkbox" value="<%= type %>" />
					</aui:field-wrapper>

				<%
				}
				%>

			</aui:field-wrapper>
		</div>
	</aui:fieldset>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</form>

<aui:script>
	

	Liferay.Util.toggleBoxes('<portlet:namespace />enableSocialBookmarksCheckbox','<portlet:namespace />socialBookmarksOptions');
</aui:script>
