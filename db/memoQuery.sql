CREATE TABLE memo (
	memoid Number(5),
	name VARCHAR2(30),
	age Number(3),
	CONSTRAINT pk_memo_id PRIMARY KEY (memoid)
);

CREATE SEQUENCE SEQ_MEMO_ID 
INCREMENT BY 1;

SELECT * FROM memo;
SELECT * FROM memo WHERE id=9;
SELECT * FROM memo WHERE name like '%동3%';
SELECT * FROM memo WHERE age=30;

INSERT INTO memo values (
SEQ_MEMO_ID.NEXTVAL,
'홍길동',
20);

INSERT INTO memo values (
SEQ_MEMO_ID.NEXTVAL,
'홍길동2',
15);

INSERT INTO memo values (
SEQ_MEMO_ID.NEXTVAL,
'홍길동3',
30);

INSERT INTO memo values (
SEQ_MEMO_ID.NEXTVAL,
'홍길동4',
40);

INSERT INTO memo values (
SEQ_MEMO_ID.NEXTVAL,
'홍길동5',
50);

UPDATE memo set
name='홍길동3',
memo=11
where id=5;

DELETE memo where id=2;

