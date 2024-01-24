import * as fs from "node:fs/promises";

import fg, { Entry } from "fast-glob";
import gitDate from "git-date-extractor";

import { ImageHeader, ImagePreview } from "./markdown/image.js";
import { encodeFilePath } from "./markdown/string.js";
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
	console.info("[Script]: Found " + path);

	try {
		const metedata = (await readJsonFile(path)) as MeteData;

		console.info(`[Script]: Config metedata.json`, metedata);

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

		for await (const file of sortFiles(files)) {
			const match = file.path.match(/\.([^.]+)$/);

			if (match?.[1] && metedata.preview?.files?.includes(match[1] as never)) {
				const folder = file.path.replace(`/${file.name}`, "");

				if (!folderDataMap.has(folder)) {
					folderDataMap.set(folder, []);
					console.info("[Script]: Folder " + folder);
				}

				console.info("[Script]: Reading " + file.name);

				const fileDate = filesDate[file.path],
					date = {
						created: new Date(Number(fileDate.created) * 1000),
						modified: new Date(Number(fileDate.modified) * 1000),
					};

				if (type === GeneratorType.List) {
					const row = formatFileRow(file, date);
					folderDataMap.get(folder)!.push(row);
				} else if (type === GeneratorType.Readme) {
					const fileData = await fs.readFile(file.path, "utf8"),
						header = formatHeader(file, date),
						content =
							metedata.preview?.remove?.enable && (metedata.preview?.remove?.lineremove || metedata.preview?.remove?.comment)
								? utils_remove.lines(fileData, metedata.preview?.remove?.lineremove, metedata.preview?.remove?.comment)
								: fileData;

					folderDataMap.get(folder)!.push(`${header}\n${await ImagePreview(file, fs)}\`\`\`${match[1]}\n${content}\n\`\`\`\n`);
				}
			}
		}

		if (type === GeneratorType.List) {
			const listContent = [];

			for (const [folder, rows] of folderDataMap) {
				const folderHierarchy = folder.split("/").slice(1).join("/");
				listContent.push(`\n## ${folderHierarchy}\n\nชื่อ | สร้าง | แก้ไข\n---| ----| ---\n${rows.join("\n")}`);
			}
			await fs.writeFile(`${path.split("/")[0]}/LIST.md`, listContent.sort().join("\n"));
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

function formatFileRow(file: Entry, date: { created: Date; modified: Date }) {
	const link = `[${file.name}](${encodeFilePath(file.path)})`,
		createdTime = utils_time(date.created),
		modifiedTime = utils_time(date.modified);

	return date.created.getTime() === date.modified.getTime() ? `${link} | ${createdTime} | - ` : `${link} | ${createdTime} | ${modifiedTime}`;
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
