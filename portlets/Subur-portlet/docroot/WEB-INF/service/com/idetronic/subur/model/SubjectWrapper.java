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
 * This class is a wrapper for {@link Subject}.
 * </p>
 *
 * @author Mazlan Mat
 * @see Subject
 * @generated
 */
public class SubjectWrapper implements Subject, ModelWrapper<Subject> {
	public SubjectWrapper(Subject subject) {
		_subject = subject;
	}

	@Override
	public Class<?> getModelClass() {
		return Subject.class;
	}

	@Override
	public String getModelClassName() {
		return Subject.class.getName();
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
	* Returns the primary key of this subject.
	*
	* @return the primary key of this subject
	*/
	@Override
	public long getPrimaryKey() {
		return _subject.getPrimaryKey();
	}

	/**
	* Sets the primary key of this subject.
	*
	* @param primaryKey the primary key of this subject
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_subject.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the subject ID of this subject.
	*
	* @return the subject ID of this subject
	*/
	@Override
	public long getSubjectId() {
		return _subject.getSubjectId();
	}

	/**
	* Sets the subject ID of this subject.
	*
	* @param subjectId the subject ID of this subject
	*/
	@Override
	public void setSubjectId(long subjectId) {
		_subject.setSubjectId(subjectId);
	}

	/**
	* Returns the parent ID of this subject.
	*
	* @return the parent ID of this subject
	*/
	@Override
	public long getParentId() {
		return _subject.getParentId();
	}

	/**
	* Sets the parent ID of this subject.
	*
	* @param parentId the parent ID of this subject
	*/
	@Override
	public void setParentId(long parentId) {
		_subject.setParentId(parentId);
	}

	/**
	* Returns the subject name of this subject.
	*
	* @return the subject name of this subject
	*/
	@Override
	public java.lang.String getSubjectName() {
		return _subject.getSubjectName();
	}

	/**
	* Sets the subject name of this subject.
	*
	* @param subjectName the subject name of this subject
	*/
	@Override
	public void setSubjectName(java.lang.String subjectName) {
		_subject.setSubjectName(subjectName);
	}

	/**
	* Returns the lft of this subject.
	*
	* @return the lft of this subject
	*/
	@Override
	public int getLft() {
		return _subject.getLft();
	}

	/**
	* Sets the lft of this subject.
	*
	* @param lft the lft of this subject
	*/
	@Override
	public void setLft(int lft) {
		_subject.setLft(lft);
	}

	/**
	* Returns the rgt of this subject.
	*
	* @return the rgt of this subject
	*/
	@Override
	public int getRgt() {
		return _subject.getRgt();
	}

	/**
	* Sets the rgt of this subject.
	*
	* @param rgt the rgt of this subject
	*/
	@Override
	public void setRgt(int rgt) {
		_subject.setRgt(rgt);
	}

	/**
	* Returns the depositable of this subject.
	*
	* @return the depositable of this subject
	*/
	@Override
	public boolean getDepositable() {
		return _subject.getDepositable();
	}

	/**
	* Returns <code>true</code> if this subject is depositable.
	*
	* @return <code>true</code> if this subject is depositable; <code>false</code> otherwise
	*/
	@Override
	public boolean isDepositable() {
		return _subject.isDepositable();
	}

	/**
	* Sets whether this subject is depositable.
	*
	* @param depositable the depositable of this subject
	*/
	@Override
	public void setDepositable(boolean depositable) {
		_subject.setDepositable(depositable);
	}

	/**
	* Returns the item count of this subject.
	*
	* @return the item count of this subject
	*/
	@Override
	public int getItemCount() {
		return _subject.getItemCount();
	}

	/**
	* Sets the item count of this subject.
	*
	* @param itemCount the item count of this subject
	*/
	@Override
	public void setItemCount(int itemCount) {
		_subject.setItemCount(itemCount);
	}

	@Override
	public boolean isNew() {
		return _subject.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_subject.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _subject.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_subject.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _subject.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _subject.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_subject.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _subject.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_subject.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_subject.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_subject.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SubjectWrapper((Subject)_subject.clone());
	}

	@Override
	public int compareTo(com.idetronic.subur.model.Subject subject) {
		return _subject.compareTo(subject);
	}

	@Override
	public int hashCode() {
		return _subject.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.Subject> toCacheModel() {
		return _subject.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.Subject toEscapedModel() {
		return new SubjectWrapper(_subject.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.Subject toUnescapedModel() {
		return new SubjectWrapper(_subject.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _subject.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _subject.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_subject.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SubjectWrapper)) {
			return false;
		}

		SubjectWrapper subjectWrapper = (SubjectWrapper)obj;

		if (Validator.equals(_subject, subjectWrapper._subject)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Subject getWrappedSubject() {
		return _subject;
	}

	@Override
	public Subject getWrappedModel() {
		return _subject;
	}

	@Override
	public void resetOriginalValues() {
		_subject.resetOriginalValues();
	}

	private Subject _subject;
}