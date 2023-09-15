import { CommentParameter } from "../types/remove-lines.js";

export const remove = {
	lines(text: string, linesToRemove: string[], commentParameter?: CommentParameter): string {
		try {
			const lines = (commentParameter ? remove.comment(text, commentParameter) : text).split("\n"),
				filteredLines = lines.filter((line) => !linesToRemove.some((pattern) => line.includes(pattern))),
				updatedText = filteredLines.join("\n");

			return updatedText;
		} catch (err) {
			console.error(`Error linesToRemove : ${err}`);
			return text;
		}
	},
	comment(text: string, parameter?: CommentParameter): string {
		let regex: RegExp = /(?:)/;

		if (parameter?.as.one) {
			regex = /\/\/[^\n]*\n?/g;
		} else if (parameter?.as.block) {
			regex = /\/\*[\s\S]*?\*\//g;
		}

		return parameter ? text.replace(regex, "") : text;
	},
};
