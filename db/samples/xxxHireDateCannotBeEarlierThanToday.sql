ALTER TABLE employee ADD (CONSTRAINT chk_hireddate_beyondtoday CHECK (trunc(hiredate)>= TO_DATE('10/04/2010','MM/DD/YYYY')));
--//@UNDO
ALTER TABLE employee DROP CONSTRAINT chk_hireddate_beyondtoday;
