import { readFileSync } from "fs";

export const get = {
	gitignore(filePath?: string): string[] {
		try {
			const data = readFileSync(filePath || ".gitignore", "utf8"),
				patterns = data.split("\n").map((line) => line.trim()),
				filteredPatterns = patterns.filter((pattern) => pattern !== "" && !pattern.startsWith("#"));

			return filteredPatterns;
		} catch (err) {
			console.error(`Error reading .gitignore file: ${err}`);
			return [];
		}
	},
};
