package com.idetronic.tazkirah.util;

import java.util.List;

import com.idetronic.tazkirah.model.Tazkirah;
import com.idetronic.tazkirah.service.TazkirahLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class TazkirahUtil {
	private static Log log = LogFactoryUtil.getLog(TazkirahUtil.class);//  (LMSBookLocalServiceImpl.class);
	
	public static Tazkirah getRandom(long companyId,long groupId,String category)
	{
		int min = 0;
		int max = 0;
		int randomNumber = 0;
		Tazkirah tazkirah = null;
		List<Tazkirah> tazkirahs = TazkirahLocalServiceUtil.getByCategory(category, companyId,groupId);
		
		if ((Validator.isNotNull(tazkirahs) && tazkirahs.size()>0))
		{
			max = tazkirahs.size();
			randomNumber = min + (int)(Math.random() * (max - min));
			
			tazkirah = tazkirahs.get(randomNumber);
			return tazkirah;
		}
		
		return tazkirah;
		
	}

}
