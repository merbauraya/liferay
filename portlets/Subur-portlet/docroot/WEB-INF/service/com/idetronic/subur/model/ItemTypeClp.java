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
import com.idetronic.subur.service.ItemTypeLocalServiceUtil;

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
public class ItemTypeClp extends BaseModelImpl<ItemType> implements ItemType {
	public ItemTypeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ItemType.class;
	}

	@Override
	public String getModelClassName() {
		return ItemType.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _ItemTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setItemTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ItemTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ItemTypeId", getItemTypeId());
		attributes.put("ItemTypeName", getItemTypeName());
		attributes.put("itemCount", getItemCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ItemTypeId = (Long)attributes.get("ItemTypeId");

		if (ItemTypeId != null) {
			setItemTypeId(ItemTypeId);
		}

		String ItemTypeName = (String)attributes.get("ItemTypeName");

		if (ItemTypeName != null) {
			setItemTypeName(ItemTypeName);
		}

		Integer itemCount = (Integer)attributes.get("itemCount");

		if (itemCount != null) {
			setItemCount(itemCount);
		}
	}

	@Override
	public long getItemTypeId() {
		return _ItemTypeId;
	}

	@Override
	public void setItemTypeId(long ItemTypeId) {
		_ItemTypeId = ItemTypeId;

		if (_itemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _itemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setItemTypeId", long.class);

				method.invoke(_itemTypeRemoteModel, ItemTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getItemTypeName() {
		return _ItemTypeName;
	}

	@Override
	public void setItemTypeName(String ItemTypeName) {
		_ItemTypeName = ItemTypeName;

		if (_itemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _itemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setItemTypeName", String.class);

				method.invoke(_itemTypeRemoteModel, ItemTypeName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getItemCount() {
		return _itemCount;
	}

	@Override
	public void setItemCount(int itemCount) {
		_itemCount = itemCount;

		if (_itemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _itemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setItemCount", int.class);

				method.invoke(_itemTypeRemoteModel, itemCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getItemTypeRemoteModel() {
		return _itemTypeRemoteModel;
	}

	public void setItemTypeRemoteModel(BaseModel<?> itemTypeRemoteModel) {
		_itemTypeRemoteModel = itemTypeRemoteModel;
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

		Class<?> remoteModelClass = _itemTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_itemTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ItemTypeLocalServiceUtil.addItemType(this);
		}
		else {
			ItemTypeLocalServiceUtil.updateItemType(this);
		}
	}

	@Override
	public ItemType toEscapedModel() {
		return (ItemType)ProxyUtil.newProxyInstance(ItemType.class.getClassLoader(),
			new Class[] { ItemType.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ItemTypeClp clone = new ItemTypeClp();

		clone.setItemTypeId(getItemTypeId());
		clone.setItemTypeName(getItemTypeName());
		clone.setItemCount(getItemCount());

		return clone;
	}

	@Override
	public int compareTo(ItemType itemType) {
		long primaryKey = itemType.getPrimaryKey();

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

		if (!(obj instanceof ItemTypeClp)) {
			return false;
		}

		ItemTypeClp itemType = (ItemTypeClp)obj;

		long primaryKey = itemType.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
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
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{ItemTypeId=");
		sb.append(getItemTypeId());
		sb.append(", ItemTypeName=");
		sb.append(getItemTypeName());
		sb.append(", itemCount=");
		sb.append(getItemCount());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.ItemType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ItemTypeId</column-name><column-value><![CDATA[");
		sb.append(getItemTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ItemTypeName</column-name><column-value><![CDATA[");
		sb.append(getItemTypeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemCount</column-name><column-value><![CDATA[");
		sb.append(getItemCount());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _ItemTypeId;
	private String _ItemTypeName;
	private int _itemCount;
	private BaseModel<?> _itemTypeRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.subur.service.ClpSerializer.class;
}