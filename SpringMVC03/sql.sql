select * from board;

delete from board where idx = 5;

create table member(
	memId varchar(20) not null, -- 아이디
	memPass varchar(20) not null, -- 패스워드
	memName varchar(20) not null, -- 이름
	primary key(memId)
)

insert into member values('admin','123','관리자');
insert into member values('smhrd1','123','스인개');
insert into member values('choi','123','choi');

drop table board;

create table board(
	idx int not null auto_increment,
	memId varchar(20) not null,
	title varchar(100) not null,
	contents varchar(2000) not null,
	writer varchar(20) not null,
	indate datetime default now(),
	count int default 0,
	primary key(idx)
);

create table member()