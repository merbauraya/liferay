package com.idetronic.subur.service.persistence;

import java.util.ArrayList;
import java.util.List;

import com.idetronic.subur.model.Author;
import com.idetronic.subur.model.FileEntryType;
import com.idetronic.subur.model.ItemType;
import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.model.impl.AuthorImpl;
import com.idetronic.subur.model.impl.FileEntryTypeImpl;
import com.idetronic.subur.model.impl.ItemAuthorImpl;
import com.idetronic.subur.model.impl.ItemFileEntryImpl;
import com.idetronic.subur.model.impl.ItemItemTypeImpl;
import com.idetronic.subur.model.impl.ItemTypeImpl;
import com.idetronic.subur.model.impl.MetadataPropertyValueImpl;
import com.idetronic.subur.model.impl.MetadataValueViewImpl;
import com.idetronic.subur.model.impl.SuburItemImpl;
import com.idetronic.subur.util.SuburConstant;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class SuburItemFinderImpl extends BasePersistenceImpl<SuburItem> implements SuburItemFinder {
	private static Log logger = LogFactoryUtil.getLog(SuburItemFinderImpl.class);
	
	private static final String SQL_FIND_BY_AUTHOR_G = SuburItemFinderImpl.class.getName() +".findByAuthor_G";
	
	public List getItemTypes(long itemId)
	{
		List objectListItemType=new ArrayList();
		List objectList=new ArrayList();
		List objectListItemItemType = new ArrayList();
		Session session = null;
		//SessionFactory  sessionFactory = (SessionFactory)PortalBeanLocatorUtil.locate("liferaySessionFactory");
		
		try
		{
			
			session = openSession();//sessionFactory.openSession();
			String sql =  CustomSQLUtil.get(SuburConstant.SQL_ITEM_SET_ITEMTYPE);
			
			SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("ItemType",ItemTypeImpl.class);
		    
	        QueryPos qPos = QueryPos.getInstance(q);
	        qPos.add(itemId);
	        
	        objectListItemType=(List)q.list();
	        objectList.add(objectListItemType);
	        
	        session=openSession();
	        q = session.createSQLQuery(sql);
	        q.addEntity("ItemItemType", ItemItemTypeImpl.class);
	        
	        qPos = QueryPos.getInstance(q);
	        qPos.add(itemId);
	       
	        objectListItemItemType = (List)q.list();
	        objectList.add(objectListItemItemType);
	        
	        return objectList;
	        //return (List) q.list();
		}catch (Exception e)
		{
			
			logger.error(e.getMessage());
			logger.error(e);
		}finally
		{
			closeSession(session);
		}
		
		
		return null;
		
		
	}
	public List getItemDetails(long itemId)
	{
		List objectListItemType=new ArrayList();
		List objectList=new ArrayList();
		List objectListItemItemType = new ArrayList();
		Session session = null;
		//SessionFactory  sessionFactory = (SessionFactory)PortalBeanLocatorUtil.locate("liferaySessionFactory");
		
		try
		{
			
			session = openSession();//sessionFactory.openSession();
			String sql =  CustomSQLUtil.get(SuburConstant.SQL_ITEM_DETAILS);
			
			SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("SuburItem",SuburItemImpl.class);
		    
	        QueryPos qPos = QueryPos.getInstance(q);
	        qPos.add(itemId);
	        
	        objectListItemType=(List)q.list();
	        objectList.add(objectListItemType);
	        
	        session=openSession();
	        q = session.createSQLQuery(sql);
	        q.addEntity("MetadataPropertyValue", MetadataPropertyValueImpl.class);
	        
	        qPos = QueryPos.getInstance(q);
	        qPos.add(itemId);
	       
	        objectListItemItemType = (List)q.list();
	        objectList.add(objectListItemItemType);
	        
	        //q.addEntity("User_",PortalClassLoaderUtil.getClassLoader().loadClass("com.liferay.portal.model.impl.UserImpl"));
	        
	       // QueryPos qPos = QueryPos.getInstance(q);
	        
	        return objectList;
	        //return (List) q.list();
		}catch (Exception e)
		{
			
			logger.error(e.getMessage());
			logger.error(e);
		}finally
		{
			closeSession(session);
		}
		
		
		return null;
		
		
	}
	/**
	 * find items for a specific author
	 * @param groupId
	 * @param authorId
	 * @param start
	 * @param end
	 * @param obc
	 * @return list of SuburItem
	 * @throws SystemException
	 */
	public List<SuburItem> findByAuthorGroup(long groupId,long authorId,
			int start, int end,int status, OrderByComparator obc) throws SystemException
	{
		Session session = null;
		try
		{
			session = openSession();//sessionFactory.openSession();
			String sql =  CustomSQLUtil.get(SQL_FIND_BY_AUTHOR_G);
			
		
			
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
	        
	        q.addEntity("Subur_Item",SuburItemImpl.class);
		    
	        QueryPos qPos = QueryPos.getInstance(q);
	        
	        qPos.add(authorId);
	        qPos.add(groupId);
	        qPos.add(status);
	        
	
	        
	        return (List<SuburItem>)QueryUtil.list(q, getDialect(), start, end);
			
		}catch (Exception e)
		{
			throw new SystemException(e.getMessage(), e);
		}finally
		{
			closeSession(session);
		}
	
	
	}
	
	
	/**
	 * getItemAuthors - Return list of authors for a given item
	 * @param itemId
	 * @return
	 */
	public List getItemAuthors(long itemId)
	{
		List objectListItemType=new ArrayList();
		List objectList=new ArrayList();
		List objectListItemItemType = new ArrayList();
		Session session = null;
		//SessionFactory  sessionFactory = (SessionFactory)PortalBeanLocatorUtil.locate("liferaySessionFactory");
		
		try
		{
			
			session = openSession();//sessionFactory.openSession();
			String sql =  CustomSQLUtil.get(SuburConstant.SQL_ITEM_AUTHOR);
			
			SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("Author",AuthorImpl.class);
		    q.addEntity("ItemAuthor", ItemAuthorImpl.class);
	        QueryPos qPos = QueryPos.getInstance(q);
	        qPos.add(itemId);
	        /*
	        objectListItemType=(List)q.list();
	        objectList.add(objectListItemType);
	        
	        session=openSession();
	        q = session.createSQLQuery(sql);
	        q.addEntity("ItemAuthor", ItemAuthorImpl.class);
	        
	        qPos = QueryPos.getInstance(q);
	        qPos.add(itemId);
	        
	        objectListItemItemType = (List)q.list();
	        objectList.add(objectListItemItemType);
	        */
	    
	        return (List) q.list();
	        
		}catch (Exception e)
		{
			
			logger.error(e.getMessage());
			logger.error(e);
		}finally
		{
			closeSession(session);
		}
		
		
		return null;
		
	}
	
	
	
	
}
