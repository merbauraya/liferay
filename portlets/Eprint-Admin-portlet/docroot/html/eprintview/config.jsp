<%@ include file="/html/eprint/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configActionUrl"/>

<form action="<%=configActionUrl.toString() %>" role="form" method="post" class="form-horizontal" name="<portlet:namespace />configuration">
	<div class="form-group">
	    <label for="eprintURL" class="col-sm-2 control-label">Eprint URL</label>
	    <div class="col-sm-10">
	      	<input type="text" value="${eprintConfig.eprintURL }" class="form-control input-sm col-xs-4" id="eprintURL" name="eprintURL" placeholder="Eprint URL">
	    </div>
 	 </div>
	
	<div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Save</button>
    </div>
  </div>

</form>
