import { FileType } from "./filetype.js";

export interface MeteData {
	coursecode: string;
	name: string;
	preview?: {
		enable: true;
		files: [FileType];
	};
}
