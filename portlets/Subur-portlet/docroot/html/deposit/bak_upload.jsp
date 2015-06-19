<%@ include file="/html/item.jsp"%>
<portlet:resourceURL id="<%=SuburConstant.RESOURCE_UPLOAD_FILE %>" var="FileUploadResourceUrl">
	<portlet:param name="resource" value="upload" />
</portlet:resourceURL>
<portlet:actionURL name="depositItem" var="depositItemURL"/>


    <aui:input type="file" name="myFile" label="My File" multiple="true"></aui:input>
    <aui:button type="submit" name="btnUploadFile" value="Upload File"></aui:button>

<div id="files-list">


	<table id="fileUploadList">
		<thead>
			<tr>
				<th>File Name</th>
				<th>File Size</th>
				<th>File Id</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</div>
<aui:script>
AUI().use(
	    'aui-io-request','aui-datatable','aui-node',
	    function(A){
	    	var btnUploadFile = A.one("#<portlet:namespace />btnUploadFile");
	        
	    	btnUploadFile.on("click", uploadFile);
	    	function uploadFile(event){
	    	    event.preventDefault();
	    	    var myForm = A.one("#<portlet:namespace/>fm");
	    	    var ajaxURL = "<portlet:resourceURL id='<%=SuburConstant.RESOURCE_UPLOAD_FILE%>'></portlet:resourceURL>";
	    	    
	    	    var configs = {
	    	        method: 'POST',
	    	        dataType: 'json',
	    	        form: {
	    	            id: myForm,
	    	            upload: true
	    	        },
	    	        sync: true,
	    	        on: {
	    	            
	    	            	complete: function(event,id,obj){    
		    	                //console.log(obj.responseText);
		    	                var messages = A.JSON.parse(obj.responseText);
		    	                //console.log(event);
		    	                //console.log(id);
		    	                //console.log(obj);
		    	                //console.log(messages);
		    	                //console.log(messages.fileName);
		    	                displayFiles(messages);
	    	            }
	    	        },
	    	 
	    	    };
	    	    
	    	    A.io.request(ajaxURL, configs); 
	    	

	};
	function displayFiles(result){
        
        console.log(result);
		//var ajaxURL = "<portlet:resourceURL id='FILES_LIST'></portlet:resourceURL>";
        var tableFileList = A.one(document.getElementById('files-list')).getElementsByTagName('table');
        //var tableFileList = .getElementsByTagName('table');
        // A.one("#fileUploadList");
       // console.log(tableFileList);
        tableHeaders = tableFileList.one('thead').one('tr').all('th'),
        console.log(tableHeaders);
        columns = [],
        i = 0;
      	tableHeaders.each(function(node) {
        	columns[i++] = node.get('innerHTML');
      	});
      	console.log(columns);
      	var tableRows = tableFileList.one('tbody').all('tr'),
        data = [],
        i = 0;
      	tableRows.each(function(node) {
        	var row = node.all('td'),
          	rowData = {},
          	j = 0;
        	row.each(function(node) {
          		rowData[columns[j++]] = node.get('innerHTML');
        	});
        	data[i++] = rowData;
     	 });
      	tableFileList.remove(true);
      	var dataTable = new A.DataTable.Base(
      	      {
      	        columnset: columns,
      	        recordset: data
      	    
      	      }
      	    ).render("#files-list");
      	
      	
        //console.log(tableFileList);
       
        if (result.status=="success")
        	{
        		data.push({"File Name":	result.fileName,
        					"File size": result.fileSize,
        					"File Id": result.fileId})
        		
        		//console.log(dataTable);
        		
        }else
        {
        	data.push({"Filename":	"Error uploading file...",
				"Filesize": "0",
				"FileID": ""})
        } 
        console.log(data);
        dataTable.set('recordset',data);
        dataTable.render("#files-list");
        /*
        var configs = {
            
            on: {
                success: function(){
                    var response = result;
                    tableFileList = A.one("#fileList");
                    console.log(tableFileList);
                    
                    filesList.set("innerHTML", response);
                }
            }
        };
        
        A.io.request(ajaxURL, configs); */
    }


   
});


</aui:script>