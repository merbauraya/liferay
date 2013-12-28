package com.idetronic.carousel.service;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.ClassNameServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.asset.NoSuchTagException;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.portlet.asset.service.persistence.AssetEntryQuery;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryType;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryTypeLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Field;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleResource;
import com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleServiceUtil;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.Throwable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

import com.idetronic.carousel.model.Carousel;
import com.idetronic.carousel.model.WebContent;
import com.idetronic.carousel.util.CarouselConstants;
import com.idetronic.carousel.util.WebContentTitleComparator;
public class CarouselServiceImpl
implements CarouselService {
    private static Log log = LogFactoryUtil.getLog((Class)(CarouselServiceImpl.class));
    private static long DLFILEENTRYCLASSID = ClassNameServiceUtil.fetchClassNameId((Class)(DLFileEntry.class));
    private static long WEBCONTENTCLASSID = ClassNameServiceUtil.fetchClassNameId((Class)(JournalArticle.class));
    private PortletRequest portletRequest;

    public CarouselServiceImpl(PortletRequest portletRequest) {
        this.portletRequest = portletRequest;
    }
/*
    @Override
    public List<Image> getCarouselImageList(Carousel carousel) {
        List<AssetEntry> assetEntries;
        ArrayList<Image> imageList = new ArrayList<Image>();
        if ((Validator.isNull((Object)(carousel))) || (Validator.isNull((Object[])(carousel.getTagNames())))) {
            this.setRequestError("NO_TAG_NAME_SPECIFIED");
            return imageList;
        }
        if (((assetEntries = this.getAssetEntries(carousel.getTagNames())) == null) || (assetEntries.size() == 0)) {
            this.setRequestError("NO_IMAGE_FOUND_FOR_TAG_NAME");
            return imageList;
        }
        for (AssetEntry assetEntry : assetEntries) {
            if (assetEntry.getClassNameId() != CarouselServiceImpl.DLFILEENTRYCLASSID) continue;
            try {
                DLFileEntryType dlFileEntryType;
                Image carouselImage;
                DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getFileEntry((long)(assetEntry.getClassPK()));
                if (((!(this.hasPermission(fileEntry))) || (!((dlFileEntryType = DLFileEntryTypeLocalServiceUtil.getFileEntryType((long)(fileEntry.getFileEntryTypeId()))).getName().equalsIgnoreCase("image")))) || ((carouselImage = this.getImage(fileEntry)) == null)) continue;
                imageList.add(carouselImage);
                continue;
            }
            catch (Exception e) {
                CarouselServiceImpl.log.error((Object)("Error processesing the asset entry"), (Throwable)(e));
                this.setRequestError("ERROR_GETTING_ASSET_ENTRY");
            }
        }
        return imageList;
    }
*/
    @Override
    public List<WebContent> getWebContentList(Carousel carousel) {
        List<AssetEntry> assetEntries;
        ArrayList<WebContent> webContentList = new ArrayList<WebContent>();
        if ((Validator.isNull((Object)(carousel))) || (Validator.isNull((Object[])(carousel.getTagNames())))) {
            this.setRequestError("NO_TAG_NAME_SPECIFIED");
            return webContentList;
        }
        if (((assetEntries = this.getAssetEntries(carousel.getTagNames())) == null) || (assetEntries.size() == 0)) {
            this.setRequestError("NO_WEBCONTENT_FOUND_FOR_TAG_NAME");
            return webContentList;
        }
        for (AssetEntry assetEntry : assetEntries) {
            if (assetEntry.getClassNameId() != CarouselServiceImpl.WEBCONTENTCLASSID) continue;
            try {
                JournalArticle journalArticle;
                JournalArticleResource journalArticleResource = JournalArticleResourceLocalServiceUtil.getJournalArticleResource((long)(assetEntry.getClassPK()));
                if ((journalArticleResource == null) || ((journalArticle = JournalArticleServiceUtil.getArticle((long)(carousel.getGroupId()), (String)(journalArticleResource.getArticleId()))) == null)) continue;
                WebContent webContent = new WebContent();
                webContent.setTitle(journalArticle.getTitleCurrentValue());
                webContent.setId(journalArticle.getArticleId());
                webContentList.add(webContent);
                if (!(CarouselServiceImpl.log.isDebugEnabled())) continue;
                CarouselServiceImpl.log.debug((Object)(("Carousel article id: " + journalArticle.getArticleId())));
                continue;
            }
            catch (Exception e) {
                CarouselServiceImpl.log.error((Object)("Error processesing the asset entry"), (Throwable)(e));
                this.setRequestError("ERROR_GETTING_ASSET_ENTRY");
            }
        }
        return webContentList;
    }
/*
    @Override
    public void sortImages(List<Image> imageList) {
        Collections.sort(imageList, new ImageSequenceComparator());
    }
*/
    @Override
    public void sortWebContent(List<WebContent> webContentList) {
        Collections.sort(webContentList, new WebContentTitleComparator());
    }

    @Override
    public Carousel createCarouselFromRequest() {
        String height;
        String timeInterval;
        String width;
        String carouselType;
        String backgroundColor;
        Carousel carousel = new Carousel();
        String tagSelected = ParamUtil.getString((PortletRequest)(this.portletRequest), (String)("assetTagNames"));
        String[] tagNames = null;
        if (!((tagSelected == null) || (tagSelected.trim().isEmpty()))) {
            tagNames = tagSelected.split(",");
        } else {
            tagSelected = "";
            tagNames = new String[]{};
        }
        String cssStyle = ParamUtil.getString((PortletRequest)(this.portletRequest), (String)("cssStyle"));
        if ((cssStyle == null) || (cssStyle.trim().isEmpty())) {
            cssStyle = "";
        }
        if (((height = ParamUtil.getString((PortletRequest)(this.portletRequest), (String)("height"))) == null) || (height.trim().isEmpty())) {
            height = "250";
        }
        if (((width = ParamUtil.getString((PortletRequest)(this.portletRequest), (String)("width"))) == null) || (width.trim().isEmpty())) {
            width = "450";
        }
        if (((timeInterval = ParamUtil.getString((PortletRequest)(this.portletRequest), (String)("pauseInterval"))) == null) || (timeInterval.trim().isEmpty())) {
            timeInterval = "5";
        }
        if (((carouselType = ParamUtil.getString((PortletRequest)(this.portletRequest), (String)("carouselType"))) == null) || (carouselType.trim().isEmpty())) {
            carouselType = "IMAGE";
        }
        if (((backgroundColor = ParamUtil.getString((PortletRequest)(this.portletRequest), (String)("backgroundColor"))) == null) || (carouselType.trim().isEmpty())) {
            backgroundColor = "";
        }
        carousel.setGroupId(this.getGroupId(this.portletRequest));
        carousel.setAllTagName(tagSelected);
        carousel.setTagNames(tagNames);
        carousel.setCssStyle(cssStyle);
        carousel.setHeight(height);
        carousel.setWidth(width);
        carousel.setPauseInterval(timeInterval);
        carousel.setCarouselType(CarouselConstants.CarouselType.valueOf((String)(carouselType)));
        carousel.setBackgroundColor(backgroundColor);
        return carousel;
    }

    @Override
    public Carousel createCarouselFromPreferences() {
        Carousel carousel = new Carousel();
        PortletPreferences prefs = this.portletRequest.getPreferences();
        String portletResource = ParamUtil.getString((PortletRequest)(this.portletRequest), (String)("portletResource"));
        if (Validator.isNotNull((String)(portletResource))) {
            try {
                prefs = PortletPreferencesFactoryUtil.getPortletSetup((PortletRequest)(this.portletRequest), (String)(portletResource));
            }
            catch (Exception e) {
                CarouselServiceImpl.log.error((Object)("Error getting portlet preferences"), (Throwable)(e));
            }
        }
        if (prefs == null) {
            CarouselServiceImpl.log.error((Object)("Portlet preferences is null"));
            this.setRequestError("ERROR_PORTLET_PREFERENCES");
            return carousel;
        }
        if (!((prefs.getValue("height", "250") == null) || (prefs.getValue("height", "250").trim().isEmpty()))) {
            carousel.setHeight(prefs.getValue("height", "250"));
        } else {
            carousel.setHeight("250");
        }
        if (!((prefs.getValue("width", "450") == null) || (prefs.getValue("width", "450").trim().isEmpty()))) {
            carousel.setWidth(prefs.getValue("width", "450"));
        } else {
            carousel.setWidth("450");
        }
        if (!((prefs.getValue("pauseInterval", "5") == null) || (prefs.getValue("pauseInterval", "5").trim().isEmpty()))) {
            carousel.setPauseInterval(prefs.getValue("pauseInterval", "5"));
        } else {
            carousel.setPauseInterval("5");
        }
        if (!((prefs.getValue("tagName", "") == null) || (prefs.getValue("tagName", "").trim().isEmpty()))) {
            carousel.setAllTagName(prefs.getValue("tagName", ""));
            String tagSelected = prefs.getValue("tagName", "");
            String[] tagNames = tagSelected.split(",");
            carousel.setTagNames(tagNames);
        } else {
            carousel.setAllTagName("");
            carousel.setTagNames((String[])(null));
        }
        if (!((prefs.getValue("cssStyle", "") == null) || (prefs.getValue("cssStyle", "").trim().isEmpty()))) {
            carousel.setCssStyle(prefs.getValue("cssStyle", ""));
        } else {
            carousel.setCssStyle("");
        }
        if (!((prefs.getValue("carouselType", "IMAGE") == null) || (prefs.getValue("carouselType", "IMAGE").trim().isEmpty()))) {
            String carouselType = prefs.getValue("carouselType", "IMAGE");
            carousel.setCarouselType(CarouselConstants.CarouselType.valueOf((String)(carouselType)));
        } else {
            carousel.setCarouselType(CarouselConstants.CarouselType.valueOf((String)("IMAGE")));
        }
        if (!((prefs.getValue("backgroundColor", "") == null) || (prefs.getValue("backgroundColor", "").trim().isEmpty()))) {
            carousel.setBackgroundColor(prefs.getValue("backgroundColor", ""));
        } else {
            carousel.setBackgroundColor("");
        }
        carousel.setGroupId(this.getGroupId(this.portletRequest));
        return carousel;
    }

    @Override
    public void saveCarouselPreferences(Carousel carousel) {
        PortletPreferences prefs = this.portletRequest.getPreferences();
        String portletResource = ParamUtil.getString((PortletRequest)(this.portletRequest), (String)("portletResource"));
        if (Validator.isNotNull((String)(portletResource))) {
            try {
                prefs = PortletPreferencesFactoryUtil.getPortletSetup((PortletRequest)(this.portletRequest), (String)(portletResource));
            }
            catch (Exception e) {
                CarouselServiceImpl.log.error((Object)("Error getting portlet preferences"), (Throwable)(e));
            }
        }
        try {
            prefs.setValues("tagNames", carousel.getTagNames());
            prefs.setValue("tagName", carousel.getAllTagName());
            prefs.setValue("cssStyle", carousel.getCssStyle());
            prefs.setValue("height", carousel.getHeight());
            prefs.setValue("width", carousel.getWidth());
            prefs.setValue("pauseInterval", carousel.getPauseInterval());
            prefs.setValue("carouselType", carousel.getCarouselType().name());
            prefs.setValue("backgroundColor", carousel.getBackgroundColor());
            prefs.store();
        }
        catch (Exception e) {
            CarouselServiceImpl.log.error((Object)("Error saving the preferences"), (Throwable)(e));
            this.setRequestError("ERROR_PORTLET_PREFERENCES");
        }
    }

    private boolean hasPermission(DLFileEntry fileEntry) {
        PermissionChecker permissionChecker = this.getThemeDisplay().getPermissionChecker();
        if (permissionChecker == null) return false;
        return permissionChecker.hasPermission(fileEntry.getGroupId(), DLFileEntry.class.getName(), fileEntry.getPrimaryKey(), "VIEW");
    }

    private List<AssetEntry> getAssetEntries(String[] tagNames) {
        ThemeDisplay themeDisplay = this.getThemeDisplay();
        try {
            long[] assetTagIds = AssetTagLocalServiceUtil.getTagIds((long)(themeDisplay.getScopeGroupId()), (String[])(tagNames));
            if (assetTagIds.length == 0) return null;
            AssetEntryQuery assetEntryQuery = new AssetEntryQuery();
            assetEntryQuery.setAnyTagIds(assetTagIds);
            assetEntryQuery.setExcludeZeroViewCount(false);
            assetEntryQuery.setVisible(Boolean.valueOf(true));
            assetEntryQuery.setStart(-1);
            assetEntryQuery.setEnd(-1);
            List assetEntries = AssetEntryLocalServiceUtil.getEntries((AssetEntryQuery)(assetEntryQuery));
            return assetEntries;
        }
        catch (NoSuchTagException nste) {
            this.setRequestError("NO_IMAGE_FOUND_FOR_TAG_NAME");
        }
        catch (SystemException se) {
            CarouselServiceImpl.log.error((Object)("Error getting the tag names"), (Throwable)(se));
            this.setRequestError("ERROR_GETTING_TAG_NAMES");
        }
        catch (PortalException pe) {
            CarouselServiceImpl.log.error((Object)("Error getting the tag names"), (Throwable)(pe));
            this.setRequestError("ERROR_GETTING_TAG_NAMES");
        }
        return null;
    }
/*
    private Image getImage(DLFileEntry fileEntry) {
        Map fileEntryFieldsMap = null;
        try {
            fileEntryFieldsMap = fileEntry.getFieldsMap(fileEntry.getFileVersion().getFileVersionId());
        }
        catch (Exception e) {
            CarouselServiceImpl.log.error((Object)("Error getting FieldsMap from FileEntry for Image"), (Throwable)(e));
            return null;
        }
        Image carouselImage = new Image();
        Collection fileEntryFieldsValueSet = fileEntryFieldsMap.values();
        for (Fields fileEntryFieldValue : fileEntryFieldsValueSet) {
            Iterator fieldIterator = fileEntryFieldValue.iterator((Comparator)(null));
            while (fieldIterator.hasNext()) {
                Field field;
                if (((field = (Field)(fieldIterator.next())).getName().equalsIgnoreCase("sequence")) && (field.getValue().toString().trim().length() != 0)) {
                    carouselImage.setSequence(Integer.parseInt(field.getValue().toString()));
                }
                if (field.getName().equalsIgnoreCase("link")) {
                    carouselImage.setLinkURL(field.getValue().toString());
                }
                if (field.getName().equalsIgnoreCase("alternateText")) {
                    carouselImage.setAlternateText(field.getValue().toString());
                }
                String actualURL = (String.valueOf(this.getImageURL()) + fileEntry.getUuid());
                carouselImage.setImageURL(actualURL);
            }
        }
        return carouselImage;
    }
*/
    private void setRequestError(String messageKey) {
        this.portletRequest.setAttribute(messageKey, (Object)(true));
    }

    private ThemeDisplay getThemeDisplay() {
        if (this.portletRequest == null) return null;
        return (ThemeDisplay)(this.portletRequest.getAttribute("THEME_DISPLAY"));
    }

    private String getImageURL() {
        ThemeDisplay themeDisplay = this.getThemeDisplay();
        String imageURL = (String.valueOf(themeDisplay.getPortalURL()) + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + "/");
        return imageURL;
    }

    private long getGroupId(PortletRequest portletRequest) {
        try {
            ThemeDisplay themeDisplay = (ThemeDisplay)(portletRequest.getAttribute("THEME_DISPLAY"));
            Group currentGroup = themeDisplay.getLayout().getGroup();
            return currentGroup.getGroupId();
        }
        catch (Exception e) {
            CarouselServiceImpl.log.error((Object)("Error getting current group"), (Throwable)(e));
            return 0;
        }
    }
}
