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

import com.idetronic.subur.service.persistence.MetadataValueViewPK;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the MetadataValueView service. Represents a row in the &quot;subur_MetadataValueView&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.subur.model.impl.MetadataValueViewModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.subur.model.impl.MetadataValueViewImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see MetadataValueView
 * @see com.idetronic.subur.model.impl.MetadataValueViewImpl
 * @see com.idetronic.subur.model.impl.MetadataValueViewModelImpl
 * @generated
 */
public interface MetadataValueViewModel extends BaseModel<MetadataValueView> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a metadata value view model instance should use the {@link MetadataValueView} interface instead.
	 */

	/**
	 * Returns the primary key of this metadata value view.
	 *
	 * @return the primary key of this metadata value view
	 */
	public MetadataValueViewPK getPrimaryKey();

	/**
	 * Sets the primary key of this metadata value view.
	 *
	 * @param primaryKey the primary key of this metadata value view
	 */
	public void setPrimaryKey(MetadataValueViewPK primaryKey);

	/**
	 * Returns the property ID of this metadata value view.
	 *
	 * @return the property ID of this metadata value view
	 */
	public long getPropertyId();

	/**
	 * Sets the property ID of this metadata value view.
	 *
	 * @param propertyId the property ID of this metadata value view
	 */
	public void setPropertyId(long propertyId);

	/**
	 * Returns the subject ID of this metadata value view.
	 *
	 * @return the subject ID of this metadata value view
	 */
	public long getSubjectId();

	/**
	 * Sets the subject ID of this metadata value view.
	 *
	 * @param subjectId the subject ID of this metadata value view
	 */
	public void setSubjectId(long subjectId);

	/**
	 * Returns the subject name of this metadata value view.
	 *
	 * @return the subject name of this metadata value view
	 */
	@AutoEscape
	public String getSubjectName();

	/**
	 * Sets the subject name of this metadata value view.
	 *
	 * @param subjectName the subject name of this metadata value view
	 */
	public void setSubjectName(String subjectName);

	/**
	 * Returns the text value of this metadata value view.
	 *
	 * @return the text value of this metadata value view
	 */
	@AutoEscape
	public String getTextValue();

	/**
	 * Sets the text value of this metadata value view.
	 *
	 * @param textValue the text value of this metadata value view
	 */
	public void setTextValue(String textValue);

	/**
	 * Returns the item count of this metadata value view.
	 *
	 * @return the item count of this metadata value view
	 */
	public int getItemCount();

	/**
	 * Sets the item count of this metadata value view.
	 *
	 * @param itemCount the item count of this metadata value view
	 */
	public void setItemCount(int itemCount);

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
	public int compareTo(MetadataValueView metadataValueView);

	@Override
	public int hashCode();

	@Override
	public CacheModel<MetadataValueView> toCacheModel();

	@Override
	public MetadataValueView toEscapedModel();

	@Override
	public MetadataValueView toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}