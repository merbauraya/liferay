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

package com.idetronic.ruangj.model;

import com.idetronic.ruangj.service.ClpSerializer;
import com.idetronic.ruangj.service.ItemFileEntryLocalServiceUtil;

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
public class ItemFileEntryClp extends BaseModelImpl<ItemFileEntry>
	implements ItemFileEntry {
	public ItemFileEntryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ItemFileEntry.class;
	}

	@Override
	public String getModelClassName() {
		return ItemFileEntry.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _itemEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setItemEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _itemEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemEntryId", getItemEntryId());
		attributes.put("itemId", getItemId());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("fileType", getFileType());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemEntryId = (Long)attributes.get("itemEntryId");

		if (itemEntryId != null) {
			setItemEntryId(itemEntryId);
		}

		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		String fileType = (String)attributes.get("fileType");

		if (fileType != null) {
			setFileType(fileType);
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
	}

	@Override
	public long getItemEntryId() {
		return _itemEntryId;
	}

	@Override
	public void setItemEntryId(long itemEntryId) {
		_itemEntryId = itemEntryId;

		if (_itemFileEntryRemoteModel != null) {
			try {
				Class<?> clazz = _itemFileEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setItemEntryId", long.class);

				method.invoke(_itemFileEntryRemoteModel, itemEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getItemId() {
		return _itemId;
	}

	@Override
	public void setItemId(long itemId) {
		_itemId = itemId;

		if (_itemFileEntryRemoteModel != null) {
			try {
				Class<?> clazz = _itemFileEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setItemId", long.class);

				method.invoke(_itemFileEntryRemoteModel, itemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;

		if (_itemFileEntryRemoteModel != null) {
			try {
				Class<?> clazz = _itemFileEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setFileEntryId", long.class);

				method.invoke(_itemFileEntryRemoteModel, fileEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFileType() {
		return _fileType;
	}

	@Override
	public void setFileType(String fileType) {
		_fileType = fileType;

		if (_itemFileEntryRemoteModel != null) {
			try {
				Class<?> clazz = _itemFileEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setFileType", String.class);

				method.invoke(_itemFileEntryRemoteModel, fileType);
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

		if (_itemFileEntryRemoteModel != null) {
			try {
				Class<?> clazz = _itemFileEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_itemFileEntryRemoteModel, userId);
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

		if (_itemFileEntryRemoteModel != null) {
			try {
				Class<?> clazz = _itemFileEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_itemFileEntryRemoteModel, userName);
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

		if (_itemFileEntryRemoteModel != null) {
			try {
				Class<?> clazz = _itemFileEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_itemFileEntryRemoteModel, createDate);
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

		if (_itemFileEntryRemoteModel != null) {
			try {
				Class<?> clazz = _itemFileEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_itemFileEntryRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getItemFileEntryRemoteModel() {
		return _itemFileEntryRemoteModel;
	}

	public void setItemFileEntryRemoteModel(
		BaseModel<?> itemFileEntryRemoteModel) {
		_itemFileEntryRemoteModel = itemFileEntryRemoteModel;
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

		Class<?> remoteModelClass = _itemFileEntryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_itemFileEntryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ItemFileEntryLocalServiceUtil.addItemFileEntry(this);
		}
		else {
			ItemFileEntryLocalServiceUtil.updateItemFileEntry(this);
		}
	}

	@Override
	public ItemFileEntry toEscapedModel() {
		return (ItemFileEntry)ProxyUtil.newProxyInstance(ItemFileEntry.class.getClassLoader(),
			new Class[] { ItemFileEntry.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ItemFileEntryClp clone = new ItemFileEntryClp();

		clone.setItemEntryId(getItemEntryId());
		clone.setItemId(getItemId());
		clone.setFileEntryId(getFileEntryId());
		clone.setFileType(getFileType());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(ItemFileEntry itemFileEntry) {
		long primaryKey = itemFileEntry.getPrimaryKey();

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

		if (!(obj instanceof ItemFileEntryClp)) {
			return false;
		}

		ItemFileEntryClp itemFileEntry = (ItemFileEntryClp)obj;

		long primaryKey = itemFileEntry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{itemEntryId=");
		sb.append(getItemEntryId());
		sb.append(", itemId=");
		sb.append(getItemId());
		sb.append(", fileEntryId=");
		sb.append(getFileEntryId());
		sb.append(", fileType=");
		sb.append(getFileType());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.ruangj.model.ItemFileEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>itemEntryId</column-name><column-value><![CDATA[");
		sb.append(getItemEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileType</column-name><column-value><![CDATA[");
		sb.append(getFileType());
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _itemEntryId;
	private long _itemId;
	private long _fileEntryId;
	private String _fileType;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _itemFileEntryRemoteModel;
}