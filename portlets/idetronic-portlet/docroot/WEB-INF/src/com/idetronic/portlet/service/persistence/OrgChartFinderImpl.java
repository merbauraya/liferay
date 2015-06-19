package com.idetronic.portlet.service.persistence;

import java.util.ArrayList;
import java.util.List;

import com.idetronic.portlet.model.OrgChart;
import com.idetronic.portlet.model.impl.OrgChartImpl;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class OrgChartFinderImpl extends BasePersistenceImpl<OrgChart> implements OrgChartFinder {
	private static Log _log = LogFactoryUtil.getLog(OrgChartFinderImpl.class);
	public static final String SQL_USER_TREE =
			OrgChartFinderImpl.class.getName() + ".findUserTree";
	@Override
	public List getUserTree(long userId) {
		// TODO Auto-generated method stub
		List objectListUser=new ArrayList();
		List objectList=new ArrayList();
		List objectUserTree = new ArrayList();
		Session session = null;
		
		try
		{
			SessionFactory  sessionFactory = (SessionFactory)PortalBeanLocatorUtil.locate("liferaySessionFactory");
			
			session = sessionFactory.openSession();
			String sql =  CustomSQLUtil.get(SQL_USER_TREE);
			
			SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("User_",PortalClassLoaderUtil.getClassLoader().loadClass("com.liferay.portal.model.impl.UserImpl"));
		    
	        QueryPos qPos = QueryPos.getInstance(q);
	        qPos.add(userId);
	        qPos.add(userId);
	        qPos.add(userId);
	        objectListUser=(List)q.list();
	        objectList.add(objectListUser);
	        
	        session=openSession();
	        q = session.createSQLQuery(sql);
	        q.addEntity("OrgChart", OrgChartImpl.class);
	        
	        qPos = QueryPos.getInstance(q);
	        qPos.add(userId);
	        qPos.add(userId);
	        qPos.add(userId);
	        objectUserTree = (List)q.list();
	        objectList.add(objectUserTree);
	        
	        //q.addEntity("User_",PortalClassLoaderUtil.getClassLoader().loadClass("com.liferay.portal.model.impl.UserImpl"));
	        
	       // QueryPos qPos = QueryPos.getInstance(q);
	        
	        return objectList;
	        //return (List) q.list();
		}catch (Exception e)
		{
			_log.error(e);
		}finally
		{
			closeSession(session);
		}
		
		
		return null;
		
		
	}

}
