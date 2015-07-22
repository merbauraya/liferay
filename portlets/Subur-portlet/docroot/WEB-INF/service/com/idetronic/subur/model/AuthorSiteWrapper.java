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
 * This class is a wrapper for {@link AuthorSite}.
 * </p>
 *
 * @author Mazlan Mat
 * @see AuthorSite
 * @generated
 */
public class AuthorSiteWrapper implements AuthorSite, ModelWrapper<AuthorSite> {
	public AuthorSiteWrapper(AuthorSite authorSite) {
		_authorSite = authorSite;
	}

	@Override
	public Class<?> getModelClass() {
		return AuthorSite.class;
	}

	@Override
	public String getModelClassName() {
		return AuthorSite.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("authorSiteId", getAuthorSiteId());
		attributes.put("authorId", getAuthorId());
		attributes.put("siteName", getSiteName());
		attributes.put("siteURL", getSiteURL());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long authorSiteId = (Long)attributes.get("authorSiteId");

		if (authorSiteId != null) {
			setAuthorSiteId(authorSiteId);
		}

		Long authorId = (Long)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
		}

		String siteName = (String)attributes.get("siteName");

		if (siteName != null) {
			setSiteName(siteName);
		}

		String siteURL = (String)attributes.get("siteURL");

		if (siteURL != null) {
			setSiteURL(siteURL);
		}
	}

	/**
	* Returns the primary key of this author site.
	*
	* @return the primary key of this author site
	*/
	@Override
	public long getPrimaryKey() {
		return _authorSite.getPrimaryKey();
	}

	/**
	* Sets the primary key of this author site.
	*
	* @param primaryKey the primary key of this author site
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_authorSite.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the author site ID of this author site.
	*
	* @return the author site ID of this author site
	*/
	@Override
	public long getAuthorSiteId() {
		return _authorSite.getAuthorSiteId();
	}

	/**
	* Sets the author site ID of this author site.
	*
	* @param authorSiteId the author site ID of this author site
	*/
	@Override
	public void setAuthorSiteId(long authorSiteId) {
		_authorSite.setAuthorSiteId(authorSiteId);
	}

	/**
	* Returns the author ID of this author site.
	*
	* @return the author ID of this author site
	*/
	@Override
	public long getAuthorId() {
		return _authorSite.getAuthorId();
	}

	/**
	* Sets the author ID of this author site.
	*
	* @param authorId the author ID of this author site
	*/
	@Override
	public void setAuthorId(long authorId) {
		_authorSite.setAuthorId(authorId);
	}

	/**
	* Returns the site name of this author site.
	*
	* @return the site name of this author site
	*/
	@Override
	public java.lang.String getSiteName() {
		return _authorSite.getSiteName();
	}

	/**
	* Sets the site name of this author site.
	*
	* @param siteName the site name of this author site
	*/
	@Override
	public void setSiteName(java.lang.String siteName) {
		_authorSite.setSiteName(siteName);
	}

	/**
	* Returns the site u r l of this author site.
	*
	* @return the site u r l of this author site
	*/
	@Override
	public java.lang.String getSiteURL() {
		return _authorSite.getSiteURL();
	}

	/**
	* Sets the site u r l of this author site.
	*
	* @param siteURL the site u r l of this author site
	*/
	@Override
	public void setSiteURL(java.lang.String siteURL) {
		_authorSite.setSiteURL(siteURL);
	}

	@Override
	public boolean isNew() {
		return _authorSite.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_authorSite.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _authorSite.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_authorSite.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _authorSite.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _authorSite.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_authorSite.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _authorSite.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_authorSite.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_authorSite.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_authorSite.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AuthorSiteWrapper((AuthorSite)_authorSite.clone());
	}

	@Override
	public int compareTo(com.idetronic.subur.model.AuthorSite authorSite) {
		return _authorSite.compareTo(authorSite);
	}

	@Override
	public int hashCode() {
		return _authorSite.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.AuthorSite> toCacheModel() {
		return _authorSite.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.AuthorSite toEscapedModel() {
		return new AuthorSiteWrapper(_authorSite.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.AuthorSite toUnescapedModel() {
		return new AuthorSiteWrapper(_authorSite.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _authorSite.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _authorSite.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_authorSite.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AuthorSiteWrapper)) {
			return false;
		}

		AuthorSiteWrapper authorSiteWrapper = (AuthorSiteWrapper)obj;

		if (Validator.equals(_authorSite, authorSiteWrapper._authorSite)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AuthorSite getWrappedAuthorSite() {
		return _authorSite;
	}

	@Override
	public AuthorSite getWrappedModel() {
		return _authorSite;
	}

	@Override
	public void resetOriginalValues() {
		_authorSite.resetOriginalValues();
	}

	private AuthorSite _authorSite;
}