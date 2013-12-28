package com.idetronic.carousel.service;

import java.util.List;
import java.lang.Object;

import com.idetronic.carousel.model.Carousel;
import com.idetronic.carousel.model.WebContent;

public interface CarouselService {
	//public List<Image> getCarouselImageList(Carousel var1);

    public List<WebContent> getWebContentList(Carousel var1);

    //public void sortImages(List<Image> var1);

    public void sortWebContent(List<WebContent> var1);

    public Carousel createCarouselFromRequest();

    public Carousel createCarouselFromPreferences();

    public void saveCarouselPreferences(Carousel var1);


}
