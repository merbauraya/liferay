create index IX_3793AB1 on item (groupId);
create index IX_28461BFF on item (status);

create index IX_A3F7E5D5 on subur_Author (companyId, groupId);
create index IX_88B92498 on subur_Author (firstName);
create index IX_13641B8D on subur_Author (firstName, lastName);
create index IX_5AD12237 on subur_Author (groupId);
create index IX_852A2991 on subur_Author (groupId, companyId);
create index IX_1B15B1FC on subur_Author (idType);
create index IX_1E27D908 on subur_Author (lastName);

create index IX_874C6104 on subur_AuthorExpertise (authorId);
create index IX_B844D872 on subur_AuthorExpertise (expertiseId);
create index IX_9E529FE0 on subur_AuthorExpertise (groupId);
create unique index IX_6C3A3E0C on subur_AuthorExpertise (groupId, expertiseName);

create index IX_943EF53 on subur_Division (depositable);

create index IX_498CB735 on subur_Expertise (groupId);
create unique index IX_A61DF217 on subur_Expertise (groupId, expertiseName);
create unique index IX_800D6737 on subur_Expertise (groupId, indexedName);

create index IX_80652B2F on subur_Item (groupId);
create index IX_2FA0D6B7 on subur_Item (itemTypeId);
create index IX_E1FB23C1 on subur_Item (status);

create index IX_CA02B100 on subur_ItemAuthor (authorId);
create index IX_8B76B888 on subur_ItemAuthor (itemId);

create index IX_C367AF84 on subur_ItemDivision (divisionId);
create index IX_FB83BBEA on subur_ItemDivision (itemId);

create index IX_818C0689 on subur_ItemFileEntry (itemId);

create index IX_1063F82A on subur_ItemItemType (itemId);
create index IX_19223804 on subur_ItemItemType (itemTypeId);

create index IX_6791B69F on subur_ItemSubject (itemId);
create index IX_123CC91A on subur_ItemSubject (subjectId);

create index IX_338A5B33 on subur_MetadataPropertyValue (itemId);

create index IX_D36F038 on subur_Subject (depositable);

create index IX_F7FB59BA on subur_SubjectTree (depositable);

create index IX_BBD2734F on subur_item (groupId);
create index IX_1DB457A1 on subur_item (status);