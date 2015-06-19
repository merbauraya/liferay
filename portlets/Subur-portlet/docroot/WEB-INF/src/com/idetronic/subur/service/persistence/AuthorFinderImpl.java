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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class AuthorFinderImpl extends BasePersistenceImpl<SuburItem> implements AuthorFinder {
	private static Log logger = LogFactoryUtil.getLog(AuthorFinderImpl.class);
	
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
