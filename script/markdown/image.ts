import * as fs from "node:fs/promises";
import { basename, dirname, extname, join } from "node:path";

import type { Entry } from "fast-glob";

const imageExtensions = [".png", ".jpg", ".jpeg", ".gif", ".bmp", ".svg", ".webp"];

export async function ImageHeader(markdownContent: string[], folder: string): Promise<string> {
	let readmeContent = markdownContent.join("");

	for (const extension of imageExtensions) {
		const imagePath = `${folder}/README${extension}`;

		try {
			await fs.access(imagePath);
			readmeContent = `![Preview Image](${imagePath.replace(folder, ".")})\n\n` + readmeContent;
			break;
		} catch {
			undefined;
		}
	}

	return readmeContent;
}

export async function ImagePreview(file: Entry, fileSystem: typeof fs) {
	let imagePreview = "";

	for (const extension of imageExtensions) {
		const imageName = basename(file.path, extname(file.path)) + extension,
			imagePath = join(dirname(file.path), imageName);

		try {
			await fileSystem.access(imagePath);
			imagePreview = `\n![${file.name}](./${imageName})\n`;
			break;
		} catch {
			undefined;
		}
	}

	return imagePreview;
}