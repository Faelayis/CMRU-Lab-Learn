import * as fs from "node:fs/promises";
import { basename, dirname, extname, join } from "node:path";

import type { Entry } from "fast-glob";

export async function ImageHeader(markdownContent: string[], folder: string): Promise<string> {
	const imagePath = `${folder}/README.png`;

	let readmeContent = markdownContent.join("");

	try {
		await fs.access(imagePath);
		readmeContent = `![Preview Image](${imagePath.replace(folder, ".")})\n\n` + readmeContent;
	} catch {
		undefined;
	}

	return readmeContent;
}

export async function ImagePreview(file: Entry, fileSystem: typeof fs) {
	const imageName = basename(file.path, extname(file.path)) + ".png",
		imagePath = join(dirname(file.path), imageName);

	let imagePreview = "";

	try {
		await fileSystem.access(imagePath);
		imagePreview = `\n![${file.name}](./${imageName})\n`;
	} catch {
		undefined;
	}

	return imagePreview;
}
