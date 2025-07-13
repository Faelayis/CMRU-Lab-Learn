
## Exam/68-02-12

##### `bubble-sort.ts`<br>
Create: 13 ก.พ. 2568 เวลา 18:58<br>
```ts
export function BubbleSort(array: number[]): number[] {
	let n = array.length;
	let swapped;

	do {
		swapped = false;
		for (let index = 0; index < n - 1; index++) {
			if (array[index] > array[index + 1]) {
				[array[index], array[index + 1]] = [array[index + 1], array[index]];
				swapped = true;
			}
		}

		n--;
	} while (swapped);

	return array;
}

```

##### `euclids-algorithm.ts`<br>
Create: 13 ก.พ. 2568 เวลา 18:58<br>
```ts
export function EuclidsAlgorithm(a: number, b: number): number {
	while (b !== 0) {
		const temporary = b;
		b = a % b;
		a = temporary;
	}

	return a;
}

```

##### `factorial-n.ts`<br>
Create: 13 ก.พ. 2568 เวลา 18:58<br>
```ts
export function Factorial(n: number): number {
	let result = 1;

	for (let index = 1; index <= n; index++) {
		result *= index;
	}

	return result;
}

```

##### `fibonacci.ts`<br>
Create: 13 ก.พ. 2568 เวลา 18:58<br>
```ts
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

```

##### `insertion-sort.ts`<br>
Create: 13 ก.พ. 2568 เวลา 18:58<br>
```ts
export function InsertionSort(array: number[]): number[] {
	for (let index = 1; index < array.length; index++) {
		const key = array[index];
		let index_ = index - 1;
		while (index_ >= 0 && array[index_] > key) {
			array[index_ + 1] = array[index_];
			index_--;
		}
		array[index_ + 1] = key;
	}

	return array;
}

```

##### `maximum-element.ts`<br>
Create: 13 ก.พ. 2568 เวลา 18:58<br>
```ts
export function MaximumElement(array: number[]): number {
	let max = array[0];

	for (let index = 1; index < array.length; index++) {
		if (array[index] > max) {
			max = array[index];
		}
	}

	return max;
}

```

##### `merge-sort.ts`<br>
Create: 13 ก.พ. 2568 เวลา 18:58<br>
```ts
export function MergeSort(array: number[]): number[] {
	if (array.length <= 1) return array;

	const mid = Math.floor(array.length / 2);
	const left = MergeSort(array.slice(0, mid));
	const right = MergeSort(array.slice(mid));

	return merge(left, right);
}

function merge(left: number[], right: number[]): number[] {
	const result: number[] = [];
	let index = 0,
		index_ = 0;

	while (index < left.length && index_ < right.length) {
		if (left[index] < right[index_]) {
			result.push(left[index++]);
		} else {
			result.push(right[index_++]);
		}
	}

	return [...result, ...left.slice(index), ...right.slice(index_)];
}

```

##### `power-a.ts`<br>
Create: 13 ก.พ. 2568 เวลา 18:58<br>
```ts
export function Power(base: number, exponent: number): number {
	let result = 1;

	for (let index = 0; index < exponent; index++) {
		result *= base;
	}

	return result;
}

```

##### `quick-sort.ts`<br>
Create: 13 ก.พ. 2568 เวลา 18:58<br>
```ts
export function QuickSort(array: number[]): number[] {
	if (array.length <= 1) return array;
	const pivot = array[0];
	const left: number[] = [],
		right: number[] = [];

	for (let index = 1; index < array.length; index++) {
		if (array[index] < pivot) left.push(array[index]);
		else right.push(array[index]);
	}
	return [...QuickSort(left), pivot, ...QuickSort(right)];
}

```

##### `selection-sort.ts`<br>
Create: 13 ก.พ. 2568 เวลา 18:58<br>
```ts
export function SelectionSort(array: number[]): number[] {
	for (let index = 0; index < array.length - 1; index++) {
		let minIndex = index;
		for (let index_ = index + 1; index_ < array.length; index_++) {
			if (array[index_] < array[minIndex]) {
				minIndex = index_;
			}
		}
		[array[index], array[minIndex]] = [array[minIndex], array[index]];
	}
	return array;
}

```

##### `sieve-of-eratosthenes.ts`<br>
Create: 13 ก.พ. 2568 เวลา 18:58<br>
```ts
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

```

##### `test.ts`<br>
Create: 13 ก.พ. 2568 เวลา 18:58<br>
```ts
import { BubbleSort } from "./bubble-sort";
import { EuclidsAlgorithm } from "./euclids-algorithm";
import { Factorial } from "./factorial-n";
import { Fibonacci } from "./fibonacci";
import { InsertionSort } from "./insertion-sort";
import { MaximumElement } from "./maximum-element";
import { MergeSort } from "./merge-sort";
import { Power } from "./power-a";
import { QuickSort } from "./quick-sort";
import { SelectionSort } from "./selection-sort";
import { SieveOfEratosthenes } from "./sieve-of-eratosthenes";

const expectedResults = {
	power: 32,
	factorial: 120,
	findMax: 5,
	fibonacci: 13,
	gcd: 14,
	sieveOfEratosthenes: [2, 3, 5, 7, 11, 13, 17, 19, 23, 29],
	// sorted array
	selectionSort: [11, 12, 22, 25, 64],
	bubbleSort: [11, 12, 22, 25, 64],
	mergeSort: [11, 12, 22, 25, 64],
	quickSort: [11, 12, 22, 25, 64],
	insertionSort: [11, 12, 22, 25, 64],
};

let result: number | number[];

// Test Power
result = Power(2, 5);
console.log(`Power Test Passed: ${result === expectedResults.power} \n(Expected: ${expectedResults.power}, Got: ${result})\n`);

// Test Factorial
result = Factorial(5);
console.log(`Factorial Test Passed: ${result === expectedResults.factorial} \n(Expected: ${expectedResults.factorial}, Got: ${result})\n`);

// Test Maximum Element
result = MaximumElement([1, 3, 2, 5, 4]);
console.log(`Max Test Passed: ${result === expectedResults.findMax} \n(Expected: ${expectedResults.findMax}, Got: ${result})\n`);

// Test Fibonacci
result = Fibonacci(7);
console.log(`Fibonacci Test Passed: ${result === expectedResults.fibonacci} \n(Expected: ${expectedResults.fibonacci}, Got: ${result})\n`);

// Test Euclid's GCD
result = EuclidsAlgorithm(56, 98);
console.log(`GCD Test Passed: ${result === expectedResults.gcd} \n(Expected: ${expectedResults.gcd}, Got: ${result})\n`);

// Test Sieve of Eratosthenes
result = SieveOfEratosthenes(30);
console.log(
	`Sieve of Eratosthenes Test Passed: ${JSON.stringify(result) === JSON.stringify(expectedResults.sieveOfEratosthenes)} \n(Expected: ${JSON.stringify(expectedResults.sieveOfEratosthenes)}, Got: ${JSON.stringify(result)})\n`,
);

// Test Selection Sort
result = SelectionSort([64, 25, 12, 22, 11]);
console.log(
	`Selection Sort Test Passed: ${JSON.stringify(result) === JSON.stringify(expectedResults.selectionSort)} \n(Expected: ${JSON.stringify(expectedResults.selectionSort)}, Got: ${JSON.stringify(result)})\n`,
);

// Test Bubble Sort
result = BubbleSort([64, 25, 12, 22, 11]);
console.log(
	`Bubble Sort Test Passed: ${JSON.stringify(result) === JSON.stringify(expectedResults.bubbleSort)} \n(Expected: ${JSON.stringify(expectedResults.bubbleSort)}, Got: ${JSON.stringify(result)})\n`,
);

// Test Merge Sort
result = MergeSort([64, 25, 12, 22, 11]);
console.log(
	`Merge Sort Test Passed: ${JSON.stringify(result) === JSON.stringify(expectedResults.mergeSort)} \n(Expected: ${JSON.stringify(expectedResults.mergeSort)}, Got: ${JSON.stringify(result)})\n`,
);

// Test Quick Sort
result = QuickSort([64, 25, 12, 22, 11]);
console.log(
	`Quick Sort Test Passed: ${JSON.stringify(result) === JSON.stringify(expectedResults.quickSort)} \n(Expected: ${JSON.stringify(expectedResults.quickSort)}, Got: ${JSON.stringify(result)})\n`,
);

// Test Insertion Sort
result = InsertionSort([64, 25, 12, 22, 11]);
console.log(
	`Insertion Sort Test Passed: ${JSON.stringify(result) === JSON.stringify(expectedResults.insertionSort)} \n(Expected: ${JSON.stringify(expectedResults.insertionSort)}, Got: ${JSON.stringify(result)})\n`,
);

```
