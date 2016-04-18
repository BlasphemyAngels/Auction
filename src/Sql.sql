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
	buyer INT ,
	image LONGBLOB not null,
	price INT not null,
	CONSTRAINT FK_OWNER FOREIGN KEY (owner) REFERENCES User (user_id),
	CONSTRAINT FK_BUYER FOREIGN KEY (buyer) REFERENCES User (user_id)
);

create table Bid(
	comm_id INT not null,
	buyer INT not null,
	price INT not null,
	cDate datetime not null,
	note varchar(200),
	CONSTRAINT FK_COMM2 FOREIGN KEY (comm_id) REFERENCES Commodity (comm_id),
	CONSTRAINT FK_BUYER2 FOREIGN KEY (buyer) REFERENCES User (user_id)
);