ALTER TABLE CUSTOMER ADD TaxIdentification VARCHAR2(20);
ALTER TABLE EMPLOYEE ADD HasAccessToCustomer NUMBER(1);
UPDATE EMPLOYEE SET HasAccessToCustomer = 0;
ALTER TABLE EMPLOYEE MODIFY HasAccessToCustomer NOT NULL;
ALTER TABLE customer ADD createddate DATE;
COMMENT ON COLUMN customer.createddate IS 'Date the customer was created';
ALTER TABLE customer ADD taxlocation VARCHAR2(40);
COMMENT ON COLUMN customer.taxlocation IS 'TaxLocation code of the customer';
ALTER TABLE employee ADD terminateddate DATE;

CREATE TABLE ACCOUNTTRANSACTION (
			accounttransactionid NUMBER NOT NULL,
			accountid            NUMBER ,
			transactiondate       DATE NOT NULL,
			transactionType       VARCHAR2(12) NOT NULL,
			amount                NUMBER(25,7),
			CONSTRAINT PK_ACCOUNTTRANSACTION
				PRIMARY KEY (AccountTransactionid)
);

CREATE SEQUENCE s_accounttransaction
    START WITH 100000
    INCREMENT BY 1
    NOMINVALUE
    NOMAXVALUE
    NOCYCLE
    CACHE 20
    NOORDER
;


--//@UNDO

ALTER TABLE CUSTOMER DROP COLUMN TaxIdentification ;
ALTER TABLE EMPLOYEE DROP COLUMN HasAccessToCustomer ;
ALTER TABLE customer DROP COLUMN createddate;
ALTER TABLE customer DROP COLUMN taxlocation;
ALTER TABLE employee DROP COLUMN terminateddate;
DROP TABLE accounttransaction;
DROP SEQUENCE s_accounttransaction;
