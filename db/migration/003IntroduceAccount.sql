CREATE TABLE ACCOUNT (
			Accountid    NUMBER NULL,
			Customerpoid   NUMBER NOT NULL,
			AccountNumber  VARCHAR2(42) NOT NULL,
			OpenedOn       DATE DEFAULT SYSDATE,
			ClosedOn	   DATE,
			balance        NUMBER(25,2),
			EffectiveSince DATE NULL,
			AccountType    VARCHAR2(12) NOT NULL,
			CONSTRAINT PK_ACCOUNT
				PRIMARY KEY (Accountid)
);

CREATE SEQUENCE S_ACCOUNT
    START WITH 100000
    INCREMENT BY 1
    NOMINVALUE
    NOMAXVALUE
    NOCYCLE
    CACHE 20
    NOORDER
;

ALTER TABLE ACCOUNT
       ADD  ( CONSTRAINT FK_ACCOUNT_CUSTOMER
              FOREIGN KEY (customerpoid)
                             REFERENCES Customer ) ;

--//@UNDO

ALTER TABLE ACCOUNT
       DROP CONSTRAINT FK_ACCOUNT_CUSTOMER;

DROP TABLE account;
DROP SEQUENCE s_account;