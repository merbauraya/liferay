<%@ include file="/html/tabview/init.jsp" %>

<div id="tabview-wrapper">

  <ul id="<portlet:namespace/>tabView" class="nav nav-tabs">
    <li class="active"><a href="#<portlet:namespace/>tab-1">Latest Wiki</a></li>
    <li><a href="#<portlet:namespace/>tab-2">Latest Blogs</a></li>
    <li><a href="#<portlet:namespace/>tab-3">Latest Upload </a></li>
    <li><a href="#<portlet:namespace/>tab-4">Latest Eprints </a></li>
  </ul>

  <div class="tab-content">
    <div id="<portlet:namespace/>tab-1" class="tab-pane active">
    	<jsp:include page="/html/tabview/latest_wiki.jsp">
    		<jsp:param name="viewType" value="tab-1"/>
    	</jsp:include>
      </div>
    <div id="<portlet:namespace/>tab-2" class="tab-pane">
       <jsp:include page="/html/tabview/latest_blog.jsp">
    		<jsp:param name="viewType" value="tab-1"/>
    	</jsp:include>
      
    </div>
    <div id="<portlet:namespace/>tab-3" class="tab-pane">
      <jsp:include page="/html/tabview/latest_upload.jsp">
    		<jsp:param name="viewType" value="tab-1"/>
    	</jsp:include>
      
    </div>
    <div id="<portlet:namespace/>tab-4" class="tab-pane">
      <jsp:include page="/html/tabview/latest_eprint.jsp">
    		<jsp:param name="viewType" value="tab-1"/>
    	</jsp:include>
      
    </div>
  </div>

</div>
<aui:script>
$('#<portlet:namespace/>tabView a').click(function (e) {
    e.preventDefault();
    $(this).tab('show');
    })

</aui:script>

<aui:script>/*
YUI().use(
  'aui-tabview',
  function(Y) {
    new Y.TabView(
      {
        srcNode: '#tabview-wrapper'
      }
    ).render();
  }
);*/
</aui:script>