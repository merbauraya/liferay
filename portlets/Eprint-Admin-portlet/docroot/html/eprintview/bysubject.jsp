<%@include file="/html/eprint/init.jsp" %>
<!-- 
<script src="<%=request.getContextPath()%>/js/jquery.dataTables.js"/></script>
<script src="<%=request.getContextPath()%>/js/date.ddmmmyy.sort.js"/></script>

-->
<portlet:resourceURL  var="browseBySubjectIdURL" />

<div id="eprint-top-nav">
	<jsp:include page="/html/eprintview/nav_menu.jsp" />
</div>

<%
List<Object> results = EprintLocalServiceUtil.byTypeSummary();
int i =0;


for (Object obj: results) {
	
	Object row[] = (Object[]) obj;
//	out.print(row[0]+"="+ row[1]);
	
}

%>
	
	<div class="eprint-wrapper row-fluid">

		<div id="ep-by-subj" class="span12" style="height:200px;overflow:auto;">
			<jsp:include page="/html/eprintview/subject_tree.jsp" />
		</div>
	</div>
	<div class="row-fluid">		
		
		<div class="span12" id="ep-subj-entry">
			
			
		</div>
	</div>
	/*
<aui:script use="aui-base">
	var minusAlt = '<%= UnicodeLanguageUtil.get(pageContext, "collapse") %>';
	var minusImage = '01_minus.png';
	var plusAlt = '<%= UnicodeLanguageUtil.get(pageContext, "expand") %>';
	var plusImage = '01_plus.png';

	A.all('.ep-entry-expander').on(
		'click',
		function(event) {
			var expander = event.currentTarget;
			var epEventDesc = expander.get('parentNode').one('.ep-child-cont');

			if (epEventDesc) {
				var altText = expander.attr('alt');
				var src = expander.attr('src');

				if (src.indexOf('minus.png') > -1) {
					altText = altText.replace(minusAlt, plusAlt);
					src = src.replace(minusImage, plusImage);
				}
				else {
					altText = altText.replace(plusAlt, minusAlt);
					src = src.replace(plusImage, minusImage);
				}

				epEventDesc.toggle();

				expander.attr('alt', altText);
				expander.attr('src', src);
			}
		}
	);
</aui:script>
<script>
jQuery(".ep-head-link").click(function(e){
	  // Holds the product ID of the clicked element
	  
	  var tId = this.id;
	  var subjectName=	$(this).text();
	  console.log(subjectName);
	  tId = tId.replace("epsubject-","");
	  sCount = $(this).find('span').text();
	  console.log(sCount);
	  subjectName = subjectName.substring(0,subjectName.length - sCount.length);
	  ep_viewBySubject(tId,subjectName);
	  
	  e.preventDefault();
	  
	});
	function ep_viewBySubject(subjectId,subjectName)
    {
    	console.log("ep_viewBySubject");
		jQuery.ajax({
			type: "POST",
			url: "<%=browseBySubjectIdURL%>",
			cache: false,
			dataType: "html",
			data : {
					subjectId: subjectId,
					isAjax: 1,
					resType: "bySubjectId",
					reqFormat: "json",
					subjectName: subjectName
			},
			success: function(res)
			{
				$("#ep-subj-entry").html(res);
				
			},
			error: function () {
                    $("#ep-subj-entry").html("Unable to complete your request");
                    
                }
		});
    }
</script>
<script>
jQuery(function() {
	ep_viewBySubject(null,'Latest Entry');
})
</script> */