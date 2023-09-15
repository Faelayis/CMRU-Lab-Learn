import { FileType } from "./filetype.js";
import { CommentParameter } from "./remove-lines.ts";

export interface MeteData {
	$schema: string;
	coursecode: string;
	name: string;
	preview?: {
		enable: boolean;
		files: FileType[];
		remove?: {
			enable: boolean;
			comment?: CommentParameter;
			lineremove?: string[];
		};
	};
}
