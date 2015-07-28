create table Subur_Author (
	authorId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	title VARCHAR(75) null,
	idType INTEGER,
	remoteId VARCHAR(75) null,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	middleName VARCHAR(75) null,
	userId INTEGER,
	metadata VARCHAR(75) null,
	lastPublishedDate DATE null,
	itemCount INTEGER,
	personalSite VARCHAR(75) null
);

create table Subur_AuthorExpertise (
	authorId LONG not null,
	expertiseId LONG not null,
	primary key (authorId, expertiseId)
);

create table Subur_AuthorSite (
	authorSiteId LONG not null primary key,
	authorId LONG,
	siteName VARCHAR(75) null,
	siteURL VARCHAR(150) null
);

create table Subur_DownloadSummary (
	id_ LONG not null primary key,
	itemId LONG,
	perMonth INTEGER,
	perYear INTEGER,
	status INTEGER
);

create table Subur_Expertise (
	expertiseId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	expertiseName VARCHAR(75) null,
	indexedName VARCHAR(75) null,
	modifiedDate DATE null,
	authorCount INTEGER
);

create table Subur_ItemAuthor (
	itemId LONG not null,
	authorId LONG not null,
	primary key (itemId, authorId)
);

create table Subur_ItemFileEntry (
	itemId LONG not null,
	fileEntryId LONG not null,
	entryType LONG,
	primary key (itemId, fileEntryId)
);

create table Subur_ItemItemType (
	itemId LONG not null,
	itemTypeId LONG not null,
	primary key (itemId, itemTypeId)
);

create table Subur_ItemType (
	ItemTypeId LONG not null primary key,
	ItemTypeName VARCHAR(75) null,
	itemCount INTEGER
);

create table Subur_ItemTypeTemplate (
	itemTypeId LONG not null,
	metadataPropertyId LONG not null,
	required BOOLEAN,
	primary key (itemTypeId, metadataPropertyId)
);

create table Subur_MetadataProperty (
	metadataPropertyId LONG not null primary key,
	metadataSchemaId LONG,
	element VARCHAR(255) null,
	scope VARCHAR(255) null,
	note VARCHAR(1024) null
);

create table Subur_MetadataPropertyValue (
	metadataPropertyValueId LONG not null primary key,
	itemId LONG,
	propertyId LONG,
	textValue TEXT null,
	itemCount INTEGER
);

create table Subur_MetadataSchema (
	metadataSchemaId LONG not null primary key,
	metadataName VARCHAR(1024) null,
	nameSpace VARCHAR(75) null
);

create table Subur_StatDownloadCategory (
	id_ LONG not null primary key,
	perMonth INTEGER,
	perYear INTEGER,
	categoryId LONG
);

create table Subur_StatDownloadItemType (
	id_ LONG not null primary key,
	perMonth INTEGER,
	perYear INTEGER,
	itemTypeId LONG
);

create table Subur_StatDownloadPeriod (
	id_ LONG not null primary key,
	itemId LONG,
	perMonth INTEGER,
	perYear INTEGER
);

create table Subur_StatDownloadTag (
	id_ LONG not null primary key,
	perMonth INTEGER,
	perYear INTEGER,
	tagId LONG
);

create table Subur_StatViewCategory (
	id_ LONG not null primary key,
	perMonth INTEGER,
	perYear INTEGER,
	categoryId LONG
);

create table Subur_StatViewItemType (
	id_ LONG not null primary key,
	perMonth INTEGER,
	perYear INTEGER,
	itemTypeId LONG
);

create table Subur_StatViewTag (
	id_ LONG not null primary key,
	perMonth INTEGER,
	perYear INTEGER,
	tagId LONG
);

create table Subur_ViewSummary (
	id_ LONG not null primary key,
	itemId LONG,
	perMonth INTEGER,
	perYear INTEGER,
	status INTEGER
);

create table item (
	itemId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	itemAbstract VARCHAR(75) null,
	status INTEGER
);

create table subur_Author (
	authorId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	title VARCHAR(75) null,
	idType INTEGER,
	remoteId VARCHAR(75) null,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	userId INTEGER,
	metadata VARCHAR(75) null,
	lastPublishedDate DATE null,
	itemCount INTEGER,
	personalSite VARCHAR(75) null,
	googleScholar VARCHAR(120) null
);

create table subur_AuthorExpertise (
	authorId LONG not null,
	expertiseId LONG not null,
	primary key (authorId, expertiseId)
);

create table subur_Division (
	divisionId LONG not null primary key,
	parentId LONG,
	divisionName VARCHAR(75) null,
	depositable BOOLEAN
);

create table subur_DownloadSummary (
	id_ LONG not null primary key,
	itemId LONG,
	perMonth INTEGER,
	perYear INTEGER,
	status INTEGER
);

create table subur_Expertise (
	expertiseId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	expertiseName VARCHAR(75) null,
	indexedName VARCHAR(75) null,
	modifiedDate DATE null,
	authorCount INTEGER
);

create table subur_FileEntryType (
	typeId LONG not null primary key,
	typeName VARCHAR(75) null
);

create table subur_Item (
	itemId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(1024) null,
	itemAbstract STRING null,
	status INTEGER
);

create table subur_ItemAuthor (
	itemId LONG not null,
	authorId LONG not null,
	primary key (itemId, authorId)
);

create table subur_ItemDivision (
	itemId LONG not null,
	divisionId LONG not null,
	primary key (itemId, divisionId)
);

create table subur_ItemFileEntry (
	itemId LONG not null,
	fileEntryId LONG not null,
	entryType LONG,
	primary key (itemId, fileEntryId)
);

create table subur_ItemItemType (
	itemId LONG not null,
	itemTypeId LONG not null,
	primary key (itemId, itemTypeId)
);

create table subur_ItemSubject (
	itemId LONG not null,
	subjectId LONG not null,
	primary key (itemId, subjectId)
);

create table subur_ItemType (
	ItemTypeId LONG not null primary key,
	ItemTypeName VARCHAR(75) null,
	itemCount INTEGER
);

create table subur_ItemTypeTemplate (
	itemTypeId LONG not null,
	metadataPropertyId LONG not null,
	required BOOLEAN,
	primary key (itemTypeId, metadataPropertyId)
);

create table subur_MetadataProperty (
	metadataPropertyId LONG not null primary key,
	metadataSchemaId LONG,
	element VARCHAR(255) null,
	scope VARCHAR(255) null,
	note VARCHAR(1024) null
);

create table subur_MetadataPropertyValue (
	metadataPropertyValueId LONG not null primary key,
	itemId LONG,
	propertyId LONG,
	textValue TEXT null,
	itemCount INTEGER
);

create table subur_MetadataSchema (
	metadataSchemaId LONG not null primary key,
	metadataName VARCHAR(1024) null,
	nameSpace VARCHAR(75) null
);

create table subur_MetadataValue (
	metadataValueId LONG not null primary key,
	itemId LONG,
	propertyId LONG,
	textValue VARCHAR(75) null
);

create table subur_MetadataValueView (
	propertyId LONG not null,
	subjectId LONG not null,
	subjectName VARCHAR(75) null,
	textValue VARCHAR(75) null,
	itemCount INTEGER,
	primary key (propertyId, subjectId)
);

create table subur_StatDownloadCategory (
	id_ LONG not null primary key,
	perMonth INTEGER,
	perYear INTEGER,
	categoryId LONG
);

create table subur_StatDownloadItemType (
	id_ LONG not null primary key,
	perMonth INTEGER,
	perYear INTEGER,
	itemTypeId LONG
);

create table subur_StatDownloadPeriod (
	id_ LONG not null primary key,
	itemId LONG,
	perMonth INTEGER,
	perYear INTEGER
);

create table subur_StatDownloadTag (
	id_ LONG not null primary key,
	perMonth INTEGER,
	perYear INTEGER,
	tagId LONG
);

create table subur_StatViewCategory (
	id_ LONG not null primary key,
	perMonth INTEGER,
	perYear INTEGER,
	categoryId LONG
);

create table subur_StatViewItemType (
	id_ LONG not null primary key,
	perMonth INTEGER,
	perYear INTEGER,
	itemTypeId LONG
);

create table subur_StatViewPeriod (
	id_ LONG not null primary key,
	itemId LONG,
	perMonth INTEGER,
	perYear INTEGER
);

create table subur_StatViewTag (
	id_ LONG not null primary key,
	perMonth INTEGER,
	perYear INTEGER,
	tagId LONG
);

create table subur_Subject (
	subjectId LONG not null primary key,
	parentId LONG,
	subjectName VARCHAR(75) null,
	lft INTEGER,
	rgt INTEGER,
	depositable BOOLEAN,
	itemCount INTEGER
);

create table subur_SubjectTree (
	subjectId LONG not null primary key,
	parentId LONG,
	subjectName VARCHAR(75) null,
	lft INTEGER,
	rgt INTEGER,
	depositable BOOLEAN,
	itemCount INTEGER
);

create table subur_ViewSummary (
	id_ LONG not null primary key,
	itemId LONG,
	perMonth INTEGER,
	perYear INTEGER,
	status INTEGER
);

create table subur_item (
	itemId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	publishedDate DATE null,
	title VARCHAR(255) null,
	itemAbstract TEXT null,
	language VARCHAR(75) null,
	status INTEGER,
	Uuid VARCHAR(75) null,
	metadataValue TEXT null
);