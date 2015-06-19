<%
	Division div = (Division)node.data;

%>
<c:if test="<%= !div.getDepositable()  %>">
	<optgroup label="<%=div.getDivisionName()%>">

</c:if>
<%
	
	if (node.hasChildren())
	{
		buildNode(node,level);	
	
	
	}
%>
<c:if test="<%= !div.getDepositable()  %>">
	</optgroup>

</c:if>

<%!
	private void buildNode(TreeNode node,int level)
	{
		for (int i = 0;i<node.getNumberOfChildren();i++)
				{
					Division div = (Division)node.getChildAt(i).data;
					System.out.print("<option>"+div.getDivisionName()+"</option>");
					
					buildNode(node.getChildAt(i),level+1);
				}
	
	}

%> 
