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
