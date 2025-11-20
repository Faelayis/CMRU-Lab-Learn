import * as fs from "node:fs";
import path from "node:path";

import { siArduino, siC, siDart, siFlutter, siHtml5, siJavascript, SimpleIcon, siMysql, siPhp, siPython, siTypescript, siVmware } from "simple-icons";

import type { FileType } from "../types/filetype";

const iconOutputDirectory = path.join(import.meta.dirname, "../../resources");

if (!fs.existsSync(iconOutputDirectory)) {
	fs.mkdirSync(iconOutputDirectory, { recursive: true });
}

export async function generateIcons(files: string[]): Promise<string> {
	const icons: { [key in FileType | string]: SimpleIcon | string } = {
		c: siC,
		py: siPython,
		sql: siMysql,
		php: siPhp,
		html: siHtml5,
		js: siJavascript,
		ts: siTypescript,
		ino: siArduino,
		dart: siDart,
		flutter: siFlutter,
		vmware: siVmware,
		spss: "spss.svg",
		fprg: "fprg.ico",
		java: "java.svg",
	};

	const iconHTML = await Promise.all(
		files.map(async (file) => {
			const icon = icons[file];

			if (typeof icon === "string") {
				return `<a href="#" target="_blank"><img width="20px" src="./resources/${icon}" alt="${file.toUpperCase()}"/></a>`;
			}

			if (icon) {
				const iconFileName = `${file}.svg`,
					iconFilePath = path.join(iconOutputDirectory, iconFileName);

				await saveIconToFile(icon, iconFilePath);

				return `<a href="#" target="_blank"><img width="20px" src="./resources/${iconFileName}" alt="${icon.title}"/></a>`;
			} else {
				return "";
			}
		}),
	);

	return iconHTML.join(" ");
}

async function saveIconToFile(icon: typeof siC, filePath: string): Promise<void> {
	const svgContent = icon.svg.replace("<svg", `<svg fill="#${icon.hex}"`);

	return new Promise((resolve, reject) => {
		fs.writeFile(filePath, svgContent, (error) => {
			if (error) {
				console.error(`[Script]: Error saving icon ${filePath}:`, error);
				reject(error);
			} else {
				const relativePath = path.relative(process.cwd(), filePath);
				console.log(`[Script]: Saved icon ${relativePath} Done.`);
				resolve();
			}
		});
	});
}
