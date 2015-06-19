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
import com.idetronic.subur.service.ItemDivisionLocalServiceUtil;
import com.idetronic.subur.service.persistence.ItemDivisionPK;

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
public class ItemDivisionClp extends BaseModelImpl<ItemDivision>
	implements ItemDivision {
	public ItemDivisionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ItemDivision.class;
	}

	@Override
	public String getModelClassName() {
		return ItemDivision.class.getName();
	}

	@Override
	public ItemDivisionPK getPrimaryKey() {
		return new ItemDivisionPK(_itemId, _divisionId);
	}

	@Override
	public void setPrimaryKey(ItemDivisionPK primaryKey) {
		setItemId(primaryKey.itemId);
		setDivisionId(primaryKey.divisionId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ItemDivisionPK(_itemId, _divisionId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ItemDivisionPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemId", getItemId());
		attributes.put("divisionId", getDivisionId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Long divisionId = (Long)attributes.get("divisionId");

		if (divisionId != null) {
			setDivisionId(divisionId);
		}
	}

	@Override
	public long getItemId() {
		return _itemId;
	}

	@Override
	public void setItemId(long itemId) {
		_itemId = itemId;

		if (_itemDivisionRemoteModel != null) {
			try {
				Class<?> clazz = _itemDivisionRemoteModel.getClass();

				Method method = clazz.getMethod("setItemId", long.class);

				method.invoke(_itemDivisionRemoteModel, itemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDivisionId() {
		return _divisionId;
	}

	@Override
	public void setDivisionId(long divisionId) {
		_divisionId = divisionId;

		if (_itemDivisionRemoteModel != null) {
			try {
				Class<?> clazz = _itemDivisionRemoteModel.getClass();

				Method method = clazz.getMethod("setDivisionId", long.class);

				method.invoke(_itemDivisionRemoteModel, divisionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getItemDivisionRemoteModel() {
		return _itemDivisionRemoteModel;
	}

	public void setItemDivisionRemoteModel(BaseModel<?> itemDivisionRemoteModel) {
		_itemDivisionRemoteModel = itemDivisionRemoteModel;
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

		Class<?> remoteModelClass = _itemDivisionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_itemDivisionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ItemDivisionLocalServiceUtil.addItemDivision(this);
		}
		else {
			ItemDivisionLocalServiceUtil.updateItemDivision(this);
		}
	}

	@Override
	public ItemDivision toEscapedModel() {
		return (ItemDivision)ProxyUtil.newProxyInstance(ItemDivision.class.getClassLoader(),
			new Class[] { ItemDivision.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ItemDivisionClp clone = new ItemDivisionClp();

		clone.setItemId(getItemId());
		clone.setDivisionId(getDivisionId());

		return clone;
	}

	@Override
	public int compareTo(ItemDivision itemDivision) {
		ItemDivisionPK primaryKey = itemDivision.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ItemDivisionClp)) {
			return false;
		}

		ItemDivisionClp itemDivision = (ItemDivisionClp)obj;

		ItemDivisionPK primaryKey = itemDivision.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{itemId=");
		sb.append(getItemId());
		sb.append(", divisionId=");
		sb.append(getDivisionId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.ItemDivision");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>itemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>divisionId</column-name><column-value><![CDATA[");
		sb.append(getDivisionId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _itemId;
	private long _divisionId;
	private BaseModel<?> _itemDivisionRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.subur.service.ClpSerializer.class;
}