create index IX_220A5F5B on Eprint_Eprint (eprintType);

create index IX_2BAAC4D8 on Eprints_Eprint (eprintType);
create unique index IX_6A018AA5 on Eprints_Eprint (groupId, urlTitle);

create index IX_4C2C777B on eprint_Eprint (eprintType);