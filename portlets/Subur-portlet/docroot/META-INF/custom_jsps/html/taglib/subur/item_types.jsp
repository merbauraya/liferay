<%@ include file="/html/taglib/subur/init.jsp" %>
<%@ page import="java.lang.reflect.Method" %>
<%@ page import="java.lang.reflect.Array" %>

<%
	long itemId = GetterUtil.getLong((String)request.getAttribute("subur:item-itemtype-display:itemId"));
	
	PortletURL viewItemTypeURL =(PortletURL) request.getAttribute("subur:item-itemtype-display:viewItemTypeURL");
	boolean showHeader = GetterUtil.getBoolean(request.getAttribute("subur:item-itemtype-display:showHeader"));
	
	Object itemItemType  = (Object)PortletBeanLocatorUtil.locate("Subur-portlet","ItemItemTypeLocalService");

	Method getItemItemType = itemItemType.getClass().getMethod("getByItemIdArray",new Class[]{long.class});

	Object itemTypes =  getItemItemType.invoke(itemItemType,itemId);
	
	Class type = itemTypes.getClass();
	Object itemTypeList = null; 
	
	if (type.isArray())
	{
		int length = Array.getLength(itemTypes);
		  
	     Class componentType = type.getComponentType();
	     itemTypeList = Array.newInstance(componentType, length);
	     for (int i=0; i<length; i++) {
	        Array.set(itemTypeList, i, Array.get(itemTypes, i));
	     }
	}
%>
	<c:if test="<%= showHeader%>">
		<div class="item-item-type">
			<h4><liferay-ui:message key="item-type" /></h4>
				<span class="item-type-summary">
	</c:if>

<%	
	if (itemTypeList != null && Array.getLength(itemTypeList) > 0){
		for (int i = 0; i < Array.getLength(itemTypeList) ; i++)
		{
			Object itemType = Array.get(itemTypeList,i);
			String itemTypeName = (String)itemType.getClass().getMethod("getItemTypeName", null).invoke(itemType);
			long itemTypeId = (Long)itemType.getClass().getMethod("getItemTypeId", null).invoke(itemType);
			
			if (viewItemTypeURL != null)
				viewItemTypeURL.setParameter("itemTypeId",String.valueOf(itemTypeId));
%>
				<c:choose>
					<c:when test="<%= viewItemTypeURL != null %>">
						<a href="<%= HtmlUtil.escape(viewItemTypeURL.toString()) %>"><%= itemTypeName %></a>
						
					</c:when>
					<c:otherwise>
						<%= itemTypeName.concat(StringPool.BLANK) %>
					
					</c:otherwise>
				</c:choose>
<%			
		}
	}else
	{
%>
		<liferay-ui:message key="no-itemtype-found" />
<%		
	}
%>
<c:if test="<%= showHeader%>">
		</span>
	</div>
</c:if>