CREATE TABLE EMPLOYEE (
       employeeid  NUMBER NOT NULL,
       manageremployeeid NUMBER NULL,
       hiredate    DATE NULL,
       email        VARCHAR2(128) NULL,
       firstname   VARCHAR2(128) NULL,
       lastname    VARCHAR2(128) NULL,
       nickname    VARCHAR2(128) NULL,
       CONSTRAINT PK_EMPLOYEE
              PRIMARY KEY (employeeid)
);

CREATE SEQUENCE S_EMPLOYEE
    START WITH 100000
    INCREMENT BY 1
    NOMINVALUE
    NOMAXVALUE
    NOCYCLE
    CACHE 20
    NOORDER
;

ALTER TABLE EMPLOYEE
       ADD  ( CONSTRAINT FK_EMPLOYEE_EMPLOYEE_MGR
              FOREIGN KEY (manageremployeeid)
                             REFERENCES EMPLOYEE ) ;

--//@UNDO

ALTER TABLE EMPLOYEE
       DROP CONSTRAINT FK_EMPLOYEE_EMPLOYEE_MGR;

DROP TABLE employee;
DROP SEQUENCE s_employee;