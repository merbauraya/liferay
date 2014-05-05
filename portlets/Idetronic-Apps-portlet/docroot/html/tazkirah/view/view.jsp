<%@ include file="/html/init.jsp" %>
 <liferay-portlet:renderURL 
               
              var="selectDLURL">
               <liferay-portlet:param name="jspPage"
                  value="/html/tazkirah/view/select_file.jsp" />
              <liferay-portlet:param name="currentURL" value="<%= currentURL%>" />
               <liferay-portlet:param name="groupId"
                  value="<%= String.valueOf(themeDisplay.getSiteGroupId()) %>" />
          </liferay-portlet:renderURL>
          <a href="<%= selectDLURL %>">Select</a>
<%
	String category = null;
	PortletPreferences preferences = renderRequest.getPreferences();
	String portletResource = ParamUtil.getString(renderRequest, (String)("portletResource"));
	if (Validator.isNotNull("portletResource"))
		preferences = PortletPreferencesFactoryUtil.getPortletSetup((PortletRequest)(renderRequest), (String)(portletResource));
	String showTitle = (String)preferences.getValue("showTitle", "false");
	category = (String)preferences.getValue("category", null);

	Tazkirah tazkirah = TazkirahUtil.getRandom(themeDisplay.getCompanyId(), 
			themeDisplay.getScopeGroupId(), category);
	/*
	String content = tazkirah.getContent();
	out.print(content);*/
	if (Validator.isNull(tazkirah))
	{
%>
	<div class="alert alert-info">
		No content to display
	</div>
<%		
	}else
	{
		String content = tazkirah.getContent();
		out.print(showTitle+ category);
		if (showTitle.equals("true"))
			out.print("<h4>"+ tazkirah.getTitle()+ "</h4>");
		out.print(content);
	}
%>


