
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portlet.asset.NoSuchVocabularyException"%>
<%@page import="com.liferay.portlet.portletdisplaytemplate.util.PortletDisplayTemplateUtil"%>
<%@page import="javax.portlet.RenderResponse"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.ArrayUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>

<%@ include file="/html/multi_categories/init.jsp" %>

<%

boolean hidePortletWhenEmpty = true;

long[] vocabularyIds = null;

if(allAssetVocabularies) {
  vocabularyIds = availableAssetVocabularyIds;
} else {
  vocabularyIds = assetVocabularyIds;
}

String categoryId = ParamUtil.getString(request, "categoryId", StringPool.BLANK);
if (categoryId.equals("0")) {
  categoryId = StringPool.BLANK;
}
String treeBoxId =renderResponse.getNamespace() + "taglibMultiAssetCategoriesNavigationPanel";

	
String[] categoryIds = StringUtil.split(categoryId);

%>

<%
long portletDisplayDDMTemplateId = PortletDisplayTemplateUtil.getPortletDisplayTemplateDDMTemplateId(displayStyleGroupId, displayStyle);

%>

<c:choose>
	<c:when test="<%= portletDisplayDDMTemplateId > 0 %>">

		<%
		List<AssetVocabulary> ddmTemplateAssetVocabularies = new ArrayList<AssetVocabulary>();

		if (allAssetVocabularies) {
			ddmTemplateAssetVocabularies = assetVocabularies;
		}
		else {
			for (long assetVocabularyId : assetVocabularyIds) {
				try {
					ddmTemplateAssetVocabularies.add(AssetVocabularyServiceUtil.getVocabulary(assetVocabularyId));
				}
				catch (NoSuchVocabularyException nsve) {
				}
			}
		}
		%>

		<%= PortletDisplayTemplateUtil.renderDDMTemplate(pageContext, portletDisplayDDMTemplateId, ddmTemplateAssetVocabularies) %>
	</c:when>
	<c:otherwise>
		
		<liferay-ui:panel-container cssClass="taglib-asset-categories-navigation" extended="<%= true %>"
			 id='<%= renderResponse.getNamespace() + "taglibMultiAssetCategoriesNavigationPanel" %>' 
			 persistState="<%= true %>">
		
			<%
			for (int i = 0; i < vocabularyIds.length; i++) {
				AssetVocabulary vocabulary = AssetVocabularyLocalServiceUtil.getAssetVocabulary(vocabularyIds[i]);
		
				vocabulary = vocabulary.toEscapedModel();
		
				String vocabularyNavigation = _buildVocabularyNavigation(renderResponse,
				    vocabulary, categoryIds, themeDisplay, selectRootCategory);
		
				if (Validator.isNotNull(vocabularyNavigation)) {
					hidePortletWhenEmpty = false;
			%>
					<c:choose>
						<c:when test="<%= singleVocab %>">
							<div id="<%=treeBoxId %>">
								<%= vocabularyNavigation %>
							</div>
						</c:when>
						<c:otherwise>
							<liferay-ui:panel defaultState="close" collapsible="<%= true %>" extended="<%= true %>" persistState="<%= true %>" 
								title="<%= vocabulary.getTitle(locale) %>">
								<%= vocabularyNavigation %>
							</liferay-ui:panel>
						
						</c:otherwise>
					
					</c:choose>
					
					
		
			<%
				}
			}
			%>
		
		</liferay-ui:panel-container>
		
		<%
		if (hidePortletWhenEmpty) {
			renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
		%>
		
			<div class="alert alert-info">
				<liferay-ui:message key="there-are-no-categories" />
			</div>
		
		<%
		}
		
		%>
		
		<aui:script use="aui-tree-view">
			
			var treeViews = A.all('#<%= renderResponse.getNamespace() %>taglibMultiAssetCategoriesNavigationPanel .lfr-asset-category-list-container');
			
			treeViews.each(
				function(item, index, collection) {
					var assetCategoryList = item.one('.lfr-asset-category-list');
		
					var treeView = new A.TreeView(
						{
							boundingBox: item,
							contentBox: assetCategoryList,
							type: 'normal'
						}
					).render();
		
					assetCategoryList.all('.tree-node .tag-selected').each(
						function(item, index, collection) {
					
							var selectedChild = treeView.getNodeByChild(item);
			
							selectedChild.expand();
			
							selectedChild.eachParent(
								function(node) {
									if (node instanceof A.TreeNode) {
										node.expand();
									}
								}
							);
						}
					);
				}
			);
		</aui:script>
		
		<%!
		private void _buildCategoriesNavigation(RenderResponse renderResponse, 
		    List<AssetCategory> categories, String[] categoryIds, ThemeDisplay themeDisplay,
		    boolean selectRootCategory, StringBundler sb) throws Exception {
		  
			for (AssetCategory category : categories) {
				category = category.toEscapedModel();
		
				String title = category.getTitle(themeDisplay.getLocale());
		
				List<AssetCategory> categoriesChildren = AssetCategoryServiceUtil.getChildCategories(
				    category.getCategoryId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
				
				sb.append("<li class=\"tree-node\"><span>");
				
				boolean selezionato = ArrayUtil.contains(categoryIds, String.valueOf(category.getCategoryId()));
		
				if (selezionato) {
				  
				  sb.append("<a class=\"tag-selected\" href=\"");
				}
				else {
		
				  sb.append("<a href=\"");
				}
		
				String href = null;
				if (!categoriesChildren.isEmpty() && !selectRootCategory) {
					href = "javascript:";
				}
				else {
				  PortletURL portletURL = renderResponse.createActionURL();
				  
				  String categoryId = null;
				  if (selezionato) {
				    categoryId = StringUtil.merge(ArrayUtil.remove(categoryIds,
				        String.valueOf(category.getCategoryId())));
				  }
				  else {
				    categoryId = StringUtil.merge(ArrayUtil.append(categoryIds,
				        String.valueOf(category.getCategoryId())));
				  }
				  
				  portletURL.setParameter("categoryIds", categoryId);
				  
				  href = portletURL.toString();
				}
		
				sb.append(HtmlUtil.escape(href));
				sb.append("\">");
				sb.append("<span>&nbsp;</span>");
				sb.append(title);
				sb.append("</a>");
				sb.append("</span>");
		
				if (!categoriesChildren.isEmpty()) {
					sb.append("<ul>");
		
					_buildCategoriesNavigation(renderResponse, categoriesChildren, categoryIds,
							themeDisplay, selectRootCategory, sb);
		
					sb.append("</ul>");
				}
		
				sb.append("</li>");
			}
		}
		
		private String _buildVocabularyNavigation(RenderResponse renderResponse, AssetVocabulary vocabulary,
		    String[] categoryIds, ThemeDisplay themeDisplay, boolean selectRootCategory) throws Exception {
		   
			
			List<AssetCategory> categories = AssetCategoryServiceUtil.getVocabularyRootCategories(
			    vocabulary.getGroupId(), vocabulary.getVocabularyId(),
			    QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
		
			if (categories.isEmpty()) {
				return null;
			}
		
			StringBundler sb = new StringBundler();
		
			sb.append("<div class=\"lfr-asset-category-list-container\"><ul class=\"lfr-asset-category-list\">");
		
			_buildCategoriesNavigation(renderResponse, categories, categoryIds, themeDisplay, selectRootCategory, sb);
		
			sb.append("</ul></div>");
			
			return sb.toString();
		}
		%>
	</c:otherwise>
</c:choose>

