package com.idetronic.subur.search;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.service.ItemAuthorLocalService;
import com.idetronic.subur.search.SuburItemQuery;
import com.idetronic.subur.util.SuburConstant;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.StringQueryFactoryUtil;
import com.liferay.portal.kernel.search.TermQuery;
import com.liferay.portal.kernel.search.TermQueryFactoryUtil;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

public class SuburSearchUtil {
	
	private static Log logger = LogFactoryUtil.getLog(SuburSearchUtil.class);
	
	private static String keywords = StringPool.BLANK;
	private static String author =StringPool.BLANK;
	private static String title = StringPool.BLANK;
	private static String yearPublished = StringPool.BLANK;
	private static String monthPublished = StringPool.BLANK;
	private static String andOperator;
	private static boolean advanceSearch;
	private static boolean matchAllField;
	private static String authorFirstName;
	private static String authorLastName;
	private static long itemType;
	
	private static long[] anyTagIds = new long[0];
	private static long[] allTagIds = new long[0];
	private static long[] anyCategoryIds = new long[0];
	private static long[] allCategoryIds = new long[0];
	private static long[] allItemTypeIds = new long[0];
	private static long[] anyItemTypeIds = new long[0];
	private static boolean visible = true;
	
	private static String className = SuburItem.class.getName();
	
	
	public Hits search(SuburItemQuery itemQuery)
	{
		getSearchParams(itemQuery);
		
		return null;
	}
	
	private static String buildQuery(SuburItemQuery itemQuery)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("+(entryClassName:").append(className).append(") ");
		
		if (itemQuery.getAnyTagIds().length > 0) {
			sb.append("+(assetTagIds:");
			for (int i = 0; i < itemQuery.getAnyTagIds().length ; i++)
			{
				sb.append(itemQuery.getAnyTagIds()[i]);
				if (i+1 < itemQuery.getAnyTagIds().length)
					sb.append(" assetTagIds:");
				
			}
			sb.append(") ");

		}
		if (itemQuery.getAnyCategoryIds().length > 0)
		{
			sb.append("+(assetCategoryIds:");
			for (int i = 0; i < itemQuery.getAnyCategoryIds().length ; i++)
			{
				sb.append(itemQuery.getAnyCategoryIds()[i]);
				if (i+1 < itemQuery.getAnyCategoryIds().length)
					sb.append(" assetCategoryIds:");
				
			}
			sb.append(") ");
			
			
		}
		
		if (itemQuery.getAllCategoryIds().length > 0)
		{
			sb.append("+(assetCategoryIds:");
			for (int i = 0; i < itemQuery.getAllCategoryIds().length ; i++)
			{
				sb.append(itemQuery.getAllCategoryIds()[i]);
				if (i+1 < itemQuery.getAllCategoryIds().length)
					sb.append(" +assetCategoryIds:");
			}
			sb.append(") ");
			
			
		}
		//all tags
		if (itemQuery.getAllTagIds().length > 0) {
			sb.append("+(assetTagIds:");
			for (int i = 0; i < itemQuery.getAllTagIds().length ; i++)
			{
				sb.append(itemQuery.getAllTagIds()[i]);
				if (i+1 < itemQuery.getAllTagIds().length)
					sb.append(" +assetTagIds:");
			}
			sb.append(") ");

		}
		//any item types
		
		if (itemQuery.getAnyItemTypeIds().length>0)
		{
			sb.append("+(itemType:");
			for (int i = 0; i < itemQuery.getAnyItemTypeIds().length; i++)
			{
				sb.append(itemQuery.getAnyItemTypeIds()[i]);
				if (i+1 < itemQuery.getAnyItemTypeIds().length )
					sb.append(" itemType:");
			}
			sb.append(") ");
		}
		//all item Type
		if (itemQuery.getAllItemTypeIds().length > 0)
		{
			sb.append("+(itemType:");
			for (int i = 0; i < itemQuery.getAllItemTypeIds().length; i++)
			{
				sb.append(itemQuery.getAllItemTypeIds()[i]);
				if (i+1 < itemQuery.getAllItemTypeIds().length )
					sb.append(" itemType:");
			}
			sb.append(") ");
		}
		//year published
		if (itemQuery.getYearPublished() > 0)
		{
			sb.append("+(yearAdded:"+ itemQuery.getYearPublished() + ") ");
		}
		if (!itemQuery.getAuthorFirstName().isEmpty())
		{
			sb.append("+(authorFirstName:"+ StringUtil.toLowerCase(itemQuery.getAuthorFirstName()) + "*) ");
		}
		
		return sb.toString();
		//itemType = itemQuery.
	}
	
	/**
	 * Build lucene query syntax based on the request params
	 * @param request
	 * @param searchContext
	 * @return
	 */
	public static Query buildSearchQuery(HttpServletRequest request, SearchContext searchContext)
	{
		getSearchParams(request);
		
		
		//String z = sb.toString();
		//logger.info(z);
		//String z = "+(entryClassName:com.idetronic.subur.model.SuburItem) +(authorFirstName:{mazlan* zzz*}authorLastName:jongk* )";
		//return StringQueryFactoryUtil.create(z);
		return StringQueryFactoryUtil.create(buildQuery());
	}
	public static Query buildSearchQuery(SuburItemQuery itemQuery)
	{
		getSearchParams(itemQuery);
		return StringQueryFactoryUtil.create(buildQuery());
	}
	
	private static void getSearchParams(HttpServletRequest request)
	{
		keywords = ParamUtil.getString(request, "keywords");
		author = ParamUtil.getString(request,"author");
		title = ParamUtil.getString(request,"title");
		yearPublished = ParamUtil.getString(request,"year");
		andOperator = ParamUtil.getString(request,"andOperator");
		advanceSearch = ParamUtil.getBoolean(request, "advancedSearch");
		matchAllField = Validator.equals(andOperator, "1");
		authorFirstName = ParamUtil.getString(request,"authorFirstName");
		authorLastName = ParamUtil.getString(request,"authorLastName");
		itemType = ParamUtil.getLong(request, SuburDisplayTerms.ITEM_TYPE);
		String itemTypeString = ParamUtil.getString(request, SuburConstant.FIELD_ITEM_TYPE);
		
		logger.info("it="+itemType + "::"+itemTypeString);
		if (!itemTypeString.equals("0"))
			buildItemTypeIdParam(itemTypeString);
		
		
		
		
	}
	private static void buildItemTypeIdParam(String itemTypeString)
	{
		List<Long> itemtypeIdList = new ArrayList<Long>();
		String[] itemTypes = StringUtil.split(itemTypeString);
		
		if (itemTypes.length > 0)
		{
			for(String itemType : itemTypes) {
			  	long id = Long.parseLong(itemType);
			  	if (id != 0L) {
			  		itemtypeIdList.add(id);
			  	}
			}
		}
		
		
		
		if (matchAllField)
			allItemTypeIds = ArrayUtil.toLongArray(itemtypeIdList);
		else
			anyItemTypeIds = ArrayUtil.toLongArray(itemtypeIdList);
	}
	private static void getSearchParams(SuburItemQuery itemQuery)
	{
		keywords = itemQuery.getKeywords();
		title = itemQuery.getTitle();
		yearPublished = String.valueOf(itemQuery.getYearPublished());
		authorFirstName = itemQuery.getAuthorFirstName();
		authorLastName = itemQuery.getAuthorLastName();
		anyItemTypeIds = itemQuery.getAnyItemTypeIds();
		allItemTypeIds = itemQuery.getAllItemTypeIds();
		anyTagIds = itemQuery.getAnyTagIds();
		allTagIds = itemQuery.getAllTagIds();
		anyCategoryIds = itemQuery.getAnyCategoryIds();
		allCategoryIds = itemQuery.getAllCategoryIds();
		visible = itemQuery.isVisible();
	}
	
	private static String buildQuery()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("+(entryClassName:").append(className).append(") ");
		if (Validator.isNotNull(authorFirstName) || Validator.isNotNull(authorLastName)
				|| Validator.isNotNull(title) || Validator.isNotNull(yearPublished)
				|| allItemTypeIds.length > 0 || anyItemTypeIds.length > 0 )

		{
			stringBuilder.append("+(");
			stringBuilder.append(buildAllCriteria());
			stringBuilder.append(")");
			
		}
		logger.info(stringBuilder.toString());
		return stringBuilder.toString();
		
	
	}
	private static String buildAllCriteria()
	{
		String[] fieldArray  = {Field.TITLE,
				SuburConstant.FIELD_AUTHOR_FIRST_NAME,
				SuburConstant.FIELD_AUTHOR_LAST_NAME,
				SuburConstant.FIELD_YEAR,
				SuburConstant.FIELD_ITEM_TYPE,
				SuburConstant.FIELD_MONTH,
				Field.ASSET_CATEGORY_ID,
				Field.ASSET_TAG_IDS,
				Field.GROUP_ID,
				Field.VIEW_COUNT
		};
		
		
		String query = StringPool.BLANK;
		for (String field : fieldArray)
		{
			query = query.concat(buildFieldCriteria(field));
		}
		logger.info(query);
		return query;
	}
	private static String buildFieldCriteria(String fieldName)
	{
		
		String qry = matchAllField ? "+".concat(fieldName).concat(":") : " "+ fieldName.concat(":");
		logger.info(matchAllField+ fieldName + " :: "+ qry);
		
		
		if (fieldName.equals(Field.TITLE))
		{
			if (Validator.isNull(title))
				return StringPool.BLANK;
			else
				qry = qry.concat(handleStringTerm(title).concat(StringPool.SPACE));

		}
		else if (fieldName.equalsIgnoreCase(SuburConstant.FIELD_AUTHOR_FIRST_NAME))
		{
			if (Validator.isNull(authorFirstName))
			{
				qry = StringPool.BLANK;
				
			}else {
				
				qry = qry.concat(handleStringTerm(authorFirstName).concat(StringPool.SPACE));
				//qry = qry.concat(StringUtil.toLowerCase(suffixWithStar(authorFirstName)).concat(StringPool.PLUS).concat("zzz*"));
				
			}
		}else if (fieldName.equalsIgnoreCase(SuburConstant.FIELD_AUTHOR_LAST_NAME))
		{
			if (Validator.isNull(authorLastName))
				qry = StringPool.BLANK;
			else
				qry = qry.concat(handleStringTerm(authorLastName).concat(StringPool.SPACE));
			
		}else if (fieldName.equalsIgnoreCase(SuburConstant.FIELD_YEAR))
		{
			if (Validator.isNull(yearPublished))
				qry =  StringPool.BLANK;
			else
				qry = qry.concat(yearPublished).concat(StringPool.SPACE);
			
		}else if (fieldName.equalsIgnoreCase(SuburDisplayTerms.ITEM_TYPE))
		{
			logger.info("ixx");
			if (itemType > 0)
				qry = qry.concat(String.valueOf(itemType)).concat(StringPool.SPACE);
			else
				qry =  StringPool.BLANK;
					
		}else if (fieldName.equals(Field.ASSET_CATEGORY_IDS))
			qry = buildAnyAllCriteria(allCategoryIds,anyCategoryIds,Field.ASSET_CATEGORY_IDS);//   buildAssetCategoryIdsCriteria();
		else if (fieldName.equals(Field.ASSET_TAG_IDS))
			qry = buildAnyAllCriteria(anyTagIds,allTagIds,Field.ASSET_TAG_IDS);
		else if (fieldName.equals(SuburConstant.FIELD_ITEM_TYPE))
			qry = buildAnyAllCriteria(anyItemTypeIds,allItemTypeIds,SuburConstant.FIELD_ITEM_TYPE);
		else
			qry = StringPool.BLANK;
		
		
		logger.info(qry);
		return qry;
		
		
	}
	
	private static String buildAnyAllCriteria(long[] anyIds,long[] allIds,String fieldName)
	{
		StringBuilder sb = new StringBuilder();
		if (anyIds.length > 0)
		{
			for (int i = 0; i < anyIds.length; i++)
			{
				sb.append(fieldName);
				sb.append(CharPool.SEMICOLON);
				sb.append(anyIds[i]);
				sb.append(CharPool.SPACE);
				
			}
		}
		if (allIds.length > 0)
		{
			for (int i = 0; i < allIds.length; i++)
			{
				sb.append(CharPool.PLUS);
				sb.append(fieldName);
				sb.append(CharPool.SEMICOLON);
				sb.append(allIds[i]);
				sb.append(CharPool.SPACE);
				
			}
		}
		
		return sb.toString();
		
	}
	private static String handleStringTerm(String term)
	{
		return suffixWithStar(handleSpace(term)).toLowerCase();
	}
	private static String handleSpace(String criteria)
	{
		criteria = criteria.replace(CharPool.SPACE, CharPool.QUESTION);
		return criteria;
	}
	public static String suffixWithStar(String value)
	{
		if (StringUtil.endsWith(value, StringPool.STAR))
			return value;
		else
			return value.concat(StringPool.STAR);
				
	}
}
