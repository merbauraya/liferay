<%@include file="/html/eprint/init.jsp" %>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.dataTables.js"/></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/date.ddmmmyy.sort.js"/></script>
<portlet:resourceURL  var="browseBySubjectIdURL" />
<portlet:resourceURL var="navURL" />
<%
	String eprintType = ParamUtil.getString(request, "type");
	String assetTagName = ParamUtil.getString(request, "tag");

%>
<div id="eprint-wrapper" style="min-height:100%">
	<div id="eprint-top-nav">
		<jsp:include page="/html/eprintview/nav_menu.jsp" />
	</div>
	<div id="eprint-type-nav" >
		
	</div>
	<div id="eprint-content">
	
	
	</div>
	<input type="hidden" id="nType"/>
</div>
<script type="text/javascript">
	var minusAlt = '<%= UnicodeLanguageUtil.get(pageContext, "collapse") %>';
	var minusImage = '01_minus.png';
	var plusAlt = '<%= UnicodeLanguageUtil.get(pageContext, "expand") %>';
	var plusImage = '01_plus.png';
	jQuery(document).on("click",".ep-entry-expander",function(event){
		var expander = event.currentTarget;
		
		var par = $(event.target).parent();
		
		
		var epEventDesc = $(expander).siblings('.ep-child-cont');
			if (epEventDesc) {
			var altText = $(expander).attr('alt');
			var src = $(expander).attr('src');

			if (src.indexOf('minus.png') > -1) {
				altText = altText.replace(minusAlt, plusAlt);
				src = src.replace(minusImage, plusImage);
			}
			else {
				altText = altText.replace(plusAlt, minusAlt);
				src = src.replace(plusImage, minusImage);
			}

			$(epEventDesc).toggle();

			$(expander).attr('alt', altText);
			$(expander).attr('src', src);
		}
		
	});
</script>

<script type="text/javascript">
jQuery(".eprint-nav").click(function(e){
	  // Holds the product ID of the clicked element
	
	var resourceURL;
	var tId = this.id;
	var navType=0;
	switch(tId)
	{
	case "eprint-by-subject":
  		navType=<%= EprintConstant.KEY_BY_SUBJECT_TREE %>;
  		
  		break;
	case "eprint-by-division":
 		navType = <%= EprintConstant.KEY_BY_DIVISION_TREE%>;
  		break;
	default:
   
	}
	$("#nType").val(navType);
	e.preventDefault();
	
	
	$.when
	{
		load_nav(navType);
		ep_viewBySubjectx("Latest Entry",null);
	}
	  
	});
		
	function load_nav(navType)
	{
		console.log("nav"+navType);
		jQuery.ajax({
			type: "GET",
			url: "<%=navURL.toString()%>",
			cache: false,
			dataType: "html",
			data : {
				navType: navType,
			
			},
			success: function(res)
			{
				$("#eprint-type-nav").html(res);
				$("#eprint-type-nav").toggle();
				
			},
			error: function () {
                    $("#eprint-type-nav").html("Unable to load navigation");
                    
                }
		});
	}
	
function ep_viewBySubjectx(subjectName,subjectId)
    {
		console.log("ep_viewBySubjectx")	;    	
		jQuery.ajax({
			type: "POST",
			url: "<%=navURL.toString() %>",
			cache: false,
			dataType: "html",
			data : {
					subjectId: subjectId,
					browseBy: $("#nType").val(),
					isAjax: 1,
					resType: "bySubjectId",
					reqFormat: "json",
					subjectName: subjectName
			},
			success: function(res)
			{
				$("#eprint-content").html(res);
				
				
			},
			error: function () {
                    $("#ep-content").html("Unable to complete your request");
                    
                }
		});
    }
	
</script>
<script type="text/javascript">
jQuery(document).on("click",".ep-head-link",function(e){

	  // Holds the product ID of the clicked element
	  
	  var tId = this.id;
	  var subjectName=	$(this).text();
	  console.log(subjectName);
	  subjectId = tId.replace("epsubject-","");
	  sCount = $(this).find('span').text();
	  console.log(subjectId + "-"+ sCount);
	  subjectName = subjectName.substring(0,subjectName.length - sCount.length);
	  //ep_viewBySubject(tId,subjectName);
	  ep_viewBySubjectx(subjectName,subjectId);
	  e.preventDefault();
	  
	});
$(document ).ready(function() {
	ep_viewBySubjectx("Latest Entry",null);
});
</script>
