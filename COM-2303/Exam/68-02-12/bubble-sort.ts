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
