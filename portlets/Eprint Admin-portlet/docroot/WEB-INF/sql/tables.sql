create table Eprints_Eprint (
	eprintId LONG not null primary key,
	groupId LONG,
	title VARCHAR(75) null,
	urlTitle VARCHAR(75) null,
	eprintType VARCHAR(75) null,
	eprintStatus VARCHAR(75) null,
	metadataVisibility VARCHAR(75) null,
	eprintAbstract VARCHAR(75) null,
	eprintKeywords VARCHAR(75) null,
	isPublished VARCHAR(75) null,
	dateYear VARCHAR(75) null,
	fullTextStatus VARCHAR(75) null,
	companyId LONG,
	modifiedDate DATE null,
	createdDate DATE null,
	userId LONG,
	userName VARCHAR(75) null
);

create table Eprints_EprintStaticContent (
	contentId LONG not null primary key,
	content VARCHAR(75) null
);

create table Eprints_EprintSubject (
	eprintId LONG not null,
	subjectId VARCHAR(75) not null,
	subjectName VARCHAR(75) null,
	primary key (eprintId, subjectId)
);