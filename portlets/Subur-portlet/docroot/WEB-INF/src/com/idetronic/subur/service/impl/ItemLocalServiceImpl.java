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

import java.util.Date;
import java.util.List;

import com.idetronic.subur.model.Item;
import com.idetronic.subur.service.MetadataPropertyValueLocalServiceUtil;
import com.idetronic.subur.service.base.ItemLocalServiceBaseImpl;
import com.idetronic.subur.service.persistence.SuburItemFinderImpl;
import com.idetronic.subur.service.persistence.ItemFinderUtil;
import com.idetronic.subur.util.SuburConstant;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.liferay.portlet.asset.service.AssetLinkLocalServiceUtil;

/**
 * The implementation of the item local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.service.ItemLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.base.ItemLocalServiceBaseImpl
 * @see com.idetronic.subur.service.ItemLocalServiceUtil
 */
public class ItemLocalServiceImpl extends ItemLocalServiceBaseImpl {
	private static Log logger = LogFactoryUtil.getLog(ItemLocalServiceImpl.class);
	public Item addItem(long userId,long groupId,String title,String itemAbstract,
			ServiceContext serviceContext) throws PortalException, SystemException
	{
		User user = userLocalService.getUserById(userId);
		
		Date now = new Date();
		long itemId = counterLocalService.increment();
		
		Item item = itemPersistence.create(itemId);
		item.setGroupId(groupId);
		item.setCompanyId(user.getCompanyId());
		item.setUserId(userId);
		item.setCreateDate(now);
		item.setModifiedDate(now);
		item.setTitle(title);
		item.setItemAbstract(itemAbstract);
		
		itemPersistence.update(item);
		resourceLocalService.addResources(item.getCompanyId(), item.getGroupId(), 
				item.getUserId(), Item.class.getName(), item.getItemId(), 
				false, true, true);
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
                Item.class);

		indexer.reindex(item);
		/*
		assetEntryLocalService.updateEntry(
		        serviceContext.getUserId(),                     // userId
		        serviceContext.getScopeGroupId(),               // groupId
		        Item.class.getName(),                                // className
		        item.getPrimaryKey(),                                // classPK
		        serviceContext.getAssetCategoryIds(),   // category Ids
		        serviceContext.getAssetTagNames());
		*/
		return item;
	}
	public List getAuthor(long itemId)
	{
		return MetadataPropertyValueLocalServiceUtil.getAuthor(itemId);
	}
	public List getItemTypes(long itemId)
	{
		List itemList =  ItemFinderUtil.getItemTypes(itemId);
		List itemType = (List)itemList.get(0);
		return itemType;
		
	}
	public List<Item> getDraftItems(int start,int end) throws SystemException
	{
		return itemPersistence.findByStatus(SuburConstant.SUBUR_DRAFT_ITEM,start,end);
	}
	public int getDraftItemCount() throws SystemException
	{
		return itemPersistence.countByStatus(SuburConstant.SUBUR_DRAFT_ITEM);
	}
	public List<Item> getByGroup(long groupId) throws SystemException
	{
		return itemPersistence.findByGroupId(groupId);
	}
}