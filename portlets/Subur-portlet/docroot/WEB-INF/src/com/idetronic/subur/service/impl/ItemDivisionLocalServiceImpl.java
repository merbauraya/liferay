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

import com.idetronic.subur.model.ItemDivision;
import com.idetronic.subur.model.ItemSubject;
import com.idetronic.subur.service.ItemSubjectLocalServiceUtil;
import com.idetronic.subur.service.base.ItemDivisionLocalServiceBaseImpl;
import com.idetronic.subur.service.persistence.ItemDivisionPK;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the item division local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.service.ItemDivisionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.base.ItemDivisionLocalServiceBaseImpl
 * @see com.idetronic.subur.service.ItemDivisionLocalServiceUtil
 */
public class ItemDivisionLocalServiceImpl
	extends ItemDivisionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.subur.service.ItemDivisionLocalServiceUtil} to access the item division local service.
	 */
	public ItemDivision addItemDivision(long itemId,long divisionId) throws SystemException
	{
		itemDivisionPersistence.removeByitemId(itemId);
		
		ItemDivisionPK pk = new ItemDivisionPK();
		pk.setDivisionId(divisionId);
		pk.setItemId(itemId);
		ItemDivision itemDiv = itemDivisionPersistence.create(pk);
		
		itemDivisionPersistence.update(itemDiv);
		return itemDiv;
		
	}
	public List<ItemDivision> getByItemId(long itemId) throws SystemException
	{
		return itemDivisionPersistence.findByitemId(itemId);
	}
}