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
import com.idetronic.subur.service.base.ItemItemTypeLocalServiceBaseImpl;
import com.idetronic.subur.service.persistence.ItemItemTypeFinderUtil;
import com.idetronic.subur.service.persistence.ItemItemTypePK;
import com.liferay.portal.kernel.exception.SystemException;

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
	public ItemItemType addItemType(long itemId,long itemTypeId) throws SystemException
	{
		ItemItemTypePK entryPK = new ItemItemTypePK();
		entryPK.setItemId(itemId);
		entryPK.setItemTypeId(itemTypeId);
		ItemItemType entry = itemItemTypePersistence.create(entryPK);
		super.updateItemItemType(entry);
		return entry;
		
	}
	public void setItemItemType(long itemId,String[] itemTypeStrings) throws SystemException
	{
		List<ItemItemType> itemItemTypes = itemItemTypePersistence.findByItemId(itemId);
		for (ItemItemType itemItemType: itemItemTypes)
		{
			super.deleteItemItemType(itemItemType);
		}
		for (String itemItemTypeString: itemTypeStrings)
		{

			ItemItemTypePK entryPK = new ItemItemTypePK();
			entryPK.setItemId(itemId);
			entryPK.setItemTypeId(Long.valueOf(itemItemTypeString));
			ItemItemType entry = itemItemTypePersistence.create(entryPK);
			super.updateItemItemType(entry);
			
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
	 * 
	 * @param itemId - Subur Item Id
	 * @return List of ItemType
	 * @throws SystemException
	 */
	public List<ItemItemType> itemTypeByItemid(long itemId) throws SystemException
	{
		return itemItemTypePersistence.findByItemId(itemId);
	}
}