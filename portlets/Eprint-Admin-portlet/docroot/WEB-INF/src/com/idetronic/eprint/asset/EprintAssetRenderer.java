package com.idetronic.eprint.asset;

import java.util.Locale;

import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.idetronic.eprint.EprintConstant;
import com.idetronic.eprint.admin.search.EprintOpenSearchImpl;
import com.idetronic.eprint.model.*;


public class EprintAssetRenderer extends BaseAssetRenderer{
	private static final Log log = LogFactoryUtil.getLog(EprintAssetRenderer.class);
	private Eprint _eprint;
	public EprintAssetRenderer(Eprint eprint) {
		_eprint = eprint;
	}
	
	public String render(RenderRequest request,	RenderResponse response, String template)
			throws Exception {
		request.setAttribute("ASSET_ENTRY", _eprint);
		String page = "/html/eprint/asset/abstract.jsp";
		if (template.equals(TEMPLATE_FULL_CONTENT)) {
			page = "/html/eprint/asset/full_content.jsp";
		}
		return page;
	}
	public String getURLViewInContext(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse,
			String noSuchEntryRedirect) throws Exception {
		
		PortletConfig portletConfig = (PortletConfig) liferayPortletRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		ThemeDisplay themeDisplay= (ThemeDisplay)liferayPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String portletName2 = portletConfig.getPortletName();
		String portletName = "eprintview_WAR_EprintAdminportlet";
		long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), portletName);
		PortletURL portletURL = PortletURLFactoryUtil.create(liferayPortletRequest, portletName, plid,PortletRequest.RENDER_PHASE);
		portletURL.setParameter("jspPage", EprintConstant.VIEW_EPRINT_DETAIL);
		portletURL.setParameter("eprintId", String.valueOf(_eprint.getEprintId()));
		//PortletURL viewPageURL = PortletURLFactoryUtil.CRE
	/*	PortletURL viewPageURL = PortletURLFactoryUtil.create(
				liferayPortletRequest,
                 portletName + "_WAR_" + portletName + "portlet",
                 themeDisplay.getPlid(),
                 PortletRequest.RENDER_PHASE);
		viewPageURL.setParameter("jspPage", EprintConstant.VIEW_EPRINT_DETAIL);*/
		//log.info("portalurl"+themeDisplay.getPortalURL());
		//log.info("pathMain="+themeDisplay.getPathMain());
		String url = themeDisplay.getPortalURL() + themeDisplay.getPathMain() + 
				     "/eprint/detail/"+_eprint.getEprintId();
		
		//return url;
		
		//log.info("EprintAssetRenderer.getURLViewInContext="+ noSuchEntryRedirect)	;
		
		/*return getURLViewInContext(
				liferayPortletRequest, noSuchEntryRedirect, "/html/eprint/detail.jsp",
				"eprintId", _eprint.getEprintId()); */
		//log.info("epView="+viewPageURL.toString());
		return portletURL.toString();
		//return noSuchEntryRedirect;
	}
	public String getDiscussionPath() {
		return "edit_entry_discussion";
	}
	public long getGroupId() {
		return _eprint.getGroupId();
	}
	public String getSummary(Locale locale) {
		return _eprint.getEprintAbstract();
	}
	public String getTitle(Locale locale) {
		return _eprint.getTitle();
	}
	public long getUserId() {
		return 0l;
	}
	public String getUuid() {
		return "";
	}
	public String getUserName() {
		return "";
	}
	public long getClassPK() {
		return _eprint.getPrimaryKey();
	}
	protected String getIconPath(ThemeDisplay themeDisplay) {
        return themeDisplay.getPathThemeImages() + "/eprint/eprint.png";
    }
}
