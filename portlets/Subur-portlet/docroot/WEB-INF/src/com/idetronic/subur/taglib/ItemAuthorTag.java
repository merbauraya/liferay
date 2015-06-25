package com.idetronic.subur.taglib;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import com.liferay.portal.kernel.servlet.PipingServletResponse;
import com.liferay.taglib.util.IncludeTag;

public class ItemAuthorTag extends IncludeTag {
	
	private long itemId;
	final String _PAGE = "/html/taglib/itemauthor.jsp";
	public void setItemId(long itemId)
	{
		this.itemId = itemId;
	}
	public long getItemId()
	{
		return itemId;
	}
	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("subur:itemId", itemId);
		
	}
	public int doEndTag() throws JspException {
		
		try {
			include(_PAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.doEndTag();
	}
	@Override
	protected String getPage() {
		return _PAGE;
	}

}
