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

import com.idetronic.subur.service.ClpSerializer;
import com.idetronic.subur.service.ItemFileEntryLocalServiceUtil;
import com.idetronic.subur.service.persistence.ItemFileEntryPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

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
	public ItemFileEntryPK getPrimaryKey() {
		return new ItemFileEntryPK(_itemId, _fileEntryId);
	}

	@Override
	public void setPrimaryKey(ItemFileEntryPK primaryKey) {
		setItemId(primaryKey.itemId);
		setFileEntryId(primaryKey.fileEntryId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ItemFileEntryPK(_itemId, _fileEntryId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ItemFileEntryPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemId", getItemId());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("entryType", getEntryType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		Long entryType = (Long)attributes.get("entryType");

		if (entryType != null) {
			setEntryType(entryType);
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
	public long getEntryType() {
		return _entryType;
	}

	@Override
	public void setEntryType(long entryType) {
		_entryType = entryType;

		if (_itemFileEntryRemoteModel != null) {
			try {
				Class<?> clazz = _itemFileEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setEntryType", long.class);

				method.invoke(_itemFileEntryRemoteModel, entryType);
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

		clone.setItemId(getItemId());
		clone.setFileEntryId(getFileEntryId());
		clone.setEntryType(getEntryType());

		return clone;
	}

	@Override
	public int compareTo(ItemFileEntry itemFileEntry) {
		ItemFileEntryPK primaryKey = itemFileEntry.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
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

		ItemFileEntryPK primaryKey = itemFileEntry.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{itemId=");
		sb.append(getItemId());
		sb.append(", fileEntryId=");
		sb.append(getFileEntryId());
		sb.append(", entryType=");
		sb.append(getEntryType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.ItemFileEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>itemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entryType</column-name><column-value><![CDATA[");
		sb.append(getEntryType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _itemId;
	private long _fileEntryId;
	private long _entryType;
	private BaseModel<?> _itemFileEntryRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.subur.service.ClpSerializer.class;
}