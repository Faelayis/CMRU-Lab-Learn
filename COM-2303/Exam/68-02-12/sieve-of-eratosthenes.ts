export function SieveOfEratosthenes(limit: number): number[] {
	const primes = Array.from({ length: limit + 1 }, () => true);
	primes[0] = primes[1] = false;

	for (let index = 2; index * index <= limit; index++) {
		if (primes[index]) {
			for (let index_ = index * index; index_ <= limit; index_ += index) {
				primes[index_] = false;
			}
		}
	}

	const result: number[] = [];
	for (let index = 0; index <= limit; index++) {
		if (primes[index]) {
			result.push(index);
		}
	}
	return result;
}
