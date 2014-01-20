<%@include file="/html/eprint/init.jsp" %>

<%
	String eprintId = request.getParameter("eprintId");
	EprintConfig eprintConfig = (EprintConfig)request.getAttribute("eprintConfig");
    Eprint eprint = EprintLocalServiceUtil.fetchEprint(Long.parseLong(eprintId));
	String eprintUrl = null;
	if (Validator.isNotNull(eprint))
	{
		eprintUrl = eprintConfig.getEprintURL() + eprint.getEprintId();
		com.liferay.portal.util.PortalUtil.setPageTitle(eprint.getTitle(), request); 
	}
%>
<% 
	
%>
<div class="container">
	<c:choose>
		<c:when test="<%=Validator.isNotNull(eprint) %>">
			<table class="ep-detailview table table-bordered">
			<thead>
			<tr>
				<th colspan="2">
					<%=eprint.getTitle() %>
				</th>
			</tr>
			</thead>
			<tbody>
			<tr>
				<td class="ep-td-label">
					Item Type
				</td>
				<td>
					<%=eprint.getEprintType() %>
				</td>
			</tr>
			<tr>
				<td class="ep-td-label">
					Abstract
				</td>
				<td>
					<%=eprint.getEprintAbstract() %>
				</td>
			</tr>
			<tr>
				<td class="ep-td-label">
					Keywords
				</td>
				<td>
					<%=eprint.getEprintKeywords() %>
				</td>
			</tr>
			<tr>
				<td class="ep-td-label">
					Date Deposited
				</td>
				<td>
					<fmt:formatDate value="<%=eprint.getCreatedDate() %>" pattern="dd-MMM-yyyy" />
				</td>
			</tr>
			<tr>
				<td class="ep-td-label">
					Eprints URL
				</td>
				<td>
					<a target="_blank" href="<%=eprintUrl %>"><%=eprintUrl %>
					
					</a>
				</td>
			</tr>
			</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<div class="alert alert-danger">
				<strong>Error retrieving repository information.</strong>
			</div>
		</c:otherwise>
	</c:choose>
</div>
