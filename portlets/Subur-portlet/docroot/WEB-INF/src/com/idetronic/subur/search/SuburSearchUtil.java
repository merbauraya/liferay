package com.idetronic.subur.search;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.service.ItemAuthorLocalService;
import com.idetronic.subur.util.SuburConstant;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.StringQueryFactoryUtil;
import com.liferay.portal.kernel.search.TermQuery;
import com.liferay.portal.kernel.search.TermQueryFactoryUtil;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

public class SuburSearchUtil {
	
	private static Log logger = LogFactoryUtil.getLog(SuburSearchUtil.class);
	
	private static String keywords;
	private static String author;
	private static String title;
	private static String yearPublished;
	private static String andOperator;
	private static boolean advanceSearch;
	private static boolean matchAllField;
	private static String authorFirstName;
	private static String authorLastName;
	private static String className = SuburItem.class.getName();
	
	
	
	public static Query buildSearchQuery(HttpServletRequest request, SearchContext searchContext)
	{
		getSearchParams(request);
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
		logger.info("xx="+andOperator);
		
	}
	
	private static String buildQuery()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("+(entryClassName:").append(className).append(") ");
		if (Validator.isNotNull(authorFirstName) || Validator.isNotNull(authorLastName)
				|| Validator.isNotNull(title) || Validator.isNotNull(yearPublished))

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
				SuburConstant.FIELD_YEAR
				
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
		
		String qry = matchAllField ? "+".concat(fieldName).concat(":") : fieldName.concat(":");
		logger.info(matchAllField+ fieldName + " :: "+ qry);
		
		
		if (fieldName.equals(Field.TITLE))
		{
			if (Validator.isNull(title))
				return StringPool.BLANK;
			else
				qry = qry.concat(StringUtil.toLowerCase(suffixWithStar(title)).concat(StringPool.SPACE));

		}
		else if (fieldName.equalsIgnoreCase(SuburConstant.FIELD_AUTHOR_FIRST_NAME))
		{
			if (Validator.isNull(authorFirstName))
			{
				qry = StringPool.BLANK;
				
			}else {
				
				qry = qry.concat(StringUtil.toLowerCase(suffixWithStar(authorFirstName)).concat(StringPool.SPACE));
				
			}
		}else if (fieldName.equalsIgnoreCase(SuburConstant.FIELD_AUTHOR_LAST_NAME))
		{
			if (Validator.isNull(authorLastName))
				qry = StringPool.BLANK;
			else
				qry = qry.concat(StringUtil.toLowerCase(suffixWithStar(authorLastName)).concat(StringPool.SPACE));
			
		}else if (fieldName.equalsIgnoreCase(SuburConstant.FIELD_YEAR))
		{
			if (Validator.isNull(yearPublished))
				qry =  StringPool.BLANK;
			else
				qry = qry.concat(yearPublished).concat(StringPool.SPACE);
			
		}
		
		
		logger.info(qry);
		return qry;
		
		
	}
	public static String suffixWithStar(String value)
	{
		if (StringUtil.endsWith(value, StringPool.STAR))
			return value;
		else
			return value.concat(StringPool.STAR);
				
	}
}
