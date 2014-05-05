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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Eprint}.
 * </p>
 *
 * @author Mazlan Mat
 * @see Eprint
 * @generated
 */
public class EprintWrapper implements Eprint, ModelWrapper<Eprint> {
	public EprintWrapper(Eprint eprint) {
		_eprint = eprint;
	}

	@Override
	public Class<?> getModelClass() {
		return Eprint.class;
	}

	@Override
	public String getModelClassName() {
		return Eprint.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eprintId", getEprintId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("title", getTitle());
		attributes.put("urlTitle", getUrlTitle());
		attributes.put("eprintType", getEprintType());
		attributes.put("eprintStatus", getEprintStatus());
		attributes.put("metadataVisibility", getMetadataVisibility());
		attributes.put("eprintAbstract", getEprintAbstract());
		attributes.put("eprintKeywords", getEprintKeywords());
		attributes.put("isPublished", getIsPublished());
		attributes.put("dateYear", getDateYear());
		attributes.put("fullTextStatus", getFullTextStatus());
		attributes.put("companyId", getCompanyId());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eprintId = (Long)attributes.get("eprintId");

		if (eprintId != null) {
			setEprintId(eprintId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String urlTitle = (String)attributes.get("urlTitle");

		if (urlTitle != null) {
			setUrlTitle(urlTitle);
		}

		String eprintType = (String)attributes.get("eprintType");

		if (eprintType != null) {
			setEprintType(eprintType);
		}

		String eprintStatus = (String)attributes.get("eprintStatus");

		if (eprintStatus != null) {
			setEprintStatus(eprintStatus);
		}

		String metadataVisibility = (String)attributes.get("metadataVisibility");

		if (metadataVisibility != null) {
			setMetadataVisibility(metadataVisibility);
		}

		String eprintAbstract = (String)attributes.get("eprintAbstract");

		if (eprintAbstract != null) {
			setEprintAbstract(eprintAbstract);
		}

		String eprintKeywords = (String)attributes.get("eprintKeywords");

		if (eprintKeywords != null) {
			setEprintKeywords(eprintKeywords);
		}

		String isPublished = (String)attributes.get("isPublished");

		if (isPublished != null) {
			setIsPublished(isPublished);
		}

		String dateYear = (String)attributes.get("dateYear");

		if (dateYear != null) {
			setDateYear(dateYear);
		}

		String fullTextStatus = (String)attributes.get("fullTextStatus");

		if (fullTextStatus != null) {
			setFullTextStatus(fullTextStatus);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}
	}

	/**
	* Returns the primary key of this eprint.
	*
	* @return the primary key of this eprint
	*/
	@Override
	public long getPrimaryKey() {
		return _eprint.getPrimaryKey();
	}

	/**
	* Sets the primary key of this eprint.
	*
	* @param primaryKey the primary key of this eprint
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_eprint.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the eprint ID of this eprint.
	*
	* @return the eprint ID of this eprint
	*/
	@Override
	public long getEprintId() {
		return _eprint.getEprintId();
	}

	/**
	* Sets the eprint ID of this eprint.
	*
	* @param eprintId the eprint ID of this eprint
	*/
	@Override
	public void setEprintId(long eprintId) {
		_eprint.setEprintId(eprintId);
	}

	/**
	* Returns the group ID of this eprint.
	*
	* @return the group ID of this eprint
	*/
	@Override
	public long getGroupId() {
		return _eprint.getGroupId();
	}

	/**
	* Sets the group ID of this eprint.
	*
	* @param groupId the group ID of this eprint
	*/
	@Override
	public void setGroupId(long groupId) {
		_eprint.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this eprint.
	*
	* @return the user ID of this eprint
	*/
	@Override
	public long getUserId() {
		return _eprint.getUserId();
	}

	/**
	* Sets the user ID of this eprint.
	*
	* @param userId the user ID of this eprint
	*/
	@Override
	public void setUserId(long userId) {
		_eprint.setUserId(userId);
	}

	/**
	* Returns the user uuid of this eprint.
	*
	* @return the user uuid of this eprint
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprint.getUserUuid();
	}

	/**
	* Sets the user uuid of this eprint.
	*
	* @param userUuid the user uuid of this eprint
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_eprint.setUserUuid(userUuid);
	}

	/**
	* Returns the title of this eprint.
	*
	* @return the title of this eprint
	*/
	@Override
	public java.lang.String getTitle() {
		return _eprint.getTitle();
	}

	/**
	* Sets the title of this eprint.
	*
	* @param title the title of this eprint
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_eprint.setTitle(title);
	}

	/**
	* Returns the url title of this eprint.
	*
	* @return the url title of this eprint
	*/
	@Override
	public java.lang.String getUrlTitle() {
		return _eprint.getUrlTitle();
	}

	/**
	* Sets the url title of this eprint.
	*
	* @param urlTitle the url title of this eprint
	*/
	@Override
	public void setUrlTitle(java.lang.String urlTitle) {
		_eprint.setUrlTitle(urlTitle);
	}

	/**
	* Returns the eprint type of this eprint.
	*
	* @return the eprint type of this eprint
	*/
	@Override
	public java.lang.String getEprintType() {
		return _eprint.getEprintType();
	}

	/**
	* Sets the eprint type of this eprint.
	*
	* @param eprintType the eprint type of this eprint
	*/
	@Override
	public void setEprintType(java.lang.String eprintType) {
		_eprint.setEprintType(eprintType);
	}

	/**
	* Returns the eprint status of this eprint.
	*
	* @return the eprint status of this eprint
	*/
	@Override
	public java.lang.String getEprintStatus() {
		return _eprint.getEprintStatus();
	}

	/**
	* Sets the eprint status of this eprint.
	*
	* @param eprintStatus the eprint status of this eprint
	*/
	@Override
	public void setEprintStatus(java.lang.String eprintStatus) {
		_eprint.setEprintStatus(eprintStatus);
	}

	/**
	* Returns the metadata visibility of this eprint.
	*
	* @return the metadata visibility of this eprint
	*/
	@Override
	public java.lang.String getMetadataVisibility() {
		return _eprint.getMetadataVisibility();
	}

	/**
	* Sets the metadata visibility of this eprint.
	*
	* @param metadataVisibility the metadata visibility of this eprint
	*/
	@Override
	public void setMetadataVisibility(java.lang.String metadataVisibility) {
		_eprint.setMetadataVisibility(metadataVisibility);
	}

	/**
	* Returns the eprint abstract of this eprint.
	*
	* @return the eprint abstract of this eprint
	*/
	@Override
	public java.lang.String getEprintAbstract() {
		return _eprint.getEprintAbstract();
	}

	/**
	* Sets the eprint abstract of this eprint.
	*
	* @param eprintAbstract the eprint abstract of this eprint
	*/
	@Override
	public void setEprintAbstract(java.lang.String eprintAbstract) {
		_eprint.setEprintAbstract(eprintAbstract);
	}

	/**
	* Returns the eprint keywords of this eprint.
	*
	* @return the eprint keywords of this eprint
	*/
	@Override
	public java.lang.String getEprintKeywords() {
		return _eprint.getEprintKeywords();
	}

	/**
	* Sets the eprint keywords of this eprint.
	*
	* @param eprintKeywords the eprint keywords of this eprint
	*/
	@Override
	public void setEprintKeywords(java.lang.String eprintKeywords) {
		_eprint.setEprintKeywords(eprintKeywords);
	}

	/**
	* Returns the is published of this eprint.
	*
	* @return the is published of this eprint
	*/
	@Override
	public java.lang.String getIsPublished() {
		return _eprint.getIsPublished();
	}

	/**
	* Sets the is published of this eprint.
	*
	* @param isPublished the is published of this eprint
	*/
	@Override
	public void setIsPublished(java.lang.String isPublished) {
		_eprint.setIsPublished(isPublished);
	}

	/**
	* Returns the date year of this eprint.
	*
	* @return the date year of this eprint
	*/
	@Override
	public java.lang.String getDateYear() {
		return _eprint.getDateYear();
	}

	/**
	* Sets the date year of this eprint.
	*
	* @param dateYear the date year of this eprint
	*/
	@Override
	public void setDateYear(java.lang.String dateYear) {
		_eprint.setDateYear(dateYear);
	}

	/**
	* Returns the full text status of this eprint.
	*
	* @return the full text status of this eprint
	*/
	@Override
	public java.lang.String getFullTextStatus() {
		return _eprint.getFullTextStatus();
	}

	/**
	* Sets the full text status of this eprint.
	*
	* @param fullTextStatus the full text status of this eprint
	*/
	@Override
	public void setFullTextStatus(java.lang.String fullTextStatus) {
		_eprint.setFullTextStatus(fullTextStatus);
	}

	/**
	* Returns the company ID of this eprint.
	*
	* @return the company ID of this eprint
	*/
	@Override
	public long getCompanyId() {
		return _eprint.getCompanyId();
	}

	/**
	* Sets the company ID of this eprint.
	*
	* @param companyId the company ID of this eprint
	*/
	@Override
	public void setCompanyId(long companyId) {
		_eprint.setCompanyId(companyId);
	}

	/**
	* Returns the modified date of this eprint.
	*
	* @return the modified date of this eprint
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _eprint.getModifiedDate();
	}

	/**
	* Sets the modified date of this eprint.
	*
	* @param modifiedDate the modified date of this eprint
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_eprint.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the created date of this eprint.
	*
	* @return the created date of this eprint
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _eprint.getCreatedDate();
	}

	/**
	* Sets the created date of this eprint.
	*
	* @param createdDate the created date of this eprint
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_eprint.setCreatedDate(createdDate);
	}

	@Override
	public boolean isNew() {
		return _eprint.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_eprint.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _eprint.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_eprint.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _eprint.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _eprint.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_eprint.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _eprint.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_eprint.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_eprint.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eprint.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EprintWrapper((Eprint)_eprint.clone());
	}

	@Override
	public int compareTo(com.idetronic.eprint.model.Eprint eprint) {
		return _eprint.compareTo(eprint);
	}

	@Override
	public int hashCode() {
		return _eprint.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eprint.model.Eprint> toCacheModel() {
		return _eprint.toCacheModel();
	}

	@Override
	public com.idetronic.eprint.model.Eprint toEscapedModel() {
		return new EprintWrapper(_eprint.toEscapedModel());
	}

	@Override
	public com.idetronic.eprint.model.Eprint toUnescapedModel() {
		return new EprintWrapper(_eprint.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _eprint.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _eprint.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_eprint.persist();
	}

	@Override
	public java.lang.String getSummary() {
		return _eprint.getSummary();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EprintWrapper)) {
			return false;
		}

		EprintWrapper eprintWrapper = (EprintWrapper)obj;

		if (Validator.equals(_eprint, eprintWrapper._eprint)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Eprint getWrappedEprint() {
		return _eprint;
	}

	@Override
	public Eprint getWrappedModel() {
		return _eprint;
	}

	@Override
	public void resetOriginalValues() {
		_eprint.resetOriginalValues();
	}

	private Eprint _eprint;
}