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

package com.idetronic.portlet.model;

import com.idetronic.portlet.service.ClpSerializer;
import com.idetronic.portlet.service.FAQEntryLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mazlan Mat
 */
public class FAQEntryClp extends BaseModelImpl<FAQEntry> implements FAQEntry {
	public FAQEntryClp() {
	}

	public Class<?> getModelClass() {
		return FAQEntry.class;
	}

	public String getModelClassName() {
		return FAQEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _entryId;
	}

	public void setPrimaryKey(long primaryKey) {
		setEntryId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_entryId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("entryId", getEntryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("groupId", getGroupId());
		attributes.put("question", getQuestion());
		attributes.put("category", getCategory());
		attributes.put("answer", getAnswer());
		attributes.put("isactive", getIsactive());
		attributes.put("displayorder", getDisplayorder());
		attributes.put("categoryOrder", getCategoryOrder());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long entryId = (Long)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String question = (String)attributes.get("question");

		if (question != null) {
			setQuestion(question);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		String answer = (String)attributes.get("answer");

		if (answer != null) {
			setAnswer(answer);
		}

		Boolean isactive = (Boolean)attributes.get("isactive");

		if (isactive != null) {
			setIsactive(isactive);
		}

		Long displayorder = (Long)attributes.get("displayorder");

		if (displayorder != null) {
			setDisplayorder(displayorder);
		}

		Long categoryOrder = (Long)attributes.get("categoryOrder");

		if (categoryOrder != null) {
			setCategoryOrder(categoryOrder);
		}
	}

	public long getEntryId() {
		return _entryId;
	}

	public void setEntryId(long entryId) {
		_entryId = entryId;

		if (_faqEntryRemoteModel != null) {
			try {
				Class<?> clazz = _faqEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setEntryId", long.class);

				method.invoke(_faqEntryRemoteModel, entryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_faqEntryRemoteModel != null) {
			try {
				Class<?> clazz = _faqEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_faqEntryRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;

		if (_faqEntryRemoteModel != null) {
			try {
				Class<?> clazz = _faqEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_faqEntryRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;

		if (_faqEntryRemoteModel != null) {
			try {
				Class<?> clazz = _faqEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_faqEntryRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_faqEntryRemoteModel != null) {
			try {
				Class<?> clazz = _faqEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_faqEntryRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_faqEntryRemoteModel != null) {
			try {
				Class<?> clazz = _faqEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_faqEntryRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_faqEntryRemoteModel != null) {
			try {
				Class<?> clazz = _faqEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_faqEntryRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getQuestion() {
		return _question;
	}

	public void setQuestion(String question) {
		_question = question;

		if (_faqEntryRemoteModel != null) {
			try {
				Class<?> clazz = _faqEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setQuestion", String.class);

				method.invoke(_faqEntryRemoteModel, question);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;

		if (_faqEntryRemoteModel != null) {
			try {
				Class<?> clazz = _faqEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setCategory", String.class);

				method.invoke(_faqEntryRemoteModel, category);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getAnswer() {
		return _answer;
	}

	public void setAnswer(String answer) {
		_answer = answer;

		if (_faqEntryRemoteModel != null) {
			try {
				Class<?> clazz = _faqEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswer", String.class);

				method.invoke(_faqEntryRemoteModel, answer);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Boolean getIsactive() {
		return _isactive;
	}

	public void setIsactive(Boolean isactive) {
		_isactive = isactive;

		if (_faqEntryRemoteModel != null) {
			try {
				Class<?> clazz = _faqEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setIsactive", Boolean.class);

				method.invoke(_faqEntryRemoteModel, isactive);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getDisplayorder() {
		return _displayorder;
	}

	public void setDisplayorder(long displayorder) {
		_displayorder = displayorder;

		if (_faqEntryRemoteModel != null) {
			try {
				Class<?> clazz = _faqEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayorder", long.class);

				method.invoke(_faqEntryRemoteModel, displayorder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getCategoryOrder() {
		return _categoryOrder;
	}

	public void setCategoryOrder(long categoryOrder) {
		_categoryOrder = categoryOrder;

		if (_faqEntryRemoteModel != null) {
			try {
				Class<?> clazz = _faqEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryOrder", long.class);

				method.invoke(_faqEntryRemoteModel, categoryOrder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFAQEntryRemoteModel() {
		return _faqEntryRemoteModel;
	}

	public void setFAQEntryRemoteModel(BaseModel<?> faqEntryRemoteModel) {
		_faqEntryRemoteModel = faqEntryRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _faqEntryRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_faqEntryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			FAQEntryLocalServiceUtil.addFAQEntry(this);
		}
		else {
			FAQEntryLocalServiceUtil.updateFAQEntry(this);
		}
	}

	@Override
	public FAQEntry toEscapedModel() {
		return (FAQEntry)ProxyUtil.newProxyInstance(FAQEntry.class.getClassLoader(),
			new Class[] { FAQEntry.class }, new AutoEscapeBeanHandler(this));
	}

	public FAQEntry toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		FAQEntryClp clone = new FAQEntryClp();

		clone.setEntryId(getEntryId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setGroupId(getGroupId());
		clone.setQuestion(getQuestion());
		clone.setCategory(getCategory());
		clone.setAnswer(getAnswer());
		clone.setIsactive(getIsactive());
		clone.setDisplayorder(getDisplayorder());
		clone.setCategoryOrder(getCategoryOrder());

		return clone;
	}

	public int compareTo(FAQEntry faqEntry) {
		int value = 0;

		if (getCategoryOrder() < faqEntry.getCategoryOrder()) {
			value = -1;
		}
		else if (getCategoryOrder() > faqEntry.getCategoryOrder()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getDisplayorder() < faqEntry.getDisplayorder()) {
			value = -1;
		}
		else if (getDisplayorder() > faqEntry.getDisplayorder()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FAQEntryClp)) {
			return false;
		}

		FAQEntryClp faqEntry = (FAQEntryClp)obj;

		long primaryKey = faqEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{entryId=");
		sb.append(getEntryId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", question=");
		sb.append(getQuestion());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", answer=");
		sb.append(getAnswer());
		sb.append(", isactive=");
		sb.append(getIsactive());
		sb.append(", displayorder=");
		sb.append(getDisplayorder());
		sb.append(", categoryOrder=");
		sb.append(getCategoryOrder());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.portlet.model.FAQEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>entryId</column-name><column-value><![CDATA[");
		sb.append(getEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>question</column-name><column-value><![CDATA[");
		sb.append(getQuestion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answer</column-name><column-value><![CDATA[");
		sb.append(getAnswer());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isactive</column-name><column-value><![CDATA[");
		sb.append(getIsactive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayorder</column-name><column-value><![CDATA[");
		sb.append(getDisplayorder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryOrder</column-name><column-value><![CDATA[");
		sb.append(getCategoryOrder());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _entryId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _groupId;
	private String _question;
	private String _category;
	private String _answer;
	private Boolean _isactive;
	private long _displayorder;
	private long _categoryOrder;
	private BaseModel<?> _faqEntryRemoteModel;
}