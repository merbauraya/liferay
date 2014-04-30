<%@include file="/html/eprint/init.jsp" %>

<%
	String eprintId = null;
	
	String urlTitle = request.getParameter("urlTitle");
	urlTitle.replaceAll("\\s","");
	
	Eprint eprint = null;
	try {
			if (Validator.isNotNull(urlTitle)) 
			{
				eprint = EprintLocalServiceUtil.fetchEntry(themeDisplay.getScopeGroupId(), urlTitle);
			}else
			{
				eprintId = request.getParameter("eprintId");
				eprint = EprintLocalServiceUtil.fetchEprint(Long.parseLong(eprintId));
			}
			EprintConfig eprintConfig = (EprintConfig)request.getAttribute("eprintConfig");
		    
		    
			String eprintUrl = null;
			if (Validator.isNotNull(eprint))
			{
				eprintUrl = eprintConfig.getEprintURL() + eprint.getEprintId();
				com.liferay.portal.util.PortalUtil.setPageTitle(eprint.getTitle(), request); 
			}else
			{
				
			}
			AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(Eprint.class.getName(), eprint.getEprintId());
			request.setAttribute("eprintUrl", eprintUrl);
			request.setAttribute("eprint", eprint);
			AssetEntryServiceUtil.incrementViewCounter(Eprint.class.getName(), eprint.getEprintId());
			
			String socialBookmarksDisplayStyle = "none";
			request.setAttribute("view_entry_content.jsp-assetEntry", assetEntry);
%>
	<jsp:include page="/html/eprintview/view_entry.jsp" />
	
<% 
	} catch (Exception e)
	{
		
		e.printStackTrace();//  (e.printStackTrace());
%>		
		Error La
		<jsp:include page="/html/eprintview/error.jsp" />	
<%		
	}

%>
