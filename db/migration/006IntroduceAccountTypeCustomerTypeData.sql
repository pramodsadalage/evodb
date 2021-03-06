CREATE TABLE ACCOUNTTYPE (
       AccountTypeID  NUMBER NOT NULL,
       Name           VARCHAR2(32) NOT NULL,
       CONSTRAINT PK_ACCOUNTTYPE
              PRIMARY KEY (AccountTypeId)
);

CREATE SEQUENCE S_ACCOUNTTYPE
    START WITH 1
    INCREMENT BY 1
    NOMINVALUE
    NOMAXVALUE
    NOCYCLE
    CACHE 20
    NOORDER
;

INSERT INTO ACCOUNTTYPE (AccountTypeID,Name) VALUES (S_ACCOUNTTYPE.NEXTVAL,'Checking');
INSERT INTO ACCOUNTTYPE (AccountTypeID,Name) VALUES (S_ACCOUNTTYPE.NEXTVAL,'Saving');
INSERT INTO ACCOUNTTYPE (AccountTypeID,Name) VALUES (S_ACCOUNTTYPE.NEXTVAL,'Money Market');
INSERT INTO ACCOUNTTYPE (AccountTypeID,Name) VALUES (S_ACCOUNTTYPE.NEXTVAL,'Mortgage');

CREATE INDEX UIDX_ACCOUNTTYPE_NAME ON ACCOUNTTYPE
( UPPER(NAME));

CREATE TABLE customertype (
       CustomerTypeID NUMBER NOT NULL,
       Name           VARCHAR2(32) NOT NULL,
       CONSTRAINT PK_CUSTOMERTYPE
              PRIMARY KEY (CustomerTypeId)
);

CREATE SEQUENCE S_CUSTOMERTYPE
    START WITH 1
    INCREMENT BY 1
    NOMINVALUE
    NOMAXVALUE
    NOCYCLE
    CACHE 20
    NOORDER
;

INSERT INTO CUSTOMERTYPE (CustomerTypeID,Name) VALUES (S_CUSTOMERTYPE.NEXTVAL,'IRA');
INSERT INTO CUSTOMERTYPE (CustomerTypeID,Name) VALUES (S_CUSTOMERTYPE.NEXTVAL,'Roth-IRA');
INSERT INTO CUSTOMERTYPE (CustomerTypeID,Name) VALUES (S_CUSTOMERTYPE.NEXTVAL,'Individual');
INSERT INTO CUSTOMERTYPE (CustomerTypeID,Name) VALUES (S_CUSTOMERTYPE.NEXTVAL,'Joint');
INSERT INTO CUSTOMERTYPE (CustomerTypeID,Name) VALUES (S_CUSTOMERTYPE.NEXTVAL,'Corporation');
ALTER TABLE employee ADD birthdate DATE;


--//@UNDO

DROP TABLE AccountType;
DROP SEQUENCE s_AccountType;

DELETE FROM ACCOUNTTYPE WHERE NAME='Checking';
DELETE FROM ACCOUNTTYPE WHERE NAME='Saving';
DELETE FROM ACCOUNTTYPE WHERE NAME='Money Market';
DELETE FROM ACCOUNTTYPE WHERE NAME='Mortgage';
DROP INDEX UIDX_ACCOUNTTYPE_NAME;

DROP TABLE CustomerType;
DROP SEQUENCE s_CustomerType;


DELETE FROM CUSTOMERTYPE WHERE NAME='IRA';
DELETE FROM CUSTOMERTYPE WHERE NAME='Roth-IRA';
DELETE FROM CUSTOMERTYPE WHERE NAME='Individual';
DELETE FROM CUSTOMERTYPE WHERE NAME='Joint';
DELETE FROM CUSTOMERTYPE WHERE NAME='Corporation';
ALTER TABLE employee DROP COLUMN birthdate;