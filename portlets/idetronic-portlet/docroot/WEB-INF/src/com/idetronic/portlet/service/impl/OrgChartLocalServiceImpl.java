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

import java.util.List;

import com.idetronic.portlet.model.OrgChart;
import com.idetronic.portlet.service.OrgChartLocalServiceUtil;
import com.idetronic.portlet.service.base.OrgChartLocalServiceBaseImpl;
import com.idetronic.portlet.service.persistence.OrgChartFinderUtil;
import com.idetronic.portlet.service.persistence.OrgChartPK;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the org chart local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.portlet.service.OrgChartLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.portlet.service.base.OrgChartLocalServiceBaseImpl
 * @see com.idetronic.portlet.service.OrgChartLocalServiceUtil
 */
public class OrgChartLocalServiceImpl extends OrgChartLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.portlet.service.OrgChartLocalServiceUtil} to access the org chart local service.
	 */
	public OrgChart addEntry(long userId,long parentId) throws SystemException
	{
		
		OrgChartPK orgChartPK = new OrgChartPK(userId,parentId);
		//find existing relationship and delete them
		List<OrgChart> usrList = orgChartPersistence.findByuserId(userId);
		for (OrgChart orgChart : usrList)
		{
			OrgChartLocalServiceUtil.deleteOrgChart(orgChart);
		}
		OrgChart entry = OrgChartLocalServiceUtil.createOrgChart(orgChartPK);
		OrgChartLocalServiceUtil.addOrgChart(entry);
		return null;
	}
	public void deleteByParentId(long parentId) throws SystemException
	{
		List<OrgChart> usrList = orgChartPersistence.findByparentId(parentId);
		for (OrgChart orgChart : usrList)
		{
			OrgChartLocalServiceUtil.deleteOrgChart(orgChart);
		}
	}
	public List getUserTree(long userId)
	{
		return OrgChartFinderUtil.getUserTree(userId);
	}
}