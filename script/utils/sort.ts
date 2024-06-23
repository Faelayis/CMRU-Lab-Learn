import { Entry } from "fast-glob";

export function sortFiles(files: Entry[]): Entry[] {
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

		const aDecimal = aParts[1] || "";
		const bDecimal = bParts[1] || "";

		return collator.compare(aDecimal, bDecimal);
	});

	return sortedFiles;
}
