<%@ include file="/html/init.jsp" %>
 <liferay-portlet:renderURL 
               
              var="selectDLURL">
               <liferay-portlet:param name="jspPage"
                  value="/html/tazkirah/view/select_file.jsp" />
              <liferay-portlet:param name="currentURL" value="<%= currentURL%>" />
               <liferay-portlet:param name="groupId"
                  value="<%= String.valueOf(themeDisplay.getSiteGroupId()) %>" />
          </liferay-portlet:renderURL>
          
<%
	String category = null;
	String content = null;
	TazkirahConfig tazkirahConfig = (TazkirahConfig)request.getAttribute("tazkirahConfig");
	String showTitle = tazkirahConfig.getShowTitle();
	category = tazkirahConfig.getSelectedCategory();
	
	Tazkirah tazkirah = TazkirahUtil.getRandom(themeDisplay.getCompanyId(), 
			themeDisplay.getScopeGroupId(), category);
	long backgroundImageId = tazkirahConfig.getBackgroundImageId(); 
	String bgImageURL = null;
	if (Validator.isNotNull(backgroundImageId))
	{
		FileEntry bgImage = DLAppServiceUtil.getFileEntry(backgroundImageId); 
		//bgImageURL = DLUtil.getThumbnailSrc(bgImage, bgImage.getFileVersion(), null, themeDisplay); 
		bgImageURL = DLUtil.getImagePreviewURL(bgImage, bgImage.getFileVersion(), themeDisplay);
	}
	
%>
<div class="tazkirah-container">
	<c:choose>
		<c:when test="<%=Validator.isNull(tazkirah) %>">
			<div class="alert alert-info">
				No content to display
			</div>
		
		</c:when>
		<c:otherwise>
			
			<c:if test="<%=showTitle.equals(\"true\") %>">
				<h4><%=tazkirah.getTitle() %></h4>
			</c:if>
			<%=tazkirah.getContent() %>
		</c:otherwise>
	</c:choose>	
	
	
	<c:choose>
		<c:when test="<%=Validator.isNotNull(bgImageURL) %>">
			<img src="<%=bgImageURL %>" class="tazkirah-bg">
		</c:when>
		<c:otherwise>
		
		</c:otherwise>
	
	</c:choose>
</div>
