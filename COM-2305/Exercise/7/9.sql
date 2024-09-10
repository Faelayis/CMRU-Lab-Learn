CREATE TABLE faculty (Fac_id INT(3) PRIMARY KEY, Fac_name VARCHAR(50), Fac_addr INT(50));

-- 9.1
ALTER TABLE faculty ADD Fac_addr INT(50);

-- 9.2
ALTER TABLE faculty MODIFY Fac_addr VARCHAR(255);

-- 9.3
ALTER TABLE faculty
DROP COLUMN Fac_addr;
