create table User(
	user_id INT auto_increment primary key,
	username varchar(30) not null,
    password varchar(200) not null,
    user_type INT not null
);
insert into User values(0, 'admin', 'admin', 1);
create table Commodity(
	comm_id INT auto_increment  primary key,
	title varchar(200),
	owner INT not null,
	pub_date datetime not null,
	end_date datetime not null,
	closed boolean not null,
	buyer INT not null,
	image LONGBLOB not null,
	price INT not null,
	CONSTRAINT FK_OWNER FOREIGN KEY (owner) REFERENCES User (user_id),
	CONSTRAINT FK_BUYER FOREIGN KEY (buyer) REFERENCES User (user_id)
	);