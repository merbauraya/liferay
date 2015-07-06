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
 * This class is a wrapper for {@link AuthorExpertise}.
 * </p>
 *
 * @author Mazlan Mat
 * @see AuthorExpertise
 * @generated
 */
public class AuthorExpertiseWrapper implements AuthorExpertise,
	ModelWrapper<AuthorExpertise> {
	public AuthorExpertiseWrapper(AuthorExpertise authorExpertise) {
		_authorExpertise = authorExpertise;
	}

	@Override
	public Class<?> getModelClass() {
		return AuthorExpertise.class;
	}

	@Override
	public String getModelClassName() {
		return AuthorExpertise.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("authorId", getAuthorId());
		attributes.put("expertiseId", getExpertiseId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long authorId = (Long)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
		}

		Long expertiseId = (Long)attributes.get("expertiseId");

		if (expertiseId != null) {
			setExpertiseId(expertiseId);
		}
	}

	/**
	* Returns the primary key of this author expertise.
	*
	* @return the primary key of this author expertise
	*/
	@Override
	public com.idetronic.subur.service.persistence.AuthorExpertisePK getPrimaryKey() {
		return _authorExpertise.getPrimaryKey();
	}

	/**
	* Sets the primary key of this author expertise.
	*
	* @param primaryKey the primary key of this author expertise
	*/
	@Override
	public void setPrimaryKey(
		com.idetronic.subur.service.persistence.AuthorExpertisePK primaryKey) {
		_authorExpertise.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the author ID of this author expertise.
	*
	* @return the author ID of this author expertise
	*/
	@Override
	public long getAuthorId() {
		return _authorExpertise.getAuthorId();
	}

	/**
	* Sets the author ID of this author expertise.
	*
	* @param authorId the author ID of this author expertise
	*/
	@Override
	public void setAuthorId(long authorId) {
		_authorExpertise.setAuthorId(authorId);
	}

	/**
	* Returns the expertise ID of this author expertise.
	*
	* @return the expertise ID of this author expertise
	*/
	@Override
	public long getExpertiseId() {
		return _authorExpertise.getExpertiseId();
	}

	/**
	* Sets the expertise ID of this author expertise.
	*
	* @param expertiseId the expertise ID of this author expertise
	*/
	@Override
	public void setExpertiseId(long expertiseId) {
		_authorExpertise.setExpertiseId(expertiseId);
	}

	@Override
	public boolean isNew() {
		return _authorExpertise.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_authorExpertise.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _authorExpertise.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_authorExpertise.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _authorExpertise.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _authorExpertise.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_authorExpertise.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _authorExpertise.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_authorExpertise.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_authorExpertise.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_authorExpertise.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AuthorExpertiseWrapper((AuthorExpertise)_authorExpertise.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.subur.model.AuthorExpertise authorExpertise) {
		return _authorExpertise.compareTo(authorExpertise);
	}

	@Override
	public int hashCode() {
		return _authorExpertise.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.AuthorExpertise> toCacheModel() {
		return _authorExpertise.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.AuthorExpertise toEscapedModel() {
		return new AuthorExpertiseWrapper(_authorExpertise.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.AuthorExpertise toUnescapedModel() {
		return new AuthorExpertiseWrapper(_authorExpertise.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _authorExpertise.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _authorExpertise.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_authorExpertise.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AuthorExpertiseWrapper)) {
			return false;
		}

		AuthorExpertiseWrapper authorExpertiseWrapper = (AuthorExpertiseWrapper)obj;

		if (Validator.equals(_authorExpertise,
					authorExpertiseWrapper._authorExpertise)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AuthorExpertise getWrappedAuthorExpertise() {
		return _authorExpertise;
	}

	@Override
	public AuthorExpertise getWrappedModel() {
		return _authorExpertise;
	}

	@Override
	public void resetOriginalValues() {
		_authorExpertise.resetOriginalValues();
	}

	private AuthorExpertise _authorExpertise;
}