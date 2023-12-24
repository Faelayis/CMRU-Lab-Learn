/* eslint-disable unicorn/prefer-top-level-await */
import fg from "fast-glob";

import generateList from "./generator-list.js";
import generatorReadme from "./generator-readme.js";
import { get as utils_get } from "./utils/get.js";

(async () => {
	const metedata = await fg(["**/metedata.json"], {
		onlyFiles: true,
		ignore: ["schema/**", "script/**", ...utils_get.gitignore()],
	});

	for (const path of metedata) {
		await generatorReadme(path);
		await generateList(path);
	}
})();
