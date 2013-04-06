PURGE RECYCLEBIN
/

DECLARE
CURSOR OBJ_VFPS IS
  SELECT OBJECT_NAME, object_type FROM USER_OBJECTS
    WHERE object_type IN ('FUNCTION','PROCEDURE','VIEW','SEQUENCE','PACKAGE','TRIGGER')
    and object_name not in (SELECT OBJECT_NAME FROM USER_OBJECTS WHERE OBJECT_TYPE='MATERIALIZED VIEW');

CURSOR TABLES IS
  SELECT TABLE_NAME FROM USER_TABLES
     WHERE TABLE_NAME NOT IN (SELECT QUEUE_TABLE FROM USER_QUEUE_TABLES)
     and TABLE_NAME not in (SELECT OBJECT_NAME FROM USER_OBJECTS WHERE OBJECT_TYPE='MATERIALIZED VIEW');

BEGIN
    FOR ITR IN OBJ_VFPS LOOP
     EXECUTE IMMEDIATE('DROP '||ITR.OBJECT_TYPE||' '||ITR.OBJECT_NAME);
    END LOOP;

    FOR ITR IN TABLES LOOP
     EXECUTE IMMEDIATE('DROP TABLE ' || ITR.TABLE_NAME || ' CASCADE CONSTRAINTS');
    END LOOP;

    FOR ITR IN (SELECT OBJECT_NAME FROM USER_OBJECTS WHERE OBJECT_TYPE='MATERIALIZED VIEW') LOOP
     EXECUTE IMMEDIATE('DROP MATERIALIZED VIEW '||ITR.OBJECT_NAME);
    END LOOP;

END;
/

PURGE RECYCLEBIN
/