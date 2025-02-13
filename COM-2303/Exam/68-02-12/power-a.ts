export function Power(base: number, exponent: number): number {
	let result = 1;

	for (let index = 0; index < exponent; index++) {
		result *= base;
	}

	return result;
}
