create table usr (
	id bigserial primary key,
	username varchar(64) not null,
	password varchar(64) not null,
	role varchar(64) not null
)