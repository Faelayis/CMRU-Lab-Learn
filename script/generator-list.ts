import * as fs from "node:fs/promises";

import fg, { Entry } from "fast-glob";
import gitDate from "git-date-extractor";

import { encodeFilePath } from "./markdown/string.js";
import { MeteData } from "./types/metedata.js";
import { get as utils_time } from "./utils/date-time-format.js";
import { get as utils_get } from "./utils/get.js";
import { readJsonFile } from "./utils/read.js";

/**
 * Generate list.md with a table summarizing files in folders and subfolders.
 *
 * @param path - Path to metadata.json file.
 */
export default async function generateList(path: string) {
	console.info("[Script]: Runs Generator List");
	console.info("[Script]: Found " + path);

	try {
		const metedata = (await readJsonFile(path)) as MeteData;

		console.info(`[Script]: Config metadata.json`, metedata);

		if (metedata.preview?.list) {
			const files = await fg([`${path.split("/")[0]}/**/*`], {
					onlyFiles: true,
					ignore: utils_get.gitignore(),
					objectMode: true,
					stats: true,
					followSymbolicLinks: true,
				}),
				folderDataMap = new Map<string, string[]>(),
				filesDate = await gitDate.getStamps({
					outputToFile: false,
					files: files.map((file) => file.path),
				});

			for await (const file of files) {
				const match = file.path.match(/\.([^.]+)$/);

				if (match?.[1] && metedata.preview?.files?.includes(match[1] as never)) {
					const folder = file.path.replace(`/${file.name}`, "");

					if (!folderDataMap.has(folder)) {
						folderDataMap.set(folder, []);
						console.info("[Script]: Folder " + folder);
					}

					try {
						console.info("[Script]: Reading " + file.name);

						const fileDate = filesDate[file.path],
							date = {
								created: new Date(Number(fileDate.created) * 1000),
								modified: new Date(Number(fileDate.modified) * 1000),
							};

						const row = formatFileRow(file, date);

						folderDataMap.get(folder)!.push(row);
					} catch (error) {
						console.error("[Script]: Error Reading:", error);
					}
				}
			}

			const listContent = [];
			for (const [folder, rows] of folderDataMap) {
				const folderHierarchy = folder.split("/").slice(1).join("/");

				listContent.push(`\n## ${folderHierarchy}\n\nชื่อ | สร้าง | แก้ไข\n---| ----| ---\n${rows.join("\n")}`);
			}

			await fs.writeFile(`${path.split("/")[0]}/LIST.md`, listContent.sort().join("\n"));
		}
	} catch (error) {
		console.error("[Script]: Error:", error);
	}
}

function formatFileRow(
	file: Entry,
	date: {
		created: Date;
		modified: Date;
	},
) {
	const link = `[${file.name}](${encodeFilePath(file.path)})`,
		createdTime = utils_time(date.created),
		modifiedTime = utils_time(date.modified);

	return date.created.getTime() === date.modified.getTime() ? `${link} | ${createdTime} | - ` : `${link} | ${createdTime} | ${modifiedTime}`;
}
