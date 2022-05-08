DECLARE
    v_count INT;
BEGIN
    SELECT count(*) INTO v_count FROM user_tables WHERE table_name IN (UPPER('cities'));
    IF v_count = 0 THEN
        EXECUTE IMMEDIATE 'CREATE TABLE cities (
                                                       id   NUMBER(10) PRIMARY KEY,
                                                       country_name VARCHAR2(50),
                                                       name VARCHAR2(50) NOT NULL,
                                                       capital NUMBER(1),
                                                       latitude VARCHAR2(50),
                                                       longitude VARCHAR2(50))';
    END IF;
END;