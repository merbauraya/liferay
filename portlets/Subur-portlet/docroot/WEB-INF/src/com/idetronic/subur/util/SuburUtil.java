package com.idetronic.subur.util;

import com.idetronic.subur.Subur;
import com.idetronic.subur.service.DivisionLocalServiceUtil;
import com.idetronic.subur.service.MetadataValueLocalServiceUtil;
import com.idetronic.subur.service.SuburItemLocalServiceUtil;
import com.idetronic.subur.model.Division;
import com.idetronic.subur.model.MetadataValue;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portlet.asset.service.persistence.AssetCategoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.idetronic.subur.service.MetadataPropertyValueLocalServiceUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.jsp.JspWriter;

public class SuburUtil {
	
	private static Log logger = LogFactoryUtil.getLog(SuburUtil.class);
	public List getAdditionalMetadata()
	{
		List metadata = MetadataPropertyValueLocalServiceUtil.getAdditionalMetadata(0);
		return metadata;
	}
	
	
	public List getAuthor(long itemId)
	{
		DynamicQuery authorQuery = DynamicQueryFactoryUtil.forClass(
				 MetadataValue.class, PortletClassLoaderUtil.getClassLoader());
		
		//authorQuery.add(PropertyFactoryUtil.forName(propertyName))
		//List<Object> authors = MetadataValueLocalServiceUtil.
		return null;
	}
	public static String getName(String firstName,String lastName)
	{
		if (Validator.isBlank(lastName) || Validator.isNull(lastName))
		{
			return lastName +",";
		}else
		{
			return lastName + "," + firstName;
		}
	}
	public static String getFirstName(String name)
	{
		Collections.emptyList();
		if (Validator.isBlank(name) || Validator.isNull(name))
		{
			
			return StringPool.BLANK;
		}
		if (name.equals(","))
			return StringPool.BLANK;
		logger.info("name="+name);
		String[] names = name.split(",");
		if (names.length < 2)
			return StringPool.BLANK;
		logger.info("length="+names.length);
		return names[1];
		
	}
	public static String getLastName(String name)
	{
		if (Validator.isBlank(name))
			return StringPool.BLANK;
		if (name.equals(","))
			return StringPool.BLANK;
		String[] names = name.split(",");
		if (names.length < 2)
			return StringPool.BLANK;
		return names[0];
		
	}
	
	
	public static String getItemTypeText(long itemId)
	{
		return StringPool.BLANK;
		
	}
	public static TreeNode<Division> showDivisionTree(JspWriter out,
			long divisionId) throws SystemException, IOException
	{
		long rootKey = 0;
		List<Division> divisions = DivisionLocalServiceUtil.findAll();
		
		
		
		HashMap<Long,Division> divs = new HashMap<Long,Division>();
		HashMap<Long,TreeNode> nodes = new HashMap<Long,TreeNode>();
		
        Map<Long, List<Division>> m = new LinkedHashMap<Long, List<Division>>();
        
        Map<Long, TreeNode> k = new LinkedHashMap<Long, TreeNode>();
        TreeNode<Division> rootNode;
        
		
		
		
		//map parent to child
		for(Division division: divisions)
		{
			List<Division> div = m.get(division.getParentId());
			divs.put(division.getDivisionId(), division);//  = m.get(division.getParentId());
			
			if (division.getParentId() ==0)
			{
				logger.info("found root");
				rootKey = division.getDivisionId();
				rootNode = new TreeNode(division);
				nodes.put(division.getDivisionId(), rootNode);
				
			}
			else
			{
				Division parent = divs.get(division.getParentId());
				TreeNode parentNode = nodes.get(division.getParentId());
				TreeNode node = new TreeNode(division);
				parentNode.addChild(node);
				nodes.put(division.getDivisionId(), node);
				//logger.info(division.getDivisionId());
				
			}
			
			if (div == null)
			{
				m.put(division.getParentId(), div=new ArrayList<Division>());
			}
			div.add(division);
			
		}
		
		TreeNode returnNode = nodes.get(rootKey);
		
		buildOrder(out, returnNode,divisionId,0);
		
		
		
		
		return returnNode;
	}
	private static void buildOrder(JspWriter out,TreeNode<Division> node,
			long divisionId,int level) throws IOException
	{
		
		Division div = node.data;
		String divName = StringPool.BLANK;
		for (int i=0;i<level*2;i++)
			divName = divName + "&nbsp;";
		
		divName=divName + div.getDivisionName();
		
		if (!div.isDepositable())
		{
			out.print("<optgroup label=\""+divName+"\">");
		}else
		{
			String selected = StringPool.BLANK;
			if (Validator.equals(divisionId, div.getDivisionId()))
				selected = "selected";
			out.print("<option value='"+div.getDivisionId()+"' " +selected + ">"+divName+"</option>");
		}
			
		//logger.info(level + " ::" + div.getDivisionId() + " :: " + div.getDivisionName());
		for (int i = 0;i<node.getNumberOfChildren();i++)
				{
					buildOrder(out,node.getChildAt(i),divisionId,level+1);
				}
		
		if (!div.isDepositable())
			out.print("</optgroup>");
	}
	public static int countAssetVocabularyById(long vocabularyId) throws SystemException
	{
		return  SuburItemLocalServiceUtil.countAssetVocabularyById(vocabularyId);
	}

}
