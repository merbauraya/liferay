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

package com.idetronic.subur.model.impl;

import com.idetronic.subur.model.StatViewTag;
import com.idetronic.subur.model.StatViewTagModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the StatViewTag service. Represents a row in the &quot;Subur_StatViewTag&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.idetronic.subur.model.StatViewTagModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StatViewTagImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see StatViewTagImpl
 * @see com.idetronic.subur.model.StatViewTag
 * @see com.idetronic.subur.model.StatViewTagModel
 * @generated
 */
public class StatViewTagModelImpl extends BaseModelImpl<StatViewTag>
	implements StatViewTagModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a stat view tag model instance should use the {@link com.idetronic.subur.model.StatViewTag} interface instead.
	 */
	public static final String TABLE_NAME = "Subur_StatViewTag";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT },
			{ "perMonth", Types.INTEGER },
			{ "perYear", Types.INTEGER },
			{ "tagId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table Subur_StatViewTag (id_ LONG not null primary key,perMonth INTEGER,perYear INTEGER,tagId LONG)";
	public static final String TABLE_SQL_DROP = "drop table Subur_StatViewTag";
	public static final String ORDER_BY_JPQL = " ORDER BY statViewTag.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Subur_StatViewTag.id_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.idetronic.subur.model.StatViewTag"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.idetronic.subur.model.StatViewTag"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.idetronic.subur.model.StatViewTag"),
			true);
	public static long TAGID_COLUMN_BITMASK = 1L;
	public static long ID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.idetronic.subur.model.StatViewTag"));

	public StatViewTagModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return StatViewTag.class;
	}

	@Override
	public String getModelClassName() {
		return StatViewTag.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("perMonth", getPerMonth());
		attributes.put("perYear", getPerYear());
		attributes.put("tagId", getTagId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Integer perMonth = (Integer)attributes.get("perMonth");

		if (perMonth != null) {
			setPerMonth(perMonth);
		}

		Integer perYear = (Integer)attributes.get("perYear");

		if (perYear != null) {
			setPerYear(perYear);
		}

		Long tagId = (Long)attributes.get("tagId");

		if (tagId != null) {
			setTagId(tagId);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@Override
	public int getPerMonth() {
		return _perMonth;
	}

	@Override
	public void setPerMonth(int perMonth) {
		_perMonth = perMonth;
	}

	@Override
	public int getPerYear() {
		return _perYear;
	}

	@Override
	public void setPerYear(int perYear) {
		_perYear = perYear;
	}

	@Override
	public long getTagId() {
		return _tagId;
	}

	@Override
	public void setTagId(long tagId) {
		_columnBitmask |= TAGID_COLUMN_BITMASK;

		if (!_setOriginalTagId) {
			_setOriginalTagId = true;

			_originalTagId = _tagId;
		}

		_tagId = tagId;
	}

	public long getOriginalTagId() {
		return _originalTagId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			StatViewTag.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public StatViewTag toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (StatViewTag)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		StatViewTagImpl statViewTagImpl = new StatViewTagImpl();

		statViewTagImpl.setId(getId());
		statViewTagImpl.setPerMonth(getPerMonth());
		statViewTagImpl.setPerYear(getPerYear());
		statViewTagImpl.setTagId(getTagId());

		statViewTagImpl.resetOriginalValues();

		return statViewTagImpl;
	}

	@Override
	public int compareTo(StatViewTag statViewTag) {
		long primaryKey = statViewTag.getPrimaryKey();

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

		if (!(obj instanceof StatViewTag)) {
			return false;
		}

		StatViewTag statViewTag = (StatViewTag)obj;

		long primaryKey = statViewTag.getPrimaryKey();

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
	public void resetOriginalValues() {
		StatViewTagModelImpl statViewTagModelImpl = this;

		statViewTagModelImpl._originalTagId = statViewTagModelImpl._tagId;

		statViewTagModelImpl._setOriginalTagId = false;

		statViewTagModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<StatViewTag> toCacheModel() {
		StatViewTagCacheModel statViewTagCacheModel = new StatViewTagCacheModel();

		statViewTagCacheModel.id = getId();

		statViewTagCacheModel.perMonth = getPerMonth();

		statViewTagCacheModel.perYear = getPerYear();

		statViewTagCacheModel.tagId = getTagId();

		return statViewTagCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", perMonth=");
		sb.append(getPerMonth());
		sb.append(", perYear=");
		sb.append(getPerYear());
		sb.append(", tagId=");
		sb.append(getTagId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.StatViewTag");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>perMonth</column-name><column-value><![CDATA[");
		sb.append(getPerMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>perYear</column-name><column-value><![CDATA[");
		sb.append(getPerYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tagId</column-name><column-value><![CDATA[");
		sb.append(getTagId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = StatViewTag.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			StatViewTag.class
		};
	private long _id;
	private int _perMonth;
	private int _perYear;
	private long _tagId;
	private long _originalTagId;
	private boolean _setOriginalTagId;
	private long _columnBitmask;
	private StatViewTag _escapedModel;
}