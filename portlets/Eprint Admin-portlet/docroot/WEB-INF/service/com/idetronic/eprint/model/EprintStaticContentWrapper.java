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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EprintStaticContent}.
 * </p>
 *
 * @author Mazlan Mat
 * @see EprintStaticContent
 * @generated
 */
public class EprintStaticContentWrapper implements EprintStaticContent,
	ModelWrapper<EprintStaticContent> {
	public EprintStaticContentWrapper(EprintStaticContent eprintStaticContent) {
		_eprintStaticContent = eprintStaticContent;
	}

	@Override
	public Class<?> getModelClass() {
		return EprintStaticContent.class;
	}

	@Override
	public String getModelClassName() {
		return EprintStaticContent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contentId", getContentId());
		attributes.put("content", getContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contentId = (Long)attributes.get("contentId");

		if (contentId != null) {
			setContentId(contentId);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}
	}

	/**
	* Returns the primary key of this eprint static content.
	*
	* @return the primary key of this eprint static content
	*/
	@Override
	public long getPrimaryKey() {
		return _eprintStaticContent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this eprint static content.
	*
	* @param primaryKey the primary key of this eprint static content
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_eprintStaticContent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the content ID of this eprint static content.
	*
	* @return the content ID of this eprint static content
	*/
	@Override
	public long getContentId() {
		return _eprintStaticContent.getContentId();
	}

	/**
	* Sets the content ID of this eprint static content.
	*
	* @param contentId the content ID of this eprint static content
	*/
	@Override
	public void setContentId(long contentId) {
		_eprintStaticContent.setContentId(contentId);
	}

	/**
	* Returns the content of this eprint static content.
	*
	* @return the content of this eprint static content
	*/
	@Override
	public java.lang.String getContent() {
		return _eprintStaticContent.getContent();
	}

	/**
	* Sets the content of this eprint static content.
	*
	* @param content the content of this eprint static content
	*/
	@Override
	public void setContent(java.lang.String content) {
		_eprintStaticContent.setContent(content);
	}

	@Override
	public boolean isNew() {
		return _eprintStaticContent.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_eprintStaticContent.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _eprintStaticContent.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_eprintStaticContent.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _eprintStaticContent.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _eprintStaticContent.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_eprintStaticContent.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _eprintStaticContent.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_eprintStaticContent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_eprintStaticContent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eprintStaticContent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EprintStaticContentWrapper((EprintStaticContent)_eprintStaticContent.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eprint.model.EprintStaticContent eprintStaticContent) {
		return _eprintStaticContent.compareTo(eprintStaticContent);
	}

	@Override
	public int hashCode() {
		return _eprintStaticContent.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eprint.model.EprintStaticContent> toCacheModel() {
		return _eprintStaticContent.toCacheModel();
	}

	@Override
	public com.idetronic.eprint.model.EprintStaticContent toEscapedModel() {
		return new EprintStaticContentWrapper(_eprintStaticContent.toEscapedModel());
	}

	@Override
	public com.idetronic.eprint.model.EprintStaticContent toUnescapedModel() {
		return new EprintStaticContentWrapper(_eprintStaticContent.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _eprintStaticContent.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _eprintStaticContent.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_eprintStaticContent.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EprintStaticContentWrapper)) {
			return false;
		}

		EprintStaticContentWrapper eprintStaticContentWrapper = (EprintStaticContentWrapper)obj;

		if (Validator.equals(_eprintStaticContent,
					eprintStaticContentWrapper._eprintStaticContent)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EprintStaticContent getWrappedEprintStaticContent() {
		return _eprintStaticContent;
	}

	@Override
	public EprintStaticContent getWrappedModel() {
		return _eprintStaticContent;
	}

	@Override
	public void resetOriginalValues() {
		_eprintStaticContent.resetOriginalValues();
	}

	private EprintStaticContent _eprintStaticContent;
}