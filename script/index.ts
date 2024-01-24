/* eslint-disable unicorn/prefer-top-level-await */
import fg from "fast-glob";

import generateReadme, { GeneratorType } from "./generator-readme.js";
import { get as utils_get } from "./utils/get.js";

(async () => {
	const metedata = await fg(["**/metedata.json"], {
		onlyFiles: true,
		ignore: ["schema/**", "script/**", ...utils_get.gitignore()],
	});

	for (const path of metedata) {
		for (const type of Object.values(GeneratorType)) {
			await generateReadme(path, type);
		}
	}
})();
