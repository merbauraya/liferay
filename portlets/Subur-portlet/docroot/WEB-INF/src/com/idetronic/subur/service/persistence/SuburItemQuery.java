package com.idetronic.subur.service.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.persistence.AssetEntryQuery;

public class SuburItemQuery  {
	
	AssetEntryQuery assetQuery = null;
	public SuburItemQuery()
	{
		assetQuery = new AssetEntryQuery();
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
	
	public boolean isVisible()
	{
		return assetQuery.isVisible();
	}
	public String getKeywords() {
		return assetQuery.getKeywords();
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
	private static Log _log = LogFactoryUtil.getLog(SuburItemQuery.class);
	
	private int _start = QueryUtil.ALL_POS;
	private int _end = QueryUtil.ALL_POS;
	private long[] _anyItemTypeIds = new long[0];
	private long[] _allItemTypeIds = new long[0];
	private String _keywords;
	
	private long _yearPublished = 0;
	private long _monthPublished = 0;
	
	

	private long[] _allCategoryIds = new long[0];
	private long[] _allTagIds = new long[0];
	private long[][] _allTagIdsArray = new long[0][];
	private long[] _anyCategoryIds = new long[0];
	private long[] _anyTagIds = new long[0];
	
	private long[] _notAllCategoryIds = new long[0];
	private long[] _notAllTagIds = new long[0];
	private long[][] _notAllTagIdsArray = new long[0][];
	private long[] _notAnyCategoryIds = new long[0];
	private long[] _notAnyTagIds = new long[0];
	
	private String _authorFirstName = StringPool.BLANK;
	private String _authorLastName = StringPool.BLANK;
	
	private String _title = StringPool.BLANK;
	private String _toString;
	private long[] _groupIds = new long[0];
	
	
	

}
