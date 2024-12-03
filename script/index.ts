/* eslint-disable unicorn/prefer-top-level-await */
import fg from "fast-glob";

import generateReadme, { GeneratorType } from "./generator-readme.js";
import { MeteData } from "./types/metedata.js";
import { get as utils_get } from "./utils/get.js";
import { readJsonFile } from "./utils/read.js";

(async () => {
	const metedataPaths = await fg(["**/metedata.json"], {
		onlyFiles: true,
		ignore: ["schema/**", "script/**", ...utils_get.gitignore()],
	});

	for (const path of metedataPaths) {
		const metedata = (await readJsonFile(path)) as MeteData;
		console.info("[Script]: Found " + path);
		console.info(`[Script]: Config metedata.json`, metedata);

		if (!metedata.preview?.enable) {
			console.info(`[Script]: Preview is disabled`);
			continue;
		}

		// if (metedata.complete) {
		// 	const date = new Date(metedata.complete.split("-").reverse().join("-"));
		// 	console.log(`[Script]: The course is complete ${date.toLocaleDateString("en-US", { timeZone: "Asia/Bangkok" })}`);
		// } else {
		// 	await Promise.all(Object.values(GeneratorType).map((type) => generateReadme(path, type)));
		// }

		await Promise.all(Object.values(GeneratorType).map((type) => generateReadme(path, type)));
		console.log("[Script]: Done! \n");
	}
})();
