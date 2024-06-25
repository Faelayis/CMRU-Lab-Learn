import express from "express";
import path from "path";
import serveIndex from "serve-index";

const ignore = [".vscode", "node_modules", "package.json"];
const app = express();

app.use(express.static(path.resolve(__dirname, ".")));
app.use(
	"/",
	serveIndex(path.resolve(__dirname, "."), {
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

app.listen(3000, () => {
	console.log("Server is running on http://localhost:3000");
});
