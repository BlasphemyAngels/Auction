create table User(username varchar(30) not null,
    password varchar(200) not null,
     email varchar(20) not null,
     first_name varchar(20) not null,
     last_name varchar(20) not null,
     user_type INT not null
     );
 insert into User values('admin', 'admin', '937312135@qq.com', 'cao', 'chenglong', 1);