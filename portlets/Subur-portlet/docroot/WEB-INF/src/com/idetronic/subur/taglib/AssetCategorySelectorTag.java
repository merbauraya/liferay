package com.idetronic.subur.taglib;

import javax.servlet.http.HttpServletRequest;

import com.liferay.taglib.util.IncludeTag;

public class AssetCategorySelectorTag extends IncludeTag {
	
	final String _PAGE = "/html/taglib/subur/category_selector.jsp";
	long vocabularyId;
	
	public void setVocabularyId(long vocabularyId)
	{
		this.vocabularyId = vocabularyId;
	}
	public long getVocabularyId()
	{
		return vocabularyId;
	}
	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("subur:category-selector:vocabularyId", String.valueOf(getVocabularyId()));
		
	}
	@Override
	public int doStartTag() {
		return EVAL_BODY_INCLUDE;
	}

}
