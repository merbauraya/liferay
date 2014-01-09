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
import com.idetronic.eprint.model.impl.EprintImpl;
import com.idetronic.eprint.service.base.EprintLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the eprint local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eprint.service.EprintLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author matle
 * @see com.idetronic.eprint.service.base.EprintLocalServiceBaseImpl
 * @see com.idetronic.eprint.service.EprintLocalServiceUtil
 */
public class EprintLocalServiceImpl extends EprintLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eprint.service.EprintLocalServiceUtil} to access the eprint local service.
	 */
	public Eprint insertEprint(long eprintId,String title,String eprintAbstract,String eprintStatus,String eprintType,
			                String metadataVisibility,String eprintKeywords,String isPublished,
			                String dateYear,String fullTextStatus)
	{
		Eprint eprint = new EprintImpl();
		eprint.setEprintId(eprintId);
		eprint.setTitle(title);
		eprint.setEprintAbstract(eprintAbstract);
		eprint.setEprintStatus(eprintStatus);
		eprint.setEprintType(eprintType);
		eprint.setMetadataVisibility(metadataVisibility);
		eprint.setEprintKeywords(eprintKeywords);
		eprint.setIsPublished(isPublished);
		eprint.setDateYear(dateYear);
		eprint.setFullTextStatus(fullTextStatus);
		try {
			eprint = addEprint(eprint);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return eprint;
		
	}
}