package com.idetronic.subur.service.persistence;

import java.util.Date;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Layout;
import com.liferay.portlet.asset.service.persistence.AssetEntryQuery;

public class SuburItemQuery  {
	
	private AssetEntryQuery assetQuery = null;
	
	public SuburItemQuery()
	{
		
	}
	
	public SuburItemQuery(AssetEntryQuery assetQuery)
	{
		this.assetQuery = assetQuery;
	}
	public void setAssetQuery(AssetEntryQuery assetQuery)
	{
		this.assetQuery = assetQuery; 
	}
	public String getTitle()
	{
		return assetQuery.getTitle();
	}
	public long getYearPublished()
	{
		return _yearPublished;
	}
	public long getMonthPublished()
	{
		return _monthPublished;
	}
	public long[] getAnyItemTypeIds()
	{
		return _anyItemTypeIds;
	}
	public long[] getAllItemTypeIds()
	{
		return _allItemTypeIds;
	}
	public void setTitle(String title)
	{
		assetQuery.setTitle(title);
	}
	public void setYearMonthPublished(long year,long month)
	{
		_yearPublished = year;
		_monthPublished = month;
	}
	public long[] getAnyTagIds()
	{
		return assetQuery.getAllTagIds();
	}
	public long[] getAllTagIds()
	{
		return assetQuery.getAnyTagIds();
	}
	public long[] getAllCategoryIds()
	{
		return assetQuery.getAllCategoryIds();
	}
	public long[] getAnyCategoryIds()
	{
		return assetQuery.getAnyCategoryIds();
	}
	public String getAuthorFirstName()
	{
		return _authorFirstName;
	}
	public String getAuthorLastName()
	{
		return _authorLastName;
	}
	public boolean isExcludeZeroViewCount()
	{
		return assetQuery.isExcludeZeroViewCount();
	}
	public long[] getNotAllCategoryIds()
	{
		return assetQuery.getNotAllCategoryIds();
	}
	public long[] getNotAnyCategoryIds()
	{
		return assetQuery.getNotAnyCategoryIds();
	}
	public long[][] getAllTagIdsArray()
	{
		return assetQuery.getAllTagIdsArray();
	}
	public long[] getNotAllTagIds()
	{
		return assetQuery.getNotAllTagIds();
	}
	public long[][] getNotAllTagIdsArray()
	{
		return assetQuery.getNotAllTagIdsArray();
	}
	public long[] getNotAnyTagIds()
	{
		return assetQuery.getNotAnyTagIds();
	}
	public Date getPublishDate()
	{
		return assetQuery.getPublishDate();
	}
	public Date getExpirationDate()
	{
		return assetQuery.getExpirationDate();
	}
	public long[] getGroupIds()
	{
		return assetQuery.getGroupIds();
	}
	public long[] getClassNameIds()
	{
		return assetQuery.getClassNameIds();
	}
	public long[] getClassTypeIds()
	{
		return assetQuery.getClassTypeIds();
	}
	public String getDescription()
	{
		return assetQuery.getDescription();
	}
	public Layout getLayout()
	{
		return assetQuery.getLayout();
	}
	public boolean isVisible()
	{
		return assetQuery.isVisible();
	}
	public String getKeywords() {
		return assetQuery.getKeywords();
	}
	public int getStart()
	{
		return assetQuery.getStart();
	}
	public int getEnd()
	{
		return assetQuery.getEnd();
	}
	public String getOrderByCol1()
	{
		return assetQuery.getOrderByCol1();
	}
	public String getOrderByCol2()
	{
		return assetQuery.getOrderByCol2();
	}
	public String getOrderByType1()
	{
		return assetQuery.getOrderByType1();
	}
	
	public long getLinkedAssetEntryId()
	{
		return assetQuery.getLinkedAssetEntryId();
	}
	public String getOrderByType2()
	{
		return assetQuery.getOrderByType2();
	}
	
	public void setAnyItemTypeIds(long[] anyItemTypeIds)
	{
		_anyItemTypeIds = anyItemTypeIds;
	}
	public void setAllItemTypeIds(long[] allItemTypeIds)
	{
		_allItemTypeIds = allItemTypeIds;
	}
	public void setAnyTagIds(long[] anyTagIds) {
		assetQuery.setAnyTagIds(anyTagIds);
	}
	public void setAnyCategoryIds(long[] anyCategoryIds) {
		assetQuery.setAnyCategoryIds(anyCategoryIds);
	}
	public void setAllCategoryIds(long[] allCategoryIds) {
		assetQuery.setAllCategoryIds(allCategoryIds);
	}

	public void setAllTagIds(long[] allTagIds) {
		assetQuery.setAllTagIds(allTagIds);
	}

	public void setAllTagIdsArray(long[][] allTagIdsArray) {
		assetQuery.setAllTagIdsArray(allTagIdsArray);
	}
	
	
	public void setStart(int start) {
		assetQuery.setStart(start);
	}
	public void setKeywords(String keywords)
	{
		assetQuery.setKeywords(keywords);
	}
	public void setVisible(boolean visible)
	{
		assetQuery.setVisible(visible);
	}
	public void setGroupIds(long[] groupIds)
	{
		assetQuery.setGroupIds(groupIds);
	}
	private static Log logger = LogFactoryUtil.getLog(SuburItemQuery.class);
	
	private long[] _anyItemTypeIds = new long[0];
	private long[] _allItemTypeIds = new long[0];
	private long _yearPublished = 0;
	private long _monthPublished = 0;
	
	

	private String _authorFirstName = StringPool.BLANK;
	private String _authorLastName = StringPool.BLANK;
	
	

	

}
