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
 * This class is a wrapper for {@link SubjectTree}.
 * </p>
 *
 * @author Mazlan Mat
 * @see SubjectTree
 * @generated
 */
public class SubjectTreeWrapper implements SubjectTree,
	ModelWrapper<SubjectTree> {
	public SubjectTreeWrapper(SubjectTree subjectTree) {
		_subjectTree = subjectTree;
	}

	@Override
	public Class<?> getModelClass() {
		return SubjectTree.class;
	}

	@Override
	public String getModelClassName() {
		return SubjectTree.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("subjectId", getSubjectId());
		attributes.put("parentId", getParentId());
		attributes.put("subjectName", getSubjectName());
		attributes.put("lft", getLft());
		attributes.put("rgt", getRgt());
		attributes.put("depositable", getDepositable());
		attributes.put("itemCount", getItemCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long subjectId = (Long)attributes.get("subjectId");

		if (subjectId != null) {
			setSubjectId(subjectId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String subjectName = (String)attributes.get("subjectName");

		if (subjectName != null) {
			setSubjectName(subjectName);
		}

		Integer lft = (Integer)attributes.get("lft");

		if (lft != null) {
			setLft(lft);
		}

		Integer rgt = (Integer)attributes.get("rgt");

		if (rgt != null) {
			setRgt(rgt);
		}

		Boolean depositable = (Boolean)attributes.get("depositable");

		if (depositable != null) {
			setDepositable(depositable);
		}

		Integer itemCount = (Integer)attributes.get("itemCount");

		if (itemCount != null) {
			setItemCount(itemCount);
		}
	}

	/**
	* Returns the primary key of this subject tree.
	*
	* @return the primary key of this subject tree
	*/
	@Override
	public long getPrimaryKey() {
		return _subjectTree.getPrimaryKey();
	}

	/**
	* Sets the primary key of this subject tree.
	*
	* @param primaryKey the primary key of this subject tree
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_subjectTree.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the subject ID of this subject tree.
	*
	* @return the subject ID of this subject tree
	*/
	@Override
	public long getSubjectId() {
		return _subjectTree.getSubjectId();
	}

	/**
	* Sets the subject ID of this subject tree.
	*
	* @param subjectId the subject ID of this subject tree
	*/
	@Override
	public void setSubjectId(long subjectId) {
		_subjectTree.setSubjectId(subjectId);
	}

	/**
	* Returns the parent ID of this subject tree.
	*
	* @return the parent ID of this subject tree
	*/
	@Override
	public long getParentId() {
		return _subjectTree.getParentId();
	}

	/**
	* Sets the parent ID of this subject tree.
	*
	* @param parentId the parent ID of this subject tree
	*/
	@Override
	public void setParentId(long parentId) {
		_subjectTree.setParentId(parentId);
	}

	/**
	* Returns the subject name of this subject tree.
	*
	* @return the subject name of this subject tree
	*/
	@Override
	public java.lang.String getSubjectName() {
		return _subjectTree.getSubjectName();
	}

	/**
	* Sets the subject name of this subject tree.
	*
	* @param subjectName the subject name of this subject tree
	*/
	@Override
	public void setSubjectName(java.lang.String subjectName) {
		_subjectTree.setSubjectName(subjectName);
	}

	/**
	* Returns the lft of this subject tree.
	*
	* @return the lft of this subject tree
	*/
	@Override
	public int getLft() {
		return _subjectTree.getLft();
	}

	/**
	* Sets the lft of this subject tree.
	*
	* @param lft the lft of this subject tree
	*/
	@Override
	public void setLft(int lft) {
		_subjectTree.setLft(lft);
	}

	/**
	* Returns the rgt of this subject tree.
	*
	* @return the rgt of this subject tree
	*/
	@Override
	public int getRgt() {
		return _subjectTree.getRgt();
	}

	/**
	* Sets the rgt of this subject tree.
	*
	* @param rgt the rgt of this subject tree
	*/
	@Override
	public void setRgt(int rgt) {
		_subjectTree.setRgt(rgt);
	}

	/**
	* Returns the depositable of this subject tree.
	*
	* @return the depositable of this subject tree
	*/
	@Override
	public boolean getDepositable() {
		return _subjectTree.getDepositable();
	}

	/**
	* Returns <code>true</code> if this subject tree is depositable.
	*
	* @return <code>true</code> if this subject tree is depositable; <code>false</code> otherwise
	*/
	@Override
	public boolean isDepositable() {
		return _subjectTree.isDepositable();
	}

	/**
	* Sets whether this subject tree is depositable.
	*
	* @param depositable the depositable of this subject tree
	*/
	@Override
	public void setDepositable(boolean depositable) {
		_subjectTree.setDepositable(depositable);
	}

	/**
	* Returns the item count of this subject tree.
	*
	* @return the item count of this subject tree
	*/
	@Override
	public int getItemCount() {
		return _subjectTree.getItemCount();
	}

	/**
	* Sets the item count of this subject tree.
	*
	* @param itemCount the item count of this subject tree
	*/
	@Override
	public void setItemCount(int itemCount) {
		_subjectTree.setItemCount(itemCount);
	}

	@Override
	public boolean isNew() {
		return _subjectTree.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_subjectTree.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _subjectTree.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_subjectTree.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _subjectTree.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _subjectTree.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_subjectTree.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _subjectTree.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_subjectTree.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_subjectTree.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_subjectTree.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SubjectTreeWrapper((SubjectTree)_subjectTree.clone());
	}

	@Override
	public int compareTo(com.idetronic.subur.model.SubjectTree subjectTree) {
		return _subjectTree.compareTo(subjectTree);
	}

	@Override
	public int hashCode() {
		return _subjectTree.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.SubjectTree> toCacheModel() {
		return _subjectTree.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.SubjectTree toEscapedModel() {
		return new SubjectTreeWrapper(_subjectTree.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.SubjectTree toUnescapedModel() {
		return new SubjectTreeWrapper(_subjectTree.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _subjectTree.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _subjectTree.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_subjectTree.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SubjectTreeWrapper)) {
			return false;
		}

		SubjectTreeWrapper subjectTreeWrapper = (SubjectTreeWrapper)obj;

		if (Validator.equals(_subjectTree, subjectTreeWrapper._subjectTree)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SubjectTree getWrappedSubjectTree() {
		return _subjectTree;
	}

	@Override
	public SubjectTree getWrappedModel() {
		return _subjectTree;
	}

	@Override
	public void resetOriginalValues() {
		_subjectTree.resetOriginalValues();
	}

	private SubjectTree _subjectTree;
}