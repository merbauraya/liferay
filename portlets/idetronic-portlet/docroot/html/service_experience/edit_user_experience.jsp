<%@ include file="/html/service_experience/init.jsp"%>

<%@ page import="com.idetronic.portlet.util.UserServiceUtil"%>
<portlet:renderURL var="xx"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="jspPage"
		value="/html/service_experience/edit_exp.jsp" />

	<portlet:param name="p_u_i_d"
		value="<%=String.valueOf(user.getUserId())%>" />

</portlet:renderURL>

<portlet:actionURL var="actionURL">
	<portlet:param name="<%=ActionRequest.ACTION_NAME%>"
		value="addServiceExperience" />
	<portlet:param name="p_u_i_d"
		value="<%=String.valueOf(user.getUserId())%>" />
</portlet:actionURL>
<portlet:resourceURL var="reURL"></portlet:resourceURL>

<%
	User selUser = PortalUtil.getSelectedUser(request);

	if (selUser == null) {
		selUser = user;
	}

	List<ServiceExperience> userServiceExperiences = ServiceExperienceLocalServiceUtil
			.getUserServiceExperience(selUser.getUserId());

	Calendar curCal = CalendarFactoryUtil.getCalendar(timeZone, locale);

	int[] monthIds = CalendarUtil.getMonthIds();
	String[] months = CalendarUtil.getMonths(locale);

	int yearRangeStart = curCal.get(Calendar.YEAR) - 70;
	int yearRangeEnd = curCal.get(Calendar.YEAR);

	int[] userServiceExperiencesIndexes = new int[userServiceExperiences
			.size()];

	for (int i = 0; i < userServiceExperiences.size(); i++) {
		userServiceExperiencesIndexes[i] = i;
	}

	String namespace = PortalUtil
			.getPortletNamespace(PortletKeys.MY_ACCOUNT);

	String editExperienceURL = UserServiceUtil
			.getEditServiceExperienceURL(request,
					renderResponse.getNamespace(), selUser.getUserId());
	String addExperienceURL = UserServiceUtil
			.getAddServiceExperienceURL(request,
					renderResponse.getNamespace(), selUser.getUserId());
	String deleteExperienceURL = UserServiceUtil
			.getDeleteServiceExperienceURL(request,
					renderResponse.getNamespace(), selUser.getUserId());
	String portletId = UserServiceUtil.getServiceExperiencePortletId();
%>
<liferay-ui:error-marker key="errorSection" value="serviceExperience" />


<h3>

	<liferay-ui:message key="serviceExperience" />
</h3>
&nbsp;

<liferay-ui:icon cssClass="edit-exp" iconCssClass="icon-edit"
	label="<%=true%>"
	linkCssClass="<%=renderResponse.getNamespace() +\"btnAddExp btn\"%>"
	message="add" url="javascript:;" />

<div class="user-exp-container" id="user-exp-container">

	<%
		for (int i = 0; i < userServiceExperiencesIndexes.length; i++) {
			int serviceExperienceIndex = userServiceExperiencesIndexes[i];

			ServiceExperience serviceExperience = userServiceExperiences
					.get(i);

			Calendar startDate = CalendarFactoryUtil.getCalendar();
			Calendar endDate = CalendarFactoryUtil.getCalendar();

			boolean current = true;

			if (serviceExperience.getStartDate() != null) {
				startDate.setTime(serviceExperience.getStartDate());
			}

			if (serviceExperience.getEndDate() != null) {
				endDate.setTime(serviceExperience.getEndDate());

				current = false;
			}
			String divId = renderResponse.getNamespace() + "idx" + i;
	%>


	<div class="user-exp-entry" id="<%=divId%>" dataIndex="<%=i%>"
		serviceId="<%=serviceExperience.getServiceExperienceId()%>">
		<div class="user-exp-entry-hdr toggler-header toggler-header-expanded">
			<span class="user-exp-item-header-icon">&nbsp;&nbsp;</span> <span
				class="exp-entry-dt"> 
<%
 	String startMonth = new SimpleDateFormat("MMM")
 				.format(startDate.getTime());
 		String startYear = new SimpleDateFormat("yyyy")
 				.format(startDate.getTime());
 		out.print(startMonth + " " + startYear + " - ");
 		if (!current) {
 			String endMonth = new SimpleDateFormat("MMM")
 					.format(endDate.getTime());
 			String endYear = new SimpleDateFormat("yyyy")
 					.format(endDate.getTime());
 			out.print(endMonth + " " + endYear);

 		} else {
 			out.print("Current");
 		}
 %>
			</span> : <span class="exp-entry-title"> <%=serviceExperience.getTitle()%>
			</span>

			<div class="exp-hdr-action">
				<span class="delete-exp">
					<button
						class="<portlet:namespace />deleteExp btn-small btn-warning" id="">
						<i class="icon-remove"></i> <span class="taglib-text ">Delete</span>
					</button>
				</span> <span class="edit-exp">
					<button
						class="<portlet:namespace />editExp btn btn-small btn-primary">
						<i class="icon-edit"></i> <span class="taglib-text ">Edit</span>
					</button>
				</span>
			</div>
		</div>
		<div
			class="user-exp-entry-data toggler-content toggler-content-expanded">
			<%=serviceExperience.getServiceData()%>
		</div>

	</div>

	<%
		}
	%>
</div>
<aui:input id="serviceExperienceIndexes" name="serviceExperienceIndexes"
	type="hidden"
	value="<%=StringUtil.merge(userServiceExperiencesIndexes)%>" />

<div id="exp-display-template" style="display: none">
	<div class="user-exp-entry toggler-header toggler-header-expanded"
		serviceId="SERVICE_ID" id="<portlet:namespace />idx_ID_"
		dataIndex="_INDEX_">
		<div class="user-exp-entry-hdr toggler-header toggler-header-expanded">
			<span class="user-exp-item-header-icon">&nbsp;&nbsp;</span> <span
				class="exp-entry-dt">EXP_PERIOD</span> : <span
				class="exp-entry-title">_TITLE_</span>
			<div class="exp-hdr-action">
				<span class="delete-exp">
					<button
						class="<portlet:namespace />deleteExp btn btn-small btn-warning"
						id="">
						<i class="icon-remove"></i> <span class="taglib-text ">Delete</span>
					</button>
				</span> <span class="edit-exp">
					<button
						class="<portlet:namespace />editExp btn btn-small btn-primary"
						id="">
						<i class="icon-edit"></i> <span class="taglib-text ">Edit</span>
					</button>
				</span>


			</div>
		</div>

		<div class="user-exp-entry-data">_DATA_</div>

	</div>

</div>



<aui:script use="aui-base,escape">
	
	
		var totIndex = <%=userServiceExperiences.size()%>;
		function <portlet:namespace />updateData(idx,data,title,startMonth,startYear,endMonth,endYear,current) {
			A.one('#<portlet:namespace />title_'+idx).set("value",title);
			A.one('#<portlet:namespace />title_'+idx).set("value",title);
		
		}
		
		window.<portlet:namespace />addServiceExperience= function(serviceId,data,title,startDate,endDate)
		{
			var templateNode = A.one('#exp-display-template');
			var curIdxElem = A.one('#<portlet:namespace />serviceExperienceIndexes');//.get("value");
			if (curIdxElem === null)
				return; //called from contact portlet
			curIdx = curIdxElem.get("value");
			var displayExp = templateNode.get("innerHTML");
			var sPeriod = <portlet:namespace />buildPeriodDisplay(startDate,endDate);
			displayExp = <portlet:namespace />replaceAll("EXP_PERIOD",sPeriod,displayExp);
			
			displayExp = <portlet:namespace />replaceAll("SERVICE_ID",serviceId,displayExp);
			displayExp = <portlet:namespace />replaceAll("_ID_",totIndex,displayExp);//displayExp.replace("_ID_",totIndex);
			displayExp = <portlet:namespace />replaceAll("_INDEX_",totIndex,displayExp);
			displayExp = <portlet:namespace />replaceAll("_TITLE_",title,displayExp);
			displayExp = <portlet:namespace />replaceAll("_DATA_",data,displayExp);
			
			
			var parentCont = A.one("#user-exp-container");
			parentCont.append(displayExp);
			var dataEl = A.one('#data'+totIndex);
			
			if (dataEl)
				dataEl.set("value",data);
			
			if (curIdx.length > 0)
				curIdx += ","+ totIndex;
			else
				curIdx = "0";
			A.one('#<portlet:namespace />serviceExperienceIndexes').set("value",curIdx);
			
			
			totIndex++;	
			
		}
		
		function <portlet:namespace />replaceAll(find, replace, str) 
		{
  			return str.replace(new RegExp(find, 'g'), replace);
		}
		window.<portlet:namespace />updServiceExperience= function(idx,data,title,startDate,endDate)
		{
			
			var current = (endDate[2] == "on");
			var sPeriod = <portlet:namespace />buildPeriodDisplay(startDate,endDate);
			var pDiv = A.one('#<portlet:namespace />idx'+idx);
			
			pDiv.one('.exp-entry-dt').set('innerHTML',sPeriod);
			
			
			pDiv.one('.user-exp-entry-data').set('innerHTML',data);
			pDiv.one('.exp-entry-title').set('innerHTML',title);
		}
		window.<portlet:namespace />buildPeriodDisplay = function(startDate,endDate)
		{
			/*start date 0-month,1-year,2-month name
			end date 0-month,1-year,2-current,3mth name
			*/
			var current = ((endDate[2] == "on") || (endDate[2]=="true"));
			var sPeriod = startDate[2].concat(" ",startDate[1]," - " );
			if (current)
				sPeriod = sPeriod.concat('Current');
			else
			{
				sPeriod = sPeriod.concat(endDate[3]," ", endDate[1]);
			}
			return sPeriod;
		}
	</aui:script>
<aui:script use="aui-base,aui-toggler">
	
		A.one('.<portlet:namespace />btnAddExp').on(
			'click',
			function(event) {
				event.preventDefault();
				Liferay.Util.selectEntity(
					{
						dialog: {
							constrain: true,
							destroyOnHide: true,
							modal: true,
							width: 850
						},
						id: '<portlet:namespace />addExperience',
						title: '<liferay-ui:message arguments="service-experience"
		key="edit-x" />',
						uri: '<%=addExperienceURL%>'
					},
					
					function(event) {
						
						var uId = event[0];
						var startDate = event[2];
						var endDate = event[3];
						<portlet:namespace />addServiceExperience(uId[1],event[4],event[1],startDate,endDate);
						
					}
				);
			}
		);
	A.one('.user-exp-container').delegate(
			'click',
			function(event){
				event.preventDefault();
				var link = event.currentTarget.ancestor('.user-exp-entry');
				var idx = link.getAttribute("dataIndex");
				var serviceExpId = link.getAttribute("serviceId");
				var delUrl = '<%=deleteExperienceURL%>';
				
				if (confirm('<%=UnicodeLanguageUtil.get(pageContext,
						"are-you-sure-you-want-to-delete-this-entry")%>')) {
					A.io.request(
						delUrl,
						{
							after: {
								success: function() {
									link.remove();
									
									var ids = A.one('#<portlet:namespace />serviceExperienceIndexes').get("value");
									ids = ids.replace(','.concat(idx),'');
									ids = ids.replace(idx.concat(','),'');
									A.one('#<portlet:namespace />serviceExperienceIndexes').set("value",ids);
									
								}
							},
							data: {
								<%=portletId%>_serviceExperienceId : serviceExpId,
								serviceExperienceId : serviceExpId
								
							}
						}
					);
				}
				
				
				
		
			},'.<portlet:namespace />deleteExp'
		);
	A.one('.user-exp-container').delegate(
			'click',
			function(event){
				event.preventDefault();
				var link = event.currentTarget.ancestor('.user-exp-entry');
				var idx = link.getAttribute("dataIndex");
				var id = link.getAttribute("serviceId");
				var url = '<%=editExperienceURL%>'.concat('&_','<%=portletId%>','_','serviceExperienceId','=',id,'&_','<%=portletId%>','_','dataIndex=',idx);
				url = url.concat('&_','<%=portletId%>','_','event=','edit');
				Liferay.Util.selectEntity(
					{
						dialog: {
							constrain: true,
							destroyOnHide: true,
							modal: true,
							width: 850
						},
						id: '<portlet:namespace />editExperience',
						title: '<liferay-ui:message arguments="service-experience"
		key="edit-x" />',
						uri: url
					},
					
					function(event) {
						var idIdx = event[0];
						var startDate = event[2];
						
						var endDate = event[3];
						<portlet:namespace />updServiceExperience(idIdx[0],event[4],event[1],startDate,endDate);
						
					}
				);
				
				
			
				
			
			},'.<portlet:namespace />editExp'
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
   	A.on(
		'domready',
		function(event) {
			togglerDelegate = new A.TogglerDelegate(
				{
					animated: true,
					container: '#user-exp-container',
					content: '.user-exp-entry-data',
					header: '.user-exp-entry-hdr'
					
				}
			);

		}
	);
	
	</aui:script>
<style>
.user-exp-entry-hdr {
	margin-bottom: 20px;
	padding: 10px;
	font-size: 15.5px;
	border-bottom: 1px solid;
	cursor: pointer;
}

.exp-hdr-action {
	float: right;
}

.user-exp-entry-data {
	
}

.user-exp-container .user-exp-entry .user-exp-item-header-icon {
	background: url() no-repeat 50%;
	display: inline-block;
	width: 9px;
}

.user-exp-container .user-exp-entry .toggler-header-expanded .user-exp-item-header-icon
	{
	background-image:
		url(/html/themes/control_panel/images/arrows/05_right.png);
}

.user-exp-container .user-exp-entry  .toggler-header-collapsed .user-exp-item-header-icon
	{
	background-image:
		url(/html/themes/control_panel/images/arrows/05_down.png);
}
</style>