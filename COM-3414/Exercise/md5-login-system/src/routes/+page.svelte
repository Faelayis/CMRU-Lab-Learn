<script lang="ts">
	import type { ActionData } from './$types';

	let { form }: { form: ActionData } = $props();
</script>

<div class="flex min-h-screen items-center justify-center bg-gray-100">
	<div class="w-full max-w-md rounded-lg bg-white p-8 shadow-lg">
		{#if form?.success}
			<div class="rounded-lg bg-green-100 p-6 text-center">
				<p class="text-lg font-semibold text-green-800">{form.message}</p>
			</div>
			<div class="mt-4 rounded-lg bg-gray-50 p-4 text-sm text-gray-700">
				<h2 class="mb-2 font-bold">Login Info</h2>
				<table class="w-full text-left">
					<tbody>
						<tr><td class="pr-2 font-medium">Username:</td><td>{form.username}</td></tr>
						<tr><td class="pr-2 font-medium">Password:</td><td>{form.inputPassword}</td></tr>
						<tr><td class="pr-2 font-medium">Input MD5:</td><td class="font-mono break-all">{form.inputMd5}</td></tr>
						<tr><td class="pr-2 font-medium">Stored MD5:</td><td class="font-mono break-all">{form.storedMd5}</td></tr>
					</tbody>
				</table>
			</div>
		{:else}
			{#if form?.error}
				<div class="mb-4 rounded-lg bg-red-100 p-4 text-center">
					<p class="font-semibold text-red-800">{form.message}</p>
				</div>
				<div class="mb-4 rounded-lg bg-gray-50 p-4 text-sm text-gray-700">
					<h2 class="mb-2 font-bold">Login Info</h2>
					<table class="w-full text-left">
						<tbody>
							<tr><td class="pr-2 font-medium">Username:</td><td>{form.username}</td></tr>
							<tr><td class="pr-2 font-medium">Password:</td><td>{form.inputPassword}</td></tr>
							<tr><td class="pr-2 font-medium">Input MD5:</td><td class="font-mono break-all">{form.inputMd5}</td></tr>
						</tbody>
					</table>
				</div>
			{/if}

			<form method="POST" class="space-y-4">
				<div>
					<label for="username" class="mb-1 block text-sm font-medium text-gray-700"> Username </label>
					<input
						type="text"
						id="username"
						name="username"
						required
						class="w-full rounded-md border border-gray-300 px-4 py-2 focus:border-orange-300 focus:ring-2 focus:ring-orange-300 focus:outline-none"
						placeholder="Enter username" />
				</div>

				<div>
					<label for="password" class="mb-1 block text-sm font-medium text-gray-700"> Password </label>
					<input
						type="password"
						id="password"
						name="password"
						required
						class="w-full rounded-md border border-gray-300 px-4 py-2 focus:border-orange-300 focus:ring-2 focus:ring-orange-300 focus:outline-none"
						placeholder="Enter password" />
				</div>

				<button type="submit" class="w-full rounded-md bg-orange-400 px-4 py-2 font-semibold text-white transition-colors hover:bg-orange-300"> Login </button>
			</form>
		{/if}
	</div>
</div>
