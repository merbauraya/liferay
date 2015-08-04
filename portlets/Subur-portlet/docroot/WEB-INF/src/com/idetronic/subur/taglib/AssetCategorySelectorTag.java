package com.idetronic.subur.taglib;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import com.liferay.taglib.util.IncludeTag;

public class AssetCategorySelectorTag extends IncludeTag {
	
	final String _PAGE = "/html/taglib/subur/category_selector.jsp";
	private PortletURL _portletURL;
	private long[] _vocabularyIds;
	private String _className;
	private String _hiddenInput;
	private long _classPK;
	
	public void setHiddenInput(String hiddenInput)
	{
		_hiddenInput = hiddenInput;
	}
	public String getHiddenInput()
	{
		return _hiddenInput;
	}
	
	public void setClassPK(long classPK)
	{
		_classPK = classPK;
	}
	public long getClassPK()
	{
		return _classPK;
	}
	public void setClassName(String className)
	{
		_className = className;
	}
	public String getClassName()
	{
		return _className;
	}
	public void setPortletURL(PortletURL portletURL)
	{
		_portletURL = portletURL;
	}
	
	public void setVocabularyId(long[] vocabularyIds)
	{
		_vocabularyIds = vocabularyIds;
	}
	public long[] getVocabularyId()
	{
		return _vocabularyIds;
	}
	public PortletURL getPortletURL()
	{
		return _portletURL;
	}
	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("subur:category-selector:vocabularyId", _vocabularyIds);
		request.setAttribute("subur:category-selector:className", _className);
		request.setAttribute("subur:category-selector:classPK", _classPK);
		request.setAttribute("subur:category-selector:hiddenInput", _hiddenInput);

	}
	@Override
	public int doStartTag() {
		return EVAL_BODY_INCLUDE;
	}
	@Override
	protected String getPage() {
		return _PAGE;
	}

}
