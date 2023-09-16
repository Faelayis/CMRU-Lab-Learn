import * as fs from "node:fs/promises";

import fg from "fast-glob";
import gitDate from "git-date-extractor";

import { MeteData } from "./types/metedata.js";
import { get as utils_time, timeZone } from "./utils/date-time-format.js";
import { get as utils_get } from "./utils/get.js";
import { readJsonFile } from "./utils/read.js";
import { remove as utils_remove } from "./utils/remove-lines.js";

/**
 * Generate README.md.
 *
 * @param path - Path to metedata.json file.
 */
export default async function generateReadme(path: string) {
	console.info("[Script]: Runs Generator README");
	console.info("[Script]: Found " + path);

	try {
		const metedata = (await readJsonFile(path)) as MeteData;

		console.info(`[Script]: Config metedata.json`, metedata);

		if (metedata.preview?.enable) {
			const files = await fg([`${path.split("/")[0]}/**`], {
					onlyFiles: true,
					ignore: await utils_get.gitignore(),
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

						const fileData = await fs.readFile(file.path, "utf8"),
							fileDate = filesDate[file.path],
							date = {
								created: new Date(Number(fileDate.created) * 1000),
								modified: new Date(Number(fileDate.modified) * 1000),
							};

						const header = `\`${file.name}\`<br>
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

						if (metedata.preview?.remove?.enable && (metedata.preview?.remove?.lineremove || metedata.preview?.remove?.comment)) {
							folderDataMap
								.get(folder)!
								.push(
									`${header}\n\`\`\`${match[1]}\n${utils_remove.lines(
										fileData,
										metedata.preview?.remove?.lineremove,
										metedata.preview?.remove?.comment,
									)}\n\`\`\`\n`,
								);
						} else {
							folderDataMap.get(folder)!.push(`${header}\n\`\`\`${match[1]}\n${fileData}\n\`\`\`\n`);
						}
					} catch (error) {
						console.error("[Script]: Error Reading:", error);
					}
				}
			}

			for (const [folder, markdownContent] of folderDataMap) {
				await fs.writeFile(`${folder}/README.md`, markdownContent.join("")).then(() => {
					console.info(`[Script]: Generator ${`${folder}/README.md`} Done.`);
				});
			}
		}
	} catch (error) {
		console.error("[Script]: Error:", error);
	}
}
