/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.idetronic.subur.service.impl;

import java.util.Calendar;
import java.util.List;

import com.idetronic.subur.model.DownloadSummary;
import com.idetronic.subur.model.ItemItemType;
import com.idetronic.subur.model.StatDownloadCategory;
import com.idetronic.subur.model.StatDownloadItemType;
import com.idetronic.subur.model.StatDownloadPeriod;
import com.idetronic.subur.model.StatDownloadTag;
import com.idetronic.subur.model.StatViewPeriod;
import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.service.ItemItemTypeLocalServiceUtil;
import com.idetronic.subur.service.base.DownloadSummaryLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.service.AssetCategoryServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagServiceUtil;

/**
 * The implementation of the download summary local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.service.DownloadSummaryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.base.DownloadSummaryLocalServiceBaseImpl
 * @see com.idetronic.subur.service.DownloadSummaryLocalServiceUtil
 */
public class DownloadSummaryLocalServiceImpl
	extends DownloadSummaryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.subur.service.DownloadSummaryLocalServiceUtil} to access the download summary local service.
	 */
	
	private static Log logger = LogFactoryUtil.getLog(DownloadSummaryLocalServiceImpl.class);
	
	
	public DownloadSummary addStats(long itemId) throws SystemException
	{
		
		
		long id = CounterLocalServiceUtil.increment(DownloadSummary.class.getName());
		DownloadSummary dSummary = downloadSummaryPersistence.create(id);
		
		
		dSummary.setItemId(itemId);
		
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		
		dSummary.setPerYear(year);
		dSummary.setPerMonth(month);
		downloadSummaryPersistence.update(dSummary);
		
		return dSummary;
	}
	/**
	 * Update stats info into their corresponding model entry
	 * This is very resource extensive operation
	 * @throws SystemException
	 */
	@Override
	public void updateStats() throws SystemException,PortalException
	{
		List<DownloadSummary> downloadSummaries = downloadSummaryPersistence.findByStatus(STATUS_NEW);
		
		long id = 0L;
		
		
		
		for (DownloadSummary downloadSummary : downloadSummaries)
		{
			int year = downloadSummary.getPerYear();
			int month = downloadSummary.getPerMonth();
			long itemId = downloadSummary.getItemId();
			//summary by period
			/*
			id  = CounterLocalServiceUtil.increment(StatDownloadPeriod.class.getName());
			StatDownloadPeriod downPeriod = statDownloadPeriodPersistence.create(id);
			downPeriod.setItemId(downloadSummary.getItemId());
			downPeriod.setPerMonth(month);
			downPeriod.setPerYear(year);
			statDownloadPeriodPersistence.update(downPeriod);
			*/
			
			//item type
			List<ItemItemType> itemItemTypes = ItemItemTypeLocalServiceUtil.itemTypeByItemid(itemId);
			
			for (int i = 0; i < itemItemTypes.size(); i++)
			{
				addItemTypeStat(month,year,itemItemTypes.get(i).getItemTypeId());
				
			}
			
			//category
			//get categories
			
			List<AssetCategory> categories = AssetCategoryServiceUtil.getCategories(SuburItem.class.getName(), itemId);
			
			long[] categoryIds = new long[categories.size()];
			for (int i = 0; i < categories.size(); i++)
			{
				
				addCategoryStat(month,year,categories.get(i).getCategoryId());
			}
			
			// tags
			List<AssetTag> tags = AssetTagServiceUtil.getTags(SuburItem.class.getName(), itemId);
			
			for (int i = 0; i < tags.size(); i++)
			{
				
				addTagStat(month,year,tags.get(i).getTagId());
			}
			
			
			
			
			downloadSummary.setStatus(STATUS_UPDATED);
			downloadSummaryPersistence.update(downloadSummary);
		}
		
		
	}
	
	private void addTagStat(int month, int year,long tagId) throws SystemException
	{
		long id  = CounterLocalServiceUtil.increment(StatDownloadTag.class.getName());
		StatDownloadTag downTag = statDownloadTagPersistence.create(id);
		downTag.setPerMonth(month);
		downTag.setPerYear(year);
		downTag.setTagId(tagId);
		statDownloadTagPersistence.update(downTag);
	}
	
	private void addCategoryStat(int month, int year, long categoryId) throws SystemException
	{
		long id  = CounterLocalServiceUtil.increment(StatDownloadCategory.class.getName());
		StatDownloadCategory downCategory = statDownloadCategoryPersistence.create(id);
		downCategory.setPerMonth(month);
		downCategory.setPerYear(year);
		downCategory.setCategoryId(categoryId);
		statDownloadCategoryPersistence.update(downCategory);
	}
	private void addItemTypeStat(int month, int year, long itemTypeId) throws SystemException
	{
		long id  = CounterLocalServiceUtil.increment(StatDownloadItemType.class.getName());
		StatDownloadItemType downItemType = statDownloadItemTypePersistence.create(id);
		downItemType.setItemTypeId(itemTypeId);
		downItemType.setPerMonth(month);
		downItemType.setPerYear(year);
		statDownloadItemTypePersistence.update(downItemType);
		
	}
	
	public static final int STATUS_NEW = 0;
	public static final int STATUS_UPDATED = 1;
}