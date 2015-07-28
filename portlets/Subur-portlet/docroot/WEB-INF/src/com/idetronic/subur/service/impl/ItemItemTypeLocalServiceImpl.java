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

import java.util.List;

import com.idetronic.subur.model.ItemItemType;
import com.idetronic.subur.model.ItemType;
import com.idetronic.subur.service.ItemTypeLocalServiceUtil;
import com.idetronic.subur.service.base.ItemItemTypeLocalServiceBaseImpl;
import com.idetronic.subur.service.persistence.ItemItemTypeFinderImpl;
import com.idetronic.subur.service.persistence.ItemItemTypeFinderUtil;
import com.idetronic.subur.service.persistence.ItemItemTypePK;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sun.istack.internal.logging.Logger;

/**
 * The implementation of the item item type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.service.ItemItemTypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.base.ItemItemTypeLocalServiceBaseImpl
 * @see com.idetronic.subur.service.ItemItemTypeLocalServiceUtil
 */
public class ItemItemTypeLocalServiceImpl
	extends ItemItemTypeLocalServiceBaseImpl {
	
	private static Log logger = LogFactoryUtil.getLog(ItemItemTypeLocalServiceImpl.class);
	
	public ItemItemType addItemType(long itemId,long itemTypeId) throws SystemException
	{
		ItemItemTypePK entryPK = new ItemItemTypePK();
		entryPK.setItemId(itemId);
		entryPK.setItemTypeId(itemTypeId);
		ItemItemType entry = itemItemTypePersistence.create(entryPK);
		super.updateItemItemType(entry);
		ItemTypeLocalServiceUtil.incrementCounter(itemTypeId);
		return entry;
		
	}
	public void addItemItemType(long itemId,long[] itemTypeIds) throws SystemException
	{
		List<ItemItemType> itemItemTypes = itemItemTypePersistence.findByItemId(itemId);
		
		for (long itemTypeId: itemTypeIds)
		{
			logger.info("id="+itemId + " :type="+ itemTypeId);
			ItemItemTypePK entryPK = new ItemItemTypePK();
			entryPK.setItemId(itemId);
			entryPK.setItemTypeId(itemTypeId);
			ItemItemType entry = itemItemTypePersistence.create(entryPK);
			itemItemTypePersistence.update(entry);
			ItemTypeLocalServiceUtil.incrementCounter(itemTypeId);
			
			
		}
		
	}
	
	public void addItemItemType(long itemId,String[] itemTypeStrings) throws SystemException
	{
		List<ItemItemType> itemItemTypes = itemItemTypePersistence.findByItemId(itemId);
		
		for (String itemItemTypeString: itemTypeStrings)
		{
			long itemTypeId = Long.valueOf(itemItemTypeString);
			ItemItemTypePK entryPK = new ItemItemTypePK();
			entryPK.setItemId(itemId);
			entryPK.setItemTypeId(itemTypeId);
			ItemItemType entry = itemItemTypePersistence.create(entryPK);
			super.updateItemItemType(entry);
			ItemTypeLocalServiceUtil.incrementCounter(itemTypeId);
			
			
		}
		
	}
	public void updateItemItemType(long itemId,long[] itemTypeIds) throws SystemException
	{
		//find existing item type
		List<ItemItemType> itemItemTypes = itemItemTypePersistence.findByItemId(itemId);
		for (ItemItemType itemItemType: itemItemTypes)
		{
			ItemTypeLocalServiceUtil.decrementCounter(itemItemType.getItemTypeId());
			super.deleteItemItemType(itemItemType);
		}
		for (long itemTypeId : itemTypeIds)
		{
			
			ItemItemTypePK entryPK = new ItemItemTypePK();
			entryPK.setItemId(itemId);
			entryPK.setItemTypeId(itemTypeId);
			ItemItemType entry = itemItemTypePersistence.create(entryPK);
			super.updateItemItemType(entry);
			ItemTypeLocalServiceUtil.incrementCounter(itemTypeId);
			
		}
		
	}
	public void updateItemItemType(long itemId,String[] itemTypeStrings) throws SystemException
	{
		//find existing item type
		List<ItemItemType> itemItemTypes = itemItemTypePersistence.findByItemId(itemId);
		for (ItemItemType itemItemType: itemItemTypes)
		{
			ItemTypeLocalServiceUtil.decrementCounter(itemItemType.getItemTypeId());
			super.deleteItemItemType(itemItemType);
		}
		for (String itemItemTypeString: itemTypeStrings)
		{
			long itemTypeId = Long.valueOf(itemItemTypeString);
			ItemItemTypePK entryPK = new ItemItemTypePK();
			entryPK.setItemId(itemId);
			entryPK.setItemTypeId(itemTypeId);
			ItemItemType entry = itemItemTypePersistence.create(entryPK);
			super.updateItemItemType(entry);
			ItemTypeLocalServiceUtil.incrementCounter(itemTypeId);
			
		}
		
	}
	/**
	 * Return item type and item item type by any given item id
	 * It return array list of the following
	 * Index 0 - Item Type
	 * Index 1 - Item Ite Type
	 * This is useful when building user interface for list of item type and selected item type
	 */
	public List getByItemId(long itemId) throws SystemException
	{
		return ItemItemTypeFinderUtil.getByItem(itemId);
				//itemItemTypePersistence.findByItemId(itemId);
	}
	/**
	 * Get item type for an item, and return it in object array
	 *
	 * @param itemId to search for
	 * @return array of ItemType for an item
	 */
	public Object[] getByItemIdArray(long itemId)
	{
		List itemTypes = ItemItemTypeFinderUtil.getByItem(itemId);

		Object[] itemTypesArray = new ItemType[itemTypes.size()];
		
		Object xx = itemTypes.get(0);

		for (int i = 0; i < itemTypes.size(); i ++)
		{
			Object object = itemTypes.get(i);

			itemTypesArray[i] = (ItemType)itemTypes.get(i);
		}
		return itemTypesArray;
		
	}
	
	/**
	 * 
	 * @param itemId - Subur Item Id
	 * @return List of ItemItemType
	 * @throws SystemException
	 */
	public List<ItemItemType> itemTypeByItemid(long itemId) throws SystemException
	{
		
		List<ItemItemType> itemTypes = itemItemTypePersistence.findByItemId(itemId);
		logger.info("id="+itemId +" size="+itemTypes.size());
		return itemTypes;
	}
}