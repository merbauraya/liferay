<%@ include file="/html/service_experience/init.jsp" %>

<portlet:actionURL var="actionURL">
	<portlet:param name="<%=ActionRequest.ACTION_NAME%>" value="addServiceExperience" />
	<portlet:param name="p_u_i_d" value="<%=String.valueOf(user.getUserId())%>" />
</portlet:actionURL>
<portlet:resourceURL var="reURL"></portlet:resourceURL>
<% 
	
	Calendar curCal = CalendarFactoryUtil.getCalendar(timeZone, locale);
	int startMonthValue=0,startYearValue=0,endMonthValue=0,endYearValue=0;
	int[] monthIds = CalendarUtil.getMonthIds();
	String[] months = CalendarUtil.getMonths(locale);
	
	
	long userId = ParamUtil.getLong(request, "p_u_i_d");
	
	int yearRangeStart = curCal.get(Calendar.YEAR) - 70;
	int yearRangeEnd = curCal.get(Calendar.YEAR);
	String namespace = renderResponse.getNamespace();
	long serviceExperienceId = ParamUtil.getLong(request, "serviceExperienceId");	
	String dataIndex = ParamUtil.getString(request, "dataIndex");
	if (Validator.isNull(dataIndex) || Validator.isBlank(dataIndex))
		dataIndex = "-1";
	String serviceExperienceTitle = "",serviceExperienceData="";
	
	Calendar startDate = CalendarFactoryUtil.getCalendar();
	Calendar endDate = CalendarFactoryUtil.getCalendar();
	boolean current = true;
	if (serviceExperienceId > 0)
	{
		ServiceExperience serviceExperience = ServiceExperienceLocalServiceUtil.getServiceExperience(serviceExperienceId);
		serviceExperienceTitle = serviceExperience.getTitle();
		serviceExperienceData = serviceExperience.getServiceData();
		
	
		if (serviceExperience.getStartDate() != null) {
			startDate.setTime(serviceExperience.getStartDate());
			startMonthValue = startDate.get(Calendar.MONTH);
			startYearValue = startDate.get(Calendar.YEAR);
		}
	
		if (serviceExperience.getEndDate() != null) {
			endDate.setTime(serviceExperience.getEndDate());
			endMonthValue = endDate.get(Calendar.MONTH);
			endYearValue = endDate.get(Calendar.YEAR);
			current = false;
		}
		
	}else
		current=false;

	String nameSpace = ParamUtil.getString(request, "nameSpace");
	String eventName = ParamUtil.getString(request, "eventName", nameSpace + "editExperience");
	
	
	
%>
<form id="<portlet:namespace />fm" class="form-horizontal" action="#" method="post" name="<portlet:namespace />fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "submitForm();" %>'>


<aui:input name='serviceExperienceId' type="hidden" value="<%= serviceExperienceId %>" id='serviceExperienceId'/>
<div class="control-group">
	<label class="control-label" for="">Description</label>
	<div  class="controls">
	<input class="field lfr-input-text" type="text" maxlength="200" name="<portlet:namespace />serviceTitle" value='<%= serviceExperienceTitle %>' id='<portlet:namespace />serviceTitle'/>
	</div>	
</div>
<aui:input name='userId' value='<%= userId %>' type="hidden"/>
	<div class="control-group">

			<%
			String fieldParam = "serviceExperienceStartDate";

			Calendar selDate = startDate;
			String startMonthId = renderResponse.getNamespace() +"startMonth";
			String startYearId = renderResponse.getNamespace() +"startYear";
			String endMonthId = renderResponse.getNamespace() +"endMonth";
			String endYearId = renderResponse.getNamespace() +"endYear";
			String chkCurrentId = renderResponse.getNamespace() +"current";
			%>

			<div class="field">
				<label class="control-label" for="<%= nameSpace %><%= fieldParam %>"><liferay-ui:message key="start-date" /></label>
	
				<div  class="controls">
					<select id="<%=startMonthId%>" name="<%=startMonthId%>">
					<%
						for (int j = 0; j < months.length; j++) {
					%>
	
						<option <%= (startMonthValue == monthIds[j]) ? "selected" : "" %> value="<%= monthIds[j] %>"><%= months[j] %></option>
	
					<%
					}
					%>
					
					</select>
					
					<select id="<%= startYearId %>" name="<%= startYearId %>">
						<c:if test="<%= (startYearValue > 0) && (startYearValue > yearRangeEnd) %>">
							<option selected value="<%= startYearValue %>"><%= startYearValue %></option>
						</c:if>
					
						<%
						for (int j = yearRangeEnd; j >= yearRangeStart; j--) {
						%>
					
							<option <%= (startYearValue == j) ? "selected" : "" %> value="<%= j %>"><%= j %></option>
					
						<%
						}
						%>
					
						<c:if test="<%= (startYearValue > 0) && (startYearValue < yearRangeStart) %>">
							<option selected value="<%= startYearValue %>"><%= startYearValue %></option>
						</c:if>
					</select>
				</div>
			</div>
		</div>
	
	<div class="control-group">

			<%
			fieldParam = "serviceExperienceEndDate";

			selDate = startDate;
			%>

			<div class="field">
				<label class="control-label" for="<%= nameSpace %><%= fieldParam %>"><liferay-ui:message key="end-date" /></label>
				<div class="controls">
					<select id="<%=endMonthId%>" name="<%=endMonthId%>">
					<%
						for (int j = 0; j < months.length; j++) {
					%>
	
						<option <%= (endMonthValue == monthIds[j]) ? "selected" : "" %> value="<%= monthIds[j] %>"><%= months[j] %></option>
	
					<%
					}
					%>
					
					</select>
					<select id="<%= endYearId %>" name="<%= endYearId %>">
						<c:if test="<%= (endYearValue > 0) && (endYearValue > yearRangeEnd) %>">
							<option selected value="<%= endYearValue %>"><%= endYearValue %></option>
						</c:if>
					
						<%
						for (int j = yearRangeEnd; j >= yearRangeStart; j--) {
						%>
					
							<option <%= (endYearValue == j) ? "selected" : "" %> value="<%= j %>"><%= j %></option>
					
						<%
						}
						%>
					
						<c:if test="<%= (endYearValue > 0) && (endYearValue < yearRangeStart) %>">
							<option selected value="<%= endYearValue %>"><%= endYearValue %></option>
						</c:if>
					</select>
				
					<label class="checkbox">Current
						<liferay-ui:input-checkbox defaultValue="<%= current %>" param="current" />
					</label>
					
				</div>
			</div>
	</div>
	



<aui:field-wrapper>
	<liferay-ui:input-editor width="100%" />
	<aui:input name="data" type="hidden" />
					
</aui:field-wrapper>
<aui:button cssClass="btn-small" value="Save" onClick="submitItemForm();"  ></aui:button>
</form>
<aui:script>
	function <portlet:namespace />initEditor() {
		return "<%= UnicodeFormatter.toString(serviceExperienceData) %>";
		
	}

	

	function <portlet:namespace />submitForm() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= (serviceExperienceId==0) ? Constants.ADD : Constants.UPDATE %>";
		document.<portlet:namespace />fm.<portlet:namespace />Data.value = window.<portlet:namespace />editor.getHTML();
		submitForm(document.<portlet:namespace />fm);
		
	}
	
</aui:script>

<aui:script use="aui-base">
Liferay.provide(window,'submitItemForm',
         function() {
          var A = AUI();
         	document.<portlet:namespace />fm.<portlet:namespace />data.value = window.<portlet:namespace />editor.getHTML();
	
          A.io.request('<%=actionURL %>',{
              method: 'POST',
              form: { id: '<portlet:namespace />fm' },
              on: {
                  success: function(event, id, obj){
 						var responseData = this.get('responseData');
 						
 						<portlet:namespace/>updateDisplay(responseData.id);
 						
   
                   }
             },
             dataType: 'json'
        });
  });
function <portlet:namespace/>updateDisplay(serviceId)
{
	var startDate=[];
	var endDate=[];
	var idIdx=[];
	startDate.push(A.one('#<portlet:namespace />startMonth').get("value"));
	startDate.push(A.one('#<portlet:namespace />startYear').get("value"));
	var sMonth = A.one('#<portlet:namespace />startMonth');
	
	startDate.push(sMonth.get('options').item(sMonth.get('selectedIndex')).get('text'));
	endDate.push(A.one('#<portlet:namespace />endMonth').get("value"));
	endDate.push(A.one('#<portlet:namespace />endYear').get("value"));
	endDate.push(A.one('#<portlet:namespace />current').get("value"))
	console.log(A.one('#<portlet:namespace />current').get("value"));
	var sMonth = A.one('#<portlet:namespace />endMonth');
	endDate.push(sMonth.get('options').item(sMonth.get('selectedIndex')).get('text'));
	var result = [];
	
	idIdx.push(<%=dataIndex %>,serviceId);
	
	result.push(idIdx);
	result.push(A.one('#<portlet:namespace />serviceTitle').get("value"));
	result.push(startDate);
	result.push(endDate);
	result.push(window.<portlet:namespace />editor.getHTML());
	console.log('<%= HtmlUtil.escapeJS(eventName) %>');
	Liferay.Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>', result);
	Liferay.Util.getOpener().closePopup('<%= HtmlUtil.escapeJS(eventName) %>');
  
}

</aui:script>	
	