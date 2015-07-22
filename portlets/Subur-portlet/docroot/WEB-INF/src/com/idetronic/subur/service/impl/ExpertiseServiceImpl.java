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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.idetronic.subur.model.Expertise;
import com.idetronic.subur.service.ExpertiseLocalServiceUtil;
import com.idetronic.subur.service.base.ExpertiseServiceBaseImpl;
import com.idetronic.subur.util.comparator.ExpertiseNameComparator;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.util.Autocomplete;

/**
 * The implementation of the expertise remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.service.ExpertiseService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.base.ExpertiseServiceBaseImpl
 * @see com.idetronic.subur.service.ExpertiseServiceUtil
 */
public class ExpertiseServiceImpl extends ExpertiseServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.subur.service.ExpertiseServiceUtil} to access the expertise remote service.
	 */
	
	public List<Expertise> getGroupExpertises(long[] groupIds) throws SystemException
	{
		Set<Expertise> groupExpertises = new TreeSet<Expertise>(
				new ExpertiseNameComparator());
		
		for (long groupId : groupIds) {
			List<Expertise> groupExpertise = getGroupExpertises(groupId);

			groupExpertises.addAll(groupExpertise);
		}

		return new ArrayList<Expertise>(groupExpertises);
		
	}
	public List<Expertise> getGroupExpertises(long groupId) throws SystemException
	{
		return expertisePersistence.findByGroup(groupId);
	}
	@Override
	public JSONArray search(
			long[] groupIds, String name, int start,
			int end)
		throws SystemException {

		name = StringUtil.lowerCase(name);		
		List<Expertise> expertises = expertiseLocalService.findByGroupsName(groupIds, name, start, end, null);

		return Autocomplete.listToJson(expertises, "expertiseName", "expertiseName");
	}
	
	@Override
	public JSONArray search(
			long groupId, String name, int start, int end)
		throws SystemException {

		return search(new long[]{groupId},name,start,end);
	}
	
	

}