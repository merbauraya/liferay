package com.idetronic.subur.service.persistence;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.idetronic.subur.model.Author;
import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.model.impl.AuthorImpl;
import com.idetronic.subur.util.SuburConstant;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class AuthorFinderImpl extends BasePersistenceImpl<SuburItem> implements AuthorFinder {
	private static Log logger = LogFactoryUtil.getLog(AuthorFinderImpl.class);
	
	public int getTotalByName(String keyword,long companyId, long groupId) throws SystemException
	{
		Session session = null;
		
		try
		{
			session = openSession();//sessionFactory.openSession();
			String sql =  CustomSQLUtil.get(SuburConstant.SQL_AUTHOR_COUNT_BY_NAME);
			
			String[] searchFor = CustomSQLUtil.keywords(keyword, true);
			keyword = StringUtil.toLowerCase(keyword);
			keyword = StringPool.PERCENT.concat(keyword).concat(StringPool.PERCENT);
			
						
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addScalar("total", com.liferay.portal.kernel.dao.orm.Type.LONG);
			
	        
	        
		    
	        QueryPos qPos = QueryPos.getInstance(query);
	        
	        
	        qPos.add(searchFor);//,1);
	        qPos.add(searchFor);//,1);
	        qPos.add(companyId);
	        qPos.add(groupId);
	        
	        Long total = (Long)query.uniqueResult();
	        return total.intValue();
	        
	       
	        
			
		}catch (Exception e)
		{
			throw new SystemException(e.getMessage(), e);
		}finally
		{
			closeSession(session);
		}
	}
	/**
	 * Search author by First Name and/or Last name
	 * 
	 * @param companyId
	 * @param groupId
	 * @param firstName
	 * @param lastName
	 * @param matchAll if true, AND operator is used in SQL,otherwise OR is used
	 * @param start
	 * @param end
	 * @param obc
	 * @return
	 * @throws SystemException 
	 */
	public List<Author> findByFistNameLastName(long companyId,long groupId,
			String firstName,String lastName,boolean matchAll,
			int start, int end, OrderByComparator obc) throws SystemException
	{
		String sql;
		Session session = null;
		if (Validator.isNull(firstName))
			firstName = StringPool.BLANK;
		if (Validator.isNull(lastName))
			lastName = StringPool.BLANK;
		firstName = StringPool.PERCENT.concat(firstName).concat(StringPool.PERCENT);
		lastName = StringPool.PERCENT.concat(lastName).concat(StringPool.PERCENT);
		
		if (matchAll)
			sql =  CustomSQLUtil.get(SuburConstant.SQL_AUTHOR_FIND_BY_NAME_AND);
		else
			sql =  CustomSQLUtil.get(SuburConstant.SQL_AUTHOR_FIND_BY_NAME);
		try {
			session = openSession();
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
	        
	        q.addEntity("Subur_Author",AuthorImpl.class);
	        QueryPos qPos = QueryPos.getInstance(q);
	        qPos.add(StringUtil.toLowerCase(firstName));
	        qPos.add(StringUtil.toLowerCase(lastName));
	        qPos.add(companyId);
	        qPos.add(groupId);
	        return (List<Author>)QueryUtil.list(q, getDialect(), start, end);
		}catch (Exception e)
		{
			throw new SystemException(e.getMessage(), e);
		}finally
		{
			closeSession(session);
		}
		
		
		
	}
	
	
	/**
	 * Find by first name or last name using same keyword
	 * e.g. sql (firstname = keyword) or (lastname = keyword)
	 */
	public List<Author> findByName(String keyword,
			long companyId,long groupId,
			int start, int end, OrderByComparator obc) 
			throws SystemException
	{
		Session session = null;
		
		try
		{
			session = openSession();//sessionFactory.openSession();
			String sql =  CustomSQLUtil.get(SuburConstant.SQL_AUTHOR_FIND_BY_NAME);
			
			String[] searchFor = CustomSQLUtil.keywords(keyword, true);
			keyword = StringUtil.toLowerCase(keyword);
			keyword = StringPool.PERCENT.concat(keyword).concat(StringPool.PERCENT);
			
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
	        
	        q.addEntity("Subur_Author",AuthorImpl.class);
		    
	        QueryPos qPos = QueryPos.getInstance(q);
	        logger.info(q.toString());
	        qPos.add(searchFor);
	        qPos.add(searchFor);
	        qPos.add(companyId);
	        qPos.add(groupId);
	
	        
	        return (List<Author>)QueryUtil.list(q, getDialect(), start, end);
			
		}catch (Exception e)
		{
			throw new SystemException(e.getMessage(), e);
		}finally
		{
			closeSession(session);
		}
	}
	/**
	 * return count search for Fist name and last name
	 * @param companyId
	 * @param groupId
	 * @param firstName
	 * @param lastName
	 * @param matchAll if true, AND operator is used, otherwise OR is used
	 * @param start
	 * @param end
	 * @param obc
	 * @return
	 * @throws SystemException
	 */
	public int countByFistNameLastName(long companyId,long groupId,
			String firstName,String lastName,boolean isAndOperator,
			int start, int end, OrderByComparator obc) throws SystemException
	{
		int count;
		String sql;
		Session session = null;
		if (Validator.isNull(firstName))
			firstName = StringPool.BLANK;
		if (Validator.isNull(lastName))
			lastName = StringPool.BLANK;
		
		firstName = StringPool.PERCENT.concat(firstName).concat(StringPool.PERCENT);
		lastName = StringPool.PERCENT.concat(lastName).concat(StringPool.PERCENT);
		
		if (isAndOperator)
			sql =  CustomSQLUtil.get(SuburConstant.SQL_AUTHOR_COUNT_BY_NAME_AND);
		else
			sql =  CustomSQLUtil.get(SuburConstant.SQL_AUTHOR_COUNT_BY_NAME);
		
		
		try {
			session = openSession();
			SQLQuery q = session.createSQLQuery(sql);
	        
			q.addScalar("total", com.liferay.portal.kernel.dao.orm.Type.LONG);
			
	        QueryPos qPos = QueryPos.getInstance(q);
	        qPos.add(StringUtil.toLowerCase(firstName));
	        qPos.add(StringUtil.toLowerCase(lastName));
	        qPos.add(companyId);
	        qPos.add(groupId);
	        
	        Long total = (Long)q.uniqueResult();
	        return total.intValue();
	        
	        
		}catch (Exception e)
		{
			throw new SystemException(e.getMessage(), e);
		}finally
		{
			closeSession(session);
		}
		
		
		
	}
	public List<Author> findByFirstName(String[] keyword,
			LinkedHashMap<String, Object> params,
			int start,int end,OrderByComparator obc) throws SystemException
	{
		
		Session session = null;
		
		keyword = CustomSQLUtil.keywords(keyword, true);
		
		//SessionFactory  sessionFactory = (SessionFactory)PortalBeanLocatorUtil.locate("liferaySessionFactory");
		
		try
		{
			
			logger.info(obc);
			
			session = openSession();//sessionFactory.openSession();
			String sql =  CustomSQLUtil.get(SuburConstant.SQL_AUTHOR_BY_FIRST_NAME);
			
			
			sql = CustomSQLUtil.replaceKeywords(
						sql, "lower(Subur_Author.firstName)",StringPool.LIKE,false, keyword);
			logger.info(sql);
			
			sql = CustomSQLUtil.replaceAndOperator(sql, false);

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			sql = StringUtil.replace(sql, "[$WHERE$]", getWhere(params));
			
			SQLQuery q = session.createSQLQuery(sql);
	        
	        q.addEntity("Subur_Author",AuthorImpl.class);
		    
	        QueryPos qPos = QueryPos.getInstance(q);
	        
	        qPos.add(keyword,1);
	        
	        logger.info(sql);
	        
	        return (List<Author>)QueryUtil.list(q, getDialect(), start, end);
	        
	        
		}catch (Exception e)
		{
			throw new SystemException(e.getMessage(), e);
		}finally
		{
			closeSession(session);
		}
		
		
		
		
	}
	/**
	 * 
	 * @param companyId
	 * @param groupId
	 * @return
	 */
	public List getItemCountByGroupCompanyScalar(long companyId,long groupId)
	{
		Session session = null;
		try
		{
			session = openSession();
			String sql = CustomSQLUtil.get(SuburConstant.SQL_AUTHOR_ITEM_COUNT_BY_G_C);
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addScalar("authorId", Type.LONG);
			queryObject.addScalar("itemCount", Type.INTEGER);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			
			qPos.add(companyId);
			qPos.add(groupId);
			
			return (List)queryObject.list();
		} catch (Exception e)
		{
			logger.error(e);
		} finally
		{
			closeSession(session);
		}
		return null;
	}
	/**
	 * Find authors for group and company
	 * @param companyId
	 * @param groupId
	 * @param start
	 * @param end
	 * @return list of authors
	 */
	public List<Author> findByCompanyGroup(long companyId,long groupId,int start,int end)
	{
		Session session = null;
		try
		{
			session = openSession();
			String sql = CustomSQLUtil.get(SuburConstant.SQL_AUTHOR_FIND_BY_G_C);
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			
			query.addEntity("Subur_Author",AuthorImpl.class);
			
			
			QueryPos qPos = QueryPos.getInstance(query);
			
			qPos.add(companyId);
			qPos.add(groupId);
			
			return (List<Author>)QueryUtil.list(query, getDialect(), start, end);
		} catch (Exception e)
		{
			logger.error(e);
		} finally
		{
			closeSession(session);
		}
		return null;
		
	}
	protected String getWhere(LinkedHashMap<String, Object> params) {
		if ((params == null) || params.isEmpty()) {
			return StringPool.BLANK;
		}

		StringBundler sb = new StringBundler(params.size());

		for (Map.Entry<String, Object> entry : params.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			if (Validator.isNotNull(value)) {
				sb.append(getWhere(key));
			}
		}

		return sb.toString();
	}
	protected String getWhere(String key) {
		String join = StringPool.BLANK;

		//if (key.equals("usersRoles")) {
		//	join = CustomSQLUtil.get(JOIN_BY_USERS_ROLES);
		//}

		if (Validator.isNotNull(join)) {
			int pos = join.indexOf("WHERE");

			if (pos != -1) {
				join = join.substring(pos + 5, join.length()).concat(" AND ");
			}
			else {
				join = StringPool.BLANK;
			}
		}

		return join;
	}

}
