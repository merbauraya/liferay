<%@include file="/html/eprint/init.jsp" %>
<%
	Eprint eprint = (Eprint)request.getAttribute("eprint");
	String socialBookmarksDisplayStyle = "horizontal";
	String eprintUrl = (String)request.getAttribute("eprintUrl");
	request.setAttribute("eprint", eprint);
	AssetEntry assetEntry = (AssetEntry)request.getAttribute("view_entry_content.jsp-assetEntry");

%>
	<portlet:renderURL var="viewEntryURL">
					<portlet:param name="jspPage" value="/blogs/view_entry" />
					
					<portlet:param name="urlTitle" value="<%= eprint.getUrlTitle() %>" />
				</portlet:renderURL>
<portlet:renderURL var="bookmarkURL" windowState="<%= WindowState.NORMAL.toString() %>">
				<portlet:param name="eprintId" value="<%= String.valueOf(eprint.getPrimaryKey()) %>" />
				<portlet:param name="urlTitle" value="<%= eprint.getTitle() %>" />
			</portlet:renderURL>



<div class="ep-detail-wrapper">
	<c:choose>
		<c:when test="<%=Validator.isNotNull(eprint) %>">
		<liferay-ui:header
			
			localizeTitle="<%= false %>"
			title="<%= eprint.getTitle() %>"
			/>
		
			<div class="entry-content">
				<div class="entry-date-img">
					<span class="aui-helper-hidden-accessible"><liferay-ui:message key="published-date" /></span>

					<%= dateFormatDateTime.format(eprint.getCreatedDate()) %>
				</div>
			
			</div>
			<jsp:include page="/html/eprintview/display/top_links.jsp"></jsp:include>
			<div class="entry-body">
				<div class="ep-abs-title">
				Abstract
				</div>
				<%=eprint.getEprintAbstract() %>
				<div class="ep-link">
					<a target="_blank" href="<%=eprintUrl %>">Read Full Content</a>
				</div>
			</div>
			<div class="entry-footer">
			<div class="entry-author">
					<liferay-ui:message key="written-by" /> <%= HtmlUtil.escape(PortalUtil.getUserName(eprint)) %>
				</div>
				<div class="stats">
					<c:if test="<%= eprint != null %>">
						<span class="view-count">
							<c:choose>
								<c:when test="<%= assetEntry.getViewCount() == 1 %>">
									<%= assetEntry.getViewCount() %> <liferay-ui:message key="view" />,
								</c:when>
								<c:when test="<%= assetEntry.getViewCount() > 1 %>">
									<%= assetEntry.getViewCount() %> <liferay-ui:message key="views" />,
								</c:when>
							</c:choose>
						</span>
					
						<c:if test="<%= enableComments %>">
							<span class="comments">
	
								<%
								long classNameId = PortalUtil.getClassNameId(Eprint.class.getName());
	
								int messagesCount = MBMessageLocalServiceUtil.getDiscussionMessagesCount(classNameId, eprint.getEprintId(), WorkflowConstants.STATUS_APPROVED);
								%>
								<%= messagesCount %> <liferay-ui:message key='<%= (messagesCount == 1) ? "comment" : "comments" %>' />
								
							</span>
						</c:if>
					</div>
					<c:if test="<%= enableFlags %>">
						<liferay-ui:flags
							className="<%= Eprint.class.getName() %>"
							classPK="<%= eprint.getEprintId() %>"
							contentTitle="<%= eprint.getTitle() %>"
							reportedUserId="<%= eprint.getUserId() %>"
						/>
					</c:if>
	
					<span class="entry-categories">
						<liferay-ui:asset-categories-summary
							className="<%= Eprint.class.getName() %>"
							classPK="<%= eprint.getEprintId() %>"
							portletURL="<%= renderResponse.createRenderURL() %>"
						/>
					</span>
	
					<span class="entry-tags">
						<liferay-ui:asset-tags-summary
							className="<%= Eprint.class.getName() %>"
							classPK="<%= eprint.getEprintId() %>"
							portletURL="<%= renderResponse.createRenderURL() %>"
						/>
					</span>
					<c:if test="<%= enableRatings %>">
						<liferay-ui:ratings
							className="<%= Eprint.class.getName() %>"
							classPK="<%= eprint.getEprintId() %>"
						/>
					</c:if>
				
				<c:if test="<%= showRelatedAssets %>">
					<liferay-ui:asset-links
						assetEntryId="<%= eprint.getPrimaryKey() %>"
						className="<%= Eprint.class.getName() %>"
						classPK="<%= eprint.getPrimaryKey() %>"
							/>
				</c:if>
			</c:if>
		</div>
	</c:when>
	</c:choose>
	</div>
			
	