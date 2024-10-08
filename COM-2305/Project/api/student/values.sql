INSERT INTO
	`student` (id, section, name)
SELECT
	66143000,
	0,
	'Test'
WHERE
	NOT EXISTS (
		SELECT
			1
		FROM
			`student`
		WHERE
			id = 66143000
	);
