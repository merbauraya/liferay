<%@ include file="/html/taglib/ui/social_bookmark/init.jsp" %> 

<!-- Go to www.addthis.com/dashboard to customize your tools -->
<script type="text/javascript" src="//s7.addthis.com/js/300/addthis_widget.js#pubid=ra-53bd736424063197"></script>




<aui:script>

   function emailThis(){

   var strrep ,ptitle = document.title;

	strrep= ptitle.replace(/"/g,'%22');
	strrep= ptitle.replace(/&/g,'%26');

	var mailtourl = "mailto:?subject=Interesting%20information&body=I thought you might find this information interesting: "+encodeURIComponent(location.href);
	location.href = mailtourl;
	return false
}
</aui:script>
<!-- Go to www.addthis.com/dashboard to customize your tools -->
<div class="addthis_sharing_toolbox"></div>
