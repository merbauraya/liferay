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
import com.idetronic.subur.service.ItemAuthorLocalServiceUtil;
import com.idetronic.subur.service.persistence.ItemAuthorPK;

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
public class ItemAuthorClp extends BaseModelImpl<ItemAuthor>
	implements ItemAuthor {
	public ItemAuthorClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ItemAuthor.class;
	}

	@Override
	public String getModelClassName() {
		return ItemAuthor.class.getName();
	}

	@Override
	public ItemAuthorPK getPrimaryKey() {
		return new ItemAuthorPK(_itemId, _authorId);
	}

	@Override
	public void setPrimaryKey(ItemAuthorPK primaryKey) {
		setItemId(primaryKey.itemId);
		setAuthorId(primaryKey.authorId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ItemAuthorPK(_itemId, _authorId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ItemAuthorPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemId", getItemId());
		attributes.put("authorId", getAuthorId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Long authorId = (Long)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
		}
	}

	@Override
	public long getItemId() {
		return _itemId;
	}

	@Override
	public void setItemId(long itemId) {
		_itemId = itemId;

		if (_itemAuthorRemoteModel != null) {
			try {
				Class<?> clazz = _itemAuthorRemoteModel.getClass();

				Method method = clazz.getMethod("setItemId", long.class);

				method.invoke(_itemAuthorRemoteModel, itemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAuthorId() {
		return _authorId;
	}

	@Override
	public void setAuthorId(long authorId) {
		_authorId = authorId;

		if (_itemAuthorRemoteModel != null) {
			try {
				Class<?> clazz = _itemAuthorRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthorId", long.class);

				method.invoke(_itemAuthorRemoteModel, authorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getItemAuthorRemoteModel() {
		return _itemAuthorRemoteModel;
	}

	public void setItemAuthorRemoteModel(BaseModel<?> itemAuthorRemoteModel) {
		_itemAuthorRemoteModel = itemAuthorRemoteModel;
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

		Class<?> remoteModelClass = _itemAuthorRemoteModel.getClass();

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

		Object returnValue = method.invoke(_itemAuthorRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ItemAuthorLocalServiceUtil.addItemAuthor(this);
		}
		else {
			ItemAuthorLocalServiceUtil.updateItemAuthor(this);
		}
	}

	@Override
	public ItemAuthor toEscapedModel() {
		return (ItemAuthor)ProxyUtil.newProxyInstance(ItemAuthor.class.getClassLoader(),
			new Class[] { ItemAuthor.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ItemAuthorClp clone = new ItemAuthorClp();

		clone.setItemId(getItemId());
		clone.setAuthorId(getAuthorId());

		return clone;
	}

	@Override
	public int compareTo(ItemAuthor itemAuthor) {
		ItemAuthorPK primaryKey = itemAuthor.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ItemAuthorClp)) {
			return false;
		}

		ItemAuthorClp itemAuthor = (ItemAuthorClp)obj;

		ItemAuthorPK primaryKey = itemAuthor.getPrimaryKey();

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
		sb.append(", authorId=");
		sb.append(getAuthorId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.ItemAuthor");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>itemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>authorId</column-name><column-value><![CDATA[");
		sb.append(getAuthorId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _itemId;
	private long _authorId;
	private BaseModel<?> _itemAuthorRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.subur.service.ClpSerializer.class;
}