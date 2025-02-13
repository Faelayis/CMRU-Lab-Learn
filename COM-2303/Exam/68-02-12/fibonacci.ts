export function Fibonacci(n: number): number {
	let a = 0,
		b = 1,
		temporary;

	for (let index = 2; index <= n; index++) {
		temporary = a + b;
		a = b;
		b = temporary;
	}

	return b;
}
