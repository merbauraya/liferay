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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the SubjectTree service. Represents a row in the &quot;subur_SubjectTree&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.subur.model.impl.SubjectTreeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.subur.model.impl.SubjectTreeImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see SubjectTree
 * @see com.idetronic.subur.model.impl.SubjectTreeImpl
 * @see com.idetronic.subur.model.impl.SubjectTreeModelImpl
 * @generated
 */
public interface SubjectTreeModel extends BaseModel<SubjectTree> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a subject tree model instance should use the {@link SubjectTree} interface instead.
	 */

	/**
	 * Returns the primary key of this subject tree.
	 *
	 * @return the primary key of this subject tree
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this subject tree.
	 *
	 * @param primaryKey the primary key of this subject tree
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the subject ID of this subject tree.
	 *
	 * @return the subject ID of this subject tree
	 */
	public long getSubjectId();

	/**
	 * Sets the subject ID of this subject tree.
	 *
	 * @param subjectId the subject ID of this subject tree
	 */
	public void setSubjectId(long subjectId);

	/**
	 * Returns the parent ID of this subject tree.
	 *
	 * @return the parent ID of this subject tree
	 */
	public long getParentId();

	/**
	 * Sets the parent ID of this subject tree.
	 *
	 * @param parentId the parent ID of this subject tree
	 */
	public void setParentId(long parentId);

	/**
	 * Returns the subject name of this subject tree.
	 *
	 * @return the subject name of this subject tree
	 */
	@AutoEscape
	public String getSubjectName();

	/**
	 * Sets the subject name of this subject tree.
	 *
	 * @param subjectName the subject name of this subject tree
	 */
	public void setSubjectName(String subjectName);

	/**
	 * Returns the lft of this subject tree.
	 *
	 * @return the lft of this subject tree
	 */
	public int getLft();

	/**
	 * Sets the lft of this subject tree.
	 *
	 * @param lft the lft of this subject tree
	 */
	public void setLft(int lft);

	/**
	 * Returns the rgt of this subject tree.
	 *
	 * @return the rgt of this subject tree
	 */
	public int getRgt();

	/**
	 * Sets the rgt of this subject tree.
	 *
	 * @param rgt the rgt of this subject tree
	 */
	public void setRgt(int rgt);

	/**
	 * Returns the depositable of this subject tree.
	 *
	 * @return the depositable of this subject tree
	 */
	public boolean getDepositable();

	/**
	 * Returns <code>true</code> if this subject tree is depositable.
	 *
	 * @return <code>true</code> if this subject tree is depositable; <code>false</code> otherwise
	 */
	public boolean isDepositable();

	/**
	 * Sets whether this subject tree is depositable.
	 *
	 * @param depositable the depositable of this subject tree
	 */
	public void setDepositable(boolean depositable);

	/**
	 * Returns the item count of this subject tree.
	 *
	 * @return the item count of this subject tree
	 */
	public int getItemCount();

	/**
	 * Sets the item count of this subject tree.
	 *
	 * @param itemCount the item count of this subject tree
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
	public int compareTo(SubjectTree subjectTree);

	@Override
	public int hashCode();

	@Override
	public CacheModel<SubjectTree> toCacheModel();

	@Override
	public SubjectTree toEscapedModel();

	@Override
	public SubjectTree toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}