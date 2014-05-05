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

package com.idetronic.tazkirah.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TazkirahLocalService}.
 *
 * @author Mazlan Mat
 * @see TazkirahLocalService
 * @generated
 */
public class TazkirahLocalServiceWrapper implements TazkirahLocalService,
	ServiceWrapper<TazkirahLocalService> {
	public TazkirahLocalServiceWrapper(
		TazkirahLocalService tazkirahLocalService) {
		_tazkirahLocalService = tazkirahLocalService;
	}

	/**
	* Adds the tazkirah to the database. Also notifies the appropriate model listeners.
	*
	* @param tazkirah the tazkirah
	* @return the tazkirah that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.tazkirah.model.Tazkirah addTazkirah(
		com.idetronic.tazkirah.model.Tazkirah tazkirah)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tazkirahLocalService.addTazkirah(tazkirah);
	}

	/**
	* Creates a new tazkirah with the primary key. Does not add the tazkirah to the database.
	*
	* @param tazkirahId the primary key for the new tazkirah
	* @return the new tazkirah
	*/
	@Override
	public com.idetronic.tazkirah.model.Tazkirah createTazkirah(long tazkirahId) {
		return _tazkirahLocalService.createTazkirah(tazkirahId);
	}

	/**
	* Deletes the tazkirah with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tazkirahId the primary key of the tazkirah
	* @return the tazkirah that was removed
	* @throws PortalException if a tazkirah with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.tazkirah.model.Tazkirah deleteTazkirah(long tazkirahId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tazkirahLocalService.deleteTazkirah(tazkirahId);
	}

	/**
	* Deletes the tazkirah from the database. Also notifies the appropriate model listeners.
	*
	* @param tazkirah the tazkirah
	* @return the tazkirah that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.tazkirah.model.Tazkirah deleteTazkirah(
		com.idetronic.tazkirah.model.Tazkirah tazkirah)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tazkirahLocalService.deleteTazkirah(tazkirah);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tazkirahLocalService.dynamicQuery();
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
		return _tazkirahLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.tazkirah.model.impl.TazkirahModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tazkirahLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.tazkirah.model.impl.TazkirahModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tazkirahLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _tazkirahLocalService.dynamicQueryCount(dynamicQuery);
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
		return _tazkirahLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.idetronic.tazkirah.model.Tazkirah fetchTazkirah(long tazkirahId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tazkirahLocalService.fetchTazkirah(tazkirahId);
	}

	/**
	* Returns the tazkirah with the primary key.
	*
	* @param tazkirahId the primary key of the tazkirah
	* @return the tazkirah
	* @throws PortalException if a tazkirah with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.tazkirah.model.Tazkirah getTazkirah(long tazkirahId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tazkirahLocalService.getTazkirah(tazkirahId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tazkirahLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the tazkirahs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.tazkirah.model.impl.TazkirahModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tazkirahs
	* @param end the upper bound of the range of tazkirahs (not inclusive)
	* @return the range of tazkirahs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.tazkirah.model.Tazkirah> getTazkirahs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tazkirahLocalService.getTazkirahs(start, end);
	}

	/**
	* Returns the number of tazkirahs.
	*
	* @return the number of tazkirahs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTazkirahsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tazkirahLocalService.getTazkirahsCount();
	}

	/**
	* Updates the tazkirah in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tazkirah the tazkirah
	* @return the tazkirah that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.tazkirah.model.Tazkirah updateTazkirah(
		com.idetronic.tazkirah.model.Tazkirah tazkirah)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tazkirahLocalService.updateTazkirah(tazkirah);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tazkirahLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tazkirahLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tazkirahLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.idetronic.tazkirah.model.Tazkirah addEntry(
		java.lang.String title, java.lang.String content,
		java.lang.String category, long userId, java.lang.String userName,
		long companyId, long groupId) {
		return _tazkirahLocalService.addEntry(title, content, category, userId,
			userName, companyId, groupId);
	}

	@Override
	public com.idetronic.tazkirah.model.Tazkirah updateEntry(long tazkirahId,
		java.lang.String title, java.lang.String content,
		java.lang.String category, long userId, java.lang.String userName,
		long companyId, long groupId) {
		return _tazkirahLocalService.updateEntry(tazkirahId, title, content,
			category, userId, userName, companyId, groupId);
	}

	@Override
	public void deleteEntry(long tazkirahId) {
		_tazkirahLocalService.deleteEntry(tazkirahId);
	}

	@Override
	public java.util.List<com.idetronic.tazkirah.model.Tazkirah> listOrderByCategory(
		long companyId, long groupId) {
		return _tazkirahLocalService.listOrderByCategory(companyId, groupId);
	}

	@Override
	public java.util.List<com.idetronic.tazkirah.model.Tazkirah> getByCategory(
		java.lang.String category, long companyId, long groupId) {
		return _tazkirahLocalService.getByCategory(category, companyId, groupId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TazkirahLocalService getWrappedTazkirahLocalService() {
		return _tazkirahLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTazkirahLocalService(
		TazkirahLocalService tazkirahLocalService) {
		_tazkirahLocalService = tazkirahLocalService;
	}

	@Override
	public TazkirahLocalService getWrappedService() {
		return _tazkirahLocalService;
	}

	@Override
	public void setWrappedService(TazkirahLocalService tazkirahLocalService) {
		_tazkirahLocalService = tazkirahLocalService;
	}

	private TazkirahLocalService _tazkirahLocalService;
}