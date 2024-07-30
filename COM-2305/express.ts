import express from "express";
import path from "path";
import serveIndex from "serve-index";
import sphp from "sphp";
import ip from "ip";

const ignore = [".vscode", "node_modules", "package.json"],
	app = express(),
	path_resolve = path.resolve(__dirname, ".");

app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(sphp.express(path_resolve, { minSpareWorkers: 10, maxWorkers: 20 }));
app.use(express.static(path_resolve));
app.use(
	"/",
	serveIndex(path_resolve, {
		icons: true,
		filter: (filename) => {
			if (ignore.includes(filename)) {
				return false;
			}
			if (["md", "ts", "yaml"].includes(filename?.split(".")[1])) {
				return false;
			}
			return true;
		},
	}),
);

sphp.setOptions({ minSpareWorkers: 10, maxWorkers: 20 });

app.listen(3000, () => {
	console.log(`Server running at
   > Local:    http://localhost:3000
   > Network:  http://${ip.address()}:3000
   \n`);
});
