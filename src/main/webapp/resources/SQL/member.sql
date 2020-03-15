--member.sql
create table member(
 mem_id varchar2(100) primary key
 ,mem_pwd varchar2(200) not null
 ,mem_name varchar2(50) not null --회원이름
 ,mem_zip varchar2(10) not null --우편번호
 ,mem_zip2 varchar2(10) not null --우편번호
 ,mem_addr varchar2(100) not null --주소
 ,mem_addr2 varchar2(100) not null --나머지주소
 ,mem_phone01 varchar2(10) --폰번호
 ,mem_phone02 varchar2(10) --폰번호
 ,mem_phone03 varchar2(10) --폰번호
 ,mail_id varchar2(50) --메일 아이디
 ,mail_domain varchar2(100) --멜도메인 주소
 ,mem_date date --가입날짜
 ,mem_state number(38) --가입회원 1,탈퇴회원 2
 ,mem_delcont varchar2(4000) --탈퇴사유
 ,mem_deldate date --탈퇴날짜
);

insert into member (mem_id,mem_pwd,mem_name,mem_zip,mem_zip2,
mem_addr,mem_addr2,mem_phone01,mem_phone02,mem_phone03,
mail_id,mail_domain,mem_date,mem_state)
values('aaaaa','77777','이순신','123','789',
'서울시 강남구 역삼동 00빌딩','401','010','777','7777',
'aaaaa','naver.com',sysdate,1);

select * from member;

--우편/주소 테이블(zipcode)
create table zipcode(
 no number(38) primary key
 ,zipcode varchar2(20) --우편번호
 ,sido varchar2(100) --시도
 ,gugun varchar2(100) --구군
 ,dong varchar2(100) --읍면동,길주소
 ,bunji varchar2(100) --번지
);

insert into zipcode values(1,'123-456','서울시','구로구',
'구로동','00빌딩 00호');
select * from zipcode;
























