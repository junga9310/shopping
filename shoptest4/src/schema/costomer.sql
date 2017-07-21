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
alter table product  add constraint pro_genre check (p_genre='dance' or p_genre='pop'or p_genre='Ʈ��Ʈ' or p_genre='rock'or p_genre='ballad'or p_genre='classic'or p_genre='hiphop'or p_genre='ost');


--�̰͵鵵 �� �߰��� �ּ���!!!
--�̸��� üũ���� �������� 1=����, 0=����
alter table customer  add constraint cust_erec check( e_rec=1 or e_rec=0);

--ȸ����� üũ���� �������� 0=������ 1=�Ϲ�ȸ�� 2=vipȸ��
alter table customer  add constraint cust_level check( u_level=0 or u_level=1 or u_level=2);

--�������� �Ϲ�ȸ������ ����Ʈ
alter table customer modify (u_level default 1);

insert into customer values ('admin','������', 'tiger1234', 'admin@gmail.com', 1, '01011111111', null, null,null,0, '2000-01-01', null);
insert into customer values 
('mkim', '������', 'asd123', 'vodmkpo3@gmail.com', 1, '01044412234', 16912, '������', '���뱸 �챸��',1, '2014-05-12', null);
insert into customer values 
('asdkg34im', '�迵��', 'assdd123', 'helloyo@gmail.com', 1, '01012341234', 12342, '�����', '�󵿱� ��õ��',1, '2004-07-12', null);
insert into customer values 
('dsk123im', '���м�', 'asd1dd23', 'ganadara@gmail.com', 1, '01000000982', 15212, '�����', '�ȴޱ� �̿���',1, '2004-08-02', null);
insert into customer values 
('abfkig34m', '������', 'asd1d23', 'panda@gmail.com', 1, '01009820982', 32912, '������', '������ ��絿',1, '2014-05-14', null);
insert into customer values 
('mksfsim', '���Ѽ�', 'asd12s23', 'yolo@gmail.com', 1, '01123420982', 11112, '�����', '�ڳʱ� �챸��',1, '2012-04-09', null);
insert into customer values 
('mk113', '������', 'asd12d33', 'korea@gmail.com', 1, '01009821920', 43212, '����', '���ı� ���ϰ�',1, '2013-02-22', null);


select * from customer;

drop table Qna;

  CREATE TABLE "WATERMELON"."QNA" 
   (   
   "BOARD_NUM" NUMBER(*,0), 
   "BOARD_NAME" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
   "BOARD_PASS" VARCHAR2(15 BYTE) NOT NULL ENABLE, 
   "BOARD_SUBJECT" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
   "BOARD_CONTENT" VARCHAR2(2000 BYTE) NOT NULL ENABLE, 
   "BOARD_FILE" VARCHAR2(50 BYTE), 
   "BOARD_FSIZE" NUMBER(*,0), 
   "BOARD_RE_REF" NUMBER(*,0), 
   "BOARD_RE_LEV" NUMBER(*,0), 
   "BOARD_RE_SEQ" NUMBER(*,0), 
   "BOARD_READNUM" NUMBER(*,0), 
   "BOARD_DATE" DATE NOT NULL ENABLE, 
    PRIMARY KEY ("BOARD_NUM")
  
	USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
    STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
    PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
    TABLESPACE "SYSTEM"  ENABLE
  ) SEGMENT CREATION IMMEDIATE 
    PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
    STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
    PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
    TABLESPACE "SYSTEM" ;
    
CREATE SEQUENCE  bd_seq
MINVALUE 1 
MAXVALUE 99999999999999999999999 
INCREMENT BY 1 
START WITH 1 ;

grant select, alter  on bd_seq  to watermelon;

insert into Qna values('1','�̼���','1234','�����Դϴ�','����',null,0,0,0,0,0,sysdate);


commit



/* B_NO */
CREATE SEQUENCE B_NO 
	MINVALUE 1
	MAXVALUE 99999999999999999999999
	INCREMENT BY 1
	START WITH 1;

/* O_NO */
CREATE SEQUENCE O_NO 
	MINVALUE 1
	MAXVALUE 9999999999999999999999999999
	INCREMENT BY 1
	START WITH 1;

/* PRODUCT_ID */
CREATE SEQUENCE P_ID 
	MINVALUE 1
	MAXVALUE 9999999999999999999999999999
	INCREMENT BY 1
	START WITH 1;

/* REVIEW_NO */
CREATE SEQUENCE R_NO 
	MINVALUE 1
	MAXVALUE 9999999999999999999999999999
	INCREMENT BY 1
	START WITH 1;

/* ȸ�� */
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
	U_INDATE DATE, /* USER_INDATE */
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

/* ��ǰ */
CREATE TABLE PRODUCT (
	P_ID NUMBER(5,0) NOT NULL, /* PRODUCT_ID */
	P_NAME VARCHAR2(20), /* PRODUCT_NAME */
	P_SINGER VARCHAR2(20), /* PRODUCT_SINGER */
	P_PRICE INT, /* PRICE */
	P_DESC VARCHAR2(100), /* DESCRIPTION */
	P_COMP VARCHAR2(55), /* COMPANY */
	P_HIT INT, /* PRODUCT_HIT */
	P_GENRE VARCHAR2(20), /* GENRE */
	P_QTT INT, /* QUANTITY */
	P_DATE DATE /* RELEASED_DATE */
);

alter table product add(P_image varchar2(500));
alter table product modify(P_DESC varchar2(999));

CREATE UNIQUE INDEX PK_PRODUCT
	ON PRODUCT (
		P_ID ASC
	);

ALTER TABLE PRODUCT
	ADD
		CONSTRAINT PK_PRODUCT
		PRIMARY KEY (
			P_ID
		);

/* ���� ���̺� */
CREATE TABLE BUY (
	O_NO NUMBER(10,0) NOT NULL, /* O_NO */
	U_ID VARCHAR2(12), /* U_ID */
	TOT_PRICE INT, /* TOT_PRICE */
	PAYMENT INT, /* PAYMENT */
	O_DATE DATE /* O_DATE */
);

CREATE UNIQUE INDEX PK_BUY
	ON BUY (
		O_NO ASC
	);

ALTER TABLE BUY
	ADD
		CONSTRAINT PK_BUY
		PRIMARY KEY (
			O_NO
		);


/* ��ٱ��� */
CREATE TABLE CART (
	U_ID VARCHAR2(12) NOT NULL, /* USER_ID */
	P_ID NUMBER(5,0) NOT NULL, /* PRODUCT_ID */
	C_QTT INT, /* QUANTITY */
	C_IMAGE VARCHAR2(550), /* IMAGE */
	C_DATE DATE /* DATE */
);

CREATE UNIQUE INDEX PK_CART
	ON CART (
		U_ID ASC,
		P_ID ASC
	);

ALTER TABLE CART
	ADD
		CONSTRAINT PK_CART
		PRIMARY KEY (
			U_ID,
			P_ID
		);

/* ���� ���̺�2 */
CREATE TABLE BUY2 (
	O_NO NUMBER(10,0), /* O_NO */
	P_ID NUMBER(5,0), /* PRODUCT_ID */
	P_AMOUNT INT /* PRODUCT_AMOUNT */
);

ALTER TABLE BUY
	ADD
		CONSTRAINT FK_CUSTOMER_TO_BUY
		FOREIGN KEY (
			U_ID
		)
		REFERENCES CUSTOMER (
			U_ID
		);

ALTER TABLE BULLETIN
	ADD
		CONSTRAINT FK_CUSTOMER_TO_BULLETIN
		FOREIGN KEY (
			U_ID
		)
		REFERENCES CUSTOMER (
			U_ID
		);

ALTER TABLE CART
	ADD
		CONSTRAINT PRODUCT_ID
		FOREIGN KEY (
			P_ID
		)
		REFERENCES PRODUCT (
			P_ID
		);

ALTER TABLE CART
	ADD
		CONSTRAINT FK_CUSTOMER_TO_CART
		FOREIGN KEY (
			U_ID
		)
		REFERENCES CUSTOMER (
			U_ID
		);

ALTER TABLE BUY2
	ADD
		CONSTRAINT FK_PRODUCT_TO_BUY2
		FOREIGN KEY (
			P_ID
		)
		REFERENCES PRODUCT (
			P_ID
		);

ALTER TABLE BUY2
	ADD
		CONSTRAINT FK_BUY_TO_BUY2
		FOREIGN KEY (
			O_NO
		)
		REFERENCES BUY (
			O_NO
		);

