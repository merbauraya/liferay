package com.idetronic.subur.service.persistence;

import java.util.ArrayList;
import java.util.List;

import com.idetronic.subur.model.ItemItemType;
import com.idetronic.subur.model.impl.ItemItemTypeImpl;
import com.idetronic.subur.model.impl.ItemTypeImpl;
import com.idetronic.subur.util.SuburConstant;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


public class ItemItemTypeFinderImpl extends BasePersistenceImpl<ItemItemType> implements ItemItemTypeFinder{

	private static Log logger = LogFactoryUtil.getLog(ItemItemTypeFinderImpl.class);
	public List getByItem(long itemId)
	{
		List objectListUser=new ArrayList();
		List objectList=new ArrayList();
		List objectUserTree = new ArrayList();
		Session session = null;
		SessionFactory  sessionFactory = null;
		try
		{
			
			//sessionFactory = (SessionFactory)PortalBeanLocatorUtil.locate("liferaySessionFactory");
			
			session = openSession();// sessionFactory.openSession();
			
			String sql =  CustomSQLUtil.get(SuburConstant.SQL_ITEM_ITEMTYPE);
			
			SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("ItemType_",ItemTypeImpl.class);
		    
	        QueryPos qPos = QueryPos.getInstance(q);
	        qPos.add(itemId);
	       
	        objectListUser=(List)q.list();
	        objectList.add(objectListUser);
	        
	        session=openSession();//sessionFactory.openSession();//openSession();
	        q = session.createSQLQuery(sql);
	        q.addEntity("ItemItemType", ItemItemTypeImpl.class);
	        
	        qPos = QueryPos.getInstance(q);
	        qPos.add(itemId);
	        objectUserTree = (List)q.list();
	        objectList.add(objectUserTree);
	        
	     
	        
	        return (List) objectList.get(0);
	        //return (List) q.list();
		}catch (Exception e)
		{
			logger.error(e);
		}finally
		{
			closeSession(session);
			//sessionFactory.closeSession(session);
		}
		
		
		return null;
	}
}
