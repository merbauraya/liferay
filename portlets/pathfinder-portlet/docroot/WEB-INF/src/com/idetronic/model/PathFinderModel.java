package com.idetronic.model;

public class PathFinderModel {
	private String eprintOAIUrl;
	private String xsl;
	
	public void setEprintURL(String url)
	{
		this.eprintOAIUrl = url;
		
	}
	public void setXSL(String xsl)
	{
		this.xsl = xsl;
	}
	public String getEprintURL()
	{
		return this.eprintOAIUrl;
	}
	public String getXSL()
	{
		return this.xsl;
	}

}
