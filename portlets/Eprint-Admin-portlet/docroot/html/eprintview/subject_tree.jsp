<%@ include file="/html/eprint/init.jsp" %>
<%@ page import="com.idetronic.eprint.service.EprintStaticContentLocalServiceUtil" %>
<%@ page import="com.idetronic.eprint.model.EprintStaticContent" %>
<%
	EprintStaticContent ep = EprintStaticContentLocalServiceUtil.fetchEprintStaticContent(EprintConstant.KEY_BY_SUBJECT_TREE);
	
%>



<c:choose>
	<c:when test="<%=(Validator.isNotNull(ep))%>">
		<%=ep.getContent() %>
	</c:when>
	<c:otherwise>
		<div class="alert alert-danger">
			<strong>Error retrieving subject tree. Please contact system administrator</strong>
		</div>
	</c:otherwise>
</c:choose>
