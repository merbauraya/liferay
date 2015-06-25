package com.idetronic.subur.service.permission;

import com.idetronic.subur.model.SuburItem;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.staging.permission.StagingPermissionUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.util.PortletKeys;

public class SuburPermission {
	private static String CLASS_NAME="com.idetronic.subur";
	
	
	public static void check(
			PermissionChecker permissionChecker, long groupId, String actionId)
		throws PortalException {

		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long groupId, String actionId) {

		
		return permissionChecker.hasPermission(
			groupId, CLASS_NAME, groupId, actionId);
	}

}
