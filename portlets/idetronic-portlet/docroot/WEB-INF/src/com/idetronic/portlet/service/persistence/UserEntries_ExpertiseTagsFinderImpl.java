package com.idetronic.portlet.service.persistence;

import java.util.List;

import com.idetronic.portlet.model.ExpertiseTag;
import com.idetronic.portlet.model.UserEntries_ExpertiseTags;
import com.idetronic.portlet.model.impl.ExpertiseTagImpl;
import com.idetronic.portlet.model.impl.UserEntries_ExpertiseTagsImpl;
import com.idetronic.portlet.service.impl.UserEntries_ExpertiseTagsLocalServiceImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;



public class UserEntries_ExpertiseTagsFinderImpl extends BasePersistenceImpl<UserEntries_ExpertiseTags> 
	implements UserEntries_ExpertiseTagsFinder
{
		private static Log _log = LogFactoryUtil.getLog(UserEntries_ExpertiseTagsFinderImpl.class);
		public static final String SQL_DETAIL_BY_USER =
				UserEntries_ExpertiseTagsFinderImpl.class.getName() + ".findDetailByUserId";
	public List getUserTags(long userId)
	{
		
		Session session = null;
		
		try
		{
			session = openSession();
			
			String sql =  CustomSQLUtil.get(SQL_DETAIL_BY_USER);
			
			SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("ExpertiseTag", ExpertiseTagImpl.class);
	        q.addEntity("UserEntries_ExpertiseTags", UserEntries_ExpertiseTagsImpl.class);
	        QueryPos qPos = QueryPos.getInstance(q);
	        qPos.add(userId);
	        
	        return (List) q.list();
		}catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}finally
		{
			closeSession(session);
		}
		
	}

}
