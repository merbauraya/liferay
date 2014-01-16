<%@include file="/html/eprint/init.jsp" %>
detail.jsp
<%
	String eprintId = request.getParameter("eprintId");
	
    Eprint eprint = EprintLocalServiceUtil.fetchEprint(Long.parseLong(eprintId));
	out.print(eprintId);
%>
<div class="row">
	<div class="col-md-8">
		<table class="ep-detailview table table-bordered">
			<thead>
				<tr>
					<th colspan="2"><%=eprint.getTitle() %></th>
				</tr>
				
			</thead>
			<tbody>
				<tr>
					<td class="ep-td-label">Item Type</td>
					<td><%=eprint.getEprintType() %></td>
				
				</tr>
				<tr>
					<td class="ep-td-label">Abstract</td>
					<td><%=eprint.getEprintAbstract() %></td>
				
				</tr>
				<tr>
					<td class="ep-td-label">Date Deposited</td>
					<td>		<fmt:formatDate value="<%=eprint.getCreatedDate() %>"
			pattern="dd-MMM-yyyy" /></td>
				
				</tr>
				<tr>
					<td class="ep-td-label">Eprints URL</td>
					<td><%=eprint.getCreatedDate() %></td>
				
				</tr>
			</tbody>
		
		</table>
	</div>
	<div class="col-md-4"></div>
</div>