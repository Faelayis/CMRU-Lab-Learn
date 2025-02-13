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
