package com.idetronic.subur.taglib;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import com.liferay.taglib.util.IncludeTag;

public class ItemItemTypeTag extends IncludeTag{
	private long itemId;
	private PortletURL viewItemTypeURL;
	private boolean showHeader;
	final String _PAGE = "/html/taglib/subur/item_types.jsp";
	
	
	public void setShowHeader(boolean showHeader)
	{
		this.showHeader = showHeader;
	}
	public boolean getShowHeader()
	{
		return showHeader;
	}
	public void setviewItemTypeURL(PortletURL viewAuthorURL)
	{
		this.viewItemTypeURL = viewAuthorURL;
	}
	public void setItemId(long itemId)
	{
		this.itemId = itemId;
	}
	public PortletURL getViewItemTypeURLL()
	{
		return viewItemTypeURL;
	}
	public long getItemId()
	{
		return itemId;
	}
	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("subur:item-itemtype-display:itemId", String.valueOf(getItemId()));
		request.setAttribute("subur:item-itemtype-display:viewItemTypeURL", getViewItemTypeURLL());
		request.setAttribute("subur:item-itemtype-display:showHeader", getShowHeader());
	}
	@Override
	public int doStartTag() {
		return EVAL_BODY_INCLUDE;
	}
	@Override
	protected void cleanUp() {
		setItemId(0);
	}
	/*
	public int doEndTag() throws JspException {
		
		try {
			include(_PAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.doEndTag();
	}*/
	
	@Override
	protected String getPage() {
		return _PAGE;
	}

}
