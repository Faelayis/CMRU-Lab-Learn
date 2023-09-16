/* eslint-disable unicorn/prefer-top-level-await */
import fg from "fast-glob";

import generatorReadme from "./generator-readme.js";
import { get as utils_get } from "./utils/get.js";

(async () => {
	const metedata = await fg(["**/metedata.json"], {
		onlyFiles: true,
		ignore: ["schema/**", "script/**", ...(await utils_get.gitignore())],
	});

	for (const path of metedata) {
		await generatorReadme(path);
	}
})();
