package com.idetronic.carousel.util;

import java.util.Comparator;

import com.idetronic.carousel.model.WebContent;

public class WebContentTitleComparator
implements Comparator<WebContent> {
    @Override
    public int compare(WebContent webContent1, WebContent webContent2) {
        return webContent1.getTitle().compareTo(webContent2.getTitle());
    }
}
