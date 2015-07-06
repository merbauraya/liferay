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

package com.idetronic.subur.service.http;

import com.idetronic.subur.service.ExpertiseServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.idetronic.subur.service.ExpertiseServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.idetronic.subur.model.ExpertiseSoap}.
 * If the method in the service utility returns a
 * {@link com.idetronic.subur.model.Expertise}, that is translated to a
 * {@link com.idetronic.subur.model.ExpertiseSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Mazlan Mat
 * @see ExpertiseServiceHttp
 * @see com.idetronic.subur.model.ExpertiseSoap
 * @see com.idetronic.subur.service.ExpertiseServiceUtil
 * @generated
 */
public class ExpertiseServiceSoap {
	public static com.idetronic.subur.model.ExpertiseSoap[] getGroupExpertises(
		long[] groupIds) throws RemoteException {
		try {
			java.util.List<com.idetronic.subur.model.Expertise> returnValue = ExpertiseServiceUtil.getGroupExpertises(groupIds);

			return com.idetronic.subur.model.ExpertiseSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.idetronic.subur.model.ExpertiseSoap[] getGroupExpertises(
		long groupId) throws RemoteException {
		try {
			java.util.List<com.idetronic.subur.model.Expertise> returnValue = ExpertiseServiceUtil.getGroupExpertises(groupId);

			return com.idetronic.subur.model.ExpertiseSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String search(long[] groupIds,
		java.lang.String name, int start, int end) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = ExpertiseServiceUtil.search(groupIds,
					name, start, end);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String search(long groupId, java.lang.String name,
		int start, int end) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = ExpertiseServiceUtil.search(groupId,
					name, start, end);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ExpertiseServiceSoap.class);
}