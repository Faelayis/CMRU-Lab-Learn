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
