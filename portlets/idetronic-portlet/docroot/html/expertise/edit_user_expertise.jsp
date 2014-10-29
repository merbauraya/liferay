<%@ include file="/html/expertise/init.jsp" %>

<h3>

<liferay-ui:message key="user-expertise" /></h3>&nbsp;


<%
User selUser = (User)request.getAttribute("user.selUser");
String editExpertiseURL = UserServiceUtil.getEditExpertiseURL(request,renderResponse.getNamespace(),selUser.getUserId());
List userExpertises = UserEntries_ExpertiseTagsLocalServiceUtil.getUserEntry(selUser.getUserId());
ExpertiseTag expertiseTag = null;
UserEntries_ExpertiseTags userTag = null;
String selectedTag = "";
%>
<div class="bootstrap-tagsinput">

<%
for (Object obj: userExpertises)
{
	Object[] arrayobject=(Object[])obj;
	expertiseTag = (ExpertiseTag) arrayobject[0];
	userTag = (UserEntries_ExpertiseTags) arrayobject[1];
	
	String tag = expertiseTag.getTagName();
%>

	<span class="tag label label-info"><%=tag %></span>	
	
<%	
}
%>
</div>

<aui:model-context bean="<%= selUser %>" model="<%= User.class %>" />




<div>
	<div id="usx_expertise">
	
	</div>
	<liferay-ui:icon
		cssClass="edit-exp"
		iconCssClass="icon-edit"
		label="<%= true %>"
		linkCssClass="<%=renderResponse.getNamespace()+ \"btnAddExpertise btn \"%>"
		message="edit"
		url="javascript:;"
	/>	
</div>


<liferay-ui:error-marker key="errorSection" value="userExpertise" />


<aui:script use="aui-base,aui-toggler">
	
		A.one('.<portlet:namespace />btnAddExpertise').on(
			'click',
			function(event) {
				event.preventDefault();
				Liferay.Util.selectEntity(
					{
						dialog: {
							constrain: true,
							destroyOnHide: true,
							modal: true,
							width: 600
						},
						id: '<portlet:namespace />editExpertise',
						title: '<liferay-ui:message arguments="user-expertise" key="edit-x" />',
						uri: '<%= editExpertiseURL %>'
					},
					
					function(event) {
						//var uId = event[0];
						
						<portlet:namespace />showUserExpertise(event);
						
					}
				);
			}
		);
	
	
		Liferay.provide(
        window,
        'closePopup',
        function(popupIdToClose) {
            var dialog = Liferay.Util.getWindow(popupIdToClose);
            dialog.destroy(); 
        },
        ['aui-base','aui-dialog','aui-dialog-iframe']
    );
	window.<portlet:namespace />showUserExpertise= function(event)
		{
					
			
		}
	
	</aui:script>
	
	
	<style>
		.bootstrap-tagsinput {padding:5px;}
		.bootstrap-tagsinput .tag{padding: 5px 4px;
		}
	
	</style>