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

package com.idetronic.eprint.service.impl;

import com.idetronic.eprint.model.Eprint;
import com.idetronic.eprint.model.EprintStaticContent;
import com.idetronic.eprint.model.impl.EprintImpl;
import com.idetronic.eprint.model.impl.EprintStaticContentImpl;
import com.idetronic.eprint.service.base.EprintStaticContentLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the eprint static content local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eprint.service.EprintStaticContentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author matle
 * @see com.idetronic.eprint.service.base.EprintStaticContentLocalServiceBaseImpl
 * @see com.idetronic.eprint.service.EprintStaticContentLocalServiceUtil
 */
public class EprintStaticContentLocalServiceImpl
	extends EprintStaticContentLocalServiceBaseImpl {
	private static final Log log = LogFactoryUtil.getLog(EprintStaticContentLocalServiceImpl.class);
	public EprintStaticContent addContent(long key,String content)
	{
		EprintStaticContent eprint = new EprintStaticContentImpl();
		eprint.setContentId(key);
		eprint.setContent(content);
		try {
			eprint = eprintStaticContentPersistence.update(eprint, false);
		} catch (SystemException e) {
			log.error(e);
		}
		return eprint;
		
	}
}