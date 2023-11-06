import { removeFirstPath } from "../utils/string.js";

export function encodeFilePath(filePath: string) {
	return removeFirstPath(filePath).replaceAll(" ", "%20");
}
