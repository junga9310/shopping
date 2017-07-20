CUSTOMER 
drop table customer;

CREATE TABLE CUSTOMER (
	U_ID VARCHAR2(12) NOT NULL, /* USER_ID */
	U_NAME VARCHAR2(10) NOT NULL, /* USER_NAME */
	U_PW VARCHAR2(16) NOT NULL, /* USER_PW */
	U_EMAIL VARCHAR2(50), /* USER_EMAIL */
	E_REC INT, /* EMAIL_REC */
	U_PHONE VARCHAR2(20), /* USER_PHONE */
	U_POST CHAR(6), /* USER_POST */
	U_ADDR VARCHAR2(50), /* USER_ADD */
	U_ADDR_DETAIL VARCHAR2(100), /* USER_ADD_DETAIL */
	U_LEVEL INT, /* USER_LEVEL */
	U_INDATE DATE , /* USER_INDATE */
	U_OUTDATE DATE /* USER_OUTDATE */
);

CREATE UNIQUE INDEX PK_CUSTOMER
	ON CUSTOMER (
		U_ID ASC
	);

ALTER TABLE CUSTOMER
	ADD
		CONSTRAINT PK_CUSTOMER
		PRIMARY KEY (
			U_ID
		);



alter table buy  add constraint buy_pay check( payment=1 or payment=2);
alter table product  add constraint pro_genre check (p_genre='dance' or p_genre='pop'or p_genre='트로트' or p_genre='rock'or p_genre='ballad'or p_genre='classic'or p_genre='hiphop'or p_genre='ost');


--이것들도 다 추가해 주세요!!!
--이메일 체크여부 제약조건 1=동의, 0=비동의
alter table customer  add constraint cust_erec check( e_rec=1 or e_rec=0);

--회원등급 체크여부 제약조건 0=관리자 1=일반회원 2=vip회원
alter table customer  add constraint cust_level check( u_level=0 or u_level=1 or u_level=2);

--유저레벨 일반회원으로 디폴트
alter table customer modify (u_level default 1);

insert into customer values ('admin','관리자', 'tiger1234', 'admin@gmail.com', 1, '01011111111', null, null,null,0, '2000-01-01', null);
insert into customer values 
('mkim', '김진수', 'asd123', 'vodmkpo3@gmail.com', 1, '01044412234', 16912, '수원시', '영통구 살구골',1, '2014-05-12', null);
insert into customer values 
('asdkg34im', '김영수', 'assdd123', 'helloyo@gmail.com', 1, '01012341234', 12342, '서울시', '상동구 양천동',1, '2004-07-12', null);
insert into customer values 
('dsk123im', '김학수', 'asd1dd23', 'ganadara@gmail.com', 1, '01000000982', 15212, '서울시', '팔달구 이영골',1, '2004-08-02', null);
insert into customer values 
('abfkig34m', '박정수', 'asd1d23', 'panda@gmail.com', 1, '01009820982', 32912, '성남시', '강남구 사양동',1, '2014-05-14', null);
insert into customer values 
('mksfsim', '구한수', 'asd12s23', 'yolo@gmail.com', 1, '01123420982', 11112, '가양시', '자너구 살구골',1, '2012-04-09', null);
insert into customer values 
('mk113', '가나수', 'asd12d33', 'korea@gmail.com', 1, '01009821920', 43212, '고양시', '송파구 제일골',1, '2013-02-22', null);



select * from customer;

select * from Qna;

drop table Qna;

CREATE TABLE Qna(
    BOARD_NUM        VARCHAR2(20),
    BOARD_NAME        VARCHAR2(20) not null,
    BOARD_PASS        VARCHAR2(15) not null,
    BOARD_SUBJECT        VARCHAR2(50) not null,
    BOARD_CONTENT    VARCHAR2(2000) not null,
    BOARD_FILE        VARCHAR2(50),
    BOARD_FSIZE        INT,
    BOARD_RE_REF        INT,
    BOARD_RE_LEV        INT,
    BOARD_RE_SEQ        INT,
    BOARD_READNUM    INT,
    BOARD_DATE        DATE not null,
    PRIMARY KEY(BOARD_NUM)
);


insert into Qna values('1','이수빈','1234','제목입니다','내용',null,0,0,0,0,0,sysdate);


commit
