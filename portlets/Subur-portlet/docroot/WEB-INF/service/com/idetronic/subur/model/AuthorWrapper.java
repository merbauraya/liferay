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
		attributes.put("idType", getIdType());
		attributes.put("remoteId", getRemoteId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("userId", getUserId());
		attributes.put("metadata", getMetadata());

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

		Integer userId = (Integer)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String metadata = (String)attributes.get("metadata");

		if (metadata != null) {
			setMetadata(metadata);
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