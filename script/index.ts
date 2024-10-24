/* eslint-disable unicorn/prefer-top-level-await */
import fg from "fast-glob";

import generateReadme, { GeneratorType } from "./generator-readme.js";
import { MeteData } from "./types/metedata.js";
import { get as utils_get } from "./utils/get.js";
import { readJsonFile } from "./utils/read.js";

(async () => {
	const metedata = await fg(["**/metedata.json"], {
		onlyFiles: true,
		ignore: ["schema/**", "script/**", ...utils_get.gitignore()],
	});

	for (const path of metedata) {
		const metedata = (await readJsonFile(path)) as MeteData;
		console.info("[Script]: Found " + path);
		console.info(`[Script]: Config metedata.json`, metedata);

		if (!metedata.preview?.enable) return console.info(`[Script]: Preview is disabled`);

		if (metedata.complete) {
			const date = new Date(metedata.complete.split("-").reverse().join("-"));
			console.log(`[Script]: The course is complete ${date.toLocaleDateString("en-US", { timeZone: "Asia/Bangkok" })}`);
		} else {
			for (const type of Object.values(GeneratorType)) {
				await generateReadme(path, type);
			}
		}

		console.log("[Script]: Done! \n");
	}
})();
