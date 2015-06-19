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
import com.idetronic.subur.service.ItemSubjectLocalServiceUtil;
import com.idetronic.subur.service.persistence.ItemSubjectPK;

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
public class ItemSubjectClp extends BaseModelImpl<ItemSubject>
	implements ItemSubject {
	public ItemSubjectClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ItemSubject.class;
	}

	@Override
	public String getModelClassName() {
		return ItemSubject.class.getName();
	}

	@Override
	public ItemSubjectPK getPrimaryKey() {
		return new ItemSubjectPK(_itemId, _subjectId);
	}

	@Override
	public void setPrimaryKey(ItemSubjectPK primaryKey) {
		setItemId(primaryKey.itemId);
		setSubjectId(primaryKey.subjectId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ItemSubjectPK(_itemId, _subjectId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ItemSubjectPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemId", getItemId());
		attributes.put("subjectId", getSubjectId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Long subjectId = (Long)attributes.get("subjectId");

		if (subjectId != null) {
			setSubjectId(subjectId);
		}
	}

	@Override
	public long getItemId() {
		return _itemId;
	}

	@Override
	public void setItemId(long itemId) {
		_itemId = itemId;

		if (_itemSubjectRemoteModel != null) {
			try {
				Class<?> clazz = _itemSubjectRemoteModel.getClass();

				Method method = clazz.getMethod("setItemId", long.class);

				method.invoke(_itemSubjectRemoteModel, itemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSubjectId() {
		return _subjectId;
	}

	@Override
	public void setSubjectId(long subjectId) {
		_subjectId = subjectId;

		if (_itemSubjectRemoteModel != null) {
			try {
				Class<?> clazz = _itemSubjectRemoteModel.getClass();

				Method method = clazz.getMethod("setSubjectId", long.class);

				method.invoke(_itemSubjectRemoteModel, subjectId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getItemSubjectRemoteModel() {
		return _itemSubjectRemoteModel;
	}

	public void setItemSubjectRemoteModel(BaseModel<?> itemSubjectRemoteModel) {
		_itemSubjectRemoteModel = itemSubjectRemoteModel;
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

		Class<?> remoteModelClass = _itemSubjectRemoteModel.getClass();

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

		Object returnValue = method.invoke(_itemSubjectRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ItemSubjectLocalServiceUtil.addItemSubject(this);
		}
		else {
			ItemSubjectLocalServiceUtil.updateItemSubject(this);
		}
	}

	@Override
	public ItemSubject toEscapedModel() {
		return (ItemSubject)ProxyUtil.newProxyInstance(ItemSubject.class.getClassLoader(),
			new Class[] { ItemSubject.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ItemSubjectClp clone = new ItemSubjectClp();

		clone.setItemId(getItemId());
		clone.setSubjectId(getSubjectId());

		return clone;
	}

	@Override
	public int compareTo(ItemSubject itemSubject) {
		ItemSubjectPK primaryKey = itemSubject.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ItemSubjectClp)) {
			return false;
		}

		ItemSubjectClp itemSubject = (ItemSubjectClp)obj;

		ItemSubjectPK primaryKey = itemSubject.getPrimaryKey();

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
		sb.append(", subjectId=");
		sb.append(getSubjectId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.ItemSubject");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>itemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subjectId</column-name><column-value><![CDATA[");
		sb.append(getSubjectId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _itemId;
	private long _subjectId;
	private BaseModel<?> _itemSubjectRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.subur.service.ClpSerializer.class;
}