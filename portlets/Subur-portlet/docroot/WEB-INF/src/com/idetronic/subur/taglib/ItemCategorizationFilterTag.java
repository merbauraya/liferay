package com.idetronic.subur.taglib;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.taglib.util.IncludeTag;

public class ItemCategorizationFilterTag extends IncludeTag {
	
	
	final String _PAGE = "/html/taglib/subur/item_categorization_filter.jsp";
	
	private String assetType;
	private PortletURL portletURL; 
	
	public void setAssetType(String assetType)
	{
		this.assetType = assetType;
	}
	public void setPortletURL(PortletURL portletURL)
	{
		this.portletURL = portletURL;
	}
	public String getAssetType()
	{
		return assetType;
	}
	public PortletURL getPortletURL()
	{
		return portletURL;
	}
	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("subur:item-categorization-filter:portletURL", getPortletURL());
		request.setAttribute("subur:item-categorization-filter:assetType", getAssetType());
		
	}
	
	@Override
	protected String getPage() {
		return _PAGE;
	}
	
	private static Log logger = LogFactoryUtil.getLog(ItemCategorizationFilterTag.class);
}
