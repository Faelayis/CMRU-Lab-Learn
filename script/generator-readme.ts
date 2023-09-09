import { MeteData } from "./types/metedata.js";
import { get as utils_get } from "./utils/get.js";
import { readJsonFile } from "./utils/read.js";
import fg from "fast-glob";
import * as fs from "fs";

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
		});

		const folderDataMap = new Map();

		for await (const file of files) {
			const match = file.path.match(/\.([^.]+)$/);

			if (match?.[1] && metedata.preview?.files.includes(match[1] as never)) {
				const folder = file.path.replace(`/${file.name}`, "");

				if (!folderDataMap.has(folder)) {
					folderDataMap.set(folder, []);
					console.info("[Script]: Folder " + folder);
				}

				try {
					console.info("[Script]: Reading " + file.name);
					const fileData = await fs.readFileSync(file.path, "utf-8");

					folderDataMap.get(folder).push("`" + file.name + "`\n" + "```" + match[1] + " \n" + fileData + "\n```\n");
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
