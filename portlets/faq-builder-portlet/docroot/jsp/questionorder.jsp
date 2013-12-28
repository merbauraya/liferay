<%@include file="/jsp/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>

<portlet:resourceURL var="getPlan" id="getPlan" >
	 <portlet:param name="jspPage" value="/jsp/ajax/question.jsp" />
</portlet:resourceURL>
<portlet:actionURL  name="getQuestionURL" var="getQuestionURL">
 <portlet:param name="jspPage" value="/jsp/ajax/question.jsp" />
 </portlet:actionURL>
<%

	PortletURL listURL = renderResponse.createRenderURL();
	listURL.setParameter("jspPage", "/jsp/catQuestion.jsp");
	//PortletURL entryURL = renderResponse.createRenderURL();
	//entryURL.setParameter("jspPage", "/jsp/entry.jsp");
	List<Object> catList = FAQEntryLocalServiceUtil.getCategory();
	PortletURL saveQuestionOrderURL = renderResponse.createActionURL();
	saveQuestionOrderURL.setParameter(ActionRequest.ACTION_NAME, "saveQuestionOrder");

	
	
	%>
<select id="qCategory">
	<%
	for (Object faq : catList)
	{
		Object row[] = (Object[]) faq;
		String catName = (String) row[0];	
		
	%>
		
		<option value="<%=catName %>"><%=catName %></option>
	<%
	}
	%>
	
</select>

<aui:button name="loadQuestion" type="button" value="Load Question" last="true" 
	class="loadQuestion" onClick="<%= renderResponse.getNamespace() + \"loadQuestion()\"%>"/>


<div id="qlist">

</div>

<aui:script>


	function <portlet:namespace />loadQuestion() {
		
		var A = AUI();
    	var url = '<%= getPlan.toString() %>';
    	var qCat = document.getElementById("qCategory").value;
	    A.io.request(url,
	    {
			method: 'get',
			dataType: 'html',
	        data: {
	        	qCategory: qCat
	        },
	
	        on: {
	        failure: function() {
	        },
	
	        success: function(event, id, obj) {
	            var instance = this;
	            var message = this.get('responseData');
	            
	            //console.log(url);
	            if (message) {
	                //alert(message);
	                A.one("#qlist").html(message);
	                document.getElementById('saveOrder').style.display = '';
	            }
	            else {
	                A.one("#saveOrder").hide();
	            }
	        }
	
	    }
	}
	
	); //END of io Request
}
</aui:script>
<script>
	$(document).on("click", 'button.change-rank', function() {
		 
		//alert('Clicked');																	 
		
		var moveDirection = $(this).attr('data-direction');
		
		var original = $(this).parents('tr').attr('id');
        var originalID = $('#'+ original + '').attr('data-id');
		var originalRank = $('#'+ original + '').attr('data-rank');
		var originalRow = $('#'+ original + '').html();
		
		if (moveDirection == 'up') {
			var switchTo = $(this).parents('tr').prev().attr('id');
		}//end if UP
		
		if (moveDirection == 'down') {
			var switchTo = $(this).parents('tr').next().attr('id');
		}//end if DOWN
		
		var switchID = $('#'+ switchTo + '').attr('data-id');
		var switchRank = $('#'+ switchTo + '').attr('data-rank');
		var switchRow = $('#'+ switchTo + '').html();
		
		//POST variables to actions.php via $.ajax
        //Do the rest after $.ajax is successful
		
		$('#'+ original + '').html(switchRow);
		$('#'+ switchTo + '').html(originalRow);

		$('#'+ original + '').attr('id', switchTo).attr('data-id', switchID);
		
        if (moveDirection == 'up') {
		  $('#'+ switchTo + '').attr('id', original).attr('data-id', originalID);
		}
		else if (moveDirection == 'down') {
          $('#'+ switchTo + '').next().attr('id', original).attr('data-id', originalID);
		}
    });
	
	</script>
<aui:form name="fm" method="POST" action="<%= saveQuestionOrderURL.toString() %>"  onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveQuestionOrder();" %>'>
	
		<aui:input name="<%= Constants.CMD %>" type="hidden" />
		<aui:input type="hidden" name="category" id="category" />
		<aui:input type="hidden" name="qorder" id="qorder" value="zzz"/>
		<input type="submit" id="saveOrder" value="save" name="saveOrder" style="display:none"/>
	
</aui:form>

<aui:script>
	function <portlet:namespace />saveQuestionOrder() {
		
		console.log("saveQ");
		var q="";
		var qorder = document.getElementById("<%=renderResponse.getNamespace() %>qorder");
		$("#questionList >tbody >tr").each(function(i, tr)
		{
			var id = $(tr).attr("id");
			var v = $(tr).attr("data-rank");
			q = q+ id + "=" + v +";"
			
		
		})
		
		qorder.value = q;
		console.log(qorder.value);
		submitForm(document.<portlet:namespace />fm);
		
}
</aui:script>