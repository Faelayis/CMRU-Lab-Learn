export function Factorial(n: number): number {
	let result = 1;

	for (let index = 1; index <= n; index++) {
		result *= index;
	}

	return result;
}
