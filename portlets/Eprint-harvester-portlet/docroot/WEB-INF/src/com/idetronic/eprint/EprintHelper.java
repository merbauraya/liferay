package com.idetronic.eprint;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.io.File;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.common.base.Strings;
import com.google.common.collect.Multimap;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


public class EprintHelper {
	private static HashMap _data;
	private static Multimap _dataIndex;
	static Log log = LogFactoryUtil.getLog(EprintHelper.class);
	private static String filePath;
	private static BufferedWriter writer;
	private static int _level = -1;
	private static int _nodeCount = 0;
	private static int _nodeSize;
	public static void buildBrowseBySubject(HashMap data, Multimap dataIndex,String portletPath)
	{
		
		filePath = portletPath;
		_data = data;
		_dataIndex = dataIndex;
		
		writer = getWriter();
		_level =1;
		_nodeSize = data.size();
		log.info("size="+_nodeSize);
		if (dataIndex.size()==0)
		{
			writeNotData(writer);
			
		}else
		{
			writeTreeParent(writer);
			displayChildNode("ROOT",0);
			writeCloseTreeParent();
		}
		
		
		try
		{
			writer.close();
		}catch (IOException e)
		{
			log.error(e);
		}
	}
	private static void displayChildNode(String parentId,int level)
	{
		
		_nodeCount++;
		if (_dataIndex.containsKey(parentId))
		{
			Collection<String> dtParent = _dataIndex.get(parentId);
			//no more child
			if (dtParent.size() == 0)
			{
				writeClosingNode();
				
			}
			for (Iterator<String> iter = dtParent.iterator(); iter.hasNext();)
			{
				String subjectId = iter.next();
				ArrayList<String> record =(ArrayList<String>) _data.get(subjectId);
				//log.info(Strings.repeat("-",level) + record.get(2));
				if (parentId.equalsIgnoreCase("ROOT"))
					writeTopRootNode(record.get(2));
				else
					writeChildNode(record.get(2),level+1);
				displayChildNode(subjectId,level+1);
			}
		}else
		{
			//log.info("no key="+parentId);
			writeClosingChild();
			log.info("counter="+_nodeCount);
			if (_nodeCount > _nodeSize)
				writeClosingLastNode(level);
		}
	}
	private static void writeClosingLastNode(int level)
	{
		log.info("writeClosingLastNode lvl="+ level);
		closeTag("li");
		closeTag("ul");
		//here hack to close content node
		switch (level)
		{
		case 4:
			writeClosingLevel();
			closeTag("ul");
			writeClosingLevel();
			
			break;
		case 3:
			break;
		case 2:
			break;
		}
		
		
	}
	private static void writeClosingLevel()
	{
		log.info("writeClosingLevel");
		closeTag("div");
		closeTag("div");
		closeTag("li");
	}
	private static void writeClosingChild()
	{
		log.info("writeCLosingChild");
		writeContent("</div></div>");
		
	}
	
	private static void writeClosingNode()
	{
		log.info("writeClosingNode");
		closeTag("li");
		closeTag("ul");
		closeTag("div");
		closeTag("div");
		closeTag("li");
		
	}
	private static void writeChildNode(String nodeName,int level)
	{
		if (_level > level)
			writeClosingNode();
		
		log.info("writenode= "+ nodeName + "_level=" + _level+" level="+ level);
		if (_level < level)
			openTag("ul");
		if (_level == level)
			closeTag("li");
		try {
			
			writer.write("<li>");
			writer.write("<h5 class='h'>");
			writer.write("<a class='trigger open' href='#'>");
			writer.write(nodeName);
			writer.write("</a></h5>");
			writer.write("<div class='outer shown ep-level" +level+"'>");
			writer.write("<div class='inner shown'>");
			
			
			
			
		}catch (IOException  e)
		{
			log.error(e);
		}
		_level = level;
	}
	private static void writeTreeParent(BufferedWriter writer)
	{
		try
		{
			writer.write("<ul id='ep-accl' class='accordion'>");
			writer.write("<li>");
			
		}catch (IOException e)
		{
			log.equals(e);
		}
	}
	private static void openTag(String tagName)
	{
		writeContent("<"+tagName + ">");
	}
	private static void writeCloseTreeParent()
	{
		log.info("writeclosetreeparent");
		writeContent("<!--closing root node-->");
		closeTag("ul");
		closeTag("div");
		closeTag("div");
		
		closeTag("li");
		closeTag("ul");
	}
	private static void writeTopRootNode(String nodeName)
	{
		try {
			writer.write("<h4 class='h'>");
			writer.write("<a class='trigger open' href='#'>");
			writer.write(nodeName);
			writer.write("</a>");
			writer.write("</h4>");
			writer.write("<div class='outer shown ep-level1' style='display block'>");
			writer.write("<div class='inner shown'>");
			
			
			
			
		}catch (IOException e)
		{
			log.error(e);
		}
	}
	private static void writeNotData(BufferedWriter writer)
	{
		try
		{
			writer.write("<div class='alert alert-info'>");
			writer.write("<strong> No data</strong>");
			writer.write("</div>");
			
		}catch (IOException e)
		{
			log.error(e);
		}
		
	}
	private static BufferedWriter getWriter()
	{
		BufferedWriter bw = null;
		try
		{
			File file = new File(filePath + EprintConstant.FILE_BY_SUBJECT2);
			log.info(filePath + EprintConstant.FILE_BY_SUBJECT2);
			if (!file.exists())
				file.createNewFile();
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			
			
		} catch (IOException e)
		{
			log.error(e);
			
		}
		return bw;
	}
	private static void closeTag(String tagName)
	{
		log.info("closing "+ tagName);
		writeContent("</"+ tagName + ">");
	}
	private static void writeContent(String content)
	{
		try
		{
			writer.write(content);
		}catch (IOException e)
		{
			log.error(e);
		}
		
	}

}
