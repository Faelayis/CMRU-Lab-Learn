import { CommentParameter } from "../types/remove-lines.js";

export const remove = {
	lines(text: string, linesToRemove?: string[], commentParameter?: CommentParameter): string {
		try {
			const processedText = commentParameter ? remove.comment(text, commentParameter) : text,
				lines = processedText.split("\n"),
				linesToRemoveSet = new Set(linesToRemove),
				filteredLines = lines.filter((line) => ![...linesToRemoveSet].some((pattern) => line.includes(pattern)));
			return filteredLines.join("\n");
		} catch (error) {
			console.error("[Script]: Error Remove Lines:", error);
			return text;
		}
	},
	comment(text: string, parameter?: CommentParameter): string {
		if (!parameter) return text;

		let regex: RegExp;
		if (parameter.as.one) {
			regex = /\/\/[^\n]*\n?/g;
		} else if (parameter.as.block) {
			regex = /\/\*[\S\s]*?\*\//g;
		} else {
			regex = /(?:)/;
		}

		return text.replace(regex, "");
	},
};
