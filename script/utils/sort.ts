import { Entry } from "fast-glob";

export async function sortFiles(files: Entry[]): Promise<Entry[]> {
	const collator = new Intl.Collator(undefined, { numeric: true, sensitivity: "base", usage: "sort" });
	const sortedFiles = [...files];

	sortedFiles.sort((a, b) => {
		const aBase = a.path.split("/").pop()?.split(".").slice(0, -1).join(".") ?? "";
		const bBase = b.path.split("/").pop()?.split(".").slice(0, -1).join(".") ?? "";

		const aNumber = Number.parseInt(aBase, 10);
		const bNumber = Number.parseInt(bBase, 10);

		if (!Number.isNaN(aNumber) && !Number.isNaN(bNumber) && aNumber !== bNumber) {
			return aNumber - bNumber;
		}

		return collator.compare(aBase, bBase);
	});

	return sortedFiles;
}
