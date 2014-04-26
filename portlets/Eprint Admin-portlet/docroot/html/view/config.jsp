<%@ include file="/html/eprint/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configActionUrl"/>

<form action="<%=configActionUrl.toString() %>" role="form" method="post" class="form-horizontal" name="<portlet:namespace />configuration">
	<div class="control-group">
	    <label for="eprintURL" class="col-sm-2 control-label">Eprint URL</label>
	    
	      	<input type="text" value="${eprintConfig.eprintURL }" class="form-text" id="eprintURL" name="eprintURL" placeholder="Eprint URL">
	    
 	 </div>
	
	<div class="button-holder">
    
      <button type="submit" class="btn btn-default">Save</button>
    
  </div>

</form>
