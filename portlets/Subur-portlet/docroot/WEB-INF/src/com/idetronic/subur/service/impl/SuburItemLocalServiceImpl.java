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
import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.service.MetadataPropertyValueLocalServiceUtil;
import com.idetronic.subur.service.base.SuburItemLocalServiceBaseImpl;
import com.idetronic.subur.service.persistence.ItemFinderUtil;
import com.idetronic.subur.service.persistence.SuburItemFinderUtil;
import com.idetronic.subur.util.SuburConstant;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.liferay.portlet.asset.service.AssetEntryLocalService;
import com.liferay.portlet.asset.service.AssetEntryService;
import com.liferay.portlet.asset.service.persistence.AssetCategoryUtil;
import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;

/**
 * The implementation of the subur item local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.service.SuburItemLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.base.SuburItemLocalServiceBaseImpl
 * @see com.idetronic.subur.service.SuburItemLocalServiceUtil
 */
public class SuburItemLocalServiceImpl extends SuburItemLocalServiceBaseImpl {
	private static Log logger = LogFactoryUtil.getLog(SuburItemLocalServiceImpl.class);
	public SuburItem addItem(long userId,long groupId,String title,String itemAbstract,
			ServiceContext serviceContext) throws PortalException, SystemException
	{
		User user = userLocalService.getUserById(userId);
		
		Date now = new Date();
		long itemId = counterLocalService.increment();
		
		SuburItem suburItem = suburItemPersistence.create(itemId);
		
		suburItem.setGroupId(groupId);
		suburItem.setCompanyId(user.getCompanyId());
		suburItem.setUserId(userId);
		suburItem.setCreateDate(now);
		suburItem.setModifiedDate(now);
		suburItem.setTitle(title);
		suburItem.setItemAbstract(itemAbstract);
		suburItem.setUuid(serviceContext.getUuid());
		
		suburItemPersistence.update(suburItem);
		
		resourceLocalService.addResources(suburItem.getCompanyId(), suburItem.getGroupId(), 
				suburItem.getUserId(), SuburItem.class.getName(), suburItem.getItemId(), 
				false, true, true);
		
		logger.info("addresource-set");
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
                SuburItem.class);

		indexer.reindex(suburItem);
		try
		{
			
			AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
                    groupId, suburItem.getCreateDate(),
                    suburItem.getModifiedDate(), SuburItem.class.getName(),
                    suburItem.getItemId(), suburItem.getUuid(), 0,
                    serviceContext.getAssetCategoryIds(),
                    serviceContext.getAssetTagNames(), true, null, null, null,
                    ContentTypes.TEXT_HTML, suburItem.getTitle(), null, null, null,
                    null, 0, 0, null, false);
                   
		}catch (Exception e)
		{
			logger.error(e);
		}
		
		
		logger.info("reindex-set");
		return suburItem;
	}
	public SuburItem updateSuburItem(SuburItem suburItem,long userId,ServiceContext serviceContext) throws SystemException
	{
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
                SuburItem.class);
		long groupId = serviceContext.getScopeGroupId();
		
		try
		{
			indexer.reindex(suburItem);
			AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
                    groupId, suburItem.getCreateDate(),
                    suburItem.getModifiedDate(), SuburItem.class.getName(),
                    suburItem.getItemId(), suburItem.getUuid(), 0,
                    serviceContext.getAssetCategoryIds(),
                    serviceContext.getAssetTagNames(), true, null, null, null,
                    ContentTypes.TEXT_HTML, suburItem.getTitle(), null, null, null,
                    null, 0, 0, null, false);
			assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
                    serviceContext.getAssetLinkEntryIds(),
                    AssetLinkConstants.TYPE_RELATED);
			logger.info("cat="+serviceContext.getAssetCategoryIds());
		}catch (Exception e)
		{
			logger.error(e);
		}
		return suburItemPersistence.update(suburItem);
		
	}
	/*
	public List getAuthor(long itemId)
	{
		return MetadataPropertyValueLocalServiceUtil.getAuthor(itemId);
	}*/
	public List getItemTypes(long itemId)
	{
		List itemList =  SuburItemFinderUtil.getItemTypes(itemId);// .getItemTypes(itemId);
		List itemType = (List)itemList.get(0);
		return itemType;
		
	}
	public List<SuburItem> getDraftItems(int start,int end) throws SystemException
	{
		return suburItemPersistence.findByStatus(SuburConstant.SUBUR_DRAFT_ITEM,start,end);
	}
	public int getDraftItemCount() throws SystemException
	{
		return suburItemPersistence.countByStatus(SuburConstant.SUBUR_DRAFT_ITEM);
	}
	public List<SuburItem> getByGroup(long groupId) throws SystemException
	{
		return suburItemPersistence.findByGroupId(groupId);
	}
	public List getDetails(long itemId)
	{
		List itemList =  SuburItemFinderUtil.getItemDetails(itemId);// .getItemTypes(itemId);
		return itemList;
	}
	public List getFileEntry(long itemId)
	{
		return SuburItemFinderUtil.getFileEntries(itemId);
	}
	
	/*
	 * Return list of Subur Item for any given subject Id
	 */
	public List<SuburItem> getBySubjectId(long subjectId,int start,int end)
	{
		List listItems = SuburItemFinderUtil.getItemBySubjectId(subjectId,start,end);
		logger.info("null="+Validator.isNull(listItems));
		List<SuburItem> items =  (List)listItems.get(0);
		return items;
	}
	public int countAssetVocabularyById(long vocabularyId) throws SystemException
	{
		return AssetCategoryUtil.countByVocabularyId(vocabularyId);
	}
}