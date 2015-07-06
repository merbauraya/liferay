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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.idetronic.subur.NoSuchSuburItemException;
import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.service.AuthorLocalServiceUtil;
import com.idetronic.subur.service.ItemAuthorLocalServiceUtil;
import com.idetronic.subur.service.ItemItemTypeLocalServiceUtil;
import com.idetronic.subur.service.base.SuburItemLocalServiceBaseImpl;
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
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.liferay.portlet.asset.service.persistence.AssetCategoryUtil;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

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
			long[] itemTypeId,ServiceContext serviceContext) throws PortalException, SystemException
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
		suburItem.setUuid(PortalUUIDUtil.generate());
		
		suburItemPersistence.update(suburItem);
		ItemItemTypeLocalServiceUtil.addItemItemType(itemId, itemTypeId);
		
				
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
                SuburItem.class);

		indexer.reindex(suburItem);
		//only show item with published status
		boolean visible = (suburItem.getStatus() == SuburConstant.STATUS_PUBLISHED_ITEM);
		String itemDescription = null;
		String summary = null;
		String url = null;
		String layoutUuid = null;
			
		resourceLocalService.addResources(suburItem.getCompanyId(), suburItem.getGroupId(), 
				suburItem.getUserId(), SuburItem.class.getName(), suburItem.getItemId(), 
				false, true, true);
		
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
                groupId, suburItem.getCreateDate(),
                suburItem.getModifiedDate(), SuburItem.class.getName(),
                suburItem.getItemId(), suburItem.getUuid(), 0,
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(), visible, null, null, null,
                ContentTypes.TEXT_HTML, suburItem.getTitle(), itemDescription, summary, url,
                layoutUuid, 0, 0, null, false);
                   
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("itemType", 1);
		assetEntry.setModelAttributes(attributes);
		assetEntryLocalService.updateAssetEntry(assetEntry);
		
		return suburItem;
	}
	
	@Override
	public SuburItem updateSuburItem(SuburItem suburItem,long userId,
			long[] itemTypeIds, long[] authorIds, ServiceContext serviceContext) throws PortalException,SystemException 
	{
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
                SuburItem.class);
		long groupId = serviceContext.getScopeGroupId();
		
		if (Validator.isNull(suburItem.getPublishedDate()) && suburItem.getStatus() == SuburConstant.STATUS_PUBLISHED_ITEM)
			suburItem.setPublishedDate(new Date());
		
		//only show item with published status
		boolean visible = (suburItem.getStatus() == SuburConstant.STATUS_PUBLISHED_ITEM);
		String itemDescription = null;
		String summary = null;
		String url = null;
		String layoutUuid = null;
		Date publishedDate = suburItem.getPublishedDate();
		
		indexer.reindex(suburItem);
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
                groupId, suburItem.getCreateDate(),
                suburItem.getModifiedDate(), SuburItem.class.getName(),
                suburItem.getItemId(), suburItem.getUuid(), 0,
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(), visible, null, null, null,
                ContentTypes.TEXT_HTML, suburItem.getTitle(), itemDescription, summary, url,
                layoutUuid, 0, 0, null, false);

		//if status is published, ensure to update asset entry published date
		if (Validator.isNull(assetEntry.getPublishDate()) && suburItem.getStatus() == SuburConstant.STATUS_PUBLISHED_ITEM)
			assetEntryLocalService.updateEntry(
					SuburItem.class.getName(), suburItem.getItemId(), suburItem.getPublishedDate(),
					true);
		
		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
                serviceContext.getAssetLinkEntryIds(),
                AssetLinkConstants.TYPE_RELATED);
		
		ItemAuthorLocalServiceUtil.setItemAuthor(suburItem.getItemId(), authorIds);
		AuthorLocalServiceUtil.updateAuthorPosting(suburItem);
		
		
		
		
		
		
		ItemItemTypeLocalServiceUtil.updateItemItemType(suburItem.getItemId(),itemTypeIds);
		return suburItemPersistence.update(suburItem);
		
	}
	
	public void deleteItem(long itemId) throws SystemException, NoSuchSuburItemException
	{
		SuburItem suburItem = suburItemPersistence.findByPrimaryKey(itemId);
		suburItemLocalService.deleteSuburItem(suburItem);
		
	}
	public void deleteItem(SuburItem suburItem) throws SystemException, PortalException
	{
		
		
		resourceLocalService.deleteResource(suburItem.getCompanyId(),SuburItem.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL,suburItem.getItemId());
		
		
		
		// Asset

		assetEntryLocalService.deleteEntry(
			SuburItem.class.getName(), suburItem.getItemId());
		
		

		suburItemPersistence.remove(suburItem);
		
		
		// Indexer

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			SuburItem.class);

		indexer.delete(suburItem);
				
				
	}
	
	public List getItemTypes(long itemId)
	{
		List itemList =  SuburItemFinderUtil.getItemTypes(itemId);// .getItemTypes(itemId);
		List itemType = (List)itemList.get(0);
		return itemType;
		
	}
	public List<SuburItem> getSuburItems(int start,int end,int status) throws SystemException
	{
		if (status != SuburConstant.STATUS_ANY)
			return suburItemPersistence.findByStatus(status,start,end);
		else
			return suburItemPersistence.findAll(start, end);
	}
	/**
	 * Publish a subur item
	 * @param itemId subur Item Id
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public SuburItem publishItem(long itemId) throws SystemException, PortalException
	{
		SuburItem suburItem = suburItemPersistence.fetchByPrimaryKey(itemId);
		suburItem.setStatus(SuburConstant.STATUS_PUBLISHED_ITEM);
		suburItem.setPublishedDate(new Date());
		assetEntryLocalService.updateEntry(
				SuburItem.class.getName(), suburItem.getItemId(), suburItem.getPublishedDate(),
				true);
		return suburItemPersistence.update(suburItem);
	}
	
	/**
	 * Withdraw item from public viewing
	 * @param itemId
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public SuburItem withDrawItem(long itemId) throws SystemException, PortalException
	{
		SuburItem suburItem = suburItemPersistence.fetchByPrimaryKey(itemId);
		suburItem.setStatus(SuburConstant.STATUS_WITHDRAWN_ITEM);
		assetEntryLocalService.updateEntry(
				SuburItem.class.getName(), suburItem.getItemId(), null,
				false);
		
		return suburItemPersistence.update(suburItem);
	}
	
	public int getItemCount(int status) throws SystemException
	{
		if (status != SuburConstant.STATUS_ANY)
			return suburItemPersistence.countByStatus(SuburConstant.STATUS_DRAFT_ITEM);
		else
			return suburItemPersistence.countAll();
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
		
		List<SuburItem> items =  (List)listItems.get(0);
		return items;
	}
	public int countAssetVocabularyById(long vocabularyId) throws SystemException
	{
		return AssetCategoryUtil.countByVocabularyId(vocabularyId);
	}
}