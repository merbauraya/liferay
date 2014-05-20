<%@ include file="/html/eventview/init.jsp" %>
<%
	
%>
<c:if test="<%=viewConfig.getShowInternalTitle() %>">
	<div class="ev-view-title">
		<%=viewConfig.getInternalTitle() %>
	</div>

</c:if>
<c:if test="<%=viewType == EventViewConstant.VIEW_MONTH_VIEW %>">
	<jsp:include page="/html/eventview/monthview.jsp"/>
</c:if>
<c:if test="<%=viewType == EventViewConstant.VIEW_UPCOMING_EVENT %>">
	<jsp:include page="/html/eventview/upcomingview.jsp"/>
</c:if>