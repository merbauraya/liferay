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

package com.slayer.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LMSBook}.
 * </p>
 *
 * @author    matle
 * @see       LMSBook
 * @generated
 */
public class LMSBookWrapper implements LMSBook, ModelWrapper<LMSBook> {
	public LMSBookWrapper(LMSBook lmsBook) {
		_lmsBook = lmsBook;
	}

	public Class<?> getModelClass() {
		return LMSBook.class;
	}

	public String getModelClassName() {
		return LMSBook.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bookId", getBookId());
		attributes.put("bookTitle", getBookTitle());
		attributes.put("author", getAuthor());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long bookId = (Long)attributes.get("bookId");

		if (bookId != null) {
			setBookId(bookId);
		}

		String bookTitle = (String)attributes.get("bookTitle");

		if (bookTitle != null) {
			setBookTitle(bookTitle);
		}

		String author = (String)attributes.get("author");

		if (author != null) {
			setAuthor(author);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	/**
	* Returns the primary key of this l m s book.
	*
	* @return the primary key of this l m s book
	*/
	public long getPrimaryKey() {
		return _lmsBook.getPrimaryKey();
	}

	/**
	* Sets the primary key of this l m s book.
	*
	* @param primaryKey the primary key of this l m s book
	*/
	public void setPrimaryKey(long primaryKey) {
		_lmsBook.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the book ID of this l m s book.
	*
	* @return the book ID of this l m s book
	*/
	public long getBookId() {
		return _lmsBook.getBookId();
	}

	/**
	* Sets the book ID of this l m s book.
	*
	* @param bookId the book ID of this l m s book
	*/
	public void setBookId(long bookId) {
		_lmsBook.setBookId(bookId);
	}

	/**
	* Returns the book title of this l m s book.
	*
	* @return the book title of this l m s book
	*/
	public java.lang.String getBookTitle() {
		return _lmsBook.getBookTitle();
	}

	/**
	* Sets the book title of this l m s book.
	*
	* @param bookTitle the book title of this l m s book
	*/
	public void setBookTitle(java.lang.String bookTitle) {
		_lmsBook.setBookTitle(bookTitle);
	}

	/**
	* Returns the author of this l m s book.
	*
	* @return the author of this l m s book
	*/
	public java.lang.String getAuthor() {
		return _lmsBook.getAuthor();
	}

	/**
	* Sets the author of this l m s book.
	*
	* @param author the author of this l m s book
	*/
	public void setAuthor(java.lang.String author) {
		_lmsBook.setAuthor(author);
	}

	/**
	* Returns the create date of this l m s book.
	*
	* @return the create date of this l m s book
	*/
	public java.util.Date getCreateDate() {
		return _lmsBook.getCreateDate();
	}

	/**
	* Sets the create date of this l m s book.
	*
	* @param createDate the create date of this l m s book
	*/
	public void setCreateDate(java.util.Date createDate) {
		_lmsBook.setCreateDate(createDate);
	}

	public boolean isNew() {
		return _lmsBook.isNew();
	}

	public void setNew(boolean n) {
		_lmsBook.setNew(n);
	}

	public boolean isCachedModel() {
		return _lmsBook.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_lmsBook.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _lmsBook.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _lmsBook.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_lmsBook.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _lmsBook.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_lmsBook.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LMSBookWrapper((LMSBook)_lmsBook.clone());
	}

	public int compareTo(com.slayer.model.LMSBook lmsBook) {
		return _lmsBook.compareTo(lmsBook);
	}

	@Override
	public int hashCode() {
		return _lmsBook.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.slayer.model.LMSBook> toCacheModel() {
		return _lmsBook.toCacheModel();
	}

	public com.slayer.model.LMSBook toEscapedModel() {
		return new LMSBookWrapper(_lmsBook.toEscapedModel());
	}

	public com.slayer.model.LMSBook toUnescapedModel() {
		return new LMSBookWrapper(_lmsBook.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _lmsBook.toString();
	}

	public java.lang.String toXmlString() {
		return _lmsBook.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_lmsBook.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LMSBookWrapper)) {
			return false;
		}

		LMSBookWrapper lmsBookWrapper = (LMSBookWrapper)obj;

		if (Validator.equals(_lmsBook, lmsBookWrapper._lmsBook)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public LMSBook getWrappedLMSBook() {
		return _lmsBook;
	}

	public LMSBook getWrappedModel() {
		return _lmsBook;
	}

	public void resetOriginalValues() {
		_lmsBook.resetOriginalValues();
	}

	private LMSBook _lmsBook;
}