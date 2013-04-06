ALTER TABLE customer ADD customeridentifier VARCHAR2(12);

UPDATE customer SET customeridentifier = customernumber;

--When using Transition

CREATE OR REPLACE TRIGGER T_SYNC_CUSTOMERNO_RENAME
	BEFORE INSERT OR UPDATE
	ON CUSTOMER
	REFERENCING OLD AS OLD NEW AS NEW
	FOR EACH ROW
	DECLARE
	BEGIN
		IF :NEW.customernumber IS NULL THEN
			:NEW.customernumber := :NEW.customeridentifier;
		END IF;
		IF :NEW.customeridentifier IS NULL THEN
			:NEW.customeridentifier := :NEW.customernumber;
		END IF;
	END;
/
--If No Transistion Period
ALTER TABLE customer DROP COLUMN customerNumber;


--//@UNDO

ALTER TABLE customer ADD customernumber NUMBER(10);
UPDATE customer SET customernumber = customeridentifier;
ALTER TABLE customer DROP COLUMN customeridentifier;
