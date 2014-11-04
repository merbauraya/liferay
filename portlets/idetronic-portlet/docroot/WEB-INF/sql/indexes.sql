create index IX_1BE66C11 on ide_ExpertiseTag (tagName);

create index IX_DE5F004E on ide_OrgChart (parentId);
create index IX_52E83CAF on ide_OrgChart (userId);

create index IX_2FA6D90A on ide_ServiceExperience (userId);

create index IX_AB41BFE4 on ide_UserEntries_ExpertiseTags (tagId);
create index IX_DBD43BFB on ide_UserEntries_ExpertiseTags (userId);