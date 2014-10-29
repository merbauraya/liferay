package com.idetronic.portlet.model;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.idetronic.portlet.service.ClpSerializer;
import com.idetronic.portlet.service.ServiceExperienceLocalServiceUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

public class ServiceExperienceClp extends BaseModelImpl<ServiceExperience>
	implements ServiceExperience
{
	@Override
	public Class<?> getModelClass() {
		return ServiceExperience.class;
	}

	@Override
	public String getModelClassName() {
		return ServiceExperience.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _serviceExperienceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setServiceExperienceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _serviceExperienceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("serviceExperienceId", getServiceExperienceId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("serviceData", getServiceData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long serviceExperienceId = (Long)attributes.get("serviceExperienceId");

		if (serviceExperienceId != null) {
			setServiceExperienceId(serviceExperienceId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String data = (String)attributes.get("serviceData");

		if (data != null) {
			setServiceData(data);
		}
	}

	@Override
	public long getServiceExperienceId() {
		return _serviceExperienceId;
	}

	@Override
	public void setServiceExperienceId(long serviceExperienceId) {
		_serviceExperienceId = serviceExperienceId;

		if (_serviceExperienceRemoteModel != null) {
			try {
				Class<?> clazz = _serviceExperienceRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceExperienceId", long.class);

				method.invoke(_serviceExperienceRemoteModel, serviceExperienceId);
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

		if (_serviceExperienceRemoteModel != null) {
			try {
				Class<?> clazz = _serviceExperienceRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_serviceExperienceRemoteModel, companyId);
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

		if (_serviceExperienceRemoteModel != null) {
			try {
				Class<?> clazz = _serviceExperienceRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_serviceExperienceRemoteModel, userId);
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

		if (_serviceExperienceRemoteModel != null) {
			try {
				Class<?> clazz = _serviceExperienceRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_serviceExperienceRemoteModel, userName);
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

		if (_serviceExperienceRemoteModel != null) {
			try {
				Class<?> clazz = _serviceExperienceRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_serviceExperienceRemoteModel, createDate);
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

		if (_serviceExperienceRemoteModel != null) {
			try {
				Class<?> clazz = _serviceExperienceRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_serviceExperienceRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_serviceExperienceRemoteModel != null) {
			try {
				Class<?> clazz = _serviceExperienceRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_serviceExperienceRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	

	@Override
	public Date getStartDate() {
		return _startDate;
	}
	@Override
	public String getServiceData() {
		return _serviceData;
	}

	@Override
	public void setServiceData(String serviceData) {
		_serviceData = serviceData;

		if (_serviceExperienceRemoteModel != null) {
			try {
				Class<?> clazz = _serviceExperienceRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceData", String.class);

				method.invoke(_serviceExperienceRemoteModel, serviceData);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
		
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		
		_status = status;

		if (_serviceExperienceRemoteModel != null) {
			try {
				Class<?> clazz = _serviceExperienceRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_serviceExperienceRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;

		if (_serviceExperienceRemoteModel != null) {
			try {
				Class<?> clazz = _serviceExperienceRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_serviceExperienceRemoteModel, startDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;

		if (_serviceExperienceRemoteModel != null) {
			try {
				Class<?> clazz = _serviceExperienceRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_serviceExperienceRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public BaseModel<?> getServiceExperienceRemoteModel() {
		return _serviceExperienceRemoteModel;
	}

	public void setServiceExperienceRemoteModel(
		BaseModel<?> serviceExperienceRemoteModel) {
		_serviceExperienceRemoteModel = serviceExperienceRemoteModel;
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

		Class<?> remoteModelClass = _serviceExperienceRemoteModel.getClass();

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

		Object returnValue = method.invoke(_serviceExperienceRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ServiceExperienceLocalServiceUtil.addServiceExperience(this);
		}
		else {
			ServiceExperienceLocalServiceUtil.updateServiceExperience(this);
		}
	}

	@Override
	public ServiceExperience toEscapedModel() {
		return (ServiceExperience)ProxyUtil.newProxyInstance(ServiceExperience.class.getClassLoader(),
			new Class[] { ServiceExperience.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ServiceExperienceClp clone = new ServiceExperienceClp();

		clone.setServiceExperienceId(getServiceExperienceId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setTitle(getTitle());
		
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setServiceData(getServiceData());

		return clone;
	}

	@Override
	public int compareTo(ServiceExperience serviceExperience) {
		int value = 0;

		value = DateUtil.compareTo(getEndDate(), serviceExperience.getEndDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServiceExperienceClp)) {
			return false;
		}

		ServiceExperienceClp serviceExperience = (ServiceExperienceClp)obj;

		long primaryKey = serviceExperience.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{serviceExperienceId=");
		sb.append(getServiceExperienceId());
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
		sb.append(", title=");
		sb.append(getTitle());
		
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", serviceData=");
		sb.append(getServiceData());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.portlet.ServiceExperience");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>serviceExperienceId</column-name><column-value><![CDATA[");
		sb.append(getServiceExperienceId());
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
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceData</column-name><column-value><![CDATA[");
		sb.append(getServiceData());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _serviceExperienceId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _description;
	private Date _startDate;
	private Date _endDate;
	private String _serviceData;
	private int _status;
	private BaseModel<?> _serviceExperienceRemoteModel; //_serviceExperienceRemoteModel
	
	


}
