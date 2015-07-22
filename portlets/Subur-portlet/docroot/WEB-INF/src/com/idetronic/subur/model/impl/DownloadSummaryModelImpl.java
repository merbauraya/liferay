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

import com.idetronic.subur.model.DownloadSummary;
import com.idetronic.subur.model.DownloadSummaryModel;

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
 * The base model implementation for the DownloadSummary service. Represents a row in the &quot;Subur_DownloadSummary&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.idetronic.subur.model.DownloadSummaryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DownloadSummaryImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see DownloadSummaryImpl
 * @see com.idetronic.subur.model.DownloadSummary
 * @see com.idetronic.subur.model.DownloadSummaryModel
 * @generated
 */
public class DownloadSummaryModelImpl extends BaseModelImpl<DownloadSummary>
	implements DownloadSummaryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a download summary model instance should use the {@link com.idetronic.subur.model.DownloadSummary} interface instead.
	 */
	public static final String TABLE_NAME = "Subur_DownloadSummary";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT },
			{ "itemId", Types.BIGINT },
			{ "perMonth", Types.INTEGER },
			{ "perYear", Types.INTEGER },
			{ "status", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table Subur_DownloadSummary (id_ LONG not null primary key,itemId LONG,perMonth INTEGER,perYear INTEGER,status INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table Subur_DownloadSummary";
	public static final String ORDER_BY_JPQL = " ORDER BY downloadSummary.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Subur_DownloadSummary.id_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.idetronic.subur.model.DownloadSummary"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.idetronic.subur.model.DownloadSummary"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.idetronic.subur.model.DownloadSummary"),
			true);
	public static long ITEMID_COLUMN_BITMASK = 1L;
	public static long PERMONTH_COLUMN_BITMASK = 2L;
	public static long PERYEAR_COLUMN_BITMASK = 4L;
	public static long STATUS_COLUMN_BITMASK = 8L;
	public static long ID_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.idetronic.subur.model.DownloadSummary"));

	public DownloadSummaryModelImpl() {
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
		return DownloadSummary.class;
	}

	@Override
	public String getModelClassName() {
		return DownloadSummary.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("itemId", getItemId());
		attributes.put("perMonth", getPerMonth());
		attributes.put("perYear", getPerYear());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Integer perMonth = (Integer)attributes.get("perMonth");

		if (perMonth != null) {
			setPerMonth(perMonth);
		}

		Integer perYear = (Integer)attributes.get("perYear");

		if (perYear != null) {
			setPerYear(perYear);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
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
	public long getItemId() {
		return _itemId;
	}

	@Override
	public void setItemId(long itemId) {
		_columnBitmask |= ITEMID_COLUMN_BITMASK;

		if (!_setOriginalItemId) {
			_setOriginalItemId = true;

			_originalItemId = _itemId;
		}

		_itemId = itemId;
	}

	public long getOriginalItemId() {
		return _originalItemId;
	}

	@Override
	public int getPerMonth() {
		return _perMonth;
	}

	@Override
	public void setPerMonth(int perMonth) {
		_columnBitmask |= PERMONTH_COLUMN_BITMASK;

		if (!_setOriginalPerMonth) {
			_setOriginalPerMonth = true;

			_originalPerMonth = _perMonth;
		}

		_perMonth = perMonth;
	}

	public int getOriginalPerMonth() {
		return _originalPerMonth;
	}

	@Override
	public int getPerYear() {
		return _perYear;
	}

	@Override
	public void setPerYear(int perYear) {
		_columnBitmask |= PERYEAR_COLUMN_BITMASK;

		if (!_setOriginalPerYear) {
			_setOriginalPerYear = true;

			_originalPerYear = _perYear;
		}

		_perYear = perYear;
	}

	public int getOriginalPerYear() {
		return _originalPerYear;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			DownloadSummary.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DownloadSummary toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (DownloadSummary)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DownloadSummaryImpl downloadSummaryImpl = new DownloadSummaryImpl();

		downloadSummaryImpl.setId(getId());
		downloadSummaryImpl.setItemId(getItemId());
		downloadSummaryImpl.setPerMonth(getPerMonth());
		downloadSummaryImpl.setPerYear(getPerYear());
		downloadSummaryImpl.setStatus(getStatus());

		downloadSummaryImpl.resetOriginalValues();

		return downloadSummaryImpl;
	}

	@Override
	public int compareTo(DownloadSummary downloadSummary) {
		long primaryKey = downloadSummary.getPrimaryKey();

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

		if (!(obj instanceof DownloadSummary)) {
			return false;
		}

		DownloadSummary downloadSummary = (DownloadSummary)obj;

		long primaryKey = downloadSummary.getPrimaryKey();

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
		DownloadSummaryModelImpl downloadSummaryModelImpl = this;

		downloadSummaryModelImpl._originalItemId = downloadSummaryModelImpl._itemId;

		downloadSummaryModelImpl._setOriginalItemId = false;

		downloadSummaryModelImpl._originalPerMonth = downloadSummaryModelImpl._perMonth;

		downloadSummaryModelImpl._setOriginalPerMonth = false;

		downloadSummaryModelImpl._originalPerYear = downloadSummaryModelImpl._perYear;

		downloadSummaryModelImpl._setOriginalPerYear = false;

		downloadSummaryModelImpl._originalStatus = downloadSummaryModelImpl._status;

		downloadSummaryModelImpl._setOriginalStatus = false;

		downloadSummaryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DownloadSummary> toCacheModel() {
		DownloadSummaryCacheModel downloadSummaryCacheModel = new DownloadSummaryCacheModel();

		downloadSummaryCacheModel.id = getId();

		downloadSummaryCacheModel.itemId = getItemId();

		downloadSummaryCacheModel.perMonth = getPerMonth();

		downloadSummaryCacheModel.perYear = getPerYear();

		downloadSummaryCacheModel.status = getStatus();

		return downloadSummaryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", itemId=");
		sb.append(getItemId());
		sb.append(", perMonth=");
		sb.append(getPerMonth());
		sb.append(", perYear=");
		sb.append(getPerYear());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.DownloadSummary");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
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
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = DownloadSummary.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			DownloadSummary.class
		};
	private long _id;
	private long _itemId;
	private long _originalItemId;
	private boolean _setOriginalItemId;
	private int _perMonth;
	private int _originalPerMonth;
	private boolean _setOriginalPerMonth;
	private int _perYear;
	private int _originalPerYear;
	private boolean _setOriginalPerYear;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _columnBitmask;
	private DownloadSummary _escapedModel;
}