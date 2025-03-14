/* eslint-disable typescript-sort-keys/interface */
import { FileType } from "./filetype.js";
import { CommentParameter } from "./remove-lines.ts";

export interface MeteData {
	index: number;
	$schema: string;
	coursecode: string;
	name: string;
	info?: string;
	complete?: string;
	time_formats?: {
		folder?: string;
	};
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
