import { fail } from '@sveltejs/kit';
import md5 from 'md5';
import { users } from '$lib/users';
import type { Actions } from './$types';

export const actions: Actions = {
	default: async ({ request }) => {
		const data = await request.formData();
		const username = data.get('username')?.toString() ?? '';
		const password = data.get('password')?.toString() ?? '';

		if (!username || !password) {
			return fail(400, { error: true, message: 'กรุณากรอก Username และ Password' });
		}

		const md5Hash = md5(password);
		const user = users.find((u) => u.username === username && u.password === md5Hash);

		if (user) {
			return {
				success: true,
				message: `Welcome to ${user.name} ${user.surname} ${user.studentId} ${user.section} Website`,
				username,
				inputPassword: password,
				inputMd5: md5Hash,
				storedMd5: user.password,
			};
		}

		return fail(401, {
			error: true,
			message: 'CAN NOT LOGIN',
			username,
			inputPassword: password,
			inputMd5: md5Hash,
		});
	},
};
