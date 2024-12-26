import * as fs from "node:fs/promises";

import fg, { Entry } from "fast-glob";
import gitDate from "git-date-extractor";

import { ImageHeader, ImagePreview } from "./markdown/image.js";
import { MeteData } from "./types/metedata.js";
import { get as utils_time, timeZone } from "./utils/date-time-format.js";
import { get as utils_get } from "./utils/get.js";
import { readJsonFile } from "./utils/read.js";
import { remove as utils_remove } from "./utils/remove-lines.js";
import { sortFiles } from "./utils/sort.js";

export enum GeneratorType {
	List = "list",
	Readme = "readme",
}

/**
 * Generate README.md or list.md with a table summarizing files in folders and subfolders.
 *
 * @param path - Path to metadata.json file.
 */
export default async function generateReadme(path: string, type: GeneratorType) {
	console.info(`[Script]: Runs Generator ${type}`);

	try {
		const metedata = (await readJsonFile(path)) as MeteData;
		const files = await fg([`${path.split("/")[0]}/**/*`], {
				onlyFiles: true,
				ignore: [...utils_get.gitignore(), "**.md", "**/metedata.json"],
				objectMode: true,
				stats: true,
				followSymbolicLinks: true,
			}),
			folderDataMap = new Map<string, string[]>(),
			filesDate = await gitDate.getStamps({
				outputToFile: false,
				files: files.map((file) => file.path),
			});

		const sortedFiles = await sortFiles(files);

		for (const file of sortedFiles) {
			const match = file.path.match(/\.([^.]+)$/);

			if (match?.[1] && metedata.preview?.files?.includes(match[1] as never)) {
				const folder = file.path.replace(`/${file.name}`, "");

				if (!folderDataMap.has(folder)) {
					folderDataMap.set(folder, []);
					console.info("[Script]: Folder " + folder);
				}

				console.info("[Script]: Reading " + file.name);

				const fileDate = filesDate[file.path],
					createdTimestamp = Number(fileDate.created) * 1000,
					modifiedTimestamp = Number(fileDate.modified) * 1000,
					date = {
						created: new Date(createdTimestamp || 0),
						modified: new Date(modifiedTimestamp || 0),
					};

				if (type === GeneratorType.List || type === GeneratorType.Readme) {
					const fileData = await fs.readFile(file.path, "utf8");
					const header = formatHeader(file, date);
					const content =
						metedata.preview?.remove?.enable && (metedata.preview?.remove?.lineremove || metedata.preview?.remove?.comment)
							? utils_remove.lines(fileData, metedata.preview?.remove?.lineremove, metedata.preview?.remove?.comment)
							: fileData;

					let fileContent = `${header}\n`;

					if (type === GeneratorType.Readme) {
						fileContent += `${await ImagePreview(file, fs)}`;
					}

					fileContent += `\`\`\`${match[1]}\n${content}\n\`\`\`\n`;

					folderDataMap.get(folder)!.push(fileContent);
				}
			}
		}

		if (type === GeneratorType.List) {
			const listContent = [];

			for (const [folder, rows] of [...folderDataMap.entries()].sort()) {
				const folderHierarchy = folder.split("/").slice(1).join("/");
				listContent.push(`\n## ${folderHierarchy}\n\n${rows.join("\n")}`);
			}

			if (listContent.length > 0) {
				await fs.writeFile(`${path.split("/")[0]}/LIST.md`, listContent.sort().join("\n"));
			}
		} else if (type === GeneratorType.Readme) {
			for (const [folder, markdownContent] of folderDataMap) {
				await fs.writeFile(`${folder}/README.md`, await ImageHeader(markdownContent, folder)).then(() => {
					console.info(`[Script]: Generator ${`${folder}/README.md`} Done.`);
				});
			}
		}
	} catch (error) {
		console.error("[Script]: Error:", error);
	}
}

function formatHeader(file: Entry, date: { created: Date; modified: Date }) {
	return `\`${file.name}\`<br>
      สร้าง: ${utils_time(date.created)}<br>${
			date.created.getDate() === date.modified.getDate()
				? `${
						date.created.getTime() === date.modified.getTime()
							? ""
							: `\nแก้ไขล่าสุด: เวลา ${date.modified.toLocaleTimeString("th-th", {
									timeStyle: "short",
									timeZone,
								})}<br>\n`
					}`
				: `\nอัปเดต: ${utils_time(date.modified)}<br>`
		}`
		.split("\n")
		.map((line) => line.trim())
		.join("\n");
}
