<%@ include file="/html/taglib/subur/init.jsp" %>
<%@ page import="java.lang.reflect.Method" %>
<%@ page import="java.lang.reflect.Array" %>
<%
String assetType = GetterUtil.getString((String)request.getAttribute("subur:item-categorization-filter:assetType"), "item");
PortletURL portletURL = (PortletURL)request.getAttribute("subur:item-categorization-filter:portletURL");

if (Validator.isNull(portletURL)) {
	portletURL = renderResponse.createRenderURL();
}


Map<Long, List<AssetCategory>> vocabularyCategories = new HashMap<Long, List<AssetCategory>>();

String categoryId = ParamUtil.getString(request, "categoryId");
String itemTypeId = ParamUtil.getString(request, "itemTypeId");

long[] assetCategoryIds = new long[0];
long[] itemTypeIds = new long[0];

String[] categoryIdsString = new String[0];
String[] itemTypeIdsString = new String[0];

if (Validator.isNotNull(categoryId)) {
  categoryIdsString = StringUtil.split(categoryId);
}

//process item type id
if (Validator.isNotNull(itemTypeId)){
	itemTypeIdsString = StringUtil.split(itemTypeId);
}
if (itemTypeIdsString.length == 1)
{
	long tId = Long.parseLong(itemTypeIdsString[0]);
	if (tId != 0L)
		itemTypeIds = new long[]{tId};
} else if (itemTypeIdsString.length > 1)
{
	List<Long> itemTypeIdsList = new ArrayList<Long>();
	for (String tIdString: itemTypeIdsString )
	{
		long tid = Long.parseLong(tIdString);
		if (tid != 0L)
			itemTypeIdsList.add(tid);
		
	}
	itemTypeIds =  ArrayUtil.toLongArray(itemTypeIdsList);
}
//process category
if(categoryIdsString.length == 1) {
  
  long assetCategoryId = Long.parseLong(categoryIdsString[0]);
  
  if (assetCategoryId != 0L) {
	
    AssetCategory assetCategory = AssetCategoryLocalServiceUtil.getAssetCategory(assetCategoryId);
    
    vocabularyCategories.put(assetCategory.getVocabularyId(), Arrays.asList(assetCategory));
    
    assetCategoryIds = new long[]{assetCategoryId};
  }
} else if (categoryIdsString.length > 1) {
  
  	List<Long> assetCategoryIdsList = new ArrayList<Long>();

	for(String categoryIdString : categoryIdsString) {
	     
	  	long id = Long.parseLong(categoryIdString);
	  	
	  	if (id != 0L) {
	  
	  		AssetCategory assetCategory = AssetCategoryLocalServiceUtil.getAssetCategory(id);
	  	  
	  		if (!vocabularyCategories.containsKey(assetCategory.getVocabularyId())) {
	  			vocabularyCategories.put(assetCategory.getVocabularyId(), new ArrayList<AssetCategory>());
	  		}
	  		((List)vocabularyCategories.get(assetCategory.getVocabularyId())).add(assetCategory);
	  		
	  		assetCategoryIdsList.add(id);
	  	}
	}
	
	assetCategoryIds = ArrayUtil.toLongArray(assetCategoryIdsList);
}

String assetTagName = ParamUtil.getString(request, "tag", StringPool.BLANK);

String[] assetTagNames = StringUtil.split(assetTagName);



%>


<c:if test="<%= !vocabularyCategories.isEmpty() %>">

	<%
	

	
	StringBuilder assetCategoriesTitle = new StringBuilder();
	
	for (Long vocabularyId : vocabularyCategories.keySet()) {
	  AssetVocabulary assetVocabulary = AssetVocabularyLocalServiceUtil.getVocabulary(vocabularyId);
	  assetVocabulary = assetVocabulary.toEscapedModel();
	%>
	
	<liferay-util:buffer var="removeCategory">
	
	<%  
	  List<AssetCategory> assetCategories = vocabularyCategories.get(vocabularyId);
	  for (AssetCategory assetCategory : assetCategories) {
	    assetCategory = assetCategory.toEscapedModel();
	    
	    List<AssetCategory> ancestorCategories = assetCategory.getAncestors();

		Collections.reverse(ancestorCategories);
		
		StringBuilder assetCategoryTitle = new StringBuilder();
		
	    for (AssetCategory ancestorCategory : ancestorCategories) {
	    	assetCategoryTitle.append(ancestorCategory.getTitle(locale) + " &raquo; ");
	    }
	    
		assetCategoryTitle.append(assetCategory.getTitle(locale));
		
		assetCategoriesTitle.append(assetCategoryTitle).append(StringPool.SPACE);
	%>
		<span class="asset-entry">
			<%= assetCategoryTitle.toString() %>

			<portlet:renderURL var="viewURLWithoutCategory">
				<portlet:param name="categoryId" value="<%=StringUtil.merge(ArrayUtil.remove(
				    assetCategoryIds, assetCategory.getCategoryId()))  %>" />
			</portlet:renderURL>

			<a href="<%= viewURLWithoutCategory %>" title="<liferay-ui:message key="remove" />">
				<span class="icon icon-close textboxlistentry-close"></span>
			</a>
		</span>
	<%
	  }
	%>	
	</liferay-util:buffer>
	
	<h2 class="taglib-categorization-filter entry-title">
		<liferay-ui:message arguments="<%= new String[] {assetVocabulary.getTitle(locale), removeCategory} %>" key='<%= assetType.concat("-with-x-x") %>' />
	</h2>
	<%
	}
	
	PortalUtil.addPageKeywords(assetCategoriesTitle.toString().replaceAll(" &raquo; ", StringPool.SPACE),
			request);
	
	PortalUtil.addPortletBreadcrumbEntry(request, 
	    assetCategoriesTitle.toString().replaceAll(" &raquo; ", StringPool.SPACE), currentURL);
	
	
	%>
	
</c:if>

<c:if test="<%= Validator.isNotNull(assetTagName) %>">

	<%
		StringBuilder assetTagsTitle = new StringBuilder();
	%>

	<liferay-util:buffer var="removeTag">
		<%
		for (String tagName : assetTagNames) {
		  assetTagsTitle.append(tagName).append(StringPool.SPACE);
		%>
			<span class="asset-entry">
				<%= HtmlUtil.escape(tagName) %>
	
				<liferay-portlet:renderURL allowEmptyParam="<%= true %>" var="viewURLWithoutTag">
					<liferay-portlet:param name="tag" value="<%=StringUtil.merge(ArrayUtil.remove(
					    assetTagNames, tagName))  %>" />
				</liferay-portlet:renderURL>
	
				<a href="<%= viewURLWithoutTag %>" title="<liferay-ui:message key="remove" />">
					<span class="icon icon-close textboxlistentry-close"></span>
				</a>
			</span>
		<%
		}
		%>
	</liferay-util:buffer>
		
	<h2 class="taglib-categorization-filter entry-title">
		<liferay-ui:message arguments="<%= removeTag %>" key='<%= assetType.concat("-with-tag-x") %>' />
	</h2>
	
	<%
	
	PortalUtil.addPageKeywords(assetTagsTitle.toString(), request);
	
	PortalUtil.addPortletBreadcrumbEntry(request, assetTagsTitle.toString(), currentURL);
	
	
	%>
	
</c:if>
<c:if test="<%= itemTypeIds.length > 0 %>">
<%
	StringBuilder itemTypeTitle = new StringBuilder();
	
%>
	<liferay-util:buffer var="removeItemType">
<%
	Object itemTypeService  = (Object)PortletBeanLocatorUtil.locate("Subur-portlet","ItemTypeLocalService");
	Method getItemTypeMethod = itemTypeService.getClass().getMethod("fetchItemType",new Class[]{long.class});

	for (long typeId : itemTypeIds)
	{

		
		Object itemType =  getItemTypeMethod.invoke(itemTypeService,typeId);
		String typeName = (String)itemType.getClass().getMethod("getItemTypeName", null).invoke(itemType);
		itemTypeTitle.append(typeName).append(StringPool.SPACE);
%>
		<span class="asset-entry">
				<%= HtmlUtil.escape(typeName) %>
	
				<liferay-portlet:renderURL allowEmptyParam="<%= true %>" var="viewURLWithoutType">
					<liferay-portlet:param name="itemTypeId" value="<%=StringUtil.merge(ArrayUtil.remove(
							itemTypeIds, typeId))  %>" />
				</liferay-portlet:renderURL>
	
				<a href="<%= viewURLWithoutType %>" title="<liferay-ui:message key="remove" />">
					<span class="icon icon-close textboxlistentry-close"></span>
				</a>
			</span>


<%
	}
%>
	</liferay-util:buffer>
	<h2 class="taglib-categorization-filter entry-title">
			<liferay-ui:message arguments="<%= removeItemType %>" key='<%= assetType.concat("-with-type-x") %>' />
	
	</h2>
</c:if>