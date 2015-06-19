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

import com.idetronic.subur.model.ItemSubject;
import com.idetronic.subur.model.Subject;
import com.idetronic.subur.model.SubjectTree;
import com.idetronic.subur.service.ItemSubjectLocalServiceUtil;
import com.idetronic.subur.service.SubjectLocalServiceUtil;
import com.idetronic.subur.service.SubjectTreeLocalServiceUtil;
import com.idetronic.subur.service.base.ItemSubjectLocalServiceBaseImpl;
import com.idetronic.subur.service.persistence.ItemSubjectPK;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the item subject local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.service.ItemSubjectLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.base.ItemSubjectLocalServiceBaseImpl
 * @see com.idetronic.subur.service.ItemSubjectLocalServiceUtil
 */
public class ItemSubjectLocalServiceImpl extends ItemSubjectLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.subur.service.ItemSubjectLocalServiceUtil} to access the item subject local service.
	 */
	public void addItemSubject(long itemId,ArrayList<String> subjects) throws SystemException, NumberFormatException, PortalException
	{
		
		
		//remove existing subject association and update item count
		List<ItemSubject> itemSubjects = itemSubjectPersistence.findByitemId(itemId);
		
		for (ItemSubject itemSubject: itemSubjects)
		{
			Subject subject = SubjectLocalServiceUtil.getSubject(itemSubject.getSubjectId() );
			subject.setItemCount(subject.getItemCount()-1);
			if (subject.getItemCount() < 0)
				subject.setItemCount(0);
			SubjectLocalServiceUtil.updateSubject(subject);
		}
		itemSubjectPersistence.removeByitemId(itemId);
		
		
		
		
		for( int i = 0; i < subjects.size(); i++)
		{
			
			ItemSubjectPK itemSubjectPK = new ItemSubjectPK();
			itemSubjectPK.setItemId(itemId);
			long subjectId =Long.valueOf((String)subjects.get(i));
			
			itemSubjectPK.setSubjectId(subjectId);
			ItemSubject itemSubject = ItemSubjectLocalServiceUtil.createItemSubject(itemSubjectPK);
			itemSubjectPersistence.update(itemSubject);
			//update item count for subject
			Subject subject = SubjectLocalServiceUtil.getSubject(subjectId);
			if (Validator.isNull(subject.getItemCount()))
				subject.setItemCount(1);
			else
				subject.setItemCount(subject.getItemCount()+1);
			SubjectLocalServiceUtil.updateSubject(subject);
		}
		
		
	}
	public List<ItemSubject> getByItemId(long itemId) throws SystemException
	{
		//DynamicQuery dq0 = DynamicQueryFactoryUtil.forClass(ItemSubject.class, "itemSubject");
		//dq0.add(PropertyFactoryUtil.forName("itemSubject.subjectId").eqProperty("subject.subjectId"));
				
		
		return itemSubjectPersistence.findByitemId(itemId);
	}
	
}