ALTER TABLE customer ADD phone VARCHAR2(12);
UPDATE customer SET phone=phoneareacode||phonenumber;
ALTER TABLE customer DROP COLUMN phoneareacode;
ALTER TABLE customer DROP COLUMN phonenumber;
--//@UNDO
ALTER TABLE customer ADD phoneareadcode VARCHAR2(10);
ALTER TABLE customer ADD phonenumber VARCHAR2(10);
UPDATE customer SET phoneareadcode = substr(phone,0,3);
UPDATE customer SET phonenumber = substr(phone,3,7);
ALTER TABLE customer DROP COLUMN phone;
