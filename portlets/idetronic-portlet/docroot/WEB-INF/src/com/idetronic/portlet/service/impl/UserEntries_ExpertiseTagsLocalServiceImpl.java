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

package com.idetronic.portlet.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.idetronic.portlet.model.ExpertiseTag;
import com.idetronic.portlet.model.UserEntries_ExpertiseTags;
import com.idetronic.portlet.service.ExpertiseTagLocalServiceUtil;
import com.idetronic.portlet.service.UserEntries_ExpertiseTagsLocalServiceUtil;
import com.idetronic.portlet.service.base.UserEntries_ExpertiseTagsLocalServiceBaseImpl;
import com.idetronic.portlet.service.persistence.UserEntries_ExpertiseTagsFinderUtil;
import com.idetronic.portlet.service.persistence.UserEntries_ExpertiseTagsPK;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the user entries_ expertise tags local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.portlet.service.UserEntries_ExpertiseTagsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.portlet.service.base.UserEntries_ExpertiseTagsLocalServiceBaseImpl
 * @see com.idetronic.portlet.service.UserEntries_ExpertiseTagsLocalServiceUtil
 */
public class UserEntries_ExpertiseTagsLocalServiceImpl
	extends UserEntries_ExpertiseTagsLocalServiceBaseImpl {
	
	private static Log _log = LogFactoryUtil.getLog(UserEntries_ExpertiseTagsLocalServiceImpl.class);
	public void addEntry(long userId,String[] tags) throws PortalException, SystemException
	{
		ExpertiseTagLocalServiceUtil.addExpertiseTag(tags, userId);
		
		List<ExpertiseTag> expertiseTags = ExpertiseTagLocalServiceUtil.findByTagName(tags);
		
		List<UserEntries_ExpertiseTags> userEntries = userEntries_ExpertiseTagsPersistence.findByuserId(userId);
		
		
		Set<Long> tagEntries = new HashSet<Long>();
		
		for (UserEntries_ExpertiseTags userEntry : userEntries)
		{
			tagEntries.add(userEntry.getTagId());
		}
		
		//create if tag does not exist for user
		for(ExpertiseTag tagEntry: expertiseTags)
		{
			
			if (!tagEntries.contains(tagEntry.getTagId()) || tagEntries.size() ==0)
			{
				_log.info("addEntry::"+ tagEntry.getTagId()+ " uid="+userId);
				UserEntries_ExpertiseTagsPK ueExp = new UserEntries_ExpertiseTagsPK(userId,tagEntry.getTagId());
				tagEntry.setUserCount(tagEntry.getUserCount()+1);
				
				ExpertiseTagLocalServiceUtil.updateExpertiseTag(tagEntry);
				//userEntries_ExpertiseTagsPersistence.create(ueExp);
				//UserEntries_ExpertiseTags umm = new UserEntries_ExpertiseTags();
				UserEntries_ExpertiseTags entry = UserEntries_ExpertiseTagsLocalServiceUtil.createUserEntries_ExpertiseTags(ueExp);
				UserEntries_ExpertiseTagsLocalServiceUtil.addUserEntries_ExpertiseTags(entry);
				
			}
		}
		//delete if user no longer attached to the tag
		tagEntries.clear();
		for (ExpertiseTag _eTag : expertiseTags)
		{
			tagEntries.add(_eTag.getTagId());
			
		}
		
		for (UserEntries_ExpertiseTags currentEntry: userEntries)
		{
			if (!tagEntries.contains(currentEntry.getTagId()))
			{
				
				ExpertiseTag tagDetach = ExpertiseTagLocalServiceUtil.getExpertiseTag(currentEntry.getTagId());
				
				int newUserCount = tagDetach.getUserCount() == 0 ? 0 : tagDetach.getUserCount()-1;
				tagDetach.setUserCount(newUserCount);
				ExpertiseTagLocalServiceUtil.updateExpertiseTag(tagDetach);
				
				UserEntries_ExpertiseTagsPK ueExp = new UserEntries_ExpertiseTagsPK();
				ueExp.setUserId(userId);
				ueExp.setTagId(currentEntry.getTagId());
				UserEntries_ExpertiseTagsLocalServiceUtil.deleteUserEntries_ExpertiseTags(ueExp);
				
			}
		}
		
	}
	public void addEntry(long userId,String tags,String delimeter) throws SystemException, PortalException
	{
		String[] arr = tags.split(delimeter);
		addEntry(userId,arr);
	}
	
	public List getUserEntry(long userId)
	{
		return UserEntries_ExpertiseTagsFinderUtil.getUserTags(userId);
	}
}