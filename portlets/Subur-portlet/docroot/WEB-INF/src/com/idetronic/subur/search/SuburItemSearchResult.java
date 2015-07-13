package com.idetronic.subur.search;

import java.util.Date;

import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.service.SuburItemLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portlet.asset.model.AssetEntry;


public class SuburItemSearchResult  {
	
	
	public SuburItemSearchResult(Document document) throws PortalException, SystemException
	{
		_doc = document;
		_itemId = Long.parseLong(document.get(Field.ENTRY_CLASS_PK));
		_item = SuburItemLocalServiceUtil.getSuburItem(_itemId);
		
	}
	public long getItemId()
	{
		return _itemId;
	}
	public String getTitle()
	{
		return _doc.get(Field.TITLE);
	}
	public String getAbstract()
	{
		return _item.getItemAbstract();
	}
	public Date getCreateDate()
	{
		return _item.getCreateDate();
	}
	public int getViewCount()
	{
		return Integer.parseInt(_doc.get(Field.VIEW_COUNT));
	}
	
	private SuburItem _item;
	private long _itemId;
	private AssetEntry _assetEntry;
	private Document _doc;
}
