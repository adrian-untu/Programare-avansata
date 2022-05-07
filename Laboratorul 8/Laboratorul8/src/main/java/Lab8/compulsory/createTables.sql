DECLARE
v_count INT;
BEGIN
SELECT count(*) INTO v_count FROM user_tables WHERE table_name IN (UPPER('continents'), UPPER('countries'));
IF v_count = 0 THEN
        EXECUTE IMMEDIATE 'CREATE TABLE continents (
            id   NUMBER(10) PRIMARY KEY,
            name VARCHAR2(50) NOT NULL)';
        EXECUTE IMMEDIATE 'CREATE TABLE countries (
                                              id   NUMBER(10) PRIMARY KEY,
                                              name VARCHAR2(50)  NOT NULL,
                                              code VARCHAR2(50)  NOT NULL,
                                              id_continent NUMBER(10) NOT NULL)';
EXECUTE IMMEDIATE 'ALTER TABLE countries ADD CONSTRAINT
    fk_countries FOREIGN KEY (id_continent)
        REFERENCES continents (id) ON DELETE CASCADE';
END IF;
END;