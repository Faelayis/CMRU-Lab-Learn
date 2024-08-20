import path from "node:path";
import { fileURLToPath } from "node:url";

import express from "express";
import ip from "ip";
import serveIndex from "serve-index";
import sphp from "sphp";

const ignore = new Set([".vscode", "node_modules", "package.json"]),
	app = express(),
	path_resolve = path.resolve(path.dirname(fileURLToPath(import.meta.url)), ".");

app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(sphp.express(path_resolve));
app.use(express.static(path_resolve));
app.use(
	"/",
	serveIndex(path_resolve, {
		icons: true,
		filter: (filename) => {
			if (ignore.has(filename)) {
				return false;
			}
			if (["md", "ts", "yaml"].includes(filename?.split(".")[1])) {
				return false;
			}
			return true;
		},
	}),
);

sphp.setOptions({
	minSpareWorkers: 10,
	maxWorkers: 20,
	preLoadScript: "./sphp/pre_load.php",
});

app.listen(3000, () => {
	console.log(`Server running at
   > Local:    http://localhost:3000
   > Network:  http://${ip.address()}:3000
   \n`);
});
