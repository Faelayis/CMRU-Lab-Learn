export function EuclidsAlgorithm(a: number, b: number): number {
	while (b !== 0) {
		const temporary = b;
		b = a % b;
		a = temporary;
	}

	return a;
}
