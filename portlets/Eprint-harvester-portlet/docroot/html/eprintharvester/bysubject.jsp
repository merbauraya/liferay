<%@ include file="/html/eprintharvester/init.jsp" %>

<%
	out.print(request.getContextPath());
%>
<portlet:resourceURL  var="browseBySubjectIdURL" />
<div class="row">

	<div id="ep-by-subj" class="col-md-6">
			<liferay-util:include page="/html/eprintview/subject_tree.jsp" />
	</div>
	<div class="col-md-6" id="ep-subj-entry">
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
$(".ep-head-link").click(function(e){
	  // Holds the product ID of the clicked element
	  console.log(this.id);
	  var tId = this.id;
	 	
	  tId = tId.replace("epsubject-","");
	  ep_viewBySubject(tId);
	  e.preventDefault();
	  
	});
	function ep_viewBySubject(subjectId)
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
			},
			success: function(res)
			{
				$("#ep-subj-entry").html(res);
				
			},
			error: function () {
                    $("#ep-subj-entry").html("Unable to complete you request");
                    console.log('Error Occurred');
                }
		});
    }
</script>

