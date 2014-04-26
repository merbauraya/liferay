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

package com.idetronic.eprint.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Eprint service. Represents a row in the &quot;Eprints_Eprint&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.eprint.model.impl.EprintModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.eprint.model.impl.EprintImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see Eprint
 * @see com.idetronic.eprint.model.impl.EprintImpl
 * @see com.idetronic.eprint.model.impl.EprintModelImpl
 * @generated
 */
public interface EprintModel extends BaseModel<Eprint> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a eprint model instance should use the {@link Eprint} interface instead.
	 */

	/**
	 * Returns the primary key of this eprint.
	 *
	 * @return the primary key of this eprint
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this eprint.
	 *
	 * @param primaryKey the primary key of this eprint
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the eprint ID of this eprint.
	 *
	 * @return the eprint ID of this eprint
	 */
	public long getEprintId();

	/**
	 * Sets the eprint ID of this eprint.
	 *
	 * @param eprintId the eprint ID of this eprint
	 */
	public void setEprintId(long eprintId);

	/**
	 * Returns the group ID of this eprint.
	 *
	 * @return the group ID of this eprint
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this eprint.
	 *
	 * @param groupId the group ID of this eprint
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the title of this eprint.
	 *
	 * @return the title of this eprint
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this eprint.
	 *
	 * @param title the title of this eprint
	 */
	public void setTitle(String title);

	/**
	 * Returns the url title of this eprint.
	 *
	 * @return the url title of this eprint
	 */
	@AutoEscape
	public String getUrlTitle();

	/**
	 * Sets the url title of this eprint.
	 *
	 * @param urlTitle the url title of this eprint
	 */
	public void setUrlTitle(String urlTitle);

	/**
	 * Returns the eprint type of this eprint.
	 *
	 * @return the eprint type of this eprint
	 */
	@AutoEscape
	public String getEprintType();

	/**
	 * Sets the eprint type of this eprint.
	 *
	 * @param eprintType the eprint type of this eprint
	 */
	public void setEprintType(String eprintType);

	/**
	 * Returns the eprint status of this eprint.
	 *
	 * @return the eprint status of this eprint
	 */
	@AutoEscape
	public String getEprintStatus();

	/**
	 * Sets the eprint status of this eprint.
	 *
	 * @param eprintStatus the eprint status of this eprint
	 */
	public void setEprintStatus(String eprintStatus);

	/**
	 * Returns the metadata visibility of this eprint.
	 *
	 * @return the metadata visibility of this eprint
	 */
	@AutoEscape
	public String getMetadataVisibility();

	/**
	 * Sets the metadata visibility of this eprint.
	 *
	 * @param metadataVisibility the metadata visibility of this eprint
	 */
	public void setMetadataVisibility(String metadataVisibility);

	/**
	 * Returns the eprint abstract of this eprint.
	 *
	 * @return the eprint abstract of this eprint
	 */
	@AutoEscape
	public String getEprintAbstract();

	/**
	 * Sets the eprint abstract of this eprint.
	 *
	 * @param eprintAbstract the eprint abstract of this eprint
	 */
	public void setEprintAbstract(String eprintAbstract);

	/**
	 * Returns the eprint keywords of this eprint.
	 *
	 * @return the eprint keywords of this eprint
	 */
	@AutoEscape
	public String getEprintKeywords();

	/**
	 * Sets the eprint keywords of this eprint.
	 *
	 * @param eprintKeywords the eprint keywords of this eprint
	 */
	public void setEprintKeywords(String eprintKeywords);

	/**
	 * Returns the is published of this eprint.
	 *
	 * @return the is published of this eprint
	 */
	@AutoEscape
	public String getIsPublished();

	/**
	 * Sets the is published of this eprint.
	 *
	 * @param isPublished the is published of this eprint
	 */
	public void setIsPublished(String isPublished);

	/**
	 * Returns the date year of this eprint.
	 *
	 * @return the date year of this eprint
	 */
	@AutoEscape
	public String getDateYear();

	/**
	 * Sets the date year of this eprint.
	 *
	 * @param dateYear the date year of this eprint
	 */
	public void setDateYear(String dateYear);

	/**
	 * Returns the full text status of this eprint.
	 *
	 * @return the full text status of this eprint
	 */
	@AutoEscape
	public String getFullTextStatus();

	/**
	 * Sets the full text status of this eprint.
	 *
	 * @param fullTextStatus the full text status of this eprint
	 */
	public void setFullTextStatus(String fullTextStatus);

	/**
	 * Returns the company ID of this eprint.
	 *
	 * @return the company ID of this eprint
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this eprint.
	 *
	 * @param companyId the company ID of this eprint
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the modified date of this eprint.
	 *
	 * @return the modified date of this eprint
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this eprint.
	 *
	 * @param modifiedDate the modified date of this eprint
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the created date of this eprint.
	 *
	 * @return the created date of this eprint
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this eprint.
	 *
	 * @param createdDate the created date of this eprint
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the user ID of this eprint.
	 *
	 * @return the user ID of this eprint
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this eprint.
	 *
	 * @param userId the user ID of this eprint
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this eprint.
	 *
	 * @return the user uuid of this eprint
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this eprint.
	 *
	 * @param userUuid the user uuid of this eprint
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this eprint.
	 *
	 * @return the user name of this eprint
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this eprint.
	 *
	 * @param userName the user name of this eprint
	 */
	public void setUserName(String userName);

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
	public int compareTo(Eprint eprint);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Eprint> toCacheModel();

	@Override
	public Eprint toEscapedModel();

	@Override
	public Eprint toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}