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

package com.idetronic.eprint.model.impl;

import com.idetronic.eprint.model.Eprint;
import com.idetronic.eprint.model.EprintModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Eprint service. Represents a row in the &quot;Eprints_Eprint&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.idetronic.eprint.model.EprintModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EprintImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see EprintImpl
 * @see com.idetronic.eprint.model.Eprint
 * @see com.idetronic.eprint.model.EprintModel
 * @generated
 */
public class EprintModelImpl extends BaseModelImpl<Eprint>
	implements EprintModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a eprint model instance should use the {@link com.idetronic.eprint.model.Eprint} interface instead.
	 */
	public static final String TABLE_NAME = "Eprints_Eprint";
	public static final Object[][] TABLE_COLUMNS = {
			{ "eprintId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "title", Types.VARCHAR },
			{ "urlTitle", Types.VARCHAR },
			{ "eprintType", Types.VARCHAR },
			{ "eprintStatus", Types.VARCHAR },
			{ "metadataVisibility", Types.VARCHAR },
			{ "eprintAbstract", Types.VARCHAR },
			{ "eprintKeywords", Types.VARCHAR },
			{ "isPublished", Types.VARCHAR },
			{ "dateYear", Types.VARCHAR },
			{ "fullTextStatus", Types.VARCHAR },
			{ "companyId", Types.BIGINT },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "createdDate", Types.TIMESTAMP },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table Eprints_Eprint (eprintId LONG not null primary key,groupId LONG,title VARCHAR(75) null,urlTitle VARCHAR(75) null,eprintType VARCHAR(75) null,eprintStatus VARCHAR(75) null,metadataVisibility VARCHAR(75) null,eprintAbstract VARCHAR(75) null,eprintKeywords VARCHAR(75) null,isPublished VARCHAR(75) null,dateYear VARCHAR(75) null,fullTextStatus VARCHAR(75) null,companyId LONG,modifiedDate DATE null,createdDate DATE null,userId LONG,userName VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table Eprints_Eprint";
	public static final String ORDER_BY_JPQL = " ORDER BY eprint.eprintId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Eprints_Eprint.eprintId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.idetronic.eprint.model.Eprint"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.idetronic.eprint.model.Eprint"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.idetronic.eprint.model.Eprint"),
			true);
	public static long EPRINTTYPE_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long URLTITLE_COLUMN_BITMASK = 4L;
	public static long EPRINTID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.idetronic.eprint.model.Eprint"));

	public EprintModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _eprintId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEprintId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eprintId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Eprint.class;
	}

	@Override
	public String getModelClassName() {
		return Eprint.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eprintId", getEprintId());
		attributes.put("groupId", getGroupId());
		attributes.put("title", getTitle());
		attributes.put("urlTitle", getUrlTitle());
		attributes.put("eprintType", getEprintType());
		attributes.put("eprintStatus", getEprintStatus());
		attributes.put("metadataVisibility", getMetadataVisibility());
		attributes.put("eprintAbstract", getEprintAbstract());
		attributes.put("eprintKeywords", getEprintKeywords());
		attributes.put("isPublished", getIsPublished());
		attributes.put("dateYear", getDateYear());
		attributes.put("fullTextStatus", getFullTextStatus());
		attributes.put("companyId", getCompanyId());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eprintId = (Long)attributes.get("eprintId");

		if (eprintId != null) {
			setEprintId(eprintId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String urlTitle = (String)attributes.get("urlTitle");

		if (urlTitle != null) {
			setUrlTitle(urlTitle);
		}

		String eprintType = (String)attributes.get("eprintType");

		if (eprintType != null) {
			setEprintType(eprintType);
		}

		String eprintStatus = (String)attributes.get("eprintStatus");

		if (eprintStatus != null) {
			setEprintStatus(eprintStatus);
		}

		String metadataVisibility = (String)attributes.get("metadataVisibility");

		if (metadataVisibility != null) {
			setMetadataVisibility(metadataVisibility);
		}

		String eprintAbstract = (String)attributes.get("eprintAbstract");

		if (eprintAbstract != null) {
			setEprintAbstract(eprintAbstract);
		}

		String eprintKeywords = (String)attributes.get("eprintKeywords");

		if (eprintKeywords != null) {
			setEprintKeywords(eprintKeywords);
		}

		String isPublished = (String)attributes.get("isPublished");

		if (isPublished != null) {
			setIsPublished(isPublished);
		}

		String dateYear = (String)attributes.get("dateYear");

		if (dateYear != null) {
			setDateYear(dateYear);
		}

		String fullTextStatus = (String)attributes.get("fullTextStatus");

		if (fullTextStatus != null) {
			setFullTextStatus(fullTextStatus);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}
	}

	@Override
	public long getEprintId() {
		return _eprintId;
	}

	@Override
	public void setEprintId(long eprintId) {
		_eprintId = eprintId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@Override
	public String getUrlTitle() {
		if (_urlTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _urlTitle;
		}
	}

	@Override
	public void setUrlTitle(String urlTitle) {
		_columnBitmask |= URLTITLE_COLUMN_BITMASK;

		if (_originalUrlTitle == null) {
			_originalUrlTitle = _urlTitle;
		}

		_urlTitle = urlTitle;
	}

	public String getOriginalUrlTitle() {
		return GetterUtil.getString(_originalUrlTitle);
	}

	@Override
	public String getEprintType() {
		if (_eprintType == null) {
			return StringPool.BLANK;
		}
		else {
			return _eprintType;
		}
	}

	@Override
	public void setEprintType(String eprintType) {
		_columnBitmask |= EPRINTTYPE_COLUMN_BITMASK;

		if (_originalEprintType == null) {
			_originalEprintType = _eprintType;
		}

		_eprintType = eprintType;
	}

	public String getOriginalEprintType() {
		return GetterUtil.getString(_originalEprintType);
	}

	@Override
	public String getEprintStatus() {
		if (_eprintStatus == null) {
			return StringPool.BLANK;
		}
		else {
			return _eprintStatus;
		}
	}

	@Override
	public void setEprintStatus(String eprintStatus) {
		_eprintStatus = eprintStatus;
	}

	@Override
	public String getMetadataVisibility() {
		if (_metadataVisibility == null) {
			return StringPool.BLANK;
		}
		else {
			return _metadataVisibility;
		}
	}

	@Override
	public void setMetadataVisibility(String metadataVisibility) {
		_metadataVisibility = metadataVisibility;
	}

	@Override
	public String getEprintAbstract() {
		if (_eprintAbstract == null) {
			return StringPool.BLANK;
		}
		else {
			return _eprintAbstract;
		}
	}

	@Override
	public void setEprintAbstract(String eprintAbstract) {
		_eprintAbstract = eprintAbstract;
	}

	@Override
	public String getEprintKeywords() {
		if (_eprintKeywords == null) {
			return StringPool.BLANK;
		}
		else {
			return _eprintKeywords;
		}
	}

	@Override
	public void setEprintKeywords(String eprintKeywords) {
		_eprintKeywords = eprintKeywords;
	}

	@Override
	public String getIsPublished() {
		if (_isPublished == null) {
			return StringPool.BLANK;
		}
		else {
			return _isPublished;
		}
	}

	@Override
	public void setIsPublished(String isPublished) {
		_isPublished = isPublished;
	}

	@Override
	public String getDateYear() {
		if (_dateYear == null) {
			return StringPool.BLANK;
		}
		else {
			return _dateYear;
		}
	}

	@Override
	public void setDateYear(String dateYear) {
		_dateYear = dateYear;
	}

	@Override
	public String getFullTextStatus() {
		if (_fullTextStatus == null) {
			return StringPool.BLANK;
		}
		else {
			return _fullTextStatus;
		}
	}

	@Override
	public void setFullTextStatus(String fullTextStatus) {
		_fullTextStatus = fullTextStatus;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
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
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Eprint.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Eprint toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Eprint)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EprintImpl eprintImpl = new EprintImpl();

		eprintImpl.setEprintId(getEprintId());
		eprintImpl.setGroupId(getGroupId());
		eprintImpl.setTitle(getTitle());
		eprintImpl.setUrlTitle(getUrlTitle());
		eprintImpl.setEprintType(getEprintType());
		eprintImpl.setEprintStatus(getEprintStatus());
		eprintImpl.setMetadataVisibility(getMetadataVisibility());
		eprintImpl.setEprintAbstract(getEprintAbstract());
		eprintImpl.setEprintKeywords(getEprintKeywords());
		eprintImpl.setIsPublished(getIsPublished());
		eprintImpl.setDateYear(getDateYear());
		eprintImpl.setFullTextStatus(getFullTextStatus());
		eprintImpl.setCompanyId(getCompanyId());
		eprintImpl.setModifiedDate(getModifiedDate());
		eprintImpl.setCreatedDate(getCreatedDate());
		eprintImpl.setUserId(getUserId());
		eprintImpl.setUserName(getUserName());

		eprintImpl.resetOriginalValues();

		return eprintImpl;
	}

	@Override
	public int compareTo(Eprint eprint) {
		long primaryKey = eprint.getPrimaryKey();

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

		if (!(obj instanceof Eprint)) {
			return false;
		}

		Eprint eprint = (Eprint)obj;

		long primaryKey = eprint.getPrimaryKey();

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
		EprintModelImpl eprintModelImpl = this;

		eprintModelImpl._originalGroupId = eprintModelImpl._groupId;

		eprintModelImpl._setOriginalGroupId = false;

		eprintModelImpl._originalUrlTitle = eprintModelImpl._urlTitle;

		eprintModelImpl._originalEprintType = eprintModelImpl._eprintType;

		eprintModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Eprint> toCacheModel() {
		EprintCacheModel eprintCacheModel = new EprintCacheModel();

		eprintCacheModel.eprintId = getEprintId();

		eprintCacheModel.groupId = getGroupId();

		eprintCacheModel.title = getTitle();

		String title = eprintCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			eprintCacheModel.title = null;
		}

		eprintCacheModel.urlTitle = getUrlTitle();

		String urlTitle = eprintCacheModel.urlTitle;

		if ((urlTitle != null) && (urlTitle.length() == 0)) {
			eprintCacheModel.urlTitle = null;
		}

		eprintCacheModel.eprintType = getEprintType();

		String eprintType = eprintCacheModel.eprintType;

		if ((eprintType != null) && (eprintType.length() == 0)) {
			eprintCacheModel.eprintType = null;
		}

		eprintCacheModel.eprintStatus = getEprintStatus();

		String eprintStatus = eprintCacheModel.eprintStatus;

		if ((eprintStatus != null) && (eprintStatus.length() == 0)) {
			eprintCacheModel.eprintStatus = null;
		}

		eprintCacheModel.metadataVisibility = getMetadataVisibility();

		String metadataVisibility = eprintCacheModel.metadataVisibility;

		if ((metadataVisibility != null) && (metadataVisibility.length() == 0)) {
			eprintCacheModel.metadataVisibility = null;
		}

		eprintCacheModel.eprintAbstract = getEprintAbstract();

		String eprintAbstract = eprintCacheModel.eprintAbstract;

		if ((eprintAbstract != null) && (eprintAbstract.length() == 0)) {
			eprintCacheModel.eprintAbstract = null;
		}

		eprintCacheModel.eprintKeywords = getEprintKeywords();

		String eprintKeywords = eprintCacheModel.eprintKeywords;

		if ((eprintKeywords != null) && (eprintKeywords.length() == 0)) {
			eprintCacheModel.eprintKeywords = null;
		}

		eprintCacheModel.isPublished = getIsPublished();

		String isPublished = eprintCacheModel.isPublished;

		if ((isPublished != null) && (isPublished.length() == 0)) {
			eprintCacheModel.isPublished = null;
		}

		eprintCacheModel.dateYear = getDateYear();

		String dateYear = eprintCacheModel.dateYear;

		if ((dateYear != null) && (dateYear.length() == 0)) {
			eprintCacheModel.dateYear = null;
		}

		eprintCacheModel.fullTextStatus = getFullTextStatus();

		String fullTextStatus = eprintCacheModel.fullTextStatus;

		if ((fullTextStatus != null) && (fullTextStatus.length() == 0)) {
			eprintCacheModel.fullTextStatus = null;
		}

		eprintCacheModel.companyId = getCompanyId();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			eprintCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			eprintCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			eprintCacheModel.createdDate = createdDate.getTime();
		}
		else {
			eprintCacheModel.createdDate = Long.MIN_VALUE;
		}

		eprintCacheModel.userId = getUserId();

		eprintCacheModel.userName = getUserName();

		String userName = eprintCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			eprintCacheModel.userName = null;
		}

		return eprintCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{eprintId=");
		sb.append(getEprintId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", urlTitle=");
		sb.append(getUrlTitle());
		sb.append(", eprintType=");
		sb.append(getEprintType());
		sb.append(", eprintStatus=");
		sb.append(getEprintStatus());
		sb.append(", metadataVisibility=");
		sb.append(getMetadataVisibility());
		sb.append(", eprintAbstract=");
		sb.append(getEprintAbstract());
		sb.append(", eprintKeywords=");
		sb.append(getEprintKeywords());
		sb.append(", isPublished=");
		sb.append(getIsPublished());
		sb.append(", dateYear=");
		sb.append(getDateYear());
		sb.append(", fullTextStatus=");
		sb.append(getFullTextStatus());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eprint.model.Eprint");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eprintId</column-name><column-value><![CDATA[");
		sb.append(getEprintId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>urlTitle</column-name><column-value><![CDATA[");
		sb.append(getUrlTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eprintType</column-name><column-value><![CDATA[");
		sb.append(getEprintType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eprintStatus</column-name><column-value><![CDATA[");
		sb.append(getEprintStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>metadataVisibility</column-name><column-value><![CDATA[");
		sb.append(getMetadataVisibility());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eprintAbstract</column-name><column-value><![CDATA[");
		sb.append(getEprintAbstract());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eprintKeywords</column-name><column-value><![CDATA[");
		sb.append(getEprintKeywords());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isPublished</column-name><column-value><![CDATA[");
		sb.append(getIsPublished());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateYear</column-name><column-value><![CDATA[");
		sb.append(getDateYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fullTextStatus</column-name><column-value><![CDATA[");
		sb.append(getFullTextStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Eprint.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Eprint.class };
	private long _eprintId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private String _title;
	private String _urlTitle;
	private String _originalUrlTitle;
	private String _eprintType;
	private String _originalEprintType;
	private String _eprintStatus;
	private String _metadataVisibility;
	private String _eprintAbstract;
	private String _eprintKeywords;
	private String _isPublished;
	private String _dateYear;
	private String _fullTextStatus;
	private long _companyId;
	private Date _modifiedDate;
	private Date _createdDate;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private long _columnBitmask;
	private Eprint _escapedModel;
}