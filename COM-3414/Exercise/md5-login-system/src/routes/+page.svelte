<script lang="ts">
	import type { ActionData } from './$types';

	let { form }: { form: ActionData } = $props();
</script>

<div style="padding: 20px; font-family: Arial;">
	<h1>Login</h1>

	{#if form?.success}
		<p style="color: green;"><b>{form.message}</b></p>
		<p>Username: {form.username}</p>
		<p>Password: {form.inputPassword}</p>
		<p>Input MD5: {form.inputMd5}</p>
		<p>Stored MD5: {form.storedMd5}</p>
	{:else}
		{#if form?.error}
			<p style="color: red;"><b>{form.message}</b></p>
			<p>Username: {form.username}</p>
			<p>Password: {form.inputPassword}</p>
			<p>Input MD5: {form.inputMd5}</p>
		{/if}

		<form method="POST">
			<p>
				<label for="username">Username:</label><br />
				<input type="text" id="username" name="username" required />
			</p>
			<p>
				<label for="password">Password:</label><br />
				<input type="password" id="password" name="password" required />
			</p>
			<p>
				<button type="submit">Login</button>
			</p>
		</form>
	{/if}
</div>
