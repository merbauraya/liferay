create table ruangj_Item (
	itemId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	itemType INTEGER
);

create table ruangj_ItemFileEntry (
	itemEntryId LONG not null primary key,
	itemId LONG,
	fileEntryId LONG,
	fileType VARCHAR(75) null,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);