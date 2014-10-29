<%@ include file="/html/expertise/init.jsp" %>

<portlet:actionURL var="saveExpertiseURL">
	<portlet:param name="<%=ActionRequest.ACTION_NAME%>" value="saveUserExpertise" />
	<portlet:param name="p_u_i_d" value="<%=String.valueOf(user.getUserId())%>" />
</portlet:actionURL>
<portlet:resourceURL var="tagListURL">
	<portlet:param name="resource" value="tagList" />
</portlet:resourceURL>


<%
out.print(tagListURL);
long userId = ParamUtil.getLong(request, "p_u_i_d");
String nameSpace = ParamUtil.getString(request, "nameSpace");
String eventName = ParamUtil.getString(request, "eventName", nameSpace + "editExpertise");
List userExpertises = UserEntries_ExpertiseTagsLocalServiceUtil.getUserEntry(userId);
ExpertiseTag expertiseTag = null;
UserEntries_ExpertiseTags userTag = null;
String selectedTag = "";
for (Object obj: userExpertises)
{
	Object[] arrayobject=(Object[])obj;
	expertiseTag = (ExpertiseTag) arrayobject[0];
	userTag = (UserEntries_ExpertiseTags) arrayobject[1];
	
	selectedTag += expertiseTag.getTagName()+","; 
	
}
%>


<input id="<portlet:namespace />expTags" type="text" value="<%=selectedTag %>" data-role="tagsinput"/>

<form id="<portlet:namespace />fmExpertise" class="form-horizontal" action="#" method="post" name="<portlet:namespace />fm" onSubmit='<%= "event.preventDefault();" %>'>
	<aui:input type="hidden" name="exp_Expertise" id="exp_Expertise"/>
	<aui:input name='userId' value='<%= userId %>' type="hidden"/>
	<div>
	<aui:button cssClass="btn-small" value="Save" onClick="saveUserExpertise();"  ></aui:button>
	</div>
</form>



<aui:script use="aui-base">
Liferay.provide(window,'saveUserExpertise',
         function() {
          	var A = AUI();
         	var tagValue = A.one("#<portlet:namespace />expTags").val();
         	
         	
         	A.one('#<portlet:namespace />exp_Expertise').val(tagValue.trim());
         	console.log('tag='+tagValue);
          A.io.request('<%=saveExpertiseURL %>',{
              method: 'POST',
              form: { id: '<portlet:namespace />fmExpertise' },
              on: {
                  success: function(event, id, obj){
 						//var responseData = this.get('responseData');
 						var result = A.one("#<portlet:namespace />expTags").val();
 						Liferay.Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>', result);
						Liferay.Util.getOpener().closePopup('<%= HtmlUtil.escapeJS(eventName) %>');
 						
   
                   }
             },
             dataType: 'json'
        });
  });
  AUI().ready(
  	function(A)
  	{
  
		

  	
  		
  		/*
  		var tagNames = new Bloodhound({
		  datumTokenizer: Bloodhound.tokenizers.obj.whitespace('name'),
		  queryTokenizer: Bloodhound.tokenizers.whitespace,
		  prefetch: {
		    url: '<%=tagListURL %>',
		    filter: function(list) {
		      return $.map(list, function(tagname) {
		      	console.log(tagname);
		        return { name: tagname }; });
		    }
		  }
		});
		tagNames.initialize();
		console.log(tagNames);
		$('#<portlet:namespace />expTags').tagsinput({
		  typeaheadjs: {
		    name: 'tagNames',
		    displayKey: 'name',
		    valueKey: 'name',
		    source: tagNames.ttAdapter()
		  }
		});
		*/
  		  
  	}
  
  );
  
 Liferay.Portlet.ready(

    /*
    This function gets loaded after each and every portlet on the page.

    portletId: the current portlet's id
    node: the Alloy Node object of the current portlet
    */

    function(portletId, node) {
    	console.log(portletId);
    }
);

$('#<portlet:namespace />expTags').tagsinput({
		  typeahead: {
		    source: function(query) {
		      return $.getJSON(
		      	'<%=tagListURL.toString() %>');
		      	
		   
		      
		      
		    }
		  }
		});


  </aui:script>
	