CREATE TABLE CUSTOMER (
       customerpoid     NUMBER NOT NULL,
       customerNumber	VARCHAR2(12) NULL,
       name             VARCHAR2(20) NULL,
       city             VARCHAR2(20) NULL,
       phonecountrycode        VARCHAR2(10),
       phoneareacode        VARCHAR2(10),
       phonenumber            VARCHAR2(10),
       CONSTRAINT PK_CUSTOMER
              PRIMARY KEY (customerpoid)
);

CREATE SEQUENCE S_CUSTOMER
    START WITH 100000
    INCREMENT BY 1
    NOMINVALUE
    NOMAXVALUE
    NOCYCLE
    CACHE 20
    NOORDER
;

--//@UNDO

DROP TABLE customer;
DROP SEQUENCE s_customer;