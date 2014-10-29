package com.idetronic.importer;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.model.CalendarResource;
import com.liferay.calendar.notification.NotificationType;
import com.idetronic.importer.recurrence.Frequency;
import com.idetronic.importer.recurrence.Recurrence;
import com.idetronic.importer.recurrence.RecurrenceSerializer;
import com.idetronic.importer.recurrence.Weekday; 
import com.liferay.calendar.service.persistence.CalendarBookingUtil;

//import com.liferay.calendar.service.base.CalendarImporterLocalServiceBaseImpl;
//import com.liferay.calendar.util.CalendarResourceUtil;
import com.liferay.portal.kernel.cal.DayAndPosition;
import com.liferay.portal.kernel.cal.TZSRecurrence;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.ResourceAction;
import com.liferay.portal.model.ResourceBlockConstants;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.ResourcePermission;
import com.liferay.portal.model.Subscription;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ResourceBlockLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetCategoryConstants;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLink;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.calendar.model.CalEvent;
import com.liferay.portlet.calendar.service.persistence.CalEventActionableDynamicQuery;
import com.liferay.portlet.calendar.service.persistence.CalEventUtil;
import com.liferay.portlet.messageboards.model.MBDiscussion;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBMessageConstants;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.service.persistence.MBDiscussionUtil;
import com.liferay.portlet.messageboards.service.persistence.MBMessageUtil;
import com.liferay.portlet.messageboards.service.persistence.MBThreadUtil;
import com.liferay.portlet.ratings.model.RatingsEntry;
import com.liferay.portlet.ratings.model.RatingsStats;
import com.liferay.portlet.ratings.service.persistence.RatingsEntryUtil;
import com.liferay.portlet.ratings.service.persistence.RatingsStatsUtil;
import com.liferay.portlet.social.model.SocialActivity;
import com.liferay.portlet.social.service.persistence.SocialActivityUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.persistence.ResourceActionUtil;
import com.liferay.portal.service.persistence.ResourcePermissionUtil;
import com.liferay.portal.service.persistence.SubscriptionUtil;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetLinkLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.asset.service.persistence.AssetCategoryUtil;
import com.liferay.portlet.asset.service.persistence.AssetEntryUtil;
import com.liferay.portlet.asset.service.persistence.AssetLinkUtil	;
import com.liferay.portlet.asset.service.persistence.AssetVocabularyUtil;
import com.idetronic.importer.calendar.CalendarResourceUtil;
public class ImportCal {

	public void importCalEvent(CalEvent calEvent)
			throws PortalException, SystemException {

			// Calendar event

			if (isImported(calEvent)) {
				return;
			}

			long calendarBookingId = CounterLocalServiceUtil.increment();

			CalendarResource calendarResource = getCalendarResource(
				calEvent.getCompanyId(), calEvent.getGroupId());

			Date startDate = calEvent.getStartDate();

			long startTime = startDate.getTime();

			long endTime =
				startTime + calEvent.getDurationHour() * Time.HOUR +
				calEvent.getDurationMinute() * Time.MINUTE;

			if (calEvent.isAllDay()) {
				endTime = endTime - 1;
			}

			String recurrence = getRecurrence(calEvent.getRecurrenceObj());

			addCalendarBooking(
				calEvent.getUuid(), calendarBookingId, calEvent.getCompanyId(),
				calendarResource.getGroupId(), calEvent.getUserId(),
				calEvent.getUserName(), calEvent.getCreateDate(),
				calEvent.getModifiedDate(), calendarResource.getDefaultCalendarId(),
				calendarResource.getCalendarResourceId(), calEvent.getTitle(),
				calEvent.getDescription(), calEvent.getLocation(), startTime,
				endTime, calEvent.getAllDay(), recurrence,
				calEvent.getFirstReminder(), NotificationType.EMAIL,
				calEvent.getSecondReminder(), NotificationType.EMAIL);

			// Resources

			importCalendarBookingResourcePermissions(calEvent, calendarBookingId);

			// Subscriptions

			importSubscriptions(calEvent, calendarBookingId);

			// Asset

			importAssets(calEvent, calendarBookingId);

			// Message boards

			importMBDiscussion(calEvent, calendarBookingId);

			// Social

			importSocialActivities(calEvent, calendarBookingId);

			// Ratings

			importRatings(
					ClassNameLocalServiceUtil.getClassNameId(CalEvent.class.getName()),
				calEvent.getEventId(),
				ClassNameLocalServiceUtil.getClassNameId(
					CalendarBooking.class.getName()),
				calendarBookingId);
		}


		public void importCalEvents() throws PortalException, SystemException {
			ActionableDynamicQuery actionableDynamicQuery =
				new CalEventActionableDynamicQuery() {


				protected void performAction(Object object)
					throws PortalException, SystemException {

					CalEvent calEvent = (CalEvent)object;

					importCalEvent(calEvent);
				}

			};

			actionableDynamicQuery.performActions();
		}

		protected void addAssetEntry(
				long entryId, long groupId, long companyId, long userId,
				String userName, Date createDate, Date modifiedDate,
				long classNameId, long classPK, String classUuid, boolean visible,
				Date startDate, Date endDate, Date publishDate, Date expirationDate,
				String mimeType, String title, String description, String summary,
				String url, String layoutUuid, int height, int width,
				double priority, int viewCount)
			throws SystemException {

			AssetEntry assetEntry = AssetEntryUtil.create(entryId);

			assetEntry.setGroupId(groupId);
			assetEntry.setCompanyId(companyId);
			assetEntry.setUserId(userId);
			assetEntry.setUserName(userName);
			assetEntry.setCreateDate(createDate);
			assetEntry.setModifiedDate(modifiedDate);
			assetEntry.setClassNameId(classNameId);
			assetEntry.setClassPK(classPK);
			assetEntry.setClassUuid(classUuid);
			assetEntry.setVisible(visible);
			assetEntry.setStartDate(startDate);
			assetEntry.setEndDate(endDate);
			assetEntry.setPublishDate(publishDate);
			assetEntry.setExpirationDate(expirationDate);
			assetEntry.setMimeType(mimeType);
			assetEntry.setTitle(title);
			assetEntry.setDescription(description);
			assetEntry.setSummary(summary);
			assetEntry.setUrl(url);
			assetEntry.setLayoutUuid(layoutUuid);
			assetEntry.setHeight(height);
			assetEntry.setWidth(width);
			assetEntry.setPriority(priority);
			assetEntry.setViewCount(viewCount);

			AssetEntryUtil.update(assetEntry);
		}

		protected void addAssetLink(
				long linkId, long companyId, long userId, String userName,
				Date createDate, long entryId1, long entryId2, int type, int weight)
			throws SystemException {

			AssetLink assetLink = AssetLinkUtil.create(linkId);

			assetLink.setCompanyId(companyId);
			assetLink.setUserId(userId);
			assetLink.setUserName(userName);
			assetLink.setCreateDate(createDate);
			assetLink.setEntryId1(entryId1);
			assetLink.setEntryId2(entryId2);
			assetLink.setType(type);
			assetLink.setWeight(weight);

			AssetLinkUtil.update(assetLink);
		}

		protected void addCalendarBooking(
				String uuid, long calendarBookingId, long companyId, long groupId,
				long userId, String userName, Date createDate, Date modifiedDate,
				long calendarId, long calendarResourceId, String title,
				String description, String location, long startTime, long endTime,
				boolean allDay, String recurrence, int firstReminder,
				NotificationType firstReminderType, int secondReminder,
				NotificationType secondReminderType)
			throws SystemException {

			CalendarBooking calendarBooking = CalendarBookingUtil.create(
				calendarBookingId);

			calendarBooking.setUuid(uuid);
			calendarBooking.setCompanyId(companyId);
			calendarBooking.setGroupId(groupId);
			calendarBooking.setUserId(userId);
			calendarBooking.setUserName(userName);
			calendarBooking.setCreateDate(createDate);
			calendarBooking.setModifiedDate(modifiedDate);
			calendarBooking.setCalendarId(calendarId);
			calendarBooking.setCalendarResourceId(calendarResourceId);
			calendarBooking.setParentCalendarBookingId(calendarBookingId);
			calendarBooking.setTitle(title);
			calendarBooking.setDescription(description);
			calendarBooking.setLocation(location);
			calendarBooking.setStartTime(startTime);
			calendarBooking.setEndTime(endTime);
			calendarBooking.setAllDay(allDay);
			calendarBooking.setRecurrence(recurrence);
			calendarBooking.setFirstReminder(firstReminder);
			calendarBooking.setFirstReminderType(firstReminderType.toString());
			calendarBooking.setSecondReminder(secondReminder);
			calendarBooking.setSecondReminderType(secondReminderType.toString());
			calendarBooking.setStatus(WorkflowConstants.STATUS_APPROVED);
			calendarBooking.setStatusByUserId(userId);
			calendarBooking.setStatusByUserName(userName);
			calendarBooking.setStatusDate(createDate);

			CalendarBookingUtil.update(calendarBooking);
		}

		protected void addMBDiscussion(
				String uuid, long discussionId, long groupId, long companyId,
				long userId, String userName, Date createDate, Date modifiedDate,
				long classNameId, long classPK, long threadId)
			throws SystemException {

			MBDiscussion mbDiscussion = MBDiscussionUtil.create(
				discussionId);

			mbDiscussion.setUuid(uuid);
			mbDiscussion.setGroupId(groupId);
			mbDiscussion.setCompanyId(companyId);
			mbDiscussion.setUserId(userId);
			mbDiscussion.setUserName(userName);
			mbDiscussion.setCreateDate(createDate);
			mbDiscussion.setModifiedDate(modifiedDate);
			mbDiscussion.setClassNameId(classNameId);
			mbDiscussion.setClassPK(classPK);
			mbDiscussion.setThreadId(threadId);

			MBDiscussionUtil.update(mbDiscussion);
		}

		protected void addMBMessage(
				String uuid, long messageId, long groupId, long companyId,
				long userId, String userName, Date createDate, Date modifiedDate,
				long classNameId, long classPK, long categoryId, long threadId,
				long rootMessageId, long parentMessageId, String subject,
				String body, String format, boolean anonymous, double priority,
				boolean allowPingbacks, boolean answer, int status,
				long statusByUserId, String statusByUserName, Date statusDate,
				Map<Long, Long> mbMessageIds)
			throws PortalException, SystemException {

			if (parentMessageId == MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID) {
				rootMessageId = messageId;
			}
			else {
				rootMessageId = importMBMessage(
					rootMessageId, threadId, classPK, mbMessageIds);

				parentMessageId = importMBMessage(
					parentMessageId, threadId, classPK, mbMessageIds);
			}

			MBMessage mbMessage = MBMessageUtil.create(messageId);

			mbMessage.setUuid(uuid);
			mbMessage.setGroupId(groupId);
			mbMessage.setCompanyId(companyId);
			mbMessage.setUserId(userId);
			mbMessage.setUserName(userName);
			mbMessage.setCreateDate(createDate);
			mbMessage.setModifiedDate(modifiedDate);
			mbMessage.setClassNameId(classNameId);
			mbMessage.setClassPK(classPK);
			mbMessage.setCategoryId(categoryId);
			mbMessage.setThreadId(threadId);
			mbMessage.setRootMessageId(rootMessageId);
			mbMessage.setParentMessageId(parentMessageId);
			mbMessage.setSubject(subject);
			mbMessage.setBody(body);
			mbMessage.setFormat(format);
			mbMessage.setAnonymous(anonymous);
			mbMessage.setPriority(priority);
			mbMessage.setAllowPingbacks(allowPingbacks);
			mbMessage.setAnswer(answer);
			mbMessage.setStatus(status);
			mbMessage.setStatusByUserId(statusByUserId);
			mbMessage.setStatusByUserName(statusByUserName);
			mbMessage.setStatusDate(statusDate);

			MBMessageUtil.update(mbMessage);
		}

		protected void addMBThread(
				String uuid, long threadId, long groupId, long companyId,
				long userId, String userName, Date createDate, Date modifiedDate,
				long categoryId, long rootMessageId, long rootMessageUserId,
				int messageCount, int viewCount, long lastPostByUserId,
				Date lastPostDate, double priority, boolean question, int status,
				long statusByUserId, String statusByUserName, Date statusDate)
			throws SystemException {

			MBThread mbThread = MBThreadUtil.create(threadId);

			mbThread.setUuid(uuid);
			mbThread.setGroupId(groupId);
			mbThread.setCompanyId(companyId);
			mbThread.setUserId(userId);
			mbThread.setUserName(userName);
			mbThread.setCreateDate(createDate);
			mbThread.setModifiedDate(modifiedDate);
			mbThread.setCategoryId(categoryId);
			mbThread.setRootMessageId(rootMessageId);
			mbThread.setRootMessageUserId(rootMessageUserId);
			mbThread.setMessageCount(messageCount);
			mbThread.setViewCount(viewCount);
			mbThread.setLastPostByUserId(lastPostByUserId);
			mbThread.setLastPostDate(lastPostDate);
			mbThread.setPriority(priority);
			mbThread.setQuestion(question);
			mbThread.setStatus(status);
			mbThread.setStatusByUserId(statusByUserId);
			mbThread.setStatusByUserName(statusByUserName);
			mbThread.setStatusDate(statusDate);

			MBThreadUtil.update(mbThread);
		}

		protected RatingsEntry addRatingsEntry(
				long entryId, long companyId, long userId, String userName,
				Date createDate, Date modifiedDate, long classNameId, long classPK,
				double score)
			throws SystemException {

			RatingsEntry ratingsEntry = RatingsEntryUtil.create(entryId);

			ratingsEntry.setCompanyId(companyId);
			ratingsEntry.setUserId(userId);
			ratingsEntry.setUserName(userName);
			ratingsEntry.setCreateDate(createDate);
			ratingsEntry.setModifiedDate(modifiedDate);
			ratingsEntry.setClassNameId(classNameId);
			ratingsEntry.setClassPK(classPK);
			ratingsEntry.setScore(score);

			return RatingsEntryUtil.update(ratingsEntry);
		}

		protected RatingsStats addRatingsStats(
				long statsId, long classNameId, long classPK, int totalEntries,
				double totalScore, double averageScore)
			throws SystemException {

			RatingsStats ratingsStats = RatingsStatsUtil.create(statsId);

			ratingsStats.setClassNameId(classNameId);
			ratingsStats.setClassPK(classPK);
			ratingsStats.setTotalEntries(totalEntries);
			ratingsStats.setTotalScore(totalScore);
			ratingsStats.setAverageScore(averageScore);

			return RatingsStatsUtil.update(ratingsStats);
		}

		protected void addSocialActivity(
				long activityId, long groupId, long companyId, long userId,
				long createDate, long mirrorActivityId, long classNameId,
				long classPK, int type, String extraData, long receiverUserId)
			throws SystemException {

			SocialActivity socialActivity = SocialActivityUtil.create(
				activityId);

			socialActivity.setGroupId(groupId);
			socialActivity.setCompanyId(companyId);
			socialActivity.setUserId(userId);
			socialActivity.setCreateDate(createDate);
			socialActivity.setMirrorActivityId(mirrorActivityId);
			socialActivity.setClassNameId(classNameId);
			socialActivity.setClassPK(classPK);
			socialActivity.setType(type);
			socialActivity.setExtraData(extraData);
			socialActivity.setReceiverUserId(receiverUserId);

			SocialActivityUtil.update(socialActivity);
		}

		protected void addSubscription(
				long subscriptionId, long companyId, long userId, String userName,
				Date createDate, Date modifiedDate, long classNameId, long classPK,
				String frequency)
			throws SystemException {

			Subscription subscription = SubscriptionUtil.create(
				subscriptionId);

			subscription.setCompanyId(companyId);
			subscription.setUserId(userId);
			subscription.setUserName(userName);
			subscription.setCreateDate(createDate);
			subscription.setModifiedDate(modifiedDate);
			subscription.setClassNameId(classNameId);
			subscription.setClassPK(classPK);
			subscription.setFrequency(frequency);

			SubscriptionUtil.update(subscription);
		}

		protected long getActionId(
				ResourceAction oldResourceAction, String newClassName)
			throws SystemException {

			ResourceAction newResourceAction = ResourceActionUtil.fetchByN_A(
				newClassName, oldResourceAction.getActionId());

			if (newResourceAction == null) {
				return 0;
			}

			return newResourceAction.getBitwiseValue();
		}

		protected long getActionIds(
				ResourcePermission resourcePermission, String oldClassName,
				String newClassName)
			throws SystemException {

			long actionIds = 0;

			List<ResourceAction> oldResourceActions =
					ResourceActionUtil.findByName(oldClassName);

			for (ResourceAction oldResourceAction : oldResourceActions) {
				boolean hasActionId = ResourcePermissionLocalServiceUtil.hasActionId(
					resourcePermission, oldResourceAction);

				if (!hasActionId) {
					continue;
				}

				actionIds = actionIds | getActionId(
					oldResourceAction, newClassName);
			}

			return actionIds;
		}

		protected AssetCategory getAssetCategory(
				long userId, long groupId, String name)
			throws PortalException, SystemException {

			AssetVocabulary assetVocabulary = AssetVocabularyUtil.fetchByG_N(
				groupId, _ASSET_VOCABULARY_NAME);

			ServiceContext serviceContext = new ServiceContext();

			serviceContext.setScopeGroupId(groupId);
			serviceContext.setUserId(userId);

			if (assetVocabulary == null) {
				assetVocabulary = AssetVocabularyLocalServiceUtil.addVocabulary(
					userId, _ASSET_VOCABULARY_NAME, serviceContext);
			}

			AssetCategory assetCategory = AssetCategoryUtil.fetchByP_N_V(
				AssetCategoryConstants.DEFAULT_PARENT_CATEGORY_ID, name,
				assetVocabulary.getVocabularyId());

			if (assetCategory != null) {
				return assetCategory;
			}

			return AssetCategoryLocalServiceUtil.addCategory(
				userId, name, assetVocabulary.getVocabularyId(), serviceContext);
		}

		protected CalendarResource getCalendarResource(long companyId, long groupId)
			throws PortalException, SystemException {

			ServiceContext serviceContext = new ServiceContext();

			serviceContext.setCompanyId(companyId);

			long userId = UserLocalServiceUtil.getDefaultUserId(companyId);

			serviceContext.setUserId(userId);

			Group group = GroupLocalServiceUtil.getGroup(groupId);

			if (group.isUser()) {
				return CalendarResourceUtil.getUserCalendarResource(
					group.getCreatorUserId(), serviceContext);
			}

			return CalendarResourceUtil.getGroupCalendarResource(
				groupId, serviceContext);
		}

		protected String getRecurrence(TZSRecurrence tzsRecurrence) {
			if (tzsRecurrence == null) {
				return null;
			}

			Recurrence recurrence = new Recurrence();

			Frequency frequency = _frequencyMap.get(tzsRecurrence.getFrequency());

			int interval = tzsRecurrence.getInterval();

			List<Weekday> weekdays = new ArrayList<Weekday>();

			if ((frequency == Frequency.DAILY) && (interval == 0)) {
				frequency = Frequency.WEEKLY;

				interval = 1;

				weekdays.add(Weekday.MONDAY);
				weekdays.add(Weekday.TUESDAY);
				weekdays.add(Weekday.WEDNESDAY);
				weekdays.add(Weekday.THURSDAY);
				weekdays.add(Weekday.FRIDAY);
			}
			else if (frequency == Frequency.WEEKLY) {
				DayAndPosition[] dayAndPositions = tzsRecurrence.getByDay();

				for (DayAndPosition dayAndPosition : dayAndPositions) {
					Weekday weekday = _weekdayMap.get(
						dayAndPosition.getDayOfWeek());

					weekdays.add(weekday);
				}
			}

			recurrence.setInterval(interval);
			recurrence.setFrequency(frequency);
			recurrence.setWeekdays(weekdays);

			Calendar untilJCalendar = tzsRecurrence.getUntil();

			int ocurrence = tzsRecurrence.getOccurrence();

			if (untilJCalendar != null) {
				recurrence.setUntilJCalendar(untilJCalendar);
			}
			else if (ocurrence > 0) {
				recurrence.setCount(ocurrence);
			}

			return RecurrenceSerializer.serialize(recurrence);
		}

		protected void importAssetLink(AssetLink assetLink, long entryId1)
			throws PortalException, SystemException {

			long entryId2 = assetLink.getEntryId2();

			AssetEntry assetEntry2 = AssetEntryUtil.findByPrimaryKey(
				entryId2);

			if (assetEntry2.getClassNameId() ==
					ClassNameLocalServiceUtil.getClassNameId(CalEvent.class)) {

				CalEvent calEvent = CalEventUtil.findByPrimaryKey(
					assetEntry2.getClassPK());

				importCalEvent(calEvent);

				assetEntry2 = AssetEntryUtil.findByG_CU(
					calEvent.getGroupId(), calEvent.getUuid());

				entryId2 = assetEntry2.getEntryId();
			}

			long linkId = CounterLocalServiceUtil.increment();

			addAssetLink(
				linkId, assetLink.getCompanyId(), assetLink.getUserId(),
				assetLink.getUserName(), assetLink.getCreateDate(), entryId1,
				entryId2, assetLink.getType(), assetLink.getWeight());
		}

		protected void importAssets(CalEvent calEvent, long calendarBookingId)
			throws PortalException, SystemException {

			// Asset entry

			AssetEntry assetEntry = AssetEntryUtil.fetchByC_C(
					ClassNameLocalServiceUtil.getClassNameId(CalEvent.class.getName()),
				calEvent.getEventId());

			if (assetEntry == null) {
				return;
			}

			long entryId = CounterLocalServiceUtil.increment();

			addAssetEntry(
				entryId, assetEntry.getGroupId(), assetEntry.getCompanyId(),
				assetEntry.getUserId(), assetEntry.getUserName(),
				assetEntry.getCreateDate(), assetEntry.getModifiedDate(),
				ClassNameLocalServiceUtil.getClassNameId(
					CalendarBooking.class.getName()),
				calendarBookingId, calEvent.getUuid(), assetEntry.isVisible(),
				assetEntry.getStartDate(), assetEntry.getEndDate(),
				assetEntry.getPublishDate(), assetEntry.getExpirationDate(),
				assetEntry.getMimeType(), assetEntry.getTitle(),
				assetEntry.getDescription(), assetEntry.getSummary(),
				assetEntry.getUrl(), assetEntry.getLayoutUuid(),
				assetEntry.getHeight(), assetEntry.getWidth(),
				assetEntry.getPriority(), assetEntry.getViewCount());

			// Asset categories

			List<AssetCategory> assetCategories = new ArrayList<AssetCategory>();

			assetCategories.addAll(assetEntry.getCategories());

			assetCategories.add(
				getAssetCategory(
					calEvent.getUserId(), calEvent.getGroupId(),
					calEvent.getType()));

			for (AssetCategory assetCategory : assetCategories) {
				AssetEntryLocalServiceUtil.addAssetCategoryAssetEntry(
					assetCategory.getCategoryId(), entryId);
			}

			// Asset links

			List<AssetLink> assetLinks = AssetLinkLocalServiceUtil.getDirectLinks(
				assetEntry.getEntryId());

			for (AssetLink assetLink : assetLinks) {
				importAssetLink(assetLink, entryId);
			}

			// Asset tags

			List<AssetTag> assetTags = assetEntry.getTags();

			for (AssetTag assetTag : assetTags) {
				AssetEntryLocalServiceUtil.addAssetTagAssetEntry(
					assetTag.getTagId(), entryId);
			}
		}

		protected void importCalendarBookingResourcePermission(
				ResourcePermission resourcePermission, long calendarBookingId)
			throws PortalException, SystemException {

			CalendarBooking calendarBooking =
					CalendarBookingUtil.findByPrimaryKey(calendarBookingId);
			
			long actionIds = getActionIds(
				resourcePermission, CalEvent.class.getName(),
				CalendarBooking.class.getName());
			
			ResourceBlockLocalServiceUtil.updateIndividualScopePermissions(
				calendarBooking.getCompanyId(), calendarBooking.getGroupId(),
				CalendarBooking.class.getName(), calendarBooking,
				resourcePermission.getRoleId(), actionIds,
				ResourceBlockConstants.OPERATOR_SET);
		}

		protected void importCalendarBookingResourcePermissions(
				CalEvent calEvent, long calendarBookingId)
			throws PortalException, SystemException {

			List<ResourcePermission> resourcePermissions =
					ResourcePermissionUtil.findByC_N_S_P(
					calEvent.getCompanyId(), CalEvent.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL,
					String.valueOf(calEvent.getEventId()));

			for (ResourcePermission resourcePermission : resourcePermissions) {
				importCalendarBookingResourcePermission(
					resourcePermission, calendarBookingId);
			}
		}

		protected void importMBDiscussion(CalEvent calEvent, long calendarBookingId)
			throws PortalException, SystemException {

			MBDiscussion mbDiscussion = MBDiscussionUtil.fetchByC_C(
				ClassNameLocalServiceUtil.getClassNameId(CalEvent.class),
				calEvent.getEventId());

			if (mbDiscussion == null) {
				return;
			}

			long threadId = importMBThread(
				mbDiscussion.getThreadId(), calendarBookingId);

			addMBDiscussion(
				PortalUUIDUtil.generate(), CounterLocalServiceUtil.increment(),
				mbDiscussion.getGroupId(), mbDiscussion.getCompanyId(),
				mbDiscussion.getUserId(), mbDiscussion.getUserName(),
				mbDiscussion.getCreateDate(), mbDiscussion.getModifiedDate(),
				ClassNameLocalServiceUtil.getClassNameId(
					CalendarBooking.class.getName()),
				calendarBookingId, threadId);
		}

		protected long importMBMessage(
				long messageId, long threadId, long calendarBookingId,
				Map<Long, Long> mbMessageIds)
			throws PortalException, SystemException {

			MBMessage mbMessage = MBMessageUtil.findByPrimaryKey(messageId);

			return importMBMessage(
				mbMessage, threadId, calendarBookingId, mbMessageIds);
		}

		protected long importMBMessage(
				MBMessage mbMessage, long threadId, long calendarBookingId,
				Map<Long, Long> mbMessageIds)
			throws PortalException, SystemException {

			Long messageId = mbMessageIds.get(mbMessage.getMessageId());

			if (messageId != null) {
				return messageId;
			}

			messageId = CounterLocalServiceUtil.increment();

			addMBMessage(
				PortalUUIDUtil.generate(), messageId, mbMessage.getGroupId(),
				mbMessage.getCompanyId(), mbMessage.getUserId(),
				mbMessage.getUserName(), mbMessage.getCreateDate(),
				mbMessage.getModifiedDate(),
				ClassNameLocalServiceUtil.getClassNameId(
					CalendarBooking.class.getName()),
				calendarBookingId, mbMessage.getCategoryId(), threadId,
				mbMessage.getRootMessageId(), mbMessage.getParentMessageId(),
				mbMessage.getSubject(), mbMessage.getBody(), mbMessage.getFormat(),
				mbMessage.isAnonymous(), mbMessage.getPriority(),
				mbMessage.getAllowPingbacks(), mbMessage.isAnswer(),
				mbMessage.getStatus(), mbMessage.getStatusByUserId(),
				mbMessage.getStatusByUserName(), mbMessage.getStatusDate(),
				mbMessageIds);

			long mbDiscussionClassNameId = ClassNameLocalServiceUtil.getClassNameId(
				MBDiscussion.class.getName());

			importRatings(
				mbDiscussionClassNameId, mbMessage.getMessageId(),
				mbDiscussionClassNameId, messageId);

			mbMessageIds.put(mbMessage.getMessageId(), messageId);

			return messageId;
		}

		protected long importMBThread(long threadId, long calendarBookingId)
			throws PortalException, SystemException {

			MBThread mbThread = MBThreadUtil.findByPrimaryKey(threadId);

			return importMBThread(mbThread, calendarBookingId);
		}

		protected long importMBThread(MBThread mbThread, long calendarBookingId)
			throws PortalException, SystemException {

			long threadId = CounterLocalServiceUtil.increment();

			addMBThread(
				PortalUUIDUtil.generate(), threadId, mbThread.getGroupId(),
				mbThread.getCompanyId(), mbThread.getUserId(),
				mbThread.getUserName(), mbThread.getCreateDate(),
				mbThread.getModifiedDate(), mbThread.getCategoryId(), 0,
				mbThread.getRootMessageUserId(), mbThread.getMessageCount(),
				mbThread.getViewCount(), mbThread.getLastPostByUserId(),
				mbThread.getLastPostDate(), mbThread.getPriority(),
				mbThread.isQuestion(), mbThread.getStatus(),
				mbThread.getStatusByUserId(), mbThread.getStatusByUserName(),
				mbThread.getStatusDate());

			Map<Long, Long> mbMessageIds = new HashMap<Long, Long>();

			List<MBMessage> mbMessages = MBMessageUtil.findByThreadId(
				mbThread.getThreadId());

			for (MBMessage mbMessage : mbMessages) {
				importMBMessage(
					mbMessage, threadId, calendarBookingId, mbMessageIds);
			}

			updateMBThreadRootMessageId(
				threadId, mbMessageIds.get(mbThread.getRootMessageId()));

			return threadId;
		}

		protected void importRatings(
				long oldClassNameId, long oldClassPK, long classNameId,
				long classPK)
			throws SystemException {

			List<RatingsEntry> ratingsEntries = RatingsEntryUtil.findByC_C(
				oldClassNameId, oldClassPK);

			for (RatingsEntry ratingsEntry : ratingsEntries) {
				addRatingsEntry(
					CounterLocalServiceUtil.increment(), ratingsEntry.getCompanyId(),
					ratingsEntry.getUserId(), ratingsEntry.getUserName(),
					ratingsEntry.getCreateDate(), ratingsEntry.getModifiedDate(),
					classNameId, classPK, ratingsEntry.getScore());
			}

			RatingsStats ratingsStats = RatingsStatsUtil.fetchByC_C(
				oldClassNameId, oldClassPK);

			if (ratingsStats == null) {
				return;
			}

			addRatingsStats(
				CounterLocalServiceUtil.increment(), classNameId, classPK,
				ratingsStats.getTotalEntries(), ratingsStats.getTotalScore(),
				ratingsStats.getAverageScore());
		}

		protected void importSocialActivities(
				CalEvent calEvent, long calendarBookingId)
			throws SystemException {

			List<SocialActivity> socialActivities =
					SocialActivityUtil.findByC_C(
					ClassNameLocalServiceUtil.getClassNameId(CalEvent.class),
					calEvent.getEventId());

			for (SocialActivity socialActivity : socialActivities) {
				importSocialActivity(socialActivity, calendarBookingId);
			}
		}

		protected void importSocialActivity(
				SocialActivity socialActivity, long calendarBookingId)
			throws SystemException {

			addSocialActivity(
				CounterLocalServiceUtil.increment(SocialActivity.class.getName()),
				socialActivity.getGroupId(), socialActivity.getCompanyId(),
				socialActivity.getUserId(), socialActivity.getCreateDate(),
				socialActivity.getMirrorActivityId(),
				ClassNameLocalServiceUtil.getClassNameId(CalendarBooking.class),
				calendarBookingId, socialActivity.getType(),
				socialActivity.getExtraData(), socialActivity.getReceiverUserId());
		}

		protected void importSubscription(
				Subscription subscription, long calendarBookingId)
			throws SystemException {

			addSubscription(
				CounterLocalServiceUtil.increment(), subscription.getCompanyId(),
				subscription.getUserId(), subscription.getUserName(),
				subscription.getCreateDate(), subscription.getModifiedDate(),
				ClassNameLocalServiceUtil.getClassNameId(CalendarBooking.class),
				calendarBookingId, subscription.getFrequency());
		}

		protected void importSubscriptions(
				CalEvent calEvent, long calendarBookingId)
			throws SystemException {

			List<Subscription> subscriptions = SubscriptionUtil.findByC_C_C(
				calEvent.getCompanyId(),
				ClassNameLocalServiceUtil.getClassNameId(CalEvent.class),
				calEvent.getEventId());

			for (Subscription subscription : subscriptions) {
				importSubscription(subscription, calendarBookingId);
			}
		}

		protected boolean isImported(CalEvent calEvent)
			throws PortalException, SystemException {

			Group group = GroupLocalServiceUtil.getCompanyGroup(
				calEvent.getCompanyId());

			CalendarBooking calendarBooking =
					CalendarBookingUtil.fetchByUUID_G(
					calEvent.getUuid(), group.getGroupId());

			if (calendarBooking != null) {
				return true;
			}

			return false;
		}

		protected void updateMBThreadRootMessageId(
				long threadId, long rootMessageId)
			throws PortalException, SystemException {

			MBThread mbThread = MBThreadUtil.findByPrimaryKey(threadId);

			mbThread.setRootMessageId(rootMessageId);

			MBThreadUtil.update(mbThread);
		}

		private static final String _ASSET_VOCABULARY_NAME = "Calendar Event Types";

		private static Map<Integer, Frequency> _frequencyMap =
			new HashMap<Integer, Frequency>();
		private static Map<Integer, Weekday> _weekdayMap =
			new HashMap<Integer, Weekday>();

		static {
			_frequencyMap.put(TZSRecurrence.DAILY, Frequency.DAILY);
			_frequencyMap.put(TZSRecurrence.WEEKLY, Frequency.WEEKLY);
			_frequencyMap.put(TZSRecurrence.MONTHLY, Frequency.MONTHLY);
			_frequencyMap.put(TZSRecurrence.YEARLY, Frequency.YEARLY);

			_weekdayMap.put(Calendar.SUNDAY, Weekday.SUNDAY);
			_weekdayMap.put(Calendar.MONDAY, Weekday.MONDAY);
			_weekdayMap.put(Calendar.TUESDAY, Weekday.TUESDAY);
			_weekdayMap.put(Calendar.WEDNESDAY, Weekday.WEDNESDAY);
			_weekdayMap.put(Calendar.THURSDAY, Weekday.THURSDAY);
			_weekdayMap.put(Calendar.FRIDAY, Weekday.FRIDAY);
			_weekdayMap.put(Calendar.SATURDAY, Weekday.SATURDAY);
		}

}
