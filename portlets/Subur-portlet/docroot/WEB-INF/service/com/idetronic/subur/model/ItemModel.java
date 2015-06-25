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

package com.idetronic.subur.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Item service. Represents a row in the &quot;subur_Item&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.subur.model.impl.ItemModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.subur.model.impl.ItemImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see Item
 * @see com.idetronic.subur.model.impl.ItemImpl
 * @see com.idetronic.subur.model.impl.ItemModelImpl
 * @generated
 */
public interface ItemModel extends BaseModel<Item>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a item model instance should use the {@link Item} interface instead.
	 */

	/**
	 * Returns the primary key of this item.
	 *
	 * @return the primary key of this item
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this item.
	 *
	 * @param primaryKey the primary key of this item
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the item ID of this item.
	 *
	 * @return the item ID of this item
	 */
	public long getItemId();

	/**
	 * Sets the item ID of this item.
	 *
	 * @param itemId the item ID of this item
	 */
	public void setItemId(long itemId);

	/**
	 * Returns the company ID of this item.
	 *
	 * @return the company ID of this item
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this item.
	 *
	 * @param companyId the company ID of this item
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this item.
	 *
	 * @return the group ID of this item
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this item.
	 *
	 * @param groupId the group ID of this item
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this item.
	 *
	 * @return the user ID of this item
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this item.
	 *
	 * @param userId the user ID of this item
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this item.
	 *
	 * @return the user uuid of this item
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this item.
	 *
	 * @param userUuid the user uuid of this item
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this item.
	 *
	 * @return the user name of this item
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this item.
	 *
	 * @param userName the user name of this item
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this item.
	 *
	 * @return the create date of this item
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this item.
	 *
	 * @param createDate the create date of this item
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this item.
	 *
	 * @return the modified date of this item
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this item.
	 *
	 * @param modifiedDate the modified date of this item
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the title of this item.
	 *
	 * @return the title of this item
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this item.
	 *
	 * @param title the title of this item
	 */
	public void setTitle(String title);

	/**
	 * Returns the item abstract of this item.
	 *
	 * @return the item abstract of this item
	 */
	@AutoEscape
	public String getItemAbstract();

	/**
	 * Sets the item abstract of this item.
	 *
	 * @param itemAbstract the item abstract of this item
	 */
	public void setItemAbstract(String itemAbstract);

	/**
	 * Returns the status of this item.
	 *
	 * @return the status of this item
	 */
	public int getStatus();

	/**
	 * Sets the status of this item.
	 *
	 * @param status the status of this item
	 */
	public void setStatus(int status);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Item item);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Item> toCacheModel();

	@Override
	public Item toEscapedModel();

	@Override
	public Item toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}