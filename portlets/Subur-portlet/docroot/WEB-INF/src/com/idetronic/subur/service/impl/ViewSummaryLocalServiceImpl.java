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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import com.idetronic.subur.model.DownloadSummary;
import com.idetronic.subur.model.ItemItemType;
import com.idetronic.subur.model.StatViewCategory;
import com.idetronic.subur.model.StatViewItemType;
import com.idetronic.subur.model.StatViewPeriod;
import com.idetronic.subur.model.StatViewTag;
import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.model.ViewSummary;
import com.idetronic.subur.service.ItemItemTypeLocalServiceUtil;
import com.idetronic.subur.service.base.ViewSummaryLocalServiceBaseImpl;
import com.idetronic.subur.service.persistence.SuburItemFinderImpl;
import com.idetronic.subur.service.persistence.ViewSummaryFinderUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.service.AssetCategoryServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagServiceUtil;
import com.liferay.util.dao.orm.CustomSQLUtil;

/**
 * The implementation of the view summary local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.service.ViewSummaryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.base.ViewSummaryLocalServiceBaseImpl
 * @see com.idetronic.subur.service.ViewSummaryLocalServiceUtil
 */
public class ViewSummaryLocalServiceImpl extends ViewSummaryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.subur.service.ViewSummaryLocalServiceUtil} to access the view summary local service.
	 */
	public static final int STATUS_NEW = 0;
	public static final int STATUS_UPDATED = 1;
	
	
	private static Log logger = LogFactoryUtil.getLog(ViewSummaryLocalServiceImpl.class);

	
	@Override
	public JSONArray getMonthlyStatRs(int year) throws SQLException
	{
		return ViewSummaryFinderUtil.getMonthlySummary(year);
		
		
	}
	
	public JSONArray getMonthlyTag(int year) throws SQLException
	{
		return ViewSummaryFinderUtil.getMothlyTagSummary(year);
	}
	
	/**
	 * Add view stats info the the entity. 
	 */
	public ViewSummary addStats(long itemId) throws SystemException
	{
		
		
		long id = CounterLocalServiceUtil.increment(ViewSummary.class.getName());
		ViewSummary dSummary = viewSummaryPersistence.create(id);
		
	
		dSummary.setItemId(itemId);
		
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		dSummary.setStatus(STATUS_NEW);
		dSummary.setPerYear(year);
		dSummary.setPerMonth(month);
		viewSummaryPersistence.update(dSummary);
		
		return dSummary;
	}
	@Override
	public void updateStats() throws SystemException,PortalException
	{
		List<ViewSummary> viewSummaries = viewSummaryPersistence.findByStatus(STATUS_NEW);
		
		long id = 0L;
		for (ViewSummary viewSummary : viewSummaries)
		{
			int month = viewSummary.getPerMonth();
			int year = viewSummary.getPerYear();
			long itemId = viewSummary.getItemId();
			
			//get item Type
			
			List<ItemItemType> itemItemTypes = ItemItemTypeLocalServiceUtil.itemTypeByItemid(itemId);
			
			for (int i = 0; i < itemItemTypes.size(); i++)
			{
				addItemTypeStat(month,year,itemItemTypes.get(i).getItemTypeId());
				
			}
			
			//category
			//get categories
			List<AssetCategory> categories = AssetCategoryServiceUtil.getCategories(SuburItem.class.getName(), itemId);
			
			
			for (int i = 0; i < categories.size(); i++)
			{
				addCategoryStat(month,year,categories.get(i).getCategoryId());
			}
			
			//tags
			List<AssetTag> tags = AssetTagServiceUtil.getTags(SuburItem.class.getName(), itemId);
			
			for (int i = 0; i < tags.size(); i++)
			{
				addTagStat(month,year,tags.get(i).getTagId());
			}
			
			
			
			
			
			
			
			
			
			viewSummary.setStatus(STATUS_UPDATED);
			viewSummaryPersistence.update(viewSummary);
		}
	}
	private void addTagStat(int month,int year,long tagId) throws SystemException
	{
		long id  = CounterLocalServiceUtil.increment(StatViewTag.class.getName());
		StatViewTag viewTag = statViewTagPersistence.create(id);
		viewTag.setTagId(tagId);
		viewTag.setPerMonth(month);
		viewTag.setPerYear(year);
		statViewTagPersistence.update(viewTag);
	}
	private void addCategoryStat(int month, int year, long categoryId) throws SystemException
	{
		long id  = CounterLocalServiceUtil.increment(StatViewCategory.class.getName());
		StatViewCategory viewCategory = statViewCategoryPersistence.create(id);
		viewCategory.setCategoryId(categoryId);
		viewCategory.setPerYear(year);
		viewCategory.setPerMonth(month);
		statViewCategoryPersistence.update(viewCategory);
	}
	private void addItemTypeStat(int month,int year,long itemTypeId) throws SystemException
	{
		//item type stats
		long id  = CounterLocalServiceUtil.increment(StatViewItemType.class.getName());
		StatViewItemType viewItemType = statViewItemTypePersistence.create(id);
		viewItemType.setItemTypeId(itemTypeId);
		viewItemType.setPerMonth(month);
		viewItemType.setPerYear(year);
		statViewItemTypePersistence.update(viewItemType);
	}
	
}