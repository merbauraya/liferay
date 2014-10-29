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
import com.idetronic.portlet.service.ExpertiseTagLocalServiceUtil;

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
public class ExpertiseTagClp extends BaseModelImpl<ExpertiseTag>
	implements ExpertiseTag {
	public ExpertiseTagClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ExpertiseTag.class;
	}

	@Override
	public String getModelClassName() {
		return ExpertiseTag.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _tagId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTagId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tagId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tagId", getTagId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("tagName", getTagName());
		attributes.put("userCount", getUserCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tagId = (Long)attributes.get("tagId");

		if (tagId != null) {
			setTagId(tagId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		String tagName = (String)attributes.get("tagName");

		if (tagName != null) {
			setTagName(tagName);
		}

		Integer userCount = (Integer)attributes.get("userCount");

		if (userCount != null) {
			setUserCount(userCount);
		}
	}

	@Override
	public long getTagId() {
		return _tagId;
	}

	@Override
	public void setTagId(long tagId) {
		_tagId = tagId;

		if (_expertiseTagRemoteModel != null) {
			try {
				Class<?> clazz = _expertiseTagRemoteModel.getClass();

				Method method = clazz.getMethod("setTagId", long.class);

				method.invoke(_expertiseTagRemoteModel, tagId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_expertiseTagRemoteModel != null) {
			try {
				Class<?> clazz = _expertiseTagRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_expertiseTagRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_expertiseTagRemoteModel != null) {
			try {
				Class<?> clazz = _expertiseTagRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_expertiseTagRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_expertiseTagRemoteModel != null) {
			try {
				Class<?> clazz = _expertiseTagRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_expertiseTagRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_expertiseTagRemoteModel != null) {
			try {
				Class<?> clazz = _expertiseTagRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_expertiseTagRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_expertiseTagRemoteModel != null) {
			try {
				Class<?> clazz = _expertiseTagRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_expertiseTagRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_expertiseTagRemoteModel != null) {
			try {
				Class<?> clazz = _expertiseTagRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_expertiseTagRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTagName() {
		return _tagName;
	}

	@Override
	public void setTagName(String tagName) {
		_tagName = tagName;

		if (_expertiseTagRemoteModel != null) {
			try {
				Class<?> clazz = _expertiseTagRemoteModel.getClass();

				Method method = clazz.getMethod("setTagName", String.class);

				method.invoke(_expertiseTagRemoteModel, tagName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getUserCount() {
		return _userCount;
	}

	@Override
	public void setUserCount(int userCount) {
		_userCount = userCount;

		if (_expertiseTagRemoteModel != null) {
			try {
				Class<?> clazz = _expertiseTagRemoteModel.getClass();

				Method method = clazz.getMethod("setUserCount", int.class);

				method.invoke(_expertiseTagRemoteModel, userCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getExpertiseTagRemoteModel() {
		return _expertiseTagRemoteModel;
	}

	public void setExpertiseTagRemoteModel(BaseModel<?> expertiseTagRemoteModel) {
		_expertiseTagRemoteModel = expertiseTagRemoteModel;
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

		Class<?> remoteModelClass = _expertiseTagRemoteModel.getClass();

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

		Object returnValue = method.invoke(_expertiseTagRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ExpertiseTagLocalServiceUtil.addExpertiseTag(this);
		}
		else {
			ExpertiseTagLocalServiceUtil.updateExpertiseTag(this);
		}
	}

	@Override
	public ExpertiseTag toEscapedModel() {
		return (ExpertiseTag)ProxyUtil.newProxyInstance(ExpertiseTag.class.getClassLoader(),
			new Class[] { ExpertiseTag.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ExpertiseTagClp clone = new ExpertiseTagClp();

		clone.setTagId(getTagId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setTagName(getTagName());
		clone.setUserCount(getUserCount());

		return clone;
	}

	@Override
	public int compareTo(ExpertiseTag expertiseTag) {
		long primaryKey = expertiseTag.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExpertiseTagClp)) {
			return false;
		}

		ExpertiseTagClp expertiseTag = (ExpertiseTagClp)obj;

		long primaryKey = expertiseTag.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{tagId=");
		sb.append(getTagId());
		sb.append(", groupId=");
		sb.append(getGroupId());
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
		sb.append(", tagName=");
		sb.append(getTagName());
		sb.append(", userCount=");
		sb.append(getUserCount());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.portlet.model.ExpertiseTag");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>tagId</column-name><column-value><![CDATA[");
		sb.append(getTagId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
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
			"<column><column-name>tagName</column-name><column-value><![CDATA[");
		sb.append(getTagName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userCount</column-name><column-value><![CDATA[");
		sb.append(getUserCount());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _tagId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _tagName;
	private int _userCount;
	private BaseModel<?> _expertiseTagRemoteModel;
}