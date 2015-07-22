<%@include file="/html/suburstatistic/init.jsp"%>

<%
	PortletURL updStatURL = renderResponse.createActionURL();
	String statDisplay = StringPool.BLANK;
	if (displayType.equals(SuburStatUtil.VIEW_MONTHLY_SUMMARY_ITEMTYPE))
		statDisplay = "renderMonthlyItemType('2015')";
	if (displayType.equals(SuburStatUtil.VIEW_MONTHLY_SUMMARY_TAG))
		statDisplay = "renderMonthlyTag('2015')";
	if (displayType.equals(SuburStatUtil.VIEW_MONTHLY_SUMMARY))
		statDisplay="renderMonthlySummary('2015')";
	if (displayType.equals(SuburStatUtil.VIEW_MONTHLY_SUMMARY_CATEGORY))
		statDisplay="renderMonthlyCategory('2015','25303')";
	
		
%>
<%=displayType %>
<portlet:actionURL var="updateStatURL" name="updateStats">
    <portlet:param name="jspPage" value="/edit.jsp" />
</portlet:actionURL>


	<a href="<%= updateStatURL.toString() %>">Update Stat</a>
	
	<div id="<portlet:namespace />myDataTable">
		
	</div>

<aui:script use="aui-datatable,datatable-sort,aui-datatype">
	var A = AUI();
	
	<%=statDisplay%>
	/*
	renderMonthlySummary();
	renderMonthlyTag(2015);
	renderMonthlyItemType(2015);
	*/
	
	function renderMonthlySummary(statYear)
	{
			var columns = [{key:'monthName',label:'Month'},{key:'totalview',label:'View',sortable:true}];
		Liferay.Service(
			  '/Subur-portlet.viewsummary/get-monthly-summary',
			  {
			    year: statYear
			  },
			  function(obj) {
			    
			    renderStat(columns,obj,statYear + " monthly View Summary");
			  }
			);
	}
	function renderMonthlyCategory(statYear,vocabularyId)
	{
		var columns = [{key:'categoryname',label:'Category'},{key:'M1',label:'Jan'},
		               {key:'M2',label:'Feb'},{key:'M3',label:'Mac'},
		               {key:'M4',label:'Apr'},{key:'M5',label:'May'},
		               {key:'M6',label:'Jun'},{key:'M7',label:'July'}];
		Liferay.Service(
				'/Subur-portlet.viewsummary/get-monthly-category',
			  {
			    year: statYear,
			    vocabularyId : vocabularyId 
			  },
			  function(obj) {
			    
			    renderStat(columns,obj, statYear + " monthly by Category");
			  }
			);
	}
	function renderMonthlyItemType(statYear)
	{
		//var columns = 
		
		var columns = [{key:'itemtypename',label:'Item Type'},{key:'M1',label:'Jan'},
		               {key:'M2',label:'Feb'},{key:'M3',label:'Mac'},
		               {key:'M4',label:'Apr'},{key:'M5',label:'May'},
		               {key:'M6',label:'Jun'},{key:'M7',label:'July'}];
		Liferay.Service(
				'/Subur-portlet.viewsummary/get-monthly-item-type',
				  {
				    year: statYear
				  },
				  function(obj) {
					  renderStat(columns,obj,statYear + " monthly by Item Type");
				  }
				);
		
	
	}
	function renderMonthlyTag(statYear)
	{
		var columns = [{key:'tagname',label:'Tag'},{key:'M1',label:'Jan'},
		               {key:'M2',label:'Feb'},{key:'M3',label:'Mac'},
		               {key:'M4',label:'Apr'},{key:'M5',label:'May'},
		               {key:'M6',label:'Jun'},{key:'M7',label:'July'}];
		Liferay.Service(
				  '/Subur-portlet.viewsummary/get-monthly-tag-summary',
				  {
				    year: statYear
				  },
				  function(obj) {
					  renderStat(columns,obj,statYear + " monthly Tag Summary");
				  }
				);
		
	
	}
		function renderStat(columns,data,caption)
		{
			var dataTable = new A.DataTable(
				{
					columnset: columns,
					recordset: data,
					caption: caption,
					sortable: true
					
				}		
			).render('#<portlet:namespace />myDataTable');
			dataTable.get('boundingBox').unselectable();
		}
</aui:script>