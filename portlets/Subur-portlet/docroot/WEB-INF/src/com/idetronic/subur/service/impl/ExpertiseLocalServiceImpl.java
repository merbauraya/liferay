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
import java.util.Date;
import java.util.List;

import com.idetronic.subur.ExpertiseException;
import com.idetronic.subur.NoSuchAuthorExpertiseException;
import com.idetronic.subur.NoSuchExpertiseException;
import com.idetronic.subur.model.AuthorExpertise;
import com.idetronic.subur.model.Expertise;
import com.idetronic.subur.service.base.ExpertiseLocalServiceBaseImpl;
import com.idetronic.subur.util.SuburAssetUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the expertise local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.service.ExpertiseLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.base.ExpertiseLocalServiceBaseImpl
 * @see com.idetronic.subur.service.ExpertiseLocalServiceUtil
 */
public class ExpertiseLocalServiceImpl extends ExpertiseLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.subur.service.ExpertiseLocalServiceUtil} to access the expertise local service.
	 */
	@Override
	public List<Expertise> checkExpertises(long userId,Group group,String[] names)
		throws SystemException,PortalException
	{
		List<Expertise> expertises = new ArrayList<Expertise>();
		
		for (String name: names)
		{
			Expertise expertise = null;
			try
			{
				expertise = getExpertise(group.getGroupId(),StringUtil.lowerCase(name));
				
			}catch (NoSuchExpertiseException nse)
			{
				ServiceContext serviceContext = new ServiceContext();

				serviceContext.setAddGroupPermissions(true);
				serviceContext.setAddGuestPermissions(true);
				serviceContext.setScopeGroupId(group.getGroupId());
				expertise = addExpertise(userId,name,serviceContext);
				
			}
			
			if (expertise != null)
				expertises.add(expertise);
			
		}
		return expertises;
	}
	@Override
	public Expertise addExpertise(long userId,String name,ServiceContext serviceContext) throws SystemException, PortalException
	{
		User user = userPersistence.findByPrimaryKey(userId);
		long groupId = serviceContext.getScopeGroupId();
		
		Date now = new Date();

		long expertiseId = counterLocalService.increment();
		Expertise expertise = expertisePersistence.create(expertiseId);
		
		expertise.setGroupId(groupId);
		expertise.setCompanyId(user.getCompanyId());
		expertise.setUserId(userId);;
		expertise.setCreateDate(now);
		expertise.setModifiedDate(now);
		
		name = StringUtil.trim(name);
		
		validate(name);

		expertise.setExpertiseName(name);
		expertise.setIndexedName(StringUtil.toLowerCase(name));
		expertisePersistence.update(expertise);
		
		
		return expertise;
		
		
		
	}
	@Override
	public Expertise getExpertise(long groupId,String name) throws NoSuchExpertiseException, SystemException
	{
		return expertisePersistence.findByGroupName(groupId, name);
	}
	
	public List<Expertise> findByGroupsName(long[] groupIds,String name,
			int start,int end,OrderByComparator obc) throws SystemException
	{
		return expertiseFinder.filterFindByG_N(groupIds, name, start, end, obc);
	}
	protected void validate(String name) throws PortalException {
		if (!SuburAssetUtil.isValidWord(name)) {
			throw new ExpertiseException(
				StringUtil.merge(
					SuburAssetUtil.INVALID_CHARACTERS, StringPool.SPACE),
					ExpertiseException.INVALID_CHARACTER);
		}
	}
	
	@Override
	public Expertise incrementAuthorCount(long expertiseId) throws SystemException
	{
		Expertise expertise;
		try {
			expertise = expertisePersistence.findByPrimaryKey(expertiseId);
			expertise.setAuthorCount(expertise.getAuthorCount() + 1);
			
			expertisePersistence.update(expertise);
			
			return expertise;
			
		} catch (NoSuchExpertiseException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}
	@Override
	public Expertise decrementAuthorCount(long expertiseId) throws SystemException
	{
		Expertise expertise;
		try {
			expertise = expertisePersistence.findByPrimaryKey(expertiseId);
			expertise.setAuthorCount(expertise.getAuthorCount() - 1);
			
			expertisePersistence.update(expertise);
			
			return expertise;
			
		} catch (NoSuchExpertiseException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}
}