INSERT INTO
	`student list` (id, section, name)
SELECT
	66143000,
	0,
	'Test'
WHERE
	NOT EXISTS (
		SELECT
			1
		FROM
			`student list`
		WHERE
			id = 66143000
	);
