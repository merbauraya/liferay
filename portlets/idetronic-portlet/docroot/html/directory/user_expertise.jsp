
<%

String editExpertiseURL = UserServiceUtil.getEditExpertiseURL(request,renderResponse.getNamespace(),selUser.getUserId());
List userExpertises = UserEntries_ExpertiseTagsLocalServiceUtil.getUserEntry(selUser.getUserId());
ExpertiseTag expertiseTag = null;
UserEntries_ExpertiseTags userTag = null;
String selectedTag = "";
for (Object obj: userExpertises)
{
	Object[] arrayobject=(Object[])obj;
	expertiseTag = (ExpertiseTag) arrayobject[0];
	userTag = (UserEntries_ExpertiseTags) arrayobject[1];
	
	String tag = expertiseTag.getTagName();
%>
<div class="bootstrap-tagsinput">
	<span class="tag label label-info"><%=tag %></span>	
	</div>
<%	
}
%>