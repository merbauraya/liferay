package com.idetronic.subur.service.persistence;


import java.util.ArrayList;
import java.util.List;

import com.idetronic.subur.Subur;
import com.idetronic.subur.service.persistence.MetadataPropertyValueFinder;
import com.idetronic.subur.util.SuburConstant;
import com.idetronic.subur.model.MetadataPropertyValue;
import com.idetronic.subur.model.impl.MetadataPropertyImpl;
import com.idetronic.subur.model.impl.MetadataPropertyValueImpl;
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

public class MetadataPropertyValueFinderImpl extends BasePersistenceImpl<MetadataPropertyValue> 
	implements MetadataPropertyValueFinder 
{
	private static Log logger = LogFactoryUtil.getLog(MetadataPropertyValueFinderImpl.class);
	public List getAuthor(long itemId)
	{
		List objectListUser=new ArrayList();
		List objectList=new ArrayList();
		List objectUserTree = new ArrayList();
		Session session = null;
		
		try
		{
			//SessionFactory  sessionFactory = (SessionFactory)PortalBeanLocatorUtil.locate("liferaySessionFactory");
			
			session = openSession();//sessionFactory.openSession();
			String sql =  CustomSQLUtil.get(SuburConstant.SQL_ITEM_AUTHOR);
			
			SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("MetadataProperty_",MetadataPropertyImpl.class);
		    
	        QueryPos qPos = QueryPos.getInstance(q);
	        qPos.add(itemId);
	       
	        objectListUser=(List)q.list();
	        objectList.add(objectListUser);
	        
	        session=openSession();
	        q = session.createSQLQuery(sql);
	        q.addEntity("MetadataPropertyValue", MetadataPropertyValueImpl.class);
	        
	        qPos = QueryPos.getInstance(q);
	        qPos.add(itemId);
	        objectUserTree = (List)q.list();
	        objectList.add(objectUserTree);
	        
	        logger.info("author size="+ objectList.size() + "::"+sql);
	        
	        return objectList;
	        //return (List) q.list();
		}catch (Exception e)
		{
			logger.error(e);
		}finally
		{
			closeSession(session);
		}
		
		
		return null;
	}
	public List getAdditionalMetadata(long itemId)
	{
		List objectListUser=new ArrayList();
		List objectList=new ArrayList();
		List objectUserTree = new ArrayList();
		Session session = null;
		
		try
		{
			//SessionFactory  sessionFactory = (SessionFactory)PortalBeanLocatorUtil.locate("liferaySessionFactory");
			
			session = openSession();//sessionFactory.openSession();
			String sql =  CustomSQLUtil.get(SuburConstant.SQL_ITEM_ADDITIONAL_METADATA);
			
			SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("MetadataProperty_",MetadataPropertyImpl.class);
		    
	        QueryPos qPos = QueryPos.getInstance(q);
	        qPos.add(itemId);
	       
	        objectListUser=(List)q.list();
	        objectList.add(objectListUser);
	        
	        session=openSession();
	        q = session.createSQLQuery(sql);
	        q.addEntity("MetadataPropertyValue", MetadataPropertyValueImpl.class);
	        
	        qPos = QueryPos.getInstance(q);
	        qPos.add(itemId);
	        objectUserTree = (List)q.list();
	        objectList.add(objectUserTree);
	        
	     
	        
	        return objectList;
	        //return (List) q.list();
		}catch (Exception e)
		{
			logger.error(e);
		}finally
		{
			closeSession(session);
		}
		
		
		return null;
	}
}
