<%@ include file="/html/eprint/init.jsp" %>



<%
	String nav = (String)request.getAttribute("nav");
%>

<c:choose>
	<c:when test="<%=(Validator.isNotNull(nav))%>">
		<%=nav %>
	</c:when>
	<c:otherwise>
		<div class="alert alert-danger">
			<strong>Error retrieving subject tree. Please contact system administrator</strong>
		</div>
	</c:otherwise>
</c:choose>
