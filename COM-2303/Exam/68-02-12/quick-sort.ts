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
