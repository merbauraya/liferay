<%@include file="/html/eprint/init.jsp" %>
<script src="<%=request.getContextPath()%>/js/jquery.dataTables.js"/></script>
<script src="<%=request.getContextPath()%>/js/date.ddmmmyy.sort.js"/></script>
<portlet:resourceURL  var="browseBySubjectIdURL" />


<div class="row">

	<div id="ep-by-subj" class="col-md-5 nopadding">
		<jsp:include page="/html/eprintview/type_tree.jsp" />
		
	</div>
	<div class="col-md-7" id="ep-subj-entry">
		
		
	</div>
</div>
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
                    console.log('Error Occurred');
                }
		});
    }
</script>
<script>
jQuery(function() {
	ep_viewBySubject(null,'Latest Entry');
})
</script>