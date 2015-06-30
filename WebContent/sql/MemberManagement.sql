select * from member;

drop table member;

show tables;

create table member (
	name varchar(50),
    userid varchar(50),
    pwd varchar(50),
    email varchar(50)
);
insert into member values("woo", "dew1405", "1111", "dew1405@naver.com");