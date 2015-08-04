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
 * Provides a wrapper for {@link AuthorLocalService}.
 *
 * @author Mazlan Mat
 * @see AuthorLocalService
 * @generated
 */
public class AuthorLocalServiceWrapper implements AuthorLocalService,
	ServiceWrapper<AuthorLocalService> {
	public AuthorLocalServiceWrapper(AuthorLocalService authorLocalService) {
		_authorLocalService = authorLocalService;
	}

	/**
	* Adds the author to the database. Also notifies the appropriate model listeners.
	*
	* @param author the author
	* @return the author that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.Author addAuthor(
		com.idetronic.subur.model.Author author)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _authorLocalService.addAuthor(author);
	}

	/**
	* Creates a new author with the primary key. Does not add the author to the database.
	*
	* @param authorId the primary key for the new author
	* @return the new author
	*/
	@Override
	public com.idetronic.subur.model.Author createAuthor(long authorId) {
		return _authorLocalService.createAuthor(authorId);
	}

	/**
	* Deletes the author with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param authorId the primary key of the author
	* @return the author that was removed
	* @throws PortalException if a author with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.Author deleteAuthor(long authorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _authorLocalService.deleteAuthor(authorId);
	}

	/**
	* Deletes the author from the database. Also notifies the appropriate model listeners.
	*
	* @param author the author
	* @return the author that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.Author deleteAuthor(
		com.idetronic.subur.model.Author author)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _authorLocalService.deleteAuthor(author);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _authorLocalService.dynamicQuery();
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
		return _authorLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _authorLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _authorLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _authorLocalService.dynamicQueryCount(dynamicQuery);
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
		return _authorLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.idetronic.subur.model.Author fetchAuthor(long authorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _authorLocalService.fetchAuthor(authorId);
	}

	/**
	* Returns the author with the primary key.
	*
	* @param authorId the primary key of the author
	* @return the author
	* @throws PortalException if a author with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.Author getAuthor(long authorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _authorLocalService.getAuthor(authorId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _authorLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the authors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @return the range of authors
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.subur.model.Author> getAuthors(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _authorLocalService.getAuthors(start, end);
	}

	/**
	* Returns the number of authors.
	*
	* @return the number of authors
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAuthorsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _authorLocalService.getAuthorsCount();
	}

	/**
	* Updates the author in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param author the author
	* @return the author that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.Author updateAuthor(
		com.idetronic.subur.model.Author author)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _authorLocalService.updateAuthor(author);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _authorLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_authorLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _authorLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public long addAuthor(java.lang.String firstName,
		java.lang.String lastName, java.lang.String title,
		java.util.Map<java.lang.String, java.lang.String> authorSite,
		java.lang.String remoteId, int idType, long userId, long groupId,
		long createdByUserId, java.lang.String[] expertiseNames,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _authorLocalService.addAuthor(firstName, lastName, title,
			authorSite, remoteId, idType, userId, groupId, createdByUserId,
			expertiseNames, serviceContext);
	}

	@Override
	public void setExpertises(long authorId,
		java.util.List<com.idetronic.subur.model.Expertise> expertises)
		throws com.liferay.portal.kernel.exception.SystemException {
		_authorLocalService.setExpertises(authorId, expertises);
	}

	/**
	* Update existing author, throw Exception if author not found or update fails
	*
	* @param authorId
	* @param firstName
	* @param lastName
	* @param remoteId
	* @param idType
	* @param userId
	* @param groupId
	* @return
	* @throws SystemException
	* @throws PortalException
	*/
	@Override
	public com.idetronic.subur.model.Author updateAuthor(long authorId,
		java.lang.String title, java.lang.String firstName,
		java.lang.String lastName,
		java.util.Map<java.lang.String, java.lang.String> authorSite,
		java.lang.String remoteId, int idType, long userId, long groupId,
		long createdByUserId, java.lang.String[] expertiseNames,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _authorLocalService.updateAuthor(authorId, title, firstName,
			lastName, authorSite, remoteId, idType, userId, groupId,
			createdByUserId, expertiseNames, serviceContext);
	}

	/**
	* Find all item under a given author
	*
	* @param groupId
	* @param authorId
	* @param start
	* @param end
	* @param status Item status
	* @param obc
	* @return
	* @throws SystemException
	*/
	@Override
	public java.util.List<com.idetronic.subur.model.SuburItem> getItemByAuthorGroup(
		long groupId, long authorId, int start, int end, int status,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _authorLocalService.getItemByAuthorGroup(groupId, authorId,
			start, end, status, obc);
	}

	/**
	* Find and return all associated expertise for the author
	*
	* @param authorId to seearch for
	* @return List of Expertise
	* @throws SystemException
	*/
	@Override
	public java.util.List<com.idetronic.subur.model.Expertise> getExpertises(
		long authorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _authorLocalService.getExpertises(authorId);
	}

	/**
	* Update author latest posting
	*
	* @param suburItem
	* @throws SystemException
	*/
	@Override
	public void updateAuthorPosting(
		com.idetronic.subur.model.SuburItem suburItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		_authorLocalService.updateAuthorPosting(suburItem);
	}

	/**
	* Increment item count and last posted date for an author
	* Usually called during new item creation
	*
	* @param authorId
	* @return new item count for the author
	* @throws SystemException if author cannot be found or fail during update
	*/
	@Override
	public int updateNewPosting(long authorId, java.util.Date newPostDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _authorLocalService.updateNewPosting(authorId, newPostDate);
	}

	/**
	* Return all authors with the primary keys
	*
	* @param authorIds the primary key of the author
	* @return authors with primary key
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public java.util.List<com.idetronic.subur.model.Author> getAuthors(
		long[] authorIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _authorLocalService.getAuthors(authorIds);
	}

	/**
	* Update all author with up to date item count
	*
	* @param companyId
	* @param groupId
	*/
	@Override
	public void updateAllItemCount(long companyId, long groupId) {
		_authorLocalService.updateAllItemCount(companyId, groupId);
	}

	/**
	* Decrement item count for the author
	*/
	@Override
	public void decrementItemCount(long authorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_authorLocalService.decrementItemCount(authorId);
	}

	@Override
	public int getSearchCount(java.lang.String keyword, long companyId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _authorLocalService.getSearchCount(keyword, companyId, groupId);
	}

	@Override
	public int getSearchCount(java.lang.String keyword, long companyId,
		long groupId, java.lang.String firstName, java.lang.String lastName,
		boolean isAdvancedSearch, boolean isAndOperator, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return _authorLocalService.getSearchCount(keyword, companyId, groupId,
			firstName, lastName, isAdvancedSearch, isAndOperator, start, end,
			obc);
	}

	@Override
	public java.util.List<com.idetronic.subur.model.SuburItem> getSuburItems(
		long authorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return _authorLocalService.getSuburItems(authorId, start, end, obc);
	}

	@Override
	public java.util.List<com.idetronic.subur.model.Author> search(
		java.lang.String keyword, long companyId, long groupId,
		java.lang.String firstName, java.lang.String lastName,
		boolean isAdvancedSearch, boolean isAndOperator, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _authorLocalService.search(keyword, companyId, groupId,
			firstName, lastName, isAdvancedSearch, isAndOperator, start, end,
			obc);
	}

	@Override
	public java.util.List<com.idetronic.subur.model.Author> search(
		java.lang.String keyword, long companyId, long groupId, int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _authorLocalService.search(keyword, companyId, groupId, start,
			end, obc);
	}

	@Override
	public java.util.List<com.idetronic.subur.model.Author> findByGroupCompany(
		long companyId, long groupId, int start, int end) {
		return _authorLocalService.findByGroupCompany(companyId, groupId,
			start, end);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AuthorLocalService getWrappedAuthorLocalService() {
		return _authorLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAuthorLocalService(
		AuthorLocalService authorLocalService) {
		_authorLocalService = authorLocalService;
	}

	@Override
	public AuthorLocalService getWrappedService() {
		return _authorLocalService;
	}

	@Override
	public void setWrappedService(AuthorLocalService authorLocalService) {
		_authorLocalService = authorLocalService;
	}

	private AuthorLocalService _authorLocalService;
}