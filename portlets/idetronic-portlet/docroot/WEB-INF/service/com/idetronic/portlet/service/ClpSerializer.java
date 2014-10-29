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

package com.idetronic.portlet.service;

import com.idetronic.portlet.model.ExpertiseTagClp;
import com.idetronic.portlet.model.OrgChartClp;
import com.idetronic.portlet.model.ServiceExperienceClp;
import com.idetronic.portlet.model.UserEntries_ExpertiseTagsClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mazlan Mat
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"idetronic-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"idetronic-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "idetronic-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(ExpertiseTagClp.class.getName())) {
			return translateInputExpertiseTag(oldModel);
		}

		if (oldModelClassName.equals(OrgChartClp.class.getName())) {
			return translateInputOrgChart(oldModel);
		}

		if (oldModelClassName.equals(ServiceExperienceClp.class.getName())) {
			return translateInputServiceExperience(oldModel);
		}

		if (oldModelClassName.equals(
					UserEntries_ExpertiseTagsClp.class.getName())) {
			return translateInputUserEntries_ExpertiseTags(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputExpertiseTag(BaseModel<?> oldModel) {
		ExpertiseTagClp oldClpModel = (ExpertiseTagClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getExpertiseTagRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputOrgChart(BaseModel<?> oldModel) {
		OrgChartClp oldClpModel = (OrgChartClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getOrgChartRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputServiceExperience(BaseModel<?> oldModel) {
		ServiceExperienceClp oldClpModel = (ServiceExperienceClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getServiceExperienceRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUserEntries_ExpertiseTags(
		BaseModel<?> oldModel) {
		UserEntries_ExpertiseTagsClp oldClpModel = (UserEntries_ExpertiseTagsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUserEntries_ExpertiseTagsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.idetronic.portlet.model.impl.ExpertiseTagImpl")) {
			return translateOutputExpertiseTag(oldModel);
		}

		if (oldModelClassName.equals(
					"com.idetronic.portlet.model.impl.OrgChartImpl")) {
			return translateOutputOrgChart(oldModel);
		}

		if (oldModelClassName.equals(
					"com.idetronic.portlet.model.impl.ServiceExperienceImpl")) {
			return translateOutputServiceExperience(oldModel);
		}

		if (oldModelClassName.equals(
					"com.idetronic.portlet.model.impl.UserEntries_ExpertiseTagsImpl")) {
			return translateOutputUserEntries_ExpertiseTags(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"com.idetronic.portlet.NoSuchExpertiseTagException")) {
			return new com.idetronic.portlet.NoSuchExpertiseTagException();
		}

		if (className.equals("com.idetronic.portlet.NoSuchOrgChartException")) {
			return new com.idetronic.portlet.NoSuchOrgChartException();
		}

		if (className.equals(
					"com.idetronic.portlet.NoSuchServiceExperienceException")) {
			return new com.idetronic.portlet.NoSuchServiceExperienceException();
		}

		if (className.equals(
					"com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException")) {
			return new com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException();
		}

		return throwable;
	}

	public static Object translateOutputExpertiseTag(BaseModel<?> oldModel) {
		ExpertiseTagClp newModel = new ExpertiseTagClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setExpertiseTagRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputOrgChart(BaseModel<?> oldModel) {
		OrgChartClp newModel = new OrgChartClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setOrgChartRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputServiceExperience(BaseModel<?> oldModel) {
		ServiceExperienceClp newModel = new ServiceExperienceClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setServiceExperienceRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUserEntries_ExpertiseTags(
		BaseModel<?> oldModel) {
		UserEntries_ExpertiseTagsClp newModel = new UserEntries_ExpertiseTagsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUserEntries_ExpertiseTagsRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}