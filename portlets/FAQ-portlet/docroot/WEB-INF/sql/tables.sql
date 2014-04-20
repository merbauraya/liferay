create table FAQ_FAQEntry (
	entryId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	question VARCHAR(255) null,
	category VARCHAR(75) null,
	answer TEXT null,
	isactive BOOLEAN,
	displayOrder LONG
);