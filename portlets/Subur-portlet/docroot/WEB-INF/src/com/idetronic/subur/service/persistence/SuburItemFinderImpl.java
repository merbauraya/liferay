package com.idetronic.subur.service.persistence;

import java.util.ArrayList;
import java.util.List;

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
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class SuburItemFinderImpl extends BasePersistenceImpl<SuburItem> implements SuburItemFinder {
	private static Log logger = LogFactoryUtil.getLog(SuburItemFinderImpl.class);
	
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
	public List getFileEntries(long itemId)
	{
		List objectListItemType=new ArrayList();
		List objectList=new ArrayList();
		List objectListItemItemType = new ArrayList();
		Session session = null;
		//SessionFactory  sessionFactory = (SessionFactory)PortalBeanLocatorUtil.locate("liferaySessionFactory");
		
		try
		{
			
			session = openSession();//sessionFactory.openSession();
			String sql =  CustomSQLUtil.get(SuburConstant.SQL_ITEM_FILE_ENTRIES);
			
			SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("FileEntryType",FileEntryTypeImpl.class);
		    
	        QueryPos qPos = QueryPos.getInstance(q);
	        qPos.add(itemId);
	        
	        objectListItemType=(List)q.list();
	        objectList.add(objectListItemType);
	        
	        session=openSession();
	        q = session.createSQLQuery(sql);
	        q.addEntity("ItemFileEntry", ItemFileEntryImpl.class);
	        
	        qPos = QueryPos.getInstance(q);
	        qPos.add(itemId);
	       
	        objectListItemItemType = (List)q.list();
	        objectList.add(objectListItemItemType);
	        
	    
	        return objectList;
	        
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
	public List getItemBySubjectId(long subjectId,int start,int end)
	{
		List objectListItems=new ArrayList();
		List objectList=new ArrayList();
		List objectListItemItemType = new ArrayList();
		Session session = null;
		//SessionFactory  sessionFactory = (SessionFactory)PortalBeanLocatorUtil.locate("liferaySessionFactory");
		
		try
		{
			
			session = openSession();//sessionFactory.openSession();
			String sql =  CustomSQLUtil.get(SuburConstant.SQL_ITEMS_BY_SUBJECT_ID);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.setFirstResult(start);
			q.setMaxResults(end);
	        q.setCacheable(false);
	        q.addEntity("SuburItem",SuburItemImpl.class);
		    
	        QueryPos qPos = QueryPos.getInstance(q);
	        qPos.add(subjectId);
	        
	        objectListItems=(List)q.list();
	        objectList.add(objectListItems);
	        
	        /*
	        session=openSession();
	        q = session.createSQLQuery(sql);
	        q.addEntity("ItemFileEntry", ItemFileEntryImpl.class);
	        
	        qPos = QueryPos.getInstance(q);
	        qPos.add(itemId);
	       
	        objectListItemItemType = (List)q.list();
	        objectList.add(objectListItemItemType);
	        
	    	*/
	        return objectList;
	        
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
	public List itemCountByItemTypeInSubject(long subjectId)
	{
		List objectListItemType=new ArrayList();
		List objectList=new ArrayList();
		List objectListItemItemType = new ArrayList();
		Session session = null;
		//SessionFactory  sessionFactory = (SessionFactory)PortalBeanLocatorUtil.locate("liferaySessionFactory");
		
		try
		{
			
			session = openSession();//sessionFactory.openSession();
			String sql =  CustomSQLUtil.get(SuburConstant.SQL_ITEM_COUNT_BY_ITEM_TYPE_IN_SUBJECT);
			
			SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("ItemType",ItemTypeImpl.class);
		    
	        QueryPos qPos = QueryPos.getInstance(q);
	        qPos.add(subjectId);
	        
	        objectListItemType=(List)q.list();
	        objectList.add(objectListItemType);
	        
	       
	        
	    
	        return objectList;
	        
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
	public List itemCountByAuthorInSubject(long subjectId)
	{
		List objectListItemType=new ArrayList();
		List objectList=new ArrayList();
		List objectListItemItemType = new ArrayList();
		Session session = null;
		//SessionFactory  sessionFactory = (SessionFactory)PortalBeanLocatorUtil.locate("liferaySessionFactory");
		
		try
		{
			
			session = openSession();//sessionFactory.openSession();
			String sql =  CustomSQLUtil.get(SuburConstant.SQL_ITEM_COUNT_BY_AUTHOR_IN_SUBJECT);
			
			SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("MetadataValueView",MetadataValueViewImpl.class);
		    
	        QueryPos qPos = QueryPos.getInstance(q);
	        qPos.add(subjectId);
	        qPos.add(SuburConstant.METADATA_CONTRIBUTOR_AUTHOR);
	        
	        logger.info(q.toString());
	        //logger.info(q.);
	        objectListItemType=(List)q.list();
	        objectList.add(objectListItemType);
	        
	       
	        logger.info("obj returned");
	    
	        
	        
		}catch (Exception e)
		{
			
			logger.error(e.getMessage());
			logger.error(e);
		}finally
		{
			closeSession(session);
		}
		
		
		return objectList;
		
	}
	
	
}
