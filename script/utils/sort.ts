import { Entry } from "fast-glob";

export async function sortFiles(files: Entry[]): Promise<Entry[]> {
	files.sort((a, b) => {
		const aBase = a.path.split("/").pop()?.split(".").slice(0, -1).join("."),
			bBase = b.path.split("/").pop()?.split(".").slice(0, -1).join("."),
			aParts = aBase?.split(".") || [],
			bParts = bBase?.split(".") || [],
			aNumber = Number(aParts[0]),
			bNumber = Number(bParts[0]);

		if (aNumber !== bNumber) {
			return aNumber - bNumber;
		}

		const aDecimal = aParts[1] || "",
			bDecimal = bParts[1] || "";

		return aDecimal.localeCompare(bDecimal);
	});

	return files;
}
