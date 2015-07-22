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

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the DownloadSummary service. Represents a row in the &quot;Subur_DownloadSummary&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.subur.model.impl.DownloadSummaryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.subur.model.impl.DownloadSummaryImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see DownloadSummary
 * @see com.idetronic.subur.model.impl.DownloadSummaryImpl
 * @see com.idetronic.subur.model.impl.DownloadSummaryModelImpl
 * @generated
 */
public interface DownloadSummaryModel extends BaseModel<DownloadSummary> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a download summary model instance should use the {@link DownloadSummary} interface instead.
	 */

	/**
	 * Returns the primary key of this download summary.
	 *
	 * @return the primary key of this download summary
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this download summary.
	 *
	 * @param primaryKey the primary key of this download summary
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this download summary.
	 *
	 * @return the ID of this download summary
	 */
	public long getId();

	/**
	 * Sets the ID of this download summary.
	 *
	 * @param id the ID of this download summary
	 */
	public void setId(long id);

	/**
	 * Returns the item ID of this download summary.
	 *
	 * @return the item ID of this download summary
	 */
	public long getItemId();

	/**
	 * Sets the item ID of this download summary.
	 *
	 * @param itemId the item ID of this download summary
	 */
	public void setItemId(long itemId);

	/**
	 * Returns the per month of this download summary.
	 *
	 * @return the per month of this download summary
	 */
	public int getPerMonth();

	/**
	 * Sets the per month of this download summary.
	 *
	 * @param perMonth the per month of this download summary
	 */
	public void setPerMonth(int perMonth);

	/**
	 * Returns the per year of this download summary.
	 *
	 * @return the per year of this download summary
	 */
	public int getPerYear();

	/**
	 * Sets the per year of this download summary.
	 *
	 * @param perYear the per year of this download summary
	 */
	public void setPerYear(int perYear);

	/**
	 * Returns the status of this download summary.
	 *
	 * @return the status of this download summary
	 */
	public int getStatus();

	/**
	 * Sets the status of this download summary.
	 *
	 * @param status the status of this download summary
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
	public int compareTo(
		com.idetronic.subur.model.DownloadSummary downloadSummary);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.idetronic.subur.model.DownloadSummary> toCacheModel();

	@Override
	public com.idetronic.subur.model.DownloadSummary toEscapedModel();

	@Override
	public com.idetronic.subur.model.DownloadSummary toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}