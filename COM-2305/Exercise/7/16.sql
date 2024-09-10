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
