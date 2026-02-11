import md5 from 'md5';

interface User {
	username: string;
	password?: string;
	name: string;
	surname: string;
	studentId: string;
	section: string;
}

const rawUsers: User[] = [
	{
		username: 'admin',
		name: 'admin',
		surname: 'dev',
		studentId: '66143000',
		section: 'SEC.00',
	},
	{
		username: 'test',
		password: '1234',
		name: 'Test',
		surname: 'User',
		studentId: '66143000',
		section: 'SEC.00',
	},
];

export const users = rawUsers.map((u) => ({
	...u,
	password: md5(u.password ?? u.username),
}));
