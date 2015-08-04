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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Author}.
 * </p>
 *
 * @author Mazlan Mat
 * @see Author
 * @generated
 */
public class AuthorWrapper implements Author, ModelWrapper<Author> {
	public AuthorWrapper(Author author) {
		_author = author;
	}

	@Override
	public Class<?> getModelClass() {
		return Author.class;
	}

	@Override
	public String getModelClassName() {
		return Author.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("authorId", getAuthorId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("title", getTitle());
		attributes.put("idType", getIdType());
		attributes.put("remoteId", getRemoteId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("middleName", getMiddleName());
		attributes.put("userId", getUserId());
		attributes.put("metadata", getMetadata());
		attributes.put("lastPublishedDate", getLastPublishedDate());
		attributes.put("itemCount", getItemCount());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("Uuid", getUuid());
		attributes.put("createdBy", getCreatedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long authorId = (Long)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Integer idType = (Integer)attributes.get("idType");

		if (idType != null) {
			setIdType(idType);
		}

		String remoteId = (String)attributes.get("remoteId");

		if (remoteId != null) {
			setRemoteId(remoteId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String middleName = (String)attributes.get("middleName");

		if (middleName != null) {
			setMiddleName(middleName);
		}

		Integer userId = (Integer)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String metadata = (String)attributes.get("metadata");

		if (metadata != null) {
			setMetadata(metadata);
		}

		Date lastPublishedDate = (Date)attributes.get("lastPublishedDate");

		if (lastPublishedDate != null) {
			setLastPublishedDate(lastPublishedDate);
		}

		Integer itemCount = (Integer)attributes.get("itemCount");

		if (itemCount != null) {
			setItemCount(itemCount);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String Uuid = (String)attributes.get("Uuid");

		if (Uuid != null) {
			setUuid(Uuid);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}
	}

	/**
	* Returns the primary key of this author.
	*
	* @return the primary key of this author
	*/
	@Override
	public long getPrimaryKey() {
		return _author.getPrimaryKey();
	}

	/**
	* Sets the primary key of this author.
	*
	* @param primaryKey the primary key of this author
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_author.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the author ID of this author.
	*
	* @return the author ID of this author
	*/
	@Override
	public long getAuthorId() {
		return _author.getAuthorId();
	}

	/**
	* Sets the author ID of this author.
	*
	* @param authorId the author ID of this author
	*/
	@Override
	public void setAuthorId(long authorId) {
		_author.setAuthorId(authorId);
	}

	/**
	* Returns the group ID of this author.
	*
	* @return the group ID of this author
	*/
	@Override
	public long getGroupId() {
		return _author.getGroupId();
	}

	/**
	* Sets the group ID of this author.
	*
	* @param groupId the group ID of this author
	*/
	@Override
	public void setGroupId(long groupId) {
		_author.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this author.
	*
	* @return the company ID of this author
	*/
	@Override
	public long getCompanyId() {
		return _author.getCompanyId();
	}

	/**
	* Sets the company ID of this author.
	*
	* @param companyId the company ID of this author
	*/
	@Override
	public void setCompanyId(long companyId) {
		_author.setCompanyId(companyId);
	}

	/**
	* Returns the title of this author.
	*
	* @return the title of this author
	*/
	@Override
	public java.lang.String getTitle() {
		return _author.getTitle();
	}

	/**
	* Sets the title of this author.
	*
	* @param title the title of this author
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_author.setTitle(title);
	}

	/**
	* Returns the id type of this author.
	*
	* @return the id type of this author
	*/
	@Override
	public int getIdType() {
		return _author.getIdType();
	}

	/**
	* Sets the id type of this author.
	*
	* @param idType the id type of this author
	*/
	@Override
	public void setIdType(int idType) {
		_author.setIdType(idType);
	}

	/**
	* Returns the remote ID of this author.
	*
	* @return the remote ID of this author
	*/
	@Override
	public java.lang.String getRemoteId() {
		return _author.getRemoteId();
	}

	/**
	* Sets the remote ID of this author.
	*
	* @param remoteId the remote ID of this author
	*/
	@Override
	public void setRemoteId(java.lang.String remoteId) {
		_author.setRemoteId(remoteId);
	}

	/**
	* Returns the first name of this author.
	*
	* @return the first name of this author
	*/
	@Override
	public java.lang.String getFirstName() {
		return _author.getFirstName();
	}

	/**
	* Sets the first name of this author.
	*
	* @param firstName the first name of this author
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_author.setFirstName(firstName);
	}

	/**
	* Returns the last name of this author.
	*
	* @return the last name of this author
	*/
	@Override
	public java.lang.String getLastName() {
		return _author.getLastName();
	}

	/**
	* Sets the last name of this author.
	*
	* @param lastName the last name of this author
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_author.setLastName(lastName);
	}

	/**
	* Returns the middle name of this author.
	*
	* @return the middle name of this author
	*/
	@Override
	public java.lang.String getMiddleName() {
		return _author.getMiddleName();
	}

	/**
	* Sets the middle name of this author.
	*
	* @param middleName the middle name of this author
	*/
	@Override
	public void setMiddleName(java.lang.String middleName) {
		_author.setMiddleName(middleName);
	}

	/**
	* Returns the user ID of this author.
	*
	* @return the user ID of this author
	*/
	@Override
	public int getUserId() {
		return _author.getUserId();
	}

	/**
	* Sets the user ID of this author.
	*
	* @param userId the user ID of this author
	*/
	@Override
	public void setUserId(int userId) {
		_author.setUserId(userId);
	}

	/**
	* Returns the metadata of this author.
	*
	* @return the metadata of this author
	*/
	@Override
	public java.lang.String getMetadata() {
		return _author.getMetadata();
	}

	/**
	* Sets the metadata of this author.
	*
	* @param metadata the metadata of this author
	*/
	@Override
	public void setMetadata(java.lang.String metadata) {
		_author.setMetadata(metadata);
	}

	/**
	* Returns the last published date of this author.
	*
	* @return the last published date of this author
	*/
	@Override
	public java.util.Date getLastPublishedDate() {
		return _author.getLastPublishedDate();
	}

	/**
	* Sets the last published date of this author.
	*
	* @param lastPublishedDate the last published date of this author
	*/
	@Override
	public void setLastPublishedDate(java.util.Date lastPublishedDate) {
		_author.setLastPublishedDate(lastPublishedDate);
	}

	/**
	* Returns the item count of this author.
	*
	* @return the item count of this author
	*/
	@Override
	public int getItemCount() {
		return _author.getItemCount();
	}

	/**
	* Sets the item count of this author.
	*
	* @param itemCount the item count of this author
	*/
	@Override
	public void setItemCount(int itemCount) {
		_author.setItemCount(itemCount);
	}

	/**
	* Returns the create date of this author.
	*
	* @return the create date of this author
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _author.getCreateDate();
	}

	/**
	* Sets the create date of this author.
	*
	* @param createDate the create date of this author
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_author.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this author.
	*
	* @return the modified date of this author
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _author.getModifiedDate();
	}

	/**
	* Sets the modified date of this author.
	*
	* @param modifiedDate the modified date of this author
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_author.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the uuid of this author.
	*
	* @return the uuid of this author
	*/
	@Override
	public java.lang.String getUuid() {
		return _author.getUuid();
	}

	/**
	* Sets the uuid of this author.
	*
	* @param Uuid the uuid of this author
	*/
	@Override
	public void setUuid(java.lang.String Uuid) {
		_author.setUuid(Uuid);
	}

	/**
	* Returns the created by of this author.
	*
	* @return the created by of this author
	*/
	@Override
	public long getCreatedBy() {
		return _author.getCreatedBy();
	}

	/**
	* Sets the created by of this author.
	*
	* @param createdBy the created by of this author
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_author.setCreatedBy(createdBy);
	}

	@Override
	public boolean isNew() {
		return _author.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_author.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _author.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_author.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _author.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _author.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_author.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _author.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_author.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_author.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_author.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AuthorWrapper((Author)_author.clone());
	}

	@Override
	public int compareTo(com.idetronic.subur.model.Author author) {
		return _author.compareTo(author);
	}

	@Override
	public int hashCode() {
		return _author.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.Author> toCacheModel() {
		return _author.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.Author toEscapedModel() {
		return new AuthorWrapper(_author.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.Author toUnescapedModel() {
		return new AuthorWrapper(_author.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _author.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _author.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_author.persist();
	}

	@Override
	public java.lang.String getDisplayName() {
		return _author.getDisplayName();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AuthorWrapper)) {
			return false;
		}

		AuthorWrapper authorWrapper = (AuthorWrapper)obj;

		if (Validator.equals(_author, authorWrapper._author)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Author getWrappedAuthor() {
		return _author;
	}

	@Override
	public Author getWrappedModel() {
		return _author;
	}

	@Override
	public void resetOriginalValues() {
		_author.resetOriginalValues();
	}

	private Author _author;
}