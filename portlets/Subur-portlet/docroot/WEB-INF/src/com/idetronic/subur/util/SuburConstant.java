package com.idetronic.subur.util;

import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.service.persistence.AuthorFinderImpl;
import com.idetronic.subur.service.persistence.SuburItemFinderImpl;
import com.idetronic.subur.service.persistence.ItemItemTypeFinderImpl;
import com.idetronic.subur.service.persistence.MetadataPropertyValueFinder;
import com.idetronic.subur.service.persistence.MetadataPropertyValueFinderImpl;

public class SuburConstant {
	
	/* Class Name */
	public static String getClassName()
	{
		return SuburItem.class.getName();
	}
	
	/* Folder Constant */
	public static String SUBUR_ROOT_FOLDER="Subur";
	
	/* Metadata Constant */
	public static long METADATA_CONTRIBUTOR_AUTHOR = 3;
	public static long METADATA_CONTRIBUTOR_ADVISOR = 2;
	public static long METADATA_CONTRIBUTOR_EDITOR = 4;
	public static long METADATA_CONTRIBUTOR_ILLUSTRATOR = 5;
	public static long METADATA_CONTRIBUTOR_OTHER = 6;
	
	
	public static long METADATA_TITLE = 64;
	public static long METADATA_OTHER_TITLE = 65;
	public static long METADATA_ISSUED_DATE = 15;
	public static long METADATA_PUBLISHER= 39;
	
	public static long METADATA_ITEM_TYPE = 66;
	public static long METADATA_SUBJECT = 57;
	
	public static long METADATA_DATE_ACCESSIONED= 11;
	public static long METADATA_DATE_AVAILABLE = 12;
	
	
	public static long METADATA_DESCRIPTION_ABSTRACT = 27;
	public static long METADATA_DESCRIPTION_SPONSORSHIP = 27;
	public static long METADATA_DESCRIPTION_PROVENANCE = 28;
	
	public static long METADATA_IDENTIFIER_ISSN = 21;
	public static long METADATA_IDENTIFIER_GOVDOC = 19;
	public static long METADATA_IDENTIFIER_ISBN = 20;
	public static long METADATA_IDENTIFIER_CITATION = 18;
	public static long METADATA_IDENTIFIER_SICI = 22;
	public static long METADATA_IDENTIFIER_ISMN = 22;
	public static long METADATA_IDENTIFIER_URI = 25;
	public static long METADATA_IDENTIFIER_OTHER = 24;
	
	public static long METADATA_FORMAT_MIMETYPE = 36;
	public static long METADATA_FORMAT_MEDIUM = 35;
	public static long METADATA_FORMAT_EXTENT = 34;
	
	
	/* Subur Item Status */
	public static int STATUS_DRAFT_ITEM = 0;
	public static int STATUS_PUBLISHED_ITEM = 1;
	public static int STATUS_WITHDRAWN_ITEM = 2;
	public static int STATUS_ANY = -1;
	
	
	/* Subur page */
	public static String PAGE_UPDATE_ITEM = "/html/deposit.jsp";
	public static String PAGE_NEW_ITEM = "/html/deposit/new.jsp";
	public static String PAGE_ADMIN_ITEM = "/html/admin/subur/view.jsp";
	public static String PAGE_ADMIN_AUTHOR = "/html/admin/author/view.jsp";
	public static String PAGE_SUBUR_SEARCH = "/html/search/subur_search.jsp";
	public static String PAGE_AUTHOR_VIEW_DETAILS = "/html/author/view/jsp";
	
	
	/* webkeys
	 * 
	 */
	 public static final String DOCUMENT_LIBRARY_FILE_ENTRY = "DOCUMENT_LIBRARY_FILE_ENTRY";
	 public static final String TEMP_RANDOM_SUFFIX = "--tempRandomSuffix--";
	
	
	/* custom permission */
	 public static final String PERMISSION_MANAGE_AUTHOR = "MANAGE_AUTHOR";
	
	
	
	
	/* Custom SQL */
	public static String SQL_ITEM_AUTHOR = SuburItemFinderImpl.class.getName() + ".getItemAuthors";
	public static String SQL_ITEM_ADDITIONAL_METADATA = MetadataPropertyValueFinderImpl.class.getName() + ".getAdditionalMetadata";
	/* use this for building select list for selected item type */
	public static String SQL_ITEM_ITEMTYPE = ItemItemTypeFinderImpl.class.getName() + ".getItemType";
	/*use this for selecting item item type */
	public static String SQL_ITEM_SET_ITEMTYPE = SuburItemFinderImpl.class.getName() +".getItemType";
	public static String SQL_ITEM_DETAILS = SuburItemFinderImpl.class.getName() + ".getItemDetails";
	public static String SQL_ITEM_FILE_ENTRIES = SuburItemFinderImpl.class.getName() + ".getFileEntries";
	/* get item by subject id */
	public static String SQL_ITEMS_BY_SUBJECT_ID = SuburItemFinderImpl.class.getName() + ".getItemsBySubject";
	/* get item count by item type for any given subject id */
	public static String SQL_ITEM_COUNT_BY_ITEM_TYPE_IN_SUBJECT = SuburItemFinderImpl.class.getName()+".itemCountSubjectByItemType";
	/* get item count by author for any given subject id */
	public static String SQL_ITEM_COUNT_BY_AUTHOR_IN_SUBJECT=SuburItemFinderImpl.class.getName()+ ".itemCountSubjectByAuthor";
	/* find author by first Name */
	public static String SQL_AUTHOR_BY_FIRST_NAME = AuthorFinderImpl.class.getName()+ ".findByFirstName";
	public static String SQL_AUTHOR_FIND_BY_NAME = AuthorFinderImpl.class.getName()+  ".findByName";
	public static String SQL_AUTHOR_COUNT_BY_NAME = AuthorFinderImpl.class.getName()+ ".totalByName";
	/* search for both first name and lastname */
	public static String SQL_AUTHOR_FIND_BY_NAME_AND = AuthorFinderImpl.class.getName()+ ".byFirstNameAndLastName";
	/* result count for both first name and last name */
	public static String SQL_AUTHOR_COUNT_BY_NAME_AND = AuthorFinderImpl.class.getName()+ ".countFirstNameAndLastName";
	public static String SQL_AUTHOR_ITEM_COUNT_BY_G_C = AuthorFinderImpl.class.getName()+".countItemByGroupCompany";
	public static String SQL_AUTHOR_FIND_BY_G_C = AuthorFinderImpl.class.getName() + ".findByCompanyGroup";
	
	/* File entry Type */
	public static final int FILE_ENTRY_COVER_PAGE = 1;
	public static final int FILE_ENTRY_MAIN_DOCUMENT = 2;
	
	
	
	/* Indexer Field Constant */
	public static final String FIELD_YEAR = "yearAdded";
	public static final String FIELD_MONTH = "monthAdded";
	
	public static final String FIELD_AUTHOR = "author";
	public static final String FIELD_ITEM_TYPE="itemType";
	public static final String FIELD_AUTHOR_FIRST_NAME="authorFirstName";
	public static final String FIELD_AUTHOR_LAST_NAME = "authorLastName";
	public static final String FIELD_TITLE_SORTABLE = "title_sortable";
	public static final String FIELD_OTHER_TITLE = "otherTitle";
	
	
	/* Serve Resource Request */
	public static String RESOURCE_UPLOAD_FILE="0";
	public static String RESOURCE_AUTHOR_LOOKUP="authorLookup";
	public static String RESOURCE_ITEM_AUTHOR_LIST="itemAuthorList";
	public static String RESOURCE_SERVE_FILE="serveFile";
	
	/* view mode */
	public static String VIEW_LIST = "view-title-list";
	public static String VIEW_TABLE = "view-table-list";
	public static String VIEW_ABSTRACT = "view-abstract-list";
	
	/* DOcument Library temp folder upload */
	public static final String TEMP_UPLOAD_FOLDER = "com.idetronic.subur.Subur.TEMP";
}
