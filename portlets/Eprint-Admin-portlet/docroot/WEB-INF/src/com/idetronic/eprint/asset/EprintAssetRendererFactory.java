package com.idetronic.eprint.asset;

import com.idetronic.eprint.model.Eprint;
import com.idetronic.eprint.service.EprintLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

public class EprintAssetRendererFactory extends BaseAssetRendererFactory {

	@Override
	public AssetRenderer getAssetRenderer(long eprintId, int type)
			throws PortalException, SystemException {
		Eprint eprint = EprintLocalServiceUtil.fetchEprint(eprintId);
		return new EprintAssetRenderer(eprint);
	}
	@Override
	public AssetRenderer getAssetRenderer(long groupId, String urlTitle)
		throws PortalException, SystemException {

		return new EprintAssetRenderer(EprintLocalServiceUtil.fetchEntry(groupId, urlTitle));
	}

	@Override
	public String getClassName() {
		return Eprint.class.getName();
	}

	@Override
	public String getType() {
		return "Eprint";
	}
	@Override
    protected String getIconPath(ThemeDisplay themeDisplay) {
        return themeDisplay.getPathThemeImages() + "/eprint/eprint.png";
    }

}
