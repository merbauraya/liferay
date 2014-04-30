package com.idetronic.eprint.util;

import java.util.ArrayList;
import java.util.List;

import com.idetronic.eprint.model.Eprint;
import com.idetronic.eprint.service.EprintLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.util.GetterUtil;

public class EprintUtil {
	private static Log _log = LogFactoryUtil.getLog(EprintUtil.class);
	public static List<Object> getEntries(Hits hits) {
		List<Object> entries = new ArrayList<Object>();

		for (Document document : hits.getDocs()) {
			String entryClassName = document.get(Field.ENTRY_CLASS_NAME);
			long entryClassPK = GetterUtil.getLong(
				document.get(Field.ENTRY_CLASS_PK));

			try {
				Object obj = null;

				
				obj = EprintLocalServiceUtil.fetchEprint(entryClassPK);
				

				entries.add(obj);
			}
			catch (Exception e) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"Eprint search index is stale and contains entry " +
							entryClassPK);
				}

				continue;
			}
		}

		return entries;
	}

}
