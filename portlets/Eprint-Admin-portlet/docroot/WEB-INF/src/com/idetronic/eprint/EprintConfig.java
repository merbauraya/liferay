package com.idetronic.eprint;

public class EprintConfig {
	private String eprintURL;
	private boolean enableSocialBookmarks;
	private String socialBookmarksDisplayStyle;
	private String socialBookmarksDisplayPosition;
	private String[] socialBookmarksType;
	public void setEprintURL(String url)
	{
		this.eprintURL = url;
	}
	public String getEprintURL()
	{
		return this.eprintURL;
	}
	public boolean getEnableSocialBookmarks()
	{
		return this.enableSocialBookmarks;
	}
	public void setEnableSocialBookmarks(boolean value)
	{
		this.enableSocialBookmarks = value;
	}
	public void setSocialBookmarksDisplayStyle(String value)
	{
		this.socialBookmarksDisplayStyle = value;
	}
	public String getSocialBookmarksDisplayStyle()
	{
		return this.socialBookmarksDisplayStyle;
	}
	public void setSocialBookmarksDisplayPosition(String value)
	{
		this.socialBookmarksDisplayPosition = value;
	}
	public String getSocialBookmarksDisplayPosition()
	{
		return this.socialBookmarksDisplayPosition;
	}
	public String[] getSocialBookmarksType()
	{
		return this.socialBookmarksType;
	}
	public void setSocialBookmarksType(String[] value)
	{
		this.socialBookmarksType = value;
	}
}
