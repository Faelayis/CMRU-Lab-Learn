/* eslint-disable unicorn/prefer-top-level-await */
import fg from "fast-glob";

import generateContent, { GeneratorType } from "./readme/content.js";
import { updateReadme } from "./readme/main.js";
import { MeteData } from "./types/metedata.js";
import { get as utils_get } from "./utils/get.js";
import { readJsonFile } from "./utils/read.js";

(async () => {
	const metedataPaths = await fg(["**/metedata.json"], {
			onlyFiles: true,
			ignore: ["schema/**", "script/**", ...utils_get.gitignore()],
		}),
		metedataList: MeteData[] = [];

	for (const path of metedataPaths) {
		const metedata = (await readJsonFile(path)) as MeteData;

		console.info("[Script]: Found " + path);
		console.info(`[Script]: Config metedata.json`, metedata);

		if (!metedata.preview?.enable) {
			console.info(`[Script]: Preview is disabled`);
			continue;
		}

		metedataList.push(metedata);

		await Promise.all(Object.values(GeneratorType).map((type) => generateContent(path, type)));
	}

	if (metedataList.length > 0) {
		await updateReadme(metedataList);
	}

	console.log("[Script]: Done!\n");
})();
