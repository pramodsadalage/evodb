COMMENT ON TABLE EMPLOYEE IS 'An EMPLOYEE is a person that works for the VIDEO STORE.';
COMMENT ON COLUMN EMPLOYEE.employeeid IS 'A unique number that identifies the employee.';
COMMENT ON COLUMN EMPLOYEE.firstname IS 'Employee''s name.';
COMMENT ON COLUMN EMPLOYEE.hiredate IS 'Employee''s date of hire at the video store.';
COMMENT ON COLUMN EMPLOYEE.email IS 'Email address of the employee.';

COMMENT ON TABLE CUSTOMER IS 'A CUSTOMER is a person who rents a video from the STORE.';
COMMENT ON COLUMN CUSTOMER.name IS 'The name of the customer';
COMMENT ON COLUMN CUSTOMER.CUSTOMERNUMBER IS 'Logical number for the customer';
COMMENT ON COLUMN CUSTOMER.CUSTOMERPOID IS 'Generated customer primary key';

COMMENT ON TABLE ACCOUNT IS 'A Account is a holding of currency for a customer';
COMMENT ON COLUMN ACCOUNT.ACCOUNTNUMBER IS 'Logical Number given to the Account of A Customer';
COMMENT ON COLUMN ACCOUNT.ACCOUNTID IS 'Generated PrimaryKey for a Account';
COMMENT ON COLUMN ACCOUNT.ACCOUNTTYPE IS 'Type of Account the Customer can hold, like Checking,Savings etc';
COMMENT ON COLUMN ACCOUNT.BALANCE IS 'Last Days closing balance';
COMMENT ON COLUMN ACCOUNT.CLOSEDON IS 'If not null means the account is closed and records the date it was closed';
COMMENT ON COLUMN ACCOUNT.CUSTOMERPOID IS 'Customer Primary Key to which this Account belongs';
COMMENT ON COLUMN ACCOUNT.EFFECTIVESINCE IS 'Accounts can be activated at a given date, stores the date the account can be active';
COMMENT ON COLUMN ACCOUNT.OPENEDON IS 'Date the account was opened';

CREATE TABLE Contact (
			contactid NUMBER NOT NULL,
			name      VARCHAR2(40) NOT NULL,
			email     VARCHAR2(40) NOT NULL,
			phonecountrycode VARCHAR2(10) NOT NULL,
			phoneareacode    VARCHAR2(10) NOT NULL,
			phonenumber      VARCHAR2(12) NOT NULL,
			CONSTRAINT pk_contact
				PRIMARY KEY (contactid)
);

CREATE SEQUENCE s_contact
    START WITH 100000
    INCREMENT BY 1
    NOMINVALUE
    NOMAXVALUE
    NOCYCLE
    CACHE 20
    NOORDER
;

--//@UNDO
DROP TABLE CONTACT;
DROP SEQUENCE s_contact;

