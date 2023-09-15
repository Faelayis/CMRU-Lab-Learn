import { MeteData } from "./types/metedata.js";
import { get as utils_time } from "./utils/date-time-format.js";
import { timeZone } from "./utils/date-time-format.js";
import { get as utils_get } from "./utils/get.js";
import { readJsonFile } from "./utils/read.js";
import { remove as utils_remove } from "./utils/remove-lines.js";
import fg from "fast-glob";
import gitDate from "git-date-extractor";
import * as fs from "node:fs";

/**
 *
 * @param path metedata.json path.
 */
export default async function generatorReadme(path: string) {
	console.info("[Script]: Runs Generator README");
	console.info("[Script]: Found " + path);

	const metedata = (await readJsonFile(path)) as MeteData;

	console.info("[Script]: Config metedata.json", metedata);

	if (metedata.preview?.enable) {
		const files = await fg([`${path.split("/")[0]}/**`], {
			onlyFiles: true,
			ignore: await utils_get.gitignore(),
			objectMode: true,
			stats: true,
			followSymbolicLinks: true,
		});

		const folderDataMap = new Map();
		const filesDate = await gitDate.getStamps({ outputToFile: false, files: files.map((file) => file.path) });

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

					const fileData = await fs.readFileSync(file.path, "utf-8"),
						fileDate = filesDate[file.path],
						date = {
							created: new Date(Number(fileDate.created) * 1000),
							modified: new Date(Number(fileDate.modified) * 1000),
						};

					const header = `\`${file.name}\`<br>
					สร้าง: ${utils_time(date.created)}<br>${
						date.created.getDate() !== date.modified.getDate()
							? `\nอัปเดต: ${utils_time(date.modified)}<br>`
							: `${
									date.created.getTime() === date.modified.getTime()
										? ""
										: `\nแก้ไขล่าสุด: เวลา ${date.modified.toLocaleTimeString("th-th", { timeStyle: "short", timeZone })}<br>`
							  }`
					}
					`
						.split("\n")
						.map((line) => line.trim())
						.join("\n");

					if (metedata.preview?.remove?.enable && metedata.preview?.remove?.lineremove) {
						folderDataMap
							.get(folder)
							.push(
								header +
									"\n" +
									"```" +
									match[1] +
									" \n" +
									utils_remove.lines(fileData, metedata.preview?.remove?.lineremove, metedata.preview?.remove?.comment) +
									"\n```\n",
							);
					} else {
						folderDataMap.get(folder).push(header + "\n" + "```" + match[1] + " \n" + fileData + "\n```\n");
					}
				} catch (error) {
					console.error("[Script]: Error Reading:", error);
				}
			}
		}

		for (const [folder, markdownContent] of folderDataMap) {
			fs.writeFile(`${folder}/README.md`, markdownContent.join(""), (error) => {
				if (error) throw error;
				console.info(`[Script]: Generator ${`${folder}/README.md`} Done.`);
			});
		}
	}
}
