create table tazkirah_Tazkirah (
	tazkirahId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	content TEXT null,
	category VARCHAR(75) null,
	status INTEGER
);

create table tazkirah_tazkirah (
	tazkirahId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	context VARCHAR(75) null,
	category VARCHAR(75) null,
	status INTEGER
);