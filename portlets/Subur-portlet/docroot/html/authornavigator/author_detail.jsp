
<div class="author-detail">
	<div class="author-info">
		<p>Profile Information</p>
	</div>
	<div class="author-summary">
		<h2><%= author.getDisplayName()%></h2>
		<div class="author-bio">
			<div class="author-title">
				<p><span class="title">Title : </span>
				<%=author.getTitle() %>
				</p>
			</div>
			<div class="author-contrib">
				<p><span class="title">Published Item : </span>
				<%=author.getItemCount() %>
				</p>
			
			</div>
			<div class="author-expertise">
				<span class="title">Research Interest </span>
				<c:if test="<%=expertises.size() > 0 %>">
					<ul class="taglib-categorization-filter">
						<%	for (Expertise expertise : expertises) 
							{	
						%>
								<li class="asset-entry"><%=expertise.getExpertiseName() %>
						<%
						
							}
						%>
					</ul>
				
				</c:if>	
				
				
				
			
			</div>
		</div>
	</div>
	
<%
	
String tabs2Names = "biodata,publication,organization";
%>

</div>
<liferay-ui:tabs
	names="<%= tabs2Names %>"
	refresh="<%= false %>"
	>
	<liferay-ui:section>
		<%@ include file="/html/authornavigator/biodata.jsp" %>
	</liferay-ui:section>
	
	<liferay-ui:section>
		<%@ include file="/html/authornavigator/publication.jsp" %>
	</liferay-ui:section>
	
	<liferay-ui:section>
		<%@ include file="/html/authornavigator/organization.jsp" %>
	</liferay-ui:section>
	

</liferay-ui:tabs>	
	
	