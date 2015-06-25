package com.idetronic.subur.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class SuburDisplayTerms extends DisplayTerms{
	
	public static final String TITLE = "title";

	public static final String AUTHOR = "author";

	public static final String YEAR_PUBLISHED = "year";
	public static final String AUTHOR_FIRST_NAME = "authorFirstName";
	public static final String AUTHOR_LAST_NAME = "authorLastName";
	
	
	protected String title;
	protected String author;
	protected String year;
	protected String authorFirstName;
	protected String authorLastName;
	
	public SuburDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);

		title = ParamUtil.getString(portletRequest, TITLE);
		author = ParamUtil.getString(portletRequest, AUTHOR);
		year = ParamUtil.getString(portletRequest, YEAR_PUBLISHED);
		authorFirstName = ParamUtil.getString(portletRequest, AUTHOR_FIRST_NAME);
		authorLastName = ParamUtil.getString(portletRequest, AUTHOR_LAST_NAME);
	}
	public String getTitle()
	{
		return title;
	}
	public String getYear()
	{
		return year;
	}
	public String getAuthor()
	{
		return author;
	}
	public String getAuthorFirstName()
	{
		return authorFirstName;
	}
	public String getAuthorLastName()
	{
		return authorLastName;
	}
}
