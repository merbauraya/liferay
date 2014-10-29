package com.idetronic.hook.user.indexer;

import java.util.LinkedHashMap;
import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexerPostProcessor;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.idetronic.portlet.model.ExpertiseTag;
import com.idetronic.portlet.model.ServiceExperience;
import com.idetronic.portlet.model.UserEntries_ExpertiseTags;
import com.idetronic.portlet.service.ServiceExperienceLocalServiceUtil;
import com.idetronic.portlet.service.UserEntries_ExpertiseTagsLocalServiceUtil;


public class UserIndexerPostProcessor extends BaseIndexerPostProcessor {
	Log _log = LogFactoryUtil.getLog(UserIndexerPostProcessor.class);
	@Override
	public void postProcessContextQuery(
			BooleanQuery contextQuery, SearchContext searchContext)
		throws Exception {
		
		LinkedHashMap<String, Object> params =
			(LinkedHashMap<String, Object>)searchContext.getAttribute("params");

		if (params != null) {
			Object experienceTitles = params.get("experienceTitles");
			Object expertise = params.get("expertise");

			if (Validator.isNotNull(experienceTitles)) {
				contextQuery.addRequiredTerm(
					"experienceTitles", String.valueOf(experienceTitles), true);
			}
			if (Validator.isNotNull(experienceTitles)) {
				contextQuery.addRequiredTerm(
					"expertise", String.valueOf(expertise), true);
			}
		}
	}

	@Override
	public void postProcessDocument(Document document, Object obj)
		throws Exception {
		
		User user = (User)obj;

		List<ServiceExperience> expEntries =
				ServiceExperienceLocalServiceUtil.getUserServiceExperience(user.getUserId());
			
		String[] entryTitles = new String[expEntries.size()]; 
		
		List userExpertises = UserEntries_ExpertiseTagsLocalServiceUtil.getUserEntry(user.getUserId());
		ExpertiseTag expertiseTag = null;
		UserEntries_ExpertiseTags userTag = null;
		String[] selectedTag = new String[userExpertises.size()];
		int k=0;
		for (Object usrTags: userExpertises)
		{
			Object[] arrayobject=(Object[])usrTags;
			expertiseTag = (ExpertiseTag) arrayobject[0];
			userTag = (UserEntries_ExpertiseTags) arrayobject[1];
			
			selectedTag[k] = StringUtil.toLowerCase(expertiseTag.getTagName());
			k++;
		}

		for (int i = 0; i < entryTitles.length; i++) {
			ServiceExperience serviceExperience = expEntries.get(i);
			entryTitles[i] = StringUtil.toLowerCase(serviceExperience.getTitle());
		}
		document.addKeyword("experienceTitles", entryTitles);
		document.addKeyword("expertise", selectedTag);
		
	}

	@Override
	public void postProcessSearchQuery(
			BooleanQuery searchQuery, SearchContext searchContext)
		throws Exception {

		String keywords = searchContext.getKeywords();
		
		if (Validator.isNotNull(keywords)) {
			searchQuery.addTerm("experienceTitles", keywords, true);
			searchQuery.addTerm("expertise", keywords, true);
			
		}
	}
}
