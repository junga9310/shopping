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


insert into Qna values('1','�̼���','1234','�����Դϴ�','����',null,0,0,0,0,0,sysdate);


commit

SELECT SYS_DATETIME; --�ý��� ���糯¥�� �ú���

SELECT writeday, to_char(writeday, 'YYYY-MM-DD HH:MI:SS AM') FROM Electronics;

 select *
 from Qna order by BOARD_NUM;
 

 
  select count(*) from Qna;
