<%@ include file="/html/orgchart/init.jsp" %>
<% 
User selUser = PortalUtil.getSelectedUser(request);

%>

<liferay-portlet:resourceURL var="getUserURL">
	<portlet:param name="resource" value="usertree"/>
	<portlet:param name="userId"
		value="<%=String.valueOf(selUser.getUserId())%>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="searchUserURL">
	<portlet:param name="resource" value="usersearch"/>
</liferay-portlet:resourceURL>
<liferay-portlet:actionURL var="saveOrgTreeURL" name="saveOrgTree">

</liferay-portlet:actionURL>


<div id="in" style="display:none"></div>

<div class="user-container">
	<div class="user-list" style="float:left;width:20%">
	<input style="width:80px" name="<portlet:namespace /><%=Constant.PARAMETER_KEYWORDS %>" id="<portlet:namespace /><%=Constant.PARAMETER_KEYWORDS %>" type="text" placeholder="Search">
 	<ul id="upload-chart">
	
	</ul>
	</div>
	<div id="chart" class="orgChart" style="float:right;width:80%"></div>
<div id="orgChartDisp"></div>
</div>
<aui:form id="fmOrgChart">
	<aui:input id="orgTree" name="orgTree" type="hidden" />
</aui:form>
<div style="clear:both;margin:0 auto;">
<liferay-ui:icon
		cssClass="edit-exp"
		iconCssClass="icon-save"
		label="<%= true %>"
		linkCssClass="<%=renderResponse.getNamespace()+ \"saveChart btn \"%>"
		message="save"
		url="javascript:;"
	/>	
</div>	
<aui:script use="aui-base,aui-io-request,autocomplete">
		var A = AUI();
		
function remChild(removing){
		$("#upload-chart").append(removing);
		$("#upload-chart ul li").each(function(){
			var Orgli = $(this).removeAttr("class").addClass("node").addClass("child").clone();
			$(this).remove();
			$("#upload-chart").append(Orgli);
		});
		$("#upload-chart ul").remove();
		var sideLi = $("#upload-chart").html();
		$("#upload-chart").empty();			
		$("#upload-chart").append(sideLi);
	}
	function makeArrays()
		{
			var hierarchy = [];
 
			$("#org li").each(function(){
			
                var uid = $(this).attr("id");
				var name = $(this).find(">:first-child a").text();
                var userId = $(this).attr("dataid");
				var hidSTR = "";
				var hid = $(this).parents("li");
                
				var parentLi = $(this).parents("li").first();
               
                var parentId="";
                if(hid.length == 0) //If this object is the root user, substitute id with "orgName" so the DB knows it's the name of organization and not a user
				{
					hidSTR = "orgName";
					var user = new getUser(userId,"0");
               
					hierarchy.push(user);
				}else{
           
                    if (parentLi.length != 0){
                       
                        parentId = parentLi.attr("dataid");
                    }
					for(var i=hid.length-1; i>=0; i--)
					{
						if(i != hid.length-1)
						{
							hidSTR = hidSTR+hid[i].id+",";
						}else{
							hidSTR = hidSTR+hid[i].id+'"';
						}
					}
				var user = getUser(userId,parentId);
	
					hierarchy.push(user);
				}
			});
			var tree= A.one('#<portlet:namespace />orgTree');
			A.one('#<portlet:namespace />orgTree').set('value',JSON.stringify(hierarchy));
			return hierarchy;
			
		}
		function getUser(userId,parentId)
        {
            var user = new Object();
            user.userId = userId;
            user.parentId = parentId;
            
            return user;
        }
		

		
        $(document).ready(function() {
        	var regx = /\w*(row)/;
        	
        	
            /* Custom jQuery for the example */
            $("#show-list").click(function(e){
                e.preventDefault();
                
                $('#list-html').toggle('fast', function(){
					$('#list-html').text($('#org').html());
					$("#org").bind("DOMSubtreeModified", function() {
						$('#list-html').text('');
						$('#list-html').text($('#org').html());
						prettyPrint();                
					});
                    if($(this).is(':visible')){
                        $('#show-list').text('Hide underlying list.');
                        $(".topbar").fadeTo('fast',0.9);
                    }else{
                        $('#show-list').text('Show underlying list.');
                        $(".topbar").fadeTo('fast',1);                  
                    }
                });
            });
            $(".del").live("click", function(e){
              var nodo=$(this);

              if(!nodo.parent().parent().hasClass("temp")){
                  var nodeDiv = nodo.parent().parent();
                  var cu = nodeDiv.find("a").attr("rel");
                  classList = nodeDiv.attr('class').split(/\s+/);
                  $.each(classList, function(index,item) {
                      if(item != "temp" && item != "node" && item != "child" && item != "ui-draggable" && item != "ui-droppable" && !regx.test(item) ){
                          del_node = item;
                          
                      }
                  });
                  var element = $("li."+del_node+":not('.temp, #upload-chart li')").removeAttr("class").addClass("node").addClass("child");
                  remChild(element);
                  init_tree();
              }

          });
            
            
            
        });
    function getData()
    {
         var responseData;
         A.io.request('<%=getUserURL %>',{
              method: 'GET',
              
              on: {
                  success: function(event, id, obj){
 						responseData = this.get('responseData');
 						loadjson(responseData);
   						init_tree();
 						
 						//<portlet:namespace/>updateDisplay(responseData.id);
 						
   
                   }
             },
             dataType: 'json'
        });
        
        
        
        
    
    }

        function init_tree(){
            var opts = {
                chartElement : '#chart',
                dragAndDrop  : true
            };
            $("#chart").html("");
            $("#org").jOrgChart(opts);
        }
		function scroll(){
		  $(".node").click(function(){
		  $("#chart").scrollTop(0)
		  $("#chart").scrollTop($(this).offset().top-140);
		})}
		
        var click_flag = true;
        var node_to_edit;
         // read json and convert to html formate
		function loadjson(jsonTree){
			var items = [];
            
            
            
            
            
        
            var data = TAFFY(jsonTree);
            
         
             
			 data({"parent":0}).each(function (record,recordnumber) {
			     
			     loops(record);
             });
			//start loop the json and form the html
			function loops(root){
                
                
				if (root.parent == ""){
				    // items.push("<li class='root unic" + root.id + " root' dataid='"+root.id + "' id='" + root.name + "'><span class='label_node'><a href='#'>" + root.name+"</a></br><i>"+ root.jobTitle+ "</i></span><div class='details'><p><strong>rank:</strong>" + root.rank+"</p><p><strong>department:</strong>" + root.department+"</p></div>");
		items.push("<li class='root unic" + root.id + " root' dataid='"+root.id + "'><span class='label_node'><a href='#'>" + root.name+"</a></br><i>"+ root.jobTitle+ "</i></span><div class='details'><p><strong>rank:</strong>" + root.rank+"</p><p><strong>department:</strong>" + root.department+"</p></div>");
		
                
                }
				else{
				//   items.push("<li class='child unic"+root.id+ "' dataid='" + root.id + "' id='" + root.name + "'><span class='label_node'><a href='#'>" + root.name+"</a></br><i>"+ root.jobTitle+ "</i></span><div class='details'><p><strong>rank:</strong>" + root.rank+"</p><p><strong>department:</strong>" + root.department+"</p></div>");
				items.push("<li class='child unic"+root.id+ "' dataid='" + root.id + "'><span class='label_node'><a href='#'>" + root.name+"</a></br><i>"+ root.jobTitle+ "</i></span><div class='details'><p><strong>rank:</strong>" + root.rank+"</p><p><strong>department:</strong>" + root.department+"</p></div>");
				
                }
				
                var c = data({"parent":root.id}).count();
				if (c != 0){
				  items.push("<ul>");
				  data({"parent":root.id}).each(function (record,recordnumber) {
					loops(record);
				  });
				 items.push("</ul></li>");
				}
				else{
				  items.push("</li>");
				}	
			}// End the generate html code
			
			//push to html code
			$( "<ul/>", {
			"id": "org",
			"style" : "float:right;",
			html: items.join( "" )
			}).appendTo( "#orgChartDisp" );
		}
		A.on('domready', function(event){
   			getData();
   			
		});
		
		function showUser(data)
		{
			var userList = $("#upload-chart");
			userList.empty();
			$.each(data,function(key,record)
			{
				userList.append($('<li>').attr('dataid',record.id).attr('class','node child ui-draggable').attr('id',record.name).append(
					$('<span>').attr('class','label_node').append(
						$('<a>').attr('href','#').append(record.name)
					
						).append('<br>').append($('<i>').append(record.jobTitle))
					
				
				
					)
				
				
				);
			
			});
			init_tree();
	
			
			
		
		}
		
		function updateUserList(event)
		{
			var searchWord = A.one('#<portlet:namespace/>keyword').val();
			
			if (searchWord.length < 3)
				return;
				
			A.io.request('<%=searchUserURL %>',
			{
            	method: 'GET',
              	data: {
              		keyword: searchWord		
              	},
              	on: {
                  	success: function(event, id, obj){
 						responseData = this.get('responseData');
 						showUser(responseData);
   		
                   }
             	},
             	dataType: 'json'
        	});
			
			
		}
		A.one('.<portlet:namespace />saveChart').on(
			'click',
			function(event) {
				event.preventDefault();
				makeArrays();
				A.io.request('<%=saveOrgTreeURL %>',{
              	method: 'POST',
              	data :{orgTree : JSON.stringify(makeArrays()),
              		data2 : 'data2',
              		data3 : 'data3'
              	
              	
              	},
              
              	on: {
                  	success: function(event, id, obj){
 						//var responseData = this.get('responseData');
 						
 						//<portlet:namespace/>updateDisplay(responseData.id);
 						
   
                   }
             },
             dataType: 'html'
        });
				
				
			}
		);
	
		
		A.one('#<portlet:namespace/><%=Constant.PARAMETER_KEYWORDS %>').on('valuechange', updateUserList);
      	
</aui:script>