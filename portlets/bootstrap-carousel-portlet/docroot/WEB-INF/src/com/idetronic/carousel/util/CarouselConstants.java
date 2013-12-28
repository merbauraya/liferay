package com.idetronic.carousel.util;

import java.lang.Enum;
import java.lang.Object;
import java.lang.String;
import java.lang.System;


public class CarouselConstants {
    public static final String CAROUSEL_DISPLAY = "carouselDisplay";
    public static final String DOCUMENTS = "/documents/";
    public static final String IMAGES = "image";
    public static final String HEIGHT = "height";
    public static final String PAUSEINTERVAL = "pauseInterval";
    public static final String TAGNAMES = "tagNames";
    public static final String TAGNAME = "tagName";
    public static final String WIDTH = "width";
    public static final String CAROUSEL_TYPE = "carouselType";
    public static final String CAROUSEL_DEFAULT_TYPE = "IMAGE";
    public static final String BACKGROUND_COLOR = "backgroundColor";
    public static final String CSSSTYLE = "cssStyle";
    public static final String PORTLETRESOURCE = "portletResource";
    public static final String NO_TAG_NAME_FOUND = "NO_TAG_NAME_FOUND";
    public static final String NO_IMAGE_FOUND_FOR_TAG_NAME = "NO_IMAGE_FOUND_FOR_TAG_NAME";
    public static final String NO_WEBCONTENT_FOUND_FOR_TAG_NAME = "NO_WEBCONTENT_FOUND_FOR_TAG_NAME";
    public static final String NO_TAG_NAME_SPECIFIED = "NO_TAG_NAME_SPECIFIED";
    public static final String ERROR_GETTING_TAG_NAMES = "ERROR_GETTING_TAG_NAMES";
    public static final String ERROR_GETTING_ASSET_ENTRY = "ERROR_GETTING_ASSET_ENTRY";
    public static final String ERROR_PORTLET_PREFERENCES = "ERROR_PORTLET_PREFERENCES";
    public static final String DEFAULT_HEIGHT = "250";
    public static final String DEFAULT_WIDTH = "450";
    public static final String DEFAULT_PAUSEINTERVAL = "5";
    public static final String SEQUENCE = "sequence";
    public static final String LINK = "link";
    public static final String ALTERNATETEXT = "alternateText";
    public static final String ERROR = "error";
    public static final String VALIDATEHEIGHT = "Height";
    public static final String VALIDATEPAUSEINTERVAL = "PauseInterval";
    public static final String VALIDATETAGNAME = "TagName";
    public static final String VALIDATEWIDTH = "Width";
    public static final String COMMADELIMITER = ",";
    public static final String ERRORSREQUIRED = "errors.required";
    public static final String ERRORSNUMBER = "errors.number";
    public static final String ERRORS_LESSERTHAN_ZERO = "errors.lesser.than.zero";
    public static final String CAROUSEL = "carousel";
    public static final String ASSETTAGNAMES = "assetTagNames";
    public static final String CONFIGURATION_JSP = "configuration";
    public static final String CSSSTYLE_HELP_JSP = "cssStyleHelp";
    public static final String SUCCESS_SAVED_PREFERENCES = "SUCCESS_SAVED_PREFERENCES";

    private CarouselConstants() {
    }

    public static enum CarouselType {
        WEBCONTENT;
        
    }
        

}