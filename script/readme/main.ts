/* eslint-disable unicorn/text-encoding-identifier-case */
import * as fs from "node:fs";
import path from "node:path";

import { MeteData } from "../types/metedata.js";
import { generateIcons } from "../utils/generate-icons.js";

const mainReadmePath = path.join(import.meta.dirname, "../../README.md");

async function generateHeader(metedataList: MeteData[]) {
	metedataList.sort((a, b) => a.index - b.index);

	const header = `|Code|Subject|Start|Folder|All Code|What's Used|\n |:---:|:---:|:---:|:---:|:---:|:---:|\n`,
		rows = await Promise.all(
			metedataList.map(async (metadata) => {
				const folderName = metadata.coursecode.replace(/-\d{2}$/, "").replaceAll(/\s+/g, "-"),
					icons = await generateIcons(metadata.preview?.files || []);

				return `| [${metadata.coursecode.split(" ")[1].replaceAll("-63", "")}](${metadata.info}) | ${metadata.name} | [⚙️](./${folderName}/README.md) | [📁](./${folderName}/) | [📑](./${folderName}/LIST.md) | ${icons} |`;
			}),
		);

	return `${header}${rows.join("\n")}`;
}

export async function updateReadme(meteData: MeteData[]): Promise<void> {
	const content = await generateHeader(meteData),
		readmeContent = fs.readFileSync(mainReadmePath, "utf8"),
		startTag = "<!-- course-start -->",
		endTag = "<!-- course-end -->",
		updatedContent = readmeContent.replaceAll(new RegExp(`${startTag}[\\s\\S]*?${endTag}`, "g"), `${startTag}\n\n${content}\n\n${endTag}`);

	return new Promise((resolve, reject) => {
		fs.writeFile(mainReadmePath, updatedContent, "utf-8", (error) => {
			if (error) {
				console.error("[Script]: Error writing to README.md:", error);
				reject(error);
			} else {
				console.log("[Script]: Successfully updated README.md Done.");
				resolve();
			}
		});
	});
}
