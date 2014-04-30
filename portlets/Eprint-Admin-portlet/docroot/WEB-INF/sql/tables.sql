create table Eprint_Eprint (
	eprintId LONG not null primary key,
	title VARCHAR(75) null,
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
	groupId LONG
);

create table Eprint_EprintStaticContent (
	contentId LONG not null primary key,
	content VARCHAR(75) null
);

create table Eprint_EprintSubject (
	eprintId LONG not null,
	subjectId VARCHAR(75) not null,
	subjectName VARCHAR(75) null,
	primary key (eprintId, subjectId)
);

create table Eprints_Eprint (
	eprintId LONG not null primary key,
	groupId LONG,
	userId LONG,
	title VARCHAR(1024) null,
	urlTitle VARCHAR(1024) null,
	eprintType VARCHAR(255) null,
	eprintStatus VARCHAR(75) null,
	metadataVisibility VARCHAR(75) null,
	eprintAbstract TEXT null,
	eprintKeywords TEXT null,
	isPublished VARCHAR(75) null,
	dateYear VARCHAR(75) null,
	fullTextStatus VARCHAR(75) null,
	companyId LONG,
	modifiedDate DATE null,
	createdDate DATE null
);

create table Eprints_EprintDivision (
	eprintId LONG not null,
	divisionId VARCHAR(128) not null,
	divisionName VARCHAR(255) null,
	primary key (eprintId, divisionId)
);

create table Eprints_EprintStaticContent (
	contentId LONG not null primary key,
	content TEXT null
);

create table Eprints_EprintSubject (
	eprintId LONG not null,
	subjectId VARCHAR(128) not null,
	subjectName VARCHAR(255) null,
	primary key (eprintId, subjectId)
);

create table eprint_Eprint (
	eprintId LONG not null primary key,
	title VARCHAR(75) null,
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
	groupId LONG
);

create table eprint_EprintStaticContent (
	contentId LONG not null primary key,
	content VARCHAR(75) null
);

create table eprint_EprintSubject (
	eprintId LONG not null,
	subjectId VARCHAR(75) not null,
	subjectName VARCHAR(75) null,
	primary key (eprintId, subjectId)
);