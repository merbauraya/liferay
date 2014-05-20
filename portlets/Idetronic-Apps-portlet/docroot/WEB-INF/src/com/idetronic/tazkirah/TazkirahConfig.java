package com.idetronic.tazkirah;

public class TazkirahConfig {
	private String showTitle;
	private String selectedCategory;
	private long backgroundImageId;
	
	public void setBackgroundImageId(long value)
	{
		this.backgroundImageId = value;
	}
	public long getBackgroundImageId()
	{
		return this.backgroundImageId;
	}
	public void setShowTitle(String value)
	{
		this.showTitle = value;
	}
	public String getShowTitle()
	{
		return this.showTitle;
	}
	public void setSelectedCategory(String value)
	{
		this.selectedCategory=value;
	}
	public String getSelectedCategory()
	{
		return this.selectedCategory;
	}

}
