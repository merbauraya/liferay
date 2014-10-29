create table ide_ExpertiseTag (
	tagId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	tagName VARCHAR(75) null,
	userCount INTEGER
);

create table ide_OrgChart (
	userId LONG not null,
	parentId LONG not null,
	primary key (userId, parentId)
);

create table ide_ServiceExperience (
	serviceExperienceId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	startDate DATE null,
	title VARCHAR(75) null,
	endDate DATE null,
	serviceData VARCHAR(75) null,
	status INTEGER
);

create table ide_UserEntries_ExpertiseTags (
	userId LONG not null,
	tagId LONG not null,
	primary key (userId, tagId)
);

create table ide_UserExpertise (
	userExpertiseId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	expertiseData VARCHAR(75) null
);