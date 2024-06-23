import { Entry } from "fast-glob";

export async function sortFiles(files: Entry[]): Promise<Entry[]> {
	const collator = new Intl.Collator(undefined, { numeric: true, sensitivity: "base", usage: "sort" });
	const sortedFiles = [...files];

	sortedFiles.sort((a, b) => {
		const aBase = a.path.split("/").pop()?.split(".").slice(0, -1).join(".") ?? "";
		const bBase = b.path.split("/").pop()?.split(".").slice(0, -1).join(".") ?? "";

		const aParts = aBase.split(".");
		const bParts = bBase.split(".");

		const aNumber = Number(aParts[0]);
		const bNumber = Number(bParts[0]);

		if (aNumber !== bNumber) {
			return aNumber - bNumber;
		}

		return collator.compare(aBase, bBase);
	});

	return sortedFiles;
}
