<%@ include file="/html/init.jsp" %>
<liferay-portlet:actionURL portletConfiguration="true" var="configActionUrl"/>

<%
	String imageFileName = StringPool.BLANK;
	TazkirahConfig tazkirahConfig =(TazkirahConfig) request.getAttribute("config");
	imageFileName = String.valueOf(tazkirahConfig.getBackgroundImageId());
	PortletPreferences preferences = renderRequest.getPreferences();
	String portletResource = ParamUtil.getString(renderRequest, (String)("portletResource"));
	preferences = PortletPreferencesFactoryUtil.getPortletSetup((PortletRequest)(renderRequest), (String)(portletResource));
	String showTitle = tazkirahConfig.getShowTitle();// preferences.getValue("showTitle", "false");
	boolean chkShowTitle = (showTitle.equals("true") ? true:false);
	String selectedCategory = tazkirahConfig.getSelectedCategory();
	out.print(selectedCategory);
	
	
	//String[] allCategory = (String[]) categoryList.toArray(new String[0]);
	List leftList = new ArrayList();
	
	
	
	for (String cat : displayCategories) {
		leftList.add(new KeyValuePair(cat, LanguageUtil.get(pageContext, cat)));
	}
	
	List rightList = new ArrayList(); 
	
	Arrays.sort(displayCategories);
	for (String category : categoryList)
	{
		if (Arrays.binarySearch(displayCategories, category) < 0) {
			rightList.add(new KeyValuePair(category, LanguageUtil.get(pageContext, category)));
		}
	}
	
	
	

%>

<%
	LiferayPortletURL documentLibURL = PortletURLFactoryUtil.create(request,         
        "tazkirah_WAR_IdetronicAppsportlet", themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
        documentLibURL.setWindowState(LiferayWindowState.NORMAL);
        documentLibURL.setPortletMode(PortletMode.VIEW);
        documentLibURL.setParameter("jspPage","/html/tazkirah/view/select_file.jsp");
        documentLibURL.setParameter("groupId", String.valueOf(themeDisplay.getSiteGroupId()));

%>

 <liferay-portlet:renderURL 
             portletName="<%=portletResource %>"
             windowState="<%=LiferayWindowState.POP_UP.toString() %>" 
              var="selectDLURL"> 
               <portlet:param name="jspPage"
                  value="/html/tazkirah/view/select_file.jsp" />
              <portlet:param name="nameSpace" value="<%=renderResponse.getNamespace() %>"/>
              <portlet:param name="currentURL" value="<%= currentURL%>" />
               <portlet:param name="groupId"
                  value="<%= String.valueOf(themeDisplay.getSiteGroupId()) %>" />
          </liferay-portlet:renderURL>
<%

String dlSelectURL = "javascript:Liferay.Tazkirah.displayPopup('" + selectDLURL + "','" + LanguageUtil.get(pageContext, "repost") + "');";

%>          

<aui:form name="fm" method="POST" action="<%=configActionUrl.toString() %>" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "submitTazkirah();" %>'>
	<aui:fieldset>
		<aui:input type="hidden" name="toList"/>
		<aui:input type="hidden" name="bgImageId" value="<%=imageFileName %>"/>
		<aui:input type="checkbox" name="showTitle" label="Show Title" 
			checked="<%=chkShowTitle %>"
		/>
		
		<aui:field-wrapper label="display-category">
		 
			<liferay-ui:input-move-boxes
					leftBoxName="selectedCat"
					leftList="<%= leftList %>"
					leftReorder="true"
					leftTitle="Current Category"
					rightBoxName="availableCat"
					rightList="<%= rightList %>"
					rightTitle="Available Category"
				/>
   
		</aui:field-wrapper>
		<liferay-ui:panel collapsible="true" title="background-image">
			<aui:fieldset>
				<aui:field-wrapper label="selected-image">
					<div class="input-append">
					<liferay-ui:input-resource id="imageFileName" url="<%= imageFileName %>" />
					<aui:button name="selectImageButton" value="select" />
					</div>
				</aui:field-wrapper>
			</aui:fieldset>
		</liferay-ui:panel>
		 
		<aui:button type="submit" value="Save" />
		
		
	</aui:fieldset>
	
</aui:form>
<aui:script>
  Liferay.provide(
       window,
        '<portlet:namespace />submitTazkirah',
        function() {
        document.<portlet:namespace />fm.<portlet:namespace/>toList.value = Liferay.Util.listSelect(document.<portlet:namespace />fm.<portlet:namespace/>selectedCat);
        document.<portlet:namespace />fm.submit();
        }, ['liferay-util-list-fields']
       );
 </aui:script>
 
 <aui:script use="aui-base,aui-io-deprecated">
 	AUI().ready(
		function() {
			Liferay.Tazkirah.init(
				{
					popupURL: '<%= selectDLURL %>'
				}
			);
		}
	);
 
 </aui:script>
<aui:script use="aui-base">
				A.one('#<portlet:namespace />selectImageButton').on(
					'click',
					function(event) {
						Liferay.Util.selectEntity(
							{
								dialog: {
									constrain: true,
									modal: true,
									width: 600
								},
								id: '<portlet:namespace />selectFile',
								title: '<liferay-ui:message arguments="image" key="select-x" />',
								uri: '<%= selectDLURL.toString() %>'
							},
							function(event) {
								
								document.getElementById("<portlet:namespace />imageFileName").value = event[1];
								document.getElementById("<portlet:namespace />bgImageId").value = event[0];
								
								var folderData = {
									idString: 'fileId',
									idValue: event.folderid,
									nameString: 'imageFileName',
									nameValue: event.foldername
								};

								//Liferay.Util.selectFile(folderData, '<portlet:namespace />');
							}
						);
					}
				);
			</aui:script>
			
			