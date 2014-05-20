package com.idetronic.eventview;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class EventViewConfig {
	static Log log = LogFactoryUtil.getLog(EventViewConfig.class);
	private int viewType;
	private int maxDaysToQuery;
	private int maxItemToDisplay;
	private String internalTitle;
	private boolean showInternalTitle;
	
	public int getViewType()
	{
		return this.viewType;
	}
	public void setViewType(int value)
	{
		viewType = value;
	}
	public void setViewType(String value)
	{
		viewType = Integer.valueOf(value);
	}
	public void setMaxDaysToQuery(int value)
	{
		this.maxDaysToQuery = value;
	}
	public void setMaxDaysToQuery(String value)
	{
		this.maxDaysToQuery = Integer.valueOf(value);
	}
	public int getMaxDaysToQuery()
	{
		return this.maxDaysToQuery;
	}
	public String getInternalTitle()
	{
		return this.internalTitle;
	}
	public void setInternalTitle(String value)
	{
		this.internalTitle = value;
	}
	public boolean getShowInternalTitle()
	{
		return this.showInternalTitle;
	}
	public void setShowInternalTitle(boolean value)
	{
		this.showInternalTitle = value;
	}
	public void setShowInternalTitle(String value)
	{
		
		this.showInternalTitle = Boolean.valueOf(value);
		
	}
	public void setMaxItemToDisplay(int value)
	{
		this.maxItemToDisplay = value;
	}
	public void setMaxItemToDisplay(String value)
	{
		this.maxItemToDisplay = Integer.valueOf(value);
	}
	public int getMaxItemToDisplay()
	{
		return this.maxItemToDisplay;
	}
	
}
