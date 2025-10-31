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

	const results = await Promise.all(
		metedataPaths.map(async (path) => {
			const metedata = (await readJsonFile(path)) as MeteData;

			console.info("[Script]: Found " + path);
			console.info(`[Script]: Config metedata.json`, metedata);

			if (!metedata.preview?.enable) {
				console.info(`[Script]: Preview is disabled`);
				return null;
			}

			// if (metedata.complete) {
			// 	const date = new Date(metedata.complete.split("-").reverse().join("-"));
			// 	console.log(`[Script]: The course is complete ${date.toLocaleDateString("en-US", { timeZone: "Asia/Bangkok" })}`);
			// } else {
			// 	await Promise.all(Object.values(GeneratorType).map((type) => generateContent(path, type)));
			// }

			await Promise.all(Object.values(GeneratorType).map((type) => generateContent(path, type)));

			return metedata;
		}),
	);

	metedataList.push(...results.filter((metedata): metedata is MeteData => metedata !== null));

	if (metedataList.length > 0) {
		await updateReadme(metedataList);
	}

	console.log("[Script]: Done!\n");
})();
