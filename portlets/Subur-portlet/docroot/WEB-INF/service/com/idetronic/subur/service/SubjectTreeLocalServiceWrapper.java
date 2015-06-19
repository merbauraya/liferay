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

package com.idetronic.subur.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SubjectTreeLocalService}.
 *
 * @author Mazlan Mat
 * @see SubjectTreeLocalService
 * @generated
 */
public class SubjectTreeLocalServiceWrapper implements SubjectTreeLocalService,
	ServiceWrapper<SubjectTreeLocalService> {
	public SubjectTreeLocalServiceWrapper(
		SubjectTreeLocalService subjectTreeLocalService) {
		_subjectTreeLocalService = subjectTreeLocalService;
	}

	/**
	* Adds the subject tree to the database. Also notifies the appropriate model listeners.
	*
	* @param subjectTree the subject tree
	* @return the subject tree that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.SubjectTree addSubjectTree(
		com.idetronic.subur.model.SubjectTree subjectTree)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectTreeLocalService.addSubjectTree(subjectTree);
	}

	/**
	* Creates a new subject tree with the primary key. Does not add the subject tree to the database.
	*
	* @param subjectId the primary key for the new subject tree
	* @return the new subject tree
	*/
	@Override
	public com.idetronic.subur.model.SubjectTree createSubjectTree(
		long subjectId) {
		return _subjectTreeLocalService.createSubjectTree(subjectId);
	}

	/**
	* Deletes the subject tree with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param subjectId the primary key of the subject tree
	* @return the subject tree that was removed
	* @throws PortalException if a subject tree with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.SubjectTree deleteSubjectTree(
		long subjectId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _subjectTreeLocalService.deleteSubjectTree(subjectId);
	}

	/**
	* Deletes the subject tree from the database. Also notifies the appropriate model listeners.
	*
	* @param subjectTree the subject tree
	* @return the subject tree that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.SubjectTree deleteSubjectTree(
		com.idetronic.subur.model.SubjectTree subjectTree)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectTreeLocalService.deleteSubjectTree(subjectTree);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _subjectTreeLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectTreeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SubjectTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectTreeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SubjectTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectTreeLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectTreeLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectTreeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.subur.model.SubjectTree fetchSubjectTree(
		long subjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectTreeLocalService.fetchSubjectTree(subjectId);
	}

	/**
	* Returns the subject tree with the primary key.
	*
	* @param subjectId the primary key of the subject tree
	* @return the subject tree
	* @throws PortalException if a subject tree with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.SubjectTree getSubjectTree(long subjectId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _subjectTreeLocalService.getSubjectTree(subjectId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _subjectTreeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the subject trees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SubjectTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subject trees
	* @param end the upper bound of the range of subject trees (not inclusive)
	* @return the range of subject trees
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.subur.model.SubjectTree> getSubjectTrees(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectTreeLocalService.getSubjectTrees(start, end);
	}

	/**
	* Returns the number of subject trees.
	*
	* @return the number of subject trees
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSubjectTreesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectTreeLocalService.getSubjectTreesCount();
	}

	/**
	* Updates the subject tree in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param subjectTree the subject tree
	* @return the subject tree that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.SubjectTree updateSubjectTree(
		com.idetronic.subur.model.SubjectTree subjectTree)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectTreeLocalService.updateSubjectTree(subjectTree);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _subjectTreeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_subjectTreeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _subjectTreeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.idetronic.subur.model.SubjectTree> getDepositable()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectTreeLocalService.getDepositable();
	}

	@Override
	public java.lang.String getDepositableJson()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectTreeLocalService.getDepositableJson();
	}

	@Override
	public int getItemCount(long subjectId)
		throws com.idetronic.subur.NoSuchSubjectTreeException,
			com.liferay.portal.kernel.exception.SystemException {
		return _subjectTreeLocalService.getItemCount(subjectId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SubjectTreeLocalService getWrappedSubjectTreeLocalService() {
		return _subjectTreeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSubjectTreeLocalService(
		SubjectTreeLocalService subjectTreeLocalService) {
		_subjectTreeLocalService = subjectTreeLocalService;
	}

	@Override
	public SubjectTreeLocalService getWrappedService() {
		return _subjectTreeLocalService;
	}

	@Override
	public void setWrappedService(
		SubjectTreeLocalService subjectTreeLocalService) {
		_subjectTreeLocalService = subjectTreeLocalService;
	}

	private SubjectTreeLocalService _subjectTreeLocalService;
}