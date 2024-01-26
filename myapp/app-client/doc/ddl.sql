-- DDL(Data Definition Language)
create table boards(
  board_no int primary key auto_increment,
  title varchar(255) not null,
  content text not null,
  writer varchar(30) not null,
  created_date datetime null default now()
);

insert into boards(title,content,writer) values('제목1','내용1','홍길동1');
insert into boards(title,content,writer) values('제목2','내용2','홍길동2');
insert into boards(title,content,writer) values('제목3','내용3','홍길동3');
insert into boards(title,content,writer) values('제목4','내용4','홍길동4');

select * from boards;