package com.idetronic.subur.search;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.idetronic.subur.model.Author;
import com.idetronic.subur.model.ItemDivision;
import com.idetronic.subur.model.ItemItemType;
import com.idetronic.subur.model.ItemSubject;
import com.idetronic.subur.model.MetadataPropertyValue;
import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.service.AuthorLocalServiceUtil;
import com.idetronic.subur.service.ItemAuthorLocalServiceUtil;
import com.idetronic.subur.service.ItemDivisionLocalServiceUtil;
import com.idetronic.subur.service.ItemItemTypeLocalServiceUtil;
import com.idetronic.subur.service.ItemSubjectLocalServiceUtil;
import com.idetronic.subur.service.MetadataPropertyValueLocalServiceUtil;
import com.idetronic.subur.service.SuburItemLocalServiceUtil;
import com.idetronic.subur.service.persistence.ItemActionableDynamicQuery;
import com.idetronic.subur.service.persistence.SuburItemActionableDynamicQuery;
import com.idetronic.subur.util.SuburConstant;

public class SuburIndexer extends BaseIndexer {
	public static final String[] CLASS_NAMES = { SuburItem.class.getName() };
	public static final String PORTLET_ID = "Subur-portlet";

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object arg0) throws Exception {
		 SuburItem item = (SuburItem)arg0;

         deleteDocument(item.getCompanyId(), item.getItemId());
		
	}

	@Override
	protected Document doGetDocument(Object arg0) throws Exception {
		 SuburItem item = (SuburItem)arg0;

         Document document = getBaseModelDocument(PORTLET_ID, item);
         Date createDate = item.getCreateDate();
         Calendar cal = Calendar.getInstance();
         cal.setTime(createDate);
         String year = String.valueOf(cal.get(Calendar.YEAR));
         String month = String.valueOf(cal.get(Calendar.MONTH));
         document.addDate(Field.MODIFIED_DATE, item.getModifiedDate());
         //document.addText(Field.CONTENT, item.getItemAbstract());
         document.addText(Field.TITLE, item.getTitle());
         document.addText(Field.DESCRIPTION, item.getItemAbstract());
         document.addKeyword(Field.GROUP_ID, getSiteGroupId(item.getGroupId()));
         document.addKeyword(Field.SCOPE_GROUP_ID, item.getGroupId());
         document.addKeyword(SuburConstant.FIELD_YEAR, year);
         document.addKeyword(SuburConstant.FIELD_MONTH, month);
         
         //other title
         String[] otherTitles = item.getOtherTitles();
         if (otherTitles != null && otherTitles.length >0)
         {
             Field otherTitle = new Field(SuburConstant.FIELD_OTHER_TITLE, otherTitles );
             document.add(otherTitle);
         }
         
         //identifier
         Map<String,String> itemIdentifiers = item.getIdentifiers();
         if (itemIdentifiers != null && itemIdentifiers.size() > 0)
         {
	         for (Map.Entry<String, String> identEntry : itemIdentifiers.entrySet()) 
	         {
	        	    String identName = identEntry.getKey();
	        	    String identValue = identEntry.getValue();
	                document.addKeyword(identName, identValue);
	
	         }
         }
         
         //Series Report No
         
         
         //item type
         List<ItemItemType> itemItemTypes = ItemItemTypeLocalServiceUtil.itemTypeByItemid(item.getItemId());
         String[] itemItemTypeList = new String[itemItemTypes.size()];
                  
         for (int i=0;i<itemItemTypes.size();i++)
         {
        	 ItemItemType iType = (ItemItemType)itemItemTypes.get(i);
        	 itemItemTypeList[i] =  String.valueOf(iType.getItemTypeId());;
         }
         Field itemTypeField = new Field(SuburConstant.FIELD_ITEM_TYPE, itemItemTypeList );
         document.add(itemTypeField);
         
         /*
         List<ItemDivision> itemDivisions = ItemDivisionLocalServiceUtil.getByItemId(item.getItemId());
         
         for (ItemDivision itemDivision : itemDivisions)
        	 document.addKeyword(SuburConstant.FIELD_DIVISION, itemDivision.getDivisionId());
         */
         long[] authorIds = ItemAuthorLocalServiceUtil.getAuthorId(item.getItemId());
         List<Author> authors = AuthorLocalServiceUtil.getAuthors(authorIds);
         String[] authorString = new String[authors.size()];
         String[] authorFirstName = new String[authors.size()];
         String[] authorLastName = new String[authors.size()];
         for (int i = 0; i < authors.size();i++)
         {
        	 authorString[i] =  authors.get(i).getLastName() + StringPool.SPACE + authors.get(i).getFirstName();
        	 authorFirstName[i] = StringUtil.toLowerCase(authors.get(i).getFirstName());
        	 authorLastName[i] = StringUtil.toLowerCase(authors.get(i).getLastName());
         }
         //List authorList = MetadataPropertyValueLocalServiceUtil.getAuthor(item.getItemId());
         
         
         
         
         Field authorField = new Field(SuburConstant.FIELD_AUTHOR, authorString );
         Field authorFirstNameField = new Field(SuburConstant.FIELD_AUTHOR_FIRST_NAME,authorFirstName);
         Field authorLastNameField = new Field(SuburConstant.FIELD_AUTHOR_LAST_NAME,authorLastName);
         
         //authorField.setTokenized(true);
         document.add(authorField);
         document.add(authorFirstNameField);
         document.add(authorLastNameField);
         

         return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet,
			PortletURL portletURL) throws Exception {

        Summary summary = createSummary(document);

        summary.setMaxContentLength(200);

        return summary;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		SuburItem item = (SuburItem)obj;

        Document document = getDocument(item);

        SearchEngineUtil.updateDocument(
                getSearchEngineId(), item.getCompanyId(), document,true);
		
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

        reindexEntries(companyId);
		
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		SuburItem item = SuburItemLocalServiceUtil.getSuburItem(classPK);

        doReindex(item);
		
	}
	protected void reindexEntries(long companyId) throws PortalException,
    SystemException {

		final Collection<Document> documents = new ArrayList<Document>();
		
		ActionableDynamicQuery actionableDynamicQuery = new SuburItemActionableDynamicQuery() {
		
		    @Override
		    protected void addCriteria(DynamicQuery dynamicQuery) {
		    }
		
		    @Override
		    protected void performAction(Object object) throws PortalException {
		    	SuburItem item = (SuburItem) object;
		
		            Document document = getDocument(item);
		
		            documents.add(document);
		    }
		
		};
		
		actionableDynamicQuery.setCompanyId(companyId);
		
		actionableDynamicQuery.performActions();
		
		SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId,documents,true);
		}
	@Override
	protected String getPortletId(SearchContext arg0) {
		
		return PORTLET_ID;
	}

}
