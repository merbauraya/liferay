package com.idetronic.calendarevent;

public class EventDisplayModel {
	private String maxAllEventDisplay;
	private String maxEventDisplay;
	private String showEmptyEventType;
	
	public String getMaxAllEventDisplay(){
		return this.maxAllEventDisplay;
	}
	public String getMaxEventDisplay(){
		return this.maxEventDisplay;
	}
	public String getShowEmptyEventType(){
		return this.showEmptyEventType;
	}
	public void setMaxAllEventDisplay(String maxVal){
		this.maxAllEventDisplay = maxVal;
	}
	public void setMaxEventDisplay(String maxVal){
		this.maxEventDisplay = maxVal;
	}
	public void setShowEmptyEventType(String showEmptyEventType){
		this.showEmptyEventType = showEmptyEventType;
	}

}
