package com.idetronic.carousel.util;

import java.util.List;

import com.idetronic.carousel.model.Carousel;
import com.liferay.portal.kernel.util.Validator;

public class CarouselValidator {
    public boolean validate(Carousel carousel, List<String> errors) {
        String hex;
        boolean valid = true;
        if ((Validator.isNotNull((String)(carousel.getBackgroundColor()))) && (!((hex = carousel.getBackgroundColor()).matches("[0-9A-Fa-f]+")))) {
            errors.add("background.color.error");
            valid = false;
        }
        if (!(Validator.isDigit((String)(carousel.getHeight())))) {
            errors.add("height.errors.number");
            valid = false;
        } else if (Long.parseLong(carousel.getHeight()) <= 0) {
            errors.add("height.errors.lesser.than.zero");
            valid = false;
        }
        if (!(Validator.isDigit((String)(carousel.getWidth())))) {
            errors.add("width.errors.number");
            valid = false;
        } else if (Long.parseLong(carousel.getWidth()) <= 0) {
            errors.add("width.errors.lesser.than.zero");
            valid = false;
        }
        if (!(Validator.isDigit((String)(carousel.getPauseInterval())))) {
            errors.add("pause.errors.number");
            valid = false;
        } else if (Long.parseLong(carousel.getPauseInterval()) <= 0) {
            errors.add("pause.errors.lesser.than.zero");
            valid = false;
        }
        if ((carousel.getAllTagName() != null) && (!(carousel.getAllTagName().equals("")))) return valid;
        errors.add("tag.error");
        valid = false;
        return valid;
    }
}
