create table User(username varchar(30) not null,
    password varchar(200) not null,
     user_type INT not null
     );
 insert into User values('admin', 'admin', 1);