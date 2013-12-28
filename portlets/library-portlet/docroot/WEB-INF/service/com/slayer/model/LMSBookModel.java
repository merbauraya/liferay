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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the LMSBook service. Represents a row in the &quot;LMS_LMSBook&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.slayer.model.impl.LMSBookModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.slayer.model.impl.LMSBookImpl}.
 * </p>
 *
 * @author matle
 * @see LMSBook
 * @see com.slayer.model.impl.LMSBookImpl
 * @see com.slayer.model.impl.LMSBookModelImpl
 * @generated
 */
public interface LMSBookModel extends BaseModel<LMSBook> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a l m s book model instance should use the {@link LMSBook} interface instead.
	 */

	/**
	 * Returns the primary key of this l m s book.
	 *
	 * @return the primary key of this l m s book
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this l m s book.
	 *
	 * @param primaryKey the primary key of this l m s book
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the book ID of this l m s book.
	 *
	 * @return the book ID of this l m s book
	 */
	public long getBookId();

	/**
	 * Sets the book ID of this l m s book.
	 *
	 * @param bookId the book ID of this l m s book
	 */
	public void setBookId(long bookId);

	/**
	 * Returns the book title of this l m s book.
	 *
	 * @return the book title of this l m s book
	 */
	@AutoEscape
	public String getBookTitle();

	/**
	 * Sets the book title of this l m s book.
	 *
	 * @param bookTitle the book title of this l m s book
	 */
	public void setBookTitle(String bookTitle);

	/**
	 * Returns the author of this l m s book.
	 *
	 * @return the author of this l m s book
	 */
	@AutoEscape
	public String getAuthor();

	/**
	 * Sets the author of this l m s book.
	 *
	 * @param author the author of this l m s book
	 */
	public void setAuthor(String author);

	/**
	 * Returns the create date of this l m s book.
	 *
	 * @return the create date of this l m s book
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this l m s book.
	 *
	 * @param createDate the create date of this l m s book
	 */
	public void setCreateDate(Date createDate);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(LMSBook lmsBook);

	public int hashCode();

	public CacheModel<LMSBook> toCacheModel();

	public LMSBook toEscapedModel();

	public LMSBook toUnescapedModel();

	public String toString();

	public String toXmlString();
}