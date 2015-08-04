package com.idetronic.subur.asset;

import com.idetronic.subur.model.Author;
import com.idetronic.subur.service.AuthorLocalServiceUtil;
import com.idetronic.subur.service.permission.AuthorPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

public class AuthorRendererFactory extends BaseAssetRendererFactory {
	

    public static final String CLASS_NAME = Author.class.getName();

    public static final String TYPE = "author";

    @Override
    public AssetRenderer getAssetRenderer(long classPK, int type)
            throws PortalException, SystemException {

            Author author = AuthorLocalServiceUtil.getAuthor(classPK);

            return new AuthorAssetRenderer(author);
    }

    @Override
    public String getClassName() {
            return CLASS_NAME;
    }

    @Override
    public String getType() {
            return TYPE;
    }

    @Override
    public boolean hasPermission(
                    PermissionChecker permissionChecker, long classPK, String actionId)
            throws Exception {

            return AuthorPermission.contains(permissionChecker, classPK, actionId);
    }

    @Override
    public boolean isLinkable() {
            return _LINKABLE;
    }

    private static final boolean _LINKABLE = true;

}

