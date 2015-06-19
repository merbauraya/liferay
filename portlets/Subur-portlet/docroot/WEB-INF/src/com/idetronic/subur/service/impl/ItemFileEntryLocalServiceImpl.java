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

import com.idetronic.subur.NoSuchItemFileEntryException;
import com.idetronic.subur.model.ItemFileEntry;
import com.idetronic.subur.service.base.ItemFileEntryLocalServiceBaseImpl;
import com.idetronic.subur.service.persistence.ItemFileEntryPK;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the item file entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.service.ItemFileEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.base.ItemFileEntryLocalServiceBaseImpl
 * @see com.idetronic.subur.service.ItemFileEntryLocalServiceUtil
 */
public class ItemFileEntryLocalServiceImpl
	extends ItemFileEntryLocalServiceBaseImpl {
	
	public void add(long itemId,long fileEntryId,long entryType) throws SystemException
	{
		ItemFileEntryPK itemFileEntryPK = new ItemFileEntryPK(itemId,fileEntryId);
		ItemFileEntry itemFileEntry = itemFileEntryPersistence.create(itemFileEntryPK);
		
		itemFileEntry.setEntryType(entryType);
		itemFileEntryPersistence.updateImpl(itemFileEntry);
		
	}
	public void delete(long itemId,long fileEntryId) throws NoSuchItemFileEntryException, SystemException
	{
		ItemFileEntryPK pk = new ItemFileEntryPK();
		pk.fileEntryId = fileEntryId;
		pk.itemId = itemId;
		itemFileEntryPersistence.remove(pk);
	}
	public List getByItemId(long itemId) throws SystemException
	{
		return itemFileEntryPersistence.findBybyItemId(itemId);
	}
	
}