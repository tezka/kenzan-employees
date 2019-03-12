CREATE TABLE employee(
	id int not null auto_increment,
	first_name varchar(40) not null,
	middle_name varchar(30),
	last_name varchar(50) not null,
	date_of_birth date not null,
	date_of_employment date not null,
	status varchar(13) default 'ACTIVE',
	primary key(id)
) CHARSET=utf8;
