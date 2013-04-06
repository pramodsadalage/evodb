ALTER TABLE employee ADD (CONSTRAINT chk_hired_before_termination CHECK (hiredate < terminateddate));

--//@UNDO
ALTER TABLE employee DROP CONSTRAINT chk_hired_before_termination;
