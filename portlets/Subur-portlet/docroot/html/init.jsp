<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This file is part of Liferay Social Office. Liferay Social Office is free
 * software: you can redistribute it and/or modify it under the terms of the GNU
 * Affero General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * Liferay Social Office is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Liferay Social Office. If not, see http://www.gnu.org/licenses/agpl-3.0.html.
 */
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://idetronic.com.my/tld/subur" prefix="subur" %>

<%@ page import="com.liferay.portal.NoSuchRoleException" %><%@
page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %><%@
page import="com.liferay.portal.kernel.language.LanguageUtil" %><%@
page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %><%@
page import="com.liferay.portal.kernel.servlet.SessionMessages" %><%@
page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.CalendarUtil" %><%@
page import="com.liferay.portal.kernel.util.Constants" %><%@
page import="com.liferay.portal.kernel.util.DateUtil" %><%@
page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.GetterUtil" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.util.StringPool" %><%@
page import="com.liferay.portal.kernel.util.StringUtil" %><%@
page import="com.liferay.portal.kernel.util.UnicodeProperties" %><%@
page import="com.liferay.portal.kernel.util.Validator" %><%@
page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %><%@
page import="com.liferay.portal.model.Group" %><%@
page import="com.liferay.portal.model.Layout" %><%@
page import="com.liferay.portal.model.LayoutConstants" %><%@
page import="com.liferay.portal.model.LayoutSetPrototype" %><%@
page import="com.liferay.portal.model.Portlet" %><%@
page import="com.liferay.portal.model.Role" %><%@
page import="com.liferay.portal.model.Team" %><%@
page import="com.liferay.portal.model.User" %><%@
page import="com.liferay.portal.security.permission.ActionKeys" %><%@
page import="com.liferay.portal.service.GroupLocalServiceUtil" %><%@
page import="com.liferay.portal.service.LayoutLocalServiceUtil" %><%@
page import="com.liferay.portal.service.LayoutSetPrototypeServiceUtil" %><%@
page import="com.liferay.portal.service.PortletLocalServiceUtil" %><%@
page import="com.liferay.portal.service.PortletPreferencesLocalServiceUtil" %><%@
page import="com.liferay.portal.service.RoleLocalServiceUtil" %><%@
page import="com.liferay.portal.service.TeamLocalServiceUtil" %><%@
page import="com.liferay.portal.service.UserLocalServiceUtil" %><%@
page import="com.liferay.portal.service.permission.GroupPermissionUtil" %><%@
page import="com.liferay.portal.service.permission.PortalPermissionUtil" %><%@
page import="com.liferay.portal.util.PortalUtil" %><%@
page import="com.liferay.portal.util.comparator.RoleNameComparator" %><%@
page import="com.liferay.portlet.social.model.SocialActivityFeedEntry" %><%@
page import="com.liferay.portlet.social.model.SocialRelationConstants" %><%@
page import="com.liferay.portlet.social.service.SocialActivityInterpreterLocalServiceUtil" %><%@
page import="com.liferay.portlet.usersadmin.util.UsersAdminUtil" %><%@
page import="com.liferay.portal.util.PortletKeys"%><%@
page import="com.liferay.portal.kernel.util.UnicodeFormatter"%><%@
page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %><%@
page import="java.util.HashMap" %><%@
page import="java.util.LinkedHashMap" %><%@
page import="java.util.LinkedHashSet" %><%@
page import="com.liferay.portal.kernel.search.Sort" %><%@
page import="com.liferay.portal.kernel.search.SortFactoryUtil" %><%@
page import="com.liferay.portlet.PortletURLUtil" %><%@
page import="com.liferay.portal.kernel.util.WebKeys" %><%@
page import=" com.liferay.portal.kernel.portlet.LiferayPortletResponse" %><%@ 
page import="javax.portlet.ActionRequest"%><%@ 
page import="javax.portlet.PortletRequest"%><%@ 
page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.log.Log" %>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.search.Indexer" %>
<%@ page import="com.liferay.portal.kernel.search.IndexerRegistryUtil" %>
<%@ page import="com.liferay.portal.kernel.search.SearchContext" %>
<%@ page import="com.liferay.portal.kernel.search.SearchContextFactory" %>
<%@ page import="com.liferay.portal.kernel.search.BooleanQuery" %>
<%@ page import="com.liferay.portal.kernel.search.BooleanQueryFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.search.Hits" %>
<%@ page import="com.liferay.portal.kernel.search.Document" %>
<%@ page import="com.liferay.portal.kernel.search.Field" %>
<%@ page import="com.liferay.portal.kernel.search.BooleanClauseOccur" %>
<%@ page import="com.liferay.portal.kernel.search.SearchEngineUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.LocaleUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %><%@
page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.search.facet.AssetEntriesFacet"%>
<%@ page import="com.liferay.portal.kernel.search.facet.Facet"%>
<%@ page import="com.liferay.portal.kernel.search.facet.SimpleFacet" %>
<%@ page import="com.liferay.portal.kernel.search.facet.MultiValueFacet" %>
<%@ page import="com.liferay.portal.kernel.search.facet.collector.FacetCollector" %>
<%@ page import="com.liferay.portal.kernel.search.facet.collector.TermCollector" %>
<%@ page import="com.liferay.portlet.asset.model.AssetVocabulary" %>
<%@ page import="com.liferay.portlet.asset.model.AssetCategory" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@ page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PrefsPropsUtil" %>
<%@ page import="com.liferay.portal.kernel.bean.BeanParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PropsKeys" %>
<%@ page import="com.liferay.portal.service.TicketLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.Ticket" %>
<%@ page import="com.liferay.portal.model.TicketConstants" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portlet.asset.service.AssetVocabularyServiceUtil"%>
<%@ page import="com.liferay.portlet.asset.service.persistence.AssetCategoryUtil" %>
<%@ page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil" %>
<%@ page import="com.liferay.portlet.asset.service.AssetTagPropertyLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.asset.service.AssetTagLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.asset.service.persistence.AssetEntryQuery" %>
<%@ page import="com.liferay.portal.kernel.util.ArrayUtil"%>
<%@ page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.asset.model.AssetEntry" %>
<%@ page import="com.liferay.portlet.asset.model.AssetRendererFactory" %>
<%@ page import="com.liferay.portlet.asset.model.AssetRenderer" %>
<%@ page import="com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil" %> 
<%@ page import="com.liferay.portal.service.ClassNameLocalServiceUtil" %>
<%@ page import="java.text.Format" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.io.PrintWriter" %>

<%@ page import="java.util.ArrayList" %><%@
page import="java.util.Calendar" %><%@
page import="java.util.Date" %><%@
page import="java.util.List" %><%@
page import="java.util.Map" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.Locale" %>

<%@ page import="javax.portlet.PortletPreferences" %><%@
page import="javax.portlet.PortletURL" %><%@
page import="javax.portlet.WindowState" %>

<%@page import="com.idetronic.subur.model.ItemType" %>
<%@ page import="com.idetronic.subur.model.Expertise" %>
<%@
page import="com.idetronic.subur.model.ItemItemType" %><%@
page import="com.idetronic.subur.model.SuburItem" %><%@
page import="com.idetronic.subur.model.MetadataPropertyValue" %><%@
page import="com.idetronic.subur.model.impl.MetadataPropertyValueImpl" %><%@
page import="com.idetronic.subur.service.ItemTypeLocalServiceUtil" %><%@
page import="com.idetronic.subur.service.SuburItemLocalServiceUtil" %><%@
page import="com.idetronic.subur.service.MetadataPropertyValueLocalServiceUtil" %>
<%@ page import="com.idetronic.subur.service.permission.SuburItemPermission" %>
<%@ page import="com.idetronic.subur.service.permission.SuburPermission" %>
<%@ page import="com.idetronic.subur.util.SuburConstant" %>
<%@ page import="com.idetronic.subur.util.SuburUtil" %>
<%@ page import="com.idetronic.subur.util.SuburFolderUtil" %>
<%@ page import="com.idetronic.subur.service.persistence.ItemItemTypeFinder" %>
<%@ page import="com.idetronic.subur.service.ItemItemTypeLocalServiceUtil"%>
<%@ page import="com.idetronic.subur.service.ItemFileEntryLocalServiceUtil"%>
<%@ page import="com.idetronic.subur.service.SubjectLocalServiceUtil"%>
<%@ page import="com.idetronic.subur.service.ItemSubjectLocalServiceUtil"%>
<%@ page import="com.idetronic.subur.service.DivisionLocalServiceUtil"%>
<%@ page import="com.idetronic.subur.service.AuthorSiteLocalServiceUtil"%>
<%@ page import="com.idetronic.subur.service.ItemAuthorLocalServiceUtil"%>
<%@ page import="com.idetronic.subur.service.AuthorLocalServiceUtil"%>
<%@ page import="com.idetronic.subur.model.impl.AuthorSiteImpl" %>
<%@ page import="com.idetronic.subur.model.FileEntryType" %>
<%@ page import="com.idetronic.subur.model.Author" %>
<%@ page import="com.idetronic.subur.model.MetadataValueView" %>
<%@ page import="com.idetronic.subur.model.ItemSubject" %>

<%@ page import="com.idetronic.subur.model.AuthorSite" %>
<%@ page import="com.idetronic.subur.util.TreeNode" %>
<%@ page import="com.idetronic.subur.search.AuthorSearch" %>
<%@ page import="com.idetronic.subur.search.AuthorSearchTerms" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@ page import="com.idetronic.subur.search.AuthorDisplayTerms" %>
<%@ page import="com.liferay.portlet.documentlibrary.model.DLFileEntry" %>
<%@ page import="com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@ page import="com.liferay.portal.kernel.repository.model.FileVersion" %>
<%@ page import="com.liferay.portlet.documentlibrary.util.DLUtil" %>
<%@ page import="com.liferay.portal.kernel.util.TextFormatter" %>
<%@ page import="com.liferay.portlet.documentlibrary.model.DLFileEntryConstants" %>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil" %>
<%@ page import="com.liferay.portal.service.ServiceContext" %>
<%@ page import="com.liferay.portal.kernel.util.Time" %>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@ page import="com.liferay.portal.kernel.repository.model.Folder" %>
<%@ page import="com.liferay.portlet.documentlibrary.model.DLFileEntryType" %>
<%@ page import="com.liferay.portlet.documentlibrary.service.DLFileEntryTypeServiceUtil" %>
<%@ page import="com.liferay.portlet.documentlibrary.model.DLFileVersion" %>
<%@ page import="com.liferay.portlet.documentlibrary.service.DLFileEntryTypeLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.model.DDMStructure" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.storage.Fields" %>
<%@ page import="com.liferay.portlet.documentlibrary.model.DLFileEntryMetadata" %>
<%@ page import="com.liferay.portlet.documentlibrary.service.DLFileEntryMetadataLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.storage.StorageEngineUtil" %>
<%@ page import="com.liferay.portlet.asset.service.AssetEntryServiceUtil" %>
<%@ page import="com.liferay.portlet.trash.util.TrashUtil" %>
<%@ page import="com.liferay.portlet.assetpublisher.util.AssetPublisherUtil" %>
<%@ page import="com.liferay.util.RSSUtil" %> 
<%@ page import="com.idetronic.subur.search.SuburSearch" %>
<%@ page import="com.idetronic.subur.search.SuburDisplayTerms" %>
<%@ page import="javax.portlet.PortletResponse" %>
<%@ page import="com.liferay.portal.security.permission.ResourceActionsUtil" %>
<%@ page import="com.liferay.portal.kernel.util.JavaConstants" %>
<%@ page import="com.idetronic.subur.service.persistence.SuburItemQuery" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
	WindowState windowState = liferayPortletRequest.getWindowState();
	String currentURL = PortalUtil.getCurrentURL(request);
	PortletURL currentURLObj = PortletURLUtil.getCurrent(liferayPortletRequest, liferayPortletResponse);
	Format dateFormatDate = FastDateFormatFactoryUtil.getSimpleDateFormat("dd MMM yyyy", locale, timeZone);
	Format timeFormatDate = FastDateFormatFactoryUtil.getSimpleDateFormat("dd MMM yyyy hh:mm",locale, timeZone);
	Format yearFormatDate = FastDateFormatFactoryUtil.getSimpleDateFormat("yyyy",locale, timeZone);

	
%>
