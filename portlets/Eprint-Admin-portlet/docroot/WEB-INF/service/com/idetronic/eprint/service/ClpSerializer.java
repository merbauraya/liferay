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

package com.idetronic.eprint.service;

import com.idetronic.eprint.model.EprintClp;
import com.idetronic.eprint.model.EprintDivisionClp;
import com.idetronic.eprint.model.EprintStaticContentClp;
import com.idetronic.eprint.model.EprintSubjectClp;

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
						"Eprint-Admin-portlet-deployment-context");

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
							"Eprint-Admin-portlet-deployment-context");

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
				_servletContextName = "Eprint-Admin-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(EprintClp.class.getName())) {
			return translateInputEprint(oldModel);
		}

		if (oldModelClassName.equals(EprintDivisionClp.class.getName())) {
			return translateInputEprintDivision(oldModel);
		}

		if (oldModelClassName.equals(EprintStaticContentClp.class.getName())) {
			return translateInputEprintStaticContent(oldModel);
		}

		if (oldModelClassName.equals(EprintSubjectClp.class.getName())) {
			return translateInputEprintSubject(oldModel);
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

	public static Object translateInputEprint(BaseModel<?> oldModel) {
		EprintClp oldClpModel = (EprintClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEprintRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEprintDivision(BaseModel<?> oldModel) {
		EprintDivisionClp oldClpModel = (EprintDivisionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEprintDivisionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEprintStaticContent(
		BaseModel<?> oldModel) {
		EprintStaticContentClp oldClpModel = (EprintStaticContentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEprintStaticContentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEprintSubject(BaseModel<?> oldModel) {
		EprintSubjectClp oldClpModel = (EprintSubjectClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEprintSubjectRemoteModel();

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
					"com.idetronic.eprint.model.impl.EprintImpl")) {
			return translateOutputEprint(oldModel);
		}

		if (oldModelClassName.equals(
					"com.idetronic.eprint.model.impl.EprintDivisionImpl")) {
			return translateOutputEprintDivision(oldModel);
		}

		if (oldModelClassName.equals(
					"com.idetronic.eprint.model.impl.EprintStaticContentImpl")) {
			return translateOutputEprintStaticContent(oldModel);
		}

		if (oldModelClassName.equals(
					"com.idetronic.eprint.model.impl.EprintSubjectImpl")) {
			return translateOutputEprintSubject(oldModel);
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

		if (className.equals("com.idetronic.eprint.NoSuchEprintException")) {
			return new com.idetronic.eprint.NoSuchEprintException();
		}

		if (className.equals(
					"com.idetronic.eprint.NoSuchEprintDivisionException")) {
			return new com.idetronic.eprint.NoSuchEprintDivisionException();
		}

		if (className.equals(
					"com.idetronic.eprint.NoSuchEprintStaticContentException")) {
			return new com.idetronic.eprint.NoSuchEprintStaticContentException();
		}

		if (className.equals(
					"com.idetronic.eprint.NoSuchEprintSubjectException")) {
			return new com.idetronic.eprint.NoSuchEprintSubjectException();
		}

		return throwable;
	}

	public static Object translateOutputEprint(BaseModel<?> oldModel) {
		EprintClp newModel = new EprintClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEprintRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEprintDivision(BaseModel<?> oldModel) {
		EprintDivisionClp newModel = new EprintDivisionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEprintDivisionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEprintStaticContent(
		BaseModel<?> oldModel) {
		EprintStaticContentClp newModel = new EprintStaticContentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEprintStaticContentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEprintSubject(BaseModel<?> oldModel) {
		EprintSubjectClp newModel = new EprintSubjectClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEprintSubjectRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}