<%@include file="/html/eprint/init.jsp" %>
<liferay-ui:asset-tags-error />
<%
	String eprintId = request.getParameter("eprintId");
	
	Eprint eprint = EprintLocalServiceUtil.fetchEprint(Long.parseLong(eprintId));
	String eprintUrl = null;
	if (Validator.isNotNull(eprint))
	{
		//eprintUrl = eprintConfig.getEprintURL() + eprint.getEprintId();
		com.liferay.portal.util.PortalUtil.setPageTitle("Update- "+ eprint.getTitle(), request); 
	}
	

	PortletURL updateEntryUrl = renderResponse.createActionURL();
	updateEntryUrl.setParameter(ActionRequest.ACTION_NAME, "updateEntry");

%>

<form action="<%=updateEntryUrl.toString() %>" method="post" class="form" name="<portlet:namespace />configuration">
	<aui:model-context bean="<%= eprint %>" model="<%= Eprint.class %>" />
	<input type="hidden" name="eprintId" value="<%=eprintId %>">
	<fieldset class="fieldset">
		<div class="control-group">
	    	<label for="title" class="control-label">Title</label>
	    	<div class="controls">
	      		<input type="text" class="span12" id="title" name="title" value ="<%= eprint.getTitle()%>" placeholder="Title">
	    	</div>
	  	</div>
	  <div class="control-group">
	    	<label for="abstract" class="control-label">Abstract</label>
	    	<div class="controls">
	      		<textarea class="span12" id="abstract" name="abstract" rows="10" placeholder="Abstract"><%= eprint.getEprintAbstract() %></textarea>
	    	</div>
	  	</div>
	  	<div id="eprintEntryCategorizationPanel" class="accordion-group lfr-panel">
		  	 <div class="accordion-heading toggler-header" data-persisted="eprintEntryCategorizationPanel">
		  	 	<div class="accordion-toggle">
		  	 		<span class="title-text"> Categorization</span>
		  	 	</div>
		  	 </div>
		  	 <div class="toggler-content-wrapper">
		  	 	<div class="toggler-content">
			  	 	<div class="accordion-inner">
			  	 		<fieldset class="fieldset">
			  	 			 <div class="control-group">
		  	 					<label for="keywords" class="col-sm-2 control-label"></label>
		  	 					<div class="col-sm-10">
		    	 					<aui:input name="tags" type="assetTags" />
		    	 		
		    	 				</div>
		  					</div>
			  	 			</fieldset>
			  	 	
			  	 	</div>
			  	 </div>
		  	</div>
		 </div>
	  	 <div class="control-group">
	  	 	<label for="keywords" class="col-sm-2 control-label">Related Assets</label>
	  	 		<div class="col-sm-10">
	    	 		
					<liferay-ui:input-asset-links
						assetEntryId="<%= eprint.getEprintId() %>"
						className="<%= Eprint.class.getName() %>"
						classPK="<%= eprint.getEprintId() %>"
					/>
				
	    	 		
	    	 		
	    	 		
	    	 	</div>
	  	</div>
	 	<div class="control-group">
	    	<label for="keywords" class="col-sm-2 control-label">Keywords</label>
	    	<div class="col-sm-10">
	      		<input type="text" class="form-control" id="keywords" name="abstract" placeholder="Abstract" value="<%= eprint.getEprintKeywords() %>" >
	    	</div>
	    	
	  	</div>
	  	
	  	<div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-default">Save</button>
	    </div>
    </fieldset>
   
</form>

 