CREATE OR REPLACE VIEW CustOpenAcct
AS
SELECT
	c.customerpoid,
	c.customerNumber,
	a.openedon,
	a.accountnumber
FROM customer c , Account a
WHERE
c.customerpoid = a.customerpoid
AND a.closedon IS NULL
and a.openedon is not null
;

CREATE INDEX IDX_EMPLOYEE_FNAME ON EMPLOYEE
( firstname ASC
);

CREATE INDEX IDX_CUSTOMER_LASTNAME ON CUSTOMER
( name ASC
);

--//@UNDO

DROP INDEX IDX_EMPLOYEE_FNAME;
DROP INDEX IDX_CUSTOMER_LASTNAME;
DROP VIEW CustOpenAcct;