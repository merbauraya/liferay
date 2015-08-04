<%@ include file="/html/subur/init.jsp" %>
<%@page import="java.util.Arrays" %>
<%
	
	//List<ItemType> itemTypes = ItemTypeLocalServiceUtil.getItemTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	SuburItem item = (SuburItem)request.getAttribute("suburItem");
	
	//List itemItemTypes =  ItemItemTypeLocalServiceUtil.getByItemId(item.getItemId());  //ItemItemTypeLocalServiceUtil.getByItemId(item.getItemId());
	
	
	List<ItemType> itemTypes2 = ItemTypeLocalServiceUtil.getItemTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	List<ItemItemType> itemItemType2 = ItemItemTypeLocalServiceUtil.itemTypeByItemid(item.getItemId());
	
	Long[] selectedItemType = new Long[itemItemType2.size()];
	for (int i = 0; i < itemItemType2.size() ; i++)
	{
		selectedItemType[i] = itemItemType2.get(i).getItemTypeId();
		
	}
	
	
	
	
	
	//List<ItemType> itemTypes = (List)itemItemTypes.get(0);
	//List<ItemItemType> selectedItemTypes = (List)itemItemTypes.get(1);
	
	
%>
<aui:model-context bean="<%= item %>" model="<%= SuburItem.class %>" />

<aui:select size="5" multiple="<%=true %>" label="item-type" name="itemType">

	
	<%for (ItemType itemType: itemTypes2) 
	{
		boolean selected = Arrays.asList(selectedItemType).contains(new Long(itemType.getItemTypeId()));
		
		
		
	%>
		<aui:option selected="<%=selected %>" value="<%= itemType.getItemTypeId() %>">
			<%=itemType.getItemTypeName() %>
		</aui:option>
	<%
	}
	%>
</aui:select>

<aui:input type="text" name="title" cssClass="fullwidth">

</aui:input>
<aui:input cssClass="fullwidth" type="textarea" name="itemAbstract" autoSize="<%= true %>"></aui:input>
<div class="control-group">
	<aui:input type="text" cssClass="fullwidth" name="publisher"></aui:input>
</div>

<div class="control-group">
	<%
		Locale[] avilableLocales = LanguageUtil.getAvailableLocales();
		String itemLanguage = item.getLanguage();
		
	%>
	<aui:select label="language" name="language" >
		<%
			boolean NASelected = (itemLanguage.equalsIgnoreCase("NA"));
			boolean otherSelected = (itemLanguage.equalsIgnoreCase("Other"));
		%>
		
		<aui:option value="NA" selected="<%=NASelected%>">N/A</aui:option>
		
		
	<%
		for (Locale avaiableLocale : avilableLocales)	
		{
			
		    String localeId = LocaleUtil.toLanguageId(avaiableLocale);
		    boolean selected  = (itemLanguage.equalsIgnoreCase(localeId));
	%>
		<aui:option selected="<%= selected %>"  value="<%= localeId %>"><%=avaiableLocale.getDisplayName() %></aui:option>
		
		
	<%
		}
	%>
		<aui:option value="Other" selected="<%=otherSelected%>">Other</aui:option>
	</aui:select>

</div>
<%
	String[] itemIdentifierTypeList = StringUtil.split(itemIdentifier,",");
	int[] itemIdentifierIndexes = null;
	Map<String,String> identifierMap = item.getIdentifiers();
	List<String> identifierList = Collections.emptyList();
	if (identifierMap != null)
	{
		itemIdentifierIndexes = new int[identifierMap.size()];
		identifierList = new ArrayList<String>();

		int i = 0;
		for (Map.Entry<String,String> entry : identifierMap.entrySet() )
		{
			itemIdentifierIndexes[i] = i;
			identifierList.add(i, entry.getKey());
			i++;
		}
	
		
	}else
	{
		itemIdentifierIndexes = new int[]{0};
	}
	
	if (identifierList.isEmpty())
	{
		identifierList = new ArrayList<String>();
		identifierList.add(StringPool.BLANK);
		identifierMap = new HashMap<String,String>();
		identifierMap.put(StringPool.BLANK, StringPool.BLANK);
		
	}
%>
<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="suburItemIdentifiers" persistState="<%= false %>" title="item-identifier">
	<div id="itemIdentifier">
	<%
		for (int i = 0; i < itemIdentifierIndexes.length; i++)
		{
			int itemIdentiferIndex = itemIdentifierIndexes[i];
			String identName = identifierList.get(i);
			String identValue = identifierMap.get(identName);
	
	%>	
		<div class="lfr-form-row">
			<div class="row-fields">
				
				<aui:col width="<%=20 %>">
					<aui:input name='<%= "itemIdentifier" + itemIdentiferIndex %>' 
					type="hidden" value="<%= itemIdentiferIndex %>" />
				
					<aui:select cssClass="small-input" inlineField="<%= true %>" label="type" name='<%= "identName" +  itemIdentiferIndex%>'>
					<%
						for (String identTypeName : itemIdentifierTypeList) 
						{
							boolean selected = false;
							if (identTypeName.equalsIgnoreCase(identName) )
								selected = true;
					%>
						<aui:option selected="<%= selected %>"  value="<%=identTypeName %>"><%=identTypeName %></aui:option>
					<%		
						}
					%>
					</aui:select>
				</aui:col>
				<aui:col width="<%=80 %>">
					<aui:input type="text" cssClass="fullwidth" label="value"
						name='<%= "identValue" + itemIdentiferIndex  %>' 
						value="<%=identValue %>" 
					/>
				</aui:col>
					
				
			</div>
		</div>
	
	<%	
		}
	%>
	<aui:input name="itemIdentifierIndexes" type="hidden" value="<%= StringUtil.merge(itemIdentifierIndexes) %>" />
	
	</div>
</liferay-ui:panel>




<%
	int[] seriesReportNoIndexes = null;
	Map<String,String> seriesReportNoMap = item.getSeriesReportNo();
	List<String> seriesReportNoList = Collections.emptyList();
	if (seriesReportNoMap != null)
	{
		seriesReportNoIndexes = new int[seriesReportNoMap.size()];
		seriesReportNoList = new ArrayList<String>();

		int i = 0;
		for (Map.Entry<String,String> entry : seriesReportNoMap.entrySet() )
		{
			seriesReportNoIndexes[i] = i;
			seriesReportNoList.add(i, entry.getKey());
			i++;
		}
	
		
	}else
	{
		seriesReportNoIndexes = new int[]{0};
	}
	
	if (seriesReportNoList.isEmpty())
	{
		seriesReportNoList = new ArrayList<String>();
		seriesReportNoList.add(StringPool.BLANK);
		seriesReportNoMap = new HashMap();
		seriesReportNoMap.put(StringPool.BLANK, StringPool.BLANK);
		
	}
%>


<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="suburItemSeriesReportNo" persistState="<%= false %>" title="series-report-no">
	<div id="seriesReportNo">
	<%
		for (int i = 0; i < seriesReportNoIndexes.length; i++)
		{
			int serieReportNoIndex = seriesReportNoIndexes[i];
			String serie = seriesReportNoList.get(i);
			String reportNo = seriesReportNoMap.get(serie);
	
	%>
		<div class="lfr-form-row">
			<div class="row-fields">
				
				<aui:col width="<%=50 %>">
					<aui:input name='<%= "seriesReportNo" + serieReportNoIndex %>' 
					type="hidden" value="<%= serieReportNoIndex %>" />
				
					<aui:input type="text" cssClass="fullwidth" label="serie-name"
						name='<%= "serie" + serieReportNoIndex  %>' 
						value="<%=serie %>" 
					/>
				</aui:col>
					<aui:col width="<%=50 %>">
					<aui:input type="text" label="report-no"
						name='<%= "reportNo" + serieReportNoIndex  %>' 
						value="<%=reportNo %>" 
						 />
				</aui:col>
			</div>
		</div>
	
	<%	
		}
	%>
	<aui:input name="serieReportNoIndexes" type="hidden" value="<%= StringUtil.merge(seriesReportNoIndexes) %>" />

	</div>

</liferay-ui:panel>

<%
	int[] otherTitleIndexes = null;
	String[] otherTitles = item.getOtherTitles();
	
	
	
	List<String> otherTitleList = Collections.emptyList();
	
	if (otherTitles != null)
	{
		otherTitleList = new ArrayList<String>();
		otherTitleIndexes = new int[otherTitles.length];
		for (int i=0 ;i < otherTitles.length; i++)
		{
			
			otherTitleIndexes[i] = i;
			otherTitleList.add(i, otherTitles[i]);
		}
	} else
	{
		otherTitleIndexes = new int[]{0};
	}
	if (otherTitleList.isEmpty())
	{
		otherTitleList = new ArrayList<String>();
		otherTitleList.add(new String());
		otherTitles = new String[]{StringPool.BLANK};
		
	}
%>

<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="suburItemOtherTitle" persistState="<%= false %>" title="other-title">


	
	<div id="otherTitle">
		<%
			for (int i = 0 ; i < otherTitleIndexes.length; i++)
			{
				int otherTitleIndex = otherTitleIndexes[i];
				String otherTitle = otherTitleList.get(i);
				
				
		%>
		<div class="lfr-form-row lfr-form-row-inline">
			<div class="row-fields">
				<aui:col width="<%=90 %>">
					<aui:input name='<%= "otherTitleId" + otherTitleIndex %>' type="hidden" value="<%= otherTitleIndex %>" />
					
					
					<aui:input type="text" label="other-title"
						name='<%= "otherTitle" + otherTitleIndex  %>' 
						value="<%=otherTitle %>" cssClass="fullwidth"
						 />
				</aui:col>
			
			</div>
		</div>
		<%
			
			}
		%>
			<aui:input name="otherTitleIndexes" type="hidden" value="<%= StringUtil.merge(otherTitleIndexes) %>" />
			
		
	</div>
</liferay-ui:panel>




<aui:script use="liferay-auto-fields">
    new Liferay.AutoFields(
    	{
    		contentBox: '#otherTitle',
    		fieldIndexes: '<portlet:namespace />otherTitleIndexes',
    		namespace: '<portlet:namespace/>'
    	}
    ).render();
    
    new Liferay.AutoFields(
        	{
        		contentBox: '#seriesReportNo',
        		fieldIndexes: '<portlet:namespace />serieReportNoIndexes',
        		namespace: '<portlet:namespace/>'
        	}
        ).render();
</aui:script>
<aui:script use="liferay-auto-fields">
    new Liferay.AutoFields(
        	{
        		contentBox: '#itemIdentifier',
        		fieldIndexes: '<portlet:namespace />itemIdentifierIndexes',
        		namespace: '<portlet:namespace/>'
        	}
        ).render();
  </aui:script>		
		