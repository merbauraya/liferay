package com.idetronic.carousel.model;

public class Image {
    private String linkURL;
    private String name;
    private String title;
    private String description;
    private int sequence;
    private String alternateText;
    private String imageURL;
    private String imageTagName;

    public String getLinkURL() {
        return this.linkURL;
    }

    public void setLinkURL(String linkURL) {
        this.linkURL = linkURL;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSequence() {
        return this.sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getAlternateText() {
        return this.alternateText;
    }

    public void setAlternateText(String alternateText) {
        this.alternateText = alternateText;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getImageTagName() {
        return this.imageTagName;
    }

    public void setImageTagName(String imageTagName) {
        this.imageTagName = imageTagName;
    }
}
