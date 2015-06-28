<%@ include file="/html/taglib/init.jsp" %>

<%@ page import="com.liferay.portlet.asset.model.AssetLink" %><%@
page import="com.liferay.portlet.asset.service.AssetLinkLocalServiceUtil" %>
<%@ page import="javax.portlet.ResourceURL" %>

<%
long assetEntryId = GetterUtil.getLong((String)request.getAttribute("subur:item-asset-links:assetEntryId"));
PortletURL serveFileURL = (PortletURL)request.getAttribute("subur:item-asset-links:serveFileURL");
String nameSpace = (String)request.getAttribute("subur:item-asset-links:nameSpace");
List<AssetLink> assetLinks = null;

if (assetEntryId > 0) {
	assetLinks = AssetLinkLocalServiceUtil.getDirectLinks(assetEntryId);
}
%>

<c:if test="<%= (assetLinks != null) && !assetLinks.isEmpty() %>">
	<div class="taglib-asset-links">
		<h2 class="asset-links-title"><liferay-ui:message key="related-assets" />:</h2>

		<ul class="asset-links-list">

			<%
			for (AssetLink assetLink : assetLinks) {
				AssetEntry assetLinkEntry = null;

				if (assetLink.getEntryId1() == assetEntryId) {
					assetLinkEntry = AssetEntryLocalServiceUtil.getEntry(assetLink.getEntryId2());
				}
				else {
					assetLinkEntry = AssetEntryLocalServiceUtil.getEntry(assetLink.getEntryId1());
				}

				if (!assetLinkEntry.isVisible()) {
					continue;
				}

				assetLinkEntry = assetLinkEntry.toEscapedModel();

				String className = PortalUtil.getClassName(assetLinkEntry.getClassNameId());
				
				AssetRendererFactory assetRendererFactory = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(className);

				if (Validator.isNull(assetRendererFactory)) {
					if (_log.isWarnEnabled()) {
						_log.warn("No asset renderer factory found for class " + className);
					}

					continue;
				}

				if (!assetRendererFactory.isActive(company.getCompanyId())) {
					continue;
				}

				AssetRenderer assetRenderer = assetRendererFactory.getAssetRenderer(assetLinkEntry.getClassPK());

				if (assetRenderer.hasViewPermission(permissionChecker)) {
					String asseLinktEntryTitle = assetLinkEntry.getTitle(locale);

					LiferayPortletURL assetPublisherURL = new PortletURLImpl(request, PortletKeys.ASSET_PUBLISHER, plid, PortletRequest.RENDER_PHASE);

					assetPublisherURL.setParameter("struts_action", "/asset_publisher/view_content");
					assetPublisherURL.setParameter("redirect", currentURL);
					assetPublisherURL.setParameter("assetEntryId", String.valueOf(assetLinkEntry.getEntryId()));
					assetPublisherURL.setParameter("type", assetRendererFactory.getType());

					if (Validator.isNotNull(assetRenderer.getUrlTitle())) {
						if (assetRenderer.getGroupId() != themeDisplay.getSiteGroupId()) {
							assetPublisherURL.setParameter("groupId", String.valueOf(assetRenderer.getGroupId()));
						}

						assetPublisherURL.setParameter("urlTitle", assetRenderer.getUrlTitle());
					}

					if (themeDisplay.isStatePopUp()) {
						assetPublisherURL.setWindowState(LiferayWindowState.POP_UP);
					}
					else {
						assetPublisherURL.setWindowState(WindowState.MAXIMIZED);
					}

					String viewFullContentURLString = assetPublisherURL.toString();

					viewFullContentURLString = HttpUtil.setParameter(viewFullContentURLString, "redirect", currentURL);

					String urlViewInContext = assetRenderer.getURLViewInContext((LiferayPortletRequest)portletRequest, (LiferayPortletResponse)portletResponse, viewFullContentURLString);
					
					urlViewInContext = HttpUtil.setParameter(urlViewInContext, "inheritRedirect", true);
					//if document, serve it manually
					if (className.equalsIgnoreCase(DLFileEntry.class.getName()))
					{
						urlViewInContext = serveFileURL.toString();
						urlViewInContext = HttpUtil.setParameter(urlViewInContext, nameSpace+"fileAssetId", String.valueOf(assetLinkEntry.getEntryId()));
					}
					
			%>

					<li class="asset-links-list-item">
						<liferay-ui:icon
							label="<%= true %>"
							message="<%= asseLinktEntryTitle %>"
							src="<%= assetRenderer.getIconPath(portletRequest) %>"
							url="<%= urlViewInContext %>"
						/>
					</li>

			<%
				}
			}
			%>

		</ul>
	</div>
</c:if>

<%!
private static Log _log = LogFactoryUtil.getLog("portal-web.docroot.html.taglib.subur.asset_links.page_jsp");
%>