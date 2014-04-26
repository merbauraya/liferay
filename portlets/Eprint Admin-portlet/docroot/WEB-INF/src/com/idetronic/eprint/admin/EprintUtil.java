package com.idetronic.eprint.admin;
import com.idetronic.eprint.model.Eprint;
import com.liferay.portal.kernel.util.FriendlyURLNormalizerUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelHintsUtil;

public class EprintUtil {
	public static String getUrlTitle(long entryId, String title) {
		if (title == null) {
			return String.valueOf(entryId);
		}

		title = title.trim().toLowerCase();

		if (Validator.isNull(title) || Validator.isNumber(title) ||
			title.equals("rss")) {

			title = String.valueOf(entryId);
		}
		else {
			title = FriendlyURLNormalizerUtil.normalize(
				title, _URL_TITLE_REPLACE_CHARS);
		}

		return ModelHintsUtil.trimString(
			Eprint.class.getName(), "urlTitle", title);
	}
	private static final char[] _URL_TITLE_REPLACE_CHARS = new char[] {
		'.', '/'
	};

}
