package com.idetronic.subur.taglib;

import javax.portlet.PortletURL;
import javax.portlet.ResourceURL;
import javax.servlet.http.HttpServletRequest;

import com.liferay.taglib.util.IncludeTag;

public class AssetLinkTag extends IncludeTag {
	private long assetEntryId;
	private String nameSpace;
	private PortletURL serveFileURL;
	final String _PAGE = "/html/taglib/subur/asset_links.jsp";
	
	public void setNameSpace(String nameSpace)
	{
		this.nameSpace = nameSpace;
	}
	public String getNameSpace()
	{
		return nameSpace;
	}
	public void setServeFileURL(PortletURL serveFileURL)
	{
		this.serveFileURL = serveFileURL;
		
	}
	public PortletURL getServeFileURL()
	{
		return serveFileURL;
	}
	public void setAssetEntryId(long  assetEntryId)
	{
		this.assetEntryId = assetEntryId;
	}
	public long getAssetEntryId()
	{
		return assetEntryId;
	}
	
	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("subur:item-asset-links:assetEntryId", String.valueOf(getAssetEntryId()));
		request.setAttribute("subur:item-asset-links:serveFileURL", getServeFileURL());
		request.setAttribute("subur:item-asset-links:nameSpace", getNameSpace());
	}
	@Override
	public int doStartTag() {
		return EVAL_BODY_INCLUDE;
	}
	@Override
	protected void cleanUp() {
		setAssetEntryId(0);
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
