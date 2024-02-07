-- DDL(Data Definition Language)
create table boards(
  board_no int primary key auto_increment,
  title varchar(255) not null,
  content text not null,
  writer varchar(30) not null,
  created_date datetime null default now()
);

insert into boards(title,content,writer)
  values('제목1','내용1','홍길동1');
insert into boards(title,content,writer)
  values(
    '제목2',
    '내용2',
    '홍길동2'
  );
insert into boards(title,content,writer) values('제목3','내용3','홍길동3');
insert into boards(title,content,writer) values('제목4','내용4','홍길동4');

select * from boards;

select *
from boards
where board_no = 3;

update boards set
  title='okok',
  content='nono',
  writer='hoho'
where board_no = 3;


delete from boards where board_no=3; --where 조건이 빠지면 그 테이블을 다 지워버리므로 주의!

--Assignment--------------------------------------------------------------------------------
create table assignments(
  assignment_no int primary key auto_increment,
  title varchar(255) not null,
  content text not null,
  deadline date not null
);

drop table assignment;

GRANT ALL PRIVILEGES ON 디비이름.* TO 유저이름@위치;

create table members(
  member_no int primary key auto_increment,
  email varchar(255) not null,
  name varchar(255) not null,
  password varchar(100) not null,
  created_date datetime null default now()
);

--혹은 date이면 (CURRENT_TIME)

insert into members(email,name,password) values('꾸앵쓰@눼이바닷컴','꾸앵이',sha2('꾸앵눼이바!@#!',256));
insert into members(email,name,password) values('뿌앵쓰@눼이바닷컴','뿌앵이',sha2('q1w2e3r4',256));


--add column
ALTER TABLE BOARDS ADD COLUMN category int not null;f