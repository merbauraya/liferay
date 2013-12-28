package com.idetronic.carousel.model;

import java.util.List;

import com.idetronic.carousel.model.WebContent;
import com.idetronic.carousel.util.*;


public class Carousel {
    private String height;
    private String width;
    private String[] tagNames;
    private String pauseInterval;
    private String cssStyle;
    private String allTagName;
    private List<WebContent> webContentList;
    private long groupId;
    private CarouselConstants.CarouselType carouselType;
    private String backgroundColor;

    public String getAllTagName() {
        return this.allTagName;
    }

    public void setAllTagName(String allTagName) {
        this.allTagName = allTagName;
    }

    public String getCssStyle() {
        return this.cssStyle;
    }

    public void setCssStyle(String cssStyle) {
        this.cssStyle = cssStyle;
    }
/*
    public List<Image> getImageList() {
        return this.imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
*/
    public String[] getTagNames() {
        return this.tagNames;
    }

    public void setTagNames(String[] tagNames) {
        this.tagNames = tagNames;
    }

    public String getHeight() {
        return this.height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return this.width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getPauseInterval() {
        return this.pauseInterval;
    }

    public void setPauseInterval(String pauseInterval) {
        this.pauseInterval = pauseInterval;
    }

    public List<WebContent> getWebContentList() {
        return this.webContentList;
    }

    public void setWebContentList(List<WebContent> webContentList) {
        this.webContentList = webContentList;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public CarouselConstants.CarouselType getCarouselType() {
        return this.carouselType;
    }

    public void setCarouselType(CarouselConstants.CarouselType carouselType) {
        this.carouselType = carouselType;
    }

    public String getBackgroundColor() {
        return this.backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
