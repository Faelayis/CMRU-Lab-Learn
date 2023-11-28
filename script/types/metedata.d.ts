/* eslint-disable typescript-sort-keys/interface */
import { FileType } from "./filetype.js";
import { CommentParameter } from "./remove-lines.ts";

export interface MeteData {
	$schema: string;
	coursecode: string;
	name: string;
	complete?: string;
	preview?: {
		enable: boolean;
		files: FileType[];
		list?: boolean;
		remove?: {
			enable: boolean;
			comment?: CommentParameter;
			lineremove?: string[];
		};
	};
}
