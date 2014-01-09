<%@ include file="/html/eprintharvester/init.jsp" %>
<%@ page import="java.sql.*" %>
<%
	out.print(request.getContextPath());
%>
<portlet:resourceURL  var="browseBySubjectIdURL" />
<div class="row">

	<div id="ep-by-subj" class="col-md-6">
		<ul><li><img class="ep-entry-expander" src="/Eprint-harvester-portlet/img/01_minus.png" alt="expande"/><span><a href="#" class="ep-head-link" id="epsubject-subjects">Library of Congress Subject Areas</a></span><div class="ep-child-cont "><div class="ep-inner"><ul><li><img class="ep-entry-expander" src="/Eprint-harvester-portlet/img/01_minus.png" alt="expande"/><span><a href="#" class="ep-head-link" id="epsubject-A">A General Works</a></span><div class="ep-child-cont "><div class="ep-inner"><ul><li><span><a href="#" class="ep-head-link" id="epsubject-AC">AC Collections. Series. Collected works</a></span><div class="ep-child-cont aui-helper-hidden"><div class="ep-inner"><ul/></div></div></li></ul></div></div></li><li><img class="ep-entry-expander" src="/Eprint-harvester-portlet/img/01_minus.png" alt="expande"/><span><a href="#" class="ep-head-link" id="epsubject-B">B Philosophy. Psychology. Religion</a></span><div class="ep-child-cont "><div class="ep-inner"><ul><li><img class="ep-entry-expander" src="/Eprint-harvester-portlet/img/01_plus.png" alt="expande"/><span><a href="#" class="ep-head-link" id="epsubject-BV">BV Practical Theology</a></span><div class="ep-child-cont aui-helper-hidden"><div class="ep-inner"><ul><li><span><a href="#" class="ep-head-link" id="epsubject-BV1460">BV1460 Religious Education</a></span><div class="ep-child-cont aui-helper-hidden"><div class="ep-inner"><ul/></div></div></li></ul></div></div></li></ul></div></div></li><li><img class="ep-entry-expander" src="/Eprint-harvester-portlet/img/01_minus.png" alt="expande"/><span><a href="#" class="ep-head-link" id="epsubject-D">D History General and Old World</a></span><div class="ep-child-cont "><div class="ep-inner"><ul><li><img class="ep-entry-expander" src="/Eprint-harvester-portlet/img/01_plus.png" alt="expande"/><span><a href="#" class="ep-head-link" id="epsubject-D1">D History (General)</a></span><div class="ep-child-cont aui-helper-hidden"><div class="ep-inner"><ul><li><span><a href="#" class="ep-head-link" id="epsubject-D901">D901 Europe (General)</a></span><div class="ep-child-cont aui-helper-hidden"><div class="ep-inner"><ul/></div></div></li></ul></div></div></li></ul></div></div></li><li><img class="ep-entry-expander" src="/Eprint-harvester-portlet/img/01_minus.png" alt="expande"/><span><a href="#" class="ep-head-link" id="epsubject-K">K Law</a></span><div class="ep-child-cont "><div class="ep-inner"><ul><li><img class="ep-entry-expander" src="/Eprint-harvester-portlet/img/01_plus.png" alt="expande"/><span><a href="#" class="ep-head-link" id="epsubject-KD">KD England and Wales</a></span><div class="ep-child-cont aui-helper-hidden"><div class="ep-inner"><ul><li><span><a href="#" class="ep-head-link" id="epsubject-KDC">KDC Scotland</a></span><div class="ep-child-cont aui-helper-hidden"><div class="ep-inner"><ul/></div></div></li></ul></div></div></li></ul></div></div></li><li><img class="ep-entry-expander" src="/Eprint-harvester-portlet/img/01_minus.png" alt="expande"/><span><a href="#" class="ep-head-link" id="epsubject-L">L Education</a></span><div class="ep-child-cont "><div class="ep-inner"><ul><li><span><a href="#" class="ep-head-link" id="epsubject-L1">L Education (General)</a></span><div class="ep-child-cont aui-helper-hidden"><div class="ep-inner"><ul/></div></div></li><li><span><a href="#" class="ep-head-link" id="epsubject-LC">LC Special aspects of education</a></span><div class="ep-child-cont aui-helper-hidden"><div class="ep-inner"><ul/></div></div></li></ul></div></div></li><li><img class="ep-entry-expander" src="/Eprint-harvester-portlet/img/01_minus.png" alt="expande"/><span><a href="#" class="ep-head-link" id="epsubject-R">R Medicine</a></span><div class="ep-child-cont "><div class="ep-inner"><ul><li><img class="ep-entry-expander" src="/Eprint-harvester-portlet/img/01_plus.png" alt="expande"/><span><a href="#" class="ep-head-link" id="epsubject-RJ">RJ Pediatrics</a></span><div class="ep-child-cont aui-helper-hidden"><div class="ep-inner"><ul><li><span><a href="#" class="ep-head-link" id="epsubject-RJ101">RJ101 Child Health. Child health services</a></span><div class="ep-child-cont aui-helper-hidden"><div class="ep-inner"><ul/></div></div></li></ul></div></div></li></ul></div></div></li><li><img class="ep-entry-expander" src="/Eprint-harvester-portlet/img/01_minus.png" alt="expande"/><span><a href="#" class="ep-head-link" id="epsubject-Z">Z Bibliography. Library Science. Information Resources</a></span><div class="ep-child-cont "><div class="ep-inner"><ul><li><span><a href="#" class="ep-head-link" id="epsubject-Z004">Z004 Books. Writing. Paleography</a></span><div class="ep-child-cont aui-helper-hidden"><div class="ep-inner"><ul/></div></div></li><li><img class="ep-entry-expander" src="/Eprint-harvester-portlet/img/01_plus.png" alt="expande"/><span><a href="#" class="ep-head-link" id="epsubject-ZA">ZA Information resources</a></span><div class="ep-child-cont aui-helper-hidden"><div class="ep-inner"><ul><li><img class="ep-entry-expander" src="/Eprint-harvester-portlet/img/01_plus.png" alt="expande"/><span><a href="#" class="ep-head-link" id="epsubject-ZA4050">ZA4050 Electronic information resources</a></span><div class="ep-child-cont aui-helper-hidden"><div class="ep-inner"><ul><li><span><a href="#" class="ep-head-link" id="epsubject-ZA4050-31">Electronic Information Resources (Computer)</a></span><div class="ep-child-cont aui-helper-hidden"><div class="ep-inner"><ul/></div></div></li></ul></div></div></li></ul></div></div></li></ul></div></div></li></ul></div></div></li></ul>
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

