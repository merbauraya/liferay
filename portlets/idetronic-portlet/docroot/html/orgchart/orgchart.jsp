<%@ include file="/html/orgchart/init.jsp" %>
<h3>Organisation Chart</h3>

<%
User selUser = (User)request.getAttribute("user.selUser");
String editOrgchartURL = UserServiceUtil.getEditOrgChartURL(request,renderResponse.getNamespace(),selUser.getUserId());


%>

<liferay-ui:icon
		cssClass="edit-exp"
		iconCssClass="icon-edit"
		label="<%= true %>"
		linkCssClass="<%=renderResponse.getNamespace()+ \"btnOrgchart btn \"%>"
		message="edit"
		url="javascript:;"
	/>	
	
	

<aui:script use="aui-base,aui-toggler">
	
		A.one('.<portlet:namespace />btnOrgchart').on(
			'click',
			function(event) {
				event.preventDefault();
				Liferay.Util.selectEntity(
					{
						dialog: {
							constrain: true,
							destroyOnHide: true,
							modal: true,
							width: 900
						},
						id: '<portlet:namespace />editOrgChart',
						title: '<liferay-ui:message arguments="user-org-chart" key="edit-x" />',
						uri: '<%= editOrgchartURL %>'
					},
					
					function(event) {
						var uId = event[0];
						var startDate = event[2];
						var endDate = event[3];
						<portlet:namespace />showOrgChart(event);
						
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
	window.<portlet:namespace />showOrgChart= function(event)
		{
			
			
		}
	
	</aui:script>	