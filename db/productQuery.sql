DROP TABLE PRODUCT;
CREATE TABLE product (
productid NUMBER(5),
productname VARCHAR2(30),
description VARCHAR2(300),
productprice NUMBER(8),
CONSTRAINT pk_product PRIMARY KEY (productid)
);

CREATE SEQUENCE SEQ_PRODUCT;

INSERT INTO PRODUCT values (
SEQ_PRODUCT.NEXTVAL,
'밥솥',
'밥을 빠르고 맛있게 지어주는 고급밥솥',
100000);

SELECT * FROM PRODUCT;
SELECT * FROM PRODUCT WHERE productid=4;

UPDATE product SET
productname='밥솥대형',
description='단체급식이 가능한 초대형 밥솥',
productprice=200000
WHERE productid=4;

DELETE product WHERE productid=4;