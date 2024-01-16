import { Entry } from "fast-glob";

export function sortFiles(files: Entry[]): Entry[] {
	files.sort((a, b) => {
		const aNumber = Number.parseInt(a.name, 10),
			bNumber = Number.parseInt(b.name, 10);
		return aNumber - bNumber;
	});

	return files;
}
