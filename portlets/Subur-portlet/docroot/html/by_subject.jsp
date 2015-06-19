<%@ include file="/html/init.jsp" %>
<%
	int columnCount = 3;
	int rowPerColumn = 30; // default subject per column display
	
	List<Subject> subjects = SubjectLocalServiceUtil.getDepositable();
	int subjectCount = subjects.size();
	String subjectNameAnchor = StringPool.BLANK;
	for (Subject subject : subjects)
	{
		String curSubjectNameAnchor = StringUtil.upperCase(subject.getSubjectName().substring(0,1));
	
%>
	<c:if test="<%= !curSubjectNameAnchor.equals(subjectNameAnchor) %>">
		<% subjectNameAnchor =curSubjectNameAnchor ; %>
		
		<div class="subject-name-anchor">
			<a><%=subjectNameAnchor %></a>
		</div>
	</c:if>
	<liferay-portlet:renderURL var="viewSubject">
		<portlet:param name="mvcPath" value="/html/browse.jsp" />
		<portlet:param name="subjectId" value="<%= String.valueOf(subject.getSubjectId()) %>" />
		
	</liferay-portlet:renderURL>
	
	<div class="subject-name">
		<a href="<%=viewSubject.toString() %>">
			<%=subject.getSubjectName()%> (<%=subject.getItemCount() %>)
		</a>
	</div>
	



<%
	}
%>


