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
