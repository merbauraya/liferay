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
 * Provides a wrapper for {@link StatViewTagLocalService}.
 *
 * @author Mazlan Mat
 * @see StatViewTagLocalService
 * @generated
 */
public class StatViewTagLocalServiceWrapper implements StatViewTagLocalService,
	ServiceWrapper<StatViewTagLocalService> {
	public StatViewTagLocalServiceWrapper(
		StatViewTagLocalService statViewTagLocalService) {
		_statViewTagLocalService = statViewTagLocalService;
	}

	/**
	* Adds the stat view tag to the database. Also notifies the appropriate model listeners.
	*
	* @param statViewTag the stat view tag
	* @return the stat view tag that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.StatViewTag addStatViewTag(
		com.idetronic.subur.model.StatViewTag statViewTag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statViewTagLocalService.addStatViewTag(statViewTag);
	}

	/**
	* Creates a new stat view tag with the primary key. Does not add the stat view tag to the database.
	*
	* @param id the primary key for the new stat view tag
	* @return the new stat view tag
	*/
	@Override
	public com.idetronic.subur.model.StatViewTag createStatViewTag(long id) {
		return _statViewTagLocalService.createStatViewTag(id);
	}

	/**
	* Deletes the stat view tag with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the stat view tag
	* @return the stat view tag that was removed
	* @throws PortalException if a stat view tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.StatViewTag deleteStatViewTag(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _statViewTagLocalService.deleteStatViewTag(id);
	}

	/**
	* Deletes the stat view tag from the database. Also notifies the appropriate model listeners.
	*
	* @param statViewTag the stat view tag
	* @return the stat view tag that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.StatViewTag deleteStatViewTag(
		com.idetronic.subur.model.StatViewTag statViewTag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statViewTagLocalService.deleteStatViewTag(statViewTag);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _statViewTagLocalService.dynamicQuery();
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
		return _statViewTagLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _statViewTagLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _statViewTagLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _statViewTagLocalService.dynamicQueryCount(dynamicQuery);
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
		return _statViewTagLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.subur.model.StatViewTag fetchStatViewTag(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statViewTagLocalService.fetchStatViewTag(id);
	}

	/**
	* Returns the stat view tag with the primary key.
	*
	* @param id the primary key of the stat view tag
	* @return the stat view tag
	* @throws PortalException if a stat view tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.StatViewTag getStatViewTag(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _statViewTagLocalService.getStatViewTag(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _statViewTagLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the stat view tags.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stat view tags
	* @param end the upper bound of the range of stat view tags (not inclusive)
	* @return the range of stat view tags
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.subur.model.StatViewTag> getStatViewTags(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statViewTagLocalService.getStatViewTags(start, end);
	}

	/**
	* Returns the number of stat view tags.
	*
	* @return the number of stat view tags
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getStatViewTagsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statViewTagLocalService.getStatViewTagsCount();
	}

	/**
	* Updates the stat view tag in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param statViewTag the stat view tag
	* @return the stat view tag that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.StatViewTag updateStatViewTag(
		com.idetronic.subur.model.StatViewTag statViewTag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statViewTagLocalService.updateStatViewTag(statViewTag);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _statViewTagLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_statViewTagLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _statViewTagLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public StatViewTagLocalService getWrappedStatViewTagLocalService() {
		return _statViewTagLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedStatViewTagLocalService(
		StatViewTagLocalService statViewTagLocalService) {
		_statViewTagLocalService = statViewTagLocalService;
	}

	@Override
	public StatViewTagLocalService getWrappedService() {
		return _statViewTagLocalService;
	}

	@Override
	public void setWrappedService(
		StatViewTagLocalService statViewTagLocalService) {
		_statViewTagLocalService = statViewTagLocalService;
	}

	private StatViewTagLocalService _statViewTagLocalService;
}