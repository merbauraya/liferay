package com.idetronic.subur.util;

import com.idetronic.subur.Subur;
import com.idetronic.subur.service.DivisionLocalServiceUtil;
import com.idetronic.subur.service.MetadataValueLocalServiceUtil;
import com.idetronic.subur.service.SuburItemLocalServiceUtil;
import com.idetronic.subur.model.Division;
import com.idetronic.subur.model.MetadataValue;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.persistence.AssetCategoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.idetronic.subur.service.MetadataPropertyValueLocalServiceUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.jsp.JspWriter;

public class SuburUtil {
	
	private static Log logger = LogFactoryUtil.getLog(SuburUtil.class);
	public List getAdditionalMetadata()
	{
		List metadata = MetadataPropertyValueLocalServiceUtil.getAdditionalMetadata(0);
		return metadata;
	}
	/**
	 * Merge related asset id with DLFileEntry id
	 * @param relatedAsset
	 * @param fileEntries
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static long[] mergeRelatedAssetWithDlFileEntry(long[] relatedAsset,long[] fileEntries) throws PortalException, SystemException
	{
		long[] dlFileEntryAssetPK = new long[fileEntries.length];
		
		//process newly upload files, if any
		if (fileEntries.length > 0 ){
			for (int i = 0; i < fileEntries.length; i++)
			{
				
				AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(DLFileEntry.class.getName(), fileEntries[i]);
				dlFileEntryAssetPK[i] = assetEntry.getEntryId();
			}
		}
		
		relatedAsset = ArrayUtil.append(dlFileEntryAssetPK,relatedAsset);
		return relatedAsset;
		
	}
	
	public List getAuthor(long itemId)
	{
		DynamicQuery authorQuery = DynamicQueryFactoryUtil.forClass(
				 MetadataValue.class, PortletClassLoaderUtil.getClassLoader());
		
		//authorQuery.add(PropertyFactoryUtil.forName(propertyName))
		//List<Object> authors = MetadataValueLocalServiceUtil.
		return null;
	}
	public static String getAuhorDisplayName(String firstName,String lastName)
	{
		if (Validator.isBlank(lastName) || Validator.isNull(lastName))
		{
			return lastName +",";
		}else
		{
			return lastName + "," + firstName;
		}
	}
	public static String getName(String firstName,String lastName)
	{
		if (Validator.isBlank(lastName) || Validator.isNull(lastName))
		{
			return lastName +",";
		}else
		{
			return lastName + "," + firstName;
		}
	}
	public static String getFirstName(String name)
	{
		Collections.emptyList();
		if (Validator.isBlank(name) || Validator.isNull(name))
		{
			
			return StringPool.BLANK;
		}
		if (name.equals(","))
			return StringPool.BLANK;
		
		String[] names = name.split(",");
		if (names.length < 2)
			return StringPool.BLANK;
		
		return names[1];
		
	}
	public static String getLastName(String name)
	{
		if (Validator.isBlank(name))
			return StringPool.BLANK;
		if (name.equals(","))
			return StringPool.BLANK;
		String[] names = name.split(",");
		if (names.length < 2)
			return StringPool.BLANK;
		return names[0];
		
	}
	
	
	
	
	public static int countAssetVocabularyById(long vocabularyId) throws SystemException
	{
		return  SuburItemLocalServiceUtil.countAssetVocabularyById(vocabularyId);
	}
	
	public static byte[] inputStreamToByteArray(InputStream is) throws IOException
	{
		
	    byte[] targetArray = new byte[is.available()];
	    is.read(targetArray);
	    return targetArray;
	}
	public static void localeTest()
	{
		Locale[] availableLocales = LanguageUtil.getAvailableLocales();
		
		for (Locale locale: availableLocales)
			logger.info(locale.getDisplayName());
		
	}

}
