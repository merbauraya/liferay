package com.idetronic.subur.taglib;

import java.util.List;

import javax.portlet.PortletURL;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import com.idetronic.subur.model.Author;
import com.liferay.portal.kernel.servlet.PipingServletResponse;
import com.liferay.taglib.util.IncludeTag;

public class ItemAuthorTag extends IncludeTag {
	
	private long itemId;
	private PortletURL viewAuthorURL;
	final String _PAGE = "/html/taglib/subur/itemauthor.jsp";
	
	public void setviewAuthorURL(PortletURL viewAuthorURL)
	{
		this.viewAuthorURL = viewAuthorURL;
	}
	public void setItemId(long itemId)
	{
		this.itemId = itemId;
	}
	public PortletURL getViewAuthorURL()
	{
		return viewAuthorURL;
	}
	public long getItemId()
	{
		return itemId;
	}
	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("subur:item-author-display:itemId", String.valueOf(getItemId()));
		request.setAttribute("subur:item-author-display:viewAuthorURL", getViewAuthorURL());
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
