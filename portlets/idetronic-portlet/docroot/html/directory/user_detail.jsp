<%@ include file="/html/directory/init.jsp" %>
<%
	User selUser = PortalUtil.getSelectedUser(request);
	String imageId = selUser.getUserId() + "-picture";
	

%>
<div class="usx-detail-container">
	<div class="usx-photo">
		<img src="<%=selUser.getPortraitURL(themeDisplay)%>" id="<%=imageId %>" alt="<%= HtmlUtil.escapeAttribute(selUser.getFullName()) %>" />
		
	</div>
	<div class="usx-contact-info">
		<h2><%=selUser.getFullName() %></h2>
		<p><strong>Job Title : </strong>
		<%=selUser.getJobTitle() %>	
		</p>
		<p><strong>About : </strong>
		<%=selUser.getComments() %>	
		</p>
		<p><strong>Email : </strong>
		<%=selUser.getEmailAddress() %>	
		</p>
	</div>
	<div class="usx-user-info">
		<div class="layout">
			<div class="layout-content">
				<div class="column w100">
					<div class="usx-info-title">About</div>
					<div class="usx-info-container">xxxx</div>
					<div class="usx-info-title">User Expertise</div>
					<div class="usx-info-container">
						<%@ include file="/html/directory/user_expertise.jsp" %>
					</div>
				
					<div class="usx-info-title">Service Experience</div>
					<div class="usx-info-container">
						<%@ include file="/html/directory/service_experience.jsp" %>
					</div>
				
				</div>
			</div>
		</div>
	</div>
</div>

	
    	
	