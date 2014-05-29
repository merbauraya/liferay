package com.idetronic.tabview;

public class TabViewConfig {
	private long blogOrganizationId;
	private int maxItem;
	
	public void setOrganizationId(long value)
	{
		this.blogOrganizationId = value;
	}
	public long getOrganizationId()
	{
		return this.blogOrganizationId;
	}
	
	public void setMaxItem(int value)
	{
		this.maxItem = value;
	}
	public int getMaxItem()
	{
		return this.maxItem;
	}
}
