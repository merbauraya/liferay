package com.idetronic.subur.asset;

import java.util.Locale;

import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.idetronic.subur.model.Author;
import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.service.permission.SuburItemPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

public class AuthorAssetRenderer extends BaseAssetRenderer{
	private Author _author;// _suburItem;

    public AuthorAssetRenderer (Author author) {

    	_author = author;
    }

    @Override
    public boolean hasEditPermission(PermissionChecker permissionChecker) {

            long authorId =  _author.getAuthorId();// _suburItem.getItemId();

            boolean contains = false;

            try {
                    contains = SuburItemPermission.contains(permissionChecker,
                    		authorId, ActionKeys.UPDATE);
            } catch (PortalException pe) {
                    _log.error(pe.getLocalizedMessage());
            } catch (SystemException se) {
                    _log.error(se.getLocalizedMessage());
            }

            return contains;
    }

    @Override
    public boolean hasViewPermission(PermissionChecker permissionChecker) {

    	 long authorId =  _author.getAuthorId();

            boolean contains = false;

            try {
                    contains = SuburItemPermission.contains(permissionChecker,
                    		authorId, ActionKeys.VIEW);
            } catch (PortalException pe) {
                    _log.error(pe.getLocalizedMessage());
            } catch (SystemException se) {
                    _log.error(se.getLocalizedMessage());
            }

            return contains;
    }

    @Override
    public String getClassName() {
            return Author.class.getName();
    }

    @Override
    public long getClassPK() {
            return _author.getAuthorId();
    }

    @Override
    public long getGroupId() {
            return _author.getGroupId();
    }

    @Override
    public String getSummary(Locale locale) {
            return "Name: " + _author.getDisplayName();
    }

    @Override
    public String getTitle(Locale locale) {
            return _author.getDisplayName();
    }

    @Override
    public long getUserId() {

            return _author.getUserId();
    }

    @Override
    public String getUserName() {
            return StringPool.BLANK;// _author.getUserName();
    }

    @Override
    public String getUuid() {
            return _author.getUuid();
    }

    @Override
    public String render(RenderRequest renderRequest,
                    RenderResponse renderResponse, String template) throws Exception {
    	
    	String page = "/html/renderer/item_abstract.jsp";
		if (template.equals(TEMPLATE_FULL_CONTENT)) {
			page = "/html/renderer/item_full.jsp";
		}
    	
		renderRequest.setAttribute("author", _author);
        return page;
    }
    public String getURLViewInContext(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse,
			String noSuchEntryRedirect) throws Exception {
		
		PortletConfig portletConfig = (PortletConfig) liferayPortletRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		ThemeDisplay themeDisplay= (ThemeDisplay)liferayPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		//String portletName = portletConfig.getPortletName();
		String portletName = "Subur_WAR_Suburportlet";
		long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), portletName);
		PortletURL portletURL = PortletURLFactoryUtil.create(liferayPortletRequest, portletName, plid,PortletRequest.RENDER_PHASE);
		portletURL.setParameter("jspPage", "/html/renderer/item_full.jsp");
		portletURL.setParameter("itemId", String.valueOf(_author.getAuthorId()));
		//portletURL.setParameter("urlTitle", _ _eprint.getUrlTitle());

		return portletURL.toString();
		//return noSuchEntryRedirect;
	}
    
    private static final Log _log = LogFactoryUtil.getLog(SuburItemAssetRenderer.class);

}


}
