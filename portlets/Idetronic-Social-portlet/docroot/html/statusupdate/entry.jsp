<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This file is part of Liferay Social Office. Liferay Social Office is free
 * software: you can redistribute it and/or modify it under the terms of the GNU
 * Affero General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * Liferay Social Office is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Liferay Social Office. If not, see http://www.gnu.org/licenses/agpl-3.0.html.
 */
--%>

<%@ include file="/html/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

long microblogsEntryId = ParamUtil.getLong(request, "microblogsEntryId");

if (microblogsEntryId <= 0) {
	microblogsEntryId = GetterUtil.getLong(request.getAttribute("view_comments.jsp-receiverMicroblogsEntryId"));
}

MicroblogsEntry microblogsEntry = null;

if (microblogsEntryId > 0) {
	try {
		microblogsEntry = MicroblogsEntryLocalServiceUtil.getMicroblogsEntry(microblogsEntryId);
	}
	catch (NoSuchEntryException nsee) {
	}
}

String modifiedDate = StringPool.BLANK;

long receiverUserId = 0;

String receiverUserDisplayURL = StringPool.BLANK;
String receiverUserFullName = StringPool.BLANK;
String receiverUserPortaitURL = StringPool.BLANK;
String receiverUserScreenName = StringPool.BLANK;

boolean edit = ParamUtil.getBoolean(request, "edit");
boolean repost = ParamUtil.getBoolean(request, "repost");

if ((microblogsEntry != null) && !edit) {
	modifiedDate = dateFormatDateTime.format(microblogsEntry.getModifiedDate());

	receiverUserId = microblogsEntry.getUserId();

	receiverUserFullName = HtmlUtil.escape(PortalUtil.getUserName(microblogsEntry));

	try {
		User receiverUser = UserLocalServiceUtil.getUserById(microblogsEntry.getUserId());

		receiverUserDisplayURL = receiverUser.getDisplayURL(themeDisplay);
		receiverUserPortaitURL = receiverUser.getPortraitURL(themeDisplay);
		receiverUserScreenName = receiverUser.getScreenName();
	}
	catch (NoSuchUserException nsue) {
	}
}

String formId = String.valueOf(microblogsEntryId);

if (edit) {
	formId = "Edit" + formId;
}

String formName = "fm" + formId;

String formCssClass = "microblogs-entry-form";

boolean comment = GetterUtil.getBoolean((String)request.getAttribute("view_comments.jsp-comment"), false);

if (comment) {
	formCssClass += " reply";
}
%>
<form action="#" method="post" role="form" enctype="multipart/form-data" class="facebook-share-box">
            <ul class="post-types">
                <li class="post-type">
                    <a class="status" title="" href="#"><i class="icon icon-file"></i> Share an Update</a>
                </li>
                <li class="post-type">
                    <a class="photos" href="#"><i class="icon icon-camera"></i> Add photos</a>
                </li>
            </ul>
            <div class="share">
                <div class="arrow"></div>
                <div class="panel panel-default">
                      <div class="panel-heading"><i class="fa fa-file"></i> Update Status</div>
                      <div class="panel-body">
                        <div class="">
                            <textarea name="message" cols="40" rows="10" id="status_message" class="form-control message" style="height: 62px; overflow: hidden;" placeholder="What's on your mind ?"></textarea>
                        </div>
                      </div>
                        <div class="panel-footer">
                                <div class="row">
                                    <div class="col-md-7">
                                        <div class="form-group">
                                            <div class="btn-group">
                                              <button type="button" class="btn btn-default"><i class="icon icon-map-marker"></i> Location</button>
                                              <button type="button" class="btn btn-default"><i class="icon icon-picture"></i> Photo</button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-5">
                                        <div class="form-group">
                                            <select name="privacy" class="form-control privacy-dropdown pull-left input-sm">
                                                <option value="1" selected="selected">Public</option>
                                                <option value="2">Only my friends</option>
                                                <option value="3">Only me</option>
                                            </select>                                    
                                            <input type="submit" name="submit" value="Post" class="btn btn-primary">                              
                                        </div>
                                    </div>
                                </div>
                        </div>
                    </div>
            </div>
            </div>
        </form>



<script type="text/javascript">
        $(document).ready(function(){
            $('.status').click(function() { $('.arrow').css("left", 0);});
            $('.photos').click(function() { $('.arrow').css("left", 146);});
        });
    </script>