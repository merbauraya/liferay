<%@ include file="/html/eprint/init.jsp" %>
<%
String eprintURL = portletPreferences.getValue("eprintURL","");
boolean enableFlags = GetterUtil.getBoolean(portletPreferences.getValue("enableFlags", null), true);
boolean enableRelatedAssets = GetterUtil.getBoolean(portletPreferences.getValue("enableRelatedAssets", null), true);
boolean enableRatings = GetterUtil.getBoolean(portletPreferences.getValue("enableRatings", null), true);
boolean enableComments = GetterUtil.getBoolean(portletPreferences.getValue("enableComments", null), true);
boolean enableCommentRatings = GetterUtil.getBoolean(portletPreferences.getValue("enableCommentRatings", null), true);
boolean enableSocialBookmarks = GetterUtil.getBoolean(portletPreferences.getValue("enableSocialBookmarks", null), true);


//boolean enableSocialBookmarks = GetterUtil.getBoolean(portletPreferences.getValue("enableSocialBookmarks", null), true);
String socialBookmarksDisplayStyle = portletPreferences.getValue("socialBookmarksDisplayStyle", "horizontal");
String socialBookmarksDisplayPosition = portletPreferences.getValue("socialBookmarksDisplayPosition", "bottom");
String socialBookmarksTypes = portletPreferences.getValue("socialBookmarksTypes", PropsUtil.get(PropsKeys.SOCIAL_BOOKMARK_TYPES));

%>