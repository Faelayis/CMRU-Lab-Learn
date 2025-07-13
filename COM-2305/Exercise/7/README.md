`2.sql`<br>
Create: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
SHOW DATABASES;

```
`3.sql`<br>
Create: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
CREATE DATABASE myproject;

```
`4.sql`<br>
Create: 10 ก.ย. 2567 เวลา 16:55<br>
Update: 18 ก.ย. 2567 เวลา 21:12<br>
```sql
DROP DATABASE myproject;

```
`5.sql`<br>
Create: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
CREATE DATABASE myproject;

USE myproject;

```
`6.sql`<br>
Create: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
CREATE TABLE faculty (Fac_id INT(3) PRIMARY KEY, Fac_name VARCHAR(50));

SELECT
	*
FROM
	student;

SELECT
	*
FROM
	faculty;

```
`7.sql`<br>
Create: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
SHOW TABLES;

DESCRIBE student;

DESCRIBE faculty;

```
`8.sql`<br>
Create: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
DROP TABLE faculty;

SHOW TABLES;

```
`9.sql`<br>
Create: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
CREATE TABLE faculty (Fac_id INT(3) PRIMARY KEY, Fac_name VARCHAR(50), Fac_addr INT(50));

-- 9.1
ALTER TABLE faculty ADD Fac_addr INT(50);

-- 9.2
ALTER TABLE faculty MODIFY Fac_addr VARCHAR(255);

-- 9.3
ALTER TABLE faculty
DROP COLUMN Fac_addr;

```
`10.sql`<br>
Create: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
CREATE TABLE student (Student_id VARCHAR(10) PRIMARY KEY, Student_name VARCHAR(50), Student_surname VARCHAR(50), Student_tel VARCHAR(10), Fac_id INT(3), FOREIGN KEY (Fac_id) REFERENCES faculty (Fac_id));

```
`11.sql`<br>
Create: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
ALTER TABLE faculty ADD Fac_name VARCHAR(50);

```
`12.sql`<br>
Create: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
USE myproject;

SHOW TABLES;

```
`13.sql`<br>
Create: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
ALTER TABLE student ADD Friend_name VARCHAR(50);

```
`14.sql`<br>
Create: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
UPDATE student
SET
	Friend_name = 'New Friend'
WHERE
	Student_id = '123';

```
`15.sql`<br>
Create: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
UPDATE student
SET
	Friend_name = NULL
WHERE
	Student_id = '123';

```
`16.sql`<br>
Create: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
-- 16.1
SELECT
	*
FROM
	student;

-- 16.2
SELECT
	*
FROM
	faculty;

-- 16.3
SELECT
	Student_name,
	Student_surname
FROM
	student;

-- 16.4
SELECT
	Student_name,
	Fac_name
FROM
	student
	JOIN faculty ON student.Fac_id = faculty.Fac_id;

-- 16.5
SELECT
	Friend_name
FROM
	student
WHERE
	Fac_id BETWEEN 111 AND 333;

-- 16.6
SELECT
	Friend_name
FROM
	student
WHERE
	Fac_id = 123;

-- 16.7
SELECT
	Friend_name
FROM
	student
ORDER BY
	Student_id ASC;

-- 16.8
SELECT
	Friend_name
FROM
	student
ORDER BY
	Student_id DESC;

-- 16.9
SELECT
	Friend_name
FROM
	student
WHERE
	Friend_name LIKE 'ก%';

-- 16.10
SELECT
	Friend_name
FROM
	student
LIMIT
	3;

-- 16.11
SELECT
	Friend_name
FROM
	student
LIMIT
	2, 3;

```
`17.sql`<br>
Create: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
SELECT
	COUNT(Friend_name)
FROM
	student;

```
