DECLARE
    v_count INT;
BEGIN
    SELECT count(*) INTO v_count FROM user_tables WHERE table_name IN (UPPER('users'), UPPER('friends'), UPPER('messages'));
    IF v_count = 0 THEN
        EXECUTE IMMEDIATE 'CREATE TABLE users (
                                                  username VARCHAR2(50) NOT NULL,
                                                  password VARCHAR2(50) NOT NULL)';
        EXECUTE IMMEDIATE 'CREATE TABLE friends (
                                                    user1   VARCHAR2(50) NOT NULL,
                                                    user2   VARCHAR2(50) NOT NULL)';
        EXECUTE IMMEDIATE 'CREATE TABLE messages (
                                                     user1   VARCHAR2(50) NOT NULL,
                                                     user2   VARCHAR2(50) NOT NULL,
                                                     message VARCHAR(50) NOT NULL,
                                                     timestamp VARCHAR2(100) NOT NULL)';
END IF;
END;