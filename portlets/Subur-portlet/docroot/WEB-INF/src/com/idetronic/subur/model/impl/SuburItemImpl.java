/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.idetronic.subur.model.impl;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.idetronic.subur.model.Author;
import com.idetronic.subur.model.ItemType;
import com.idetronic.subur.search.SuburSearchUtil;
import com.idetronic.subur.service.AuthorLocalServiceUtil;
import com.idetronic.subur.service.ItemAuthorLocalServiceUtil;
import com.idetronic.subur.service.ItemItemTypeLocalServiceUtil;
import com.idetronic.subur.util.SuburUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncStringWriter;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * The extended model implementation for the SuburItem service. Represents a row in the &quot;item&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.model.SuburItem} interface.
 * </p>
 *
 * @author Mazlan Mat
 */
public class SuburItemImpl extends SuburItemBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a subur item model instance should use the {@link com.idetronic.subur.model.SuburItem} interface instead.
	 */
	
	private static Log logger = LogFactoryUtil.getLog(SuburItemImpl.class);
	
	private String _metadataValue = null;
	private Document _metadataDoc = null;
	private boolean _isEmptyMetadata = false;
	private String[] _otherTitles = null;
	private Map<String,String> _seriesReportNo = null;
	private Map<String,String> _identifierMap = null;
	
	public SuburItemImpl() {
	}
	
	public void setSeriesReportNo(Map<String,String> entryMap)
	{
		_seriesReportNo = entryMap;
		buildMetadataValue();
	}
	public void setIdentifier(Map<String,String> identifierMap)
	{
		_identifierMap = identifierMap;
		buildMetadataValue();
	}
	public void setOtherTitle(String[] otherTitle)
	{
		this._otherTitles = otherTitle;
		buildMetadataValue();
	}
	public String getMetadataValue()
	{
		_metadataValue = super.getMetadataValue();
		if (_metadataValue == null || _metadataValue.equals(StringPool.BLANK))
			buildMetadataValue();
		super.setMetadataValue(_metadataValue);
		return _metadataValue;
	}
	/**
	 * Build xml for extra metadata/ or data that has multi value
	 */
	private void buildMetadataValue()
	{
		String xml = StringPool.BLANK;
		XMLStreamWriter xmlStreamWriter = null;
		
		UnsyncStringWriter unsyncStringWriter = new UnsyncStringWriter();
		XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
		
		
		try {
			xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(
					unsyncStringWriter);
			xmlStreamWriter.writeStartDocument();
			xmlStreamWriter.writeStartElement("root");
			
			//othertitle
			
			xmlStreamWriter.writeStartElement("otherTitles");
			if (_otherTitles != null)
			{
			
				for (String otherTitle: _otherTitles)
				{
					
					if (otherTitle != null && !otherTitle.isEmpty())
					{
						
						xmlStreamWriter.writeStartElement("title");
						xmlStreamWriter.writeCharacters(otherTitle);
						xmlStreamWriter.writeEndElement();
					}
				}
				
			}
			xmlStreamWriter.writeEndElement(); //other Title
			
			//series report no
			xmlStreamWriter.writeStartElement("series");
			if (_seriesReportNo != null)
			{
				
				//access via new for-loop
				for(Object serie : _seriesReportNo.keySet()) {
				    String reportNo = (String)_seriesReportNo.get(serie);
				    if (reportNo != null && !reportNo.isEmpty())
				    {
					    xmlStreamWriter.writeStartElement("serie");
					    
					    xmlStreamWriter.writeStartElement("serieName");
					    xmlStreamWriter.writeCharacters(serie.toString());
					    xmlStreamWriter.writeEndElement();
					    
					    xmlStreamWriter.writeStartElement("reportNo");
					    xmlStreamWriter.writeCharacters(reportNo);
					    xmlStreamWriter.writeEndElement();
					   
					    xmlStreamWriter.writeEndElement();
				    }
				}
				
				
			} //end series report no
			xmlStreamWriter.writeEndElement();
			
			//identifier
			//series report no
			xmlStreamWriter.writeStartElement("identifiers");
			if (_identifierMap != null)
			{
				
				//access via new for-loop
				for(String identName : _identifierMap.keySet()) 
				{
				    String identValue = (String)_identifierMap.get(identName);
				    if (identName != null && !identName.isEmpty())
				    {
					    xmlStreamWriter.writeStartElement("ident");
					    
					    xmlStreamWriter.writeStartElement("type");
					    xmlStreamWriter.writeCharacters(identName);
					    xmlStreamWriter.writeEndElement();
					    
					    xmlStreamWriter.writeStartElement("value");
					    xmlStreamWriter.writeCharacters(identValue);
					    xmlStreamWriter.writeEndElement();
					   
					    xmlStreamWriter.writeEndElement();
				    }
				}
				
				
			} 
			xmlStreamWriter.writeEndElement();
				
			
			//end identifier
			
			
			
			xmlStreamWriter.writeEndDocument();
			
			
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_metadataValue = unsyncStringWriter.toString();
		super.setMetadataValue(_metadataValue);
		logger.info(unsyncStringWriter.toString());
		
		
		
	}
	
	public Map<String,String> getIdentifiers () throws SAXException, IOException, ParserConfigurationException
	{
		if (_metadataDoc == null)
			buildDom();
		if (_isEmptyMetadata)
			return null;
		
		Element docElements = _metadataDoc.getDocumentElement();
		
		NodeList identifierNodeList = docElements.getElementsByTagName("ident");//.item(0).getChildNodes();
		
		Map<String,String> identifierMap = null;
		if (identifierNodeList != null && identifierNodeList.getLength() > 0)
		{
			identifierMap = new HashMap<String,String>();
			for (int i=0; i < identifierNodeList.getLength();i++)
			{
				Node node = identifierNodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE)
				{
					
						Element eElement = (Element) node;
						String identName = eElement.getElementsByTagName("type").item(0).getTextContent();
						String identValue = eElement.getElementsByTagName("value").item(0).getTextContent();
						identifierMap.put(identName, identValue);
					
				}
			
			}
		
		}

		return identifierMap;
		
	}
	
	public Map getSeriesReportNo() throws SAXException, IOException, ParserConfigurationException
	{
		if (_metadataDoc == null)
			buildDom();
		if (_isEmptyMetadata)
			return null;
		
		Element docElements = _metadataDoc.getDocumentElement();
		
		NodeList seriesReportNoNodes = docElements.getElementsByTagName("serie");//.item(0).getChildNodes();
		/*
		NodeList seriesReportNoNodeList = null;
		if (seriesReportNoNodes != null && seriesReportNoNodes.getLength() > 0)
		{
			seriesReportNoNodeList = seriesReportNoNodes.item(0).getChildNodes();
		}else
		{
			return null;
		} */
		Map<String,String> seriesReportNoMap = null;
		if (seriesReportNoNodes != null && seriesReportNoNodes.getLength() > 0)
		{
			seriesReportNoMap = new HashMap();
			for (int i=0; i < seriesReportNoNodes.getLength();i++)
			{
				Node node = seriesReportNoNodes.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE)
				{
					Element eElement = (Element) node;
					String serie = eElement.getElementsByTagName("serieName").item(0).getTextContent();
					String reportNo = eElement.getElementsByTagName("reportNo").item(0).getTextContent();
					seriesReportNoMap.put(serie, reportNo);
				}
				
				
				
			}
		
			
		}

		return seriesReportNoMap;
		
	}
	public String[] getOtherTitles() throws SAXException, IOException, ParserConfigurationException
	{
		String[] otherTitle = null;
		
		if (_metadataDoc == null)
			buildDom();
		
		if (_isEmptyMetadata)
			return null;
		
		Element docElements = _metadataDoc.getDocumentElement();
	
		
		NodeList otherTitleNodes = docElements.getElementsByTagName("title");//.item(0).getChildNodes();
		
		
		
		logger.info("length="+otherTitleNodes.getLength());
		
		if (otherTitleNodes != null && otherTitleNodes.getLength() > 0)
		{
			otherTitle = new String[otherTitleNodes.getLength()];
			for (int i=0; i < otherTitleNodes.getLength();i++)
			{
				Node node = otherTitleNodes.item(i);
				otherTitle[i] = node.getTextContent();
				/*
				if (node.getNodeType() == Node.ELEMENT_NODE)
				{
					Element eElement = (Element) node;
					otherTitle[i] = eElement.getElementsByTagName("title").item(0).getTextContent();
					logger.info("title= "+eElement.getElementsByTagName("title").item(0).getTextContent());
				}*/
					
			}
		}
		return otherTitle;

		
	}
	private void buildDom() throws SAXException, IOException, ParserConfigurationException
	{
		String xml = getMetadataValue();
		
		if (xml == null || xml.equalsIgnoreCase(StringPool.BLANK) || xml.length() == 0)
		{
			_isEmptyMetadata = true;
			return;
		}
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = dbf.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(xml));
		logger.info(xml);
		_metadataDoc = docBuilder.parse(is);
		
		//Element docElements = doc.getDocumentElement();
		
		
	}
	/**
	 * 
	 */
	public String getSearchDescription()
	{
		String authorDescription = "Author :".concat(StringPool.SPACE);
		long[] authorIds;
		try {
			authorIds = ItemAuthorLocalServiceUtil.getAuthorId(getItemId());
			List<Author> authors = AuthorLocalServiceUtil.getAuthors(authorIds);
			for (Author author: authors)
			{
				
				authorDescription = authorDescription.concat(SuburUtil.getName(author.getFirstName(), author.getLastName()));
				authorDescription = authorDescription.concat(StringPool.SPACE);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return StringPool.BLANK;
		}
		
		
		return (authorDescription);
	}
	public List<ItemType> getItemTypes() throws SystemException
	{
		return ItemItemTypeLocalServiceUtil.getByItemId(getItemId());
		
	}
	
}