<%@include file="/html/init.jsp"%>

<%
	String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />
<aui:form action="<%= configurationActionURL  %>" method="post" name="fm">
	<aui:fieldset label="asset-selection">
		<aui:input checked='<%= itemToShow.equals("latest") %>' id="itemToShowLatest" label="show-latest" name="preferences--itemToShow--" onChange='<%= renderResponse.getNamespace() + "chooseSelectionStyle();" %>' type="radio" value="latest" />

		<aui:input checked='<%= itemToShow.equals("popular") %>' id="itemToShowPopular" label="show-popular" name="preferences--itemToShow--" onChange='<%= renderResponse.getNamespace() + "chooseSelectionStyle();" %>' type="radio" value="popular" />
	</aui:fieldset>
	<aui:fieldset label="display-style">
		<aui:select name="preferences--displayStyle--">
			<aui:option label="list" value="list" selected='<%=displayStyle.equals("list") %>' />
			<aui:option label="table" value="table" selected='<%=displayStyle.equals("table") %>' />
			<aui:option label="abstract" value="abstract" selected='<%=displayStyle.equals("abstract") %>' />
			
		
		</aui:select>
		<aui:select helpMessage="number-of-items-to-display-help" label="number-of-items-to-display" name="preferences--delta--">
		
			<%
				int[] pageDelta = {5,10,15,20};
				for (int currentDelta : pageDelta) {
			%>
	
				<aui:option label="<%= currentDelta %>" selected="<%= (delta == currentDelta) %>" />
	
			<%
			}
			%>

		</aui:select>
		
		<aui:select name="preferences--paginationType--">
			<aui:option label="none" selected='<%= paginationType.equals("none") %>' />
			<aui:option label="simple" selected='<%= paginationType.equals("simple") %>' />
			<aui:option label="regular" selected='<%= paginationType.equals("regular") %>' />
		</aui:select>
	
	</aui:fieldset>
	<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="assetPublisherOrderingAndGroupingPanel" persistState="<%= true %>" title="ordering-and-grouping">
		<aui:fieldset>
			<span class="field-row">
				<aui:select inlineField="<%= true %>" inlineLabel="left" label="order-by" name="preferences--orderByColumn1--">
					
					<aui:option label="title" selected='<%= orderByColumn1.equals("title") %>' />
					<aui:option label="create-date" selected='<%= orderByColumn1.equals("createDate") %>' value="createDate" />
					<aui:option label="modified-date" selected='<%= orderByColumn1.equals("modifiedDate") %>' value="modifiedDate" />
					<aui:option label="publish-date" selected='<%= orderByColumn1.equals("publishDate") %>' value="publishDate" />
					<aui:option label="priority" selected='<%= orderByColumn1.equals("priority") %>' value="priority" />

					
				</aui:select>

				<aui:select inlineField="<%= true %>" label="" name="preferences--orderByType1--">
					<aui:option label="ascending" selected='<%= orderByType1.equals("ASC") %>' value="ASC" />
					<aui:option label="descending" selected='<%= orderByType1.equals("DESC") %>' value="DESC" />
				</aui:select>
			</span>
			<span class="field-row">
				<aui:select inlineField="<%= true %>" inlineLabel="left" label="and-then-by" name="preferences--orderByColumn2--">
					<aui:option label="title" selected='<%= orderByColumn2.equals("title") %>' />
					<aui:option label="create-date" selected='<%= orderByColumn2.equals("createDate") %>' value="createDate" />
					<aui:option label="modified-date" selected='<%= orderByColumn2.equals("modifiedDate") %>' value="modifiedDate" />
					<aui:option label="publish-date" selected='<%= orderByColumn2.equals("publishDate") %>' value="publishDate" />
					<aui:option label="priority" selected='<%= orderByColumn2.equals("priority") %>' value="priority" />

					
				</aui:select>

				<aui:select inlineField="<%= true %>" label="" name="preferences--orderByType2--">
					<aui:option label="ascending" selected='<%= orderByType2.equals("ASC") %>' value="ASC" />
					<aui:option label="descending" selected='<%= orderByType2.equals("DESC") %>' value="DESC" />
				</aui:select>
			</span>
		
		</aui:fieldset>
	
	
	</liferay-ui:panel>
	<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="suburSubscriptionPanel" persistState="<%= true %>" title="subscription">
			
		<c:if test="<%= PortalUtil.isRSSFeedsEnabled() %>">
			<liferay-ui:rss-settings
				delta="<%= rssDelta %>"
				displayStyle="<%= rssDisplayStyle %>"
				displayStyles="<%= new String[] {RSSUtil.DISPLAY_STYLE_ABSTRACT, RSSUtil.DISPLAY_STYLE_TITLE} %>"
				enabled="<%= enableRSS %>"
				feedType="<%= rssFeedType %>"
				name="<%= rssName %>"
				nameEnabled="<%= true %>"
			/>
		</c:if>
				
	</liferay-ui:panel>
	<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="suburDisplayMultipleTagCategoriesPanel" persistState="<%= true %>" title="multiple-tag-and-categories-display">
			
		<aui:input value="<%= useOrOperatorCategorySearch %>" type="checkbox" label="use-or-operator-between-category-search-instead-of-and-operator" name="preferences--useOrOperatorCategorySearch--" />
		<aui:input value="<%= useOrOperatorTagSearch%>" type="checkbox" label="use-or-operator-between-tag-search-instead-of-and-operator" name="preferences--useOrOperatorTagSearch--" />
				
	</liferay-ui:panel>
	<div class="button-holder">
		<aui:button type="submit" value="save"></aui:button>
	</div>
</aui:form>