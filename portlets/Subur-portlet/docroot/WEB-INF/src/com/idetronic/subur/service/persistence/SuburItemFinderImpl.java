package com.idetronic.subur.service.persistence;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.persistence.AssetCategoryFinderUtil;
import com.liferay.portlet.asset.service.persistence.AssetEntryQuery;
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
	
	public int countEntries(AssetEntryQuery entryQuery,long[] anyItemTypeIds,long[] allItemTypeIds) 
			throws SystemException {
		Session session = null;

		try {
			session = openSession();

			SQLQuery q = buildAssetQuerySQL(entryQuery,anyItemTypeIds,allItemTypeIds, true, session);

			Iterator<Long> itr = q.iterate();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
	
	public List<AssetEntry> findAssetEntries(AssetEntryQuery entryQuery,long[] anyItemTypeIds,long[] allItemTypeIds)
			throws SystemException {
		SessionFactory sessionFactory = (SessionFactory) PortalBeanLocatorUtil.locate("liferaySessionFactory");

			Session session = null;

			try {
				session = sessionFactory.openSession();//openSession();

				SQLQuery q = buildAssetQuerySQL(entryQuery,anyItemTypeIds, allItemTypeIds,false, session);

				return (List<AssetEntry>)QueryUtil.list(
					q, getDialect(), entryQuery.getStart(), entryQuery.getEnd());
			}
			catch (Exception e) {
				throw new SystemException(e);
			}
			finally {
				closeSession(session);
			}
		}
	
	protected SQLQuery buildAssetQuerySQL(
			AssetEntryQuery entryQuery, long[] anyItemTypeIds,long[] allItemTypeIds,boolean count, Session session)
		throws SystemException, ClassNotFoundException {

		StringBundler sb = new StringBundler();

		if (count) {
			sb.append(
				"SELECT COUNT(DISTINCT AssetEntry.entryId) AS COUNT_VALUE ");
		}
		else {
			sb.append("SELECT AssetEntry.* ");

			boolean selectRatings = false;

			String orderByCol1 = entryQuery.getOrderByCol1();
			String orderByCol2 = entryQuery.getOrderByCol2();

			if (orderByCol1.equals("ratings") ||
				orderByCol2.equals("ratings")) {

				selectRatings = true;

				sb.append(", TEMP_TABLE.averageScore ");
			}

			sb.append("FROM (SELECT DISTINCT AssetEntry.entryId ");

			if (selectRatings) {
				sb.append(", RatingsStats.averageScore ");
			}
		}

		sb.append("FROM AssetEntry ");

		if (entryQuery.getAnyTagIds().length > 0) {
			sb.append("INNER JOIN ");
			sb.append("AssetEntries_AssetTags ON ");
			sb.append("(AssetEntries_AssetTags.entryId = ");
			sb.append("AssetEntry.entryId) ");
			sb.append("INNER JOIN ");
			sb.append("AssetTag ON ");
			sb.append("(AssetTag.tagId = AssetEntries_AssetTags.tagId) ");
		}

		if (entryQuery.getLinkedAssetEntryId() > 0) {
			sb.append("INNER JOIN ");
			sb.append("AssetLink ON ");
			sb.append("(AssetEntry.entryId = AssetLink.entryId1) ");
			sb.append("OR (AssetEntry.entryId = AssetLink.entryId2)");
		}

		if (entryQuery.getOrderByCol1().equals("ratings") ||
			entryQuery.getOrderByCol2().equals("ratings")) {

			sb.append(" LEFT JOIN ");
			sb.append("RatingsStats ON ");
			sb.append("(RatingsStats.classNameId = ");
			sb.append("AssetEntry.classNameId) AND ");
			sb.append("(RatingsStats.classPK = AssetEntry.classPK)");
		}

		sb.append("WHERE ");

		int whereIndex = sb.index();

		if (entryQuery.getLinkedAssetEntryId() > 0) {
			sb.append(" AND ((AssetLink.entryId1 = ?) OR ");
			sb.append("(AssetLink.entryId2 = ?))");
			sb.append(" AND (AssetEntry.entryId != ?)");
		}

		if (entryQuery.isVisible() ) {
			sb.append(" AND (visible = ?)");
		}

		if (entryQuery.isExcludeZeroViewCount()) {
			sb.append(" AND (AssetEntry.viewCount > 0)");
		}

		// Keywords

		if (Validator.isNotNull(entryQuery.getKeywords())) {
			sb.append(" AND ((AssetEntry.title LIKE ?) OR");
			sb.append(" (AssetEntry.description LIKE ?))");
		}
		else {
			if (Validator.isNotNull(entryQuery.getTitle())) {
				sb.append(" AND (AssetEntry.title LIKE ?)");
			}

			if (Validator.isNotNull(entryQuery.getDescription())) {
				sb.append(" AND (AssetEntry.description LIKE ?)");
			}
		}

		// Layout

		Layout layout = entryQuery.getLayout();

		if (layout != null) {
			sb.append(" AND (AssetEntry.layoutUuid = ?)");
		}

		// Category conditions

		if (entryQuery.getAllCategoryIds().length > 0) {
			buildAllCategoriesSQL(entryQuery.getAllCategoryIds(), sb);
		}

		if (entryQuery.getAnyCategoryIds().length > 0) {
			buildAnyCategoriesSQL(entryQuery.getAnyCategoryIds(), sb);
		}

		if (entryQuery.getNotAllCategoryIds().length > 0) {
			buildNotAllCategoriesSQL(entryQuery.getNotAllCategoryIds(), sb);
		}

		if (entryQuery.getNotAnyCategoryIds().length > 0) {
			buildNotAnyCategoriesSQL(entryQuery.getNotAnyCategoryIds(), sb);
		}

		// Asset entry subtypes

		if (entryQuery.getClassTypeIds().length > 0) {
			buildClassTypeIdsSQL(entryQuery.getClassTypeIds(), sb);
		}

		// Tag conditions
		
		if (entryQuery.getAllTagIds().length > 0) {
			buildAllTagsSQL(entryQuery.getAllTagIdsArray(), sb);
		}

		if (entryQuery.getAnyTagIds().length > 0) {
			buildAnyTagsSQL(entryQuery.getAnyTagIds(), sb);
		}

		if (entryQuery.getNotAllTagIds().length > 0) {
			buildNotAllTagsSQL(entryQuery.getNotAllTagIdsArray(), sb);
		}
		
		//item type ids
		if (anyItemTypeIds != null && anyItemTypeIds.length > 0){
			buildAnyItemTypesSQL(anyItemTypeIds,sb);
			
		}
		
		if (allItemTypeIds != null && allItemTypeIds.length > 0){
			buildAllItemTypesSQL(allItemTypeIds ,sb);
		}
		
		if (entryQuery.getNotAnyTagIds().length > 0) {
			buildNotAnyTagsSQL(entryQuery.getNotAnyTagIds(), sb);
		}

		// Other conditions

		sb.append(
			getDates(
				entryQuery.getPublishDate(), entryQuery.getExpirationDate()));
		sb.append(getGroupIds(entryQuery.getGroupIds()));
		sb.append(getClassNameIds(entryQuery.getClassNameIds()));

		if (!count) {
			sb.append(") TEMP_TABLE ");
			sb.append("INNER JOIN ");
			sb.append("AssetEntry AssetEntry ON ");
			sb.append("TEMP_TABLE.entryId = AssetEntry.entryId");

			sb.append(" ORDER BY ");

			if (entryQuery.getOrderByCol1().equals("ratings")) {
				sb.append("TEMP_TABLE.averageScore");
			}
			else {
				sb.append("AssetEntry.");
				sb.append(entryQuery.getOrderByCol1());
			}

			sb.append(StringPool.SPACE);
			sb.append(entryQuery.getOrderByType1());

			if (Validator.isNotNull(entryQuery.getOrderByCol2()) &&
				!entryQuery.getOrderByCol1().equals(
					entryQuery.getOrderByCol2())) {

				if (entryQuery.getOrderByCol2().equals("ratings")) {
					sb.append(", TEMP_TABLE.averageScore");
				}
				else {
					sb.append(", AssetEntry.");
					sb.append(entryQuery.getOrderByCol2());
				}

				sb.append(StringPool.SPACE);
				sb.append(entryQuery.getOrderByType2());
			}
		}

		if (sb.index() > whereIndex) {
			String where = sb.stringAt(whereIndex);

			if (where.startsWith(" AND")) {
				sb.setStringAt(where.substring(4), whereIndex);
			}
		}

		String sql = sb.toString();
		//logger.info(sql);
		SQLQuery q = session.createSQLQuery(sql);

		if (count) {
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
		}
		else {
			q.addEntity("AssetEntry_",PortalClassLoaderUtil.getClassLoader().loadClass("com.liferay.portlet.asset.model.impl.AssetEntryImpl"));

			//q.addEntity("AssetEntry", com.liferay.portlet.asset.model.impl.AssetEntryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		if (entryQuery.getLinkedAssetEntryId() > 0) {
			qPos.add(entryQuery.getLinkedAssetEntryId());
			qPos.add(entryQuery.getLinkedAssetEntryId());
			qPos.add(entryQuery.getLinkedAssetEntryId());
		}

		if (entryQuery.isVisible()) {
			qPos.add(entryQuery.isVisible());
		}

		if (Validator.isNotNull(entryQuery.getKeywords())) {
			qPos.add(entryQuery.getKeywords() + CharPool.PERCENT);
			qPos.add(entryQuery.getKeywords() + CharPool.PERCENT);
		}
		else {
			if (Validator.isNotNull(entryQuery.getTitle())) {
				qPos.add(entryQuery.getTitle() + CharPool.PERCENT);
			}

			if (Validator.isNotNull(entryQuery.getDescription())) {
				qPos.add(entryQuery.getDescription() + CharPool.PERCENT);
			}
		}

		if (layout != null) {
			qPos.add(layout.getUuid());
		}

		setDates(
			qPos, entryQuery.getPublishDate(), entryQuery.getExpirationDate());

		qPos.add(entryQuery.getGroupIds());
		qPos.add(entryQuery.getClassNameIds());

		return q;
	}
	protected void buildClassTypeIdsSQL(long[] classTypeIds, StringBundler sb) {
		sb.append(" AND (");

		for (int i = 0; i < classTypeIds.length; i++) {
			sb.append(" AssetEntry.classTypeId = ");
			sb.append(classTypeIds[i]);

			if ((i + 1) < classTypeIds.length) {
				sb.append(" OR ");
			}
			else {
				sb.append(StringPool.CLOSE_PARENTHESIS);
			}
		}
	}
	protected void buildAllCategoriesSQL(long[] categoryIds, StringBundler sb)
			throws SystemException {
			
			String findByAndCategoryIdsSQL = CustomSQLUtil.get(
				FIND_BY_AND_CATEGORY_IDS);

			sb.append(" AND (");

			for (int i = 0; i < categoryIds.length; i++) {
				String sql = null;

				if (catSearchHierarchy) {
					List<Long> treeCategoryIds = AssetCategoryFinderUtil.findByG_L(
						categoryIds[i]);

					if (treeCategoryIds.size() > 1) {
						sql = StringUtil.replace(
							findByAndCategoryIdsSQL, "[$CATEGORY_ID$]",
							StringUtil.merge(treeCategoryIds));
					}
				}

				if (sql == null) {
					sql = StringUtil.replace(
						findByAndCategoryIdsSQL, " IN ([$CATEGORY_ID$])",
						" = " + categoryIds[i]);
				}

				sb.append(sql);

				if ((i + 1) < categoryIds.length) {
					sb.append(" AND ");
				}
			}

			sb.append(StringPool.CLOSE_PARENTHESIS);
		}
	protected void buildAllItemTypesSQL(long[] itemTypeIds, StringBundler sb)
			throws SystemException {
			
			String findByAndItemTypeIdsSQL = CustomSQLUtil.get(
					FIND_BY_AND_ITEMTYPE_IDS);

			sb.append(" AND (");

			for (int i = 0; i < itemTypeIds.length; i++) {
				String sql = null;

				

				
				sql = StringUtil.replace(
							findByAndItemTypeIdsSQL, " IN ([$ITEMTYPE_ID$])",
						" = " + itemTypeIds[i]);
				

				sb.append(sql);

				if ((i + 1) < itemTypeIds.length) {
					sb.append(" AND ");
				}
			}

			sb.append(StringPool.CLOSE_PARENTHESIS);
		}
		protected void buildAllTagsSQL(long[][] tagIds, StringBundler sb) {
			sb.append(" AND AssetEntry.entryId IN (");

			for (int i = 0; i < tagIds.length; i++) {
				String sql = CustomSQLUtil.get(FIND_BY_AND_TAG_IDS);

				sql = StringUtil.replace(sql, "[$TAG_ID$]", getTagIds(tagIds[i]));

				sb.append(sql);

				if ((i + 1) < tagIds.length) {
					sb.append(" AND AssetEntry.entryId IN (");
				}
			}

			for (int i = 0; i < tagIds.length; i++) {
				if ((i + 1) < tagIds.length) {
					sb.append(StringPool.CLOSE_PARENTHESIS);
				}
			}

			sb.append(StringPool.CLOSE_PARENTHESIS);
		}

		protected void buildAnyItemTypesSQL(long[] itemTypeIds, StringBundler sb)
				throws SystemException {

				String sql = CustomSQLUtil.get(FIND_BY_AND_ITEMTYPE_IDS);

				String itemTypeIdsString = null;

				
				
				itemTypeIdsString = StringUtil.merge(itemTypeIds);
				

				sb.append(" AND (");
				sb.append(
					StringUtil.replace(sql, "[$ITEMTYPE_ID$]", itemTypeIdsString));
				sb.append(StringPool.CLOSE_PARENTHESIS);
			}
		
		protected void buildAnyCategoriesSQL(long[] categoryIds, StringBundler sb)
			throws SystemException {

			String sql = CustomSQLUtil.get(FIND_BY_AND_CATEGORY_IDS);

			String categoryIdsString = null;

			if (catSearchHierarchy) {
				List<Long> categoryIdsList = new ArrayList<Long>();

				for (long categoryId : categoryIds) {
					categoryIdsList.addAll(
						AssetCategoryFinderUtil.findByG_L(categoryId));
				}

				if (categoryIdsList.isEmpty()) {
					return;
				}

				categoryIdsString = StringUtil.merge(categoryIdsList);
			}
			else {
				categoryIdsString = StringUtil.merge(categoryIds);
			}

			sb.append(" AND (");
			sb.append(
				StringUtil.replace(sql, "[$CATEGORY_ID$]", categoryIdsString));
			sb.append(StringPool.CLOSE_PARENTHESIS);
		}

		protected String buildAnyTagsSQL(long[] tagIds, StringBundler sb) {
			sb.append(" AND (");

			for (int i = 0; i < tagIds.length; i++) {
				sb.append("AssetTag.tagId = ");
				sb.append(tagIds[i]);

				if ((i + 1) != tagIds.length) {
					sb.append(" OR ");
				}
			}

			sb.append(StringPool.CLOSE_PARENTHESIS);

			return sb.toString();
		}
		protected void buildNotAllCategoriesSQL(
				long[] categoryIds, StringBundler sb)
			throws SystemException {

			String findByAndCategoryIdsSQL = CustomSQLUtil.get(
				FIND_BY_AND_CATEGORY_IDS);

			sb.append(" AND (");

			for (int i = 0; i < categoryIds.length; i++) {
				sb.append("NOT ");

				String sql = null;

				if (catSearchHierarchy) {
					List<Long> treeCategoryIds = AssetCategoryFinderUtil.findByG_L(
						categoryIds[i]);

					if (treeCategoryIds.size() > 1) {
						sql = StringUtil.replace(
							findByAndCategoryIdsSQL, "[$CATEGORY_ID$]",
							StringUtil.merge(treeCategoryIds));
					}
				}

				if (sql == null) {
					sql = StringUtil.replace(
						findByAndCategoryIdsSQL, " IN ([$CATEGORY_ID$])",
						" = " + categoryIds[i]);
				}

				sb.append(sql);

				if ((i + 1) < categoryIds.length) {
					sb.append(" OR ");
				}
			}

			sb.append(StringPool.CLOSE_PARENTHESIS);
		}

		protected void buildNotAllTagsSQL(long[][] tagIds, StringBundler sb) {
			sb.append(" AND (");

			for (int i = 0; i < tagIds.length; i++) {
				sb.append("AssetEntry.entryId NOT IN (");

				String sql = CustomSQLUtil.get(FIND_BY_AND_TAG_IDS);

				sql = StringUtil.replace(sql, "[$TAG_ID$]", getTagIds(tagIds[i]));

				sb.append(sql);
				sb.append(StringPool.CLOSE_PARENTHESIS);

				if (((i + 1) < tagIds.length) && (tagIds[i + 1].length > 0)) {
					sb.append(" OR ");
				}
			}

			sb.append(StringPool.CLOSE_PARENTHESIS);
		}

		protected void buildNotAnyCategoriesSQL(
				long[] notCategoryIds, StringBundler sb)
			throws SystemException {

			sb.append(" AND (NOT ");

			String sql = CustomSQLUtil.get(FIND_BY_AND_CATEGORY_IDS);

			String notCategoryIdsString = null;

			if (catSearchHierarchy) {
				List<Long> notCategoryIdsList = new ArrayList<Long>();

				for (long notCategoryId : notCategoryIds) {
					notCategoryIdsList.addAll(
						AssetCategoryFinderUtil.findByG_L(notCategoryId));
				}

				notCategoryIdsString = StringUtil.merge(notCategoryIdsList);
			}
			else {
				notCategoryIdsString = StringUtil.merge(notCategoryIds);
			}

			sb.append(
				StringUtil.replace(sql, "[$CATEGORY_ID$]", notCategoryIdsString));
			sb.append(StringPool.CLOSE_PARENTHESIS);
		}

		protected String buildNotAnyTagsSQL(long[] notTagIds, StringBundler sb) {
			sb.append(" AND (");

			for (int i = 0; i < notTagIds.length; i++) {
				sb.append("AssetEntry.entryId NOT IN (");

				String sql = CustomSQLUtil.get(FIND_BY_AND_TAG_IDS);

				sql = StringUtil.replace(sql, "[$TAG_ID$]", getTagIds(notTagIds));

				sb.append(sql);
				sb.append(StringPool.CLOSE_PARENTHESIS);

				if ((i + 1) < notTagIds.length) {
					sb.append(" AND ");
				}
			}

			sb.append(StringPool.CLOSE_PARENTHESIS);

			return sb.toString();
		}
	protected String getDates(Date publishDate, Date expirationDate) {
		StringBundler sb = new StringBundler(4);

		if (publishDate != null) {
			sb.append(" AND (AssetEntry.publishDate IS NULL OR ");
			sb.append("AssetEntry.publishDate < ?)");
		}

		if (expirationDate != null) {
			sb.append(" AND (AssetEntry.expirationDate IS NULL OR ");
			sb.append("AssetEntry.expirationDate > ?)");
		}

		return sb.toString();
	}
	protected void setDates(
			QueryPos qPos, Date publishDate, Date expirationDate) {

			if (publishDate != null) {
				Timestamp publishDate_TS = CalendarUtil.getTimestamp(publishDate);

				qPos.add(publishDate_TS);
			}

			if (expirationDate != null) {
				Timestamp expirationDate_TS = CalendarUtil.getTimestamp(
					expirationDate);

				qPos.add(expirationDate_TS);
			}
		}
	protected String getTagIds(long[] tagIds) {
		StringBundler sb = new StringBundler((tagIds.length * 3) - 1);

		for (int i = 0; i < tagIds.length; i++) {
			sb.append("tagId = ");
			sb.append(tagIds[i]);

			if ((i + 1) != tagIds.length) {
				sb.append(" OR ");
			}
		}

		return sb.toString();
	}
	protected String getGroupIds(long[] groupIds) {
		if (groupIds.length == 0) {
			return StringPool.BLANK;
		}

		StringBundler sb = new StringBundler(groupIds.length + 1);

		sb.append(" AND (AssetEntry.groupId = ?");

		for (int i = 0; i < (groupIds.length - 1); i++) {
			sb.append(" OR AssetEntry.groupId = ?");
		}

		sb.append(StringPool.CLOSE_PARENTHESIS);

		return sb.toString();
	}
	protected String getClassNameIds(long[] classNameIds) {
		if (classNameIds.length == 0) {
			return StringPool.BLANK;
		}

		StringBundler sb = new StringBundler(classNameIds.length + 1);

		sb.append(" AND (AssetEntry.classNameId = ?");

		for (int i = 0; i < (classNameIds.length - 1); i++) {
			sb.append(" OR AssetEntry.classNameId = ?");
		}

		sb.append(StringPool.CLOSE_PARENTHESIS);

		return sb.toString();
	}
	
	public static final String FIND_BY_AND_CATEGORY_IDS =
			SuburItemFinder.class.getName() + ".findByAndCategoryIds";
	public static final String FIND_BY_AND_TAG_IDS =
			SuburItemFinder.class.getName() + ".findByAndTagIds";
	public static final String FIND_BY_AND_ITEMTYPE_IDS = 
			SuburItemFinder.class.getName() + ".findByAndItemTypeIds";
	private static final boolean catSearchHierarchy = GetterUtil.getBoolean(PropsUtil.get(PropsKeys.ASSET_CATEGORIES_SEARCH_HIERARCHICAL));

}
