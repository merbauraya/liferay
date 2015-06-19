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

package com.idetronic.subur.service.impl;

import java.io.PrintWriter;
import java.util.List;

import com.idetronic.subur.NoSuchSubjectTreeException;
import com.idetronic.subur.model.SubjectTree;
import com.idetronic.subur.service.base.SubjectTreeLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

/**
 * The implementation of the subject tree local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.service.SubjectTreeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.base.SubjectTreeLocalServiceBaseImpl
 * @see com.idetronic.subur.service.SubjectTreeLocalServiceUtil
 */
public class SubjectTreeLocalServiceImpl extends SubjectTreeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.subur.service.SubjectTreeLocalServiceUtil} to access the subject tree local service.
	 */
	public List<SubjectTree> getDepositable() throws SystemException
	{
		return subjectTreePersistence.findBydepositable(true);
	}
	public String getDepositableJson() throws SystemException
	{
		List<SubjectTree> subjects =   subjectTreePersistence.findBydepositable(true);
		JSONArray jResults = JSONFactoryUtil.createJSONArray();
		for (SubjectTree subject: subjects)
		{
			JSONObject jSubject = JSONFactoryUtil.createJSONObject();
			jSubject.put("key", subject.getPrimaryKey());
			jSubject.put("name", subject.getSubjectName());
			jResults.put(jSubject);
		}
		return jResults.toString();
		
		
		
	}
	public int getItemCount(long subjectId) throws NoSuchSubjectTreeException, SystemException
	{
		SubjectTree subject = subjectTreePersistence.findByPrimaryKey(subjectId);
		return subject.getItemCount();
	}
}